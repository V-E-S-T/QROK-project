package com.QROKproject.dao;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.model.Reward;

import java.util.List;

public interface AuthorRepository {

    Author save(Author author);

    boolean delete(int author_id);

    Author get(int author_id);

    List<Author> getAll();

    List<Book> listBooks(int author_id);

    List<Reward> listRewards(int author_id);

    boolean isExist(int author_id);

}
