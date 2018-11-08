package com.QROKproject.dao;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.model.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository{

    @Autowired
    private CRUDAuthorRepository authorRepository;

    @Override
    public Author save(Author author){

        author.getRewardList().forEach(reward -> reward.setAuthor(author));

        return authorRepository.save(author);
    }

    @Override
    public boolean delete(int author_id){

        return authorRepository.deleteById(author_id) > 0;
    }

    @Override
    public Author get(int author_id){

        return authorRepository.findById(author_id);
    }

    @Override
    public List<Author> getAll(){

        return authorRepository.findAll();
    }

    @Override
    public List<Book> listBooks(int author_id) {

        return get(author_id).getBookList();
    }

    @Override
    public List<Reward> listRewards(int author_id) {

        return authorRepository.findById(author_id).getRewardList();
    }

    @Override
    public boolean isExist(int author_id) {

        return authorRepository.countById(author_id) > 0;
    }
}
