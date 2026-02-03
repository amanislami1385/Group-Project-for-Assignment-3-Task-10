package edu.aitu.oop3.components.Task.controllers;
import edu.aitu.oop3.components.Task.entities.Comment;
import edu.aitu.oop3.components.Task.services.CommentService;

public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public void addComment(Comment comment) {
        try {
            commentService.addComment(comment);
            System.out.println("Comment added successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}