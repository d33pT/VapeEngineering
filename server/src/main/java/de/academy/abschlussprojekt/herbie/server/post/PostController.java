package de.academy.abschlussprojekt.herbie.server.post;

import de.academy.abschlussprojekt.herbie.server.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/api/test")
    public List<PostDTO> lesen(){
        List<PostDTO> beitraege = new ArrayList<>();

        for (Post post : postRepository.findAllByOrOrderByCreationDateCreationDateDesc()) {
            beitraege.add(new PostDTO(post.getTitle(), post.getText()));
        }

        return beitraege;
    }


}
