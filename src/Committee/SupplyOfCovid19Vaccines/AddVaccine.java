package Committee.SupplyOfCovid19Vaccines;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Committee.SupplyVaccines;

public class AddVaccine extends JFrame{
    private JTextField enterName;
    private JTextField enterDate;
    private JTextField enterNumOfTaken;
    private JButton button1;
    private JPanel Add_Venue_Panel;

    public AddVaccine() {
        setContentPane(Add_Venue_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupplyVaccines supplyVaccines = new SupplyVaccines();
                String venueName = enterName.getText();
                String date = enterDate.getText();
                String numOfTaken = enterNumOfTaken.getText();
                supplyVaccines.Add(venueName, date, numOfTaken);
            }
        });
    }
}
