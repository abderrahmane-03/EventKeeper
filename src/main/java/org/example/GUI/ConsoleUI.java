package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import org.example.dao.EventDAO;
import org.example.dao.ParticipantDAO;
import org.example.entities.Event;
import org.example.entities.Participant;
import org.example.enums.EventType;
import org.example.services.ReportService;
import org.example.utils.Validation;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI {
    private final EventDAO eventManager;
    private final ParticipantDAO participantManager;
    private final ReportService reportService;
    private final Scanner scanner;

    public ConsoleUI(EventDAO eventManager, ParticipantDAO participantManager, ReportService reportService, Scanner scanner) {
        this.eventManager = eventManager;
        this.participantManager = participantManager;
        this.reportService = reportService;
        this.scanner = scanner;
    }

    public void displayAdminMenu() {
        // Display Admin Menu options

        System.out.println("                                                                                                                    \n" +

                "         eeeeeeeeeeee    vvvvvvv           vvvvvvv    eeeeeeeeeeee    nnnn  nnnnnnnn    ttttttt:::::ttttttt         \n" +
                "       ee::::::::::::ee   v:::::v         v:::::v   ee::::::::::::ee  n:::nn::::::::nn  t:::::::::::::::::t         \n" +
                "      e::::::eeeee:::::ee  v:::::v       v:::::v   e::::::eeeee:::::een::::::::::::::nn t:::::::::::::::::t         \n" +
                "     e::::::e     e:::::e   v:::::v     v:::::v   e::::::e     e:::::enn:::::::::::::::ntttttt:::::::tttttt         \n" +
                "     e:::::::eeeee::::::e    v:::::v   v:::::v    e:::::::eeeee::::::e  n:::::nnnn:::::n      t:::::t               \n" +
                "     e:::::::::::::::::e      v:::::v v:::::v     e:::::::::::::::::e   n::::n    n::::n      t:::::t               \n" +
                "     e::::::eeeeeeeeeee        v:::::v:::::v      e::::::eeeeeeeeeee    n::::n    n::::n      t:::::t               \n" +
                "     e:::::::e                  v:::::::::v       e:::::::e             n::::n    n::::n      t:::::t    tttttt     \n" +
                "     e::::::::e                  v:::::::v        e::::::::e            n::::n    n::::n      t::::::tttt:::::t     \n" +
                "      e::::::::eeeeeeee           v:::::v          e::::::::eeeeeeee    n::::n    n::::n      tt::::::::::::::t     \n" +
                "       ee:::::::::::::e            v:::v            ee:::::::::::::e    n::::n    n::::n        tt:::::::::::tt     \n" +
                "         eeeeeeeeeeeeee             vvv               eeeeeeeeeeeeee    nnnnnn    nnnnnn          ttttttttttt       \n" +
                "kkkkkkkk                                                                                                               \n" +
                "k::::::k                                                                                                               \n" +
                "k::::::k                                                                                                               \n" +
                "k::::::k                                                                                                               \n" +
                " k:::::k    kkkkkkk    eeeeeeeeeeee        eeeeeeeeeeee    ppppp   ppppppppp       eeeeeeeeeeee    rrrrr   rrrrrrrrr   \n" +
                " k:::::k   k:::::k   ee::::::::::::ee    ee::::::::::::ee  p::::ppp:::::::::p    ee::::::::::::ee  r::::rrr:::::::::r  \n" +
                " k:::::k  k:::::k   e::::::eeeee:::::ee e::::::eeeee:::::eep:::::::::::::::::p  e::::::eeeee:::::eer:::::::::::::::::r \n" +
                " k:::::k k:::::k   e::::::e     e:::::ee::::::e     e:::::epp::::::ppppp::::::pe::::::e     e:::::err::::::rrrrr::::::r\n" +
                " k::::::k:::::k    e:::::::eeeee::::::ee:::::::eeeee::::::e p:::::p     p:::::pe:::::::eeeee::::::e r:::::r     r:::::r\n" +
                " k:::::::::::k     e:::::::::::::::::e e:::::::::::::::::e  p:::::p     p:::::pe:::::::::::::::::e  r:::::r     rrrrrrr\n" +
                " k:::::::::::k     e::::::eeeeeeeeeee  e::::::eeeeeeeeeee   p:::::p     p:::::pe::::::eeeeeeeeeee   r:::::r            \n" +
                " k::::::k:::::k    e:::::::e           e:::::::e            p:::::p    p::::::pe:::::::e            r:::::r            \n" +
                "k::::::k k:::::k   e::::::::e          e::::::::e           p:::::ppppp:::::::pe::::::::e           r:::::r            \n" +
                "k::::::k  k:::::k   e::::::::eeeeeeee   e::::::::eeeeeeee   p::::::::::::::::p  e::::::::eeeeeeee   r:::::r            \n" +
                "k::::::k   k:::::k   ee:::::::::::::e    ee:::::::::::::e   p::::::::::::::pp    ee:::::::::::::e   r:::::r            \n" +
                "kkkkkkkk    kkkkkkk    eeeeeeeeeeeeee      eeeeeeeeeeeeee   p::::::pppppppp        eeeeeeeeeeeeee   rrrrrrr            \n" +
                "                                                            p:::::p                                                    \n" +
                "                                                            p:::::p                                                    \n" +
                "                                                           p:::::::p                                                   \n");
                System.out.println("1. Add Event");
                System.out.println("2. Modify Event");
                System.out.println("3. Delete Event");
                System.out.println("4. Generate Event Report");
                System.out.println("5. Manage Participants");
                System.out.println("6. Exit");
    }

    public void displayParticipantMenu() {
        System.out.println("=== Event Management System ===");
        System.out.println("1. View Events");
        System.out.println("2. Register for Event");
        System.out.println("3. View My Registrations");
        System.out.println("6. Exit");
    }

    public int getUserChoice() {
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public void handleAdminActions(int choice) {
        switch (choice) {
            case 1:
                String eventName = Validation.validateStringInput(scanner, "Event Name");
                Date eventDate = Validation.validateDate(scanner);
                String eventLocation = Validation.validateStringInput(scanner, "Event Location");
                System.out.print("Enter Event Type (CONFERENCE, WORKSHOP, SEMINAR, WEBINAR): ");
                String eventTypeInput = scanner.next().toUpperCase();
                try {
                    EventType eventType = EventType.valueOf(eventTypeInput);
                    Event newEvent = new Event();
                    newEvent.setEventName(eventName);
                    newEvent.setEventDate(eventDate);
                    newEvent.setEventLocation(eventLocation);
                    newEvent.setEventType(eventType);

                    eventManager.addEvent(newEvent);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid event type. Please enter a valid type.");
                }
                break;

            case 2:
                modifyEvent();
                break;

            case 3:
                deleteEvent();
                break;

            case 4:
                reportService.generateEventReport();
                break;
            case 5:
                manageParticipants();
                break;
            case 6:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public void handleParticipantActions(int choice) {
        switch (choice) {
            case 1:
                eventManager.getAllEvents().forEach(Event::displayEventDetails);
                break;

            case 2:
                registerForEvent();
                break;

            case 3:
                System.out.println("Viewing your registrations...");
                break;

            case 6:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private int validateEventId() {
        int eventId = 0;
        while (eventId <= 0) {
            System.out.print("Enter a positive Event ID: ");
            if (scanner.hasNextInt()) {
                eventId = scanner.nextInt();
                if (eventId <= 0) {
                    System.out.println("Event ID must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return eventId;
    }

    private void modifyEvent() {
        int modifyId = validateEventId();
        String newName = Validation.validateStringInput(scanner, "New Event Name");
        Date newDate = Validation.validateDate(scanner);
        String newLocation = Validation.validateStringInput(scanner, "New Event Location");

        EventType newType = null;
        while (newType == null) {
            String newTypeString = Validation.validateStringInput(scanner, "New Event Type");
            try {
                newType = EventType.valueOf(newTypeString.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid event type. Please enter a valid type.");
            }
        }

        eventManager.modifyEvent(modifyId, newName, newDate, newLocation, newType);
    }

    private void deleteEvent() {
        int deleteId = validateEventId();
        eventManager.deleteEvent(deleteId);
    }

    private void registerForEvent() {
        int eventId = validateEventId();
        System.out.println("Registering for event ID: " + eventId);
    }

    private void manageParticipants() {
        System.out.println("1. Add Participant");
        System.out.println("2. Modify Participant");
        System.out.println("3. Delete Participant");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                String name = Validation.validateStringInput(scanner, "Name");
                String email = Validation.validateEmail(scanner);
                String phoneNumber = Validation.validateStringInput(scanner, "Phone Number");

                participantManager.addParticipant(new Participant(0, name, email, phoneNumber));
                break;

            case 2:
                int participantId = validateParticipantId();
                String newName = Validation.validateStringInput(scanner, "New Name");
                String newEmail = Validation.validateEmail(scanner);
                String newPhoneNumber = Validation.validateStringInput(scanner, "New Phone Number");

                participantManager.modifyParticipant(participantId, newName, newEmail, newPhoneNumber);
                break;

            case 3:
                participantId = validateParticipantId();
                participantManager.deleteParticipant(participantId);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private int validateParticipantId() {
        int participantId = 0;
        while (participantId <= 0) {
            System.out.print("Enter a positive Participant ID: ");
            if (scanner.hasNextInt()) {
                participantId = scanner.nextInt();
                if (participantId <= 0) {
                    System.out.println("Participant ID must be positive.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        scanner.nextLine();  // Consume newline
        return participantId;
    }

    // Method to display custom font in a GUI window

}
