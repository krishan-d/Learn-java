package com.learning.dp.creational.c_prototype;

//Prototype Design Pattern
public class Main {

    public static void main(String[] args) {

        System.gc();

        BookShop bs = new BookShop();
        bs.setShopName("A");
        bs.loadBooksFromDB();

        /*
        * //Instead of loading data form db again, use object cloning to achieve prototype design pattern.
        * BookShop bs2 = new BookShop();
        * bs.loadBooksFromDB();
        * */

        //BookShop bs2 = (BookShop) bs.clone(); //shallow copy

        //Prototype design pattern...
        BookShop bs2 = bs.clone(); //deep copy
        bs2.setShopName("B");

        bs.getBookList().remove(2);
        System.out.println(bs);
        System.out.println(bs2);

    }
}
