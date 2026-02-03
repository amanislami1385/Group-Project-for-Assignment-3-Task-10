package edu.aitu.oop3.components.Task.utilities;

import edu.aitu.oop3.components.Task.entities.Task;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class TaskFilter<T extends Task> {

    public List<T> filter(List<T> items, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}