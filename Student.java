import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String name;
    private String email;
    private String studentId;
    private Project registeredProject;
    private List<Request> requestHistory;

    public Student(String userId, String password, String name, String email, String studentId) {
        super(userId, password);
        this.name = name;
        this.email = email;
        this.studentId = studentId;
        this.registeredProject = null;
        this.requestHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentId() {
        return studentId;
    }

    public Project getRegisteredProject() {
        return registeredProject;
    }

    public void setRegisteredProject(Project registeredProject) {
        this.registeredProject = registeredProject;
    }

    public List<Request> getRequestHistory() {
        return requestHistory;
    }

    public void addRequestToHistory(Request request) {
        this.requestHistory.add(request);
    }

    public void requestProjectAllocation(Project project, FYPCoordinator coordinator) {
        coordinator.allocateProject(this, project);
    }

    public void requestProjectDeregistration(FYPCoordinator coordinator) {
        coordinator.deregisterProject(this);
    }

    public void requestTitleChange(String newTitle, Supervisor supervisor) {
        supervisor.approveTitleChange(this.registeredProject, newTitle);
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId='" + this.getUserId() + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
