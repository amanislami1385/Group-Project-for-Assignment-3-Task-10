package edu.aitu.oop3.components.Notification;

public class NotificationCenter {
    private static NotificationCenter instance;
    private boolean enabled = true;

    private NotificationCenter() {}

    public static synchronized NotificationCenter getInstance() {
        if (instance == null) {
            instance = new NotificationCenter();
        }
        return instance;
    }

    public void send(String message) {
        if (enabled) {
            System.out.println("[ALERT]: " + message);
        }
    }

    public void toggle() {
        enabled = !enabled;
        System.out.println("Notifications are now " + (enabled ? "ON" : "OFF"));
    }
}
