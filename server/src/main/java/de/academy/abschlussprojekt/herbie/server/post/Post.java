package de.academy.abschlussprojekt.herbie.server.post;

import de.academy.abschlussprojekt.herbie.server.user.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String title;

    @Lob
    private String text;

    @ManyToOne
    private User user;

    private Instant creationDate;

    public Post() {
    }

    public Post(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.creationDate = Instant.now();
    }

    public long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public Instant getCreationDate() {
        return creationDate;
    }
}
