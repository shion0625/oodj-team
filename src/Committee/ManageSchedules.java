package Committee;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class ManageSchedules {
    public ManageSchedules(){};

    static void eliminateDuplicates(ArrayList<String> strings) {
        List<String> listA = new ArrayList<String>(strings);
        List<String> listB = new ArrayList<String>(new LinkedHashSet<>(listA));
        JOptionPane.showMessageDialog(null, listB);
    }

    public void AddSchedule(String mail, String date) throws IOException {
        try {
            Scanner SC = new Scanner(System.in);
            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));

            boolean successful = false;
            boolean success =false;
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] personArr = currentLine.split(" ");
                if (personArr[0].equals(mail)) {
                    if (personArr[4].equals("NULL")) {
                        personArr[4] = date;
                        writer.write(String.join(" ", personArr));
                        writer.write("\n");
                        success = true;
                        continue;
                    }

                }
                writer.write(currentLine);
                writer.write("\n");
            }
            if(!success) {
                JOptionPane.showMessageDialog(null, "not found");
            }
            writer.close();
            successful = TempFile.renameTo(usersFile);
            if (successful) {
                JOptionPane.showMessageDialog(null, "success!");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void RemoveSchedule(String mail) throws IOException {
        try {
            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] personArr = currentLine.split(" ");
                if (personArr[0].equals(mail)) {
                    personArr[4] = "NULL";
                    writer.write(String.join(" ", personArr));
                    writer.write("\n");
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            boolean successful = TempFile.renameTo(usersFile);
            if (successful) {
                JOptionPane.showMessageDialog(null, "success");
                return;
            }
            JOptionPane.showMessageDialog(null, "failed");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void ModifySchedule(String mail, String date) throws IOException {
        try {

            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));
            String currentLine;
            boolean successful = false;
            while ((currentLine = reader.readLine()) != null) {
                String[] personArr = currentLine.split(" ");
                if (personArr[0].equals(mail)) {
                    if (!personArr[4].equals("NULL")) {

                        personArr[4] = date;
                        writer.write(String.join(" ", personArr));
                        continue;
                    }
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            successful = TempFile.renameTo(usersFile);
            if (successful) {
                JOptionPane.showMessageDialog(null, "success");
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void ViewSchedule() throws IOException {
        try {
            ArrayList<String> scheduleList = new ArrayList<>();
            Scanner SC = new Scanner(System.in);
            String dateLine = "";
            File usersFile = new File("users.txt");
            SC = new Scanner(usersFile);
            while (SC.hasNextLine()) {
                String Line = SC.nextLine();
                String date = Line.split(" ")[4];
                scheduleList.add(date);
            }
            eliminateDuplicates(scheduleList);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void SearchSchedule(String mail) throws IOException {
        try {
            File userfile = new File("users.txt");
            Scanner SC = new Scanner(userfile);
            int flag = 0;
            while (SC.hasNextLine()) {
                String Line = SC.nextLine();
                String[] personArr = Line.split(" ");
                if (personArr[0].equals(mail)) {
                    JOptionPane.showMessageDialog(null, Line);
                    flag = 1;
                }
            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "Cannot find this person");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}

