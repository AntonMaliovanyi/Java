import java.util.List;

public interface UserServiseIn {
    List<User> sortByName(List<User> users);
    <T extends Comparable<? super T>> List<T> sortByAge(List<T> items);

    List<User> sortByBorrowedBooks(List<User> users);
}
