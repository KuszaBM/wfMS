package org.kusza.api.core.project;

public class Project {
    private final int projectId;
    private final String clientName;
    private final String projectName;

    public Project(int projectId, String clientName, String projectName) {
        this.projectId = projectId;
        this.clientName = clientName;
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProjectName() {
        return projectName;
    }
}
