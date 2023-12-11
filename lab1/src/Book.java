import java.util.Objects;

/**
 * Клас, що представляє книгу в бібліотеці.
 */
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Гетер для поля title
    public String getTitle() {
        return title;
    }

    // Сетер для поля title
    public void setTitle(String title) {
        this.title = title;
    }

    // Гетер для поля author
    public String getAuthor() {
        return author;
    }

    // Сетер для поля author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Гетер для поля year
    public int getYear() {
        return year;
    }

    // Сетер для поля year
    public void setYear(int year) {
        this.year = year;
    }
    // Вивід інформації про книгу
    @Override
    public String toString() {
        return "(Book" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year + ")";
    }
    // Порівняння двох об'єктів нкиг
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }
    // Хаш код об'єкту книги
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
