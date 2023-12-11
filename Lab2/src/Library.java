import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Клас, що представляє бібліотеку.
 */
public class Library{
    private final String name;
    private final List<Book> books;
    private final List<User> users;

    // Приватний конструктор для внутрішнього використання
    private Library(Builder builder) {
        this.name = builder.name;
        this.books = builder.books;
        this.users = builder.users;
    }

    public List<User> getUsers(){
        return users;
    }

    /**
     * Метод для додавання книги до бібліотеки.
     *
     * @param book книга для додавання
     */
    public void addBook(Book book) {
        this.books.add(book);
    }


    /**
     * Метод для додавання користувача до бібліотеки.
     *
     * @param user користувач для додавання
     */
    public void addUser(User user) {
        this.users.add(user);
    }

    /**
     * Перевизначений метод toString для представлення об'єкта у вигляді рядка.
     */
    @Override
    public String toString() {
        return "Library\n" +
                "name='" + name + '\'' +
                "\nbooks: " + books +
                "\nusers: " + users;
    }

    /**
     * Перевизначений метод equals для порівняння об'єктів.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) &&
                Objects.equals(books, library.books) &&
                Objects.equals(users, library.users);
    }

    /**
     * Перевизначений метод hashCode для генерації хеш-коду.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, books, users);
    }


    /**
     * Клас-білдер для створення об'єктів класу Library.
     */
    public static class Builder {
        private final String name;
        private List<Book> books;
        private List<User> users;

        /**
         * Конструктор білдера з обов'язковими параметрами.
         *
         * @param name назва бібліотеки
         */
        public Builder(String name) {
            this.name = name;
            this.books = new ArrayList<>();
            this.users = new ArrayList<>();
        }

        /**
         * Метод для додавання списку книг до бібліотеки.
         *
         * @param books список книг
         * @return об'єкт білдера
         */
        public Builder books(List<Book> books) {
            this.books = books;
            return this;
        }

        /**
         * Метод для додавання списку користувачів до бібліотеки.
         *
         * @param users список користувачів
         * @return об'єкт білдера
         */
        public Builder users(List<User> users) {
            this.users = users;
            return this;
        }

        /**
         * Метод для побудови об'єкта класу Library.
         *
         * @return готовий об'єкт бібліотеки
         */
        public Library build() {
            return new Library(this);
        }
    }


}
