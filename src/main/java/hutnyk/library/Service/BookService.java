package hutnyk.library.Service;

import hutnyk.library.Service.Interface.IBookService;
import hutnyk.library.model.Author;
import hutnyk.library.model.Book;
import hutnyk.library.model.DTO.BookDTO;
import hutnyk.library.model.Publisher;
import hutnyk.library.repository.IBookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book with ID " + id + " not found.");
        }
        bookRepository.deleteById(id);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public BookDTO convertToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setIsbn(book.getIsbn());
        dto.setPublicationYear(book.getPublicationYear());
        dto.setAuthorFirstName(book.getAuthor().getFirstName());
        dto.setAuthorLastName(book.getAuthor().getLastName());
        dto.setPublisherName(book.getPublisher().getPublisherName());
        return dto;
    }

    public void updateBook(BookDTO bookDTO, Author author, Publisher publisher) {
        Book book = bookRepository.findById(bookDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Book with ID " + bookDTO.getId() + " not found."));
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setAuthor(author);
        book.setPublisher(publisher);
        bookRepository.save(book);
    }
}
