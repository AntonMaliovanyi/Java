import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        // Створення об'єктів книг та користувачів
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        User user1 = new User("Ivan Petrov", 1995);
        User user2 = new User("Vaska Grosu", 2004);

        // Додавання книг до користувачів
        user1.borrowBook(book1);
        user2.borrowBook(book2);

        // Створення об'єкту для бібліотеки
        Library library = new Library.Builder("City Library")
                .books(Arrays.asList(book1, book2))
                .users(Arrays.asList(user1, user2))
                .build();

        // Вивід інформації
        System.out.println(library);
        System.out.println("Result of book1 == book2 ");
        System.out.println(book1 == book2);
        System.out.println("User1 hashcode");
        System.out.println(user1.hashCode());
    }
}
