import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Committee.*;


public class SupplyVaccine extends JFrame{
    private JPanel Manage_Schedule_Panel;
    private JButton addVaccineSuplyButton;
    private JButton removeVaccineSuplyButton;
    private JButton modifyVaccineButton;
    private JButton viewAllVaccineButton;
    private JButton searchVaccineButton;
    private JPanel Supply_Vaccine_Panel;


    public SupplyVaccine() {
        setContentPane(Supply_Vaccine_Panel);
        setVisible(true);
        setSize(450, 300);
        addVaccineSuplyButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                AddVaccine av = new AddVaccine();

            }
        });
        removeVaccineSuplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveVaccine rv = new RemoveVaccine();
            }
        });
        modifyVaccineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyVaccine mv = new ModifyVaccine();
            }
        });
        searchVaccineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchVaccine sv = new SearchVaccine();
            }
        });
        viewAllVaccineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupplyVaccines sv = new SupplyVaccines();
                sv.View();
            }
        });
    }
}
