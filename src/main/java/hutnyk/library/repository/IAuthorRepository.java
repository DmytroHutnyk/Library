package hutnyk.library.repository;

import hutnyk.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository  extends JpaRepository<Author, Long> {
}
