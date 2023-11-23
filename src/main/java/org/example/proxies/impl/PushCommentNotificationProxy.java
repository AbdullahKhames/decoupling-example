package org.example.proxies.impl;

import org.example.models.Notification;
import org.example.proxies.CommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("pushCommentNotificationProxy")
public class PushCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Sending notification to push service");
    }
}
