/*
 * Mark White
 * CSD420
 * Assignment#10.2
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Fans extends JFrame {
    private JTextField idField, firstNameField, lastNameField, teamField;
    private JButton displayButton, updateButton;
    private Connection conn;

    public Fans() {
        super("Fan Manager");
        setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 20, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 20, 150, 25);
        add(idField);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(20, 60, 100, 25);
        add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(120, 60, 150, 25);
        add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(20, 100, 100, 25);
        add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(120, 100, 150, 25);
        add(lastNameField);

        JLabel teamLabel = new JLabel("Favorite Team:");
        teamLabel.setBounds(20, 140, 100, 25);
        add(teamLabel);

        teamField = new JTextField();
        teamField.setBounds(120, 140, 150, 25);
        add(teamField);

        displayButton = new JButton("Display");
        displayButton.setBounds(20, 180, 100, 25);
        add(displayButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(170, 180, 100, 25);
        add(updateButton);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasedb", "student1", "pass");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Connection failed: " + e.getMessage());
        }

        displayButton.addActionListener(e -> displayFan());
        updateButton.addActionListener(e -> updateFan());

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayFan() {
        try {
            int id = Integer.parseInt(idField.getText());
            PreparedStatement stmt = conn.prepareStatement("SELECT firstname, lastname, favoriteteam FROM fans WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No fan found with ID " + id);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updateFan() {
        try {
            int id = Integer.parseInt(idField.getText());
            String firstname = firstNameField.getText();
            String lastname = lastNameField.getText();
            String team = teamField.getText();

            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE id = ?"
            );
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, team);
            stmt.setInt(4, id);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Fan updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "No fan found with ID " + id);
            }
            stmt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Fans();
    }
}
