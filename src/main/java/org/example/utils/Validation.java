package org.example.utils;

import org.example.enums.EventType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    // Validate String Input
    public static String validateStringInput(Scanner scanner, String fieldName) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print("Enter " + fieldName + ": ");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println(fieldName + " cannot be empty.");
            }
        }
        return input;
    }
    public static String validateEmail(Scanner scanner) {
        String email;
        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        do {
            System.out.println("Enter email: ");
            email = scanner.nextLine().trim();
            if (!Pattern.matches(emailPattern, email)) {
                System.out.println("Invalid email format. Please enter again.");
            }
        } while (!Pattern.matches(emailPattern, email));
        return email;
    }
    // Validate Date Input
    public static Date validateDate(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Date date = null;
        while (date == null) {
            System.out.print("Enter Event Date (dd/MM/yyyy): ");
            String dateInput = scanner.nextLine();
            try {
                date = dateFormat.parse(dateInput);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            }
        }
        return date;
    }

    // Validate EventType Input
    public static EventType validateEventType(Scanner scanner) {
        EventType eventType = null;
        while (eventType == null) {
            System.out.println("Select Event Type:");
            for (EventType type : EventType.values()) {
                System.out.println(type.ordinal() + 1 + ". " + type);
            }
            int typeIndex = scanner.nextInt();
            scanner.nextLine();
            if (typeIndex >= 1 && typeIndex <= EventType.values().length) {
                eventType = EventType.values()[typeIndex - 1];
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        return eventType;
    }


    public static int validateAdminMenuChoice(Scanner scanner) {
        int choice = 0;
        while (choice < 1 || choice > 6) {
            System.out.print("Enter choice (1-6): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.next(); // Consume invalid input
            }
        }
        return choice;
    }
}
