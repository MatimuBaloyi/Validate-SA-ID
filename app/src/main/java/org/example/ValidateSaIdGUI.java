package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class ValidateSaIdGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SA ID Validator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Enter a South African ID Number:");
        JTextField textField = new JTextField();
        JButton validateButton = new JButton("Validate");
        JLabel resultLabel = new JLabel("");
        JLabel birthdateLabel = new JLabel("");
        JLabel genderLabel = new JLabel("");

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idNumber = textField.getText().trim();
                boolean isValid = ValidateSaId.isIdNumberValid(idNumber);
                if (isValid) {
                    resultLabel.setText("Valid ID number.");

                    var birthDate = ValidateSaId.getBirthDate(idNumber);
                    String gender = ValidateSaId.getGender(idNumber);

                    if (birthDate != null) {
                        String formattedDate = birthDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
                        birthdateLabel.setText("Birthdate: " + formattedDate);
                    } else {
                        birthdateLabel.setText("Birthdate: Invalid");
                    }

                    genderLabel.setText("Gender: " + gender);
                } else {
                    resultLabel.setText("Invalid ID number.");
                    birthdateLabel.setText("");
                    genderLabel.setText("");
                }
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(validateButton);
        panel.add(resultLabel);
        panel.add(birthdateLabel);
        panel.add(genderLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
