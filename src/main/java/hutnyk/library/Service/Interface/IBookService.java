package hutnyk.library.Service.Interface;

import hutnyk.library.model.Author;
import hutnyk.library.model.Book;
import hutnyk.library.model.DTO.BookDTO;
import hutnyk.library.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getAllBooks();
    void deleteById(Long id);
    Optional<Book> findById(Long id);
    BookDTO convertToDTO(Book book);
    void updateBook(BookDTO bookDTO, Author author, Publisher publisher);
}
