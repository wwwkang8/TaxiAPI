package com.drama.taxi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private String passenger;
    private String status="배차대기";
    private String driver;
    private LocalDateTime createDate;
    private LocalDateTime assignedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Booking(String destination, String passenger, String status, String driver, LocalDateTime createDate, LocalDateTime assignedDate, User user) {
        this.destination = destination;
        this.passenger = passenger;
        this.status = status;
        this.driver = driver;
        this.createDate = createDate;
        this.assignedDate = assignedDate;
        this.user = user;
    }


    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCreateDate() {
        if (createDate == null) {
            return "";
        }
        return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getAssignedDate() {

        if (assignedDate == null) {
            return "";
        }
        return assignedDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

    }

    public void setAssignedDate(LocalDateTime assignedDate) {
        this.assignedDate = assignedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", passenger='" + passenger + '\'' +
                ", status='" + status + '\'' +
                ", driver='" + driver + '\'' +
                ", createDate=" + createDate +
                ", assignedDate=" + assignedDate +
                ", user=" + user +
                '}';
    }
}
