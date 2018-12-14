package de.academy.abschlussprojekt.herbie.server.user;

import de.academy.abschlussprojekt.herbie.server.registration.RegistrationController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RegistrationController.PasswordMatches
public class UserDTO {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @RegistrationController.ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    public UserDTO() {
    }

    public UserDTO(String username) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
