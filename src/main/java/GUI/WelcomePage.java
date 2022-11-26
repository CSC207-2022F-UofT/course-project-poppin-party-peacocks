package GUI;

import Controller.WelcomePageActionListener;
import GUI.CustomJButton;
import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame{
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

    public WelcomePage() {
        super("Login Page");
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

        JPanel loginPanel = new LoginPanel();
        mainPanel.add(loginPanel);

        JPanel signupPanel = new JPanel();

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

        WelcomePageActionListener wpal = new WelcomePageActionListener(mainPanel, loginPanel, signupPanel);
        switchToLoginButton.addActionListener(wpal.getLoginActionListener());
        switchToSignupButton.addActionListener(wpal.getSignupActionListener());


        // sign up panel

//        usernameLabel = new JLabel("Create Username");
//        createUsernameField = new JTextField();
//        passwordLabel = new JLabel("Create Password");
//        createPasswordField = new JPasswordField();
//        confirmPasswordLabel = new JLabel("Confirm Password");
//        confirmPasswordField = new JPasswordField();
//        signupButton = new JButton("Sign Up");
//        signupPanel.add(usernameLabel);
//        signupPanel.add(createUsernameField);
//        signupPanel.add(passwordLabel);
//        signupPanel.add(createPasswordField);
//        signupPanel.add(confirmPasswordLabel);
//        signupPanel.add(confirmPasswordField);
//        signupPanel.add(signupButton);
//
//        // footer panel
//        footerPanel = new JPanel(new FlowLayout());
//        gotoLoginPanelButton = new JButton("Login");
//        gotoSignupPanelButton = new JButton("Sign Up");
//        footerPanel.add(gotoLoginPanelButton);
//        footerPanel.add(gotoSignupPanelButton);
//        mainPanel.add(footerPanel, BorderLayout.SOUTH);
//
//        // Button Logic
        //moved
//        gotoLoginPanelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // remove current BorderLayout centre
//                BorderLayout layout = (BorderLayout) mainPanel.getLayout();
//                mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
//                // adds new BorderLayout centre
//                mainPanel.add(loginPanel);
//                mainPanel.repaint();
//                mainPanel.revalidate();
//            }
//        });
//          moved
//        gotoSignupPanelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // remove current BorderLayout centre
//                BorderLayout layout = (BorderLayout) mainPanel.getLayout();
//                mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
//                // adds new BorderLayout centre
//                mainPanel.add(signupPanel);
//                mainPanel.repaint();
//                mainPanel.revalidate();
//            }
//        });
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
//
//        signupButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                GUI.ListOfWishlistsPage listOfWishlists = new GUI.ListOfWishlistsPage();
//                listOfWishlists.setContentPane(listOfWishlists.getMainPanel());
//                listOfWishlists.setVisible(true);
//                listOfWishlists.setLocationRelativeTo(null);
//                listOfWishlists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                dispose();
//
//                // TODO: Add sign up logic
//            }
//        });

    }

}
