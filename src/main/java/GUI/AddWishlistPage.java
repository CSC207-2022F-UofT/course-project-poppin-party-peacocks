package GUI;

import GUI.RoundedBorder;
import GUI.WishlistPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWishlistPage extends JFrame {
    private JPanel mainPanel;
    private JLabel label;
    private JTextField nameField;
    private JPanel southPanel;
    private JButton cancelButton;
    private JButton createButton;

    private JPanel middlePanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public AddWishlistPage() {
        super("Add Wishlist");
        setLayout(null);
        setSize(400, 150);
        setResizable(false);

        // constants
        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 200);
        mainPanel.setBackground(color2);

        // top label
        label = new JLabel("Name your wishlist:");
        mainPanel.add(label, BorderLayout.NORTH);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.white);

        // text field
        nameField = new JTextField("", 20);
        mainPanel.setSize(400, 200);

        // middle panel
        middlePanel = new JPanel(new FlowLayout());
        middlePanel.add(nameField);
        middlePanel.setBackground(color1);

        // inception
        mainPanel.add(middlePanel, BorderLayout.CENTER);

        // bottom
        southPanel = new JPanel(new FlowLayout());
        cancelButton = new JButton("Cancel");
        cancelButton.setBorder(new RoundedBorder(5));
        cancelButton.setForeground(Color.white);

        createButton = new JButton("Add");
        createButton.setBorder(new RoundedBorder(5));
        createButton.setForeground(Color.white);

        southPanel.add(cancelButton);
        southPanel.add(createButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setBackground(color2);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                // Currently navigates to GUI.WishlistPage
                WishlistPage wlPage = new WishlistPage();
                wlPage.setContentPane(wlPage.getMainPanel());
                wlPage.setVisible(true);
                wlPage.setLocationRelativeTo(null);
                wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Returns to GUI.ListOfWishlistsPage
                HomePage listOfWL = new HomePage();
                listOfWL.setContentPane(listOfWL.getMainPanel());
                listOfWL.setVisible(true);
                listOfWL.setLocationRelativeTo(null);
                listOfWL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }
}
