package Committee.ManageVaccinationAppointments;

import Committee.ManageSchedules;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RemoveSchedule extends JFrame {
    private JTextField enterMail;
    private JButton button1;
    private JPanel Remove_Schedule_Panel;

    public RemoveSchedule() {
        setContentPane(Remove_Schedule_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageSchedules f1 = new ManageSchedules();
                    String mail = enterMail.getText();
                    f1.RemoveSchedule(mail);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
