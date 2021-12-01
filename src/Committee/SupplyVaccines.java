package Committee;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

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
            File centerFile = new File("center.txt");
            FileWriter Fw = new FileWriter(centerFile, true);
            BufferedReader reader = new BufferedReader(new FileReader(centerFile));
            String currentLine;
            int i = 0;
            while ((currentLine = reader.readLine()) != null) {
                i++;
            }
            String lines = String.valueOf(i);
            Fw.write("\n" + lines+" "+ EnteredVenue +" "+ EnteredDate + " " + EnteredNumPerson);
            Fw.write("\n");
            Fw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
