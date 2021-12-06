package Class;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class VaccinationStatusSearch {
    public VaccinationStatusSearch(){};

    public void StatusSearch(String x){
        try {
            File mainFile = new File("center.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mainFile));
            String currentLine;
            String total = "";
            while ((currentLine = reader.readLine()) != null) {
                String[] CenterArray = currentLine.split(" ");
                if (CenterArray[0].equals(x) ||
                        CenterArray[1].equals(x) ||
                        CenterArray[2].equals(x)) {
                    String Line = "VenueName: " + CenterArray[0] + " Date: " + CenterArray[1] +
                            " Number Of People Taken: " + CenterArray[3] + "/" + CenterArray[2];
                    total = total.concat(Line + "\n");

                }
            }
            JOptionPane.showMessageDialog(null, total);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
