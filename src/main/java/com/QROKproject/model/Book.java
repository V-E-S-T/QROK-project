package com.QROKproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Size(max = 100)
    @Column(name = "isbn")
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @JsonBackReference
    @ManyToMany(mappedBy = "bookList", fetch = FetchType.LAZY)
    private List<Author> authorList = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String isbn, Genre genre) {
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        if (getIsbn() != null ? !getIsbn().equals(book.getIsbn()) : book.getIsbn() != null) return false;
        if (getGenre() != book.getGenre()) return false;
        return getAuthorList() != null ? getAuthorList().equals(book.getAuthorList()) : book.getAuthorList() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getIsbn() != null ? getIsbn().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre=" + genre +
                ", authorList=" + authorList +
                '}';
    }
}
