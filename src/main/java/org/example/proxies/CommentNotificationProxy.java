package org.example.proxies;

import org.example.models.Notification;

public interface CommentNotificationProxy {
    void sendNotification(Notification notification);
}
