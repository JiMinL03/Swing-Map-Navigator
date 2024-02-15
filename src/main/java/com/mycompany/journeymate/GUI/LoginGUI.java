package com.mycompany.journeymate.GUI;

import com.mycompany.journeymate.DB.Controller.LoginController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

public class LoginGUI extends javax.swing.JFrame {

    public LoginGUI() {
        setUndecorated(true);
        initComponents();
        fixingFrame();
        fixingButton();
        image();
        border();
    }

    private void fixingFrame() { //프레임 고정
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    private void fixingButton() {
        Font font = new Font("HY중고딕", Font.PLAIN, 20);
        loginButt.setFont(font);
    }

    private void image() {//label에 아이콘 넣는 메서드
        String imagePath = "/image/free-icon-placeholder-2536611.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));

        int width = 115;
        int height = 115;

        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        image.setHorizontalAlignment(JLabel.CENTER);  // 가운데 정렬
        image.setVerticalAlignment(JLabel.CENTER);  // 가운데 정렬
        image.setIcon(scaledIcon);  // 아이콘 설정
    }

    private void border() {//input 요소들마다 테두리를 넣어줌
        AbstractBorder border = new LineBorder(Color.black, 2);
        idInput.setBorder(border);
        pwInput.setBorder(border);
    }

    public ArrayList<String> sendData() {
        //입력받은 input 요소들을 새로운 변수의 값에 대입하고 array 타입으로 리턴한다.
        String id = idInput.getText();
        String pw = pwInput.getText();

        ArrayList<String> data = new ArrayList<>();
        data.add(id);
        data.add(pw);
        data.add("null");
        data.add("null");
        return data;
    }

    private boolean checkSpace() {
        if (idInput.getText().equals("") || pwInput.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButt = new javax.swing.JButton();
        idInput = new javax.swing.JTextField();
        pwInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        closeBUTT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginButt.setBackground(new java.awt.Color(111, 197, 81));
        loginButt.setFont(new java.awt.Font("HY중고딕", 0, 12)); // NOI18N
        loginButt.setText("확인");
        loginButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtActionPerformed(evt);
            }
        });

        idInput.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N

        pwInput.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("HY중고딕", 1, 12)); // NOI18N
        jLabel1.setText("아직 회원가입을 안하셨나요?");

        jButton1.setBackground(new java.awt.Color(111, 197, 81));
        jButton1.setFont(new java.awt.Font("HY그래픽M", 0, 12)); // NOI18N
        jButton1.setText("회원가입");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2.setText("JourneyMate");

        closeBUTT.setBackground(new java.awt.Color(242, 242, 242));
        closeBUTT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        closeBUTT.setForeground(new java.awt.Color(102, 204, 0));
        closeBUTT.setText("X");
        closeBUTT.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        closeBUTT.setOpaque(false);
        closeBUTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBUTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idInput)
                                .addComponent(pwInput, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(loginButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(97, 97, 97))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(394, 394, 394)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeBUTT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(closeBUTT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(loginButt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pwInput, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //확인 버튼을 누르면 회원가입 화면으로 넘어감
        RegisterGUI register = new RegisterGUI();
        register.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loginButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtActionPerformed
        if (checkSpace()) {
            ArrayList<String> dataToSend = sendData();
            LoginController user = new LoginController(dataToSend);
            JOptionPane.showMessageDialog(null, user.toMessage(), "알림", JOptionPane.INFORMATION_MESSAGE);
            if (user.toMessage().equals("다시 만나서 반가워요!")) {
                MaplistGUI map = new MaplistGUI();
                map.setVisible(true);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "빈칸을 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_loginButtActionPerformed

    private void closeBUTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBUTTActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeBUTTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBUTT;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButt;
    private javax.swing.JTextField pwInput;
    // End of variables declaration//GEN-END:variables
}
