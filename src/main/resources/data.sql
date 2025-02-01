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
INSERT INTO author (first_name, last_name) VALUES ('Isaac', 'Asimov');
INSERT INTO author (first_name, last_name) VALUES ('J.R.R.', 'Tolkien');
INSERT INTO author (first_name, last_name) VALUES ('Agatha', 'Christie');
INSERT INTO author (first_name, last_name) VALUES ('George', 'Orwell');
INSERT INTO author (first_name, last_name) VALUES ('J.K.', 'Rowling');

INSERT INTO publisher (publisher_name, address, country) VALUES ('Scholastic', '789 Scholastic Ave', 'USA');
INSERT INTO publisher (publisher_name, address, country) VALUES ('Macmillan Publishers', '159 Macmillan Blvd', 'UK');
INSERT INTO publisher (publisher_name, address, country) VALUES ('Random House', '753 Random Street', 'Germany');
INSERT INTO publisher (publisher_name, address, country) VALUES ('Hachette Book Group', '951 Hachette Lane', 'France');
INSERT INTO publisher (publisher_name, address, country) VALUES ('Simon & Schuster', '852 Simon Road', 'USA');
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

INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Foundation', '1111111111111', 1951, 3, 3);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Hobbit', '2222222222222', 1937, 4, 4);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Murder on the Orient Express', '3333333333333', 1934, 5, 5);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('1984', '4444444444444', 1949, 6, 6);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Harry Potter and the Sorcerer''s Stone', '5555555555555', 1997, 7, 7);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Two Towers', '6666666666666', 1954, 4, 4);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Return of the King', '7777777777777', 1955, 4, 4);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Animal Farm', '8888888888888', 1945, 6, 6);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Harry Potter and the Chamber of Secrets', '9999999999999', 1998, 7, 7);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Foundation and Empire', '1010101010101', 1952, 3, 3);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Second Foundation', '1212121212121', 1953, 3, 3);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Silmarillion', '1313131313131', 1977, 4, 4);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Murder of Roger Ackroyd', '1414141414141', 1926, 5, 5);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('And Then There Were None', '1515151515151', 1939, 5, 5);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Brave New World', '1616161616161', 1932, 6, 6);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Caves of Steel', '1717171717171', 1954, 3, 3);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Moon is a Harsh Mistress', '1818181818181', 1966, 3, 3);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('Fantastic Beasts and Where to Find Them', '1919191919191', 2001, 7, 7);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('The Casual Vacancy', '2020202020202', 2012, 7, 7);
INSERT INTO book (title, isbn, publication_year, author_id, publisher_id) VALUES ('I, Robot', '2121212121212', 1950, 3, 3);

INSERT INTO book_genre (book_id, genre_id) VALUES (1, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (2, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES (3, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES (4, 3);
INSERT INTO book_genre (book_id, genre_id) VALUES (5, 4);
INSERT INTO book_genre (book_id, genre_id) VALUES (6, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (7, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (8, 4);
INSERT INTO book_genre (book_id, genre_id) VALUES (9, 3);
INSERT INTO book_genre (book_id, genre_id) VALUES (10, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES (11, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES (12, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (13, 4);
INSERT INTO book_genre (book_id, genre_id) VALUES (14, 4);
INSERT INTO book_genre (book_id, genre_id) VALUES (15, 3);
INSERT INTO book_genre (book_id, genre_id) VALUES (16, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES (17, 2);
INSERT INTO book_genre (book_id, genre_id) VALUES (18, 3);
INSERT INTO book_genre (book_id, genre_id) VALUES (19, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (20, 1);
INSERT INTO book_genre (book_id, genre_id) VALUES (21, 2);
