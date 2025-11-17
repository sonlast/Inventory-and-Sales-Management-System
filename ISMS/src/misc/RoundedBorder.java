package misc;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

// Custom Border class to draw a rounded rectangle border
public class RoundedBorder extends AbstractBorder {
    private final Color color;
    private final int thickness;
    private final int radius;

    public RoundedBorder(Color color, int thickness, int radius) {
        this.color = color;
        this.thickness = thickness;
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable anti-aliasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the color and stroke
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));

        // Draw the rounded rectangle
        // Adjust bounds for thickness so the border is fully inside the component
        int adjustedX = x + thickness / 2;
        int adjustedY = y + thickness / 2;
        int adjustedWidth = width - thickness;
        int adjustedHeight = height - thickness;

        // Draw the rounded rectangle border
        g2.draw(new RoundRectangle2D.Double(adjustedX, adjustedY, adjustedWidth, adjustedHeight, radius, radius));

        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        // Defines the empty space required around the component's content to accommodate the border
        // We add the radius to the thickness to ensure padding for the curve
        int padding = radius / 2;
        return new Insets(padding + thickness, padding + thickness, padding + thickness, padding + thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        // Same logic as above
        int padding = radius / 2;
        insets.left = insets.right = insets.top = insets.bottom = padding + thickness;
        return insets;
    }
}