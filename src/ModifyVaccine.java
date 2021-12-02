import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Committee.SupplyVaccines;

public class ModifyVaccine extends JFrame{
    private JPanel Add_Venue_Panel;
    private JTextField enterName;
    private JTextField enterDate;
    private JTextField enterNumOfTaken;
    private JButton button1;
    private JTextField changeName;
    private JTextField changeDate;
    private JPanel Modify_Vaccine_Panel;

    public ModifyVaccine() {
        setContentPane(Modify_Vaccine_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String changename = changeName.getText();
                String changedate = changeDate.getText();
                String name = enterName.getText();
                String date = enterDate.getText();
                String num = enterNumOfTaken.getText();
                SupplyVaccines supplyVaccines = new SupplyVaccines();
                supplyVaccines.Modify(changename, changedate, name, date, num);
            }
        });
    }
}
