package org.example;

import javax.swing.*;
import java.awt.*;

public class Grafika {
    public static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);

        // Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2)); // 6 rows for the components

        // Add a text input field
        JTextField textField = new JTextField(20);
        panel.add(new JLabel("Enter password:"));
        panel.add(textField);

        // Add radio buttons
        JRadioButton md5 = new JRadioButton("MD-5");
        JRadioButton sha = new JRadioButton("SHA-256");
        ButtonGroup radioGroup = new ButtonGroup(); // Group the radio buttons
        radioGroup.add(md5);
        radioGroup.add(sha);

        JPanel radioPanel = new JPanel();
        radioPanel.add(md5);
        radioPanel.add(sha);
        panel.add(new JLabel("Select an option:"));
        panel.add(radioPanel);

        JTextField generatedField = new JTextField(20);
        panel.add(new JLabel("Generated password:"));
        panel.add(generatedField);


        // Add a button
        JButton button = new JButton("Generate");
        button.addActionListener(e -> {
            if (md5.isSelected()) {
                generatedField.setText(Logika.computeMD5Hash(textField.getText()));
            }
            if (sha.isSelected()) {
                generatedField.setText(Logika.computeSHA256Hash(textField.getText()));
            }
        });
        panel.add(button);


        // Add the panel to the frame
        frame.add(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
