import Committee.Committee_main;
import people.Citizen_main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login extends JFrame{
    private JTextField mailAddress;
    private JButton button1;
    private JTextField passWord;
    private JPanel mainPanel;

    public ArrayList<String> result;


    public Login() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String mail = mailAddress.getText();
                    String password = passWord.getText();
                    result = CheckValidUser(mail, password);
                    if (result.size() == 2) {
                        if(result.get(0).equals("Committee")) {
                            Committee_main com = new Committee_main();
                        }else {
                            Citizen_main cit = new Citizen_main(result.get(1));
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "something error");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public ArrayList<String> CheckValidUser(String mail, String ps) throws IOException {
        ArrayList<String> values = new ArrayList<>();
        try {
            File usersFile = new File("users.txt");
            Scanner SC = new Scanner(usersFile);
            while (SC.hasNextLine()) {
                String Line = SC.nextLine();
                String emailInLine = Line.split(" ")[0];
                String passwordInLine = Line.split(" ")[1];
                String isCommittee = Line.split(" ")[3];
                if (mail.equals(emailInLine) && ps.equals(passwordInLine)) {
                    if (isCommittee.equals("Yes")) {
                        values.add("Committee");
                        values.add(emailInLine);
                        return values;
                    }
                    if (isCommittee.equals("No")) {
                        values.add("Citizen");
                        values.add(emailInLine);
                        return values;
                    }
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        values.add("cannot find this people");
        return values;
    }
}
