import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Committee.SupplyVaccines;


public class SearchVaccine extends JFrame{
    private JTextField something;
    private JButton button1;
    private JPanel Search_Vaccine_Panel;

    public SearchVaccine() {
        setContentPane(Search_Vaccine_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupplyVaccines sv = new SupplyVaccines();
                String someValue = something.getText();
                sv.Search(someValue);
            }
        });
    }
}
