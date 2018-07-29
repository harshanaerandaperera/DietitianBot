package View;

import java.util.TimerTask;
import javax.swing.JOptionPane;

//IT16083424 Perera P.A.H.E     SHU ID=27045240 
/**
 *
 * @author Harshana
 */
public class SignInUI extends javax.swing.JFrame {

    public SignInUI() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        txtUname = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        txtPwd = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        lblCreateAccount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loader = new javax.swing.JPanel();
        img_loader = new javax.swing.JLabel();
        lbl_loader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnl_bg.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                loginMouseDragged(evt);
            }
        });
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
        });
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUname.setBackground(new java.awt.Color(255, 255, 255));
        txtUname.setForeground(new java.awt.Color(102, 102, 102));
        txtUname.setToolTipText("Enter Your Email");
        txtUname.setBorder(null);
        txtUname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUnameFocusGained(evt);
            }
        });
        login.add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 302, 23));

        jSeparator1.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator1.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 302, 10));

        jSeparator2.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator2.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 302, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unlock_18px.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 31));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/contacts_18px.png"))); // NOI18N
        login.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, 31));

        lbl_close.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        lbl_close.setForeground(new java.awt.Color(51, 51, 51));
        lbl_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_close.setText("X");
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_closeMousePressed(evt);
            }
        });
        login.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 0, 27, -1));

        txtPwd.setBackground(new java.awt.Color(255, 255, 255));
        txtPwd.setForeground(new java.awt.Color(102, 102, 102));
        txtPwd.setBorder(null);
        txtPwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPwdFocusGained(evt);
            }
        });
        login.add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 302, 19));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login128.png"))); // NOI18N
        jLabel6.setText("Sign In");
        login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 230, 140));

        btnSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SignUp64.png"))); // NOI18N
        btnSignIn.setBorder(null);
        btnSignIn.setContentAreaFilled(false);
        btnSignIn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SignupPressed.png"))); // NOI18N
        btnSignIn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SignUprollover.png"))); // NOI18N
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        login.add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        lblCreateAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCreateAccount.setForeground(new java.awt.Color(51, 153, 255));
        lblCreateAccount.setText("Create Account");
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCreateAccountMousePressed(evt);
            }
        });
        login.add(lblCreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Don't have an account?");
        login.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        jPanel1.add(login, "card2");

        loader.setBackground(new java.awt.Color(255, 255, 255));
        loader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_loader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ring.gif"))); // NOI18N
        loader.add(img_loader, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 105, 139, 141));

        lbl_loader.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_loader.setForeground(new java.awt.Color(41, 168, 73));
        lbl_loader.setText("Loggin in....");
        loader.add(lbl_loader, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 276, -1, -1));

        jPanel1.add(loader, "card3");

        javax.swing.GroupLayout pnl_bgLayout = new javax.swing.GroupLayout(pnl_bg);
        pnl_bg.setLayout(pnl_bgLayout);
        pnl_bgLayout.setHorizontalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_bgLayout.setVerticalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txtUnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUnameFocusGained
        txtUname.setText("");
    }//GEN-LAST:event_txtUnameFocusGained

    private void txtPwdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPwdFocusGained
        txtPwd.setText("");
    }//GEN-LAST:event_txtPwdFocusGained

    private void lbl_closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMousePressed
        System.exit(0);
    }//GEN-LAST:event_lbl_closeMousePressed
    int xy, xx;
    private void loginMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_loginMouseDragged

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_loginMousePressed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed

        if ("user".equals(txtUname.getText()) && "user".equals(txtPwd.getText())) {
            loader.show();
            login.hide();

            // timeout
            new java.util.Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    UserUI U = new UserUI();
                    U.setVisible(true);
                    dispose();

                }
            }, 1000 * 2);

        }
        else if ("admin".equals(txtUname.getText()) && "admin".equals(txtPwd.getText())) {
            loader.show();
            login.hide();

            // timeout
            new java.util.Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    AdminUI AU = new AdminUI();
                    AU.setVisible(true);
                    dispose();

                }
            }, 1000 * 2);

        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid User !", " Sign In AI Dietitian", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSignInActionPerformed

    private void lblCreateAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateAccountMousePressed
        SignUpUI UU=new SignUpUI();
        UU.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblCreateAccountMousePressed

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
            java.util.logging.Logger.getLogger(SignInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new SignInUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JLabel img_loader;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCreateAccount;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_loader;
    private javax.swing.JPanel loader;
    private javax.swing.JPanel login;
    private javax.swing.JPanel pnl_bg;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
