package hutnyk.library.Service;

import hutnyk.library.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    void saveUser(User user);
}
