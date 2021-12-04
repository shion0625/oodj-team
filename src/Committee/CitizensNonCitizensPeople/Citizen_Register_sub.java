package Committee.CitizensNonCitizensPeople;

import people.Program;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Citizen_Register_sub extends JFrame{
    private JButton registerButton;
    private JButton modifyButton;
    private JButton viewButton;
    private JPanel Citizen_Register_Panel;
    public String mailaddress;

    public Citizen_Register_sub(String mail) {
        setContentPane(Citizen_Register_Panel);
        setVisible(true);
        setSize(450, 300);
        this.mailaddress = mail;
        Program p = new Program(mailaddress);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.Register();
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.Change();
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.View();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
