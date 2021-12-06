package Class;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class VaccinationStatusSearch {
    public VaccinationStatusSearch(){};

    public void StatusSearch(String value){
        try {
            File mainFile = new File("center.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mainFile));
            String currentLine;
            String total = "";
            boolean is_exist = false;
            while ((currentLine = reader.readLine()) != null) {
                String[] CenterArray = currentLine.split(" ");
                if (CenterArray[0].equals(value) ||
                        CenterArray[1].equals(value) ||
                        CenterArray[2].equals(value)) {
                    String Line = "VenueName: " + CenterArray[0] + " Date: " + CenterArray[1] +
                            " Number Of People Taken: " + CenterArray[3] + "/" + CenterArray[2];
                    total = total.concat(Line + "\n");
                    is_exist = true;
                }
            }
            if(is_exist){
                JOptionPane.showMessageDialog(null, total);
            } else{
                JOptionPane.showMessageDialog(null, "Not a single hit was found for the entered ("+ value +").");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
