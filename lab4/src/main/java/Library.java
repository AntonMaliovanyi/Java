import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.*;
import javax.validation.*;
import java.util.Set;


/**
 * Клас, що представляє бібліотеку.
 */
public class Library {
    @Pattern(regexp = "^[a-z A-Z]+[a-z A-Z0-9]*$+", message = "Invalid name of the library")
    private String name;

    @Max(value = 2023, message = "Year should not be > 2023")
    @Min(value = 1600, message = "Year should not be < 1600")
    private Integer b_year;
    private List<Book> books;
    private List<User> users;

    // Приватний конструктор для внутрішнього використання
    private Library(Builder builder) {
        this.name = builder.name;
        this.books = builder.books;
        this.users = builder.users;
        this.b_year = builder.b_year;
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
                "\nbuilded in: " + b_year +
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
        private String name;
        private List<Book> books;
        private List<User> users;

        private Integer b_year;

        /**
         * Конструктор білдера з обов'язковими параметрами.
         *
         * @param name назва бібліотеки
         */
        public Builder(String name, Integer b_year) {
            this.name = name;
            this.books = new ArrayList<>();
            this.users = new ArrayList<>();
            this.b_year = b_year;
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
        public Library build() throws IllegalArgumentException {
            Library library = new Library(this);


            javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Library>> violations = validator.validate(library);

            if (!violations.isEmpty()) {
                // Формуємо повідомлення про всі невалідні поля
                StringBuilder errorMessage = new StringBuilder("Invalid data\n");
                for (ConstraintViolation<Library> violation : violations) {
                    errorMessage.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
                }
                throw new IllegalArgumentException(errorMessage.toString());
            }

            return new Library(this);
        }
    }


}
