package com.QROKproject.dao;

import com.QROKproject.model.Book;
import com.QROKproject.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CRUDBookRepository extends JpaRepository<Book, Integer> {

    @Transactional
    @Override
    Book save(Book book);

    Book findById(int book_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Book b WHERE b.id=:id")
    int delete(@Param("id") int id);

    List<Book> findBooksByGenre(Genre genre);

    List<Book> findAll();

    int countById(int book_id);
}
