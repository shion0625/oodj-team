package people;

import java.io.*;

public class Appointment {
    private String email;
    public Appointment(){}
    public Appointment(String email){
        this.email = email;
    }
    public void Register(){
        try{
            File usersFile = new File("users.txt");
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                String[] UsersArray = currentLine.split(" ");
                if(UsersArray[0].equals(this.email)) {
                    UsersArray[5] = "YES";
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
                System.out.println("success vaccination appointment register");
            }else {
                System.out.println("fail vaccination appointment register");
            }
        } catch (IOException ex){}
    }
    public void Cancel(){
        try{
            File usersFile = new File("users.txt");
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                String[] UsersArray = currentLine.split(" ");
                if(UsersArray[0].equals(this.email)) {
                    UsersArray[5] = "NO";
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
                System.out.println("success vaccination appointment cancel");
            }else {
                System.out.println("fail vaccination appointment cancel");
            }
        } catch (IOException ex){}
    }
    public void View(){
        try{
            File usersFile = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] UsersArray = currentLine.split(" ");
                if (UsersArray[0].equals(this.email)) {
                    System.out.println("Name: " + UsersArray[2] +"\nEmail: "+
                            UsersArray[0] +"\nprogram subscribe: " +UsersArray[4] +
                            "\nvaccination appointment date: "+ UsersArray[5]);
                    break;
                }
            }
        } catch (IOException ex){}
    }
}
