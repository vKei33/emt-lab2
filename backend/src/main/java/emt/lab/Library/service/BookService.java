package emt.lab.Library.service;

import emt.lab.Library.model.Book;
import emt.lab.Library.model.dto.BookDto;

import java.util.List;

public interface BookService {

    public List<Book> getAll();

    Book getById(Long id);

    Book insertBook(BookDto bookDto);

    Book updateBook(Long id, BookDto bookDto);

    public void deleteById(Long id);

    Book markAsTaken(Long id);

}
