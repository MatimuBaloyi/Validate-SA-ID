package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.format.DateTimeFormatter;

public class ValidateSaIdGUI {
    // Color scheme
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185); // Blue
    private static final Color SUCCESS_COLOR = new Color(39, 174, 96); // Green
    private static final Color ERROR_COLOR = new Color(231, 76, 60); // Red
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241); // Light gray
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TEXT_COLOR = new Color(52, 73, 94); // Dark gray
    private static final Color SECONDARY_TEXT = new Color(127, 140, 141); // Medium gray

    public static void main(String[] args) {
        // Set system look and feel
        /*
         * try {
         * UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("South African ID Validator");
        frame.setMinimumSize(new Dimension(450, 350));
        frame.setPreferredSize(new Dimension(550, 450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.getContentPane().setBackground(BACKGROUND_COLOR);

        // Main panel with card-like appearance
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Card panel with responsive design
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBackground(CARD_COLOR);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(25, 25, 25, 25)));

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(CARD_COLOR);

        // Title
        JLabel titleLabel = new JLabel("ID Number Validator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(0, 0, 20, 0));

        // Subtitle
        JLabel subtitleLabel = new JLabel("Enter a 13-digit South African ID number", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(SECONDARY_TEXT);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setBorder(new EmptyBorder(0, 0, 25, 0));

        // Input panel with responsive layout
        JPanel inputPanel = new JPanel(new BorderLayout(15, 15));
        inputPanel.setBackground(CARD_COLOR);
        inputPanel.setBorder(new EmptyBorder(20, 0, 20, 0));

        JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 2),
                new EmptyBorder(12, 15, 12, 15)));
        textField.setBackground(Color.WHITE);
        textField.setForeground(TEXT_COLOR);
        textField.setPreferredSize(new Dimension(0, 45)); // Height only, width flexible

        // Add placeholder text effect
        String placeholder = "e.g., 8001015009087";
        textField.setText(placeholder);
        textField.setForeground(SECONDARY_TEXT);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(SECONDARY_TEXT);
                }
            }
        });

        // Styled button with responsive sizing
        JButton validateButton = new JButton("Validate");
        validateButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        validateButton.setBackground(PRIMARY_COLOR);
        validateButton.setForeground(Color.WHITE);
        validateButton.setFocusPainted(false);
        validateButton.setBorderPainted(false);
        validateButton.setBorder(new EmptyBorder(12, 20, 12, 20));
        validateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        validateButton.setPreferredSize(new Dimension(120, 45));

        // Button hover effect
        validateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                validateButton.setBackground(new Color(52, 152, 219));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                validateButton.setBackground(PRIMARY_COLOR);
            }
        });

        inputPanel.add(textField, BorderLayout.CENTER);
        inputPanel.add(validateButton, BorderLayout.EAST);

        // Results panel with flexible sizing
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(CARD_COLOR);
        resultsPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setBorder(new EmptyBorder(10, 0, 15, 0));

        // Info panel for birthdate and gender with flexible layout
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(CARD_COLOR);
        infoPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel birthdateLabel = new JLabel("", SwingConstants.CENTER);
        birthdateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        birthdateLabel.setForeground(TEXT_COLOR);
        birthdateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        birthdateLabel.setBorder(new EmptyBorder(5, 0, 5, 0));

        JLabel genderLabel = new JLabel("", SwingConstants.CENTER);
        genderLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        genderLabel.setForeground(TEXT_COLOR);
        genderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        genderLabel.setBorder(new EmptyBorder(5, 0, 5, 0));

        infoPanel.add(birthdateLabel);
        infoPanel.add(genderLabel);

        resultsPanel.add(resultLabel);
        resultsPanel.add(infoPanel);

        // Action listener
        ActionListener validateAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idNumber = textField.getText().trim();

                // Clear placeholder if present
                if (idNumber.equals(placeholder)) {
                    idNumber = "";
                }

                if (idNumber.isEmpty()) {
                    resultLabel.setText("Please enter an ID number");
                    resultLabel.setForeground(ERROR_COLOR);
                    birthdateLabel.setText("");
                    genderLabel.setText("");
                    return;
                }

                boolean isValid = ValidateSaId.isIdNumberValid(idNumber);
                if (isValid) {
                    resultLabel.setText("Valid ID Number");
                    resultLabel.setForeground(SUCCESS_COLOR);

                    var birthDate = ValidateSaId.getBirthDate(idNumber);
                    String gender = ValidateSaId.getGender(idNumber);

                    if (birthDate != null) {
                        String formattedDate = birthDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
                        birthdateLabel.setText("Date of Birth: " + formattedDate);
                    } else {
                        birthdateLabel.setText("Date of Birth: Invalid");
                    }

                    genderLabel.setText("Gender: " + gender);
                } else {
                    resultLabel.setText("Invalid ID Number");
                    resultLabel.setForeground(ERROR_COLOR);
                    birthdateLabel.setText("Please check the format and try again");
                    birthdateLabel.setForeground(SECONDARY_TEXT);
                    genderLabel.setText("");
                }
            }
        };

        validateButton.addActionListener(validateAction);
        textField.addActionListener(validateAction); // Allow Enter key to validate

        // Add components to header
        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);

        // Add components to card with responsive layout
        cardPanel.add(headerPanel, BorderLayout.NORTH);
        cardPanel.add(inputPanel, BorderLayout.CENTER);
        cardPanel.add(resultsPanel, BorderLayout.SOUTH);

        mainPanel.add(cardPanel, BorderLayout.CENTER);

        // Footer
        JLabel footerLabel = new JLabel("Validates South African ID numbers using the Luhn algorithm",
                SwingConstants.CENTER);
        footerLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        footerLabel.setForeground(SECONDARY_TEXT);
        footerLabel.setBorder(new EmptyBorder(15, 0, 0, 0));
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.pack(); // Auto-size based on content
        frame.setVisible(true);
    }
}