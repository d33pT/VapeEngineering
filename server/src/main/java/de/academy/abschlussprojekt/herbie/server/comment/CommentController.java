package de.academy.abschlussprojekt.herbie.server.comment;

import de.academy.abschlussprojekt.herbie.server.post.Post;
import de.academy.abschlussprojekt.herbie.server.post.PostDTO;
import de.academy.abschlussprojekt.herbie.server.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class CommentController {

   @Autowired
   CommentRepository commentRepository;

//   @Autowired
//    PostRepository postrepository;

    @GetMapping("/api/forum")
    public List<CommentDTO> lesen(){
        List<CommentDTO> comment = new LinkedList<>();

        for (Comment comments : commentRepository.findAllByOrderByCreationDateDesc()) {
            comment.add(new CommentDTO(comments.getTitle(), comments.getText()));
        }

        return comment;
    }

}
