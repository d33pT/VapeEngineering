package de.academy.abschlussprojekt.herbie.server.comment;

import de.academy.abschlussprojekt.herbie.server.user.User;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table (name = "comments" )
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    @Lob
    private String text;

    private String title;

    @ManyToOne
    private User user;

    private Instant creationDate;



    public Comment(String text, String title, User user, Instant creationDate) {
        this.text = text;
        this.title = title;
        this.user = user;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
