package com.example.javaalior_martynaplawny_zad_11_1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = new ArrayList<>();

    public void add(User user) {
        userList.add(user);
    }

    public List<User> getAll() {
        return userList;
    }

    public UserRepository() {
        User user1 = new User("Użytkownik", "Testowy", 1);
        User user2 = new User("Użytkownik", "Testowy", 2);
        User user3 = new User("Użytkownik", "Testowy", 3);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }
}
