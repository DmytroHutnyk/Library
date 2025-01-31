package hutnyk.library.Controller;

import hutnyk.library.Security.RegistrationService;
import hutnyk.library.Security.UserValidator;
import hutnyk.library.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController{

    private final UserValidator userValidator;
    private final RegistrationService registrationService;

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registrationReader")
    public String registrationPage(@ModelAttribute("user") User user){
        return "auth/registrationReader";
    }

    @PostMapping("/registrationReader")
    public String registration(@Valid @ModelAttribute("user")User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "auth/registrationReader";
        }
        registrationService.registerReader(user);
        return "redirect:/auth/login";
    }


    @GetMapping("/registrationPublisher")
    public String registrationPagePublisher(@ModelAttribute("user") User user){
        return "auth/registrationPublisher";
    }

    @PostMapping("/registrationPublisher")
    public String registrationPublisher(@Valid @ModelAttribute("user")User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "auth/registrationPublisher";
        }
        registrationService.registerPublisher(user);
        return "redirect:/auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/auth/login";
    }
}



