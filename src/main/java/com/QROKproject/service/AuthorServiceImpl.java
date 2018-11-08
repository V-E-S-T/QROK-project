package com.QROKproject.service;

import com.QROKproject.dao.AuthorRepository;
import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.model.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author update(Author author, int id) {

        Assert.isTrue(authorRepository.isExist(id), "Author with this ID does not exist");
        Assert.notNull(author, "Can not save empty author parameter");
        Assert.notNull(author.getFirstName(), "Can not save empty FirstName parameter");
        Assert.notNull(author.getLastName(), "Can not save empty LastName parameter");
        Assert.notNull(author.getBirthDate(), "Can not save empty BirthDate parameter");
        Assert.notNull(author.getSex(), "Can not save empty Sex parameter");

        return authorRepository.save(author);
    }

    @Override
    public Author save(Author author) {

        Assert.notNull(author, "Can not save empty author parameter");
        Assert.notNull(author.getFirstName(), "Can not save empty FirstName parameter");
        Assert.notNull(author.getLastName(), "Can not save empty LastName parameter");
        Assert.notNull(author.getBirthDate(), "Can not save empty BirthDate parameter");
        Assert.notNull(author.getSex(), "Can not save empty Sex parameter");
        return authorRepository.save(author);
    }

    @Override
    public boolean delete(int author_id) {

        Assert.isTrue(authorRepository.isExist(author_id), "Author with this ID does not exist");
        return authorRepository.delete(author_id);
    }

    @Override
    public Author get(int author_id) {

        Assert.isTrue(authorRepository.isExist(author_id), "Author with this ID does not exist");
        return authorRepository.get(author_id);
    }

    @Override
    public List<Author> getAll() {

        return authorRepository.getAll();
    }

    @Override
    public List<Book> listBooks(int author_id) {

        Assert.isTrue(authorRepository.isExist(author_id), "Author with this ID does not exist");
        return authorRepository.listBooks(author_id);
    }

    @Override
    public List<Reward> listRewards(int author_id) {

        Assert.isTrue(authorRepository.isExist(author_id), "Author with this ID does not exist");
        return authorRepository.listRewards(author_id);
    }
}
