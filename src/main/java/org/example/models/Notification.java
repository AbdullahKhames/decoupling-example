package org.example.models;

public class Notification {
    private int id;
    private String message;

    public Notification() {
    }

    public Notification(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Notification(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Notification(NotificationBuilder notificationBuilder) {
        this.id = notificationBuilder.id;
        this.message = notificationBuilder.message;
    }
    public static NotificationBuilder builder() {
        return new NotificationBuilder();
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

    public static class NotificationBuilder {
        private int id;
        private String message;

        public NotificationBuilder id(int id) {
            this.id = id;
            return this;
        }

        public NotificationBuilder message(String message) {
            this.message = message;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
