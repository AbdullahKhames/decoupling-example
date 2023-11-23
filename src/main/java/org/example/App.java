package org.example;

import org.example.config.SpringConfig;
import org.example.mappers.impl.NotificationMapperImpl;
import org.example.models.Comment;
import org.example.reposirtory.impl.CommentRepositoryImpl;
import org.example.services.CommentService;
import org.example.proxies.impl.CommentNotificationProxyImpl;
import org.example.services.impl.CommentServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        simpleComment();
        springCommentWithQualifier();
        springCommentWithPrimaryDI();
    }
    public static void simpleComment(){
        // example without using spring framework
        CommentService commentService = new CommentServiceImpl(
                new CommentNotificationProxyImpl(),
                new CommentRepositoryImpl(),
                new NotificationMapperImpl()
        );
        commentService.publishComment(
                Comment.builder()
                        .author("John Doe")
                        .comment("Hello World from non spring managed!")
                        .datePosted(LocalDateTime.now())
                        .build());
    }

    public static void springCommentWithQualifier(){
        // example without using spring framework
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CommentService commentService = context.getBean("fileCommentService", CommentService.class);
        commentService.publishComment(
                Comment.builder()
                        .author("John Doe")
                        .comment("Hello World from spring managed!")
                        .datePosted(LocalDateTime.now())
                        .build());
    }
    public static void springCommentWithPrimaryDI(){
        // example without using spring framework
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CommentService commentService = context.getBean("dbCommentService", CommentService.class);
        commentService.publishComment(
                Comment.builder()
                        .author("John Doe")
                        .comment("Hello World from spring managed!")
                        .datePosted(LocalDateTime.now())
                        .build());
    }
}
