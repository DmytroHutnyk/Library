package hutnyk.library.repository;

import hutnyk.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Long> {
}
