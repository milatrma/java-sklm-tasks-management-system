package sk.skillmea.task_management_system.service.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddRequest {
    private String name;
    private String email;
}

