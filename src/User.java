package src;
public class User {
    private int userId;
    private String userName;
    private String role;

    public User(int userId, String userName, String role) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return "Admin".equalsIgnoreCase(role);
    }

    public boolean isParticipant() {
        return "Participant".equalsIgnoreCase(role);
    }


    public void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Role: " + role);
    }
}
