package sk.skillmea.task_management_system.model;

import java.time.OffsetDateTime;

public class Project {
    private final long id;
    private final long userId;
    private final String name;
    private final String description;
    private final OffsetDateTime createdAt;


    public Project(long id, long userId, String name, String description, OffsetDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
