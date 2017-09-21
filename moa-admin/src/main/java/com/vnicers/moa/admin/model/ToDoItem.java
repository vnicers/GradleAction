package com.vnicers.moa.admin.model;

import lombok.Data;

@Data
public class ToDoItem implements Comparable<ToDoItem> {
    private Long id;
    private String name;
    private Boolean completed;

    @Override
    public int compareTo(ToDoItem o) {
        return (int) (this.getId() - o.getId());
    }
}
