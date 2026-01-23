package services;

import entities.Comment;
import repositories.CommentRepository;

import java.sql.SQLException;

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment) throws SQLException {
        commentRepository.save(comment);
    }
}dd