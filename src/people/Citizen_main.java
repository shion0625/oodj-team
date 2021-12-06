package people;

import people.SubmitVaccinationAppointment.Citizen_Appoint_sub;
import people.VaccinationStatus.VaccineStatus_sub1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import people.RegisterVaccinationProgramme.Citizen_Register_sub;

public class Citizen_main extends JFrame{
    private JButton registerToVaccineProgramButton;
    private JButton submitAppointmentButton;
    private JButton viewVaccineStatusButton;
    private JPanel Citizen_main_Panel;
    public String mailaddress;



    public Citizen_main(String mail) {
        setContentPane(Citizen_main_Panel);
        setVisible(true);
        setSize(450, 300);
        this.mailaddress = mail;
        registerToVaccineProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Citizen_Register_sub crs = new Citizen_Register_sub(mailaddress);
            }
        });
        submitAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Citizen_Appoint_sub cas = new Citizen_Appoint_sub(mailaddress);
            }
        });
        viewVaccineStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VaccineStatus_sub1 vs = new VaccineStatus_sub1();
            }
        });

    }
}
