import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton selectIndexButton;
    private int index;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static JPanel createPanel(String imagePath, String name, String cost, String description, int index) {
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
        JLabel indexLabel = new JLabel(Integer.toString(index));

        panel.add(indexLabel, BorderLayout.EAST);
        panel.add(centrePanel, BorderLayout.CENTER);
        panel.add(imageLabel, BorderLayout.WEST);
        return panel;
    }

    public void renderCentre() {
        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }

    public AddItemPage() {
        super("Add Item");
        setLayout(null);
        setSize(400, 600);
        setResizable(true);

        // constants
        Color color1 = new Color(194, 234, 186);
        Color color2 = new Color(106, 189, 154);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBounds(0, 0, 400, 600);
        // header
        headerPanel = new JPanel(new FlowLayout());
        headerPanel.setBackground(color2);
        searchLabel = new JLabel("Search:");
        searchLabel.setForeground(Color.white);
        searchBar = new JTextField("", 20);
        searchButton = new JButton("Go");
        headerPanel.add(searchLabel);
        headerPanel.add(searchBar);
        headerPanel.add(searchButton);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.setBackground(color1);

        // centre
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JPanel[] array = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            array[i] = createPanel(
                    "https://www.gardeningknowhow.com/wp-content/uploads/2021/05/whole-and-slices-watermelon.jpg",
                    "name",
                    "cost",
                    "description",
                    i + 1
            );
        }
        list = new JList<>(array);
        list.setCellRenderer(new PanelRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contentPanel.add(new JScrollPane(list));
        // Note: adding centre panel to main panel is done in renderCentre().

        // footer
        cancelButton = new JButton("Cancel");
        footerPanel = new JPanel(new FlowLayout());
        selectIndexButton = new JButton("Selected item: ");

        footerPanel.add(cancelButton);
        footerPanel.add(selectIndexButton);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BorderLayout layout = (BorderLayout) mainPanel.getLayout();
                    mainPanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException error) {
                    renderCentre();
                }
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

            Color defaultColor = new Color(238, 238, 238);
            Color selectedColor = new Color(0, 255, 0);

            if (isSelected) {
                BorderLayout layout = (BorderLayout) renderer.getLayout();
                layout.getLayoutComponent(BorderLayout.CENTER).setBackground(selectedColor);
                renderer.setBackground(defaultColor);
                renderer.setForeground(selectedColor);
                selectIndexButton.setText("Select item " + Integer.toString(index + 1));
            } else {
                BorderLayout layout = (BorderLayout) renderer.getLayout();
                layout.getLayoutComponent(BorderLayout.CENTER).setBackground(defaultColor);
                renderer.setBackground(defaultColor);
                renderer.setForeground(selectedColor);
            }
            return renderer;
        }
    }
}
