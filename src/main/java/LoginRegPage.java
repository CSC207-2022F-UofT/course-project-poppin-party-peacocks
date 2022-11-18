import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginRegPage extends JFrame {
    private JPanel mainPanel;
    private JButton chooseLoginButton;
    private JButton chooseSignupButton;
    private JPanel loginOrSignup;
    private JPanel contentPanel;
    private JPanel loginPanel;
    private JPanel signupPanel;
    private JPasswordField PWlogin;
    private JTextField userLoginTextfield;
    private JButton loginToMainButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton signupToMainButton;
    private JLabel createUserLabel;
    private JTextField createUserTextfield;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JLabel createPW;
    private JLabel confirmPW;

    public LoginRegPage() {

        // LOGIN OR SIGNUP PANEL
        chooseLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.removeAll();
                contentPanel.add(loginPanel);
                contentPanel.repaint();
                contentPanel.revalidate();
            }
        });
        chooseSignupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.removeAll();
                contentPanel.add(signupPanel);
                contentPanel.repaint();
                contentPanel.revalidate();
            }
        });

        // CONTENT PANEL
        loginToMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if user and PW fields are non-empty (for now)
                //if (!Objects.equals(userLoginTextfield.getText(), "") && (!Objects.equals(new String(PWlogin.getPassword()), ""))) {

                // open main app frame
                MainApp mainApp = new MainApp();
                //mainApp.setContentPane(mainApp.getMainPanel());
                mainApp.setVisible(true);
                mainApp.setLocationRelativeTo(null);
                mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // trash old jframe
                dispose();

            }
        });
        signupToMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("i dont do anything atm");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
