import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;
/**
 * Клас, що представляє користувача бібліотеки.
 */
public class User implements Comparable<Object>{
    private String name;
    private int birth_y;
    public List<Book> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.birth_y = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return birth_y;
    }

    public void setAge(int age) {
        this.birth_y = age;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = new ArrayList<>(borrowedBooks);
    }


    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    public int compareTo(Object o) {
        User u = (User) o;
        return this.getAge() - u.getAge();
    }

    @Override
    public String toString() {
        return "(Name=" + name + '\'' +
                ", year of birth=" + birth_y +
                ", borrowedBooks=" + borrowedBooks + ") ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return birth_y == user.birth_y &&
                Objects.equals(name, user.name) &&
                Objects.equals(borrowedBooks, user.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birth_y, borrowedBooks);
    }
}
