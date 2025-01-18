package hutnyk.library.repository;

import hutnyk.library.model.Genre;
import hutnyk.library.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublisherRepository extends JpaRepository<Publisher, Long> {
}
