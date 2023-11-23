package org.example.mappers.impl;

import org.example.mappers.NotificationMapper;
import org.example.models.Comment;
import org.example.models.Notification;

public class NotificationMapperImpl implements NotificationMapper {
    @Override
    public Notification mapToNotification(Comment comment) {
        return Notification.builder()
                .message(comment.toString())
                .build();
    }
}
