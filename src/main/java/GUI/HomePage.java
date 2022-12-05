package GUI;

import Controller.UserRegisterController;
import Entities.User;
import UseCases.UserRegister.UserRegister;
import UseCases.UserRegister.UserRegisterCreateUser;
import UseCases.UserRegister.UserRegisterResponseFormatter;
import UseCases.UserRegister.UserRegisterStatus;
import Entities.ListOfWishlists;
import DataBase.DataBaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HomePage extends JFrame {
    private JPanel leftPanel;
    private JPanel upperPanel;
    private JPanel headerPanel;
    private JButton signoutButton;
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JPanel upperFooterPanel;
    private JPanel lowerPanel;
    private JLabel listOfWishlistsLabel;
    private JPanel wishlistPanel;
    private JPanel outerWLPanel;
    private JPanel lowerFooterPanel;
    private JButton addWishlistButton;

    private JButton dummyButton;
    UserRegisterController userRegisterController;
    private ListOfWishlists lwl;

    public JPanel getMainPanel() {
        return leftPanel;
    }

    public JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    public HomePage() {
        super("My Wishlists");
        DataBaseController dbc = new DataBaseController();
        lwl = dbc.getListOfWishlists(dbc.getCurrentUser().getName());

        setLayout(null);
        setSize(400, 638);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                JFrame f = (JFrame) e.getSource();
                f.setSize(400, f.getHeight());
                lowerPanel.setBounds(0, 300, 400, f.getHeight() - 338);
                wishlistPanel.setPreferredSize(new Dimension(400, f.getHeight() - 338));
            }
        });

        // Constants
        Font font1 = new Font("Montserrat", Font.PLAIN, 12);
        Font font2 = new Font("Montserrat", Font.PLAIN, 36);
        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);

        // main panel
        leftPanel = new JPanel();
        leftPanel.setBackground(color2);
        leftPanel.setBounds(0, 0, 400, 638);
        leftPanel.setLayout(null);
        // upper panel
        upperPanel = new JPanel();
        upperPanel.setBackground(color1);
        upperPanel.setBounds(0, 0, 400, 300);
        upperPanel.setLayout(new BorderLayout());
        // app name
        welcomeLabel = createLabel("Starlight Wishes", font2, Color.BLACK);
        welcomeLabel.setIcon(new ImageIcon("logo_gradient.png"));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(font1);
        upperPanel.add(welcomeLabel, BorderLayout.CENTER);
        // username label
        usernameLabel = createLabel("Hello Barry", font1, Color.WHITE);
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(color2);
        headerPanel.add(usernameLabel);
        upperPanel.add(headerPanel, BorderLayout.NORTH);
        // sign out button
        upperFooterPanel = new JPanel(new FlowLayout());
        upperFooterPanel.setBackground(color2);
        signoutButton = new CustomJButton("Sign Out", 150, 30, color2, Color.WHITE, font1);
        upperFooterPanel.add(signoutButton);
        upperPanel.add(upperFooterPanel, BorderLayout.SOUTH);
        // lower panel
        lowerPanel = new JPanel();
        lowerPanel.setBackground(color1);
        lowerPanel.setBounds(0, 300, 400, this.getHeight() - 338);
        lowerPanel.setLayout(new BorderLayout(20, 20));
        // wishlists label
        listOfWishlistsLabel = createLabel("Your Wishlists", font1, Color.BLACK);
        listOfWishlistsLabel.setHorizontalAlignment(JLabel.CENTER);
        lowerPanel.add(listOfWishlistsLabel, BorderLayout.NORTH);
        // footer
        lowerFooterPanel = new JPanel();
        lowerFooterPanel.setBackground(color2);
        lowerFooterPanel.setLayout(new FlowLayout());
        addWishlistButton = new CustomJButton("Add Wishlist", 150, 30, color2, Color.WHITE, font1);
        lowerFooterPanel.add(addWishlistButton);
        lowerPanel.add(lowerFooterPanel, BorderLayout.SOUTH);
        // list of wishlists
        wishlistPanel = new JPanel();
        wishlistPanel.setPreferredSize(new Dimension(400, this.getHeight() - 338));
        wishlistPanel.setBackground(Color.WHITE);
        FlowLayout layout = new FlowLayout();
        wishlistPanel.setLayout(layout);

        for (int i = 0; i < 10; i++) {
            dummyButton = new CustomJButton("dummyButton" + Integer.toString(i), 0, 0, Color.WHITE, color2, font1);
            wishlistPanel.add(dummyButton);
        }

        outerWLPanel = new JPanel(new FlowLayout());
        outerWLPanel.setBackground(color1);
        outerWLPanel.add(wishlistPanel, BorderLayout.CENTER);
        lowerPanel.add(outerWLPanel, BorderLayout.CENTER);
        // assemble panels
        leftPanel.add(upperPanel);
        leftPanel.add(lowerPanel);

        addWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWishlistPage addPage = new AddWishlistPage(lwl);
                addPage.setContentPane(addPage.getMainPanel());
                addPage.setVisible(true);
                addPage.setLocationRelativeTo(null);
                addPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });

        signoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRegisterStatus presenter = new UserRegisterResponseFormatter();
                UserRegisterCreateUser interactor = new UserRegister(presenter);
                UserRegisterController userRegisterController = new UserRegisterController(
                        interactor
                );

                WelcomePage loginSignupPage = new WelcomePage(userRegisterController);
                loginSignupPage.setContentPane(loginSignupPage.getMainPanel());
                loginSignupPage.setVisible(true);
                loginSignupPage.setLocationRelativeTo(null);
                loginSignupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

}
