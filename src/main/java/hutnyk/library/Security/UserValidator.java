package hutnyk.library.Security;

import hutnyk.library.Service.Interface.IUserService;
import hutnyk.library.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class UserValidator implements Validator {
    private final IUserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(userService.findByUsername(user.getUsername()).isPresent())
            errors.rejectValue("username", "", "User with such username already exists");


        if(userService.findByEmail(user.getEmail()).isPresent())
            errors.rejectValue("email", "", "User with such email already exists");
    }
}
