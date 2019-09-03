import java.util.Date;
import javax.swing.JOptionPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AdminMenu extends javax.swing.JFrame {
    public String AdminName;
    private int AdminId;
    private String AdminPassword;
    
    private String Name;
    private String Number;
    private String Password;
    private String Account;
    private String Cash;
    
    /**
     * Creates new form AdminMenu
     */
    public AdminMenu() {
        initComponents();
        //Fill fields
        setNumber();
        setAccount();
        getToday();        
    }

    

    private void setId(int ID){
        this.AdminId = ID;
    }
    private void setPwd(String password){
        this.AdminPassword = password;
    }
    
    public void SetAdminData(int ID, String Password){
        setId(ID);
        setPwd(Password);
    }  
    
    private void ClearFields(){
 
        CustomerName.setText("");
        setNumber();
        getToday();
        setAccount();
        CustomerCashField.setText("0.00");
        StatusField.setSelected(false);
        CustomerIDField.setText("");
    }
    //create customer number
    private void setNumber() {
        
        int rand = (int) (Math.random() * 98999999) + 1000000;
        this.Number = Integer.toString(rand);
        ClientNumberField.setText(this.Number);
       
    }
    
    private void setAccount(){
                
        long detail = System.currentTimeMillis() / 1000;
        //long details = now.getTime()/1000;
        Long IntDetail = Long.valueOf(this.Number);
        Long data =  detail + IntDetail;
        this.Account = "DP"+ data;
        CustomerAccountField.setText(this.Account);
    }
    
    //for default password
    private void getToday(){
        Date d=new Date();
        int yearInt  =  d.getYear() - 100;
        String year = "20" + yearInt;
        this.Password = ""+ d.getDate();
        int month = d.getMonth() +1;
        if( d.getMonth() < 10 ){
            this.Password += "0" + month;
        }else{this.Password += "" +d.getMonth();}
       
        this.Password += "" +year;
        CustomerPasswordField.setText(this.Password);        
    }
    
    void HelloAdmin(){
        HelloAdminLabel.setText("Admin - " +this.AdminName);
    }
    
    private int CheckAdminStatus(){
        boolean status = StatusField.isSelected();
        int admin = 0;
        
        if(status){
            admin = 1;
        }else{
            admin = 0;
        }
        return admin;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        CustomerName = new javax.swing.JTextField();
        Theme = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        NumberLabel = new javax.swing.JLabel();
        ClientNumberField = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        AccountLabel = new javax.swing.JLabel();
        CustomerAccountField = new javax.swing.JLabel();
        CashLabel = new javax.swing.JLabel();
        CustomerCashField = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        CustomerPasswordField = new javax.swing.JLabel();
        AddAction = new javax.swing.JButton();
        UpdateAction = new javax.swing.JButton();
        DeleteAction = new javax.swing.JButton();
        ResetCustomerPassword = new javax.swing.JButton();
        ClearFieldsButton = new javax.swing.JRadioButton();
        StatusField = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        CustomerIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        HelloAdminLabel = new javax.swing.JLabel();
        ExitButton = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CustomerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Theme.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Theme.setText("Desktop");

        NameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NameLabel.setText("Full name");

        NumberLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NumberLabel.setText("Client num.");

        ClientNumberField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PasswordLabel.setText("Password");

        AccountLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AccountLabel.setText("Account");

        CustomerAccountField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CashLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CashLabel.setText("Cash");

        CustomerCashField.setText("0.00");
        CustomerCashField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        StatusLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        StatusLabel.setText("Admin status");

        CustomerPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AddAction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddAction.setText("Add");
        AddAction.setBorder(new javax.swing.border.MatteBorder(null));
        AddAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionActionPerformed(evt);
            }
        });

        UpdateAction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UpdateAction.setText("Update");
        UpdateAction.setBorder(new javax.swing.border.MatteBorder(null));
        UpdateAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionActionPerformed(evt);
            }
        });

        DeleteAction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DeleteAction.setText("Delete");
        DeleteAction.setBorder(new javax.swing.border.MatteBorder(null));
        DeleteAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionActionPerformed(evt);
            }
        });

        ResetCustomerPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ResetCustomerPassword.setText("Password");
        ResetCustomerPassword.setBorder(new javax.swing.border.MatteBorder(null));
        ResetCustomerPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetCustomerPasswordActionPerformed(evt);
            }
        });

        ClearFieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearFieldsButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID");

        CustomerIDField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Password change");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(Theme)
                                .addGap(107, 107, 107)
                                .addComponent(ClearFieldsButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StatusLabel)
                                    .addComponent(CashLabel)
                                    .addComponent(AccountLabel)
                                    .addComponent(PasswordLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CustomerPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StatusField)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(NumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ClientNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CustomerIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddAction, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UpdateAction, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteAction, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResetCustomerPassword))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClearFieldsButton)
                    .addComponent(Theme))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerIDField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLabel)
                    .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClientNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordLabel)
                    .addComponent(CustomerPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AccountLabel)
                        .addGap(18, 18, 18)
                        .addComponent(CashLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CustomerAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CustomerCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(StatusField)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddAction)
                    .addComponent(UpdateAction)
                    .addComponent(DeleteAction)
                    .addComponent(ResetCustomerPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Number", "Password", "Account", "Balance", "Admin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        HelloAdminLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ExitButton.setText("Exit");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HelloAdminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExitButton)
                        .addGap(24, 24, 24)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HelloAdminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearFieldsButtonActionPerformed
        // TODO add your handling code here:
        ClearFields();
    }//GEN-LAST:event_ClearFieldsButtonActionPerformed

    private void AddActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionActionPerformed
        // TODO add your handling code here:
   
        Data insert = new Data();
        //insert into DB hashing pass
        String pass = insert.GetHashingPassword( CustomerPasswordField.getText() );
        //check admin status field
        int isThisAdmin = CheckAdminStatus();
        
        //Is Name filed empty
        if( CustomerName.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"Name is empty. Please fill Name Field.");
        }else{
            String sql = "INSERT INTO users (FULLNAME, CLIENT_NUM, PASSWORD, ACCOUNT, CASH, ADMIN ) Values ('"+CustomerName.getText()+"','"+ClientNumberField.getText()+"','"+ pass +"','"+CustomerAccountField.getText()+"','"+CustomerCashField.getText() +"','"+ isThisAdmin +"')";
            insert.exec_sql(sql);
            JOptionPane.showMessageDialog(null,"User added");
            ClearFields();
        }
    }//GEN-LAST:event_AddActionActionPerformed

    private void UpdateActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionActionPerformed
        // TODO add your handling code here:
        Data update = new Data();
        String sql = "Update users SET FULLNAME = '" + CustomerName.getText() + "' where ID = '" + CustomerIDField.getText() + "' ";
    }//GEN-LAST:event_UpdateActionActionPerformed

    private void DeleteActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionActionPerformed
        // TODO add your handling code here:
        Data delete = new Data();
        if( CustomerIDField.getText().equals(null) || CustomerIDField.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"ID is empty. Please edit ID field.");
        }else{
            String sql = "DELETE FROM users WHERE ID = '" + CustomerIDField.getText() + "'";
            delete.exec_sql(sql);
        }
    }//GEN-LAST:event_DeleteActionActionPerformed

    private void ResetCustomerPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetCustomerPasswordActionPerformed
        // TODO add your handling code here:
        getToday();
        Data updatePass = new Data();
        if( CustomerIDField.getText().equals(null) || CustomerIDField.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"ID is empty. Please edit ID field.");
        }else{
            String sql = "Update users SET PASSWORD = '" + updatePass.GetHashingPassword( CustomerPasswordField.getText() ) + "' where ID = '" + CustomerIDField.getText() + "' ";
            updatePass.exec_sql(sql);
        }
    }//GEN-LAST:event_ResetCustomerPasswordActionPerformed

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        // TODO add your handling code here:
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Settings changePassword = new Settings();
        changePassword.setID( this.AdminId );
        changePassword.setOldPassword( this.AdminPassword);
        changePassword.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked


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
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountLabel;
    private javax.swing.JButton AddAction;
    private javax.swing.JLabel CashLabel;
    private javax.swing.JRadioButton ClearFieldsButton;
    private javax.swing.JLabel ClientNumberField;
    private javax.swing.JLabel CustomerAccountField;
    private javax.swing.JLabel CustomerCashField;
    private javax.swing.JTextField CustomerIDField;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JLabel CustomerPasswordField;
    private javax.swing.JButton DeleteAction;
    private javax.swing.JLabel ExitButton;
    private javax.swing.JLabel HelloAdminLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel NumberLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton ResetCustomerPassword;
    private javax.swing.JCheckBox StatusField;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel Theme;
    private javax.swing.JButton UpdateAction;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
