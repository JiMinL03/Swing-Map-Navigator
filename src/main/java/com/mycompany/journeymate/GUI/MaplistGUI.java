package com.mycompany.journeymate.GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

public class MaplistGUI extends javax.swing.JFrame {

    public MaplistGUI() {
        setUndecorated(true);
        initComponents();
        fixingFrame();
        addImageAddButt();
        addImageLabel();
    }

    private void fixingFrame() {
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    private void addImageAddButt() {
        // 이미지 파일 경로
        String imagePath = "/image/free-icon-add-148781.png";

        // 이미지 아이콘 생성 및 크기 조절
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // 아이콘을 버튼에 적용
        addBUTT.setIcon(scaledIcon);

        // 버튼의 배경과 테두리 제거
        addBUTT.setContentAreaFilled(false);
        addBUTT.setBorderPainted(false);

    }

    private void addImageLabel() { //label에 아이콘 넣는 메서드
        String imagePath = "/image/free-icon-user-8801434.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));

        Image scaledImage = icon.getImage().getScaledInstance(45, 41, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        jLabel1.setHorizontalAlignment(JLabel.CENTER);  // 가운데 정렬
        jLabel1.setVerticalAlignment(JLabel.CENTER);  // 가운데 정렬
        jLabel1.setIcon(scaledIcon);  // 아이콘 설정

    }

    private void border() {//input 요소들마다 테두리를 넣어줌
        Color customColor = new Color(111, 197, 81);
        AbstractBorder border = new LineBorder(customColor, 2);
        inputPosition.setBorder(border);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        background = new javax.swing.JPanel();
        addBUTT = new javax.swing.JButton();
        inputPosition = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        closeBUTT1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        listPanel = new javax.swing.JPanel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 246, 189));

        addBUTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBUTTMouseClicked(evt);
            }
        });
        addBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBUTTActionPerformed(evt);
            }
        });

        inputPosition.setBackground(new Color(0,0,0,0));
        inputPosition.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 0)));
        inputPosition.setOpaque(false);

        jLabel1.setName("image"); // NOI18N

        closeBUTT1.setBackground(new java.awt.Color(242, 242, 242));
        closeBUTT1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        closeBUTT1.setForeground(new java.awt.Color(0, 153, 51));
        closeBUTT1.setText("X");
        closeBUTT1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        closeBUTT1.setOpaque(false);
        closeBUTT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBUTT1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(closeBUTT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addComponent(addBUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(closeBUTT1)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(addBUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBUTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBUTTMouseClicked
    }//GEN-LAST:event_addBUTTMouseClicked

    private void closeBUTT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBUTT1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeBUTT1ActionPerformed

    private void addBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBUTTActionPerformed
        // TODO add your handling code here:
        addNewPanel();
    }//GEN-LAST:event_addBUTTActionPerformed
    private int panelCount = 0;
    private void addNewPanel() {
        JPanel panel = new JPanel();
        panel.setBounds(10, 50 + panelCount * 60, 200, 50);

        JLabel label = new JLabel("Label:");
        JTextField textField = new JTextField(10);

        panel.add(label);
        panel.add(textField);

        listPanel.add(panel);
        listPanel.revalidate(); // 프레임을 다시 그리기
        panelCount++;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBUTT;
    private javax.swing.JPanel background;
    private javax.swing.JButton closeBUTT1;
    private javax.swing.JTextField inputPosition;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel listPanel;
    // End of variables declaration//GEN-END:variables
}
