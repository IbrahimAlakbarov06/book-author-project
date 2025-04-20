package turing.edu.az.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turing.edu.az.dao.AuthorDao;
import turing.edu.az.exception.AuthorNotFoundException;
import turing.edu.az.model.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorDao authorDao;

    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorDao.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }

    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = getAuthorById(id);
        author.setName(authorDetails.getName());
        author.setEmail(authorDetails.getEmail());
        return authorDao.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorDao.delete(author);
    }
}