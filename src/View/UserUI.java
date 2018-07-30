package View;

import Controller.DietMaths;
import Models.LUIS;
import Models.User;
import java.io.Serializable;

//IT16083424 Perera P.A.H.E     SHU ID=27045240 
/**
 *
 * @author Harshana
 */
public class UserUI extends javax.swing.JFrame implements Serializable {
    User currentUser;
    /**
     * Creates new form View
     */
    public UserUI() {
        initComponents();

    }
    /**
     * 
     * @param user 
     */
    public void getCurrentUser(User user){
        currentUser=user;
        txtUpdateUserName.setText(currentUser.getName());
        txtAge.setText(Integer.toString(currentUser.getAge()));
        txtWeight.setText(Double.toString(currentUser.getWeight()));
        txtHeight.setText(Double.toString(currentUser.getHeight()));
        
        lblUserEmail.setText(currentUser.getEmail());
        lblUserGender.setText(currentUser.getGender());
        System.out.println("Current User is"+currentUser.getName());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMainPanelUser = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnSendQuery = new javax.swing.JButton();
        txtUserQuery = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        check = new javax.swing.JLabel();
        lblJResponse = new javax.swing.JLabel();
        lbltopintentVal = new javax.swing.JLabel();
        lblSenAna = new javax.swing.JLabel();
        lblSenScore = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        cmbActivityLevel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbGoal = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtUpdateUserName = new javax.swing.JTextField();
        lblUserEmail = new javax.swing.JLabel();
        lblUserGender = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        btntestingpurpose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 33, 35));
        setUndecorated(true);
        setResizable(false);

        jTabbedPaneMainPanelUser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Query Sentiment Score:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 20));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 212, 10));

        btnSendQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send (64).png"))); // NOI18N
        btnSendQuery.setBorder(null);
        btnSendQuery.setContentAreaFilled(false);
        btnSendQuery.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send(32)red.png"))); // NOI18N
        btnSendQuery.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send(64)red.png"))); // NOI18N
        btnSendQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendQueryActionPerformed(evt);
            }
        });
        jPanel1.add(btnSendQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 80, 70));

        txtUserQuery.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtUserQuery.setToolTipText("");
        txtUserQuery.setBorder(null);
        jPanel1.add(txtUserQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 340, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chatbar.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 480, 90));

        check.setForeground(new java.awt.Color(255, 255, 255));
        check.setText("Top Score Intent");
        jPanel1.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        lblJResponse.setForeground(new java.awt.Color(255, 255, 255));
        lblJResponse.setText("Response");
        jPanel1.add(lblJResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        lbltopintentVal.setForeground(new java.awt.Color(255, 255, 255));
        lbltopintentVal.setText("Top Intent Score Val");
        jPanel1.add(lbltopintentVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 130, -1));

        lblSenAna.setForeground(new java.awt.Color(255, 255, 255));
        lblSenAna.setText("Query sentiment Analysis label");
        jPanel1.add(lblSenAna, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 170, -1));

        lblSenScore.setForeground(new java.awt.Color(255, 255, 255));
        lblSenScore.setText("Query Sentiment Score");
        jPanel1.add(lblSenScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Query sentiment Analysis label:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BOT Predicted Top Intent: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BOT Predicted Intent: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jTabbedPane1.addTab("                                                                                                    Welcome                                                                                                         ", jPanel1);

        jTabbedPaneMainPanelUser.addTab("          Assistant         ", jTabbedPane1);

        jTabbedPane3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(32, 33, 35));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Weight :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 118, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Height:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 171, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Age:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gender:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 230, -1, -1));

        txtWeight.setBackground(new java.awt.Color(32, 33, 35));
        txtWeight.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtWeight.setForeground(new java.awt.Color(255, 255, 255));
        txtWeight.setBorder(null);
        jPanel4.add(txtWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 116, 125, -1));

        txtHeight.setBackground(new java.awt.Color(32, 33, 35));
        txtHeight.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtHeight.setForeground(new java.awt.Color(255, 255, 255));
        txtHeight.setBorder(null);
        jPanel4.add(txtHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 171, 125, -1));

        txtAge.setBackground(new java.awt.Color(32, 33, 35));
        txtAge.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtAge.setForeground(new java.awt.Color(255, 255, 255));
        txtAge.setBorder(null);
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 125, -1));

        btnUpdate.setBackground(new java.awt.Color(38, 50, 56));
        btnUpdate.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update Profile");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 452, 1117, -1));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 143, 125, 10));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 198, 125, 10));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 67, 125, 10));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Activity Level :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 358, 111, -1));

        cmbActivityLevel.setForeground(new java.awt.Color(255, 255, 255));
        cmbActivityLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lightly active (moderate exercise but sedentary job)", "Moderately active (intense exercise but sedentary job)", "Very active (moderate exercise and active job)", "Extra active (intense exercise and active job)" }));
        jPanel4.add(cmbActivityLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 355, 349, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Goal :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 300, 57, -1));

        cmbGoal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fat Loss", "Maintenance" }));
        jPanel4.add(cmbGoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(786, 297, 148, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 60, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 50, -1));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 77, 188, 10));

        txtUpdateUserName.setBackground(new java.awt.Color(32, 33, 35));
        txtUpdateUserName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtUpdateUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUpdateUserName.setBorder(null);
        jPanel4.add(txtUpdateUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 50, 188, -1));

        lblUserEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblUserEmail.setText("...");
        jPanel4.add(lblUserEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 300, -1));

        lblUserGender.setForeground(new java.awt.Color(255, 255, 255));
        lblUserGender.setText("...");
        jPanel4.add(lblUserGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 230, 90, -1));

        jTabbedPane3.addTab("                                                     Edit Profile                                                      ", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneMainPanelUser.addTab("           Profile          ", jPanel5);

        jTabbedPane4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTabbedPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane4MouseClicked(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(32, 33, 35));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btntestingpurpose.setText("Testing App");
        btntestingpurpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntestingpurposeActionPerformed(evt);
            }
        });
        jPanel10.add(btntestingpurpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        jTabbedPane4.addTab("                                             Status                                          ", jPanel10);

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane4.addTab("                                         My Plan                                         ", jPanel2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneMainPanelUser.addTab("           Diet Chart          ", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        jTabbedPaneMainPanelUser.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Images/SignOut.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMainPanelUser)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMainPanelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jTabbedPaneMainPanelUser.getAccessibleContext().setAccessibleName("     Me     ");

        setSize(new java.awt.Dimension(1222, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
//        radMale.setActionCommand("M");
//        radFemale.setActionCommand("F");
//        String selectedOption=radGrpGender.getSelection().getActionCommand();
        // System.out.println(selectedOption);
        //System.out.println(cmbActivityLevel.getSelectedItem()); 
//       try {
//                    System.out.println(cmbActivityLevel.getSelectedIndex());
//
//        } catch (Exception e) {
//        e.printStackTrace();
//        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTabbedPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane4MouseClicked

    }//GEN-LAST:event_jTabbedPane4MouseClicked

    private void btnSendQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendQueryActionPerformed

        LUIS L = new LUIS();
        L.setQuery(txtUserQuery.getText());
        L.ProcessQuery();
        check.setText(L.getTopScoreIntent());
        lbltopintentVal.setText(L.getTopScoreIntentScore().toString());
        lblSenAna.setText(L.getSentimentAnalysisLabel());
        lblSenScore.setText(L.getSentimentAnalysisScore().toString());


    }//GEN-LAST:event_btnSendQueryActionPerformed

    private void btntestingpurposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntestingpurposeActionPerformed


    
        
        DietMaths t=new DietMaths();
      //  System.out.println(t.TDEE_M(88, 183, 29, 3));
      //  t.TDEE_M(88, 183, 29, 3);
       // System.out.println(t.BMI(80,180));
       t.MACRONUTRIENT(1, 2000);
   
    }//GEN-LAST:event_btntestingpurposeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendQuery;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btntestingpurpose;
    private javax.swing.JLabel check;
    private javax.swing.JComboBox<String> cmbActivityLevel;
    private javax.swing.JComboBox<String> cmbGoal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPaneMainPanelUser;
    private javax.swing.JLabel lblJResponse;
    private javax.swing.JLabel lblSenAna;
    private javax.swing.JLabel lblSenScore;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserGender;
    private javax.swing.JLabel lbltopintentVal;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtUpdateUserName;
    private javax.swing.JTextField txtUserQuery;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables

}
