/**
 * The Registration class represents a registration for an event in the application.
 * It contains details about the event and the date of registration.
 *
 * Package: org.example.entities
 */
package org.example.entities;

import java.util.Date;

/**
 * The Registration class models a registration entity that links a participant
 * to an event. It provides methods to access and modify the event and
 * registration date, as well as to retrieve specific event details like name,
 * date, and location.
 */
public class Registration {

    // The event associated with this registration
    private Event event;

    // The date when the registration was made
    private Date registrationDate;

    /**
     * Constructor to initialize the registration with specific details.
     *
     * @param event The event for which the registration is made.
     * @param registrationDate The date of the registration.
     */
    public Registration(Event event, Date registrationDate) {
        this.event = event;
        this.registrationDate = registrationDate;
    }

    /**
     * Gets the event associated with the registration.
     *
     * @return The event.
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Sets the event associated with the registration.
     *
     * @param event The event to associate with the registration.
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Gets the date of the registration.
     *
     * @return The registration date.
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the date of the registration.
     *
     * @param registrationDate The date to set for the registration.
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Gets the name of the event associated with the registration.
     *
     * @return The name of the event.
     */
    public String getEventName() {
        return event.getEventName();
    }

    /**
     * Gets the date of the event associated with the registration.
     *
     * @return The date of the event.
     */
    public Date getEventDate() {
        return event.getEventDate();
    }

    /**
     * Gets the location of the event associated with the registration.
     *
     * @return The location of the event.
     */
    public String getEventLocation() {
        return event.getEventLocation();
    }
}
