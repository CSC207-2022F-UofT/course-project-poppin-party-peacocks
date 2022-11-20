import Entities.ListOfWishlists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAppLoginSignupPage extends JFrame {
    private customJButton asdf;
    private JPanel mainPanel;
    // header
    private JPanel headerPanel;
    private JLabel titleLabel;

    // Login Page
    private JPanel loginPanel;
    private JLabel logoLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Sign Up Page
    private JPanel signupPanel;
    private JTextField createUsernameField;
    private JPasswordField createPasswordField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordField;
    private JButton signupButton;

    // footer
    private JPanel footerPanel;
    private JButton gotoLoginPanelButton;
    private JButton gotoSignupPanelButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public MainAppLoginSignupPage() {
        super("Login Page");
        setLayout(null);
        setSize(400, 638);
        setResizable(false);

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 638);

        // header
        headerPanel = new JPanel(new FlowLayout());
        titleLabel = new JLabel("Starlight Wishes");
        headerPanel.add(titleLabel);
        asdf = new customJButton();
        asdf.setPreferredSize(new Dimension(100, 100));
        asdf.setText("asdf");
        headerPanel.add(asdf);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // login panel
        loginPanel = new JPanel();
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(10);
        loginPanel.setLayout(layout);
        logoLabel = new JLabel(new ImageIcon("sus.png"));
        usernameLabel = new JLabel("Username");
        usernameField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");


        loginPanel.add(logoLabel);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        mainPanel.add(loginPanel, BorderLayout.CENTER);

        // sign up panel
        signupPanel = new JPanel();
        signupPanel.setLayout(new GridLayout(0, 1));
        usernameLabel = new JLabel("Create Username");
        createUsernameField = new JTextField();
        passwordLabel = new JLabel("Create Password");
        createPasswordField = new JPasswordField();
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordField = new JPasswordField();
        signupButton = new JButton("Sign Up");
        signupPanel.add(usernameLabel);
        signupPanel.add(createUsernameField);
        signupPanel.add(passwordLabel);
        signupPanel.add(createPasswordField);
        signupPanel.add(confirmPasswordLabel);
        signupPanel.add(confirmPasswordField);
        signupPanel.add(signupButton);

        // footer panel
        footerPanel = new JPanel(new FlowLayout());
        gotoLoginPanelButton = new JButton("Login");
        gotoSignupPanelButton = new JButton("Sign Up");
        footerPanel.add(gotoLoginPanelButton);
        footerPanel.add(gotoSignupPanelButton);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Button Logic
        gotoLoginPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // remove current BorderLayout centre
                BorderLayout layout = (BorderLayout) mainPanel.getLayout();
                mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                // adds new BorderLayout centre
                mainPanel.add(loginPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        gotoSignupPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // remove current BorderLayout centre
                BorderLayout layout = (BorderLayout) mainPanel.getLayout();
                mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                // adds new BorderLayout centre
                mainPanel.add(signupPanel);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOfWishlistsPage listOfWishlists = new ListOfWishlistsPage();
                listOfWishlists.setContentPane(listOfWishlists.getMainPanel());
                listOfWishlists.setVisible(true);
                listOfWishlists.setLocationRelativeTo(null);
                listOfWishlists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();

                // TODO: Add login logic
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListOfWishlistsPage listOfWishlists = new ListOfWishlistsPage();
                listOfWishlists.setContentPane(listOfWishlists.getMainPanel());
                listOfWishlists.setVisible(true);
                listOfWishlists.setLocationRelativeTo(null);
                listOfWishlists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();

                // TODO: Add sign up logic
            }
        });

    }
}