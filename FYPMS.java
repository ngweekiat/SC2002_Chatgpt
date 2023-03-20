import java.util.Scanner;

public class FYPMS {
    public static void main(String[] args) {

        User[] student_users = {
                new User("CHERN", "YCHERN@e.ntu.edu.sg", "password"),
                new User("KOH", "KOH1@e.ntu.edu.sg", "password"),
                new User("BRANDON", "BR015@e.ntu.edu.sg", "password"),
                new User("CALVIN", "CT113@e.ntu.edu.sg", "password"),
                new User("CHAN", "YCN019@e.ntu.edu.sg", "password"),
                new User("DENISE", "DL007@e.ntu.edu.sg", "password"),
                new User("DONG", "DON84@e.ntu.edu.sg", "password"),
                new User("ERNEST", "ELI34@e.ntu.edu.sg", "password"),
                new User("LEE", "LE51@e.ntu.edu.sg", "password"),
                new User("LIU", "SL22@e.ntu.edu.sg", "password"),
                new User("RAWAL", "AKY013@e.ntu.edu.sg", "password")
        };

        // Create User object to access the login function
        User user_var = new User("UserID", "Emailaddress", "Password");
        // Login users
        while(true){
            user_var = user_var.login(student_users);  
            user_var.passwordChange(student_users);

        }

    }
}
