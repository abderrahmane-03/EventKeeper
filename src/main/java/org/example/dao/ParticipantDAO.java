/**
 * The ParticipantDAO class provides data access operations for managing participants in the application.
 * It handles the addition, modification, deletion, and retrieval of participant data, as well as managing
 * participant registrations.
 *
 * Package: org.example.dao
 */
package org.example.dao;

import org.example.entities.Participant;
import org.example.entities.Registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The ParticipantDAO class manages the data access operations for the Participant entity.
 */
public class ParticipantDAO {

    private final Map<UUID, Participant> participantMap = new HashMap<>();

    private final ArrayList<Participant> participants;

    /**
     * Constructor to initialize the participant list.
     */
    public ParticipantDAO() {
        participants = new ArrayList<>();
    }

    /**
     * Adds a participant to the participant list.
     *
     * @param participant The participant to be added.
     */
    public void addParticipant(Participant participant) {
        participants.add(participant);
        System.out.println("Participant added successfully with ID: " + participant.getParticipantId());
    }

    /**
     * Modifies the details of an existing participant based on the participant ID.
     *
     * @param participantId The ID of the participant to be modified.
     * @param newName The new name of the participant.
     * @param newEmail The new email of the participant.
     * @param newPhoneNumber The new phone number of the participant.
     */
    public void modifyParticipant(UUID participantId, String newName, String newEmail, String newPhoneNumber) {
        participants.stream()
                .filter(participant -> participant.getParticipantId().equals(participantId))
                .findFirst()
                .ifPresentOrElse(participant -> {
                    participant.setName(newName);
                    participant.setEmail(newEmail);
                    participant.setPhoneNumber(newPhoneNumber);
                    System.out.println("Participant modified successfully.");
                }, () -> System.out.println("Participant not found."));
    }


    /**
     * Deletes a participant from the participant list based on the participant ID.
     *
     * @param participantId The ID of the participant to be deleted.
     */
    public void deleteParticipant(UUID participantId) {
        for (Participant participant : participants) {
            if (participant.getParticipantId().equals(participantId)) {
                participants.remove(participant);
                System.out.println("Participant deleted successfully.");
                return;
            }
        }
        System.out.println("Participant not found.");
    }

    /**
     * Finds a participant by their name.
     *
     * @param name The name of the participant to search for.
     * @return The participant with the specified name, or null if not found.
     */
    public Participant findByName(String name) {
        for (Participant participant : participants) {
            if (participant.getName().equalsIgnoreCase(name)) {
                return participant;
            }
        }
        return null;
    }

    /**
     * Retrieves all participants from the participant list.
     *
     * @return A list of all participants.
     */
    public ArrayList<Participant> getAllParticipants() {
        return participants;
    }

    /**
     * Adds a registration to a participant based on their UUID.
     *
     * @param participantId The UUID of the participant to add the registration to.
     * @param registration The registration to be added.
     */
    public void addRegistrationToParticipant(UUID participantId, Registration registration) {
        Participant participant = participantMap.get(participantId);
        if (participant != null) {
            participant.addRegistration(registration);
        }
    }
}
