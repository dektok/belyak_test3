package ru.haulmont.belyak_test3.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResponseBook {

    private String bookPublisher;

    private String bookName;
    private String bookYear;

    public ResponseBook( String bookname, String bookyear, String bookpublisher) {
        this.bookName = bookname;
        this.bookYear = bookyear;
        this.bookPublisher = bookpublisher;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
}
