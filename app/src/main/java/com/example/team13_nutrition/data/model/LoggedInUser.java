package com.example.team13_nutrition.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private static String userId;
    private String displayName;

    public LoggedInUser(String userId, String displayName) {
        LoggedInUser.userId = userId;
        this.displayName = displayName;
    }

    public static String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}
