INSERT INTO role (name, description) VALUES ('READER', 'Default role for readers');
INSERT INTO role (name, description) VALUES ('PUBLISHER', 'Role for publishers');
INSERT INTO role (name, description) VALUES ('LIBRARIAN', 'Role for librarians');
INSERT INTO role (name, description) VALUES ('ADMIN', 'Role for administrators');


INSERT INTO users (username, email, password, is_enable) VALUES ('user1', 'reader@example.com', '$2a$10$hjGxvkN0w.TCcjcFNQNiGOtBZlBaSwwkvcBgbvhgUWLLcxfz8oplS', true);
INSERT INTO users (username, email, password, is_enable) VALUES ('user2', 'publisher@example.com', '$2a$10$88uhV4Gcc6oErp.hQfXuJumNeLmEjAY9GK5z8ERgF9fDFk8G.KlCS', true);
INSERT INTO users (username, email, password, is_enable) VALUES ('user3', 'librarian@example.com', '$2a$10$zInLivtLP/C1VXF9OuRtCu6qXxF3mkpzQtdt9xJ21Bde.rXBPym.6', true);
INSERT INTO users (username, email, password, is_enable) VALUES ('admin', 'admin@example.com', '$2a$10$GvwN4b9roOCbRod7uUS9XuCv2VQugY.bpD0AHTEYTDUBJEo6HdBaa', true);
INSERT INTO users (username, email, password, is_enable) VALUES ('user0', 'unreg@example.com', '$2a$10$Hx/Ty7KBNAP8vwmzZDiAPey3Xqly.OHt4El1TydfRoXnI5sMnP9i6', true);


INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO user_role (user_id, role_id) VALUES (4, 4);



INSERT INTO author (first_name, last_name) VALUES ('John', 'Doe');
INSERT INTO author (first_name, last_name) VALUES ('Jane', 'Smith');

INSERT INTO publisher (publisher_name, address, country) VALUES ('Penguin Books', '123 Penguin Road', 'USA');
INSERT INTO publisher (publisher_name, address, country) VALUES ('HarperCollins', '456 Harper Street', 'UK');

INSERT INTO genre (genre_name) VALUES ('Fiction');
INSERT INTO genre (genre_name) VALUES ('Science Fiction');
INSERT INTO genre (genre_name) VALUES ('Fantasy');
INSERT INTO genre (genre_name) VALUES ('Non-Fiction');

INSERT INTO book (title, isbn, publication_year, author_id, publisher_id)
VALUES ('The Great Adventure', '1234567890123', 2021, 1, 1);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id)
VALUES ('The Science of Tomorrow', '9876543210987', 2020, 2, 2);

INSERT INTO book_genre (book_id, genre_id) VALUES (1, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (2, 2);
