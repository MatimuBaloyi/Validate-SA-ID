package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidateSaIdGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SA ID Validator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Enter a South African ID Number:");
        JTextField textField = new JTextField();
        JButton validateButton = new JButton("Validate");
        JLabel resultLabel = new JLabel("");

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idNumber = textField.getText().trim();
                boolean isValid = ValidateSaId.isIdNumberValid(idNumber);
                resultLabel.setText(isValid ? "Valid ID number." : " Invalid ID number.");
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(validateButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
