package org.example.services;

import org.example.models.Notification;

public interface CommentNotificationProxy {
    void sendNotification(Notification notification);
}
