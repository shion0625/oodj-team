import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Committee.SupplyVaccines;

public class RemoveVaccine extends JFrame{
    private JTextField enterName;
    private JTextField enterDate;
    private JPanel Remove_Vaccine_Panel;
    private JButton button1;

    public RemoveVaccine() {
        setContentPane(Remove_Vaccine_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = enterName.getText();
                String date = enterDate.getText();
                SupplyVaccines supplyVaccines = new SupplyVaccines();
                supplyVaccines.Remove(name, date);
            }
        });
    }
}
