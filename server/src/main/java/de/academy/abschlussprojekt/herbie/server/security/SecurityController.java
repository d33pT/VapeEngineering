package de.academy.abschlussprojekt.herbie.server.security;

import de.academy.abschlussprojekt.herbie.server.user.User;
import de.academy.abschlussprojekt.herbie.server.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("/api/currentUser")
    public UserDTO currentUser() {
        Optional<User> optionalUser = this.securityService.getCurrentUser();
        if (optionalUser.isPresent()) {
            return new UserDTO(optionalUser.get().getUsername());
        }
        return null;
    }
}
