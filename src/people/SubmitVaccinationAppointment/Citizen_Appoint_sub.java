package people.SubmitVaccinationAppointment;

import people.Appointment;
import people.SubmitVaccinationAppointment.Appoint_Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Citizen_Appoint_sub extends JFrame{
    private JButton registerButton;
    private JButton modifyButton;
    private JButton viewButton;
    private JPanel Citizen_Appoint_sub_Panel;
    private String mailaddress;

    public Citizen_Appoint_sub(String mail) {
        setContentPane(Citizen_Appoint_sub_Panel);
        setVisible(true);
        setSize(450, 300);
        this.mailaddress = mail;
        Appointment a = new Appointment(mailaddress);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Appoint_Register ar = new Appoint_Register(mailaddress);
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.Cancel();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.View();
            }
        });
    }
}
