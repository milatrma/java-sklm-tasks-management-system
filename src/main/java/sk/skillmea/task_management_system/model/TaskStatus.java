package sk.skillmea.task_management_system.model;

public enum TaskStatus {
    NEW,
    DONE;

    public static TaskStatus fromString(String status) {
        return switch (status) {
            case "NEW" -> NEW;
            case "DONE" -> DONE;
            default ->throw new IllegalStateException("Unknown task status :" + status);
        };
    };
}
