package Committee;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;


public class PersonalForCommittee {
    private Committee ComObj;
    public PersonalForCommittee() {
    }

    public void RegisterPerson(Committee ComObj) throws IOException {
        try {
            File usersFile = new File("users.txt");
            FileWriter fw = new FileWriter(usersFile, true);
            fw.write(ComObj.writeNewPerson());
            fw.write("\n");
            fw.close();
            System.out.println("new person have written!");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void ModifyPerson(String mail, String chmail, String chPw, String chName) throws IOException {
        try {
            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));

            boolean successful = false;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String Line = currentLine;
                String[] personArr = Line.split(" ");
                boolean flag = false;
                if (personArr[0].equals(mail)) {
                    if (chmail !=null) {
                        personArr[0] = chmail;
                        flag = true;
                    }
                    if (chPw != null) {
                        personArr[1] = chPw;
                        flag = true;
                    }
                    if (chName != null) {
                        personArr[2] = chName;
                        flag = true;
                        System.out.println(chName);
                    }
                }
                if(flag) {
                    writer.write(String.join(" ", personArr));
                    writer.write("\n");
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            successful = TempFile.renameTo(usersFile);
            if (successful) {
                JOptionPane.showMessageDialog(null, "successful");
            } else {
                JOptionPane.showMessageDialog(null, "something failed");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void ViewPerson() throws IOException {
        try {
            File usersFile = new File("users.txt");
            Scanner SC = new Scanner(usersFile);
            String total = "";
            while (SC.hasNextLine()) {
                String Line = SC.nextLine();
                total = total.concat(Line + "\n");
            }
            JOptionPane.showMessageDialog(null, total);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void SearchPerson(String mail) throws IOException {
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
                JOptionPane.showMessageDialog(null, "cannot find person");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}

