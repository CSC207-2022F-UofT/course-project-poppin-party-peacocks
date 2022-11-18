import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dummyGuiForm extends JFrame{
    private JPanel mainPanel;
    private JButton button1;

    public dummyGuiForm() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("fdsa");
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
