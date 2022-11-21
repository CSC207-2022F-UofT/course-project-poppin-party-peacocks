import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ListOfWishlistsPage extends JFrame {
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

    public JPanel getMainPanel() {
        return leftPanel;
    }

    public JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    public JButton createButton(String text, int prefWidth, int prefHeight, Color background, Color foreground, Font font) {
        JButton button = new JButton();
        button.setText(text);
        button.setFont(font);
        button.setBorder(new RoundedBorder(20));
        if (prefHeight > 0 && prefWidth > 0) {
            button.setPreferredSize(new Dimension(prefWidth, prefHeight));
        }
        button.setBackground(background);
        button.setForeground(foreground);
        return button;
    }

    public ListOfWishlistsPage() {
        super("My Wishlists");
        setLayout(null);
        setSize(400, 638);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                JFrame f = (JFrame)e.getSource();
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
        signoutButton = createButton("Sign Out", 150, 30, color2, Color.WHITE, font1);
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
        addWishlistButton = createButton("Add Wishlist", 150, 30, color2, Color.WHITE, font1);
        lowerFooterPanel.add(addWishlistButton);
        lowerPanel.add(lowerFooterPanel, BorderLayout.SOUTH);
        // list of wishlists
        wishlistPanel = new JPanel();
        wishlistPanel.setPreferredSize(new Dimension(400, this.getHeight() - 338));
        wishlistPanel.setBackground(Color.WHITE);
        FlowLayout layout = new FlowLayout();
        wishlistPanel.setLayout(layout);

        for (int i = 0; i < 10; i++) {
            dummyButton = createButton("dummyButton" + Integer.toString(i), 0, 0, Color.WHITE, color2, font1);
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
