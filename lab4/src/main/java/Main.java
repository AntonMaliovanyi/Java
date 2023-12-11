import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        // Створення об'єктів книг та користувачів
        try {
            Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
            Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
            User user1 = new User("Ivan Petrov", 25);
            User user2 = new User("Vaska Grosu", 25);

            // Додавання книг до користувачів
            user1.borrowBook(book1);
            user2.borrowBook(book2);

            // Створення об'єкту для бібліотеки
            Library library = new Library.Builder("3Library", 2025)
                    .books(Arrays.asList(book1, book2))
                    .users(Arrays.asList(user1, user2))
                    .build();


            System.out.println(library);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
