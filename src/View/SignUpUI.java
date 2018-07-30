package View;

import Controller.Users;
import Controller.Validator;
import Models.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TimerTask;
import javax.swing.JOptionPane;

//IT16083424 Perera P.A.H.E     SHU ID=27045240 
/**
 *
 * @author Harshana
 */
public class SignUpUI extends javax.swing.JFrame {

    public Validator validator = new Validator();
    Users users = new Users();
    public User registerUser;
    public User currentUser;

    public SignUpUI() {
        initComponents();
        radMale.setActionCommand("Male");
        radFemale.setActionCommand("Female");

        DeserializeUsers();
    }

    /**
     * Serialize Users
     */
    public void SerializeUser() {
        try {
            FileOutputStream ufos = new FileOutputStream(new File("users.txt"));
            ObjectOutputStream uboos = new ObjectOutputStream(ufos);
            uboos.writeObject(users);
            uboos.flush();
            uboos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Deserialize Users
     */
    public void DeserializeUsers() {
        ObjectInputStream uois = null;
        File file = new File("users.txt");
        try {

            FileInputStream ufis = new FileInputStream(file);
            if (ufis.available() != 0) {
                uois = new ObjectInputStream(ufis);
                while (uois != null) {
                    users = (Users) uois.readObject();
                    System.out.println(this.users.size());
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radGrpGender = new javax.swing.ButtonGroup();
        pnl_bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        txtPwd = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        lblSignIn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtConfirmPwd = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtHeight = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
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

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setToolTipText("Name");
        txtName.setBorder(null);
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
        });
        login.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 302, 23));

        jSeparator1.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator1.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 302, 10));

        jSeparator2.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator2.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 302, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unlock_18px.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        login.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, -1, 31));

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
        login.add(lbl_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 27, -1));

        txtPwd.setBackground(new java.awt.Color(255, 255, 255));
        txtPwd.setForeground(new java.awt.Color(102, 102, 102));
        txtPwd.setToolTipText("Password");
        txtPwd.setBorder(null);
        txtPwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPwdFocusGained(evt);
            }
        });
        login.add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 302, 19));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login128.png"))); // NOI18N
        jLabel6.setText("Sign Up");
        login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 230, 140));

        btnSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SignUp64.png"))); // NOI18N
        btnSignUp.setBorder(null);
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SignupPressed.png"))); // NOI18N
        btnSignUp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SignUprollover.png"))); // NOI18N
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        login.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, -1, -1));

        lblSignIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSignIn.setForeground(new java.awt.Color(51, 153, 255));
        lblSignIn.setText("Sign in instead");
        lblSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSignInMousePressed(evt);
            }
        });
        login.add(lblSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Already have an account?");
        login.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 600, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator3.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 302, 10));

        txtConfirmPwd.setBackground(new java.awt.Color(255, 255, 255));
        txtConfirmPwd.setForeground(new java.awt.Color(102, 102, 102));
        txtConfirmPwd.setToolTipText("Confirm Password");
        txtConfirmPwd.setBorder(null);
        txtConfirmPwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmPwdFocusGained(evt);
            }
        });
        login.add(txtConfirmPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 302, 19));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unlock_18px.png"))); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        login.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, -1, 31));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circular-line-with-word-age-in-the-center.png"))); // NOI18N
        login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, 31));

        txtAge.setBackground(new java.awt.Color(255, 255, 255));
        txtAge.setForeground(new java.awt.Color(102, 102, 102));
        txtAge.setToolTipText("Age");
        txtAge.setBorder(null);
        txtAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAgeFocusGained(evt);
            }
        });
        login.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 302, 23));

        jSeparator4.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator4.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 302, 10));

        txtHeight.setBackground(new java.awt.Color(255, 255, 255));
        txtHeight.setForeground(new java.awt.Color(102, 102, 102));
        txtHeight.setToolTipText("Height");
        txtHeight.setBorder(null);
        txtHeight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHeightFocusGained(evt);
            }
        });
        login.add(txtHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 302, 23));

        jSeparator5.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator5.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 302, 10));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/height.png"))); // NOI18N
        login.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, 31));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gender.png"))); // NOI18N
        login.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, 31));

        txtWeight.setBackground(new java.awt.Color(255, 255, 255));
        txtWeight.setForeground(new java.awt.Color(102, 102, 102));
        txtWeight.setToolTipText("Weight");
        txtWeight.setBorder(null);
        txtWeight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtWeightFocusGained(evt);
            }
        });
        login.add(txtWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 302, 23));

        jSeparator6.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator6.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 302, 10));

        radGrpGender.add(radMale);
        radMale.setForeground(new java.awt.Color(0, 0, 0));
        radMale.setText("Male");
        radMale.setBorder(null);
        radMale.setContentAreaFilled(false);
        login.add(radMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        radGrpGender.add(radFemale);
        radFemale.setForeground(new java.awt.Color(0, 0, 0));
        radFemale.setText("Female");
        radFemale.setBorder(null);
        radFemale.setContentAreaFilled(false);
        login.add(radFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scale.png"))); // NOI18N
        login.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, 31));

        jSeparator7.setBackground(new java.awt.Color(41, 168, 73));
        jSeparator7.setForeground(new java.awt.Color(41, 168, 73));
        login.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 302, 10));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setToolTipText("Email");
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
        });
        login.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 302, 23));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/opened-email-envelope.png"))); // NOI18N
        login.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, 31));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
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


    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        txtName.setText("");
    }//GEN-LAST:event_txtNameFocusGained

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

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        String email = txtEmail.getText();
        String password1 = txtPwd.getText();
        String password2 = txtConfirmPwd.getText();

        if (validator.isValidEmail(email)) {

            if (validator.isUniqueEmail(email, users)) {
                if (validator.confirmPassword(password1, password2)) {
                    registerUser = new User(txtName.getText(), email, Integer.parseInt(txtAge.getText()), Double.parseDouble(txtHeight.getText()), Double.parseDouble(txtWeight.getText()), radGrpGender.getSelection().getActionCommand(), password2);
                    users.registerUser(registerUser);
                    currentUser = registerUser;
                    JOptionPane.showMessageDialog(null, "Register Successfully !", " password match ", JOptionPane.DEFAULT_OPTION);
                    SerializeUser();
                    loader.show();
                    login.hide();

                    // timeout
                    new java.util.Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {

                            UserUI U = new UserUI();
                            U.setVisible(true);
                            U.getCurrentUser(currentUser);
                            dispose();
                        }
                    }, 1000 * 2);

                } else {
                    JOptionPane.showMessageDialog(null, "Password Does Not match please Re enter the password !", " password match ", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // System.out.println(validator.validateEmail(email, users));
                JOptionPane.showMessageDialog(null, "Email is already used !", " email match ", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Email pattern !", " email ", JOptionPane.ERROR_MESSAGE);
        }

        // }
//        if ("user".equals(txtUname.getText()) && "user".equals(txtPwd.getText())) {
//            loader.show();
//            login.hide();
//
//            // timeout
//            new java.util.Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    UserUI U = new UserUI();
//                    U.setVisible(true);
//                    dispose();
//
//                }
//            }, 1000 * 2);
//
//        } else if ("admin".equals(txtUname.getText()) && "admin".equals(txtPwd.getText())) {
//            loader.show();
//            login.hide();
//
//            // timeout
//            new java.util.Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    AdminUI AU = new AdminUI();
//                    AU.setVisible(true);
//                    dispose();
//
//                }
//            }, 1000 * 2);
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Invalid User !", " Sign In AI Dietitian", JOptionPane.ERROR_MESSAGE);
//        }

    }//GEN-LAST:event_btnSignUpActionPerformed

    private void lblSignInMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMousePressed
        SignInUI IU = new SignInUI();
        IU.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblSignInMousePressed

    private void txtConfirmPwdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPwdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmPwdFocusGained

    private void txtAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAgeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeFocusGained

    private void txtHeightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHeightFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeightFocusGained

    private void txtWeightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtWeightFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailFocusGained

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
            java.util.logging.Logger.getLogger(SignUpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SignUpUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel img_loader;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblSignIn;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_loader;
    private javax.swing.JPanel loader;
    private javax.swing.JPanel login;
    private javax.swing.JPanel pnl_bg;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.ButtonGroup radGrpGender;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JTextField txtAge;
    private javax.swing.JPasswordField txtConfirmPwd;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
