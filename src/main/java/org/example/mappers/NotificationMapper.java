package org.example.mappers;

import org.example.models.Comment;
import org.example.models.Notification;

public interface NotificationMapper {

    public Notification mapToNotification(Comment comment);

}
