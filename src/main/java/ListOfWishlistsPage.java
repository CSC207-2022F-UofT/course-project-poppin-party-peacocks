import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListOfWishlistsPage extends JFrame {
    private JPanel leftPanel;
    private JPanel upperPanel;
    private JButton signoutButton;
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JPanel upperFooterPanel;
    private JPanel lowerPanel;
    private JLabel listOfWishlistsLabel;
    private JPanel wishlistPanel;
    private JPanel lowerFooterPanel;
    private JButton addWishlistButton;

    private JButton dummy1;
    private JButton dummy2;
    private JButton dummy3;

    public JPanel getMainPanel() {
        return leftPanel;
    }

    public ListOfWishlistsPage() {
        super("My Wishlists");
        setLayout(null);
        setSize(400, 638);
        setResizable(false);

        Font font = new Font("Montserrat", Font.PLAIN, 24);

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.red);
        leftPanel.setBounds(0, 0, 400, 638);
        leftPanel.setLayout(null);
        // upper panel
        upperPanel = new JPanel();
        upperPanel.setBackground(Color.green);
        upperPanel.setBounds(0, 0, 400, 300);
        upperPanel.setLayout(new BorderLayout());
        // app name
        welcomeLabel = new JLabel("Party Peacocks");
        welcomeLabel.setIcon(new ImageIcon("sus.png"));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(font);
        upperPanel.add(welcomeLabel, BorderLayout.CENTER);
        // username label
        usernameLabel = new JLabel("Hello Barry");
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);
        upperPanel.add(usernameLabel, BorderLayout.NORTH);
        // sign out button
        upperFooterPanel = new JPanel(new FlowLayout());
        upperFooterPanel.setBackground(Color.blue);
        signoutButton = new JButton("Sign out");
        upperFooterPanel.add(signoutButton);
        upperPanel.add(upperFooterPanel, BorderLayout.SOUTH);
        // lower panel
        lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.orange);
        lowerPanel.setBounds(0, 300, 400, 300);
        lowerPanel.setLayout(new BorderLayout(20, 20));
        // wishlists label
        listOfWishlistsLabel = new JLabel("Your Wishlists");
        listOfWishlistsLabel.setHorizontalAlignment(JLabel.CENTER);
        lowerPanel.add(listOfWishlistsLabel, BorderLayout.NORTH);
        // footer
        lowerFooterPanel = new JPanel();
        lowerFooterPanel.setBackground(Color.MAGENTA);
        lowerFooterPanel.setLayout(new FlowLayout());
        addWishlistButton = new JButton("Add Wishlist");
        lowerFooterPanel.add(addWishlistButton);
        lowerPanel.add(lowerFooterPanel, BorderLayout.SOUTH);
        // list of wishlists
        wishlistPanel = new JPanel();
        wishlistPanel.setBackground(Color.CYAN);
        wishlistPanel.setLayout(new GridLayout(0, 2));
        dummy1 = new JButton("d1");
        dummy2 = new JButton("d2");
        dummy3 = new JButton("d3");
        wishlistPanel.add(dummy1);
        wishlistPanel.add(dummy2);
        wishlistPanel.add(dummy3);
        lowerPanel.add(wishlistPanel, BorderLayout.CENTER);
        // assemble panels
        leftPanel.add(upperPanel);
        leftPanel.add(lowerPanel);

        addWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                AddWishlistPage addPage = new AddWishlistPage();
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
                // TODO
                // Currently, this navigates to MainAppLoginSignupPage.
                MainAppLoginSignupPage loginSignupPage = new MainAppLoginSignupPage();
                loginSignupPage.setContentPane(loginSignupPage.getMainPanel());
                loginSignupPage.setVisible(true);
                loginSignupPage.setLocationRelativeTo(null);
                loginSignupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

}
