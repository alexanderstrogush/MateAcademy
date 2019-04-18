package mate.academy.hw07.handler;

import mate.academy.hw07.dao.HumanDao;
import mate.academy.hw07.dao.InMemoryHumanDao;
import mate.academy.hw07.di.Inject;
import mate.academy.hw07.model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static HumanDao humanDao = new InMemoryHumanDao();

    public static void handler() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Виберіть команду : ");
            System.out.println("1 - для додавання людини в базу");
            System.out.println("2 - для перегляду всіх людей з бази");
            System.out.println("3 - для перегляду інформації про людину з бази за її ім'ям і прізвищем");
            System.out.println("4 - для перегляду інформації про людину з бази за порядковим номером");
            System.out.println("5 - для виходу з програми");
            int consoleChoice = scanner.nextInt();
            switch (consoleChoice) {
                case 1:
                    addHumanInfo(scanner);
                    break;
                case 2:
                    humanDao.get();
                    break;
                case 3:
                    System.out.println("Введіть ім'я та прізвище");
                    System.out.println(humanDao.get(scanner.next() + " " + scanner.next()));
                    break;
                case 4:
                    System.out.println("Введіть порядковий номер");
                    System.out.println(humanDao.get(scanner.nextInt()));
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addHumanInfo(Scanner scanner) {
        System.out.println("Додавання людини в базу :");
        System.out.println("Введіть ім'я :");
        String name = scanner.next();
        System.out.println("Введіть прізвище");
        String surName = scanner.next();
        System.out.println("Введіть вік");
        int age = scanner.nextInt();
        System.out.println("Введіть місто");
        String currentCity = scanner.next();
        System.out.println("Введіть email");
        String email = scanner.next();
        System.out.println("Введіть номер телефону");
        String phoneNumber = scanner.next();

        humanDao.save(new Human(name, surName, age, currentCity, email, phoneNumber));
    }
}
