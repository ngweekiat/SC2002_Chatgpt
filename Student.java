import java.util.ArrayList;
import java.util.List;


public class Student extends User {
    private String name;
    private String email;
    private String studentID;
    private Project registeredProject;
    private List<Request> requestHistory;

    public Student(String name, String email, String studentID) {
        super(studentID.split("@")[0], "password");
        this.name = name;
        this.email = email;
        this.studentID = studentID;
        this.requestHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentID() {
        return studentID;
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

    public void selectProject(Project project) {
        // Check if the student has not already registered a project
        if (registeredProject == null) {
            // Check if the project is available
            if (project.getStatus() == ProjectStatus.AVAILABLE) {
                // Reserve the project and add it to the student's registered project
                project.setStatus(ProjectStatus.RESERVED);
                registeredProject = project;
            } else {
                throw new RuntimeException("Project is not available");
            }
        } else {
            throw new RuntimeException("Student has already registered a project");
        }
    }

    public void requestTitleChange(String newTitle) {
        // Check if the student has already registered a project
        if (registeredProject != null) {
            // Create a new request to change the project title
            TitleChangeRequest request = new TitleChangeRequest(registeredProject, newTitle);
            // Add the request to the project and the student's request history
            registeredProject.addRequest(request);
            requestHistory.add(request);
        } else {
            throw new RuntimeException("Student has not registered a project");
        }
    }

    public void requestDeregistration() {
        // Check if the student has already registered a project
        if (registeredProject != null) {
            // Create a new request to deregister the project
            DeregistrationRequest request = new DeregistrationRequest(registeredProject);
            // Add the request to the project and the student's request history
            registeredProject.addRequest(request);
            requestHistory.add(request);
        } else {
            throw new RuntimeException("Student has not registered a project");
        }
    }
}
