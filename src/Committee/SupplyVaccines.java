package Committee;

import java.io.*;
import java.util.Scanner;
import Class.OverrideOfFile;



public class SupplyVaccines {
    private String email;
    public SupplyVaccines() {}
    public SupplyVaccines(String email) { this.email = email; }

    public void Add() {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("please enter Name of Venue");
            String EnteredVenue = scan.nextLine();
            System.out.println("please enter Name of date");
            String EnteredDate = scan.nextLine();
            System.out.println("please enter Name of Number of people taken");
            String EnteredNumPerson = scan.nextLine();
            OverrideOfFile override = new OverrideOfFile();
            File mainFile = new File("center.txt");
            File tempFile = new File("centerTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mainFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] UsersArray = currentLine.split(" ");
                if (UsersArray[0].equals(this.email)) {
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
            boolean successful = tempFile.renameTo(mainFile);
            if (successful) {
                System.out.println("success vaccination appointment register");
            } else {
                System.out.println("fail vaccination appointment register");
            }
        } catch (IOException ex){}
    }
}
