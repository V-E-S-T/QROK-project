package com.QROKproject.dao;

import com.QROKproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CRUDAuthorRepository extends JpaRepository<Author, Integer>{

    @Transactional
    @Override
    Author save(Author author);

    Author findById(int author_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Author a WHERE a.id=:id")
    int deleteById(@Param("id") int id);

    @Override
    List<Author> findAll();

    int countById(int author_id);

}
