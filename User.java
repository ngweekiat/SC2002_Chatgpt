// public abstract class User {
//     protected String userID;
//     protected String password;
//     protected int authenticated;

//     public User(String userID, String password) {
//         this.userID = userID;
//         this.password = "password";
//     }

//     public void login(String password) {
//         if(password == this.password){
//             this.authenticated = 1;
//             System.out.println("You have logged in successfully");
//         else
//             System.out.println("Wrong password, please try again");
//         return;
//         }
//     }

//     public void changePassword(String newPassword) {
//         this.password = newPassword;
//     }

//     public abstract String getType();

//     public String getUserID() {
//         return userID;
//     }
// }

import java.util.Scanner;
public class User {
    private String username;
    private String email;
    private String password;
    Scanner scanner = new Scanner(System.in);

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public User login(User[] dataset){
        // Login Function()
        System.out.println("Welcome to the login page");

        while (true) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            boolean foundUser = false;

            for (User user : dataset) {
                // If username matches 
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Welcome, " + user.getUsername() + "!");
                    foundUser = true;
                    return user;
                }
            }

            if (!foundUser) {
                System.out.println("Invalid username or password. Please try again.");
            } else {
                // Return null if not found
                return null;
            }
        }
    }

    public User[] passwordChange(User[] dataset){
        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();
        this.password = newPassword;

        System.out.println("Password for user " + username + " updated.");
        
        //-------------Debugging code-----------------------
        for (int i = 0; i < dataset.length; i++) {
            System.out.println("User " + (i+1) + ": " + dataset[i].getUsername() + " (" + dataset[i].getEmail() + ")"+ " (" + dataset[i].getPassword() + ")");
        }
        //-------------Debugging code-----------------------

        return dataset;
    }
}




