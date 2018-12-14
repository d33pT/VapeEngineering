package de.academy.abschlussprojekt.herbie.server.security;

import de.academy.abschlussprojekt.herbie.server.user.User;
import de.academy.abschlussprojekt.herbie.server.user.UserDTO;
import de.academy.abschlussprojekt.herbie.server.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof SecurityUserDetails) {
            return userRepository.findByUsername(((SecurityUserDetails) principal).getUsername());
        }
        return Optional.empty();
    }

//    public User registerNewUserAccount(UserDTO userDTO) {
//
//        User user = new User();
//        user.setUsername(userDTO.getUsername());
//
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//
//        user.setEmail(userDTO.getEmail());
//
//        return userRepository.save(user);
//    }
}
