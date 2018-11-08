package com.QROKproject.controller;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookRESTController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll(){

        return bookService.getAll();
    }

    @PostMapping(value = "/book/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book create(@RequestBody Book book){

        bookService.save(book);

        return book;
    }

    @PostMapping(value = "/book/{id}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book update(@RequestBody Book book, @PathVariable("id") int id){

        return bookService.update(book, id);
    }

    @DeleteMapping(value = "/book/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){

        bookService.delete(id);
    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book get(@PathVariable("id") int id){

        return bookService.get(id);
    }

    @GetMapping(value = "/book/{id}/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Author> getListAuthors(@PathVariable("id") int id){

        return bookService.listAuthors(id);
    }
}


