package pages;

import misc.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Staff2 extends JFrame {

    public Staff2() {
        setTitle("Staff");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        Font headerFont = new Font("Trebuchet MS", Font.BOLD, 24);
        Font textFieldLabelFont = new Font("Trebuchet MS", Font.BOLD, 17);
        Font textFieldFont = new Font("Trebuchet MS", Font.PLAIN, 12);
        Font forgotPasswordFont = new Font("Trebuchet MS", Font.PLAIN, 12);
        Font loginBtnFont = new Font("Trebuchet MS", Font.PLAIN, 12);
        Dimension buttonWH = new Dimension(140, 35);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(142, 180, 134));

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel backAndLogoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        backAndLogoPanel.setOpaque(false);
        backAndLogoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(backAndLogoPanel, gbc);

        // Back button & Logo in top-left
        ImageIcon backIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/back.png")));
        Image backImg = getHighQualityScaledImage(backIcon.getImage(), 25, 25);
        backIcon = new ImageIcon(backImg);

        RoundedButton backBtn = new RoundedButton("", 25);
        backBtn.setIcon(backIcon);
        backBtn.setHorizontalAlignment(SwingConstants.CENTER);
        backBtn.setVerticalAlignment(SwingConstants.CENTER);
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.setBorderThickness(0);
        backBtn.setAlignmentY(Component.CENTER_ALIGNMENT);
        backBtn.addActionListener(this::backBtn);
        backAndLogoPanel.add(backBtn);

        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/2.png")));
        Image originalImage = originalIcon.getImage();
        Image resizedImage = getHighQualityScaledImage(originalImage, 150, 34);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel sideLogo = new JLabel(resizedIcon);
        sideLogo.setAlignmentY(Component.CENTER_ALIGNMENT);
        backAndLogoPanel.add(sideLogo);

        // Sign-up text centered in frame but positioned below logo level
        JLabel headerText = new JLabel("LOG IN (STAFF)");
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
        gbc.insets = new Insets(80, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(emailText, gbc);

        JTextField email = new RoundedTextField(25, 10, 10, Color.LIGHT_GRAY);
        email.setPreferredSize(new Dimension(275, 40));
        email.setBackground(Color.decode("#D9D9D9"));
        email.setFont(textFieldFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(110, 0, 0, 0);
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
        gbc.insets = new Insets(170, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(pwdText, gbc);

        JPanel passwordPanel = createPasswordFieldWithIcon();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(200, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(passwordPanel, gbc);

        JLabel forgotPassword = new JLabel("Forgot Password?");
        forgotPassword.setFont(forgotPasswordFont);
        forgotPassword.setForeground(Color.decode("#FF0C0C"));
        forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(280, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;

        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                new ForgotPassword("staff").setVisible(true);
                dispose();
            }
        });

        mainPanel.add(forgotPassword, gbc);

        RoundedButton signUpBtn = new RoundedButton("LOG IN", 40);
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setBackground(Color.decode("#997C70"));
        signUpBtn.setFont(loginBtnFont);
        signUpBtn.setPreferredSize(buttonWH);
        signUpBtn.setMinimumSize(buttonWH);
        signUpBtn.setMaximumSize(buttonWH);
        signUpBtn.setBorderThickness(0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(370, 0, 0, 0);
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(signUpBtn, gbc);

        add(mainPanel);
    }

    private void backBtn(ActionEvent evt) {
        new Auth2().setVisible(true);
        this.dispose();
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
        ImageIcon showIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/showpwd.png")));
        ImageIcon hideIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/hidepwd.png")));

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

    private Image getHighQualityScaledImage(Image srcImg, int width, int height) {
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();

        return resizedImg;
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> new Staff2().setVisible(true));
    }
}