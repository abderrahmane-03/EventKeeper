package org.example.services;

import org.example.dao.EventDAO;
import org.example.entities.Event;
import org.example.enums.EventType;
import org.example.utils.Validation;

import java.util.Date;
import java.util.Scanner;

public class EventService {
    private final EventDAO eventManager;

    public EventService(EventDAO eventManager) {
        this.eventManager = eventManager;
    }

    // Handle Admin Actions
    public void handleAdminActions(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                String eventName = Validation.validateStringInput(scanner, "Event Name");
                Date eventDate = Validation.validateDate(scanner);
                String eventLocation = Validation.validateStringInput(scanner, "Event Location");
                EventType eventType = Validation.validateEventType(scanner);

                Event newEvent = new Event();
                newEvent.setEventName(eventName);
                newEvent.setEventDate(eventDate);
                newEvent.setEventLocation(eventLocation);
                newEvent.setEventType(eventType);

                eventManager.addEvent(newEvent);
                break;

            case 2:
                modifyEvent(scanner);
                break;

            case 3:
                deleteEvent(scanner);
                break;

            case 4:
                System.out.println("Generating reports...");
                break;

            case 5:
                System.out.println("Managing users...");
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

    // Modify Event
    private void modifyEvent(Scanner scanner) {
        int modifyId = validateEventId(scanner);
        String newName = Validation.validateStringInput(scanner, "New Event Name");
        Date newDate = Validation.validateDate(scanner);
        String newLocation = Validation.validateStringInput(scanner, "New Event Location");
        EventType newType = Validation.validateEventType(scanner);

        eventManager.modifyEvent(modifyId, newName, newDate, newLocation, newType);
    }

    // Delete Event
    private void deleteEvent(Scanner scanner) {
        int deleteId = validateEventId(scanner);
        eventManager.deleteEvent(deleteId);
    }

    // Validate Event ID
    private int validateEventId(Scanner scanner) {
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
}
