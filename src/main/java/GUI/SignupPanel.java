package GUI;

import javax.swing.*;
import java.awt.*;

public class SignupPanel extends JPanel {
    private final JFrame currJFrame;
    private final Color color1 = new Color(194, 234, 186);
    private final Color color2 = new Color(106, 189, 154);
    private final Font buttonFont = new Font("Sans Serif", Font.PLAIN, 12);

    public SignupPanel(JFrame currJFrame) {
        super(null);
        this.setBounds(0, 80, 360, 460);
        this.setBackground(color2);
        this.currJFrame = currJFrame;

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("src/main/java/Assets/logo.png"));
        logo.setBounds(85, 22, 180, 180);
        this.add(logo);

        // signup Panel
        JLabel createUsernameLabel = new JLabel("Create Username");
        createUsernameLabel.setBounds(42, 266, 100, 15);

        JTextField createUsernameField = new JTextField();
        createUsernameField.setBounds(38, 286, 274, 30);

        JLabel passwordLabel = new JLabel("Create Password");
        passwordLabel.setBounds(42, 321, 100, 15);

        JPasswordField createPasswordField = new JPasswordField();
        createPasswordField.setBounds(38, 341, 274, 30);

        JButton signupButton = new CustomJButton("Sign Up",
                0, 0,
                Color.WHITE, Color.BLACK,
                buttonFont);
        signupButton.setBounds(120, 420, 108, 24);

        this.add(createUsernameLabel);
        this.add(createUsernameField);
        this.add(passwordLabel);
        this.add(createPasswordField);
        this.add(signupButton);


    }

}
