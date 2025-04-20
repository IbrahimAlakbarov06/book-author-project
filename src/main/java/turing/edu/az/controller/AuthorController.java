package turing.edu.az.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import turing.edu.az.model.Author;
import turing.edu.az.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable long id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);
    }
}
