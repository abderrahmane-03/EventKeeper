package org.example.services;

import org.example.entities.User;
import org.example.enums.UserRole;

import java.util.Scanner;

public class UserService {

    public static User login(Scanner scanner) {
        System.out.println("Welcome! Please log in.");
        System.out.print("Enter your user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        UserRole role = null;
        while (role == null) {
            System.out.print("Are you an Admin or Participant? ");
            String roleInput = scanner.nextLine();
            if (roleInput.equalsIgnoreCase("Admin")) {
                role = UserRole.ADMIN;
            } else if (roleInput.equalsIgnoreCase("Participant")) {
                role = UserRole.PARTICIPANT;
            } else {
                System.out.println("Invalid role. Please enter either 'Admin' or 'Participant'.");
            }
        }

        return new User(userId, userName, role);  // Assuming User class constructor takes userId, userName, and role
    }
}
