
package com.athletics.athletics_management.repository;

import com.athletics.athletics_management.entity.CoachAthlete;
import com.athletics.athletics_management.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoachAthleteRepository
        extends JpaRepository<CoachAthlete, Long> {

    List<CoachAthlete> findByAthleteOrderByRequestedAtDesc(User athlete);

    List<CoachAthlete> findByCoachOrderByRequestedAtDesc(User coach);

    List<CoachAthlete> findByCoachAndStatusOrderByRequestedAtDesc(
            User coach, String status);

    Optional<CoachAthlete> findByCoachAndAthlete(
            User coach, User athlete);

    boolean existsByCoachAndAthleteAndStatus(
            User coach, User athlete, String status);
}
