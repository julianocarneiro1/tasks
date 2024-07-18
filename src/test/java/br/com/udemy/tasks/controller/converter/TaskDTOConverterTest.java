package br.com.udemy.tasks.controller.converter;

import br.com.udemy.tasks.controller.dto.TaskDTO;
import br.com.udemy.tasks.model.Task;
import br.com.udemy.tasks.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskDTOConverterTest {

    @InjectMocks
    private TaskDTOConverter converter;

    @Test
    void converter_mustReturnTaskDTO_whenInputTask() {
        Task task = TestUtils.buildValidTask();

        TaskDTO dto = converter.convert(task);

        assertEquals(dto.getId(), task.getId());
        assertEquals(dto.getTitle(), task.getTitle());
        assertEquals(dto.getDescription(), task.getDescription());
        assertEquals(dto.getPriority(), task.getPriority());
        assertEquals(dto.getState(), task.getState());
    }

    @Test
    void converter_mustReturnTask_whenInputTaskDTO() {
        TaskDTO dto = TestUtils.buildValidTaskDTO();

        Task task = converter.convert(dto);

        assertEquals(task.getId(), dto.getId());
        assertEquals(task.getTitle(), dto.getTitle());
        assertEquals(task.getDescription(), dto.getDescription());
        assertEquals(task.getPriority(), dto.getPriority());
        assertEquals(task.getState(), dto.getState());
    }

    @Test
    void converter_mustReturnTask_whenInputParameters() {
        Task task = TestUtils.buildValidTask();

        Task builder = converter.convert(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getState()
        );

        assertEquals(builder.getId(), task.getId());
        assertEquals(builder.getTitle(), task.getTitle());
        assertEquals(builder.getDescription(), task.getDescription());
        assertEquals(builder.getPriority(), task.getPriority());
        assertEquals(builder.getState(), task.getState());
    }
}
