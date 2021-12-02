import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModifyPerson extends JFrame{
    private JTextField mail;
    private JButton button1;
    private JPanel Modify_Person_Panel;
    private JTextField enterMail;
    private JTextField enterPw;
    private JTextField enterName;

    public ModifyPerson() {
        setContentPane(Modify_Person_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOperation f1 = new FileOperation();
                    String Mail = mail.getText();
                    String changeMail = enterMail.getText();
                    String changePw = enterPw.getText();
                    String changeName = enterName.getText();
                    f1.ModifyPerson(Mail, changeMail, changePw, changeName);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
