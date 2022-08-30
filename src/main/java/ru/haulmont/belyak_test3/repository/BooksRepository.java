package ru.haulmont.belyak_test3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.haulmont.belyak_test3.entity.Book;

import java.util.UUID;


public interface BooksRepository extends JpaRepository<Book, UUID>  {
}
