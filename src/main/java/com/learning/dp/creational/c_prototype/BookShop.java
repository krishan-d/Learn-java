package com.learning.dp.creational.c_prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {

    private String shopName;
    private List<Book> bookList = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void loadBooksFromDB() {
        for (int i = 1; i <= 10; i++) {
            Book b = new Book();
            b.setBookId(i);
            b.setBookName("Book-" + i);
            getBookList().add(b);
        }
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + bookList +
                '}';
    }

    @Override
    public BookShop clone() { //deep copy
        try {
            //BookShop clone = (BookShop) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            //return clone;

            BookShop shop = new BookShop();
            //Fetching data from old object...which is much faster than fetching data from database
            for (Book b : this.getBookList()) {
                shop.getBookList().add(b);
            }
            return shop;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
