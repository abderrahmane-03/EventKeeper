/**
 * The ConsoleUI class provides a command-line interface for interacting with the Event Management System.
 * It allows both administrators and participants to perform various actions related to events and participants.
 *
 * Package: org.example.GUI
 */
package org.example.GUI;

import org.example.dao.EventDAO;
import org.example.dao.ParticipantDAO;
import org.example.entities.Event;
import org.example.entities.Participant;
import org.example.entities.Registration;
import org.example.enums.EventType;
import org.example.services.ReportService;
import org.example.utils.Validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * ConsoleUI class handles the user interactions via the command-line interface.
 * It provides menus for administrators and participants, and processes user choices to perform actions.
 *
 * The main functionalities include:
 * - Displaying menus for admin and participant users
 * - Handling admin actions like adding, modifying, and deleting events
 * - Handling participant actions like registering for events and viewing registrations
 * - Searching for events by date, type, or location
 * - Managing participants (adding, modifying, deleting)
 */
public class ConsoleUI {
    private final EventDAO eventManager;
    private final ParticipantDAO participantManager;
    private final ReportService reportService;
    private final Scanner scanner;

    /**
     * Constructor for ConsoleUI.
     *
     * @param eventManager       The EventDAO object for managing events.
     * @param participantManager The ParticipantDAO object for managing participants.
     * @param reportService      The ReportService object for generating reports.
     * @param scanner            The Scanner object for user input.
     */
    public ConsoleUI(EventDAO eventManager, ParticipantDAO participantManager, ReportService reportService, Scanner scanner) {
        this.eventManager = eventManager;
        this.participantManager = participantManager;
        this.reportService = reportService;
        this.scanner = scanner;
    }

    /**
     * Displays the admin menu with options for managing events and participants.
     */
    public void displayAdminMenu() {


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
                System.out.println("6. search for an events");
                System.out.println("7. Exit");
    }

    /**
     * Displays the participant menu with options for viewing and registering for events.
     */
    public void displayParticipantMenu() {
        System.out.println("=== Event Management System ===");
        System.out.println("1. View Events");
        System.out.println("2. Register for Event");
        System.out.println("3. View My Registrations");
        System.out.println("6. Exit");
    }

    /**
     * Prompts the user to choose an option and returns their choice.
     *
     * @return The user's chosen option as an integer.
     */
    public int getUserChoice() {
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    /**
     * Handles actions for the admin user based on the selected menu option.
     *
     * @param choice The menu option selected by the user.
     */
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
                searchforEvents();
                break;
            case 7:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    /**
     * Handles actions for the participant user based on the selected menu option.
     *
     * @param choice The menu option selected by the user.
     */
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
                System.out.print("Enter your name: ");
                String userName = scanner.nextLine();

                List<Registration> registrations = getRegistrationsByUserName(userName);

                if (registrations.isEmpty()) {
                    System.out.println("You have no registrations.");
                } else {
                    for (Registration registration : registrations) {
                        System.out.println("Event: " + registration.getEventName());
                        System.out.println("Date: " + registration.getEventDate());
                        System.out.println("Location: " + registration.getEventLocation());
                        System.out.println("----");
                    }
                }
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

    private List<Registration> getRegistrationsByUserName(String userName) {

        List<Registration> registrations = new ArrayList<>();

        Participant participant = participantManager.findByName(userName);
        if (participant != null) {
            registrations = participant.getRegistrations();
        }

        return registrations;
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
    /**
     * Registers a participant for an event.
     */
    private void registerForEvent() {
        int eventId = validateEventId();
        System.out.println("Registering for event ID: " + eventId);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        Participant participant = participantManager.findByName(userName);

        Event event = eventManager.findById(eventId);

        if (participant != null && event != null) {
            Registration registration = new Registration(event, new Date()); // Pass event and current date
            participant.addRegistration(registration);
            participantManager.addRegistrationToParticipant(participant.getParticipantId(), registration);
            System.out.println("Successfully registered for the event.");
        } else {
            if (participant == null) {
                System.out.println("Participant not found.");
            }
            if (event == null) {
                System.out.println("Event not found.");
            }
        }
    }


    /**
     * Searches for events based on user input (date, type, or location).
     */
    public void searchforEvents() {
        System.out.println("1. By date");
        System.out.println("2. By type");
        System.out.println("3. By place");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                searchEventsByDate();
                break;
            case 2:
                searchEventsByType();
                break;
            case 3:
                searchEventsByLocation();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    private void searchEventsByDate() {
        System.out.print("Enter the date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();
        Date date = Validation.parseDate(dateInput);

        List<Event> events = eventManager.searchEventsByDate(date);
        displaySearchResults(events, "No events found on this date.");
    }

    private void searchEventsByType() {
        System.out.print("Enter the event type (CONFERENCE, WORKSHOP, SEMINAR, WEBINAR): ");
        String eventTypeInput = scanner.nextLine().toUpperCase();

        try {
            EventType eventType = EventType.valueOf(eventTypeInput);
            List<Event> events = eventManager.searchEventsByType(eventType);
            displaySearchResults(events, "No events found for this event type.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid event type. Please enter a valid type.");
        }
    }

    private void searchEventsByLocation() {
        System.out.print("Enter the event location: ");
        String location = scanner.nextLine();

        List<Event> events = eventManager.searchEventsByLocation(location);
        displaySearchResults(events, "No events found in this location.");
    }

    private void displaySearchResults(List<Event> events, String noResultsMessage) {
        if (events.isEmpty()) {
            System.out.println(noResultsMessage);
        } else {
            for (Event event : events) {
                event.displayEventDetails();
            }
        }
    }

    /**
     * Manages participants by allowing the admin to add, modify, or delete participants.
     */
    private void manageParticipants() {
        System.out.println("1. add participant");
        System.out.println("2. Modify Participant");
        System.out.println("3. Delete Participant");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                String name = Validation.validateStringInput(scanner, "Name");
                String email = Validation.validateEmail(scanner);
                String phoneNumber = Validation.validateStringInput(scanner, "Phone Number");

                participantManager.addParticipant(new Participant( name, email, phoneNumber));
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
    /**
     * Validates and returns an event ID input by the user.
     *
     * @return A valid positive event ID.
     */
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
    /**
     * Validates and returns a participant ID input by the user.
     *
     * @return A valid positive participant ID.
     */
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
        scanner.nextLine();
        return participantId;
    }


}
