import java.util.ArrayList;
import java.util.List;


public class Supervisor {
    private String supervisorID;
    private String name;
    private String email;
    private List<Project> projects;
    private int maxProjects = 2;

    public Supervisor(String supervisorID, String name, String email) {
        this.supervisorID = supervisorID;
        this.name = name;
        this.email = email;
        this.projects = new ArrayList<>();
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getMaxProjects() {
        return maxProjects;
    }

    public void setMaxProjects(int maxProjects) {
        this.maxProjects = maxProjects;
    }

    public void createProject(String projectTitle) {
        if (projects.size() >= maxProjects) {
            System.out.println("Cannot create more than " + maxProjects + " projects.");
            return;
        }
        Project project = new Project(this, projectTitle);
        projects.add(project);
        System.out.println("Project created with ID " + project.getProjectID() + ".");
    }

    public void viewProjects() {
        if (projects.isEmpty()) {
            System.out.println("No projects found.");
            return;
        }
        for (Project project : projects) {
            System.out.println("Project ID: " + project.getProjectID());
            System.out.println("Supervisor Name: " + name);
            System.out.println("Supervisor Email: " + email);
            System.out.println("Project Title: " + project.getProjectTitle());
            System.out.println("Project Status: " + project.getStatus());
        }
    }

    public void modifyProjectTitle(Project project, String newTitle) {
        if (!projects.contains(project)) {
            System.out.println("Project not found.");
            return;
        }
        project.setProjectTitle(newTitle);
        System.out.println("Project title modified.");
    }

    public void approveTitleChangeRequest(Student student, Project project, String newTitle) {
        if (!projects.contains(project)) {
            System.out.println("Project not found.");
            return;
        }
        if (!project.getStudent().equals(student)) {
            System.out.println("Student not assigned to project.");
            return;
        }
        project.setProjectTitle(newTitle);
        System.out.println("Title change request approved.");
    }

    public void transferStudent(Project project, Supervisor newSupervisor) {
        if (!projects.contains(project)) {
            System.out.println("Project not found.");
            return;
        }
        if (newSupervisor.getProjects().size() >= newSupervisor.getMaxProjects()) {
            System.out.println("New supervisor cannot take on more projects.");
            return;
        }
        project.setSupervisor(newSupervisor);
        newSupervisor.getProjects().add(project);
        projects.remove(project);
        System.out.println("Student transferred to new supervisor.");
    }

    public void viewRequests() {
        // implementation of viewing pending requests from students
    }

    public void approveRequest() {
        // implementation of approving student requests
    }

    public void rejectRequest() {
        // implementation of rejecting student requests
    }

    public void viewRequestHistory() {
        // implementation of viewing request history and status
    }
}
