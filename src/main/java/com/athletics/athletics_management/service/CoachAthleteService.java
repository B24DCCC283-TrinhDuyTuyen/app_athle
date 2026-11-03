
package com.athletics.athletics_management.service;

import com.athletics.athletics_management.entity.CoachAthlete;
import com.athletics.athletics_management.entity.Role;
import com.athletics.athletics_management.entity.User;
import com.athletics.athletics_management.repository.CoachAthleteRepository;
import com.athletics.athletics_management.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CoachAthleteService {

    private final CoachAthleteRepository coachAthleteRepository;
    private final UserRepository userRepository;

    public CoachAthleteService(
            CoachAthleteRepository coachAthleteRepository,
            UserRepository userRepository) {
        this.coachAthleteRepository = coachAthleteRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> getAllCoaches() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole() == Role.COACH)
                .filter(User::isEnabled)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<CoachAthlete> getRequestsForAthlete(String username) {
        User athlete = getUserByUsername(username);
        requireRole(athlete, Role.ATHLETE);

        return coachAthleteRepository
                .findByAthleteOrderByRequestedAtDesc(athlete);
    }

    @Transactional(readOnly = true)
    public List<CoachAthlete> getRequestsForCoach(String username) {
        User coach = getUserByUsername(username);
        requireRole(coach, Role.COACH);

        return coachAthleteRepository
                .findByCoachOrderByRequestedAtDesc(coach);
    }

    @Transactional(readOnly = true)
    public List<CoachAthlete> getLinkedAthletesForCoach(String username) {
        User coach = getUserByUsername(username);
        requireRole(coach, Role.COACH);

        return coachAthleteRepository
                .findByCoachAndStatusOrderByRequestedAtDesc(coach, "ACCEPTED");
    }

    @Transactional(readOnly = true)
    public List<CoachAthlete> getLinkedCoachesForAthlete(String username) {
        User athlete = getUserByUsername(username);
        requireRole(athlete, Role.ATHLETE);

        return coachAthleteRepository
                .findByAthleteOrderByRequestedAtDesc(athlete)
                .stream()
                .filter(link -> "ACCEPTED".equals(link.getStatus()))
                .toList();
    }

    @Transactional
    public void sendRequest(String athleteUsername, Long coachId) {
        User athlete = getUserByUsername(athleteUsername);
        requireRole(athlete, Role.ATHLETE);

        User coach = userRepository.findById(coachId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy HLV."));

        requireRole(coach, Role.COACH);

        if (!coach.isEnabled()) {
            throw new IllegalArgumentException(
                    "Tài khoản HLV hiện không hoạt động.");
        }

        var existing = coachAthleteRepository
                .findByCoachAndAthlete(coach, athlete);

        if (existing.isPresent()) {
            CoachAthlete link = existing.get();

            if ("PENDING".equals(link.getStatus())) {
                throw new IllegalArgumentException(
                        "Bạn đã gửi yêu cầu đến HLV này.");
            }

            if ("ACCEPTED".equals(link.getStatus())) {
                throw new IllegalArgumentException(
                        "Bạn đã liên kết với HLV này.");
            }

            link.setStatus("PENDING");
            link.setRequestedAt(LocalDateTime.now());
            link.setRespondedAt(null);
            coachAthleteRepository.save(link);
            return;
        }

        CoachAthlete link = new CoachAthlete();
        link.setCoach(coach);
        link.setAthlete(athlete);
        link.setStatus("PENDING");
        link.setRequestedAt(LocalDateTime.now());

        coachAthleteRepository.save(link);
    }

    @Transactional
    public void respondToRequest(
            String coachUsername, Long requestId, boolean accept) {

        User coach = getUserByUsername(coachUsername);
        requireRole(coach, Role.COACH);

        CoachAthlete link = coachAthleteRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Không tìm thấy yêu cầu liên kết."));

        if (!link.getCoach().getId().equals(coach.getId())) {
            throw new IllegalArgumentException(
                    "Bạn không có quyền xử lý yêu cầu này.");
        }

        if (!"PENDING".equals(link.getStatus())) {
            throw new IllegalArgumentException(
                    "Yêu cầu này đã được xử lý.");
        }

        if (accept) {
            link.setStatus("ACCEPTED");
        } else {
            link.setStatus("REJECTED");
        }

        link.setRespondedAt(LocalDateTime.now());
        coachAthleteRepository.save(link);
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Không tìm thấy tài khoản."));
    }

    private void requireRole(User user, Role expectedRole) {
        if (user.getRole() != expectedRole) {
            throw new IllegalArgumentException(
                    "Bạn không có quyền thực hiện thao tác này.");
        }
    }
}
