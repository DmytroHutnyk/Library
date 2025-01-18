package hutnyk.library.Security;

import hutnyk.library.Service.IUserService;
import hutnyk.library.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Getter
@Setter
@RequiredArgsConstructor
@Component
public class UserValidator implements Validator {
    private IUserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(userService.findByUsername(user.getUsername()).isEmpty())
            errors.rejectValue("username", "", "User with such username already exists");


        if(userService.findByEmail(user.getEmail()).isEmpty())
            errors.rejectValue("email", "", "User with such email already exists");
    }
}
