package com.learning._8.lambda;

import com.learning._8.lambda.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(100, "Microservices", "San M"));
        books.add(new Book(102, "DSA", "M Web"));
        return books;
    }
}
