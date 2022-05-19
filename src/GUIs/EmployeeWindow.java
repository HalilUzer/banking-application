/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;
import ClassesInterfaces.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Halil
 */
public class EmployeeWindow extends javax.swing.JPanel {
    private Engine engine;
    private JFrame parent;

    public JTextArea getAccountInformation() {
        return accountInformation;
    }

    public void setAccountInformation(JTextArea accountInformation) {
        this.accountInformation = accountInformation;
    }

    public JTextArea getCreditCardInformation() {
        return creditCardInformation;
    }

    public void setCreditCardInformation(JTextArea creditCardInformation) {
        this.creditCardInformation = creditCardInformation;
    }

    public JTextArea getProgramAccountInformation() {
        return programAccountInformation;
    }

    public void setProgramAccountInformation(JTextArea programAccountInformation) {
        this.programAccountInformation = programAccountInformation;
    }
    
    
    /**
     * Creates new form EmployeeWindow
     */
    public EmployeeWindow(long id, long iban,long moneyInBankAccount, long sumOfDebts, 
            String username, String password,Login root, JFrame parent) {
        initComponents();
        this.parent = parent;
        this.engine = new EmployeeEngine(
        id, iban, moneyInBankAccount, sumOfDebts, username, password,
        root); 
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        depositMoneyButton = new javax.swing.JButton();
        withdrawMoney = new javax.swing.JButton();
        getCreditToBankAccount = new javax.swing.JButton();
        transferMoneyAnotherAccount = new javax.swing.JButton();
        CreditCardToBankAccount = new javax.swing.JButton();
        IncreaseLimit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountInformation = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        creditCardInformation = new javax.swing.JTextArea();
        payBill = new javax.swing.JButton();
        objectBill = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        programAccountInformation = new javax.swing.JTextArea();
        changePassword = new javax.swing.JButton();
        demandCreditCard = new javax.swing.JButton();
        acceptOrDenyCreditRequests = new javax.swing.JButton();
        limitRequestsDenyAccept = new javax.swing.JButton();
        wayCreditCardDemands = new javax.swing.JButton();
        sendBill = new javax.swing.JButton();
        goBackToLogin = new javax.swing.JButton();

        depositMoneyButton.setText("Hesaba Para Yatir");
        depositMoneyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositMoneyButtonActionPerformed(evt);
            }
        });

        withdrawMoney.setText("Hesabtan Para Cek");
        withdrawMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawMoneyActionPerformed(evt);
            }
        });

        getCreditToBankAccount.setText("Hesabina Kredi Iste");
        getCreditToBankAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCreditToBankAccountActionPerformed(evt);
            }
        });

        transferMoneyAnotherAccount.setText("Baska Hesaba Para Aktar");
        transferMoneyAnotherAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferMoneyAnotherAccountActionPerformed(evt);
            }
        });

        CreditCardToBankAccount.setText("Kredi Kartindan Banka Hesabına Para Aktar");
        CreditCardToBankAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditCardToBankAccountActionPerformed(evt);
            }
        });

        IncreaseLimit.setText("Kredi Karti Limit Artisi Talep Et");
        IncreaseLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncreaseLimitActionPerformed(evt);
            }
        });

        accountInformation.setEditable(false);
        accountInformation.setBackground(new java.awt.Color(204, 204, 204));
        accountInformation.setColumns(20);
        accountInformation.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        accountInformation.setRows(5);
        accountInformation.setText("Hesap Bilgileri");
        jScrollPane1.setViewportView(accountInformation);

        creditCardInformation.setEditable(false);
        creditCardInformation.setBackground(new java.awt.Color(204, 204, 204));
        creditCardInformation.setColumns(20);
        creditCardInformation.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        creditCardInformation.setRows(5);
        creditCardInformation.setText("Kredi Karti Bilgileri");
        jScrollPane3.setViewportView(creditCardInformation);

        payBill.setText("Fatura Ode");
        payBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBillActionPerformed(evt);
            }
        });

        objectBill.setText("Fatura Itirazi Gonder");
        objectBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objectBillActionPerformed(evt);
            }
        });

        programAccountInformation.setEditable(false);
        programAccountInformation.setBackground(new java.awt.Color(204, 204, 204));
        programAccountInformation.setColumns(20);
        programAccountInformation.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        programAccountInformation.setRows(5);
        programAccountInformation.setText("Program Hesap Bilgileri");
        jScrollPane2.setViewportView(programAccountInformation);

        changePassword.setText("Sifre Degistir");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });

        demandCreditCard.setText("Kredi Karti Talep Et");
        demandCreditCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demandCreditCardActionPerformed(evt);
            }
        });

        acceptOrDenyCreditRequests.setText("Kredi Taleplerini Onayla Ya Da Reddet");
        acceptOrDenyCreditRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptOrDenyCreditRequestsActionPerformed(evt);
            }
        });

        limitRequestsDenyAccept.setText("Limit Artis Taleplerini Onayla Ya Da Reddet");
        limitRequestsDenyAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limitRequestsDenyAcceptActionPerformed(evt);
            }
        });

        wayCreditCardDemands.setText("Kredi Karti Taleplerini Onayla Ya Da Reddet");
        wayCreditCardDemands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wayCreditCardDemandsActionPerformed(evt);
            }
        });

        sendBill.setText("Fatura Gonder");
        sendBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBillActionPerformed(evt);
            }
        });

        goBackToLogin.setText("<-Giris Sayfasini Don");
        goBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackToLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(withdrawMoney, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositMoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(transferMoneyAnotherAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreditCardToBankAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(getCreditToBankAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IncreaseLimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(demandCreditCard, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sendBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(payBill, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                        .addComponent(objectBill, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(acceptOrDenyCreditRequests, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                                    .addComponent(limitRequestsDenyAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(wayCreditCardDemands, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(186, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(depositMoneyButton)
                            .addComponent(withdrawMoney))
                        .addGap(18, 18, 18)
                        .addComponent(transferMoneyAnotherAccount)
                        .addGap(18, 18, 18)
                        .addComponent(getCreditToBankAccount)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payBill)
                            .addComponent(objectBill))
                        .addGap(20, 20, 20)
                        .addComponent(sendBill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(changePassword)
                        .addGap(35, 35, 35)
                        .addComponent(acceptOrDenyCreditRequests)
                        .addGap(34, 34, 34)
                        .addComponent(limitRequestsDenyAccept)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(demandCreditCard)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(wayCreditCardDemands)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CreditCardToBankAccount)
                        .addGap(18, 18, 18)
                        .addComponent(IncreaseLimit)
                        .addGap(18, 18, 18))
                    .addComponent(goBackToLogin, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptOrDenyCreditRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptOrDenyCreditRequestsActionPerformed
        // TODO add your handling code here:
        EmployeeEngine employeeEngine = (EmployeeEngine)this.engine;
        employeeEngine.acceptOrDenyCreditRequests();

    }//GEN-LAST:event_acceptOrDenyCreditRequestsActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        // TODO add your handling code here:
        this.engine.changePassword();

    }//GEN-LAST:event_changePasswordActionPerformed

    private void limitRequestsDenyAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limitRequestsDenyAcceptActionPerformed
        // TODO add your handling code here:
       EmployeeEngine employeeE = (EmployeeEngine)this.engine;
       employeeE.limitChangeDemands();
   
    }//GEN-LAST:event_limitRequestsDenyAcceptActionPerformed

    private void depositMoneyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositMoneyButtonActionPerformed
        // TODO add your handling code here:
        this.engine.depositMoney();

    }//GEN-LAST:event_depositMoneyButtonActionPerformed

    private void withdrawMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawMoneyActionPerformed
        // TODO add your handling code here:
        this.engine.withdrawMoney();
 
    }//GEN-LAST:event_withdrawMoneyActionPerformed

    private void transferMoneyAnotherAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferMoneyAnotherAccountActionPerformed
        // TODO add your handling code here:
        this.engine.transferMoneyToAnotherAccount();

    }//GEN-LAST:event_transferMoneyAnotherAccountActionPerformed

    private void getCreditToBankAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCreditToBankAccountActionPerformed
        // TODO add your handling code here:
        this.engine.getCreditToBankAccount();
  
    }//GEN-LAST:event_getCreditToBankAccountActionPerformed

    private void IncreaseLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncreaseLimitActionPerformed
        // TODO add your handling code here:
        this.engine.demandLimitChange();

    }//GEN-LAST:event_IncreaseLimitActionPerformed

    private void CreditCardToBankAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditCardToBankAccountActionPerformed
        // TODO add your handling code here:
        this.engine.creditCardToBankAccount();
    
    }//GEN-LAST:event_CreditCardToBankAccountActionPerformed

    private void demandCreditCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demandCreditCardActionPerformed
        // TODO add your handling code here:
        this.engine.demandCreditCard();
    
    }//GEN-LAST:event_demandCreditCardActionPerformed

    private void wayCreditCardDemandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wayCreditCardDemandsActionPerformed
        // TODO add your handling code here:
        EmployeeEngine employeeEngine = (EmployeeEngine)this.engine;
        employeeEngine.wayCreditCardDemands();

    }//GEN-LAST:event_wayCreditCardDemandsActionPerformed

    private void objectBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objectBillActionPerformed
        // TODO add your handling code here:
        this.engine.objectBill();
  
    }//GEN-LAST:event_objectBillActionPerformed

    private void payBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBillActionPerformed
        // TODO add your handling code here:
        this.engine.payBill();

    }//GEN-LAST:event_payBillActionPerformed

    private void sendBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBillActionPerformed
        // TODO add your handling code here:
        EmployeeEngine employeeEngine = (EmployeeEngine)this.engine;
        employeeEngine.sendBills();
 
    }//GEN-LAST:event_sendBillActionPerformed

    private void goBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackToLoginActionPerformed
        // TODO add your handling code here:
        this.engine.getRoot().setVisible(true);
        this.parent.dispose();
    }//GEN-LAST:event_goBackToLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreditCardToBankAccount;
    private javax.swing.JButton IncreaseLimit;
    private javax.swing.JButton acceptOrDenyCreditRequests;
    private javax.swing.JTextArea accountInformation;
    private javax.swing.JButton changePassword;
    private javax.swing.JTextArea creditCardInformation;
    private javax.swing.JButton demandCreditCard;
    private javax.swing.JButton depositMoneyButton;
    private javax.swing.JButton getCreditToBankAccount;
    private javax.swing.JButton goBackToLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton limitRequestsDenyAccept;
    private javax.swing.JButton objectBill;
    private javax.swing.JButton payBill;
    private javax.swing.JTextArea programAccountInformation;
    private javax.swing.JButton sendBill;
    private javax.swing.JButton transferMoneyAnotherAccount;
    private javax.swing.JButton wayCreditCardDemands;
    private javax.swing.JButton withdrawMoney;
    // End of variables declaration//GEN-END:variables
}
