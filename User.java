public abstract class User {
    protected String userID;
    protected String password;

    public User(String userID) {
        this.userID = userID;
        this.password = "password";
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public abstract String getType();

    public String getUserID() {
        return userID;
    }
}
