/**
 * The Validation class provides utility methods for validating user input and parsing dates.
 * It includes methods for validating string inputs, email addresses, and dates.
 *
 * Package: org.example.utils
 */
package org.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Validation class provides static methods to validate user inputs and parse dates.
 *
 * It includes methods for validating non-empty strings, email formats, and date formats.
 */
public class Validation {

    /**
     * Validates a non-empty string input from the user.
     *
     * @param scanner The Scanner object used for reading user input.
     * @param fieldName The name of the field for which input is being validated.
     * @return A non-empty string input provided by the user.
     */
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

    /**
     * Validates the format of an email address.
     *
     * @param scanner The Scanner object used for reading user input.
     * @return A valid email address provided by the user.
     */
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

    /**
     * Validates and parses a date input from the user.
     *
     * @param scanner The Scanner object used for reading user input.
     * @return A Date object parsed from the user input in dd/MM/yyyy format.
     */
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

    /**
     * Parses a date string in YYYY-MM-DD format.
     *
     * @param dateInput The date string to be parsed.
     * @return A Date object parsed from the input string.
     */
    public static Date parseDate(String dateInput) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            return null;
        }
    }
}
