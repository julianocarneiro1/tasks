package br.com.udemy.tasks.model;

import br.com.udemy.tasks.service.TaskService;

public class Task {

    private String title;

    private String description;

    private int priority;

    private TaskState state;

    public Task newTask() {
        TaskService.taskList.add(this);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }
}
