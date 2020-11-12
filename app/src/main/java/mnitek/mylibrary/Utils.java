package mnitek.mylibrary;

import android.app.Activity;
import android.content.Intent;

import java.net.URISyntaxException;
import java.util.ArrayList;


public class Utils {

    public static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> readBooks;
    private static ArrayList<Book> favBooks;
    private static ArrayList<Book> wantBooks;
    private static ArrayList<Book> currentBooks;

    private Utils()  {
        if (null == allBooks) allBooks = new ArrayList<>(); initData();
        if (null == readBooks) readBooks = new ArrayList<>();
        if (null == favBooks) favBooks = new ArrayList<>();
        if (null == wantBooks) wantBooks = new ArrayList<>();
        if (null == currentBooks) currentBooks = new ArrayList<>();
    }





    private void initData() {
        allBooks.add(new Book(1, "1984", "George Orwell", 184, "https://cf1-taniaksiazka.statiki.pl/images/large/EFF/61966402794KS.jpg"
                , "Modern Utopia", "Long Description"));

        allBooks.add(new Book(2, "Lord of the Flies", "William Golding", 250, "https://images-na.ssl-images-amazon.com/images/I/81WUAoL-wFL.jpg"
                , "Human culture collapse", "Long Description"));
    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getReadBooks() {
        return readBooks;
    }

    public static ArrayList<Book> getFavBooks() {
        return favBooks;
    }

    public static ArrayList<Book> getWantBooks() {
        return wantBooks;
    }

    public static ArrayList<Book> getCurrentBooks() {
        return currentBooks;
    }

    public static Utils getInstance() {
        if (instance != null) return instance;
        else {
            instance = new Utils();
            return instance;
        }
    }

    public Book getBookById(int id) {
        for (Book b:allBooks) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        return readBooks.add(book);
    }

    public boolean addToCurrRead(Book book) {
        return currentBooks.add(book);
    }

    public boolean addToFav(Book book) {
        return favBooks.add(book);
    }

    public boolean addToWantRead(Book book) {
        return wantBooks.add(book);
    }

    public boolean removeFromAlreadyRead(Book book) {
        return readBooks.remove(book);
    }

    public boolean removeFromCurrRead(Book book) {
        return currentBooks.remove(book);
    }

    public boolean removeFromWantRead(Book book) {
        return wantBooks.remove(book);
    }

    public boolean removeFromFav(Book book) {
        return favBooks.remove(book);
    }
}
