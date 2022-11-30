package GUI;

import Controller.UserRegisterController;
import GUI.Listeners.WelcomePageActionListenerSwitchPanels;
import UseCases.LoginAction;
import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame{
    UserRegisterController userRegisterController;
    private JPanel mainPanel;
    // header
    private JLabel titleLabel;

    // Login Page
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Sign Up Page
    private JTextField createUsernameField;
    private JPasswordField createPasswordField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordField;
    private JButton signupButton;

    // footer
    private JButton gotoLoginPanelButton;
    private JButton gotoSignupPanelButton;
    private Color color1 = new Color(194, 234, 186);
    private Color color2 = new Color(106, 189, 154);
    private Font buttonFont = new Font("Sans Serif", Font.PLAIN, 12);
    private Font titleFont = new Font("Sans Serif", Font.PLAIN, 20);
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public WelcomePage(UserRegisterController controller) {
        super("Login Page");
        this.userRegisterController = controller;
        setLayout(null);
        setSize(360, 640);
        setResizable(false);

        JLabel titleLabel = new JLabel("Starlight Wishes");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(103,13,154,24);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 360, 640);
        mainPanel.setBackground(color2);
        mainPanel.add(titleLabel);

        JPanel loginPanel = new LoginPanel(this);
        mainPanel.add(loginPanel);

        JPanel signupPanel = new SignupPanel(this);

        CustomJButton switchToLoginButton = new CustomJButton("Login Page",0,0,
                Color.WHITE, Color.BLACK,
                buttonFont);
        switchToLoginButton.setBounds(30,550,130,15);
        CustomJButton switchToSignupButton = new CustomJButton("Sign Up Page",0,0,
                Color.WHITE, Color.BLACK,
                buttonFont);
        switchToSignupButton.setBounds(190,550,130,15);
        mainPanel.add(switchToLoginButton);
        mainPanel.add(switchToSignupButton);

        WelcomePageActionListenerSwitchPanels wpal = new WelcomePageActionListenerSwitchPanels(this, mainPanel, loginPanel, signupPanel);
        switchToLoginButton.addActionListener(wpal.getLoginActionListener());
        switchToSignupButton.addActionListener(wpal.getSignupActionListener());

        // footer panel
        JPanel footerPanel = new JPanel(new FlowLayout());
        gotoLoginPanelButton = new JButton("Login");
        gotoSignupPanelButton = new JButton("Sign Up");
        footerPanel.add(gotoLoginPanelButton);
        footerPanel.add(gotoSignupPanelButton);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);


//
//        // Button Logic
//
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUI.ListOfWishlistsPage listOfWishlists = new GUI.ListOfWishlistsPage();
//                listOfWishlists.setContentPane(listOfWishlists.getMainPanel());
//                listOfWishlists.setVisible(true);
//                listOfWishlists.setLocationRelativeTo(null);
//                listOfWishlists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                dispose();
//
//                // TODO: Add login logic
//            }
//        });
        loginButton.addActionListener(e -> {
            HomePage homePage = new HomePage();

            LoginAction login = new LoginAction(usernameField.getText(),
                    String.valueOf(passwordField.getPassword()));
            if (login.checkUsername() == false | login.checkUserMatchesPassword() == false){
                JOptionPane.showMessageDialog(loginButton,
                        "User and/or password does not match the records in our system. Please try again.");
            }
            else if (login.checkUserMatchesPassword() == true) {
                homePage.setContentPane(homePage.getMainPanel());
                homePage.setVisible(true);
                homePage.setLocationRelativeTo(null);
                homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
//
//        signupButton.addActionListener(e -> {
//            ListOfWishlistsPage listOfWishlists = new ListOfWishlistsPage();
//            listOfWishlists.setContentPane(listOfWishlists.getMainPanel());
//            listOfWishlists.setVisible(true);
//            listOfWishlists.setLocationRelativeTo(null);
//            listOfWishlists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            dispose();
//
//            try{
//                this.userRegisterController.create(createUsernameField.getText(), String.valueOf(createPasswordField.getPassword()));
//                JOptionPane.showMessageDialog(signupButton, "User created.");
//
//            } catch(Exception message){
//                JOptionPane.showMessageDialog(signupButton, message.getMessage());
//            }
//        });
        signupButton.addActionListener(e -> {
            HomePage homePage = new HomePage();
            homePage.setContentPane(homePage.getMainPanel());
            homePage.setVisible(true);
            homePage.setLocationRelativeTo(null);
            homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();

            try{
                this.userRegisterController.create(createUsernameField.getText(), String.valueOf(createPasswordField.getPassword()));
                JOptionPane.showMessageDialog(signupButton, "User created.");

            } catch(Exception message){
                JOptionPane.showMessageDialog(signupButton, message.getMessage());
            }
        });

    }

}
