package src;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationUtils {

    public static String validateStringInput(Scanner scanner, String fieldName) {
        String input;
        do {
            System.out.println("Enter " + fieldName + ": ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(fieldName + " cannot be empty. Please enter again.");
            }
        } while (input.isEmpty());
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

    
    public static Date validateDate(Scanner scanner) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date date = null;
        while (date == null) {
            System.out.println("Enter event date (yyyy-MM-dd): ");
            String input = scanner.nextLine().trim();
            try {
                date = dateFormat.parse(input);
                if (date.before(new Date())) {
                    System.out.println("Event date cannot be in the past. Please enter again.");
                    date = null;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter again.");
            }
        }
        return date;
    }
}

