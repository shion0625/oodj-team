package Committee.CitizensNonCitizensPeople;

import Committee.FileOperation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SearchPerson extends JFrame{
    private JTextField mail;
    private JButton button1;
    private JPanel SearchPerson_Panel;

    public SearchPerson() {
        setContentPane(SearchPerson_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Mail = mail.getText();
                    FileOperation f1 = new FileOperation();
                    f1.SearchPerson(Mail);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
