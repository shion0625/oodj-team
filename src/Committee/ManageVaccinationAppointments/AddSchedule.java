package Committee.ManageVaccinationAppointments;

import Committee.FileOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddSchedule extends JFrame{
    private JTextField mail;
    private JButton button1;
    private JTextField enterDate;
    private JPanel Add_Schedule_Panel;

    public AddSchedule() {
        setContentPane(Add_Schedule_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Mail = mail.getText();
                    String date = enterDate.getText();
                    FileOperation f1 = new FileOperation();
                    f1.AddSchedule(Mail, date);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
