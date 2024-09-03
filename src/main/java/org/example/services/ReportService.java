package org.example.services;

import org.example.dao.EventDAO;
import org.example.dao.ParticipantDAO;
import org.example.entities.Event;
import org.example.entities.Participant;

public class ReportService {
    private final EventDAO eventDAO;
    private final ParticipantDAO participantDAO;

    public ReportService(EventDAO eventDAO, ParticipantDAO participantDAO) {
        this.eventDAO = eventDAO;
        this.participantDAO = participantDAO;
    }

    public void generateEventReport() {
        System.out.println("=== Event Report ===");
        for (Event event : eventDAO.getAllEvents()) {
            event.displayEventDetails();
            System.out.println("----------------------");
        }
    }

    public void generateParticipantReport() {
        System.out.println("=== Participant Report ===");
        for (Participant participant : participantDAO.getAllParticipants()) {
            participant.displayParticipantDetails();
            System.out.println("----------------------");
        }
    }
}
