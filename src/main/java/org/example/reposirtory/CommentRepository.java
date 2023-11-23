package org.example.reposirtory;

import org.example.models.Comment;

public interface CommentRepository {
    void saveComment(Comment comment);

    Comment getCommentById(int id);

    void printComments();
}
