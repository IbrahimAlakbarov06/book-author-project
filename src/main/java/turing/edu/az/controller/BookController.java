package turing.edu.az.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import turing.edu.az.model.Book;
import turing.edu.az.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book, @PathVariable long id) {
        return bookService.createBook(book, id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book book, @RequestParam Long authorId) {
        return bookService.updateBook(id, book, authorId);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }
}
