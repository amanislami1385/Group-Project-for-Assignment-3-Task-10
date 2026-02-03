package edu.aitu.oop3.components.Task.services;

import edu.aitu.oop3.components.Task.entities.Comment;
import edu.aitu.oop3.components.Task.repositories.CommentRepository;

import java.sql.SQLException;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment) throws SQLException {
        commentRepository.save(comment);
    }
}