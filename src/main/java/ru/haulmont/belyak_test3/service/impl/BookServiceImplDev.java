package ru.haulmont.belyak_test3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import ru.haulmont.belyak_test3.condition.DevCondition;
import ru.haulmont.belyak_test3.dto.ResponseBook;
import ru.haulmont.belyak_test3.repository.BooksRepository;
import ru.haulmont.belyak_test3.service.BooksService;

import java.util.ArrayList;
import java.util.List;

@Conditional(DevCondition.class)
@Service("bookService")
public class BookServiceImplDev implements BooksService {
    private final BooksRepository booksRepository;

    @Value("${publishername}")
    private String defPublisher;

    @Autowired
    public BookServiceImplDev(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<ResponseBook> getAllBooks() {

        List<ResponseBook> responseBooks = new ArrayList<ResponseBook>();

        responseBooks.add(new ResponseBook("Name 1", "1999", defPublisher));
        responseBooks.add(new ResponseBook("Name 2", "2010", defPublisher));

        return responseBooks;
    }

    public void createBook(ResponseBook resbook) {

        // Ничего не делаем, так как Dev

        // Book book = new Book(resbook.getBookName(), resbook.getBookYear(), resbook.getBookPublisher());

        // booksRepository.save(book);
    }

}
