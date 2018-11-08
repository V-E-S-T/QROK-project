package com.QROKproject.dao;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.model.Genre;

import java.util.List;

public interface BookRepository {

    Book create(String title, String isbn, Genre genre);

    Book save(Book book);

    boolean delete(int book_id);

    Book get(int book_id);

    List<Book> getAll();

    List<Author> listAuthors(int book_id);

    boolean isExist(int book_id);
}
