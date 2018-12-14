package de.academy.abschlussprojekt.herbie.server.user;

import de.academy.abschlussprojekt.herbie.server.exceptions.EmailExistsException;

public interface IUserService {
    User registerNewUserAccount(UserDTO accountDTO)
            throws EmailExistsException;
}
