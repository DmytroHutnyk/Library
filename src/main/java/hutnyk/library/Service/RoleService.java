package hutnyk.library.Service;

import hutnyk.library.Service.Interface.IRoleService;
import hutnyk.library.model.Role;
import hutnyk.library.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    public Optional<Role> getRoleByName(String name){
        return roleRepository.getRoleByName(name);
    }
}
