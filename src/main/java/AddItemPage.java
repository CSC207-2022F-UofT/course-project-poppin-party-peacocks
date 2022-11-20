import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class AddItemPage extends JFrame {
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JLabel searchLabel;
    private JTextField searchBar;
    private JButton searchButton;
    private JPanel contentPanel;
    private JList<JPanel> list;
    private JButton cancelButton;
    private JPanel footerPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static JPanel createPanel(JButton button, String imagePath, String name, String cost, String description) {
        JPanel panel = new JPanel(new BorderLayout());
        // icon
        JLabel imageLabel = new JLabel();
        Image image = null;
        Image resizedImage = null;
        try {
            URL url = new URL(imagePath);
            image = ImageIO.read(url);
            resizedImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        } catch (IOException e) {
            System.out.println("Image not found!");
        }
        // text
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));
        JLabel nameLabel = new JLabel(name);
        JLabel costLabel = new JLabel(cost);
        JLabel descriptionLabel = new JLabel(description);
        centrePanel.add(nameLabel);
        centrePanel.add(costLabel);
        centrePanel.add(descriptionLabel);
        // select button
        JButton selectButton = new JButton("Select");


        panel.add(selectButton, BorderLayout.EAST);
        panel.add(centrePanel, BorderLayout.CENTER);
        panel.add(imageLabel, BorderLayout.WEST);
        return panel;
    }

    public AddItemPage() {
        super("Add Item");
        setLayout(null);
        setSize(400, 600);
        setResizable(true);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 600);
        // header
        headerPanel = new JPanel(new FlowLayout());
        searchLabel = new JLabel("Search:");
        searchBar = new JTextField("", 20);
        searchButton = new JButton("Go");
        headerPanel.add(searchLabel);
        headerPanel.add(searchBar);
        headerPanel.add(searchButton);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        // centre
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JButton[] buttons = new JButton[10];
        JPanel[] array = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            array[i] = createPanel(buttons[i], "https://www.gardeningknowhow.com/wp-content/uploads/2021/05/whole-and-slices-watermelon.jpg", "name", "cost", "description");
        }
        list = new JList<>(array);
        list.setCellRenderer(new PanelRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        list.addMouseListener(new MouseAdapter()
//        {
//            @Override
//            public void mouseClicked(MouseEvent event)
//            {
//                int index = list.locationToIndex(event.getPoint());
//                JPanel item = (JPanel) list.getModel().getElementAt(index);
//                item..doClick();
//            }
//        });
        contentPanel.add(new JScrollPane(list));

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        // footer
        cancelButton = new JButton("Cancel");
        footerPanel = new JPanel(new FlowLayout());
        footerPanel.add(cancelButton);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BorderLayout layout = (BorderLayout)mainPanel.getLayout();
                    mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException error) {
                    System.out.println("Caught");
                    // call a method that renders the centre panel
                }
                //mainPanel.add(contentPanel, BorderLayout.CENTER);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WishlistPage wlPage = new WishlistPage();
                wlPage.setContentPane(wlPage.getMainPanel());
                wlPage.setVisible(true);
                wlPage.setLocationRelativeTo(null);
                wlPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }
    class PanelRenderer implements ListCellRenderer {

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JPanel renderer = (JPanel) value;
            renderer.setBackground(isSelected ? Color.red : list.getBackground());
            Color defaultColor = new Color(255, 0, 0);
            Color selectedColor = new Color(0, 255, 0);
            if (isSelected) {
//                setBackground(list.getSelectionBackground());
//                setForeground(list.getSelectionForeground());
                ((JPanel) value).setBackground(selectedColor);
                ((JPanel) value).setForeground(selectedColor);
                System.out.println("dab" + index);
            } else {
//                setBackground(list.getBackground());
//                setForeground(list.getForeground());
                ((JPanel) value).setBackground(defaultColor);
                ((JPanel) value).setForeground(defaultColor);
            }
            return renderer;
        }
    }
}
