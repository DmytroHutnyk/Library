package hutnyk.library.Service.Interface;

import hutnyk.library.model.Author;

import java.util.Optional;

public interface IAuthorService {
    Optional<Author> findByNameAndLastname(String name, String lastname);
    Author save(Author author);
}
