package com.vnicers.todo.repository;

import com.vnicers.todo.model.ToDoItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class ToDoRepositoryImpl implements ToDoRepository {
    private AtomicLong currentId = new AtomicLong();

    private ConcurrentMap<Long, ToDoItem> todos = new ConcurrentHashMap<>();

    @Override
    public List<ToDoItem> listAll() {
        final List<ToDoItem> values = new ArrayList<>(this.todos.values());
        Collections.sort(values);
        return values;
    }

    @Override
    public ToDoItem getById(long id) {
        return this.todos.get(id);
    }

    @Override
    public void remove(long id) {
        this.todos.remove(id);
    }

    @Override
    public void remove(ToDoItem toDoItem) {
        this.todos.remove(toDoItem.getId());
    }

    @Override
    public void update(ToDoItem toDoItem) {
        this.todos.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public long save(ToDoItem toDoItem) {
        final long id = currentId.incrementAndGet();
        toDoItem.setId(id);
        this.todos.putIfAbsent(id, toDoItem);
        return id;
    }
}
