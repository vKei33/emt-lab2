package emt.lab.Library.service.impl;

import emt.lab.Library.dao.AuthorDao;
import emt.lab.Library.model.Author;
import emt.lab.Library.model.exceptions.InvalidAuthorIdException;
import emt.lab.Library.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author getById(Long id) {
        return this.authorDao.findById(id).orElseThrow(InvalidAuthorIdException::new);
    }
}
