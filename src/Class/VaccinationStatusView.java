package Class;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VaccinationStatusView {
    public VaccinationStatusView(){}
    public void StatusView(){
        try {
            File centerFile = new File("center.txt");
            BufferedReader centersReader = new BufferedReader(new FileReader(centerFile));
            String CentersCurrentLine;
            String total = "";
            while ((CentersCurrentLine = centersReader.readLine()) != null) {
                String[] CenterArray = CentersCurrentLine.split(" ");
                String Line = "VenueName: " + CenterArray[0] +
                        " Date: " + CenterArray[1] +
                        " Number Of People Taken: " + CenterArray[3] + "/" + CenterArray[2];
                total = total.concat(Line + "\n");

            }
            JOptionPane.showMessageDialog(null, total);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}