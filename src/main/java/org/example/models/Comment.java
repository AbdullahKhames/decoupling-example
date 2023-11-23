package org.example.models;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String comment;
    private String author;
    private LocalDateTime datePosted;
    public Comment() {

    }

    public Comment( String comment, String author, LocalDateTime datePosted) {
        this.comment = comment;
        this.author = author;
        this.datePosted = datePosted;
    }

    // constructor to create an object of type Comment using the CommentBuilder
    public Comment(CommentBuilder commentBuilder) {
        this.id = commentBuilder.id;
        this.comment = commentBuilder.comment;
        this.author = commentBuilder.author;
        this.datePosted = commentBuilder.datePosted;
    }
    // static method to create an object of type CommentBuilder
    // this method is called from the outer class
    // static factory method that returns an instance of the CommentBuilder
    // eg Comment.CommentBuilder builder = Comment.builder();
    // instead of Comment.CommentBuilder builder = new Comment.CommentBuilder();
    public static CommentBuilder builder() {
        return new CommentBuilder();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }



    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", author='" + author + '\'' +
                ", datePosted=" + datePosted +
                '}';
    }

    // static inner class CommentBuilder
    // this class is used to construct the object of type Comment
    // it has exactly the same set of fields as the outer class
    // it has a build method that returns the object of type Comment
    // to implement the builder pattern using the static builder class
    public static class CommentBuilder {
        private int id;
        private String comment;
        private String author;
        private LocalDateTime datePosted;

        public CommentBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CommentBuilder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public CommentBuilder author(String author) {
            this.author = author;
            return this;
        }

        public CommentBuilder datePosted(LocalDateTime datePosted) {
            this.datePosted = datePosted;
            return this;
        }

        // build method to construct the object of type Comment
        // using the constructor of the outer class
        // that takes the CommentBuilder object as a parameter
        public Comment build() {
//            Comment comment = new Comment();
//            comment.setId(this.id);
//            comment.setComment(this.comment);
//            comment.setAuthor(this.author);
//            comment.setDatePosted(this.datePosted);
//            return comment;
            return new Comment(this);
        }
    }
}
