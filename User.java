public class User {
    private String userID;
    private String password;

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
}
