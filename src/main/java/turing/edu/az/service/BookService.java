package turing.edu.az.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turing.edu.az.dao.AuthorDao;
import turing.edu.az.dao.BookDao;
import turing.edu.az.exception.AuthorNotFoundException;
import turing.edu.az.exception.BookNotFoundException;
import turing.edu.az.model.Author;
import turing.edu.az.model.Book;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book getBookById(Long id) {
        return bookDao.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    public Book createBook(Book book, Long authorId) {
        Author author = authorDao.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + authorId));
        book.setAuthor(author);
        return bookDao.save(book);
    }

    public Book updateBook(Long id, Book bookDetails, Long authorId) {
        Book book = getBookById(id);
        Author author = authorDao.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + authorId));

        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setAuthor(author);

        return bookDao.save(book);
    }

    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookDao.delete(book);
    }
}