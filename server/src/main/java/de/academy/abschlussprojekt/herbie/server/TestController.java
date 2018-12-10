package de.academy.abschlussprojekt.herbie.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    SecurityService securityService;

    @GetMapping("/api/test")
    public HashMap<String, String> test() {
        Optional<User> optionalUser = securityService.getCurrentUser();

        HashMap<String, String> ret = new HashMap<>();
        if (optionalUser.isPresent()) {
            ret.put("hello", optionalUser.get().getUsername());
        }
        else {
            ret.put("hello", "world");
        }
        return ret;
    }
}
