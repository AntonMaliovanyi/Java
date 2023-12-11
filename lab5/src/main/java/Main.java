import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Підключення до бази даних SQLite
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");

            // Створення таблиць
            createTables(connection);

            // Додавання значень до таблиць з усіма книгами доступними
            insertSampleData(connection);

            // Виведення результатів до оновлення
            System.out.println("Before Update:");
            displayResults(connection);

            // Оновлення стану всіх книг (is_available) (зміна всіх книг з доступних на недоступні)
            updateLoanedBooksAvailability(connection, false);

            // Виведення результатів після оновлення
            System.out.println("\nAfter Update:");
            displayResults(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закриття з'єднання
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        // Створення таблиць
        statement.execute("CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "author TEXT NOT NULL," +
                "is_available BOOLEAN NOT NULL)");

        statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL)");

        statement.execute("CREATE TABLE IF NOT EXISTS loans (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "book_id INTEGER NOT NULL," +
                "user_id INTEGER NOT NULL," +
                "loan_date DATE NOT NULL," +
                "return_date DATE," +
                "FOREIGN KEY (book_id) REFERENCES books(id)," +
                "FOREIGN KEY (user_id) REFERENCES users(id))");
    }

    private static void insertSampleData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        // Додавання кількох книг і користувачів
        statement.execute("INSERT INTO books (title, author, is_available) VALUES " +
                "('Java Programming', 'John Doe', true), " +
                "('SQL Fundamentals', 'Jane Smith', true), " +
                "('Data Structures', 'Bob Johnson', true)");

        statement.execute("INSERT INTO users (name) VALUES " +
                "('Alice'), " +
                "('Bob')");

        // Видача книг користувачам
        statement.execute("INSERT INTO loans (book_id, user_id, loan_date) VALUES " +
                "(1, 1, '2023-01-01'), " +
                "(3, 2, '2023-02-01')");
    }

    private static void displayResults(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        // Виведення всіх книг
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
        System.out.println("Books:");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                    ", Title: " + resultSet.getString("title") +
                    ", Author: " + resultSet.getString("author") +
                    ", Available: " + resultSet.getBoolean("is_available"));
        }

        // Виведення видач книг користувачам
        resultSet = statement.executeQuery("SELECT users.name, books.title, loans.loan_date " +
                "FROM loans " +
                "INNER JOIN users ON loans.user_id = users.id " +
                "INNER JOIN books ON loans.book_id = books.id");
        System.out.println("\nLoans:");
        while (resultSet.next()) {
            System.out.println("User: " + resultSet.getString("name") +
                    ", Book: " + resultSet.getString("title") +
                    ", Loan Date: " + resultSet.getString("loan_date"));
        }
    }

    private static void updateLoanedBooksAvailability(Connection connection, boolean isAvailable) {
        try {
            Statement statement = connection.createStatement();

            // Оновлення стану книг (is_available) тільки для видачі користувачам
            String updateQuery = "UPDATE books SET is_available = " + isAvailable +
                    " WHERE id IN (SELECT book_id FROM loans)";
            statement.executeUpdate(updateQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
