package br.com.udemy.tasks.messaging;

import br.com.udemy.tasks.model.Task;
import br.com.udemy.tasks.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TaskNotificationConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskNotificationConsumer.class);

    private final TaskService taskService;

    public TaskNotificationConsumer(TaskService taskService) {
        this.taskService = taskService;
    }

    @KafkaListener(topics = "${kafka.task.notification.output}", groupId = "${kafka.task.notification.group.id}")
    public void receiveAndFinishTask(Task task) {
        Mono.just(task)
                .doOnNext(it -> LOGGER.info("Receiving task to finish with id {}", task.getId()))
                .flatMap(taskService::done)
                .doOnNext(it -> LOGGER.info("Done. Id: {}", task.getId()))
                .subscribe(); // block(executa um por vez) - subscribe (executa em paralelo)
    }
}
