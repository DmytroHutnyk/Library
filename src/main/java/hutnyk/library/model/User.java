package hutnyk.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username can not be empty")
    @Column(nullable = false)
    @Size(min = 4)
    private String username;

    @NotBlank(message = "Email can not be empty")
    @Column(nullable = false)
    @Email(message = "This is not an email")
    private String email;

    @NotBlank(message = "Password can not be empty")
    @Column(nullable = false)
    @Size(min = 4)
    private String password;

    @Column(nullable = false)
    private Boolean isEnable;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
