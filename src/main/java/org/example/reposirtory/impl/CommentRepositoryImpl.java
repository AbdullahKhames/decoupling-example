package org.example.reposirtory.impl;

import org.example.config.ConnectionProvider;
import org.example.models.Comment;
import org.example.reposirtory.CommentRepository;

import java.sql.*;

public class CommentRepositoryImpl implements CommentRepository {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;



    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println("Error closing connection");
        }
    }

    @Override
    public void saveComment(Comment comment) {
        try {
            connect = ConnectionProvider.getCon();
            if (connect == null) {
                System.out.println("Connection failed");
                return;
            }
            statement = connect.createStatement();
            int x  = statement.executeUpdate("INSERT INTO comments (comment, author, date_posted) VALUES ('" + comment.getComment() + "', '" + comment.getAuthor() + "', '" + comment.getDatePosted() + "')");
            System.out.println(x);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error in the query");
        } finally {
            close();
        }
    }
    @Override
    public Comment getCommentById(int id ) {
        if (id < 0) {
            return null;
        }

        try {
            String sql = "SELECT * FROM comments WHERE id = ?";
            connect = ConnectionProvider.getCon();
            if (connect == null) {
                System.out.println("Connection failed");
                return null;
            }
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
//                return new Comment.CommentBuilder()
//                        .id(resultSet.getInt("id"))
//                        .comment(resultSet.getString("comment"))
//                        .author(resultSet.getString("author"))
//                        .datePosted(resultSet.getTimestamp("date_posted").toLocalDateTime())
//                        .build();
                return Comment.builder()
//                        .id(resultSet.getInt("id"))
                        .comment(resultSet.getString("comment"))
                        .author(resultSet.getString("author"))
                        .datePosted(resultSet.getTimestamp("date_posted").toLocalDateTime())
                        .build();
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error in the query");
            return null;
        }
        finally {
            close();
        }
        return null;
    }
    @Override
    public void printComments(){
        try (Connection con = ConnectionProvider.getCon()) {
            if (con == null) {
                System.out.println("Connection failed");
                return;
            }
            try (Statement statement = con.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM comments")) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("comment") + " " + resultSet.getString("author") + " " + resultSet.getString("date_posted"));
                    }
                }
            }
        }

         catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error in the query");
        }
    }
}
