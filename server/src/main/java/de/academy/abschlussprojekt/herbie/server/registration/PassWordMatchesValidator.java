package de.academy.abschlussprojekt.herbie.server.registration;

import de.academy.abschlussprojekt.herbie.server.user.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PassWordMatchesValidator implements ConstraintValidator<RegistrationController.PasswordMatches, Object> {

    @Override
    public void initialize(RegistrationController.PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

        UserDTO userDTO = (UserDTO) object;
        return userDTO.getPassword().equals(userDTO.getMatchingPassword());
    }

}
