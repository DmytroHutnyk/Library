package hutnyk.library.Controller;

import hutnyk.library.Service.Interface.IAuthorService;
import hutnyk.library.Service.Interface.IBookService;
import hutnyk.library.Service.Interface.IPublisherService;
import hutnyk.library.Service.Interface.IUserService;
import hutnyk.library.model.Author;
import hutnyk.library.model.Book;
import hutnyk.library.model.DTO.BookDTO;
import hutnyk.library.model.Publisher;
import hutnyk.library.repository.IBookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class AppController {

    private final IBookService bookService;
    private final IAuthorService authorService;
    private final IPublisherService publisherService;
    private final IBookRepository bookRepository;
    private final IUserService userService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute( "books", bookService.getAllBooks());
        return "index";
    }
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/menu")
    public String menu(Model model){
        model.addAttribute( "books", bookService.getAllBooks());
        return "app/menu";
    }

    @GetMapping("/menu/add")
    public String addBook(Model model){
        model.addAttribute("book", new BookDTO());
        return "app/addBook";
    }


    @PostMapping("/menu/add/save-book")
    public String saveBook(@ModelAttribute("book") BookDTO bookDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "app/addBook";
        }

        Author author = authorService.findByNameAndLastname(
                bookDTO.getAuthorFirstName(),
                bookDTO.getAuthorLastName()
        ).orElseGet(() -> {
            Author newAuthor = new Author();
            newAuthor.setFirstName(bookDTO.getAuthorFirstName());
            newAuthor.setLastName(bookDTO.getAuthorLastName());
            return authorService.save(newAuthor);
        });

        Publisher publisher = publisherService.findByName(
                bookDTO.getPublisherName()
        ).orElseGet(() -> {
            Publisher newPublisher = new Publisher();
            newPublisher.setPublisherName(bookDTO.getPublisherName());
            return publisherService.save(newPublisher);
        });

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setAuthor(author);
        book.setPublisher(publisher);

        bookRepository.save(book);

        return "redirect:/menu";
    }

    @DeleteMapping("/menu/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/menu";
    }

    @GetMapping("/menu/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        BookDTO bookDTO = bookService.findById(id)
                .map(book -> bookService.convertToDTO(book))
                .orElseThrow(() -> new EntityNotFoundException("Book with ID " + id + " not found."));

        model.addAttribute("book", bookDTO);
        return "app/editBook";
    }

    @PostMapping("/menu/edit/save")
    public String updateBook(@ModelAttribute("book") BookDTO bookDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "app/editBook";
        }

        Author author = authorService.findByNameAndLastname(
                bookDTO.getAuthorFirstName(),
                bookDTO.getAuthorLastName()
        ).orElseGet(() -> {
            Author newAuthor = new Author();
            newAuthor.setFirstName(bookDTO.getAuthorFirstName());
            newAuthor.setLastName(bookDTO.getAuthorLastName());
            return authorService.save(newAuthor);
        });

        Publisher publisher = publisherService.findByName(
                bookDTO.getPublisherName()
        ).orElseGet(() -> {
            Publisher newPublisher = new Publisher();
            newPublisher.setPublisherName(bookDTO.getPublisherName());
            return publisherService.save(newPublisher);
        });

        bookService.updateBook(bookDTO, author, publisher);

        return "redirect:/menu";
    }



    @GetMapping("/menu/admin/panel")
    public String adminPanel(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "app/adminPanel";
    }

    @PostMapping("/menu/admin/add-role")
    public String addRoleToUser(@RequestParam String username, @RequestParam String role) {
        userService.addRoleToUser(username, role);
        return "redirect:/menu/admin/panel";
    }

    @PostMapping("/menu/admin/remove-role")
    public String removeRoleFromUser(@RequestParam String username, @RequestParam String role) {
        userService.removeRoleFromUser(username, role);
        return "redirect:/menu/admin/panel";
    }

}
