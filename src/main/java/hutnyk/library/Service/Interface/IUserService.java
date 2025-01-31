package hutnyk.library.Service.Interface;

import hutnyk.library.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    void saveUser(User user);
    List<User> findAllUsers();
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
}
