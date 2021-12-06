package people.VaccinationStatus;

import people.ViewVaccinationStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaccineStatus_sub1 extends JFrame{
    private JButton viewVaccineStatusButton;
    private JButton searchVaccineStatusButton;
    private JPanel Vaccine_Status_Panel;

    public VaccineStatus_sub1() {
        setContentPane(Vaccine_Status_Panel);
        setVisible(true);
        setSize(450, 300);
        viewVaccineStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewVaccinationStatus vs = new ViewVaccinationStatus();
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
