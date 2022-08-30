package ru.haulmont.belyak_test3.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", nullable = false)
    private UUID id;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "BYEAR")
    private String Year;
    @Column(name = "PUBLISHER")
    private String Publisher;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public Book () {}

    public Book (String name, String year, String publisher) {
        this.Name = name;
        this.Publisher = publisher;
        this.Year = year;
    }

}
