package com.example.javaalior_martynaplawny_zad_11_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/add")
    public String add(@RequestParam(name = "imie", required = false) String name,
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
