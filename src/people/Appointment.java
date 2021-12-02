package people;

import java.io.*;
import java.util.Scanner;

public class Appointment {
    private String email;
    public Appointment(){}
    public Appointment(String email){
        this.email = email;
    }
    public void Register(){
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("enter venue");
            String enteredVenue = scan.nextLine();
            System.out.println("enter dateeee");
            String enteredDate = scan.nextLine();

            File usersFile = new File("users.txt");
            File tempFile = new File("temp.txt");
            File centersFile = new File("center.txt");
            File centersTempFile = new File("centersTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            BufferedReader centersReader = new BufferedReader(new FileReader(centersFile));
            BufferedWriter centersWriter = new BufferedWriter(new FileWriter(centersTempFile));

            String currentLine;
            boolean successful = false;
            boolean isExist = false;
            while((currentLine = centersReader.readLine()) != null){
                String[] centersArray = currentLine.split(" ");
                if(centersArray[0].equals(enteredVenue) &&
                        centersArray[1].equals(enteredDate) &&
                        Integer.parseInt(centersArray[2])  > Integer.parseInt(centersArray[3])
                ){
                    int current_num = Integer.parseInt(centersArray[3]) + 1;
                    centersArray[3] = String.valueOf(current_num);
                    String CenterString = String.join(" ", centersArray);
                    centersWriter.write(CenterString);
                    centersWriter.write("\n");
                    isExist = true;
                    continue;
                }
                centersWriter.write(currentLine);
                centersWriter.write("\n");
            }
            centersWriter.close();
            successful = centersTempFile.renameTo(centersFile);
            if(isExist) {
                while ((currentLine = reader.readLine()) != null){
                    String[] UsersArray = currentLine.split(" ");
                    if(UsersArray[0].equals(this.email)) {
                        UsersArray[4] = enteredDate;
                        UsersArray[5] = enteredVenue;
                        String UserString = String.join(" ", UsersArray);
                        writer.write(UserString);
                        writer.write("\n");
                        continue;
                    }
                    writer.write(currentLine);
                    writer.write("\n");
                }
                writer.close();
                successful = tempFile.renameTo(usersFile);
            }
            if(successful) {
                System.out.println("success vaccination appointment register");
            }else {
                System.out.println("fail vaccination appointment register");
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void Cancel(){
        try{
            File usersFile = new File("users.txt");
            File tempFile = new File("temp.txt");
            File centersFile = new File("center.txt");
            File centersTempFile = new File("centersTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            BufferedReader centersReader = new BufferedReader(new FileReader(centersFile));
            BufferedWriter centersWriter = new BufferedWriter(new FileWriter(centersTempFile));
            String currentLine;
            boolean successful = false;
            while ((currentLine = reader.readLine()) != null){
                String[] UsersArray = currentLine.split(" ");
                if(UsersArray[0].equals(this.email)) {
                    String CentersCurrentLine;
                    while((CentersCurrentLine = centersReader.readLine())!= null){
                        String[] centersArray = CentersCurrentLine.split(" ");
                        if(centersArray[0].equals(UsersArray[5]) &&
                                centersArray[1].equals(UsersArray[4])){
                            centersArray[3] = String.valueOf(Integer.parseInt(centersArray[3]) -1);
                            String CenterString = String.join(" ", centersArray);
                            centersWriter.write(CenterString);
                            centersWriter.write("\n");
                            continue;
                        }
                        centersWriter.write(CentersCurrentLine);
                        centersWriter.write("\n");
                    }
                    centersWriter.close();
                    successful = centersTempFile.renameTo(centersFile);
                    UsersArray[4] = "NULL";
                    UsersArray[5] = "NULL";
                    String UserString = String.join(" ", UsersArray);
                    writer.write(UserString);
                    writer.write("\n");
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            successful = tempFile.renameTo(usersFile);
            if(successful) {
                System.out.println("success vaccination appointment cancel");
            }else {
                System.out.println("fail vaccination appointment cancel");
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void View(){
        try{
            File usersFile = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] UsersArray = currentLine.split(" ");
                if (UsersArray[0].equals(this.email)) {
                    System.out.println("" +
                            "Name: " + UsersArray[2] +
                            "\nEmail: "+ UsersArray[0] +
                            "\nprogram subscribe: " +UsersArray[3] +
                            "\nvaccination appointment date: "+ UsersArray[4] +
                            "\nVenue name: "+ UsersArray[5]);
                    break;
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
