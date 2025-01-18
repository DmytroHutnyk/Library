package hutnyk.library.repository;

import hutnyk.library.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByName(String name);
}
