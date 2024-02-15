package com.mycompany.journeymate.GUI;

import com.mycompany.journeymate.DB.Controller.RegisterController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

public class RegisterGUI extends javax.swing.JFrame {

    public RegisterGUI() {
        initComponents();
        fixingFrame();
        image();
        border();
    }

    private void fixingFrame() { //frame 고정하는 역할
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    private void image() { //label에 아이콘 넣는 메서드
        String imagePath = "/image/free-icon-placeholder-2536611.png";
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));

        int width = 85;
        int height = 85;

        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        image.setHorizontalAlignment(JLabel.CENTER);  // 가운데 정렬
        image.setVerticalAlignment(JLabel.CENTER);  // 가운데 정렬
        image.setIcon(scaledIcon);  // 아이콘 설정
    }

    private void border() { //input 요소들마다 테두리를 넣어줌
        Color customColor = new Color(111, 197, 81);
        AbstractBorder border = new LineBorder(customColor, 2);
        idInput.setBorder(border);
        pwInput.setBorder(border);
        emailInput.setBorder(border);
        nameInput.setBorder(border);
    }

    public ArrayList<String> sendData() {
        //입력받은 input 요소들을 새로운 변수의 값에 대입하고 array 타입으로 리턴한다.
        String id = idInput.getText();
        String pw = pwInput.getText();
        String mail = emailInput.getText();
        String name = nameInput.getText();

        ArrayList<String> data = new ArrayList<>();
        data.add(id);
        data.add(pw);
        data.add(mail);
        data.add(name);

        return data;
    }

    private boolean checkSpace() {
        if (idInput.getText().equals("") || pwInput.getText().equals("") || emailInput.getText().equals("") || nameInput.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        pwInput = new javax.swing.JTextField();
        emailInput = new javax.swing.JTextField();
        nameInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        checkButt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Welcome :)");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setText("This is ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 204, 0));
        jLabel3.setText("JourneyMate!");

        idInput.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N

        pwInput.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N

        emailInput.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N

        nameInput.setFont(new java.awt.Font("HY중고딕", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("HY중고딕", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("회원가입");

        checkButt.setBackground(new java.awt.Color(111, 197, 81));
        checkButt.setFont(new java.awt.Font("HY중고딕", 0, 14)); // NOI18N
        checkButt.setText("확인");
        checkButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("HY중고딕", 0, 18)); // NOI18N
        jLabel5.setText("비밀번호 :");

        jLabel6.setFont(new java.awt.Font("HY중고딕", 0, 18)); // NOI18N
        jLabel6.setText("닉네임 :");

        jLabel7.setFont(new java.awt.Font("HY중고딕", 0, 18)); // NOI18N
        jLabel7.setText("아이디 :");

        jLabel8.setFont(new java.awt.Font("HY중고딕", 0, 18)); // NOI18N
        jLabel8.setText("이메일 :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameInput)
                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pwInput, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(idInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkButt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(187, 187, 187))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(201, 201, 201))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwInput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(checkButt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtActionPerformed
        //확인버튼을 클릭하면 로그인 화면으로 넘어가고 UserRespository에 값을 전달한다.
        if (checkSpace()) {
            ArrayList<String> dataToSend = sendData();
            RegisterController user = new RegisterController(dataToSend);

            JOptionPane.showMessageDialog(null, user.toMessage(), "알림", JOptionPane.INFORMATION_MESSAGE);
            if (!user.toMessage().equals("이미 존재하는 아이디입니다.")) {
                LoginGUI login = new LoginGUI();
                login.setVisible(true);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "빈칸을 입력해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_checkButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkButt;
    private javax.swing.JTextField emailInput;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField pwInput;
    // End of variables declaration//GEN-END:variables
}
