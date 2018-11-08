package com.QROKproject.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author  implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(max = 100)
    @Column(name = "last_name")
    private String lastName;

    //@NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "authors_books", joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> bookList = new ArrayList<>();

    @PrePersist
    public void addBooks() {
        bookList.forEach(book -> book.getAuthorList().add(this));
    }

    @PreRemove
    public void removeBooks() {
        bookList.forEach(book -> book.getAuthorList().remove(this));
    }

    @NotNull
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private List<Reward> rewardList = new ArrayList<>();

    public Author() {
    }

    public Author(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.sex = author.getSex();
        this.birthDate = author.getBirthDate();
        this.bookList = author.getBookList();
        this.rewardList = author.getRewardList();
    }

    public Author(String firstName, String lastName, Sex sex, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Reward> getRewardList() {
        return rewardList;
    }

    public void setRewardList(List<Reward> rewardList) {
        this.rewardList = rewardList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (getFirstName() != null ? !getFirstName().equals(author.getFirstName()) : author.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(author.getLastName()) : author.getLastName() != null)
            return false;
        if (getSex() != author.getSex()) return false;
        if (getBookList() != null ? !getBookList().equals(author.getBookList()) : author.getBookList() != null)
            return false;
        if (getBirthDate() != null ? !getBirthDate().equals(author.getBirthDate()) : author.getBirthDate() != null)
            return false;
        return getRewardList() != null ? getRewardList().equals(author.getRewardList()) : author.getRewardList() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", bookList=" + bookList +
                ", birthDate=" + birthDate +
                ", rewardList=" + rewardList +
                '}';
    }
}
