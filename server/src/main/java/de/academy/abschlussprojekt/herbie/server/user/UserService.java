package de.academy.abschlussprojekt.herbie.server.user;

import de.academy.abschlussprojekt.herbie.server.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDTO accountDTO) throws EmailExistsException{

        if (emailExist(accountDTO.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address: "
                            + accountDTO.getEmail());
        }

        User user = new User();
        user.setUsername(accountDTO.getUsername());
        user.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        user.setEmail(accountDTO.getEmail());
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return true;
        }
        return false;
    }
}
