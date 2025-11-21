package pages;

import misc.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class ForgotPassword extends JFrame {
    private String returnPage;

    public ForgotPassword(String returnPage) {
        this.returnPage = returnPage;
        setTitle("Forgot Password");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        Font headerFont = new Font("Trebuchet MS", Font.BOLD, 24);

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

        JLabel headerText = new JLabel("FORGOT PASSWORD");
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

        add(mainPanel);
    }

    private void backBtn(ActionEvent evt) {
        if ("admin".equals(returnPage)) {
            new Admin2().setVisible(true);
        } else {
            new Staff2().setVisible(true);
        }
        this.dispose();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ForgotPassword forgotPassword = new ForgotPassword("admin");
            forgotPassword.setVisible(true);
        });
    }
}
