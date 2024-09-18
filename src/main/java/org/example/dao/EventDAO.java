package org.example.dao;

import org.example.entities.Event;
import org.example.enums.EventType;

import java.util.*;

public class EventDAO {

    private final Map<UUID, Event> eventMap = new HashMap<>();

    /**
     * Adds an event to the event map.
     *
     * @param event The event to be added.
     */
    public void addEvent(Event event) {
        eventMap.put(event.getEventId(), event);
        System.out.println("Event added: " + event.getEventId());
    }

    /**
     * Modifies the details of an existing event based on the event ID.
     *
     * @param eventId The ID of the event to be modified.
     * @param newName The new name of the event.
     * @param newDate The new date of the event.
     * @param newLocation The new location of the event.
     * @param newType The new type of the event.
     */
    public void modifyEvent(UUID eventId, String newName, Date newDate, String newLocation, EventType newType) {
        Event event = eventMap.get(eventId);
        if (event != null) {
            event.setEventName(newName);
            event.setEventDate(newDate);
            event.setEventLocation(newLocation);
            event.setEventType(newType);
            System.out.println("Event modified successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    /**
     * Deletes an event from the event map based on the event ID.
     *
     * @param eventId The ID of the event to be deleted.
     */
    public void deleteEvent(UUID eventId) {
        if (eventMap.remove(eventId) != null) {
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    /**
     * Retrieves an event by its ID from the event map.
     *
     * @param eventId The ID of the event to retrieve.
     * @return The event with the specified ID, or null if not found.
     */
    public Event findById(UUID eventId) {
        return eventMap.get(eventId);
    }

    /**
     * Searches for events that occur on a specific date.
     *
     * @param date The date to search for events.
     * @return A list of events that occur on the specified date.
     */
    public List<Event> searchEventsByDate(Date date) {
        List<Event> result = new ArrayList<>();
        for (Event event : eventMap.values()) {
            if (isSameDay(event.getEventDate(), date)) {
                result.add(event);
            }
        }
        return result;
    }

    /**
     * Searches for events that are located at a specific location.
     *
     * @param location The location to search for events.
     * @return A list of events that occur at the specified location.
     */
    public List<Event> searchEventsByLocation(String location) {
        List<Event> result = new ArrayList<>();
        for (Event event : eventMap.values()) {
            if (event.getEventLocation().equalsIgnoreCase(location)) {
                result.add(event);
            }
        }
        return result;
    }

    /**
     * Searches for events of a specific type.
     *
     * @param type The type of events to search for.
     * @return A list of events of the specified type.
     */
    public List<Event> searchEventsByType(EventType type) {
        List<Event> result = new ArrayList<>();
        for (Event event : eventMap.values()) {
            if (event.getEventType().equals(type)) {
                result.add(event);
            }
        }
        return result;
    }

    /**
     * Retrieves all events from the event map.
     *
     * @return A list of all events.
     */
    public List<Event> getAllEvents() {
        return new ArrayList<>(eventMap.values());
    }

    /**
     * Helper method to check if two dates fall on the same day.
     *
     * @param date1 The first date.
     * @param date2 The second date.
     * @return true if the dates are on the same day, false otherwise.
     */
    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}
