package com.QROKproject.dto;

import com.QROKproject.model.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDTO {

    private String firstName;
    private String lastName;
    private int age;
    private List<String> listBook;
    private String authorInfo;

    public AuthorDTO(Author author) {

        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();

        LocalDate currentDate = LocalDate.now();
        this.age = currentDate.getYear() - author.getBirthDate().getYear();
        this.listBook = author.getBookList().stream().map(book -> book.getTitle()).collect(Collectors.toList());
        this.authorInfo = getAuthorInfo();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<String> getListBook() {
        return listBook;
    }

    public String getAuthorInfo(){

        StringBuilder resultString = new StringBuilder();

        resultString.append("Author First Name: ").append(getFirstName())
                .append("Author Last Name: ").append(getLastName())
                .append("Author Age: ").append(getAge())
                .append("Author Books: ").append("\n");
        getListBook().forEach(book -> resultString.append(book).append("\n"));

        return resultString.toString();
    }
}
