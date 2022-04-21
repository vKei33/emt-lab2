package emt.lab.Library.controller;

import emt.lab.Library.model.Book;
import emt.lab.Library.model.dto.BookDto;
import emt.lab.Library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> showAll() {
        return this.bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book showBook(@PathVariable Long id) {
        return this.bookService.getById(id);
    }

    @PostMapping("/add-book")
    public String addBook(@RequestBody BookDto bookDto) {
        this.bookService.insertBook(bookDto);
        return "Successfully added new book.";
    }

    @PutMapping("/{id}/edit-book")
    public String editBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        this.bookService.updateBook(id, bookDto);
        return "Successfully edited a book.";
    }

    @DeleteMapping("/{id}/delete-book")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return "Successfully deleted a book.";
    }

}
