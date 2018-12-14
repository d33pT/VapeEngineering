package de.academy.abschlussprojekt.herbie.server.comment;

public class CommentDTO {

    private String title;

    private String text;


    private Long postId;


    public CommentDTO() {
    }

    public CommentDTO(String title, String text, Long postId) {
        this.title = title;
        this.text = text;
         this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
}


