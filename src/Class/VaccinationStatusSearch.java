package Class;

import java.io.*;
import java.util.Scanner;

public class VaccinationStatusSearch {
    public VaccinationStatusSearch(){}
    public void StatusSearch(){
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
                    System.out.println("" +
                            "VenueName: " + CenterArray[0] +
                            " Date: " + CenterArray[1] +
                            " Number Of People Taken: " + CenterArray[3] + "/" + CenterArray[2]);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
