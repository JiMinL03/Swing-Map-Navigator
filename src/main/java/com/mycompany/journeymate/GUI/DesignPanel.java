package com.mycompany.journeymate.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
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

    public JPanel createPanel(String fromTitle, String fromLocation, String fromMemo, String fromStartTime, String fromEndTime) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setPreferredSize(new Dimension(500, 300));
        panel.setOpaque(false);

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Title: ");
        JTextField title = createTextField(25, 600, 50, 18);
        title.setText("test");
        titlePanel.add(titleLabel);
        titlePanel.add(title);

        JPanel locationPanel = new JPanel();
        JLabel locationLabel = new JLabel("Location: ");
        JTextField location = createTextField(25, 600, 50, 18);
        location.setText("location");
        locationPanel.add(locationLabel);
        locationPanel.add(location);

        JPanel memoPanel = new JPanel();
        JLabel memoLabel = new JLabel("Memo: ");
        JTextField memo = createTextField(25, 600, 50, 18);
        memo.setText("memo");
        memoPanel.add(memoLabel);
        memoPanel.add(memo);

        JPanel startTimePanel = new JPanel();
        JLabel startTimeLabel = new JLabel("ETD: ");
        JTextField startTime = createTextField(10, 600, 50, 18);
        startTime.setText("startTime");
        startTimePanel.add(startTimeLabel);
        startTimePanel.add(startTime);

        JPanel endTimePanel = new JPanel();
        JLabel endTimeLabel = new JLabel("ETA: ");
        JTextField endTime = createTextField(10, 600, 50, 18);
        endTime.setText("endTime");
        endTimePanel.add(endTimeLabel);
        endTimePanel.add(endTime);

        JButton goMap = new JButton("길찾기");
        panel.add(titlePanel);
        panel.add(locationPanel);
        panel.add(memoPanel);
        panel.add(startTimePanel);
        panel.add(endTimePanel);
        panel.add(goMap);
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
