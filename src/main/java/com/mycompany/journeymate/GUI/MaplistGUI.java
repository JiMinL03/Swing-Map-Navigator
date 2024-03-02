package com.mycompany.journeymate.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MaplistGUI extends javax.swing.JFrame {
    String idInput;
    public MaplistGUI(String idInput) {
        this.idInput = idInput;
        setUndecorated(true);
        initComponents();
        swingGUI();
        initScrollPane();
    }

    private void swingGUI() {
        fixingFrame();
        addImageButt();
        image();
    }

    private void fixingFrame() {
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    private void image() {//label에 아이콘 넣는 메서드
        String imagePath = "/image/free-icon-placeholder-2536611.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));

        int width = 79;
        int height = 73;

        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        jLabel1.setHorizontalAlignment(JLabel.CENTER);  // 가운데 정렬
        jLabel1.setVerticalAlignment(JLabel.CENTER);  // 가운데 정렬
        jLabel1.setIcon(scaledIcon);  // 아이콘 설정
    }

    public void addImageButt() {
        String imagePath = "/image/free-icon-add-148781.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        addBUTT.setIcon(scaledIcon);

        imagePath = "/image/check_14025690.png";
        icon = new ImageIcon(getClass().getResource(imagePath));
        scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaledImage);
        endButt2.setIcon(scaledIcon);
        cssButt();
    }

    private void cssButt() {
        addBUTT.setContentAreaFilled(false);
        addBUTT.setBorderPainted(false);
        endButt2.setOpaque(false);
        endButt2.setContentAreaFilled(false);
        endButt2.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        background = new javax.swing.JPanel();
        addBUTT = new javax.swing.JButton();
        closeBUTT1 = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        endButt = new javax.swing.JButton();
        endButt1 = new javax.swing.JButton();
        endButt2 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 246, 189));

        addBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBUTTActionPerformed(evt);
            }
        });

        closeBUTT1.setBackground(new java.awt.Color(242, 242, 242));
        closeBUTT1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        closeBUTT1.setForeground(new java.awt.Color(0, 153, 51));
        closeBUTT1.setText("X");
        closeBUTT1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        closeBUTT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBUTT1ActionPerformed(evt);
            }
        });

        listPanel.setOpaque(false);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        endButt.setBorder(null);
        endButt.setOpaque(false);

        endButt1.setBorder(null);
        endButt1.setOpaque(false);

        endButt2.setBorder(null);
        endButt2.setOpaque(false);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(addBUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endButt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 775, Short.MAX_VALUE)
                        .addComponent(closeBUTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(endButt)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(endButt1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBUTT, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(endButt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(closeBUTT1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(endButt)
                    .addGap(0, 516, Short.MAX_VALUE)))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(endButt1)
                    .addGap(0, 516, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBUTT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBUTT1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeBUTT1ActionPerformed

    private void addBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBUTTActionPerformed
        InputMaplistGUI InputMaplist = new InputMaplistGUI(idInput);
        InputMaplist.setVisible(true);
        dispose();
    }//GEN-LAST:event_addBUTTActionPerformed

    private int panelCount = 0;
    private JScrollPane scrollPane; // JScrollPane 변수 추가

    private void initScrollPane() {
        scrollPane = createScrollPane();
        background.add(scrollPane);
    }

    private JScrollPane createScrollPane() {
        JScrollPane newScrollPane = new JScrollPane(listPanel);
        newScrollPane.setBounds(listPanel.getBounds());

        // listPanel을 JScrollPane의 Viewport에 설정
        newScrollPane.setViewportView(listPanel);

        // 스크롤 바를 투명하게 설정
        newScrollPane.getViewport().setOpaque(false);
        newScrollPane.setOpaque(false);
        newScrollPane.setBorder(null);

        newScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // newScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //가로스크롤바 필요시 표시

        return newScrollPane;
    }

    private void addNewPanel() {
        JPanel panel = createPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.add(panel);
        listPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        listPanel.revalidate(); // 프레임을 다시 그리기
        scrollPane.revalidate(); // 스크롤바 갱신
        panelCount++;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setMaximumSize(new Dimension(600, 60));
        panel.setOpaque(false);

        String imagePath = "/image/check_14025690.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);

        JTextField textField = createTextField();
        String panelName = "panel" + panelCount;
        panel.setName(panelName);

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(15, 0)));
        panel.add(textField);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
        return panel;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(45);
        textField.setPreferredSize(new Dimension(400, 60));
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        return textField;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBUTT;
    private javax.swing.JPanel background;
    private javax.swing.JButton closeBUTT1;
    private javax.swing.JButton endButt;
    private javax.swing.JButton endButt1;
    private javax.swing.JButton endButt2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel listPanel;
    // End of variables declaration//GEN-END:variables
}
