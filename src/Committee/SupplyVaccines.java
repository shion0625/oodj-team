package Committee;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import Class.OverrideOfFile;

import Class.*;

import javax.swing.*;


public class SupplyVaccines {

    public SupplyVaccines() {
    }

    public void Add(String name, String date, String num) {
        try {

            File centerFile = new File("center.txt");
            FileWriter Fw = new FileWriter(centerFile, true);
            Fw.write(name + " " + date + " " + num + " 0");
            Fw.write("\n");
            Fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Remove(String name, String date) {

        try {
            File mainFile = new File("center.txt");
            File tempFile = new File("centerTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(mainFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] CenterArray = currentLine.split(" ");
                if (CenterArray[0].equals(name) && CenterArray[1].equals(date)) {
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            boolean successful = tempFile.renameTo(mainFile);
            if (successful) {
                JOptionPane.showMessageDialog(null, "deleted!");
            } else {
                JOptionPane.showMessageDialog(null, "failed");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Modify(String changeName, String changeDate, String name, String date, String num) {
        try {
            File centerFile = new File("center.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(centerFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));

            boolean successful = false;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String Line = currentLine;
                String[] centerArr = Line.split(" ");
                boolean flag = false;
                if (centerArr[0].equals(changeName)) {
                    if(centerArr[1].equals(changeDate)) {
                        if (name !=null) {
                            centerArr[0] = name;
                            flag = true;
                        }
                        if (date != null) {
                            centerArr[1] = date;
                            flag = true;
                        }
                        if (num != null) {
                            centerArr[2] = num;
                            flag = true;
                        }
                    }

                }
                if(flag) {
                    writer.write(String.join(" ", centerArr));
                    writer.write("\n");
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            successful = TempFile.renameTo(centerFile);
            if (successful) {
                JOptionPane.showMessageDialog(null, "successful");
            } else {
                JOptionPane.showMessageDialog(null, "something failed");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    public void View() {
        VaccinationStatusView vaccinationStatusView = new VaccinationStatusView();
        vaccinationStatusView.StatusView();
    }
    public void Search(String x){
        VaccinationStatusSearch vss = new VaccinationStatusSearch();
        vss.StatusSearch(x);
    }
}
