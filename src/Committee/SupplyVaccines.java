package Committee;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import Class.OverrideOfFile;



public class SupplyVaccines {
    private String email;

    public SupplyVaccines() {
    }

    public SupplyVaccines(String email) {
        this.email = email;
    }

    public void Add() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("please enter Name of Venue");
            String EnteredVenue = scan.nextLine();
            System.out.println("please enter date");
            String EnteredDate = scan.nextLine();
            System.out.println("please enter Number of people taken");
            String EnteredNumPerson = scan.nextLine();
            File centerFile = new File("center.txt");
            FileWriter Fw = new FileWriter(centerFile, true);
            Fw.write(EnteredVenue + " " + EnteredDate + " " + EnteredNumPerson);
            Fw.write("\n");
            Fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Remove() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter Name of Venue");
        String EnteredVenue = scan.nextLine();
        System.out.println("please enter date");
        String EnteredDate = scan.nextLine();
        try {
            File mainFile = new File("center.txt");
            File tempFile = new File("centerTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mainFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] CenterArray = currentLine.split(" ");
                if (CenterArray[0].equals(EnteredVenue) && CenterArray[1].equals(EnteredDate)) {
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            boolean successful = tempFile.renameTo(mainFile);
            if (successful) {
                System.out.println("delete id venue");
            } else {
                System.out.println("fail id venue");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Modify() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter Name of Venue");
        String EnteredVenue = scan.nextLine();
        System.out.println("" +
                "please enter change position\n" +
                "1) change venue name\n" +
                "2) change date\n" +
                "3) change Number of people taken");
        String EnteredNum = scan.nextLine();
        int choiceNum = Integer.parseInt(EnteredNum);
        System.out.println("Please enter the value");
        String EnteredValue = scan.nextLine();
        OverrideOfFile override = new OverrideOfFile(EnteredVenue, "center.txt", choiceNum - 1, EnteredValue);
        boolean result = override.Override();
    }
    public void View() {
        try {
            File centerFile = new File("center.txt");
            BufferedReader reader = new BufferedReader(new FileReader(centerFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] CenterArray = currentLine.split(" ");
                    System.out.println("VenueName: " + CenterArray[0] + " Date: " +
                            CenterArray[1] + " Number Of People Taken: " + CenterArray[2]+"\n");
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void Search(){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the value you wish to search for");
            String EnteredValue = scan.nextLine();
            File mainFile = new File("center.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mainFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] CenterArray = currentLine.split(" ");
                if (CenterArray[0].equals(EnteredValue) ||
                        CenterArray[1].equals(EnteredValue) ||
                        CenterArray[2].equals(EnteredValue)) {
                    System.out.println(currentLine);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
