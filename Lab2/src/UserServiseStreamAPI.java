import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class UserServiseStreamAPI{


    public List<User> sortByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> sortByName(List<User> users) {
        return users.stream()
                .sorted((user1, user2) -> user1.getName().compareTo(user2.getName()))
                .collect(Collectors.toList());
    }

    public List<User> sortByBorrowedBooks(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(user -> user.getBorrowedBooks().size()))
                .collect(Collectors.toList());
    }




}