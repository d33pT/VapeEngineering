package de.academy.abschlussprojekt.herbie.server.comment;

import de.academy.abschlussprojekt.herbie.server.post.Post;
import de.academy.abschlussprojekt.herbie.server.post.PostDTO;
import de.academy.abschlussprojekt.herbie.server.post.PostRepository;
import de.academy.abschlussprojekt.herbie.server.security.SecurityService;
import de.academy.abschlussprojekt.herbie.server.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    SecurityService securityService;


   @Autowired
    PostRepository postrepository;


    @PostMapping("addComment")
    public void addComment(@RequestBody CommentDTO commentDTO) {
        User user = securityService.getCurrentUser().get();
        Post post = postrepository.findById(commentDTO.getPostId()).get();
        Comment comment = new Comment();
        comment.setTitle(commentDTO.getTitle());
        comment.setText(commentDTO.getText());
        comment.setUser(user);
        post.addComment(comment);
        postrepository.save(post);

    }


}