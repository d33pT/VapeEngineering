package de.academy.abschlussprojekt.herbie.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof SecurityUserDetails) {
            return userRepository.findByUsername(((SecurityUserDetails) principal).getUsername());
        }
        return Optional.empty();
    }
}
