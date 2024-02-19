package com.mycompany.journeymate.GUI;

import com.mycompany.journeymate.API.Geocoding;
import com.mycompany.journeymate.API.StaticMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MaplistGUI extends javax.swing.JFrame {

    String location = "동의대학교";
    StaticMap showMap = new StaticMap();
    Geocoding geo = new Geocoding();

    public MaplistGUI() {
        setUndecorated(true);
        initComponents();
        fixingFrame();
        addImageAddButt();
        addImageLabel();
        initScrollPane();
        addEnterKeyListener();
        setMap(location);
        showMap.fileDelete(location);
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

    private void addEnterKeyListener() {
        inputPosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 여기에 Enter 키 입력에 대한 액션을 추가
                location = inputPosition.getText();
                setMap(location);
            }
        });
    }
    
    ArrayList<Double> coordinates = geo.geocode(location);
    double latitude = coordinates.get(0);
    double longitude = coordinates.get(1);
    String fileName = latitude + "," + longitude;

    public void setMap(String location) {
        try {
            showMap.downloadMap(geo.geocode(location));
            ImageIcon mapIcon = showMap.getMap(showMap.downloadMap(geo.geocode(location)));
            map.setIcon(mapIcon);
            showMap.fileDelete(fileName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "잘못된 주소 정보입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        background = new javax.swing.JPanel();
        addBUTT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        closeBUTT1 = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        inputPosition = new javax.swing.JTextField();
        map = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 246, 189));

        addBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBUTTActionPerformed(evt);
            }
        });

        jLabel1.setName("image"); // NOI18N

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

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        inputPosition.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N
        inputPosition.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 204, 0)));
        inputPosition.setOpaque(false);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(0, 527, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(closeBUTT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addComponent(addBUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                                    .addComponent(inputPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(addBUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void closeBUTT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBUTT1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeBUTT1ActionPerformed

    private void addBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBUTTActionPerformed
        addNewPanel();
    }//GEN-LAST:event_addBUTTActionPerformed

    private int panelCount = 0;
    private JScrollPane scrollPane; // JScrollPane 변수 추가

    private void initScrollPane() {
        scrollPane = new JScrollPane(listPanel);
        scrollPane.setBounds(listPanel.getBounds()); // listPanel과 같은 위치와 크기로 설정

        // listPanel을 JScrollPane의 Viewport에 설정
        scrollPane.setViewportView(listPanel);

        // 스크롤 바를 투명하게 설정
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //가로스크롤바 필요시 표시       
        background.add(scrollPane);
    }

    private void addNewPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setMaximumSize(new Dimension(600, 60));

        String imagePath = "/image/check_14025690.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);

        JTextField textField = new JTextField(45);
        textField.setPreferredSize(new Dimension(400, 60)); // 원하는 크기로 조정 (가로, 세로)

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(15, 0))); // 간격을 더해줌
        panel.add(textField);

        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS)); // listPanel의 레이아웃을 BoxLayout으로 설정
        listPanel.add(panel);
        listPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 텍스트 필드 간의 간격                   

        listPanel.revalidate(); // 프레임을 다시 그리기
        scrollPane.revalidate(); // 스크롤바 갱신
        panelCount++;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBUTT;
    private javax.swing.JPanel background;
    private javax.swing.JButton closeBUTT1;
    private javax.swing.JTextField inputPosition;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel listPanel;
    private javax.swing.JLabel map;
    // End of variables declaration//GEN-END:variables
}
