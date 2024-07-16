package br.com.udemy.tasks.model;

import br.com.udemy.tasks.service.TaskService;

public class Task {

    private String title;

    private String description;

    private int priority;

    private TaskState state;

    public Task() {
    }

    public Task(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        this.state = builder.state;
    }

    public Task newTask() {
        TaskService.taskList.add(this);
        return this;
    }

    public Task insert() {
        return builderFrom(this)
                .withState(TaskState.INSERT)
                .build();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public TaskState getState() {
        return state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderFrom(Task task) {
        return new Builder(task);
    }

    public static class Builder {

        private String title;

        private String description;

        private int priority;

        private TaskState state;

        public Builder() {
        }

        public Builder(Task task) {
            this.title = task.title;
            this.description = task.description;
            this.priority = task.priority;
            this.state = task.state;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder withState(TaskState state) {
            this.state = state;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
