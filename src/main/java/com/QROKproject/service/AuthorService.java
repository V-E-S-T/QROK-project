package com.QROKproject.service;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.model.Reward;

import java.util.List;

public interface AuthorService {

    Author update(Author author, int id);

    Author save(Author author);

    boolean delete(int author_id);

    Author get(int author_id);

    List<Author> getAll();

    List<Book> listBooks(int author_id);

    List<Reward> listRewards(int author_id);

}
