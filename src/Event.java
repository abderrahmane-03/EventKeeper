package src;
import java.util.Date;
import java.util.ArrayList;

public class Event {
    private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private String eventType;
    private ArrayList<Participant> participants;

    public Event(int eventId, String eventName, Date eventDate, String eventLocation, String eventType) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventType = eventType;
        this.participants = new ArrayList<>();
    }

    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public Date getEventDate() { return eventDate; }
    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }


    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }

    public void removeParticipant(Participant participant) {
        this.participants.remove(participant);
    }

    public ArrayList<Participant> getParticipants() {
        return this.participants;
    }


    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Location: " + eventLocation);
        System.out.println("Event Type: " + eventType);
        System.out.println("Participants: ");
        for (Participant p : participants) {
            System.out.println("- " + p.getName()); 
            
        }
    }
}
