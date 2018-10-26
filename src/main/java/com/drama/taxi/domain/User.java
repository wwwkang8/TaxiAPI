package com.drama.taxi.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String password;
    private String userType;

    @OneToMany(mappedBy = "user")
    private List<Booking> booking;

    public User() {
    }

    public User(String userEmail, String password, String userType) {
        this.userEmail = userEmail;
        this.password = password;
        this.userType = userType;
    }

    public boolean matchId(String newUserEmail) {
        if (newUserEmail == null) {
            return false;
        }

        return userEmail.equals(newUserEmail);
    }

    public boolean matchPassword(String newPassword) {
        if (newPassword == null) {
            return false;
        }

        return password.equals(newPassword);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
