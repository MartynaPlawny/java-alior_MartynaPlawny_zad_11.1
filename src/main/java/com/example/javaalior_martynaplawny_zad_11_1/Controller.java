package com.example.javaalior_martynaplawny_zad_11_1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final UserRepository userRepository;

    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
        User user1 = new User("Użytkownik", "Testowy", 1);
        User user2 = new User("Użytkownik", "Testowy", 2);
        User user3 = new User("Użytkownik", "Testowy", 3);
        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);
    }

    @RequestMapping("/add")
    public String add(@RequestParam(name = "imie") String name,
                      @RequestParam(name = "nazwisko", required = false, defaultValue = "Nazwisko") String lastName,
                      @RequestParam(name = "wiek", required = false, defaultValue = "20") Integer age) {

        if (name.isEmpty()) {
            return "redirect:/err.html";
        } else {
            User user = new User(name, lastName, age);
            userRepository.add(user);
        }
        return "redirect:/success.html";
    }

    @ResponseBody
    @RequestMapping("/users")
    public String list() {

        List<User> userList = userRepository.getAll();

        String result = "";
        for (User user : userList) {
            result += "Imię: " + user.getFirstName() +
                    ", Nazwisko: " + user.getLastName() +
                    ", Wiek: " + user.getAge() + "<br/>";
        }
        return result;
    }
}
