package turing.edu.az.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turing.edu.az.model.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
}
