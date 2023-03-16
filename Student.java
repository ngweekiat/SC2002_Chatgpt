import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String name;
    private String email;
    private String studentID;
    private Project registeredProject;
    private List<Request> requests;

    public Student(String name, String email, String studentID) {
        super(studentID);
        this.name = name;
        this.email = email;
        this.studentID = studentID;
        this.registeredProject = null;
        this.requests = new ArrayList<>();
    }

    @Override
    public String getType() {
        return "student";
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

    public void requestProjectAllocation(Project project) {
        Request request = new Request(this, project.getSupervisor(), "project allocation", project);
        this.requests.add(request);
        project.addRequest(request);
    }

    public void requestTitleChange(Project project, String newTitle) {
        Request request = new Request(this, project.getSupervisor(), "title change", project);
        request.setMessage(newTitle);
        this.requests.add(request);
        project.addRequest(request);
    }

    public void requestDeregistration(Project project) {
        Request request = new Request(this, project.getSupervisor(), "deregistration", project);
        this.requests.add(request);
        project.addRequest(request);
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRegisteredProject(Project registeredProject) {
        this.registeredProject = registeredProject;
    }

    public Project getRegisteredProject() {
        return registeredProject;
    }
}
