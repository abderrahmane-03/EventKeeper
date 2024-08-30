package src;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        User currentUser = login(scanner);

        while (true) {
            System.out.println("=== Event Management System ===");
            if (currentUser.isAdmin()) {
                System.out.println("1. Add Event");
                System.out.println("2. Modify Event");
                System.out.println("3. Delete Event");
                System.out.println("4. Generate Reports");
                System.out.println("5. Manage Users");
            } else if (currentUser.isParticipant()) {
                System.out.println("1. View Events");
                System.out.println("2. Register for Event");
                System.out.println("3. View My Registrations");
            }
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            if (currentUser.isAdmin()) {
                handleAdminActions(choice, scanner, eventManager, dateFormat);
            } else if (currentUser.isParticipant()) {
                handleParticipantActions(choice, scanner, eventManager);
            }
        }
    }

    private static User login(Scanner scanner) {
        System.out.println("Welcome! Please log in.");
        System.out.print("Enter your user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        String role;
        while (true) {
            System.out.print("Are you an Admin or Participant? ");
            role = scanner.nextLine();
            if (role.equalsIgnoreCase("Admin") || role.equalsIgnoreCase("Participant")) {
                break;
            } else {
                System.out.println("Invalid role. Please enter either 'Admin' or 'Participant'.");
            }
        }

        return new User(userId, userName, role);
    }

    private static void handleAdminActions(int choice, Scanner scanner, EventManager eventManager, SimpleDateFormat dateFormat) {
        switch (choice) {
            case 1:
                int eventId = validateEventId(scanner);
                String eventName = ValidationUtils.validateStringInput(scanner, "Event Name");
                Date eventDate = ValidationUtils.validateDate(scanner);
                String eventLocation = ValidationUtils.validateStringInput(scanner, "Event Location");
                String eventType = ValidationUtils.validateStringInput(scanner, "Event Type");

                Event newEvent = new Event(eventId, eventName, eventDate, eventLocation, eventType);
                eventManager.addEvent(newEvent);
                break;

            case 2:
                modifyEvent(scanner, eventManager, dateFormat);
                break;

            case 3:
                deleteEvent(scanner, eventManager);
                break;

            case 4:
                System.out.println("Generating reports... (this feature can be further implemented)");
                break;

            case 5:
                System.out.println("Managing users... (this feature can be further implemented)");
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

    private static void handleParticipantActions(int choice, Scanner scanner, EventManager eventManager) {
        switch (choice) {
            case 1:
                eventManager.getAllEvents().forEach(Event::displayEventDetails);
                break;

            case 2:
                registerForEvent(scanner, eventManager);
                break;

            case 3:
                System.out.println("Viewing your registrations... (this feature can be further implemented)");
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

    private static int validateEventId(Scanner scanner) {
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

    private static void modifyEvent(Scanner scanner, EventManager eventManager, SimpleDateFormat dateFormat) {
        
        int modifyId = validateEventId(scanner);
        String newName = ValidationUtils.validateStringInput(scanner, "New Event Name");
        Date newDate = ValidationUtils.validateDate(scanner);
        String newLocation = ValidationUtils.validateStringInput(scanner, "New Event Location");
        String newType = ValidationUtils.validateStringInput(scanner, "New Event Type");

        eventManager.modifyEvent(modifyId, newName, newDate, newLocation, newType);
    }

    private static void deleteEvent(Scanner scanner, EventManager eventManager) {
       int deleteId = validateEventId(scanner);
        eventManager.deleteEvent(deleteId);
    }

    private static void registerForEvent(Scanner scanner, EventManager eventManager) {
        
        int eventId = validateEventId(scanner);
        System.out.println("Registering for event ID: " + eventId);
        }
}
