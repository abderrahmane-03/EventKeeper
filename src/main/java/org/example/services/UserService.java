/**
 * The UserService class provides functionality for user authentication and login.
 * It handles user input to determine the role and creates a User object based on the provided information.
 *
 * Package: org.example.services
 */
package org.example.services;

import org.example.entities.User;
import org.example.enums.UserRole;

import java.util.Scanner;
import java.util.UUID;

/**
 * UserService class manages user login and authentication.
 *
 * It prompts the user for their name and role (Admin or Participant), and creates a User object with the provided details.
 */
public class UserService {

    /**
     * Handles user login by prompting for user details and role.
     *
     * @param scanner The Scanner object used for reading user input.
     * @return A User object with a generated UUID, provided user name, and role.
     */
    public static User login(Scanner scanner) {
        System.out.println("Welcome! Please log in.");

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        UserRole role = null;
        while (role == null) {
            System.out.print("Are you an 1-Admin or 2-Participant? ");
            String roleInput = scanner.nextLine();
            if (roleInput.equals("1")) {
                role = UserRole.ADMIN;
            } else if (roleInput.equals("2")) {
                role = UserRole.PARTICIPANT;
            } else {
                System.out.println("Invalid role. Please enter either '1' for Admin or '2' for Participant.");
            }
        }

        UUID userId = UUID.randomUUID();

        return new User(userId, userName, role);
    }
}
