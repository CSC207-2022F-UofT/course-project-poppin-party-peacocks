package GUI;
import UseCases.LoginAction.LoginAction;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPanel extends JPanel{

    public LoginPanel(JFrame currJFrame){
        super(null);
        this.setBounds(0,80,360,460);
        Color color2 = new Color(106, 189, 154);
        this.setBackground(color2);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("src/main/java/Assets/logo.png"));
        logo.setBounds(85,22,180,180);
        this.add(logo);

        // login panel
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(42,266,100,15);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(38,286,274,30);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(42,321,100,15);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(38,341,274,30);

        Font buttonFont = new Font("Sans Serif", Font.PLAIN, 12);
        CustomJButton loginButton = new CustomJButton("Login",
                0,0,
                Color.WHITE, Color.BLACK,
                buttonFont);
        loginButton.setBounds(120,420,108,24);

        loginButton.addActionListener(e->{
            LoginAction login = new LoginAction(usernameField.getText(),
                    String.valueOf(passwordField.getPassword()));
            try {
                if (!login.checkUsername() | !login.checkUserMatchesPassword()){
                    JOptionPane.showMessageDialog(loginButton,
                            "User and/or password does not match the records in our system. Please try again.");
                }
                else {
                    try {
                        if (login.checkUserMatchesPassword()) {
                            HomePage homePage = new HomePage();
                            homePage.setContentPane(homePage.getMainPanel());
                            homePage.setVisible(true);
                            homePage.setLocationRelativeTo(null);
                            homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            currJFrame.dispose();
                        }
                    } catch (FileNotFoundException | ParseException | java.text.ParseException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } catch (FileNotFoundException | ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);
    }
}
