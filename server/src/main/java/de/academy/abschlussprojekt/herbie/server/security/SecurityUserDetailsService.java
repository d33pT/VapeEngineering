package de.academy.abschlussprojekt.herbie.server.security;

import de.academy.abschlussprojekt.herbie.server.user.User;
import de.academy.abschlussprojekt.herbie.server.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            return new SecurityUserDetails(optionalUser.get());
        }
        throw new UsernameNotFoundException("Nutzer nicht gefunden");
    }
}
