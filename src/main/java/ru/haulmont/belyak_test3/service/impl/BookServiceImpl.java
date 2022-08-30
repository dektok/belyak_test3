package ru.haulmont.belyak_test3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import ru.haulmont.belyak_test3.condition.ProdCondition;
import ru.haulmont.belyak_test3.dto.ResponseBook;
import ru.haulmont.belyak_test3.entity.Book;
import ru.haulmont.belyak_test3.repository.BooksRepository;
import ru.haulmont.belyak_test3.service.BooksService;

import java.util.ArrayList;
import java.util.List;

@Conditional(ProdCondition.class)
@Service("bookService")
public class BookServiceImpl implements BooksService {

    private final BooksRepository booksRepository;

    @Value("${publishername}")
    private String defPublisher;

    @Autowired
    public BookServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<ResponseBook> getAllBooks() {

        List<Book> books = booksRepository.findAll();
        List<ResponseBook> responseBooks = new ArrayList<ResponseBook>();

        for(Book b : books){
            ResponseBook proxyBook = new ResponseBook(b.getName(),b.getYear(), defPublisher);

            responseBooks.add(proxyBook);
        }

        return responseBooks;
    }

    public void createBook(ResponseBook resbook) {

        Book book = new Book(resbook.getBookName(), resbook.getBookYear(), resbook.getBookPublisher());

        booksRepository.save(book);
    }

}
