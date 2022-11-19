import Entities.ListOfWishlists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO:
 *  - Add labels above all the text and password fields
 *  - Adjust size and spacing of text and password fields
 *  - Add login and sign up logic
 */

public class MainAppLoginSignupPage extends JFrame {
    private JPanel mainPanel;
    // header
    private JPanel headerPanel;
    private JLabel titleLabel;

    // Login Page
    private JPanel loginPanel;
    private JLabel logoLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Sign Up Page
    private JPanel signupPanel;
    private JTextField createUsernameField;
    private JPasswordField createPasswordField;
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
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // login panel
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(0, 1));
        logoLabel = new JLabel(new ImageIcon("sus.png"));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginPanel.add(logoLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        mainPanel.add(loginPanel, BorderLayout.CENTER);

        // sign up panel
        signupPanel = new JPanel();
        signupPanel.setLayout(new GridLayout(0, 1));
        createUsernameField = new JTextField();
        createPasswordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        signupButton = new JButton("Sign Up");
        signupPanel.add(createUsernameField);
        signupPanel.add(createPasswordField);
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
