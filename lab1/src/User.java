import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Клас, що представляє користувача бібліотеки.
 */
public class User {
    private String name;
    private int birth_y;
    private List<Book> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.birth_y = age;
        this.borrowedBooks = new ArrayList<>();
    }

    // Гетер для поля name
    public String getName() {
        return name;
    }

    // Сетер для поля name
    public void setName(String name) {
        this.name = name;
    }

    // Гетер для поля age
    public int getAge() {
        return birth_y;
    }

    // Сетер для поля age
    public void setAge(int age) {
        this.birth_y = age;
    }

    // Гетер для поля borrowedBooks
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Сетер для поля borrowedBooks
    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    // Метод для видачі книги користувачу
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Вивід інформації про користувача
    @Override
    public String toString() {
        return "(Name='" + name + '\'' +
                ", year of birth=" + birth_y +
                ", borrowedBooks=" + borrowedBooks + ")";
    }
    // Порівняння двох об'єктів користувачів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return birth_y == user.birth_y &&
                Objects.equals(name, user.name) &&
                Objects.equals(borrowedBooks, user.borrowedBooks);
    }

    // Хаш код об'єкту користувача
    @Override
    public int hashCode() {
        return Objects.hash(name, birth_y, borrowedBooks);
    }
}
