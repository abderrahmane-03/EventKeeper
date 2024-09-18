/**
 * The Event class represents an event in the application.
 * It contains details such as the event's ID, name, date, location, type,
 * and a list of participants attending the event.
 *
 * Package: org.example.entities
 */
package org.example.entities;

import org.example.enums.EventType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The Event class models an event entity with attributes like ID, name, date,
 * location, type, and participants. It provides methods to access and modify
 * these attributes, as well as to display event details.
 */
public class Event {

    // Unique identifier for the event
    private UUID eventId;

    // Name of the event
    private String eventName;

    // Date of the event
    private Date eventDate;

    // Location of the event
    private String eventLocation;

    // Type of the event
    private EventType eventType;

    // List of participants attending the event
    private List<Participant> participants;

    /**
     * Constructor to initialize the event with specific details.
     *
     * @param eventId The unique identifier of the event.
     * @param eventName The name of the event.
     * @param eventDate The date of the event.
     * @param eventLocation The location of the event.
     * @param eventType The type of the event.
     */
    public Event(UUID eventId, String eventName, Date eventDate, String eventLocation, EventType eventType) {
        this.eventId = UUID.randomUUID();
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventType = eventType;
        this.participants = new ArrayList<>();
    }

    /**
     * Default constructor.
     */
    public Event() { }

    /**
     * Gets the event ID.
     *
     * @return The unique identifier of the event.
     */
    public UUID getEventId() {
        return eventId;
    }

    /**
     * Sets the event ID.
     *
     * @param eventId The unique identifier to set for the event.
     */
    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    /**
     * Gets the event name.
     *
     * @return The name of the event.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the event name.
     *
     * @param eventName The name to set for the event.
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets the event date.
     *
     * @return The date of the event.
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * Sets the event date.
     *
     * @param eventDate The date to set for the event.
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * Gets the event location.
     *
     * @return The location of the event.
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * Sets the event location.
     *
     * @param eventLocation The location to set for the event.
     */
    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    /**
     * Gets the event type.
     *
     * @return The type of the event.
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * Sets the event type.
     *
     * @param eventType The type to set for the event.
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    /**
     * Gets the number of participants attending the event.
     *
     * @return The number of participants.
     */
    public int getNumberOfParticipants() {
        return participants != null ? participants.size() : 0;
    }

    /**
     * Gets the list of participants attending the event.
     *
     * @return The list of participants.
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     * Displays the event details, including ID, name, date, location, type,
     * and the number of participants.
     */
    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Location: " + eventLocation);
        System.out.println("Event Type: " + eventType);
        System.out.println("Number of Participants: " + getNumberOfParticipants());
        System.out.println("=========================");
    }
}
