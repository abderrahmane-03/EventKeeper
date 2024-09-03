package org.example.dao;

import org.example.entities.Participant;

import java.util.ArrayList;

public class ParticipantDAO {
    private final ArrayList<Participant> participants;
    private int participantIdCounter;

    public ParticipantDAO() {
        participants = new ArrayList<>();
        participantIdCounter = 1;
    }

    public void addParticipant(Participant participant) {
        participant.setParticipantId(participantIdCounter);
        participants.add(participant);
        participantIdCounter++;
        System.out.println("Participant added successfully with ID: " + participant.getParticipantId());
    }

    public void modifyParticipant(int participantId, String newName, String newEmail, String newPhoneNumber) {
        for (Participant participant : participants) {
            if (participant.getParticipantId() == participantId) {
                participant.setName(newName);
                participant.setEmail(newEmail);
                participant.setPhoneNumber(newPhoneNumber);
                System.out.println("Participant modified successfully.");
                return;
            }
        }
        System.out.println("Participant not found.");
    }

    public void deleteParticipant(int participantId) {
        for (Participant participant : participants) {
            if (participant.getParticipantId() == participantId) {
                participants.remove(participant);
                System.out.println("Participant deleted successfully.");
                return;
            }
        }
        System.out.println("Participant not found.");
    }

    public ArrayList<Participant> getAllParticipants() {
        return participants;
    }

    public Participant findParticipantById(int participantId) {
        for (Participant participant : participants) {
            if (participant.getParticipantId() == participantId) {
                return participant;
            }
        }
        return null;
    }
}
