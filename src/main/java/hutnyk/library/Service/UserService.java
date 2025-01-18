package hutnyk.library.Service;

import hutnyk.library.Security.CustomUserDetails;
import hutnyk.library.model.User;
import hutnyk.library.repository.IUserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class UserService implements IUserService, UserDetailsService {

    private IUserRepository userRepository;

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

}
