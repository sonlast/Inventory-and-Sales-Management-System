package misc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {
    private Shape shape;
    private int paddingLeft = 10;
    private int paddingRight = 10;
    private Color borderColor = Color.GRAY;

    public RoundedTextField(int size, int paddingLeft, int paddingRight, Color borderColor) {
        super(size);
        setOpaque(false);
        this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
        this.borderColor = borderColor;
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(borderColor);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
    }
    public Insets getInsets() {
        Insets insets = super.getInsets();
        insets.left += paddingLeft;
        insets.right += paddingRight;
        return insets;
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        }
        return shape.contains(x, y);
    }
}
