package Class;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Login {
    protected String mailAddress;
    protected String password;
    public ArrayList<String> result;

    public Login() {};

    public Login(String mailAddress, String password) throws IOException {
        this.mailAddress = mailAddress;
        this.password = password;
        this.result = this.CheckValidUser(this.mailAddress, this.password);
    }

    public ArrayList<String> CheckValidUser(String mail, String ps) throws IOException {
        ArrayList<String> values = new ArrayList<>();
        try {
            File usersFile = new File("users.txt");

            Scanner SC = new Scanner(usersFile);


            while (SC.hasNextLine()) {
                String Line = SC.nextLine();
                String emailInLine = Line.split(" ")[0];
                String passwordInLine = Line.split(" ")[1];
                String isCommittee = Line.split(" ")[3];
                if (mail.equals(emailInLine) && ps.equals(passwordInLine)) {
                    if(isCommittee.equals("Yes")) {
                        values.add("Committee");
                        values.add(emailInLine);

                        return values;
                    }
                    if(isCommittee.equals("No")) {
                        values.add("Citizen");
                        values.add(emailInLine);

                        return values;
                    }
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        values.add("cannot find this people");

        return values;
    }
}