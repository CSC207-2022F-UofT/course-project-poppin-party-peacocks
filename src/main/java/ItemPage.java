import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class ItemPage extends JFrame {
    private JPanel rightPanel;
    private JLabel thisItemLabel;
    private JPanel rightPanelNORTH;
    private JLabel itemPriceLabel;
    private JPanel rightPanelCENTRE;
    private JLabel imageLabel;
    private JLabel description;
    private JLabel priceChange;
    private JLabel dateAdded;
    private JLabel url;
    private JPanel tagsColumnPanel;
    private JLabel tagLabel;
    private JPanel rightFooterPanel;
    private JButton deleteThisItemButton;

    public JPanel getMainPanel() {
        return rightPanel;
    }

    public ItemPage() {
        super("Item name here");
        setLayout(null);
        setSize(400, 638);
        setResizable(false);

        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.blue);
        rightPanel.setBounds(800, 0, 400, 600);
        // header
        rightPanelNORTH = new JPanel(new FlowLayout());
        rightPanelNORTH.setBackground(Color.darkGray);
        thisItemLabel = new JLabel("Get this item title");
        rightPanelNORTH.add(thisItemLabel);
        itemPriceLabel = new JLabel("$12.34");
        rightPanelNORTH.add(itemPriceLabel);
        rightPanel.add(rightPanelNORTH, BorderLayout.NORTH);
        // centre
        rightPanelCENTRE = new JPanel(new GridLayout(0, 1));
        rightPanelCENTRE.setBackground(Color.GRAY);
        // image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        Image image = null;
        Image resizedImage = null;
        try {
            URL url = new URL("https://www.gardeningknowhow.com/wp-content/uploads/2021/05/whole-and-slices-watermelon.jpg");
            image = ImageIO.read(url);
            resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        } catch (IOException e) {
            System.out.println("Image not found!");
        }
        rightPanelCENTRE.add(imageLabel);
        // item description
        description = new JLabel("This is an item description.");
        rightPanelCENTRE.add(description);
        // price chance
        priceChange = new JLabel("Price change:");
        rightPanelCENTRE.add(priceChange);
        // date added
        dateAdded = new JLabel("Date Added:");
        rightPanelCENTRE.add(dateAdded);
        // url
        url = new JLabel("INSERT URL HERE");
        rightPanelCENTRE.add(url);

        rightPanel.add(rightPanelCENTRE, BorderLayout.CENTER);
        // WEST side for tags
        tagsColumnPanel = new JPanel();
        tagsColumnPanel.setLayout(new BoxLayout(tagsColumnPanel, BoxLayout.Y_AXIS));
        tagsColumnPanel.setBackground(Color.red);
        String[] tags = {"a", "b", "c", "fjdksal;"};    // dummy tags
        for (String tag : tags) {
            tagLabel = new JLabel(tag);
            tagsColumnPanel.add(tagLabel);
        }
        rightPanel.add(tagsColumnPanel, BorderLayout.WEST);
        // footer
        rightFooterPanel = new JPanel(new FlowLayout());
        rightFooterPanel.setBackground(Color.YELLOW);
        deleteThisItemButton = new JButton("Delete this item");
        rightFooterPanel.add(deleteThisItemButton);
        // add footer to rightPanel
        rightPanel.add(rightFooterPanel, BorderLayout.SOUTH);

        deleteThisItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
    }
}
