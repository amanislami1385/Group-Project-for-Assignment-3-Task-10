package edu.aitu.oop3.components.Task.repositories;

import java.util.List;

public interface Repository<T> {
    void save(T item);
    List<T> findAll();
}