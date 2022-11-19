import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class placeholderLoginFrame extends JFrame{
    private JPanel mainPanel;
    private JButton button;
    public placeholderLoginFrame() {
        super("test");
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.YELLOW);
        button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // open main app frame
                MainApp mainApp = new MainApp();
                //mainApp.setContentPane(mainApp.getMainPanel());
                mainApp.setVisible(true);
                mainApp.setLocationRelativeTo(null);
                mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
        mainPanel.add(button);
        mainPanel.setSize(1200, 638);
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
