package misc;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    private final int radius;
    private int borderThickness = 2;     // default thickness
    private Color borderColor = Color.decode("#000000");  // default border color

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    // allow changing border thickness
    public void setBorderThickness(int thickness) {
        this.borderThickness = thickness;
        repaint();
    }

    // allow changing border color
    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Change color when pressed/hover
        Color bgColor = getBackground();
        if (getModel().isPressed()) {
            bgColor = bgColor.darker();
        } else if (getModel().isRollover()) {
            bgColor = bgColor.brighter();
        }

        // Draw rounded background
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Draw border
        if (borderThickness > 0) {
            g2.setStroke(new BasicStroke(borderThickness));
            g2.setColor(borderColor);
            int offset = borderThickness / 2;
            g2.drawRoundRect(offset, offset, getWidth() - borderThickness, getHeight() - borderThickness, radius, radius);
        }

        g2.dispose();

        // Draw the button text on top
        super.paintComponent(g);
    }
}
