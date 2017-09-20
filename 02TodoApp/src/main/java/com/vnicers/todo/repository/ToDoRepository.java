package com.vnicers.todo.repository;

import com.vnicers.todo.model.ToDoItem;

import java.util.List;

public interface ToDoRepository {
    List<ToDoItem> listAll();

    ToDoItem getById(long id);

    void remove(long id);

    void remove(ToDoItem toDoItem);

    void update(ToDoItem toDoItem);

    long save(ToDoItem toDoItem);

}
