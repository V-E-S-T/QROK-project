package com.QROKproject.controller;

import com.QROKproject.model.Author;
import com.QROKproject.model.Book;
import com.QROKproject.model.Reward;
import com.QROKproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AuthorRESTController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getAll(){

        return authorService.getAll();
    }

    @PostMapping(value = "/author/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Author create(@RequestBody Author author){

        authorService.save(author);

        return author;
    }

    @PostMapping(value = "/author/{id}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Author update(@RequestBody Author author, @PathVariable("id") int id){

        return authorService.update(author, id);
    }

    @DeleteMapping(value = "/author/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){

        authorService.delete(id);
    }

    @GetMapping(value = "/author/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Author get(@PathVariable("id") int id){

        return authorService.get(id);
    }

    @GetMapping(value = "/author/{id}/books", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Book> getListBooks(@PathVariable("id") int id){

        return authorService.listBooks(id);
    }

    @GetMapping(value = "/author/{id}/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Reward> getListRewards(@PathVariable("id") int id){

        return authorService.listRewards(id);
    }

}
