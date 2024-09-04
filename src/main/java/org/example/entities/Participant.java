/**
 * The Participant class represents a participant in the application.
 * It contains details such as the participant's ID, name, email, phone number,
 * and a list of registrations associated with the participant.
 *
 * Package: org.example.entities
 */
package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The Participant class models a participant entity with attributes like ID,
 * name, email, phone number, and registrations. It provides methods to access
 * and modify these attributes, as well as to display participant details.
 */
public class Participant {

    // Unique identifier for the participant
    private UUID participantId;

    // Name of the participant
    private String name;

    // Email of the participant
    private String email;

    // Phone number of the participant
    private String phoneNumber;

    // List of registrations associated with the participant
    private final List<Registration> registrations;

    /**
     * Constructor to initialize the participant with specific details.
     *
     * @param name The name of the participant.
     * @param email The email of the participant.
     * @param phoneNumber The phone number of the participant.
     */
    public Participant(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrations = new ArrayList<>();
    }

    /**
     * Gets the participant ID.
     *
     * @return The unique identifier of the participant.
     */
    public UUID getParticipantId() {
        return participantId;
    }

    /**
     * Sets the participant ID.
     *
     * @param participantId The unique identifier to set for the participant.
     */
    public void setParticipantId(UUID participantId) {
        this.participantId = participantId;
    }

    /**
     * Gets the participant's name.
     *
     * @return The name of the participant.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the participant's name.
     *
     * @param name The name to set for the participant.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the participant's email.
     *
     * @return The email of the participant.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the participant's email.
     *
     * @param email The email to set for the participant.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the participant's phone number.
     *
     * @return The phone number of the participant.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the participant's phone number.
     *
     * @param phoneNumber The phone number to set for the participant.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the list of registrations associated with the participant.
     *
     * @return The list of registrations.
     */
    public List<Registration> getRegistrations() {
        return registrations;
    }

    /**
     * Adds a registration to the participant's list of registrations.
     *
     * @param registration The registration to add.
     */
    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
    }

    /**
     * Displays the participant's details, including ID, name, email, and phone number.
     */
    public void displayParticipantDetails() {
        System.out.println("Participant ID: " + participantId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
