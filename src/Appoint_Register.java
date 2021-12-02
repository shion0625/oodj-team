import people.Appointment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Appoint_Register extends JFrame{
    private JTextField enterVenue;
    private JTextField enterDate;
    private JButton button1;
    private JPanel Appoint_Register_Panel;
    private String mailaddress;

    public Appoint_Register(String mail) {
        setContentPane(Appoint_Register_Panel);
        setVisible(true);
        setSize(450, 300);
        this.mailaddress = mail;
        Appointment a = new Appointment(mailaddress);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String venue = enterVenue.getText();
                String date = enterDate.getText();
                a.Register(venue, date);
            }
        });
    }
}
