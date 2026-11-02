
package com.athletics.athletics_management.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coach_athlete_links", uniqueConstraints = {
        @UniqueConstraint(name = "uk_coach_athlete", columnNames = { "coach_id", "athlete_id" })
})
public class CoachAthlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "coach_id", nullable = false)
    private User coach;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "athlete_id", nullable = false)
    private User athlete;

    @Column(nullable = false, length = 20)
    private String status = "PENDING";

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt = LocalDateTime.now();

    @Column(name = "responded_at")
    private LocalDateTime respondedAt;

    public CoachAthlete() {
    }

    public Long getId() {
        return id;
    }

    public User getCoach() {
        return coach;
    }

    public void setCoach(User coach) {
        this.coach = coach;
    }

    public User getAthlete() {
        return athlete;
    }

    public void setAthlete(User athlete) {
        this.athlete = athlete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public LocalDateTime getRespondedAt() {
        return respondedAt;
    }

    public void setRespondedAt(LocalDateTime respondedAt) {
        this.respondedAt = respondedAt;
    }
}
