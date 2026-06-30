package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();


        userService.createUsersTable();


        userService.saveUser("Иван", "Иванов", (byte) 25);
        System.out.println("Пользователь с именем - Иван добавлен в базу данных");

        userService.saveUser("Мария", "Петрова", (byte) 30);
        System.out.println("Пользователь с именем - Мария добавлена в базу данных");

        userService.saveUser("Алексей", "Сидоров", (byte) 22);
        System.out.println("Пользователь с именем - Алексей добавлен в базу данных");

        userService.saveUser("Елена", "Кузнецова", (byte) 28);
        System.out.println("Пользователь с именем - Елена добавлена в базу данных");


        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);


        userService.cleanUsersTable();


        userService.dropUsersTable();
    }
}