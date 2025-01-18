package hutnyk.library.model.DTO;

import hutnyk.library.model.Role;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Boolean isEnable;
    private Set<Role> roles;
}
