package org.example.entities;

import org.example.enums.UserRole;

public class User {
    private int userId;
    private String userName;
    private UserRole role;

    public User(int userId, String userName, UserRole role) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
    }

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

    public boolean isParticipant() {
        return role == UserRole.PARTICIPANT;
    }

    public boolean hasPermission(String permission) {
        // Example permission handling logic:
        if (role == UserRole.ADMIN) {
            return true;  // Admin has all permissions
        } else if (role == UserRole.PARTICIPANT) {
            return permission.equals("VIEW_EVENTS") || permission.equals("REGISTER_EVENT");
        }
        return false;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public UserRole getRole() { return role; }

    public void setRole(UserRole role) { this.role = role; }


    public void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Role: " + role);
    }
}


