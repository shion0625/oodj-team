package people;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import Class.OverrideOfFile;

public class Program {
    private People PeopleObject;
    private String email;
    public Program() {}
    public Program(String email) {
        this.email = email;
    }
    public void Register(){
            OverrideOfFile override = new OverrideOfFile(this.email,"users.txt",4,"YES");
            boolean result = override.Override();
            if(result) {
                System.out.println("success register");
            }else {
                System.out.println("fail register");
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
                    if(UsersArray[4].equals("YES")) {
                        UsersArray[4] = "NO";
                    }else if(UsersArray[4].equals("NO")) {
                        UsersArray[4] = "YES";
                    }else {
                        System.out.println("Have not registered");
                        return;
                    }
                    System.out.println("change to " + UsersArray[4]);
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
                System.out.println("success change");
            }else {
                System.out.println("fail change");
            }
        } catch (IOException ex){}
    }
    public void View() {
        try{
            File usersFile = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] UsersArray = currentLine.split(" ");
                if (UsersArray[0].equals(this.email)) {
                    System.out.println("Name: " + UsersArray[2] +"\nEmail: "+
                            UsersArray[0] +"\nprogram subscribe: " +UsersArray[4]);
                    break;
                }
            }
        } catch (IOException ex){}
    }
}
