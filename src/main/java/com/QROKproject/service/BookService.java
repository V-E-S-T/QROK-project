package com.QROKproject.service;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;

import java.util.List;

public interface BookService {

    Book update(Book book, int id);

    Book save(Book book);

    boolean delete(int book_id);

    Book get(int book_id);

    List<Book> getAll();

    List<Author> listAuthors(int book_id);
}
