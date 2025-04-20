package turing.edu.az.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turing.edu.az.dao.BookDao;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
}
