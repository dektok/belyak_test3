package ru.haulmont.belyak_test3.service;

import ru.haulmont.belyak_test3.dto.ResponseBook;

import java.util.List;

public interface BooksService {

    List<ResponseBook> getAllBooks();

    void createBook(ResponseBook book);
}
