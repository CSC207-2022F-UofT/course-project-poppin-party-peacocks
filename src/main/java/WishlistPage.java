import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WishlistPage extends JFrame {
    private JPanel middlePanel;
    private JLabel thisWishlistLabel;
    private JPanel itemPanel;
    private JLabel middleWestLabel;
    private JLabel middleEastLabel;
    private JPanel middleFooterPanel;
    private JButton deleteThisWishlistButton;
    private JButton addItemButton;

    private JButton dummy4;
    private JButton dummy5;
    private JButton dummy6;

    public JPanel getMainPanel() {
        return middlePanel;
    }

    public WishlistPage() {
        super("Wishlist name here");
        setLayout(null);
        setSize(400, 638);
        setResizable(false);

        Color color = new Color(150, 75, 130);

        middlePanel = new JPanel(new BorderLayout(20, 20));
        middlePanel.setBackground(color);
        middlePanel.setBounds(400, 0, 400, 600);
        // top label (wishlist name)
        thisWishlistLabel = new JLabel("Get this wishlist title");
        thisWishlistLabel.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(thisWishlistLabel, BorderLayout.NORTH);
        // items
        itemPanel = new JPanel();
        itemPanel.setBackground(Color.PINK);
        itemPanel.setLayout(new GridLayout(0, 1));
        dummy4 = new JButton("d4");
        dummy5 = new JButton("d5");
        dummy6 = new JButton("d6");
        itemPanel.add(dummy4);
        itemPanel.add(dummy5);
        itemPanel.add(dummy6);
        middlePanel.add(itemPanel, BorderLayout.CENTER);
        // list padding
        middleWestLabel = new JLabel("");
        middlePanel.add(middleWestLabel, BorderLayout.WEST);
        middleEastLabel = new JLabel("");
        middlePanel.add(middleEastLabel, BorderLayout.EAST);
        // footer
        middleFooterPanel = new JPanel(new FlowLayout());
        middleFooterPanel.setBackground(Color.DARK_GRAY);
        // footer buttons
        deleteThisWishlistButton = new JButton("Delete this Entities.Wishlist");
        middleFooterPanel.add(deleteThisWishlistButton);
        addItemButton = new JButton("Add Entities.Item");
        middleFooterPanel.add(addItemButton);
        // add footer to middlePanel
        middlePanel.add(middleFooterPanel, BorderLayout.SOUTH);

        deleteThisWishlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                // Change middlePanel top label
//                thisWishlistLabel.setText("Choose a Entities.Wishlist");
//                // Reset itemPanel
//                middlePanel.remove(itemPanel);
//                itemPanel = new JPanel();
//                itemPanel.setBackground(Color.PINK);
//                itemPanel.setLayout(new GridLayout(0, 1));
//                middlePanel.add(itemPanel, BorderLayout.CENTER);
//                middlePanel.revalidate();
//                middlePanel.repaint();
                // TODO
            }
        });
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                ItemPage itemPage = new ItemPage();
                itemPage.setContentPane(itemPage.getMainPanel());
                itemPage.setVisible(true);
                itemPage.setLocationRelativeTo(null);
                itemPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }
}
