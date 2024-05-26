package com.learning._8.lambda;

import java.util.Comparator;
import java.util.List;

public class BookService {

    public List<Book> getBooksSortedByName() {
        List<Book> books = new BookDAO().getBooks();
//      Collections.sort(books, new BookComparator());
        // or
        /*Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/
        // or
//      Collections.sort(books, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        // or
//      Collections.sort(books, Comparator.comparing(Book::getName));
        // or
        books.sort(Comparator.comparing(Book::getName));
        // or
        books.stream().sorted(Comparator.comparing(Book::getName)).forEach(System.out::println);

        return books;
    }

    public static void main(String[] args) {
        List<Book> books = new BookService().getBooksSortedByName();
        System.out.println(books);

    }
}

class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
//      return o1.getName().compareTo(o2.getName());
        return o2.getName().compareTo(o1.getName()); // reverse
    }
}