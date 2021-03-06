package de.academy.abschlussprojekt.herbie.server.post;

import de.academy.abschlussprojekt.herbie.server.security.SecurityService;
import de.academy.abschlussprojekt.herbie.server.user.User;
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

    @Autowired
    private SecurityService securityService;

    @GetMapping("/api/forum")
    public List<PostDTO> lesen(){
        List<PostDTO> beitraege = new LinkedList<>();

        for (Post post : postRepository.findAllByOrderByCreationDateDesc()) {
            beitraege.add(new PostDTO(post.getTitle(), post.getText()));
        }

        return beitraege;
    }

   /** RequestBody enthält Anfrage vom Frontend und wandelt sie in Java um. Die nachfolgende Methode speichert es
    *  in DB und schickt per return 'lesen' zum Frontend zurück**/

    @PostMapping("/api/forum")
    public List<PostDTO> schreiben(@RequestBody PostDTO postDTO) {
        User user = securityService.getCurrentUser().get();
        postRepository.save(new Post(postDTO.getTitle(), postDTO.getText(), user));
        return lesen();
    }

    @PostConstruct
    public void dummyData() {
        if (postRepository.count() == 0) {
            User user = new User("Test", "test","test@email.de");
            postRepository.save(new Post("Geiles Stück", "Ich mag Strings!", user));
            postRepository.save(new Post("Juhu!", "Schöne neue Welt", user));
        }
    }


}
