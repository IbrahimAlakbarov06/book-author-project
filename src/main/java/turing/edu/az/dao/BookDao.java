package turing.edu.az.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turing.edu.az.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
}
