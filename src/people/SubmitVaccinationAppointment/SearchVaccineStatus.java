package people.SubmitVaccinationAppointment;

import people.VaccinationStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchVaccineStatus extends JFrame{
    private JTextField something;
    private JButton button1;
    private JPanel Search_Vaccine_Panel;

    public SearchVaccineStatus() {
        setContentPane(Search_Vaccine_Panel);
        setVisible(true);
        setSize(450, 300);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String somethings = something.getText();
                VaccinationStatus vs = new VaccinationStatus();
                vs.Search(somethings);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
