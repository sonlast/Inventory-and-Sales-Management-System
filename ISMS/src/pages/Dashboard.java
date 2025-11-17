package pages;

import javax.swing.*;
import java.util.Objects;

public class Dashboard extends javax.swing.JFrame {
    public Dashboard() {
        setTitle("DASHBOARD");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/2.png"))).getImage());

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new java.awt.Color(142, 180, 134));
        getContentPane().add(mainPanel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }
}
