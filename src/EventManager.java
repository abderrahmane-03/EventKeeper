package src;
import java.util.ArrayList;
import java.util.Date;

public class EventManager {
    private ArrayList<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event added successfully.");
    }

    public void modifyEvent(int eventId, String newName, Date newDate, String newLocation, String newType) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                event.setEventName(newName);
                event.setEventDate(newDate);
                event.setEventLocation(newLocation);
                event.setEventType(newType);
                System.out.println("Event modified successfully.");
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public void deleteEvent(int eventId) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                events.remove(event);
                System.out.println("Event deleted successfully.");
                return;
            }
        }
        System.out.println("Event not found.");
    }

    public ArrayList<Event> searchEventsByDate(Date date) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }

    public ArrayList<Event> searchEventsByLocation(String location) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventLocation().equalsIgnoreCase(location)) {
                result.add(event);
            }
        }
        return result;
    }

    public ArrayList<Event> searchEventsByType(String type) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventType().equalsIgnoreCase(type)) {
                result.add(event);
            }
        }
        return result;
    }
    public ArrayList<Event> getAllEvents() {
        return events;
    }
}
