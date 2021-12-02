package Class;

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
            while ((CentersCurrentLine = centersReader.readLine()) != null) {
                String[] CenterArray = CentersCurrentLine.split(" ");
                    System.out.println("" +
                            "VenueName: " + CenterArray[0] +
                            " Date: " + CenterArray[1] +
                            " Number Of People Taken: " + CenterArray[3] + "/" + CenterArray[2]);
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
