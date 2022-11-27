//package GUI;
//
//import Entities.ListOfWishlists;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainAppLoginSignupPage_deprecated extends JFrame {
//    private JPanel mainPanel;
//    // header
//    private JPanel headerPanel;
//    private JLabel titleLabel;
//
//    // Login Page
//    private JPanel loginPanel;
//    private JLabel usernameLabel;
//    private JTextField usernameField;
//    private JLabel passwordLabel;
//    private JPasswordField passwordField;
//    private JButton loginButton;
//
//    private JPanel loginButtonPanel;
//
//    // Sign Up Page
//    private JPanel signupPanel;
//    private JTextField createUsernameField;
//    private JPasswordField createPasswordField;
//    private JLabel confirmPasswordLabel;
//    private JPasswordField confirmPasswordField;
//    private JButton signupButton;
//
//    private JPanel signupPanelButton;
//
//
//    // footer
//    private JPanel footerPanel;
//    private JButton gotoLoginPanelButton;
//    private JButton gotoSignupPanelButton;
//
//    public JPanel getMainPanel() {
//        return mainPanel;
//    }
//
//    public MainAppLoginSignupPage_deprecated() {
//        super("Login Page");
//        setLayout(null);
//        setSize(400, 638);
//        setResizable(false);
//
//        //constants
//        Color color1 = new Color(194, 234, 186);
//        Color color2 = new Color(106, 189, 154);
//        Font font1 = new Font("Montserrat", Font.PLAIN, 12);
//
//        // main panel
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//        mainPanel.setBounds(0, 0, 400, 638);
//
//        // header
//        headerPanel = new JPanel(new FlowLayout());
//        headerPanel.setBackground(color2);
//        titleLabel = new JLabel("Starlight Wishes");
//        titleLabel.setForeground(Color.WHITE);
//        titleLabel.setIcon(new ImageIcon("logo_white.png"));
//        headerPanel.add(titleLabel);
//        mainPanel.add(headerPanel, BorderLayout.NORTH);
//
//        // login panel
//        loginPanel = new JPanel();
//        GridLayout layout = new GridLayout(0, 1);
//        layout.setVgap(10);
//        loginPanel.setLayout(layout);
//        usernameLabel = new JLabel("Username:");
//        usernameField = new JTextField();
//        passwordLabel = new JLabel("Password:");
//        passwordField = new JPasswordField();
//
//        loginButtonPanel = new JPanel(new FlowLayout());
//        loginButton = new CustomJButton("Login",0, 0, color2, Color.white, font1);
//        loginButton.setBackground(color2);
//        loginButton.setForeground(Color.white);
//        loginPanel.setBackground(color1);
//        loginButtonPanel.setBackground(color2);
//
//        loginPanel.add(usernameLabel);
//        loginPanel.add(usernameField);
//        loginPanel.add(passwordLabel);
//        loginPanel.add(passwordField);
//
//        // loginPanel.add(loginButton);
//        loginButtonPanel.add(loginButton);
//        loginPanel.add(loginButtonPanel);
//        mainPanel.add(loginPanel, BorderLayout.CENTER);
//
//        // sign up panel
//        signupPanel = new JPanel();
//        signupPanel.setBackground(color1);
//
//        signupPanel.setLayout(new GridLayout(0, 1));
//        usernameLabel = new JLabel("Create Username");
//        createUsernameField = new JTextField();
//        passwordLabel = new JLabel("Create Password");
//        createPasswordField = new JPasswordField();
//        confirmPasswordLabel = new JLabel("Confirm Password");
//        confirmPasswordField = new JPasswordField();
//        signupButton = new CustomJButton("Sign Up", 0, 0, color2, Color.white, font1);
//
//        signupPanelButton = new JPanel(new FlowLayout());
//        signupPanelButton.setBackground(color2);
//
//        signupPanelButton.add(signupButton);
//        signupPanel.add(usernameLabel);
//        signupPanel.add(createUsernameField);
//        signupPanel.add(passwordLabel);
//        signupPanel.add(createPasswordField);
//        signupPanel.add(confirmPasswordLabel);
//        signupPanel.add(confirmPasswordField);
//        signupPanel.add(signupPanelButton);
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
//
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
//                ListOfWishlistsPage listOfWishlists = new ListOfWishlistsPage();
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
//                ListOfWishlistsPage listOfWishlists = new ListOfWishlistsPage();
//                listOfWishlists.setContentPane(listOfWishlists.getMainPanel());
//                listOfWishlists.setVisible(true);
//                listOfWishlists.setLocationRelativeTo(null);
//                listOfWishlists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                dispose();
//
//                // TODO: Add sign up logic
//            }
//        });
//
//    }
//}
