package com.QROKproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rewards")
public class Reward implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "year")
    private int year;

    @Column(name = "title")
    private String title;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Reward() {
    }

    public Reward(int year, String title, Author author) {
        this.year = year;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reward)) return false;

        Reward reward = (Reward) o;

        if (getId() != reward.getId()) return false;
        if (getYear() != reward.getYear()) return false;
        if (getTitle() != null ? !getTitle().equals(reward.getTitle()) : reward.getTitle() != null) return false;
        return author != null ? author.equals(reward.author) : reward.author == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getYear();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
