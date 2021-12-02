import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Committee.ManageSchedules;

public class SearchSchedule extends JFrame{
    private JTextField enterMail;
    private JButton button1;
    private JPanel Search_Schedule_Panel;

    public SearchSchedule() {
        setContentPane(Search_Schedule_Panel);
        setVisible(true);
        setSize(450, 300);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = enterMail.getText();
                ManageSchedules m1 = new ManageSchedules();
                try {
                    m1.SearchSchedule(mail);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
