import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ManageSchedule extends JFrame{
    private JButton addNewScheduleButton;
    private JButton removeScheduleButton;
    private JButton modifyScheduleButton;
    private JButton viewAllScheduleButton;
    private JButton searchScheduleButton;
    private JPanel Manage_Schedule_Panel;

    public ManageSchedule() {
        setContentPane(Manage_Schedule_Panel);
        setVisible(true);
        setSize(450, 300);
        viewAllScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addNewScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSchedule as = new AddSchedule();
            }
        });

        removeScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveSchedule rs = new RemoveSchedule();
            }
        });
        modifyScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifySchedule ms = new ModifySchedule();
            }
        });
        viewAllScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperation f1 = new FileOperation();
                try {
                    f1.ViewSchedule();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        searchScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchSchedule ss = new SearchSchedule();
            }
        });
    }
}
