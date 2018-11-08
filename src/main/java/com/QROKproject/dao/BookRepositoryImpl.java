package com.QROKproject.dao;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @Autowired
    private CRUDBookRepository bookRepository;

    @Override
    public Book create(String title, String isbn, Genre genre) {

        Book newBook = new Book(title, isbn, genre);
        return bookRepository.save(newBook);
    }

    @Override
    public Book save(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public boolean delete(int book_id) {
        return bookRepository.delete(book_id) != 0;
    }

    @Override
    public Book get(int book_id) {
        return bookRepository.findById(book_id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Author> listAuthors(int book_id) {
        return bookRepository.findById(book_id).getAuthorList();
    }

    @Override
    public boolean isExist(int book_id) {
        return bookRepository.countById(book_id) > 0;
    }
}
