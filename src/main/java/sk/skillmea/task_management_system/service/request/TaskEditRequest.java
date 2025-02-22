package sk.skillmea.task_management_system.service.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.skillmea.task_management_system.model.TaskStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEditRequest {

    private String name;
    private String description;
    private TaskStatus status;

}
