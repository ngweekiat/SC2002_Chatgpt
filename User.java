public abstract class User {
    protected String userID;
    protected String password;
    protected int authenticated;

    public User(String userID) {
        this.userID = userID;
        this.password = "password";
        this.authenticated = 0;
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
        if(this.authenticated == 1){
            this.password = newPassword;
            System.out.println("Your password has been successfully changed!");
        }
        else
            System.out.println("You are not authenticated! Please log in to change your password");
        return;
    }

    public String getUserID() {
        return userID;
    }
}
