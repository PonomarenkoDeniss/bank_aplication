import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.logging.Level;
import java.util.logging.Logger;

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
public class Transaction extends javax.swing.JFrame {
    
    /*****************************************************************/
    String url = "jdbc:mysql://localhost/bank_system";
    String username = "root";
    String password = "";
    /*****************************************************************/
        
    String TransactionTime;
    
    private int id;
    private String myAccount;
    private double myBeforeBalance;
    private double myAfterBalance;

    private int receiverID;
    private String receiverName;
    private String receiverAccount;
    private double receiverBalance;
    private double receiverAfterBalance;
    private String comment;
    private double amount;
    

    
    
    private int error;

    
    public Transaction() {
        initComponents();
        
    }
    public void SetTxt(){
        MyAccountField.setText("" + this.myAccount + "");
    }
    
    public void SetID(int ID){
        this.id = ID;
    }
    
    public void SetBalance(double cash){
        this.myBeforeBalance = cash;
    }
    
    
    public void SetMyAccount(String Account){
        this.myAccount = Account;
    }
    
    
    public void EchoData(){
        
        System.out.println("");
        System.out.println("----------Receiver data---------------");
        System.out.println("TRANSACTION->ID->  " + this.id);
        System.out.println("TRANSACTION->receiverName->  " + this.receiverName);
        System.out.println("TRANSACTION->receiverAccount-> " + this.receiverAccount);
        System.out.println("----------Receiver data---------------");
        
        System.out.println("---------------SELECT SQL-----------------");
        System.out.println("TRANSACTION->receiverID-> " + this.receiverID);
        System.out.println("TRANSACTION->receiverBalance-> " + this.receiverBalance);
        System.out.println("---------------SELECT SQL-----------------");
        
        System.out.println("-------------------------------------");
        System.out.println("TRANSACTION->comment-> " + this.comment);
        System.out.println("TRANSACTION->myBeforeBalance-> " + this.myBeforeBalance);
        System.out.println("TRANSACTION->amount-> " + this.amount);
        System.out.println("TRANSACTION->myAccount-> " + this.myAccount);
        
        System.out.println("-------------------------------------");
        System.out.println("TRANSACTION->Time-> " + this.TransactionTime);
        System.out.println("-------------------------------------");

        
        
        System.out.println("");
    }
    
    //Block 1 
    private void SetAmount(){
        double money = Double.valueOf( AmountField.getText() );
        money= Math.abs(money);
        this.amount = money;
    }
    private void SetAccount(){
        this.receiverAccount = AccountField.getText();
    }
    private void SetReceiver(){
        this.receiverName = NameField.getText();
    }
    private void SetComment(){
        this.comment = CommnetField.getText();
    }
    
    // block 2
    private void CheckValidData(){
        if( this.amount <= 0  ){
            this.error = 2;                                                     //2 - not valid amount
        }else{ this.error = 0;} 
    }
    
    private void CheckMyBalance(){
        if( this.myBeforeBalance <= 0  || this.myBeforeBalance < this.amount ){
            this.error = 5;                                                     //5 - no money
        }else{ this.error = 0;}                                                 //0 - OK
    }
    
    
    private void MyAfterBalance(){
        this.myAfterBalance = this.myBeforeBalance - this.amount;
    }
    private void ReceiverAfterBalance(){
        this.receiverAfterBalance = this.receiverBalance + this.amount;
    }
    
    private void GetDataAndTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        this.TransactionTime =  dateFormat.format(cal.getTime());
    }
    
    

    
    private void UpdateMyData(){
        Data exec = new Data();
        String sql = "Update users SET CASH = " + this.myAfterBalance + " where ID = " + this.id + ";";
        exec.exec_sql(sql);
    }
    private void UpdateReceiverData(){
        Data exec = new Data();
        String sql = "Update users SET CASH = " + this.receiverAfterBalance + " where ID= " + this.receiverID + ";";
        exec.exec_sql(sql);
    }
    private void InsertIntoForMe(){
        Data exec = new Data();
        String Act = "Send";
        String sql = "INSERT INTO transaction (CLIENT_ACCAUNT, RECIPIENT, CASH, Comment, ACT, Time ) Values ('" + this.myAccount + "','" + this.receiverAccount + "','"+"-" + this.amount + "','" + this.comment + "','"+ Act +"', '" + this.TransactionTime + "' );";
        exec.exec_sql(sql);
    }
        private void InsertIntoForRecipient(){
        Data exec = new Data();
        String Act = "Received"; 
        String sql = "INSERT INTO transaction (CLIENT_ACCAUNT, RECIPIENT, CASH, Comment, ACT, Time ) Values ('" + this.receiverAccount + "','" + this.myAccount + "','"+"+" + this.amount + "','" + this.comment + "','"+ Act +"' , '" + this.TransactionTime + "');";
        exec.exec_sql(sql);
    }
    private void GetCustomerData() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery ("SELECT ID, CASH from users where FULLNAME = '" + this.receiverName + "' AND ACCOUNT = '" + this.receiverAccount + "' " );
            while(rset.next()){
                this.receiverID = Integer.valueOf( rset.getString("ID") );
                this.receiverBalance = Double.valueOf( rset.getString("CASH") );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepositFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void GetErrorText(){
        switch(this.error){
            case 0: 
                JOptionPane.showMessageDialog(null,"you transferred " + this.amount + "$ to " + this.receiverName + " ");
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"Not valid amount");
                break;
            case 5:
                JOptionPane.showMessageDialog(null,"Not enough funds in the account, please deposit money to the account");
                break;
            case 6:
                JOptionPane.showMessageDialog(null,"Receiver not found.");
                break;
            case 7:
                JOptionPane.showMessageDialog(null,"User not found.");
                break;
        }
            Client client = new Client();
            client.SetID(this.id);
            client.CreateCustomerFrame();
            client.setVisible(true);
            dispose();
    }
    public void DoTransaction(){
        //Set Data
        SetAmount();
        SetAccount();
        SetReceiver();
        SetComment();
        
        //get now()
        GetDataAndTime();
        
        
        //check data valid
        CheckValidData();
        CheckMyBalance();
        //Data from DB
        GetCustomerData();
        
        //do math operation
        MyAfterBalance();
        ReceiverAfterBalance();
        
        //Error text JOpenPane
        GetErrorText();
        
        //sql requests - update
        UpdateMyData();
        UpdateReceiverData();
        
        //sql requests - insert into 
        InsertIntoForMe();
        InsertIntoForRecipient();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AmountField = new javax.swing.JTextField();
        AccountField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        MyAccountField = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CommnetField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Account number");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Amount");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText(" Receiver ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Comment");

        MyAccountField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Pay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(MyAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NameField)
                                    .addComponent(AccountField)
                                    .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CommnetField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MyAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(AccountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(CommnetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(jButton1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DoTransaction();
        EchoData();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountField;
    private javax.swing.JTextField AmountField;
    private javax.swing.JTextField CommnetField;
    private javax.swing.JLabel MyAccountField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
