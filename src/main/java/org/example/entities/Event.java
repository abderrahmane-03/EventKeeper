package org.example.entities;

import org.example.enums.EventType;
import java.util.Date;

public class Event {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private EventType eventType;

    // Constructor
    public Event(int eventId, String eventName, Date eventDate, String eventLocation, EventType eventType) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventType = eventType;
    }

    // Default Constructor
    public Event() { }

    // Getters and Setters
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public Date getEventDate() { return eventDate; }
    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public EventType getEventType() { return eventType; }
    public void setEventType(EventType eventType) { this.eventType = eventType; }

    // Display Event Details
    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Location: " + eventLocation);
        System.out.println("Event Type: " + eventType);
    }
}
