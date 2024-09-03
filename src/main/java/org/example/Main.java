package org.example;

import org.example.GUI.ConsoleUI;
import org.example.dao.EventDAO;
import org.example.dao.ParticipantDAO;
import org.example.services.ReportService;
import org.example.entities.User;
import org.example.services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventDAO eventManager = new EventDAO();
        ParticipantDAO participantManager = new ParticipantDAO();
        ReportService reportService = new ReportService(eventManager, participantManager);
        ConsoleUI consoleUI = new ConsoleUI(eventManager, participantManager, reportService, scanner);


        User currentUser = UserService.login(scanner);

        while (true) {
            if (currentUser.isAdmin()) {
                consoleUI.displayAdminMenu();
            } else if (currentUser.isParticipant()) {
                consoleUI.displayParticipantMenu();
            }

            int choice = consoleUI.getUserChoice();

            if (currentUser.isAdmin()) {
                consoleUI.handleAdminActions(choice);
            } else if (currentUser.isParticipant()) {
                consoleUI.handleParticipantActions(choice);
            }
        }
    }
}
