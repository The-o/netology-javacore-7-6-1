package ru.netology.pyas;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ru.netology.pyas.missedcalls.Contact;
import ru.netology.pyas.missedcalls.ContactGroup;
import ru.netology.pyas.missedcalls.PhoneCalls;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneCalls phoneCalls = new PhoneCalls();
        loop: while(true) {
            int action = promptAction(scanner);

            switch(action) {
                case 1:
                    addContact(scanner, phoneCalls);
                    break;

                case 2:
                    updateContact(scanner, phoneCalls);
                    break;

                case 3:
                    removeContact(scanner, phoneCalls);
                    break;

                case 4:
                    addMissedCall(scanner, phoneCalls);
                    break;

                case 5:
                    printMissedCalls(phoneCalls);
                    break;

                case 6:
                    clearMissedCalls(phoneCalls);
                    break;

                default:
                    break loop;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void addContact(Scanner scanner, PhoneCalls phoneCalls) {
        String phone = readPhone(scanner);
        Contact contact = new Contact(phone);
        populateContact(scanner, contact);
        phoneCalls.addContact(contact);
    }

    private static void updateContact(Scanner scanner, PhoneCalls phoneCalls) {
        String phone = readPhone(scanner);
        Contact contact = phoneCalls.getContact(phone);
        if (contact == null) {
            System.out.println("Такого контакта нет.");
            return;
        }
        populateContact(scanner, contact);
    }

    private static void removeContact(Scanner scanner, PhoneCalls phoneCalls) {
        String phone = readPhone(scanner);
        if (!phoneCalls.removeContact(phone)) {
            System.out.println("Такого контакта нет.");
        }
    }

    private static int readInt(Scanner scanner, String prompt, int min, int max) {
        int result = 0;

        while (true) {
            System.out.print(prompt);
            System.out.print(": ");

            try {
                result = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }

            if (result >= min && result <= max) {
                break;
            }
        }

        return result;
    }

    private static int promptAction(Scanner scanner) {
        System.out.println("1. Добавить контакт");
        System.out.println("2. Изменить контакт");
        System.out.println("3. Удалить контакт");
        System.out.println("4. Добавить пропущенный вызов");
        System.out.println("5. Вывести все пропущенные вызовы");
        System.out.println("6. Очистить пропущенные вызовы");
        System.out.println("7. Выход");
        System.out.println();

        return readInt(scanner, "Выберите пункт из меню", 1, 7);
    }

    private static String readPhone(Scanner scanner) {
        System.out.print("Введите номер телефона: ");
        return scanner.nextLine();
    }

    private static void populateContact(Scanner scanner, Contact contact) {
        System.out.print("Введите фамилию: ");
        contact.setLastname(scanner.nextLine());

        System.out.print("Введите имя: ");
        contact.setFirstname(scanner.nextLine());

        System.out.println("Доступные группы: ");

        ContactGroup[] groups = ContactGroup.values();
        for (int i = 0; i < groups.length; ++i) {
            System.out.format("\t%d. %s%n", i + 1, groups[i].getTitle());
        }
        int groupNum = readInt(scanner, "Введите номер группы", 1, groups.length + 1) - 1;

        contact.setGroup(groups[groupNum]);
    }

    private static void addMissedCall(Scanner scanner, PhoneCalls phoneCalls) {
        String phone = readPhone(scanner);
        phoneCalls.addMissedCall(LocalDateTime.now(), phone);
    }

    private static void clearMissedCalls(PhoneCalls phoneCalls) {
        phoneCalls.clearMissedCalls();
    }

    private static void printMissedCalls(PhoneCalls phoneCalls) {
        Iterator<PhoneCalls.MissedCall> iterator = phoneCalls.getMissedCallsIterator();

        if(!iterator.hasNext()) {
            System.out.println("Нет пропущенных звонков.");
            return;
        }

        System.out.println("Пропущенные звонки: ");

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
