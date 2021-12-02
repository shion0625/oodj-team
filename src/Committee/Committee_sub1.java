package Committee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Committee.CitizensNonCitizensPeople.AddPerson;
import Committee.CitizensNonCitizensPeople.ModifyPerson;
import Committee.CitizensNonCitizensPeople.SearchPerson;

public class Committee_sub1 extends JFrame{
    private JButton addNewPersonButton;
    private JButton modifyPersonButton;
    private JButton viewAllPeopleButton;
    private JButton searchSpecificPersonButton;
    private JPanel committee_sub_panel;

    public Committee_sub1() {
        setContentPane(committee_sub_panel);
        setVisible(true);
        setSize(450, 300);
        addNewPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPerson ap = new AddPerson();
            }
        });
        modifyPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyPerson mp = new ModifyPerson();
            }
        });
        viewAllPeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperation f1 = new FileOperation();
                try {
                    f1.ViewPerson();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        searchSpecificPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchPerson sp = new SearchPerson();
            }
        });
    }


}
