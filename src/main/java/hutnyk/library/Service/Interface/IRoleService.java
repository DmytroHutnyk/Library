package hutnyk.library.Service.Interface;

import hutnyk.library.model.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> getRoleByName(String name);
}
