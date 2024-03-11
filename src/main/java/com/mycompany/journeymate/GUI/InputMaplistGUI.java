package com.mycompany.journeymate.GUI;

import com.mycompany.journeymate.API.Geocoding;
import com.mycompany.journeymate.API.StaticMap;
import com.mycompany.journeymate.DB.Controller.UserDataController;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class InputMaplistGUI extends javax.swing.JFrame {

    private static ArrayList<String> returnLocation = new ArrayList<>();
    private static ArrayList<String> returnMemo = new ArrayList<>();
    private static ArrayList<String> returnStartTime = new ArrayList<>();
    private static ArrayList<String> returnEndTime = new ArrayList<>();
    private static ArrayList<Double> coordinates;

    StaticMap showMap = new StaticMap();
    Geocoding geo = new Geocoding();
    String location = "동의대학교";
    int zoomLevel;
    int calculateZoomlevel = 0;
    private static boolean isExceptionOccurred = false;
    String idInput;

    public InputMaplistGUI(String idInput) {
        this.idInput = idInput;
        setUndecorated(true);
        initComponents();
        swingGUI();
        addEnterKeyListener();
        initScrollPane();
        textfield(inputTitle);
    }

    private void swingGUI() {
        inputTitle.setVisible(false);
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
        String imagePath = "/image/check_14025690.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        endButt.setIcon(scaledIcon);
    }

    public void coustombutton() {
        endButt.setOpaque(false);
        endButt.setContentAreaFilled(false);
        endButt.setBorderPainted(false);
    }
    private boolean spaceTime = false;

    private void addEnterKeyListener() {
        inputPosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInput();
            }
        });
        inputPosition.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleSendButt();
            }
        });
    }
    boolean setInputTitle = false;

    private void handleInput() {
        if (!setInputTitle) {
            inputTitle.setVisible(true);
        }
        location = inputPosition.getText();
        if (!location.equals("")) {
            setMap(location, calculateZoomlevel);
            if (!isExceptionOccurred) {
                addNewPanel();
            }
            inputPosition.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "주소 정보를 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleSendButt() {
        if (spaceTime) {
            JOptionPane.showMessageDialog(null, "send 버튼을 눌러주세요", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setMap(String location, int calculateZoomlevel) {
        isExceptionOccurred = false;
        try {
            coordinates = geo.geocode(location);
            this.zoomLevel = coordinates.get(2).intValue();

            if (calculateZoomlevel != 0) {
                this.zoomLevel = calculateZoomlevel;
            }

            showMap.downloadMap(geo.geocode(location), zoomLevel);
            ImageIcon mapIcon = showMap.getMap(showMap.downloadMap(geo.geocode(location), zoomLevel));
            map.setIcon(mapIcon);
            showMap.fileDelete(showMap.downloadMap(geo.geocode(location), zoomLevel));
        } catch (Exception e) {
            isExceptionOccurred = true;
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
        map = new javax.swing.JLabel();
        listPanel = new javax.swing.JPanel();
        inputTitle = new javax.swing.JTextField();
        endButt = new javax.swing.JButton();
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

        listPanel.setOpaque(false);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
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
        endButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeBUTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(inputTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(endButt, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(8, 8, 8))
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
        panel.setMaximumSize(new Dimension(510, 150));
        panel.setOpaque(false);

        JTextField inputLocation = createTextField(510, 60, "위치를 입력해주세요.", "inputLocation");
        JTextField inputMemo = createTextField(510, 40, "", "");

        if (!isExceptionOccurred) {
            setLocationText(inputLocation, location);
        }

        setMemoText(inputMemo);

        JPanel timePanel = createTimePanel();

        panel.add(inputLocation);
        panel.add(inputMemo);
        panel.add(timePanel);
        return panel;
    }

    private JTextField createTextField(int width, int height, String text, String name) {
        Font fieldFont = new Font("Malgun Gothic", Font.BOLD, 16);
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setText(text);
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        textField.setBorder(new LineBorder(new Color(51, 204, 0), 2));
        textField.setFont(fieldFont);
        return textField;
    }

    private void textfield(JTextField textField) {
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

    private void setLocationText(JTextField inputLocation, String text) {
        inputLocation.setText(text);
        double latitude = coordinates.get(0);
        double longitude = coordinates.get(1);
        location = latitude + "," + longitude;
        returnLocation.add(location);
    }

    private void setMemoText(JTextField inputMemo) {
        String userMemo = JOptionPane.showInputDialog(null, "메모를 입력해주세요.");
        if (userMemo != null) {
            inputMemo.setText(userMemo);
            returnMemo.add(userMemo);
        }
    }
    ArrayList<JFormattedTextField> textFields;

    private JPanel createTimePanel() {
        textFields = new ArrayList<>();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(255, 246, 189));
        spaceTime = true;
        try {
            MaskFormatter formatter = new MaskFormatter("##:##"); // 시간 형식 지정
            formatter.setPlaceholderCharacter('_');

            JFormattedTextField departureTimeField = new JFormattedTextField(formatter);
            JFormattedTextField arrivalTimeField = new JFormattedTextField(formatter);

            DecorateTimeTextField(departureTimeField);
            DecorateTimeTextField(arrivalTimeField);

            panel.add(new JLabel("출발 시간:"));
            panel.add(departureTimeField);
            panel.add(Box.createVerticalStrut(10));
            panel.add(new JLabel("도착 시간:"));
            panel.add(arrivalTimeField);

            textFields.add(departureTimeField);
            textFields.add(arrivalTimeField);

            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> {
                saveValues(textFields);
                spaceTime = false;
            });

            panel.add(saveButton);
        } catch (Exception e) {
            System.out.println("setTime 오류");
        }
        return panel;
    }

    private void DecorateTimeTextField(JTextField textfield) {
        Font fieldFont = new Font("Arial", Font.BOLD, 18);
        textfield.setFont(fieldFont);
        textfield.setOpaque(false);
        textfield.setBorder(null);
    }

    private static void saveValues(ArrayList<JFormattedTextField> textFields) {
        if (textFields.size() == 2) {
            JFormattedTextField departureTimeField = textFields.get(0);
            JFormattedTextField arrivalTimeField = textFields.get(1);

            if (!departureTimeField.getText().equals("") && !arrivalTimeField.getText().equals("")) {
                returnStartTime.add(departureTimeField.getText().replaceAll("_", ""));
                returnEndTime.add(arrivalTimeField.getText().replaceAll("_", ""));
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MaplistGUI Maplist = new MaplistGUI(idInput);
        Maplist.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void endButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtActionPerformed
        ArrayList<ArrayList<String>> returnArraylist = new ArrayList<>();
        returnArraylist.add(returnLocation);
        returnArraylist.add(returnMemo);
        returnArraylist.add(returnStartTime);
        returnArraylist.add(returnEndTime);
        if (!inputTitle.getText().equals("Title") && !inputTitle.getText().equals("")) {
            UserDataController userdata = new UserDataController(idInput, inputTitle.getText(), returnArraylist);
            if (!userdata.toMessage()) {
                MaplistGUI maplist = new MaplistGUI(idInput);
                maplist.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "중복된 타이틀이 존재합니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "타이틀을 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_endButtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
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
    // End of variables declaration//GEN-END:variables
}
