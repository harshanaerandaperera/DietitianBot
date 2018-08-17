package View;

import Controller.DietMaths;
import Controller.SetOfMealPlans;
import Controller.SetOfUsers;
import Controller.Validator;
import Models.LUIS;
import Models.MealPlan;
import Models.User;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//IT16083424 Perera P.A.H.E     SHU ID=27045240 
/**
 *
 * @author Harshana
 */
public class UserUI extends javax.swing.JFrame implements Serializable {

    User currentUser;
    SetOfUsers users = new SetOfUsers();
    DietMaths dm = new DietMaths();
    SetOfMealPlans mealPlans = new SetOfMealPlans();
    SetOfMealPlans myPlans = new SetOfMealPlans();
    MealPlan currentMealPlan = new MealPlan();
    int TDEE;
    double BMI;
    String recommandation;
    LUIS L = new LUIS();
    Validator V = new Validator();
    StringBuilder sb = new StringBuilder();
    StyledDocument doc;
    Style style;

    /**
     * Creates new form View
     */
    public UserUI() {
        initComponents();
        DeserializeUsers();
        DeserializeMealPlans();
        doc = txtAssistant.getStyledDocument();
        style = txtAssistant.addStyle("", null);

        //set Transparent to txtAssistant 
        jScrollPane4.getViewport().setOpaque(false);
        jScrollPane4.setBorder(null);
        jScrollPane4.setViewportBorder(null);
        txtAssistant.setOpaque(false);
        txtAssistant.setBorder(null);
        txtAssistant.setBackground(new Color(0, 0, 0, 0));

    }

    /**
     *
     * @param user
     */
    public void getCurrentUser(User user) {
        currentUser = user;
        populateGoalsToComboBox(currentUser.getGoal());
        populateActivityLevelToComboBox(currentUser.getActivityLevel());
        createProfile();
        showBMI();
        getTDEE();
        getMyPlan();
        jTabbedPaneAssistant.setTitleAt(0, "                                                                                       Welcome " + currentUser.getName() + "                                                                                                                                                                                                                       ");

        System.out.println("Current User is: " + currentUser.getName());

        sb.append("  Hi " + currentUser.getName() + " How can i help ?");

        giveBotResponse();
    }

    public void createProfile() {
        txtUpdateUserName.setText(currentUser.getName());
        txtAge.setText(Integer.toString(currentUser.getAge()));
        txtWeight.setText(Double.toString(currentUser.getWeight()));
        txtHeight.setText(Double.toString(currentUser.getHeight()));
        lblUserEmail.setText(currentUser.getEmail());
        lblUserGender.setText(currentUser.getGender());
        jTabbedPaneAssistant.setTitleAt(0, "                                                                                       Welcome " + currentUser.getName() + "                                                                                                                                                                                                                       ");
        showBMI();
        getTDEE();

        System.out.println("Profile created");

    }

    public void showBMI() {
        lblUserBMI.setText(Double.toString(dm.BMI(currentUser.getWeight(), currentUser.getHeight())));
        lblUserBMIProfile.setText(Double.toString(dm.BMI(currentUser.getWeight(), currentUser.getHeight())));
        BMI = dm.BMI(currentUser.getWeight(), currentUser.getHeight());
        showRecomendation();
        System.out.println("Current User BMI: " + dm.BMI(currentUser.getWeight(), currentUser.getHeight()));
    }

    public void showRecomendation() {

        StringBuilder sbrecomendations = new StringBuilder();

        if (this.BMI < 18.5) {
            sbrecomendations.append("\n");

            sbrecomendations.append("You are Under Weight !");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Proper Recommandation");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Treatments");

            sbrecomendations.append("\n");

            recommandation = sbrecomendations.toString();
            txtUserRecommandation.setText(recommandation);

            sbrecomendations.setLength(0);
        }
        if (this.BMI >= 18.5 && this.BMI < 24.9) {
            sbrecomendations.append("\n");

            sbrecomendations.append("Healthy weight");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Proper Recommandation");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Treatments");

            sbrecomendations.append("\n");

            recommandation = sbrecomendations.toString();
            txtUserRecommandation.setText(recommandation);

            sbrecomendations.setLength(0);

        }
        if (this.BMI >= 24.9 && this.BMI < 29.9) {

            sbrecomendations.append("\n");

            sbrecomendations.append("Overweight");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Proper Recommandation");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Treatments");

            sbrecomendations.append("\n");

            recommandation = sbrecomendations.toString();
            txtUserRecommandation.setText(recommandation);

            sbrecomendations.setLength(0);
        }
        if (this.BMI >= 29.9) {

            sbrecomendations.append("\n");
            sbrecomendations.append("Obese");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Proper Recommandation");
            sbrecomendations.append("\n");
            sbrecomendations.append("\n");

            sbrecomendations.append("Treatments");

            sbrecomendations.append("\n");

            recommandation = sbrecomendations.toString();
            txtUserRecommandation.setText(recommandation);

            sbrecomendations.setLength(0);

        }
    }

    public void getTDEE() {

        //for newly created user
        if (this.currentUser.getActivityLevel() == null && this.currentUser.getGoal() == null) {
            System.out.println("cal IDEE for new user");

        } else {
            //maintainance
            if (cmbGoal.getSelectedIndex() == 0) {
                System.out.println("Index 0");

                if (currentUser.getGender().equals("Male")) {
                    TDEE = dm.TDEE_M(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex());
                    lblUserTDEE1.setText(Double.toString(dm.TDEE_M(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex())));

                } else if (currentUser.getGender().equals("Female")) {
                    TDEE = dm.TDEE_F(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex());
                    lblUserTDEE1.setText(Double.toString(dm.TDEE_F(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex())));
                }

            }
            if (cmbGoal.getSelectedIndex() == 1) {
                System.out.println("index 1 cmbGoal");

                TDEE = TDEE - 250;
                lblUserTDEE1.setText(Double.toString(TDEE));
                System.out.println("Reduced Tdee" + TDEE);

            }
        }

//Orignal Code Here
//        if (currentUser.getGender().equals("Male")) {
//            TDEE = dm.TDEE_M(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex());
//            System.out.println("calorie Requirement of " + currentUser.getEmail() + " is " + dm.TDEE_M(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex()));
//            lblUserTDEE1.setText(Double.toString(dm.TDEE_M(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex())));
//
//        } else if (currentUser.getGender().equals("Female")) {
//            TDEE = dm.TDEE_F(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex());
//            System.out.println("calorie Requirement of " + currentUser.getEmail() + " is " + dm.TDEE_F(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex()));
//            lblUserTDEE1.setText(Double.toString(dm.TDEE_F(currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge(), cmbActivityLevel.getSelectedIndex())));
//
        //   }
    }

    public void populateMealPlanDetailsToComboBox() {
        for (int i = 0; i < myPlans.size(); i++) {
            cmbMyMealPlans.addItem("-" + myPlans.get(i).getId() + "-   " + myPlans.get(i).getName());
        }

    }

    public String getMatchedMealPlanId(String cmbValue) {
        Pattern p = Pattern.compile("[0-9]{1,13}(\\.[0-9]*)?");
        Matcher m = p.matcher(cmbValue);
        if (m.find()) {
            return m.group();
        } else {
            return null;
        }
    }

    public void getMyPlan() {
        for (int i = 0; i < mealPlans.size(); i++) {

            if (TDEE > 0 && TDEE <= 250) {

                if (mealPlans.get(i).getCalorieAmount() > 0 && mealPlans.get(i).getCalorieAmount() <= 250) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }
            if (TDEE > 250 && TDEE <= 500) {

                if (mealPlans.get(i).getCalorieAmount() > 250 && mealPlans.get(i).getCalorieAmount() <= 500) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

            if (TDEE > 500 && TDEE <= 750) {

                if (mealPlans.get(i).getCalorieAmount() > 500 && mealPlans.get(i).getCalorieAmount() <= 750) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

            if (TDEE > 750 && TDEE <= 1000) {

                if (mealPlans.get(i).getCalorieAmount() > 750 && mealPlans.get(i).getCalorieAmount() <= 1000) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

            if (TDEE > 1000 && TDEE <= 1250) {

                if (mealPlans.get(i).getCalorieAmount() > 1000 && mealPlans.get(i).getCalorieAmount() <= 1250) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

            if (TDEE > 1250 && TDEE <= 1500) {

                if (mealPlans.get(i).getCalorieAmount() > 1250 && mealPlans.get(i).getCalorieAmount() <= 1500) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

            if (TDEE > 1500 && TDEE <= 1750) {

                if (mealPlans.get(i).getCalorieAmount() > 1500 && mealPlans.get(i).getCalorieAmount() <= 1750) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

            if (TDEE > 1750 && TDEE <= 2000) {

                if (mealPlans.get(i).getCalorieAmount() > 1750 && mealPlans.get(i).getCalorieAmount() <= 2000) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

            if (TDEE > 2000 && TDEE <= 2250) {

                if (mealPlans.get(i).getCalorieAmount() > 2000 && mealPlans.get(i).getCalorieAmount() <= 2250) {

                    myPlans.addMealPlan(mealPlans.get(i));
                }

            }

        }
        populateMealPlanDetailsToComboBox();
        System.out.println("My plan size: " + myPlans.size());
    }

    public void generateMyPlan() {
        if (myPlans.size() != 0) {
            myPlans = new SetOfMealPlans();
            System.out.println("creted new object");
            try {
                for (int i = cmbMyMealPlans.getItemCount() - 1; i >= 1; i--) {
                    cmbMyMealPlans.removeItemAt(i);
                    lblMealPlanTotalCalorieAmount.setText("");
                    txtBreakfastUserMealPlan.setText("");
                    txtLunchUserMealPlan.setText("");
                    txtDinnerUserMealPlan.setText("");
                    txtSnackUserMealPlan.setText("");

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void populateGoalsToComboBox(String goal) {
        cmbGoal.setSelectedItem(goal);
    }

    public void populateActivityLevelToComboBox(String ActivityLevel) {
        cmbActivityLevel.setSelectedItem(ActivityLevel);
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
        jTabbedPaneAssistant = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnSendQuery = new javax.swing.JButton();
        txtUserQuery = new javax.swing.JTextField();
        lblChatBarImage = new javax.swing.JLabel();
        lblSenAna = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAssistant = new javax.swing.JTextPane();
        lblAssistantImage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPaneEditProfile = new javax.swing.JTabbedPane();
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
        lblUserBMIProfile = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblProfileImage = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblUserBMI = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblUserTDEE1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtUserRecommandation = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        cmbMyMealPlans = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBreakfastUserMealPlan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLunchUserMealPlan = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDinnerUserMealPlan = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtSnackUserMealPlan = new javax.swing.JTextArea();
        jLabel38 = new javax.swing.JLabel();
        lbldisplayTotCal = new javax.swing.JLabel();
        lblMealPlanTotalCalorieAmount = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtNutrition = new javax.swing.JTextArea();
        jLabel39 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 33, 35));
        setUndecorated(true);
        setResizable(false);

        jTabbedPaneMainPanelUser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTabbedPaneMainPanelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMainPanelUserMouseClicked(evt);
            }
        });

        jTabbedPaneAssistant.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 51, 153));
        jPanel1.setOpaque(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSendQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send (64).png"))); // NOI18N
        btnSendQuery.setBorder(null);
        btnSendQuery.setContentAreaFilled(false);
        btnSendQuery.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send(32)red.png"))); // NOI18N
        btnSendQuery.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send(64)red.png"))); // NOI18N
        btnSendQuery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSendQueryMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSendQueryMouseReleased(evt);
            }
        });
        btnSendQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendQueryActionPerformed(evt);
            }
        });
        jPanel1.add(btnSendQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 430, 80, 70));

        txtUserQuery.setBackground(new java.awt.Color(241, 242, 246));
        txtUserQuery.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtUserQuery.setToolTipText("Please Enter your message!! ");
        txtUserQuery.setBorder(null);
        jPanel1.add(txtUserQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 1100, 50));

        lblChatBarImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bar.png"))); // NOI18N
        jPanel1.add(lblChatBarImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 420, 1270, 90));

        lblSenAna.setBackground(new java.awt.Color(153, 153, 153));
        lblSenAna.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblSenAna.setForeground(new java.awt.Color(204, 204, 204));
        lblSenAna.setText("...");
        jPanel1.add(lblSenAna, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 400, 170, -1));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setOpaque(false);
        jScrollPane4.setRequestFocusEnabled(false);

        txtAssistant.setEditable(false);
        txtAssistant.setBorder(null);
        txtAssistant.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txtAssistant.setOpaque(false);
        jScrollPane4.setViewportView(txtAssistant);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1180, 370));

        lblAssistantImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ABackground.png"))); // NOI18N
        jPanel1.add(lblAssistantImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1240, 520));

        jTabbedPaneAssistant.addTab("                                                                                                    Welcome                                                                                                         ", jPanel1);

        jTabbedPaneMainPanelUser.addTab("                     Assistant                      ", jTabbedPaneAssistant);

        jTabbedPaneEditProfile.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(32, 33, 35));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Weight :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Height:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 140, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Age:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Gender:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, -1, -1));

        txtWeight.setBackground(new java.awt.Color(255, 255, 255));
        txtWeight.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtWeight.setForeground(new java.awt.Color(51, 51, 51));
        txtWeight.setToolTipText("Enter your weight in kilogram");
        txtWeight.setBorder(null);
        jPanel4.add(txtWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 125, -1));

        txtHeight.setBackground(new java.awt.Color(255, 255, 255));
        txtHeight.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtHeight.setForeground(new java.awt.Color(51, 51, 51));
        txtHeight.setToolTipText("Enter Your height in centimeters");
        txtHeight.setBorder(null);
        jPanel4.add(txtHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 140, 125, -1));

        txtAge.setBackground(new java.awt.Color(255, 255, 255));
        txtAge.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtAge.setForeground(new java.awt.Color(51, 51, 51));
        txtAge.setBorder(null);
        jPanel4.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 125, -1));

        btnUpdate.setBackground(new java.awt.Color(38, 50, 56));
        btnUpdate.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update128.png"))); // NOI18N
        btnUpdate.setToolTipText("Click to update profile");
        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setOpaque(false);
        btnUpdate.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update64.png"))); // NOI18N
        btnUpdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/updaterollover.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 340, 150, 140));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 80, 125, 10));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 170, 125, 10));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 125, 10));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Activity Level :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 140, -1));

        cmbActivityLevel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmbActivityLevel.setForeground(new java.awt.Color(0, 0, 0));
        cmbActivityLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lightly active (moderate exercise but sedentary job)", "Moderately active (intense exercise but sedentary job)", "Very active (moderate exercise and active job)", "Extra active (intense exercise and active job)" }));
        cmbActivityLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbActivityLevelActionPerformed(evt);
            }
        });
        jPanel4.add(cmbActivityLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 440, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Goal :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 80, -1));

        cmbGoal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cmbGoal.setForeground(new java.awt.Color(0, 0, 0));
        cmbGoal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maintenance", "Fat Loss" }));
        cmbGoal.setBorder(null);
        jPanel4.add(cmbGoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 270, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Name:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Email:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 50, -1));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 188, 10));

        txtUpdateUserName.setBackground(new java.awt.Color(255, 255, 255));
        txtUpdateUserName.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtUpdateUserName.setForeground(new java.awt.Color(51, 51, 51));
        txtUpdateUserName.setBorder(null);
        jPanel4.add(txtUpdateUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 188, -1));

        lblUserEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUserEmail.setForeground(new java.awt.Color(51, 51, 51));
        lblUserEmail.setText("...");
        jPanel4.add(lblUserEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 300, -1));

        lblUserGender.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUserGender.setForeground(new java.awt.Color(51, 51, 51));
        lblUserGender.setText("...");
        jPanel4.add(lblUserGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 220, 90, -1));

        lblUserBMIProfile.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUserBMIProfile.setForeground(new java.awt.Color(51, 51, 51));
        lblUserBMIProfile.setText("...");
        jPanel4.add(lblUserBMIProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 150, 40));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("BMI:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 50, -1));

        lblProfileImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ABackground.png"))); // NOI18N
        jPanel4.add(lblProfileImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1240, 520));

        jTabbedPaneEditProfile.addTab("                                                                                                  Edit Your Profile here                                                                                                     ", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneEditProfile, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneEditProfile, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneMainPanelUser.addTab("                    Profile                     ", jPanel5);

        jTabbedPane4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel10.setBackground(new java.awt.Color(32, 33, 35));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("BMI:");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 50, -1));

        lblUserBMI.setForeground(new java.awt.Color(255, 255, 255));
        lblUserBMI.setText("...");
        jPanel10.add(lblUserBMI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 150, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TDEE:");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, 50, -1));

        lblUserTDEE1.setForeground(new java.awt.Color(255, 255, 255));
        lblUserTDEE1.setText("...");
        jPanel10.add(lblUserTDEE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 210, 150, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Recommandation:");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 140, -1));

        jScrollPane3.setViewportView(txtUserRecommandation);

        jPanel10.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 460, 260));

        jTabbedPane4.addTab("                                                  My Status                                                 ", jPanel10);

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbMyMealPlans.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Click Here To View Availabale Meal Plans for me" }));
        cmbMyMealPlans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMyMealPlansActionPerformed(evt);
            }
        });
        jPanel2.add(cmbMyMealPlans, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 500, -1));

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Breakfast:");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 80, -1));

        txtBreakfastUserMealPlan.setEditable(false);
        txtBreakfastUserMealPlan.setColumns(20);
        txtBreakfastUserMealPlan.setRows(5);
        jScrollPane1.setViewportView(txtBreakfastUserMealPlan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 280, 280));

        txtLunchUserMealPlan.setEditable(false);
        txtLunchUserMealPlan.setColumns(20);
        txtLunchUserMealPlan.setRows(5);
        jScrollPane2.setViewportView(txtLunchUserMealPlan);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 280, 280));

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Lunch:");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 80, -1));

        txtDinnerUserMealPlan.setEditable(false);
        txtDinnerUserMealPlan.setColumns(20);
        txtDinnerUserMealPlan.setRows(5);
        jScrollPane7.setViewportView(txtDinnerUserMealPlan);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 280, 280));

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Nutri:");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 40, -1));

        txtSnackUserMealPlan.setEditable(false);
        txtSnackUserMealPlan.setColumns(20);
        txtSnackUserMealPlan.setRows(5);
        jScrollPane8.setViewportView(txtSnackUserMealPlan);

        jPanel2.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 200, 280, 280));

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Snack:");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 170, 80, -1));

        lbldisplayTotCal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbldisplayTotCal.setForeground(new java.awt.Color(255, 255, 255));
        lbldisplayTotCal.setText("TotalCalorie Amount:");
        jPanel2.add(lbldisplayTotCal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        lblMealPlanTotalCalorieAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblMealPlanTotalCalorieAmount.setText("...");
        jPanel2.add(lblMealPlanTotalCalorieAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 90, -1));

        txtNutrition.setEditable(false);
        txtNutrition.setColumns(20);
        txtNutrition.setRows(5);
        jScrollPane9.setViewportView(txtNutrition);

        jPanel2.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 280, 130));

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Dinner:");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 80, -1));

        jTabbedPane4.addTab("                                               My Diet Plans                                              ", jPanel2);

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

        jTabbedPaneMainPanelUser.addTab("                Diet Chart               ", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1226, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMainPanelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, Short.MAX_VALUE)
                .addContainerGap())
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

        if (V.isValidName(txtUpdateUserName.getText())) {
            if (V.isValidAge(txtAge.getText())) {
                if (V.isValidWeight(txtWeight.getText())) {
                    if (V.isValidHeight(txtHeight.getText())) {
                        users.getUserByEmail(currentUser.getEmail()).setName(txtUpdateUserName.getText());
                        users.getUserByEmail(currentUser.getEmail()).setAge(Integer.parseInt(txtAge.getText()));
                        users.getUserByEmail(currentUser.getEmail()).setWeight(Double.parseDouble(txtWeight.getText()));
                        users.getUserByEmail(currentUser.getEmail()).setHeight(Double.parseDouble(txtHeight.getText()));
                        users.getUserByEmail(currentUser.getEmail()).setGoal((String) cmbGoal.getSelectedItem());
                        users.getUserByEmail(currentUser.getEmail()).setActivityLevel((String) cmbActivityLevel.getSelectedItem());
                        JOptionPane.showMessageDialog(null, "Profile Updated Successfully !", " Update Profile ", JOptionPane.DEFAULT_OPTION);
                        currentUser = users.getUserByEmail(currentUser.getEmail());
                        showBMI();
                        getTDEE();
                        jTabbedPaneAssistant.setTitleAt(0, "                                                                                       Welcome " + currentUser.getName() + "                                                                                                                                                                                                                       ");
                        generateMyPlan();

                        getMyPlan();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Height, Please Re-Enter Height !", " Height ", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Weight, Please Re-Enter Weight !", " Update Weight ", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Age, Please Re-Enter Age !", " Update Age ", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Name pattern, Please Re-Enter Name !", " Update Name ", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    public void AssistantProcessor() {
        /**
         * Setters
         */

        if (L.getTopScoreIntent().equals("setHeight")) {

            if (L.getEntityType1().equals("height")) {

                if (V.isValidHeight(L.getEntityValue1())) {
                    currentUser.setHeight(Double.parseDouble(L.getEntityValue1()));
                    users.getUserByEmail(currentUser.getEmail()).setHeight(Double.parseDouble(L.getEntityValue1()));

                    createProfile();
                    generateMyPlan();
                    getMyPlan();

                    sb.append("\n");
                    sb.append("  Your height is set to " + L.getEntityValue1() + " centimeters");
                    sb.append("\n");

                    giveBotResponse();

                } else {

                    sb.append("\n");
                    sb.append("  Invalid Height, your height should be 90 to 240 centimeters");
                    sb.append("\n");

                    giveBotResponse();

                }

            }
        }
        if (L.getTopScoreIntent().equals("setWeight")) {

            if (L.getEntityType1().equals("weight")) {

                if (V.isValidWeight(L.getEntityValue1())) {

                    currentUser.setWeight(Double.parseDouble(L.getEntityValue1()));
                    users.getUserByEmail(currentUser.getEmail()).setWeight(Double.parseDouble(L.getEntityValue1()));

                    createProfile();
                    generateMyPlan();
                    getMyPlan();

                    sb.append("\n");
                    sb.append("  Your weight is set to " + L.getEntityValue1() + " Kilograms");
                    sb.append("\n");

                    giveBotResponse();

                } else {

                    sb.append("\n");
                    sb.append("  Invalid Weight, your weight should be 30 to 500 Kilograms");
                    sb.append("\n");

                    giveBotResponse();
                }

            }
        }
        if (L.getTopScoreIntent().equals("setName")) {

            if (L.getEntityType1().equals("username")) {

                if (V.isValidName(L.getEntityValue1())) {
                    currentUser.setName((L.getEntityValue1()));
                    users.getUserByEmail(currentUser.getEmail()).setName((L.getEntityValue1()));

                    createProfile();

                    sb.append("\n");
                    sb.append("  Your name is set to " + L.getEntityValue1());
                    sb.append("\n");

                    giveBotResponse();

                } else {
                    sb.append("\n");
                    sb.append("  Invalid Name");
                    sb.append("\n");

                    giveBotResponse();
                }

            }
        }

        if (L.getTopScoreIntent().equals("setAge")) {

            if (L.getEntityType1().equals("age")) {

                if (V.isValidAge(L.getEntityValue1())) {

                    currentUser.setName((L.getEntityValue1()));
                    users.getUserByEmail(currentUser.getEmail()).setName((L.getEntityValue1()));

                    createProfile();
                    generateMyPlan();
                    getMyPlan();

                    sb.append("\n");
                    sb.append("  Your Age is set to " + L.getEntityValue1());
                    sb.append("\n");

                    giveBotResponse();

                } else {

                    sb.append("\n");
                    sb.append("  Invalid Age, your Age should be 16 to 120");
                    sb.append("\n");

                    giveBotResponse();

                }

            }
        }

        /**
         * getters
         */
        if (L.getTopScoreIntent().equals("getActivityLevel")) {
            sb.append("\n");
            sb.append("  Your Acivity Level is " + currentUser.getActivityLevel());
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getAge")) {
            sb.append("\n");
            sb.append("  Your Age is " + currentUser.getAge());
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getBMI")) {
            sb.append("\n");
            sb.append("  Your BMI is " + Double.toString(this.BMI));
            sb.append("\n");

            giveBotResponse();
        }

        if (L.getTopScoreIntent().equals("getRecommandation")) {
            sb.append("\n");
            sb.append("  Here is your recommandation ");
            sb.append("\n");
            sb.append(this.recommandation);
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getStatus")) {
            sb.append("  Here is your Current Status ");
            sb.append("\n");
            sb.append("<=============================================================>");
            sb.append("\n");
            sb.append("  Total Daily Energy Expenditure : " + Integer.toString(this.TDEE));
            sb.append("\n");
            sb.append("  BMI : " + Double.toString(this.BMI));
            sb.append("\n");
            sb.append("  Following are the recommandations ");
            sb.append("\n");
            sb.append(this.recommandation);
            sb.append("\n");
            sb.append("<=============================================================>");
            giveBotResponse();

        }

        if (L.getTopScoreIntent().equals("getEmail")) {
            sb.append("\n");
            sb.append("  Your Email is " + currentUser.getEmail());
            sb.append("\n");

            giveBotResponse();
        }
        if (L.getTopScoreIntent().equals("getGender")) {
            sb.append("\n");
            sb.append("  Your Gender is " + currentUser.getGender());
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getGoal")) {
            sb.append("\n");
            sb.append("  Your Goal is " + currentUser.getGoal());
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getHeight")) {
            sb.append("\n");
            sb.append("  Your Height is " + Double.toString(currentUser.getHeight()));
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getName")) {

            sb.append("\n");
            sb.append("  Your Name is " + currentUser.getName());
            sb.append("\n");

            giveBotResponse();
        }
        if (L.getTopScoreIntent().equals("getTDEE")) {

            sb.append("\n");
            sb.append("  Your Daily calorie requirement is " + Integer.toString(this.TDEE));
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getWeight")) {

            sb.append("\n");
            sb.append("  Your Weight is " + Double.toString(currentUser.getWeight()));
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("getDietPlans")) {

            sb.append("  Here is your available Meal plans !!!!! ");
            for (int i = 0; i < myPlans.size(); i++) {
                this.currentMealPlan = myPlans.get(i);
                sb.append("\n");
                sb.append("\n");
                sb.append(this.currentMealPlan.getId() + ": " + this.currentMealPlan.getName());  //mealPlan Id and MealOPlan name
                sb.append("\n");
                sb.append("<=============================================================>");
                sb.append("\n");
                sb.append("\n");
                sb.append("---------------------Breakfast-----------------");
                sb.append("\n");
                sb.append(this.currentMealPlan.getBreakfast());
                sb.append("\n");
                sb.append("\n");
                sb.append("---------------------Lunch---------------------");
                sb.append("\n");
                sb.append(this.currentMealPlan.getLunch());
                sb.append("\n");
                sb.append("\n");
                sb.append("---------------------Dinner--------------------");
                sb.append("\n");
                sb.append(this.currentMealPlan.getDinner());
                sb.append("\n");
                sb.append("\n");
                sb.append("---------------------Snack---------------------");
                sb.append("\n");
                sb.append(this.currentMealPlan.getSnack());
                sb.append("\n");
                sb.append("\n");
                sb.append("<=============================================================>");
                sb.append("\n");
                sb.append("\n");
                sb.append(this.currentMealPlan.getMacro());
                sb.append("\n");
                sb.append("\n");
                sb.append("<=============================================================>");

            }

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("Greeting")) {

            sb.append("\n");
            sb.append("  Thanks. You are welcome!! ");
            sb.append("\n");

            giveBotResponse();

        }
        if (L.getTopScoreIntent().equals("None")) {

            sb.append("\n");
            sb.append("  Out Of Domain !");
            sb.append("\n");

            giveBotResponse();

        }

    }

    public void giveUserResponse() {
        StyleConstants.setForeground(style, Color.DARK_GRAY);
        try {
            doc.insertString(doc.getLength(), sb.toString(), style);
        } catch (BadLocationException ex) {
        }
        sb.setLength(0);
    }

    public void giveBotResponse() {
        StyleConstants.setForeground(style, Color.RED);
        try {
            doc.insertString(doc.getLength(), sb.toString(), style);
        } catch (BadLocationException ex) {
        }
        sb.setLength(0);
    }

    private void cmbMyMealPlansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMyMealPlansActionPerformed
        if (cmbMyMealPlans.getSelectedIndex() == 0) {
            lbldisplayTotCal.setVisible(false); //Hide Total Calorie Amount Label
            lblMealPlanTotalCalorieAmount.setText("");
            txtBreakfastUserMealPlan.setText("");
            txtLunchUserMealPlan.setText("");
            txtDinnerUserMealPlan.setText("");
            txtSnackUserMealPlan.setText("");
            txtNutrition.setText("");
        }
        if (cmbMyMealPlans.getSelectedIndex() != 0) {

            myPlans.getMealPlanById(Integer.parseInt(getMatchedMealPlanId(cmbMyMealPlans.getSelectedItem().toString())));
            lblMealPlanTotalCalorieAmount.setText(Double.toString(myPlans.getMealPlanById(Integer.parseInt(getMatchedMealPlanId(cmbMyMealPlans.getSelectedItem().toString()))).getCalorieAmount()));
            txtNutrition.setText(myPlans.getMealPlanById(Integer.parseInt(getMatchedMealPlanId(cmbMyMealPlans.getSelectedItem().toString()))).getMacro());
            txtBreakfastUserMealPlan.setText(myPlans.getMealPlanById(Integer.parseInt(getMatchedMealPlanId(cmbMyMealPlans.getSelectedItem().toString()))).getBreakfast());
            txtLunchUserMealPlan.setText(myPlans.getMealPlanById(Integer.parseInt(getMatchedMealPlanId(cmbMyMealPlans.getSelectedItem().toString()))).getLunch());
            txtDinnerUserMealPlan.setText(myPlans.getMealPlanById(Integer.parseInt(getMatchedMealPlanId(cmbMyMealPlans.getSelectedItem().toString()))).getDinner());
            txtSnackUserMealPlan.setText(myPlans.getMealPlanById(Integer.parseInt(getMatchedMealPlanId(cmbMyMealPlans.getSelectedItem().toString()))).getSnack());

            lbldisplayTotCal.setVisible(true);  //Show Total Calorie Amount Label
        }
    }//GEN-LAST:event_cmbMyMealPlansActionPerformed

    private void jTabbedPaneMainPanelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMainPanelUserMouseClicked
        switchTabs();
    }//GEN-LAST:event_jTabbedPaneMainPanelUserMouseClicked

    private void cmbActivityLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActivityLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbActivityLevelActionPerformed

    private void btnSendQueryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendQueryMouseReleased

        L.setQuery(txtUserQuery.getText());
        L.ProcessQuery();

        lblSenAna.setText(L.getSentimentAnalysisLabel() + " user query");
        txtUserQuery.setText("");
        AssistantProcessor();
    }//GEN-LAST:event_btnSendQueryMouseReleased

    private void btnSendQueryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendQueryMousePressed

        sb.append("\n");
        sb.append("\n");
        sb.append("                                                                                                             " + txtUserQuery.getText().toString());
        sb.append("\n");
        sb.append("\n");

        giveUserResponse();

    }//GEN-LAST:event_btnSendQueryMousePressed

    private void btnSendQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendQueryActionPerformed
        //don't do anything
    }//GEN-LAST:event_btnSendQueryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendQuery;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbActivityLevel;
    private javax.swing.JComboBox<String> cmbGoal;
    private javax.swing.JComboBox<String> cmbMyMealPlans;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPaneAssistant;
    private javax.swing.JTabbedPane jTabbedPaneEditProfile;
    private javax.swing.JTabbedPane jTabbedPaneMainPanelUser;
    private javax.swing.JLabel lblAssistantImage;
    private javax.swing.JLabel lblChatBarImage;
    private javax.swing.JLabel lblMealPlanTotalCalorieAmount;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JLabel lblSenAna;
    private javax.swing.JLabel lblUserBMI;
    private javax.swing.JLabel lblUserBMIProfile;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserGender;
    private javax.swing.JLabel lblUserTDEE1;
    private javax.swing.JLabel lbldisplayTotCal;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextPane txtAssistant;
    private javax.swing.JTextArea txtBreakfastUserMealPlan;
    private javax.swing.JTextArea txtDinnerUserMealPlan;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextArea txtLunchUserMealPlan;
    private javax.swing.JTextArea txtNutrition;
    private javax.swing.JTextArea txtSnackUserMealPlan;
    private javax.swing.JTextField txtUpdateUserName;
    private javax.swing.JTextField txtUserQuery;
    private javax.swing.JTextPane txtUserRecommandation;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables

    /**
     * Serialize SetOfUsers
     */
    public void SerializeUser() {
        try {
            FileOutputStream ufos = new FileOutputStream(new File("datafiles/users.ser"));
            ObjectOutputStream uboos = new ObjectOutputStream(ufos);
            uboos.writeObject(users);
            uboos.flush();
            uboos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Deserialize SetOfUsers
     */
    public void DeserializeUsers() {
        ObjectInputStream uois = null;
        File file = new File("datafiles/users.ser");
        try {

            FileInputStream ufis = new FileInputStream(file);
            if (ufis.available() != 0) {
                uois = new ObjectInputStream(ufis);
                while (uois != null) {
                    users = (SetOfUsers) uois.readObject();
                    System.out.println(this.users.size());
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * Deserialize SetOfMealPlans
     */
    public void DeserializeMealPlans() {
        ObjectInputStream mplois = null;
        File file = new File("datafiles/mealPlans.ser");
        try {

            FileInputStream mplfis = new FileInputStream(file);
            if (mplfis.available() != 0) {
                mplois = new ObjectInputStream(mplfis);
                while (mplois != null) {
                    mealPlans = (SetOfMealPlans) mplois.readObject();
                    System.out.println(this.mealPlans.size());
                }
            }
        } catch (Exception e) {

        }
    }

    public void switchTabs() {

        int selectedIndex = jTabbedPaneMainPanelUser.getSelectedIndex();

        if (selectedIndex == 3) {
            int answer = JOptionPane.showConfirmDialog(null, "Do you really want to Exit?", " AI Dietitian ", JOptionPane.YES_NO_OPTION);

            if (answer == 0) {
                System.out.println("SerializeUser");
                SerializeUser();
                SignInUI SI = new SignInUI();
                SI.setVisible(true);
                this.dispose();
            }
            if (answer == 1) {
                jTabbedPaneMainPanelUser.setSelectedIndex(0);
            }
        }
    }

}
