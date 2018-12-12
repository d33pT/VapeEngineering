package de.academy.abschlussprojekt.herbie.server.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/api/forum")
    public List<PostDTO> lesen(){
        List<PostDTO> beitraege = new LinkedList<>();

        for (Post post : postRepository.findAllByOrderByCreationDateDesc()) {
            beitraege.add(new PostDTO(post.getTitle(), post.getText()));
        }

        return beitraege;
    }

    @PostMapping("/api/forum")      //RequestBody enthält Anfrage vom Frontend und wandelt sie in Java um
    public List<PostDTO> schreiben(@RequestBody PostDTO postDTO) { // und diese Methode speichert es in DB
        postRepository.save(new Post(postDTO.getTitle(), postDTO.getText())); // und schickt per return
        return lesen();                                             // lesen zum Frontend zurück
    }

    @PostConstruct
    public void dummyData() {
        if (postRepository.count() == 0) {
            postRepository.save(new Post("Geiles Stück", "Ich mag Strings!"));
        }
    }


}
