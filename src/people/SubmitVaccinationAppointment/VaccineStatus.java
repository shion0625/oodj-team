package people.SubmitVaccinationAppointment;

import people.VaccinationStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaccineStatus extends JFrame{
    private JButton viewVaccineStatusButton;
    private JButton searchVaccineStatusButton;
    private JPanel Vaccine_Status_Panel;

    public VaccineStatus() {
        setContentPane(Vaccine_Status_Panel);
        setVisible(true);
        setSize(450, 300);
        viewVaccineStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VaccinationStatus vs = new VaccinationStatus();
                vs.View();
            }
        });
        searchVaccineStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchVaccineStatus sv = new SearchVaccineStatus();
            }
        });
    }
}
