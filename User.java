public abstract class User {
    protected String userID;
    protected String password;

    public User(String userID, String password) {
        this.userID = userID;
        this.password = "password";
    }

    public void login(String password) {
        if(password == this.password){
            this.authenticated = 1;
            System.out.println("You have logged in successfully");
        else
            System.out.println("Wrong password, please try again");
        return;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public abstract String getType();

    public String getUserID() {
        return userID;
    }
}
