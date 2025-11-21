package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import misc.RoundedButton;
import database.Person;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

//    public static void connect() {
//        Connection conn = null;
//
//        try {
//            // db parameters
//            String url = "jdbc:sqlite:temp.db";
//            conn = DriverManager.getConnection(url);
//            System.out.println("Connection to SQLite is succesful");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }
    public void SelectAll() {
        Person person;
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM Person";

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("Name") + '\t' + rs.getString("Sex"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertPerson(String name, String sex) {
        String sql = "INSERT INTO Person(Name, Sex) VALUES(?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, sex);
            pstmt.executeUpdate();
            System.out.println("Person added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePerson(int id, String name, String sex) {
        String sql = "UPDATE Person SET Name = ?, Sex = ?, WHERE person_id = ?";
        
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, sex);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Person update!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deletePerson(int id) {
        String sql = "DELETE FROM Person WHERE person_id = ?";
        
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Person deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection connect() {
        String url = "jdbc:mysql:Information.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Auth auth = new Auth();
            auth.setVisible(true);
//            auth.insertPerson("Aiah Arceta", "Female");
//            auth.insertPerson("Mikha Lim", "Female");
//            auth.insertPerson("Nicole Torres", "Female");
//            auth.insertPerson("Maloi Ricalde", "Female");
//            auth.updatePerson(3, "John Updated", "Male");
//            auth.deletePerson(2);
//            auth.SelectAll();
        });
    }
}
