/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import javax.swing.*;
import java.sql.*;
import ClassesInterfaces.*;

/**
 *
 * @author Halil
 */
public class getIdAndAmount extends javax.swing.JPanel {

    private String ibanS;
    private String amountS;
    private User programUser;
    private JFrame frame;

    public String getIbanS() {
        return ibanS;
    }

    public void setIbanS(String ibanS) {
        this.ibanS = ibanS;
    }

    public String getAmountS() {
        return amountS;
    }

    public void setAmountS(String amountS) {
        this.amountS = amountS;
    }

    /**
     * Creates new form getIdAndAmount
     */
    public getIdAndAmount(User programUser, JFrame frame) {
        initComponents();
        this.programUser = programUser;
        this.frame = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        ibanInput = new javax.swing.JTextField();
        amountInput = new javax.swing.JTextField();
        transferButton = new javax.swing.JButton();

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Lutfen para transferi yapmak istediginiz hesabin IBANini ve para miktarini  giriniz");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("IBAN:");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setText("Para Miktari:");

        transferButton.setText("Transfer Et");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ibanInput)
                            .addComponent(amountInput, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(transferButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ibanInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(transferButton)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        // TODO add your handling code here:
        String tempAmount = this.amountInput.getText();
        String tempIban = this.ibanInput.getText();
        boolean IbanConfirm = false;
        long inputAmount = 0;
        if (tempIban.equals("") || tempAmount.equals("")) {
            JPanel p = new JPanel();
            JOptionPane.showMessageDialog(p,
                    "Lutfen iban numarası "
                    + "veya para miktari kismini bos birakmayiniz");
        } else {
            String query = "SELECT EXISTS(SELECT 1 FROM BankAccounts\n"
                    + "WHERE IBAN = " + tempIban + ");";
            
            try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                    Statement stat = conn.createStatement()) {

                try (ResultSet result = stat.executeQuery(query)) {

                    IbanConfirm = result.getBoolean(1);
                }

                query = "SELECT BankBalance FROM BankAccounts\n"
                        + "WHERE IBAN = " + tempIban + ";";
                try (ResultSet result = stat.executeQuery(query)) {
                    inputAmount = result.getLong(1);
                }
            } catch (SQLException exp) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, exp.toString());

            }

            if (IbanConfirm == false) {
                JPanel p = new JPanel();
                JOptionPane.showMessageDialog(p, "Lutfen gecerli bir IBAN"
                        + " giriniz");
            } else if (inputAmount
                    >= DatabaseWorks.getMoneyInBankAccount(this.programUser.getId())) {
                JPanel p = new JPanel();
                JOptionPane.showMessageDialog(p,
                        "Girdiginiz para miktari hesabinizdaki paradan fazla"
                        + " lutfen kabul edilebilir bir miktar giriniz");
            } else {
                this.amountS = tempAmount;
                this.ibanS = tempIban;
                long amount = Long.valueOf(this.amountS);
                long iban = Long.valueOf(this.ibanS);

                query = "UPDATE BankAccounts\n"
                        + "SET BankBalance = " + amount + " + (SELECT BankBalance\n"
                        + "FROM BankAccounts WHERE IBAN = " + iban + ")\n"
                        + "WHERE IBAN = " + iban + ";";
                try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                        Statement stat = conn.createStatement()) {
                    stat.execute(query);

                } catch (SQLException exp) {
                    JFrame j = new JFrame();
                    JOptionPane.showMessageDialog(j, exp.toString());
                }

                query = "UPDATE BankAccounts\n"
                        + "SET BankBalance = (SELECT BankBalance\n"
                        + "FROM BankAccounts\n"
                        + "WHERE IBAN = " + this.programUser.getIban() + ") - " + amount
                        + " WHERE IBAN = " + this.programUser.getIban()
                        + ";";
                try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                        Statement stat = conn.createStatement()) {
                    stat.execute(query);

                } catch (SQLException exp) {
                    JFrame j = new JFrame();
                    JOptionPane.showMessageDialog(j, exp.toString());

                }

                Engine.refresh();
                this.frame.dispose();
            }
        }
    }//GEN-LAST:event_transferButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountInput;
    private javax.swing.JTextField ibanInput;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton transferButton;
    // End of variables declaration//GEN-END:variables
}
