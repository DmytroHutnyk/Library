package hutnyk.library.model.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private Integer publicationYear;
    private String authorFirstName;
    private String authorLastName;
    private String publisherName;

}