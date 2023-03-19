import java.util.ArrayList;
import java.util.List;

public class FYPCoordinator {
    
    // Attributes
    private List<Supervisor> supervisors;
    private List<Student> students;
    private List<Project> projects;
    
    // Constructor
    public FYPCoordinator(List<Supervisor> supervisors, List<Student> students, List<Project> projects) {
        this.supervisors = supervisors;
        this.students = students;
        this.projects = projects;
    }
    
    // Getters and setters
    public List<Supervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
    // Methods
    
    // Change supervisor of a project upon request
    public void changeProjectSupervisor(int projectID, int supervisorID) {
        for (Project project : projects) {
            if (project.getProjectID() == projectID) {
                for (Supervisor supervisor : supervisors) {
                    if (supervisor.getSupervisorID() == supervisorID) {
                        project.setSupervisor(supervisor);
                        System.out.println("Project supervisor changed successfully!");
                        return;
                    }
                }
            }
        }
        System.out.println("Project or supervisor not found.");
    }
    
    // Allocate a project to a student upon request
    public void allocateProject(int projectID, int studentID) {
        for (Project project : projects) {
            if (project.getProjectID() == projectID) {
                if (project.getStatus() == Status.AVAILABLE) {
                    for (Student student : students) {
                        if (student.getStudentID() == studentID) {
                            project.setStudent(student);
                            project.setStatus(Status.ALLOCATED);
                            System.out.println("Project allocated successfully!");
                            return;
                        }
                    }
                } else {
                    System.out.println("Project is not available.");
                }
            }
        }
        System.out.println("Project or student not found.");
    }
    
    // Deregister a student from FYP by changing the studentID of the allocated project to be empty
    public void deregisterStudent(int studentID) {
        for (Project project : projects) {
            if (project.getStudent() != null && project.getStudent().getStudentID() == studentID) {
                project.setStudent(null);
                project.setStatus(Status.AVAILABLE);
                System.out.println("Student deregistered successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
    
    // View all available, unavailable, reserved and allocated projects
    public void viewAllProjects() {
        for (Project project : projects) {
            System.out.println(project);
        }
    }
    
    // Generate project details report according to searching filters, e.g., status, or supervisor
    public List<Project> generateProjectDetailsReport(Status status, int supervisorID) {
        List<Project> report = new ArrayList<>();
        for (Project project : projects) {
            if ((status == null || project.getStatus() == status)
                    && (supervisorID == -1 || (project.getSupervisor() != null && project.getSupervisor().getSupervisorID() == supervisorID))) {
                report.add(project);
            }
        }
        return report;
    }
