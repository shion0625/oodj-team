package people;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import Class.OverrideOfFile;

import javax.swing.*;

public class Program {
    private People PeopleObject;
    private String email;
    public Program() {}
    public Program(String email) {
        this.email = email;
    }
    public void Register(){
            OverrideOfFile override = new OverrideOfFile(this.email,"users.txt",6,"YES");
            boolean result = override.Override();
            if(result) {
                JOptionPane.showMessageDialog(null, "success register");
            }else {
                JOptionPane.showMessageDialog(null, "failed");
            }
    }

    public void Change(){
        try{
            File usersFile = new File("users.txt");
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                String[] UsersArray = currentLine.split(" ");
                if(UsersArray[0].equals(this.email)) {
                    if(UsersArray[6].equals("YES")) {
                        UsersArray[6] = "NO";
                    }else if(UsersArray[6].equals("NO")) {
                        UsersArray[6] = "YES";
                    }else {
                        JOptionPane.showMessageDialog(null, "Have not registered");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "change to " + UsersArray[6]);
                    String UserString = String.join(" ", UsersArray);
                    writer.write(UserString);
                    writer.write("\n");
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            boolean successful = tempFile.renameTo(usersFile);
            if(successful) {
                JOptionPane.showMessageDialog(null, "success change");
            }else {
                JOptionPane.showMessageDialog(null, "fail change");
            }
        } catch (IOException ex){}
    }
    public void View() {
        try{
            File usersFile = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String currentLine;
            String total = "";
            while ((currentLine = reader.readLine()) != null) {
                String[] UsersArray = currentLine.split(" ");
                if (UsersArray[0].equals(this.email)) {
                    String Line = "Name: " + UsersArray[2] +"\nEmail: "+
                            UsersArray[0] +"\nprogram subscribe: " +UsersArray[4];
                    total = total.concat(Line + "\n");
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, total);
        } catch (IOException ex){}
    }
}
