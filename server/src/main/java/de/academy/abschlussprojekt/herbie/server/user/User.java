package de.academy.abschlussprojekt.herbie.server.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;

    private boolean isAdmin;

    public User() {
    }

    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public User(String username, String password) {
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public long getId() {
        return Id;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
