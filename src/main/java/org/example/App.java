package org.example;

import org.example.mappers.impl.NotificationMapperImpl;
import org.example.models.Comment;
import org.example.reposirtory.impl.CommentRepositoryImpl;
import org.example.services.CommentService;
import org.example.services.impl.CommentNotificationProxyImpl;
import org.example.services.impl.CommentServiceImpl;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CommentService commentService = new CommentServiceImpl(
                new CommentNotificationProxyImpl(),
                new CommentRepositoryImpl(),
                new NotificationMapperImpl()
        );
        commentService.publishComment(
                Comment.builder()
                        .author("John Doe")
                        .comment("Hello World!")
                        .datePosted(LocalDateTime.now())
                        .build());
    }
}
