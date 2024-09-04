/**
 * The Main class serves as the entry point for the Event Management System application.
 * It initializes necessary components, performs user authentication, and provides
 * a menu-driven interface for administrators and participants.
 *
 * Package: org.example
 */
package org.example;

import org.example.GUI.ConsoleUI;
import org.example.dao.EventDAO;
import org.example.dao.ParticipantDAO;
import org.example.services.ReportService;
import org.example.entities.User;
import org.example.services.UserService;

import java.util.Scanner;

/**
 * Main class containing the main method to start the Event Management System application.
 *
 * It initializes data access objects, services, and user interfaces, and handles the
 * main application loop based on the user's role (Admin or Participant).
 */
public class Main {
    /**
     * The main method to start the application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventDAO eventManager = new EventDAO();
        ParticipantDAO participantManager = new ParticipantDAO();
        ReportService reportService = new ReportService(eventManager);
        ConsoleUI consoleUI = new ConsoleUI(eventManager, participantManager, reportService, scanner);

        // Perform user login
        User currentUser = UserService.login(scanner);

        // Main application loop
        while (true) {
            // Display menu based on user role
            if (currentUser.isAdmin()) {
                consoleUI.displayAdminMenu();
            } else if (currentUser.isParticipant()) {
                consoleUI.displayParticipantMenu();
            }

            // Get user choice and handle actions based on role
            int choice = consoleUI.getUserChoice();

            if (currentUser.isAdmin()) {
                consoleUI.handleAdminActions(choice);
            } else if (currentUser.isParticipant()) {
                consoleUI.handleParticipantActions(choice);
            }
        }
    }
}
