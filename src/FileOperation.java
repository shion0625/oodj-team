import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class FileOperation {
    private Committee ComObj;

    public FileOperation() {
    }

    static void eliminateDuplicates(ArrayList<String> strings) {
        List<String> listA = new ArrayList<String>(strings);
        List<String> listB = new ArrayList<String>(new LinkedHashSet<>(listA));
        System.out.println(listB);

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

    public void ModifyPerson(String mail) throws IOException {
        try {
            Scanner SC = new Scanner(System.in);
            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));

            int isExist = 0;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String Line = currentLine;

                String[] personArr = Line.split(" ");

                if (personArr[0].equals(mail)) {
                    System.out.println("What do you want to change? \n(1)mail \n(2)password \n(3)name");
                    int choice = Integer.parseInt(SC.nextLine());
                    if (choice == 1) {
                        System.out.println("Enter new email");
                        String newMail = SC.nextLine();
                        personArr[0] = newMail;

                        writer.write(String.join(" ", personArr));
                        writer.close();
                        boolean successful = TempFile.renameTo(usersFile);
                    }
                    if (choice == 2) {
                        System.out.println("Enter new password");
                        String ps = SC.nextLine();
                        personArr[1] = ps;

                        writer.write(String.join(" ", personArr));
                        writer.close();
                        boolean successful = TempFile.renameTo(usersFile);
                    }
                    if (choice == 3) {
                        System.out.println("Enter new name");
                        String name = SC.nextLine();
                        personArr[2] = name;

                        writer.write(String.join(" ", personArr));
                        writer.close();
                        boolean successful = TempFile.renameTo(usersFile);
                    }

                } else {
                    isExist = 1;
                }
            }
            if (isExist == 0) {
                System.out.println("Successful!");
            } else {
                System.out.println("Cannot find this email");
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void ViewPerson() throws IOException {
        try {
            Scanner SC = new Scanner(System.in);
            File usersFile = new File("users.txt");
            SC = new Scanner(usersFile);
            while (SC.hasNextLine()) {
                String Line = SC.nextLine();
                System.out.println(Line);
            }

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
                    System.out.println(Line);
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("Cannot find this person");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void AddSchedule(String mail) throws IOException {
        try {
            Scanner SC = new Scanner(System.in);
            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));

            int isExist = 0;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String[] personArr = currentLine.split(" ");

                if (personArr[0].equals(mail)) {
                    if (personArr[4] == null) {
                        String date = SC.nextLine();
                        personArr[4] = date;
                        writer.write(String.join(" ", personArr));
                        writer.close();
                        boolean successful = TempFile.renameTo(usersFile);
                    } else {
                        System.out.println("the person hasn't registered appointment please check it again");
                    }
                } else {
                    isExist = 1;
                }
            }
            if (isExist == 0) {
                System.out.println("Successful!");
            } else {
                System.out.println("Cannot find this email");
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void RemoveSchedule(String mail) throws IOException {
        try {
            Scanner SC = new Scanner(System.in);
            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));

            int isExist = 0;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String[] personArr = currentLine.split(" ");

                if (personArr[0].equals(mail)) {
                    String date = SC.nextLine();
                    personArr[4] = null;
                    writer.write(String.join(" ", personArr));
                    writer.close();
                    boolean successful = TempFile.renameTo(usersFile);
                } else {
                    isExist = 1;
                }
            }
            if (isExist == 0) {
                System.out.println("Successful!");
            } else {
                System.out.println("Cannot find this email");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void ModifySchedule(String mail) throws IOException {
        try {
            Scanner SC = new Scanner(System.in);
            File usersFile = new File("users.txt");
            File TempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TempFile));

            int isExist = 0;

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String[] personArr = currentLine.split(" ");

                if (personArr[0].equals(mail)) {
                    if (personArr[4] != null) {
                        System.out.println("Which date do you want to??");
                        String date = SC.nextLine();
                        personArr[4] = date;
                        writer.write(String.join(" ", personArr));
                        writer.close();
                        boolean successful = TempFile.renameTo(usersFile);
                    } else {
                        System.out.println("the person hasn't registered appointment please check it again");
                    }
                } else {
                    isExist = 1;
                }
            }
            if (isExist == 0) {
                System.out.println("Successful!");
            } else {
                System.out.println("Cannot find this email");
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
                    System.out.println(personArr[5]);
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("Cannot find this person");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
