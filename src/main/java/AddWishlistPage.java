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

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public AddWishlistPage() {
        super("Add Wishlist");
        setLayout(null);
        setSize(400, 150);
        setResizable(false);

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 200);

        // top label
        label = new JLabel("Name your wishlist:");
        mainPanel.add(label, BorderLayout.NORTH);

        // text field
        nameField = new JTextField();
        mainPanel.add(nameField, BorderLayout.CENTER);

        // bottom
        southPanel = new JPanel(new FlowLayout());
        cancelButton = new JButton("Cancel");
        createButton = new JButton("Add");
        southPanel.add(cancelButton);
        southPanel.add(createButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                // Currently navigates to WishlistPage
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
                // Returns to ListOfWishlistsPage
                ListOfWishlistsPage listOfWL = new ListOfWishlistsPage();
                listOfWL.setContentPane(listOfWL.getMainPanel());
                listOfWL.setVisible(true);
                listOfWL.setLocationRelativeTo(null);
                listOfWL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }
}
