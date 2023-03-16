import java.util.ArrayList;
import java.util.List;

public class Supervisor extends User {
    private String name;
    private String email;
    private String supervisorID;
    private List<Project> projects;
    private List<Request> requests;

    public Supervisor(String name, String email, String supervisorID) {
        super(supervisorID);
        this.name = name;
        this.email = email;
        this.supervisorID = supervisorID;
        this.projects = new ArrayList<>();
        this.requests = new ArrayList<>();
    }

    @Override
    public String getType() {
        return "supervisor";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public void createProject(String title) {
        Project project = new Project(this, title);
        this.projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void approveTitleChange(Request request) {
        Project project = request.getProject();
        project.setTitle(request.getMessage());
        project.removeRequest(request);
        this.requests.remove(request);
    }

    public void transferStudent(Request request, Supervisor replacementSupervisor) {
        Project project = request.getProject();
        project.setSupervisor(replacementSupervisor);
        project.removeRequest(request);
        this.requests
