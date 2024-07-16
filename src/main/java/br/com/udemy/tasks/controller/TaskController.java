package br.com.udemy.tasks.controller;

import br.com.udemy.tasks.controller.converter.TaskDTOConverter;
import br.com.udemy.tasks.controller.dto.TaskDTO;
import br.com.udemy.tasks.model.Task;
import br.com.udemy.tasks.service.TaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    private final TaskDTOConverter converter;

    public TaskController(TaskService taskService,
                          TaskDTOConverter converter) {
        this.taskService = taskService;
        this.converter = converter;
    }

    @GetMapping
    public Mono<List<TaskDTO>> getTasks() {
        return taskService.list()
                .map(converter::convertList);
    }

    @PostMapping
    public Mono<TaskDTO> createTask(@RequestBody Task task) {
        return taskService.insert(task)
                .map(converter::convert);
    }
}
