package org.example.dao;

import org.example.entities.Event;
import org.example.enums.EventType;

import java.util.ArrayList;
import java.util.Date;

public class EventDAO {
    private final ArrayList<Event> events;
    private int eventIdCounter;

    public EventDAO() {
        events = new ArrayList<>();
        eventIdCounter = 1;  // Start the counter from 1
    }

    // Add Event
    public void addEvent(Event event) {
        event.setEventId(eventIdCounter);
        events.add(event);
        eventIdCounter++;
        System.out.println("Event added successfully with ID: " + event.getEventId());
    }

    // Modify Event
    public void modifyEvent(int eventId, String newName, Date newDate, String newLocation, EventType newType) {
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

    // Delete Event
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

    // Search Events by Date
    public ArrayList<Event> searchEventsByDate(Date date) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }

    // Search Events by Location
    public ArrayList<Event> searchEventsByLocation(String location) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventLocation().equalsIgnoreCase(location)) {
                result.add(event);
            }
        }
        return result;
    }

    // Search Events by Type
    public ArrayList<Event> searchEventsByType(EventType type) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventType().equals(type)) {
                result.add(event);
            }
        }
        return result;
    }

    // Get All Events
    public ArrayList<Event> getAllEvents() {
        return events;
    }
}
