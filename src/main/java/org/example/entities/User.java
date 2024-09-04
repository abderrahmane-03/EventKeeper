/**
 * The User class represents a user in the application.
 * It contains details such as the user's ID, name, role, and a list of
 * registrations associated with the user.
 *
 * Package: org.example.entities
 */
package org.example.entities;

import org.example.enums.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The User class models a user entity with attributes like ID, name, role,
 * and a list of registrations. It provides methods to access and modify
 * these attributes, check the user's role, and display user details.
 */
public class User {

    // Unique identifier for the user
    private UUID userId;

    // Name of the user
    private String userName;

    // Role of the user (e.g., ADMIN, PARTICIPANT)
    private UserRole role;

    // List of registrations associated with the user
    private List<Registration> registrations = new ArrayList<>();

    /**
     * Constructor to initialize the user with specific details.
     *
     * @param userId The unique identifier of the user.
     * @param userName The name of the user.
     * @param role The role of the user (ADMIN or PARTICIPANT).
     */
    public User(UUID userId, String userName, UserRole role) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
    }

    /**
     * Checks if the user has an Admin role.
     *
     * @return true if the user is an Admin, false otherwise.
     */
    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

    /**
     * Checks if the user has a Participant role.
     *
     * @return true if the user is a Participant, false otherwise.
     */
    public boolean isParticipant() {
        return role == UserRole.PARTICIPANT;
    }

    /**
     * Gets the user ID.
     *
     * @return The unique identifier of the user.
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The unique identifier to set for the user.
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Gets the user's name.
     *
     * @return The name of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user's name.
     *
     * @param userName The name to set for the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user's role.
     *
     * @return The role of the user (ADMIN or PARTICIPANT).
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the user's role.
     *
     * @param role The role to set for the user (ADMIN or PARTICIPANT).
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets the list of registrations associated with the user.
     *
     * @return The list of registrations.
     */
    public List<Registration> getRegistrations() {
        return registrations;
    }

    /**
     * Adds a registration to the user's list of registrations.
     *
     * @param registration The registration to add.
     */
    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
    }

    /**
     * Displays the user's details, including ID, name, and role.
     */
    public void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Role: " + role);
    }
}
