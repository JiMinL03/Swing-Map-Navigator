package com.mycompany.journeymate.GUI;

import com.mycompany.journeymate.API.Geocoding;
import com.mycompany.journeymate.API.StaticMap;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class InputMaplistGUI extends javax.swing.JFrame {
    
    StaticMap showMap = new StaticMap();
    Geocoding geo = new Geocoding();
    String panelName;
    String location = "동의대학교";
    int zoomLevel;
    int calculateZoomlevel = 0;

    public InputMaplistGUI(String panelName) {
        setUndecorated(true);
        this.panelName = panelName;
        initComponents();
        swingGUI();
        addEnterKeyListener();
        initScrollPane();
        textfield(inputTitle);
        textfield(inputPosition);
    }
    private void swingGUI() {
        fixingFrame();
        addImageLabel();
        addImageButt();
        coustombutton();
        inputTitle.setHorizontalAlignment(JTextField.CENTER);
    }
    private void fixingFrame() {
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
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
        endButt.setIcon(scaledIcon);
        checkButt.setIcon(scaledIcon);
    }
    public void coustombutton() {
        addBUTT.setOpaque(false);
        addBUTT.setContentAreaFilled(false);
        addBUTT.setBorderPainted(false);

        endButt.setOpaque(false);
        endButt.setContentAreaFilled(false);
        endButt.setBorderPainted(false);
        
        checkButt.setOpaque(false);
        checkButt.setContentAreaFilled(false);
        checkButt.setBorderPainted(false);
    }
    private void addEnterKeyListener() {
        inputPosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                location = inputPosition.getText();
                if (!location.equals("")) {
                    setMap(location, calculateZoomlevel);
                } else {
                    JOptionPane.showMessageDialog(null, "주소 정보를 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    public void setMap(String location, int calculateZoomlevel) {
        try {
            ArrayList<Double> coordinates = geo.geocode(location);
            this.zoomLevel = coordinates.get(2).intValue();
            if (calculateZoomlevel != 0) {
                this.zoomLevel = calculateZoomlevel;
            }
            showMap.downloadMap(geo.geocode(location), zoomLevel);
            ImageIcon mapIcon = showMap.getMap(showMap.downloadMap(geo.geocode(location), zoomLevel));
            map.setIcon(mapIcon);
            showMap.fileDelete(showMap.downloadMap(geo.geocode(location), zoomLevel));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "정확한 건물명을 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputPosition1 = new javax.swing.JTextField();
        background = new javax.swing.JPanel();
        closeBUTT1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputPosition = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        zoomInButt = new javax.swing.JButton();
        zoomOutButt = new javax.swing.JButton();
        addBUTT = new javax.swing.JButton();
        map = new javax.swing.JLabel();
        listPanel = new javax.swing.JPanel();
        inputTitle = new javax.swing.JTextField();
        endButt = new javax.swing.JButton();
        checkButt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        inputPosition1.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N
        inputPosition1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        inputPosition1.setOpaque(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 246, 189));

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

        jLabel1.setName("image"); // NOI18N

        inputPosition.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N
        inputPosition.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        inputPosition.setOpaque(false);

        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("추가하실 건물명을 입력해주세요.");

        zoomInButt.setBackground(new java.awt.Color(246, 215, 118));
        zoomInButt.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        zoomInButt.setForeground(new java.awt.Color(51, 153, 0));
        zoomInButt.setText("+");
        zoomInButt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        zoomInButt.setOpaque(false);
        zoomInButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomInButtActionPerformed(evt);
            }
        });

        zoomOutButt.setBackground(new java.awt.Color(246, 215, 118));
        zoomOutButt.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        zoomOutButt.setForeground(new java.awt.Color(51, 153, 0));
        zoomOutButt.setText("-");
        zoomOutButt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        zoomOutButt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        zoomOutButt.setOpaque(false);
        zoomOutButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomOutButtActionPerformed(evt);
            }
        });

        addBUTT.setBorder(null);
        addBUTT.setOpaque(false);
        addBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBUTTActionPerformed(evt);
            }
        });

        listPanel.setOpaque(false);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        inputTitle.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N
        inputTitle.setText("Title");
        inputTitle.setToolTipText("");
        inputTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        inputTitle.setOpaque(false);

        endButt.setBorder(null);
        endButt.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 51));
        jButton1.setText("<<");
        jButton1.setBorder(null);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(inputTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(closeBUTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(zoomInButt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(checkButt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(zoomOutButt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endButt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closeBUTT1)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addBUTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(zoomOutButt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkButt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zoomInButt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBUTT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBUTT1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeBUTT1ActionPerformed

    private void zoomInButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomInButtActionPerformed
        String location = inputPosition.getText();
        if (!location.equals("")) {
            calculateZoomlevel = 2;
            setMap(location, this.zoomLevel + calculateZoomlevel);
        } else {
            JOptionPane.showMessageDialog(null, "주소 정보를 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_zoomInButtActionPerformed

    private void zoomOutButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomOutButtActionPerformed
        String location = inputPosition.getText();
        if (!location.equals("")) {
            calculateZoomlevel = -2;
            setMap(location, this.zoomLevel + calculateZoomlevel);
        } else {
            JOptionPane.showMessageDialog(null, "주소 정보를 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_zoomOutButtActionPerformed
    private int panelCount = 0;
    private JScrollPane scrollPane; // JScrollPane 변수 추가

    private void initScrollPane() {
        scrollPane = createScrollPane();
        background.add(scrollPane);
    }
    private JScrollPane createScrollPane() {
        JScrollPane newScrollPane = new JScrollPane(listPanel);
        newScrollPane.setBounds(listPanel.getBounds());
        newScrollPane.setViewportView(listPanel);

        configureTransparentScrollPane(newScrollPane);

        return newScrollPane;
    }
    private void configureTransparentScrollPane(JScrollPane scrollPane) {
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // 가로스크롤바 필요시 표시
    }
    private void addNewPanel() {
        JPanel panel = createPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.add(panel);
        listPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        revalidateComponents();
        panelCount++;
    }
    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setMaximumSize(new Dimension(450, 100));
        panel.setOpaque(false);

        JTextField inputLocation = createTextField(450, 60, "위치를 입력해주세요.", "inputLocation");
        JTextField memo = createTextField(450, 40, "", "");

        panel.add(inputLocation);
        panel.add(memo);
        return panel;
    }
    private JTextField createTextField(int width, int height, String text, String name) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setText(text);
        textField.setName(name + panelCount);
        
        textfield(textField);
        return textField;
    }
    private void textfield(JTextField textField){
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        });
    }
    private void revalidateComponents() {
        listPanel.revalidate();
        scrollPane.revalidate();
    }
    private void addBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBUTTActionPerformed
        addNewPanel();
    }//GEN-LAST:event_addBUTTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MaplistGUI Maplist = new MaplistGUI();
        Maplist.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBUTT;
    private javax.swing.JPanel background;
    private javax.swing.JButton checkButt;
    private javax.swing.JButton closeBUTT1;
    private javax.swing.JButton endButt;
    private javax.swing.JTextField inputPosition;
    private javax.swing.JTextField inputPosition1;
    private javax.swing.JTextField inputTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel listPanel;
    private javax.swing.JLabel map;
    private javax.swing.JButton zoomInButt;
    private javax.swing.JButton zoomOutButt;
    // End of variables declaration//GEN-END:variables
}