import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Committee_main extends JFrame{
    private JButton aboutPeopleButton;
    private JButton manageVaccineButton;
    private JButton supplyVaccineButton;
    private JButton exitButton;
    public JPanel Committee_main_Panel;

    public Committee_main() {
        setContentPane(Committee_main_Panel);
        setVisible(true);
        setSize(450, 300);
        aboutPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Committee_sub1 com_sub = new Committee_sub1();

            }
        });


        manageVaccineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageSchedule ms = new ManageSchedule();
            }
        });

        supplyVaccineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupplyVaccine sv = new SupplyVaccine();
            }
        });
    }
}
