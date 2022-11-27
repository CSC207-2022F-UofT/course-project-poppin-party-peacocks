package GUI;

import javax.swing.*;
import java.awt.*;

public class GradientJPanel extends JPanel{
    private Color topColor;
    private Color bottomColor;
    public GradientJPanel(LayoutManager lm, Color topColor, Color bottomColor){
        super(lm);
        this.topColor = topColor;
        this.bottomColor = bottomColor;
    }


    /*
    * Overrides the inherited paintComponent method from JPanel to accommodate a gradient for the background
    */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(w/2, 0, topColor, w/2, h, bottomColor);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
