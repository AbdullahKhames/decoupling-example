package org.example.reposirtory.impl;

import org.example.models.Comment;
import org.example.reposirtory.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fileCommentRepository")
public class FileCommentRepository implements CommentRepository {
    @Override
    public void saveComment(Comment comment) {
        System.out.println("Saving comment to file");
    }

    @Override
    public Comment getCommentById(int id) {
        return null;
    }

    @Override
    public void printComments() {

    }
}
