package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import misc.RoundedButton;

public class Auth extends JFrame {
    public Auth() {
        setTitle("SIGN UP");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/2.png"))).getImage());

        initComponents();
    }

    private void center(JComponent... components) {
        for (JComponent c : components) {
            c.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }

    private void initComponents() {
        final int BORDER_RADIUS = 40;

        Font headerFont = new Font("Trebuchet MS", Font.BOLD, 24);
        Font subHeaderFont = new Font("Trebuchet MS", Font.PLAIN, 14);
        Font options = new Font("Trebuchet MS", Font.BOLD, 18);
        Font contingencyFont = new Font("Trebuchet MS", Font.PLAIN, 12);
        Dimension buttonWH = new Dimension(130, 45);

        JPanel mainPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        JPanel contingencyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 0));
        JPanel adminPanel = new JPanel();
        JPanel staffPanel = new JPanel();
        mainPanel.setBackground(new Color(142, 180, 134));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        contingencyPanel.setOpaque(false);
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
        adminPanel.setOpaque(false);
        staffPanel.setLayout(new BoxLayout(staffPanel, BoxLayout.Y_AXIS));
        staffPanel.setOpaque(false);

        JLabel mainLogo = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/2.png"))));

        JLabel headerText = new JLabel("SIGN UP");
        headerText.setFont(headerFont);
        headerText.setForeground(Color.decode("#FFFFFF"));
        JLabel subHeaderText = new JLabel("as");
        subHeaderText.setFont(subHeaderFont);
        subHeaderText.setForeground(Color.decode("#FFFFFF"));
        headerPanel.add(headerText);
        headerPanel.add(subHeaderText);

        JButton adminBtn = new RoundedButton("ADMIN", BORDER_RADIUS);
        adminBtn.setFont(options);
        adminBtn.setForeground(Color.decode("#8EB486"));
        adminBtn.setPreferredSize(buttonWH);
        adminBtn.setMinimumSize(buttonWH);
        adminBtn.setMaximumSize(buttonWH);
        adminBtn.setBackground(Color.decode(("#FDF7F4")));
        adminBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminBtn.setContentAreaFilled(false);
        adminBtn.addActionListener(this::adminBtn);

        JButton staffBtn = new RoundedButton("STAFF", BORDER_RADIUS);
        staffBtn.setFont(options);
        staffBtn.setForeground(Color.decode("#8EB486"));
        staffBtn.setPreferredSize(buttonWH);
        staffBtn.setMinimumSize(buttonWH);
        staffBtn.setMaximumSize(buttonWH);
        staffBtn.setBackground(Color.decode("#FDF7F4"));
        staffBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        staffBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        staffBtn.setContentAreaFilled(false);
        staffBtn.addActionListener(this::staffBtn);

        JLabel contingencyText = new JLabel("Have an account? Log in");
        JLabel linkText = new JLabel("<html>here.</html>");
        contingencyText.setFont(contingencyFont);
        linkText.setFont(contingencyFont);
        linkText.setForeground(Color.decode("#AD3C3C"));
        linkText.setCursor(new Cursor(Cursor.HAND_CURSOR));

        linkText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                new Auth2().setVisible(true);
                dispose();
            }
        });

        contingencyPanel.add(contingencyText);
        contingencyPanel.add(linkText);

        adminPanel.add(adminBtn);
        staffPanel.add(staffBtn);

        center(mainLogo, headerPanel, headerText, subHeaderText, adminBtn, staffBtn, contingencyPanel, contingencyText, linkText);

        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(mainLogo);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(headerPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(adminPanel);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(staffPanel);
        mainPanel.add(Box.createVerticalStrut(40));
        mainPanel.add(contingencyPanel);

        add(mainPanel);
    }

    private void adminBtn(ActionEvent evt) {
        new Admin().setVisible(true);
        this.dispose();
    }

    private void staffBtn(ActionEvent evt) {
        new Staff().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Auth().setVisible(true));
    }
}