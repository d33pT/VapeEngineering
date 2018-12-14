package de.academy.abschlussprojekt.herbie.server.post;

import de.academy.abschlussprojekt.herbie.server.comment.Comment;
import de.academy.abschlussprojekt.herbie.server.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany
    private List<Comment> comments;

    @Lob
    private String text;

    @ManyToOne
    private User user;

    private String creationDate;

    public Post() {
        this.creationDate = formatDateTime(LocalDateTime.now());
        this.comments = new ArrayList<>();
    }

    public Post(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.creationDate = formatDateTime(LocalDateTime.now());
        this.comments = new ArrayList<>();
        this.user = user;
    }


    private static String formatDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return localDateTime.format(formatter);

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
