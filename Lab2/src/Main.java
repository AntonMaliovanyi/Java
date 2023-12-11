import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Створення об'єктів книг та користувачів
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        User user1 = new User("Ivan Petrov", 1995);
        User user2 = new User("Vaska Grosu", 1996);
        User user3 = new User("Stepan Bandera", 2004);

        // Додавання книг до користувачів
        user1.borrowBook(book1);
        user2.borrowBook(book2);
        user2.borrowBook(book1);

        // Створення об'єкту для бібліотеки
        Library library = new Library.Builder("City Library")
                .books(Arrays.asList(book1, book2))
                .users(Arrays.asList(user1, user2, user3))
                .build();



        System.out.println("Base list of users:");
        System.out.println(library.getUsers());

        UserServise us = new UserServise();

        System.out.println("\nUserService");

        System.out.println("Sort by Age:");
        System.out.println(us.sortByAge(library.getUsers()));
        System.out.println("Sort by Name:");
        System.out.println(us.sortByName(library.getUsers()));
        System.out.println("Sort by Borrowed Books:");
        System.out.println(us.sortByBorrowedBooks(library.getUsers()));


        UserServiseStreamAPI uss = new UserServiseStreamAPI();

        System.out.println("\nSort by Age(StreamAPI):");
        System.out.println(uss.sortByAge(library.getUsers()));
        System.out.println("Sort by Name(StreamAPI):");
        System.out.println(uss.sortByName(library.getUsers()));
        System.out.println("Sort by Borrowed Books(StreamAPI):");
        System.out.println(uss.sortByBorrowedBooks(library.getUsers()));

    }
}
