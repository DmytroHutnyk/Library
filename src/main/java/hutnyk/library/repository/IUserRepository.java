package hutnyk.library.repository;

import hutnyk.library.model.Role;
import hutnyk.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByUsername (String username);
    Optional<User> getUserByEmail(String email);
}
