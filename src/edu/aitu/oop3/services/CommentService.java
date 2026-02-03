package edu.aitu.oop3.services;

import edu.aitu.oop3.entities.Comment;
import edu.aitu.oop3.repositories.CommentRepository;

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