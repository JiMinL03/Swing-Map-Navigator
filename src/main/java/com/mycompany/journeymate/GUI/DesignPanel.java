package com.mycompany.journeymate.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DesignPanel {

    public JTextField createTextField(int columns, int width, int height, int fontSize) {
        JTextField textField = new JTextField(columns);
        textField.setPreferredSize(new Dimension(width, height));
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        Font font = new Font("Courier", Font.BOLD, fontSize);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        return textField;
    }

    public JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(600, 100));
        panel.setOpaque(false);

        JTextField title = createTextField(25, 600, 50, 18);
        title.setText("test");
        JTextField location = createTextField(20, 600, 50, 18);
        location.setText("location");
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(15, 0)));
        panel.add(location);
        return panel;
    }

    public JScrollPane createScrollPane(JPanel panel) {
        JScrollPane newScrollPane = new JScrollPane();
        newScrollPane.setBounds(panel.getBounds());

        newScrollPane.setViewportView(panel);

        newScrollPane.getViewport().setOpaque(false);
        newScrollPane.setOpaque(false);
        newScrollPane.setBorder(null);

        newScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // newScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //가로스크롤바 필요시 표시
        return newScrollPane;
    }
}
