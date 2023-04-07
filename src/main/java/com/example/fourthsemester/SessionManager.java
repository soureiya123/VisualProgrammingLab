package com.example.fourthsemester;

public class SessionManager {
    private UserSession currentSession;

    public UserSession getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(UserSession session) {
        this.currentSession = session;
    }
}
