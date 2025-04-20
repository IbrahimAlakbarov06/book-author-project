package turing.edu.az.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turing.edu.az.dao.AuthorDao;
import turing.edu.az.model.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorDao authorDao;
}
