package hutnyk.library.Service;

import hutnyk.library.Service.Interface.IAuthorService;
import hutnyk.library.model.Author;
import hutnyk.library.repository.IAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;

    public Optional<Author> findByNameAndLastname(String name, String lastname){
        return authorRepository.findByFirstNameAndLastName(name, lastname);
    }
    public Author save(Author author){
        return authorRepository.save(author);
    }
}
