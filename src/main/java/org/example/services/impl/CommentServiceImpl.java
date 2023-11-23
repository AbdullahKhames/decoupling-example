package org.example.services.impl;

import org.example.mappers.NotificationMapper;
import org.example.models.Comment;
import org.example.models.Notification;
import org.example.reposirtory.CommentRepository;
import org.example.proxies.CommentNotificationProxy;
import org.example.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("fileCommentService")
@Qualifier("fileCommentService")
public class CommentServiceImpl implements CommentService {
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    private final NotificationMapper notificationMapper;
    @Autowired
    public CommentServiceImpl(@Qualifier("pushCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy,
                              @Qualifier("fileCommentRepository") CommentRepository commentRepository,
                              NotificationMapper notificationMapper) {
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
        this.notificationMapper = notificationMapper;
    }
    @Override
    public void publishComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment can't be null");
        }
        commentRepository.saveComment(comment);
        Notification notification = notificationMapper.mapToNotification(comment);
        commentNotificationProxy.sendNotification(notification);
    }
}
