package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * JPanel with customisable gradient background.
 */
public class GradientJPanel extends JPanel{
    // top colour for panel gradient
    private final Color topColor;
    // bottom colour for panel gradient
    private final Color bottomColor;

    /**
     * GradientJPanel basic constructor.
     * @param lm default parameter for JPanels to optionally initialise a layout manager.
     */
    public GradientJPanel(LayoutManager lm){
        super(lm);
        this.topColor = new Color(194, 234, 186);
        this.bottomColor = new Color(106, 189, 154);
    }

    /**
     * GradientJPanel gradient constructor.
     * @param lm default parameter for JPanels to optionally initialise a layout manager.
     * @param topColor gradient top colour.
     * @param bottomColor gradient bottom colour.
     */
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
        GradientPaint gp = new GradientPaint(w/2.0f, 0, topColor, w/2.0f, h, bottomColor);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
