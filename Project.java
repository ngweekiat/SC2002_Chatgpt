public class Project {
    private static int nextProjectId = 1;
    private int projectId;
    private String supervisorName;
    private String supervisorEmail;
    private String studentName;
    private String studentEmail;
    private String projectTitle;
    private ProjectStatus status;

    public Project(String supervisorName, String supervisorEmail, String projectTitle) {
        this.projectId = nextProjectId++;
        this.supervisorName = supervisorName;
        this.supervisorEmail = supervisorEmail;
        this.projectTitle = projectTitle;
        this.status = ProjectStatus.AVAILABLE;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public String getSupervisorEmail() {
        return supervisorEmail;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
