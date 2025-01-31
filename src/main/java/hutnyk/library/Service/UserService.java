package hutnyk.library.Service;

import hutnyk.library.Security.CustomUserDetails;
import hutnyk.library.Service.Interface.IUserService;
import hutnyk.library.model.Role;
import hutnyk.library.model.User;
import hutnyk.library.repository.IRoleRepository;
import hutnyk.library.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService, UserDetailsService {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User does not exsist with username: " + username));
        return new CustomUserDetails(user);
    }


    public Optional<User> findByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.getUserByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + username));
        Role role = roleRepository.getRoleByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role not found: " + roleName));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public void removeRoleFromUser(String username, String roleName) {
        User user = userRepository.getUserByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + username));
        Role role = roleRepository.getRoleByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role not found: " + roleName));
        user.getRoles().remove(role);
        userRepository.save(user);
    }

}
