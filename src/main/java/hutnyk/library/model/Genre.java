package hutnyk.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Genre name can not be blank")
    @Column(nullable = false)
    private String genreName;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books = new LinkedHashSet<>();
}


