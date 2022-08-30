package ru.haulmont.belyak_test3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.haulmont.belyak_test3.dto.ResponseBook;
import ru.haulmont.belyak_test3.entity.Book;
import ru.haulmont.belyak_test3.repository.BooksRepository;
import ru.haulmont.belyak_test3.service.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BooksService booksService;
    private final BooksRepository booksRepository;

    @Autowired
    public BookController(BooksService booksService,
                          BooksRepository booksRepository) {
        this.booksService = booksService;
        this.booksRepository = booksRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResponseBook>> getAllBooksProd() {

        return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Book> createBook(@RequestParam String name, @RequestParam String year) {
        Book book = new Book();
        book.setName(name);
        book.setYear(year);
        booksRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

}
