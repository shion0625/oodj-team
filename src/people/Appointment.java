package people;

import javax.swing.*;
import java.io.*;

public class Appointment {
    private String email;
    public Appointment(){}
    public Appointment(String email){
        this.email = email;
    }
    public void Register(String venue, String date){
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
            boolean isExist = false;
            while((currentLine = centersReader.readLine()) != null){
                String[] centersArray = currentLine.split(" ");
                if(centersArray[0].equals(venue) &&
                        centersArray[1].equals(date) &&
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
            if(!isExist) {
                JOptionPane.showMessageDialog(null, "doesn't match this date or venue");
            }
                while ((currentLine = reader.readLine()) != null){
                    String[] UsersArray = currentLine.split(" ");
                    if(UsersArray[0].equals(this.email)) {
                        UsersArray[4] = date;
                        UsersArray[5] = venue;
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
                JOptionPane.showMessageDialog(null, "success register");
            }else {
                JOptionPane.showMessageDialog(null, "failed");
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
                JOptionPane.showMessageDialog(null, "success vaccination appointment cancel");
            }else {
                JOptionPane.showMessageDialog(null, "fail vaccination appointment cancel");
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void View(){
        try{
            System.out.println("Line");
            File usersFile = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String currentLine;
            String total = "";
            while ((currentLine = reader.readLine()) != null) {
                String[] UsersArray = currentLine.split(" ");
                if (UsersArray[0].equals(this.email)) {
                    String Line = "Name: " + UsersArray[2] +
                            "\nEmail: "+ UsersArray[0] +
                            "\nprogram subscribe: " +UsersArray[3] +
                            "\nvaccination appointment date: "+ UsersArray[4] +
                            "\nVenue name: "+ UsersArray[5];

                    total = total.concat(Line + "\n");
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, total);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
