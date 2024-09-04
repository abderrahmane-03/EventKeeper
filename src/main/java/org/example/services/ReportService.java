/**
 * The ReportService class is responsible for generating reports related to events.
 * It retrieves event data from the EventDAO and displays it to the user.
 *
 * Package: org.example.services
 */
package org.example.services;

import org.example.dao.EventDAO;
import org.example.entities.Event;

/**
 * ReportService class handles the generation of event reports.
 *
 * It uses the EventDAO to fetch all events and displays their details.
 */
public class ReportService {
    private final EventDAO eventDAO;

    /**
     * Constructor for ReportService.
     *
     * @param eventDAO The EventDAO object used for fetching event data.
     */
    public ReportService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    /**
     * Generates and displays a report of all events.
     * The report includes the details of each event.
     */
    public void generateEventReport() {
        System.out.println("=== Event Report ===");
        for (Event event : eventDAO.getAllEvents()) {
            event.displayEventDetails();
            System.out.println("----------------------");
        }
    }
}
