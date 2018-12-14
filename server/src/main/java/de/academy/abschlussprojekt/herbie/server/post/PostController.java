package de.academy.abschlussprojekt.herbie.server.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
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
            beitraege.add(new PostDTO(post.getTitle(), post.getText(), post.getUser(), post.getCreationDate()));
        }

        return beitraege;
    }

   /** RequestBody enthält Anfrage vom Frontend und wandelt sie in Java um. Die nachfolgende Methode speichert es
    *  in DB und schickt per return 'lesen' zum Frontend zurück**/

    @PostMapping("/api/forum")
    public List<PostDTO> schreiben(@RequestBody PostDTO postDTO) {
        postRepository.save(new Post(postDTO.getTitle(), postDTO.getText(), postDTO.getUser(), postDTO.getCreationDate()));
        return lesen();
    }

    @PostConstruct
    public void dummyData() {
        if (postRepository.count() == 0) {
            postRepository.save(new Post("Geiles Stück", "Ich mag Strings!"));
            postRepository.save(new Post("Juhu!", "Schöne neue Welt"));
        }
    }


}
