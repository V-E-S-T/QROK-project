insert into books (title, isbn, genre) values
  ('title_1', 'isbn_1', 'DETECTIVE'),
  ('title_2', 'isbn_2', 'DETECTIVE'),
  ('title_3', 'isbn_3', 'FANTASTIC'),
  ('title_4', 'isbn_4', 'FANTASTIC'),
  ('title_5', 'isbn_5', 'NOVEL'),
  ('title_6', 'isbn_6', 'NOVEL'),
  ('title_7', 'isbn_7', 'FANTASY'),
  ('title_8', 'isbn_8', 'FANTASY');

insert into authors (first_name, last_name, sex, birth_date) values
  ('firstName_1', 'lastName_1', 'MALE', '1986-08-01'),
  ('firstName_2', 'lastName_2', 'FEMALE', '1976-09-02'),
  ('firstName_3', 'lastName_3', 'FEMALE', '1966-01-03'),
  ('firstName_4', 'lastName_4', 'MALE', '1956-02-04'),
  ('firstName_51', 'lastName_51', 'FEMALE', '1946-03-05'),
  ('firstName_61', 'lastName_61', 'FEMALE', '1936-04-06'),
  ('firstName_17', 'lastName_17', 'MALE', '1926-05-07');

insert into rewards (year, title, author_id) values
  (2005, 'title_1', 1),
  (2005, 'title_1', 4),
  (2005, 'title_1', 5),
  (2000, 'title_2', 2),
  (2000, 'title_2', 3),
  (2000, 'title_2', 1),
  (2002, 'title_3', 2),
  (2002, 'title_3', 3);

insert into authors_books (author_id, book_id) values
  (1, 5),
  (1, 3),
  (2, 4),
  (3, 4),
  (4, 5),
  (4, 4),
  (5, 5),
  (6, 1),
  (7, 2),
  (7, 6),
  (2, 7),
  (7, 8);