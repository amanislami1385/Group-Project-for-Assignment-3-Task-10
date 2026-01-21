package exceptions;

public class TaskWithoutProjectException extends Exception {
    public TaskWithoutProjectException(String message) { super(message); }
}