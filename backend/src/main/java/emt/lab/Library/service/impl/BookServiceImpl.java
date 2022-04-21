package emt.lab.Library.service.impl;

import emt.lab.Library.dao.AuthorDao;
import emt.lab.Library.dao.BookDao;
import emt.lab.Library.model.Author;
import emt.lab.Library.model.Book;
import emt.lab.Library.model.dto.BookDto;
import emt.lab.Library.model.exceptions.InvalidAuthorIdException;
import emt.lab.Library.model.exceptions.InvalidBookIdException;
import emt.lab.Library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public BookServiceImpl(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @Override
    public List<Book> getAll() {
        return this.bookDao.findAll();
    }

    @Override
    public Book getById(Long id) {
        return this.bookDao.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Book insertBook(BookDto bookDto) {

        Author author = this.authorDao.findById(bookDto.getAuthor()).orElseThrow(InvalidAuthorIdException::new);
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());

        return this.bookDao.save(book);
    }

    @Override
    public Book updateBook(Long id, BookDto bookDto) {

        Author author = this.authorDao.findById(bookDto.getAuthor()).orElseThrow(InvalidAuthorIdException::new);
        Book book = this.bookDao.findById(id).orElseThrow(InvalidBookIdException::new);

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return this.bookDao.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookDao.deleteById(id);
    }

    @Override
    public Book markAsTaken(Long id) {

        Book book = this.bookDao.findById(id).orElseThrow(InvalidBookIdException::new);
        book.setAvailableCopies(book.getAvailableCopies()-1);

        return this.bookDao.save(book);
    }
}
