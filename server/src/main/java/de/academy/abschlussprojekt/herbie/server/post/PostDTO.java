package de.academy.abschlussprojekt.herbie.server.post;

import de.academy.abschlussprojekt.herbie.server.user.User;

import java.time.Instant;

public class PostDTO {

    private String title;

    private String text;

    private User user;
    private Instant creationDate;


    public PostDTO() {
    }

    public PostDTO(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public PostDTO(String title, String text, User user, Instant creationDate) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.creationDate = Instant.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }
}
