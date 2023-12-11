import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class UserServise implements  UserServiseIn{


    public UserServise(){

    }
    public List<User> sortByName(List<User> users) {
        List<User> sorted = new ArrayList<>(users);
        sorted.sort(Comparator.comparing(User::getName));
        return sorted;
    }
    public <T extends Comparable<? super T>> List<T> sortByAge(List<T> items) {
        List<T> sorted = new ArrayList<>(items);
        Collections.sort(sorted);
        return sorted;
    }

    public List<User> sortByBorrowedBooks(List<User> users) {
        List<User> sorted = new ArrayList<>(users);
        sorted.sort(Comparator.comparingInt(user -> user.getBorrowedBooks().size()));
        return sorted;
    }

}
