package pages;

import misc.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Admin extends JFrame {

    public Admin() {
        setTitle("Admin");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents();
    }

    private void center(JComponent... components) {
        for (JComponent c : components) {
            c.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }

    private void initComponents() {
        Font headerFont = new Font("Trebuchet MS", Font.BOLD, 24);
        Font textFieldLabelFont = new Font("Trebuchet MS", Font.BOLD, 17);
        Font textFieldFont = new Font("Trebuchet MS", Font.PLAIN, 12);
        Font signUpBtnFont = new Font("Trebuchet MS", Font.PLAIN, 12);
        Dimension buttonWH = new Dimension(140, 35);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(142, 180, 134));

        GridBagConstraints gbc = new GridBagConstraints();

        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/2.png")));
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(150, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Logo in top-left
        JLabel sideLogo = new JLabel(resizedIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(30, 80, 0, 0);
        gbc.weightx = 0;
        gbc.weighty = 0;
        mainPanel.add(sideLogo, gbc);

        // Sign-up text centered in frame but positioned below logo level
        JLabel headerText = new JLabel("SIGN UP (ADMIN)");
        headerText.setFont(headerFont);
        headerText.setForeground(Color.decode("#FFFFFF"));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 0, 0); // Adjust this to position it below the logo
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(headerText, gbc);

        JLabel emailText = new JLabel("EMAIL");
        emailText.setFont(textFieldLabelFont);
        emailText.setForeground(Color.decode("#FFFFFF"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(100, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(emailText, gbc);

        JTextField email = new RoundedTextField(25, 10, 10, Color.LIGHT_GRAY);
        email.setPreferredSize(new Dimension(150, 40));
        email.setBackground(Color.decode("#D9D9D9"));
        email.setFont(textFieldFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(130, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(email, gbc);

        JLabel pwdText = new JLabel("PASSWORD");
        pwdText.setFont(textFieldLabelFont);
        pwdText.setForeground(Color.decode("#FFFFFF"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(190, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(pwdText, gbc);

        JPanel passwordPanel = createPasswordFieldWithIcon();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(220, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(passwordPanel, gbc);

        JLabel repwdText = new JLabel("RE-ENTER PASSWORD");
        repwdText.setFont(textFieldLabelFont);
        repwdText.setForeground(Color.decode("#FFFFFF"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(280, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(repwdText, gbc);

        JPanel repasswordPanel = createPasswordFieldWithIcon();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(310, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(repasswordPanel, gbc);

        RoundedButton signUpBtn = new RoundedButton("SIGN UP", 40);
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBackground(Color.decode("#997C70"));
        signUpBtn.setFont(signUpBtnFont);
        signUpBtn.setPreferredSize(buttonWH);
        signUpBtn.setMinimumSize(buttonWH);
        signUpBtn.setMaximumSize(buttonWH);
        signUpBtn.setBorderThickness(0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(390, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(signUpBtn, gbc);

        add(mainPanel);
    }

    private JPanel createPasswordFieldWithIcon() {
        // Outer rounded container
        JPanel container = getJPanel();

        // Password field (NO rounded background anymore)
        RoundedPasswordTextField password = new RoundedPasswordTextField(0, 0, 0, Color.decode("#D9D9D9"));
        password.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // inner padding only
        password.setOpaque(false); // IMPORTANT: so it blends with container
        password.setPreferredSize(new Dimension(250, 40));
        password.setBackground(new Color(0, 0, 0, 0));
        password.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));

        // Show/Hide Icon
        ImageIcon showIcon = new ImageIcon(getClass().getResource("/icons/showpwd.png"));
        ImageIcon hideIcon = new ImageIcon(getClass().getResource("/icons/hidepwd.png"));

        showIcon = new ImageIcon(showIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        hideIcon = new ImageIcon(hideIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        JLabel eyeIcon = new JLabel(showIcon);
        eyeIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eyeIcon.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 10));

        ImageIcon finalShowIcon = showIcon;
        ImageIcon finalHideIcon = hideIcon;

        eyeIcon.addMouseListener(new MouseAdapter() {
            boolean visible = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                visible = !visible;
                if (visible) {
                    password.showPassword();
                    eyeIcon.setIcon(finalHideIcon);
                } else {
                    password.hidePassword();
                    eyeIcon.setIcon(finalShowIcon);
                }
            }
        });

        // Add components
        container.add(password, BorderLayout.CENTER);
        container.add(eyeIcon, BorderLayout.EAST);

        return container;
    }

    private JPanel getJPanel() {
        JPanel container = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(Color.decode("#D9D9D9"));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 35); // rounded box
            }
        };

        container.setLayout(new BorderLayout());
        container.setOpaque(false);
        container.setPreferredSize(new Dimension(275, 40)); // Wider field
        return container;
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> new Admin().setVisible(true));
    }
}