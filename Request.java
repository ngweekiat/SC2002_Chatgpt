public class Request {
    private String senderId;
    private String receiverId;
    private String projectId;
    private String message;
    private boolean isApproved;
    
    public Request(String senderId, String receiverId, String projectId, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.projectId = projectId;
        this.message = message;
        this.isApproved = false;
    }
    
    public String getSenderId() {
        return senderId;
    }
    
    public String getReceiverId() {
        return receiverId;
    }
    
    public String getProjectId() {
        return projectId;
    }
    
    public String getMessage() {
        return message;
    }
    
    public boolean isApproved() {
        return isApproved;
    }
    
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
