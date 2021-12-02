import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Committee.*;

public class AddPerson extends JFrame{
    private JTextField mail;
    private JTextField password;
    private JTextField name;
    private JButton button1;
    private JPanel Add_Panel;

    public AddPerson() {
        setContentPane(Add_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PersonalForCommittee p1 = new PersonalForCommittee();
                    String MailAdd = mail.getText();
                    String Pass = password.getText();
                    String Name = name.getText();
                    Committee comObj = new Committee(MailAdd, Pass, Name, "No");
                    p1.RegisterPerson(comObj);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
