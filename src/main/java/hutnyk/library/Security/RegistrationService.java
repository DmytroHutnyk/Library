package hutnyk.library.Security;

import hutnyk.library.Service.Interface.IRoleService;
import hutnyk.library.Service.Interface.IUserService;
import hutnyk.library.model.Role;
import hutnyk.library.model.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final IUserService userService;
    private final IRoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public void registerReader(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleService.getRoleByName("READER").orElseThrow(
                () -> new EntityNotFoundException("Role does not exists with name: ROLE_READER")
        );
        user.getRoles().add(role);
        user.setIsEnable(true);

        userService.saveUser(user);
    }

    public void registerPublisher(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleService.getRoleByName("PUBLISHER").orElseThrow(
                () -> new EntityNotFoundException("Role does not exists with name: ROLE_READER")
        );
        user.getRoles().add(role);
        user.setIsEnable(true);

        userService.saveUser(user);
    }
}
