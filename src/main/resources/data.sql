INSERT INTO BOOK (ID, CREATED_DATE, PUBLISH_DATE, AUTHOR, DESCRIPTION, NAME) VALUES
('67a111a5-3fd8-4b86-9caf-67957644050a', '2025-04-11 16:19:43.88', '1813-01-12 07:00:00', 'Jane Austen ', 'FICTION', 'BOOK1'),
('2f8123aa-1e87-4a68-8982-a366a5c1bfc8', '2025-04-11 16:19:43.88', '1955-04-11 00:00:00', 'J.R.R Tolkien', 'FICTION', 'BOOK2'),
('73de39e3-5852-4148-8879-fbe170f4f8de', '2025-04-11 16:20:43.88', '1998-09-01 00:00:00', 'J.K Rowling', 'FICTION', 'BOOK3'),
('17cd3665-1145-4ae5-92c4-3370df7c6bee', '2025-04-11 16:21:43.88', '1995-10-14 00:00:00', 'J.D. Salinger', 'LEGEND', 'BOOK4'),
('fd037bfb-fe50-4c19-986d-0f27e1c8662e', '2025-04-11 16:22:43.88', '1988-12-15 00:00:00', 'George Orwell', 'FICTION', 'BOOK5'),
('922a87c8-fe63-4602-8473-48262791d673', '2025-04-11 16:23:43.88', '1974-01-22 00:00:00', ' Aldous Huxley', 'FICTION', 'BOOK6'),
('2032519e-44fb-4f0f-a7b5-54425587e865', '2025-04-11 16:24:43.88', '1851-04-10 00:00:00', 'Herman Melville', 'FICTION', 'BOOK7'),
('04575dae-93de-4cf1-b3d4-14c987e8f4fc', '2025-04-11 16:25:43.88', '1925-06-30 00:00:00', 'F. Scott Fitzgerald', 'FICTION', 'BOOK8'),
('122e41dd-9451-4a6a-ac85-7b875e3387ff', '2025-04-11 16:26:43.88', '1947-06-29 00:00:00', 'Leo Tolstoy', 'NOVEL', 'BOOK9'),
('16d8d993-0686-4a81-8c6d-429b16a0361d', '2025-04-11 16:27:43.88', '1960-05-30 00:00:00', 'Harper Lee', 'NOVEL', 'BOOK10');

-- INSERT INTO BOOK (ID, CREATED_DATE, PUBLISH_DATE, AUTHOR, DESCRIPTION, NAME) VALUES
-- ('67a111a5-3fd8-4b86-9caf-67957644050a', '2025-04-11 16:19:43.88', '1813-01-12 07:00:00', 'Jane Austen ', 'FICTION', 'Pride and Prejudice'),
-- ('2f8123aa-1e87-4a68-8982-a366a5c1bfc8', '2025-04-11 16:19:43.88', '1955-04-11 00:00:00', 'J.R.R Tolkien', 'FICTION', 'The Lord of the Rings'),
-- ('73de39e3-5852-4148-8879-fbe170f4f8de', '2025-04-11 16:20:43.88', '1998-09-01 00:00:00', 'J.K Rowling', 'FICTION', 'Harry Potter'),
-- ('17cd3665-1145-4ae5-92c4-3370df7c6bee', '2025-04-11 16:21:43.88', '1995-10-14 00:00:00', 'J.D. Salinger', 'LEGEND', 'The Odyssey '),
-- ('fd037bfb-fe50-4c19-986d-0f27e1c8662e', '2025-04-11 16:22:43.88', '1988-12-15 00:00:00', 'George Orwell', 'FICTION', 'The Republic'),
-- ('922a87c8-fe63-4602-8473-48262791d673', '2025-04-11 16:23:43.88', '1974-01-22 00:00:00', ' Aldous Huxley', 'FICTION', 'Frankenstein'),
-- ('2032519e-44fb-4f0f-a7b5-54425587e865', '2025-04-11 16:24:43.88', '1851-04-10 00:00:00', 'Herman Melville', 'FICTION', 'Moby Dick'),
-- ('04575dae-93de-4cf1-b3d4-14c987e8f4fc', '2025-04-11 16:25:43.88', '1925-06-30 00:00:00', 'F. Scott Fitzgerald', 'FICTION', 'The Great Gatsby'),
-- ('122e41dd-9451-4a6a-ac85-7b875e3387ff', '2025-04-11 16:26:43.88', '1947-06-29 00:00:00', 'Leo Tolstoy', 'NOVEL', 'Brave New World'),
-- ('16d8d993-0686-4a81-8c6d-429b16a0361d', '2025-04-11 16:27:43.88', '1960-05-30 00:00:00', 'Harper Lee', 'NOVEL', 'To Kill a Mockinbird');



-- PAGE 1 -> 0
-- ROW 5 -> 5
--
-- PAGE 2 -> 5
-- ROW 5 -> 5
--
-- PAGE 3 -> 10
-- ROW 5 -> 5
--
-- page: (row*page)-row
-- row: row
