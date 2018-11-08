DROP TABLE IF EXISTS authors_books;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS rewards;
DROP TABLE IF EXISTS authors;

CREATE SCHEMA IF NOT EXISTS qrok DEFAULT CHARACTER SET utf8;
USE qrok;
CREATE TABLE books(

  id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title varchar(100),
  isbn varchar(255),
  genre varchar(100))
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE authors(

  id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(255),
  sex VARCHAR(100),
  birth_date DATE)

  DEFAULT CHARACTER SET = utf8;

CREATE TABLE rewards(

  id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  author_id INT(10),
  year INT(20),
  title VARCHAR(255),
  FOREIGN KEY (author_id) REFERENCES authors (id))
  DEFAULT CHARACTER SET = utf8;



CREATE TABLE authors_books(

  author_id INT(10) NOT NULL,
  book_id INT(10) NOT NULL,
  FOREIGN KEY (author_id) REFERENCES authors (id),
  FOREIGN KEY (book_id) REFERENCES books (id))
  DEFAULT CHARACTER SET = utf8;




