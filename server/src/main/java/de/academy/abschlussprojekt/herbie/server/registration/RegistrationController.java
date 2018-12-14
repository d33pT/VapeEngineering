package de.academy.abschlussprojekt.herbie.server.registration;

import de.academy.abschlussprojekt.herbie.server.exceptions.EmailExistsException;
import de.academy.abschlussprojekt.herbie.server.security.SecurityService;
import de.academy.abschlussprojekt.herbie.server.user.User;
import de.academy.abschlussprojekt.herbie.server.user.UserDTO;
import de.academy.abschlussprojekt.herbie.server.user.UserService;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class RegistrationController {

    @Autowired
    private SecurityService service;

    @Autowired
    private UserService userService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model, WebRequest webRequest) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDTO accountDto,
                                            BindingResult result, WebRequest request, Errors errors) {

        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }

        return null;
    }

    private User createUserAccount(UserDTO accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }


    @Target({TYPE, FIELD, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Constraint(validatedBy = EmailValidator.class)
    @Documented
    public @interface ValidEmail {
        String message() default "Invalid email";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    @Target({TYPE, ANNOTATION_TYPE})
    public @interface PasswordMatches {
        String message() default "Passwords don't match";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }


}
