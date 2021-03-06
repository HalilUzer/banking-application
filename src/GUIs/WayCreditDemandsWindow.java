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
public class WayCreditDemandsWindow extends javax.swing.JPanel {

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    private JFrame frame;

    /**
     * Creates new form WayCreditDemandsWindow
     */
    public WayCreditDemandsWindow(JFrame frame) {
        initComponents();
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
        accept = new javax.swing.JButton();
        deny = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Lutfen kabul etmek ya da reddetmek icin istek IDsini giriniz");

        accept.setText("Kabul Et");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        deny.setText("Reddet");
        deny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("Istek ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(accept)
                        .addGap(52, 52, 52)
                        .addComponent(deny))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(idTextField))
                            .addComponent(jTextField1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accept)
                    .addComponent(deny))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        // TODO add your handling code here:
        String demandId = this.idTextField.getText();
        boolean confirmation = false;
        long amount = 0;
        long destinationId = 0;
        long moneyInBankAccount = 0;
        JFrame f = null;
        if (demandId.equals("")) {
            f = new JFrame();
            JOptionPane.showMessageDialog(f,
                    "Lutfen ID kismini bos birakmayiniz");
        } else {

            String query = "SELECT EXISTS(SELECT 1 FROM CreditDemands\n"
                    + "WHERE  DemandId = " + demandId + ")";
            try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                    Statement stat = conn.createStatement();
                    ResultSet result = stat.executeQuery(query)) {
                confirmation = result.getBoolean(1);
            } catch (SQLException exp) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, exp.toString());
            }

            if (confirmation) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        "Kredi paralari banka hesabina aktarilmistir");

                query = "SELECT Amount, CreditDemands.ID, "
                        + "BankBalance FROM CreditDemands\n"
                        + "LEFT JOIN BankAccounts\n"
                        + "ON CreditDemands.ID = BankAccounts.ID\n"
                        + "WHERE\n"
                        + " DemandId = " + demandId;

                try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                        Statement stat = conn.createStatement();) {
                    try (ResultSet result = stat.executeQuery(query)) {
                        amount = result.getLong(1);
                        destinationId = result.getLong(2);
                        moneyInBankAccount = result.getLong(3);
                    }

                    query = "UPDATE BankAccounts\n"
                            + "SET BankBalance = "
                            + (moneyInBankAccount + amount)
                            + " WHERE ID = " + destinationId + ";";
                    stat.execute(query);
                    query = "DELETE FROM CreditDemands WHERE"
                            + " DemandId = " + demandId;
                    stat.execute(query);
                    Engine.refresh();
                    frame.dispose();

                } catch (SQLException exp) {
                    JFrame j = new JFrame();
                    JOptionPane.showMessageDialog(j, exp.toString());
                }
            } else {
                f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        "Lutfen var olan bir kredi istek IDsi giriniz");
            }

    }//GEN-LAST:event_acceptActionPerformed
    }
    private void denyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyActionPerformed
        // TODO add your handling code here:
        String demandId = this.idTextField.getText();
        boolean confirmation = false;
        long amount = 0;
        JFrame f = null;
        if (demandId.equals("")) {
            f = new JFrame();
            JOptionPane.showMessageDialog(f,
                    "Lutfen ID kismini bos birakmayiniz");
        } else {
            
            String query = "SELECT EXISTS(SELECT 1 FROM CreditDemands\n"
                    + "WHERE  DemandId = " + demandId + ");";
            try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                    Statement stat = conn.createStatement();
                    ResultSet result = stat.executeQuery(query)) {
                confirmation = result.getBoolean(1);
            } catch (SQLException exp) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, exp.toString());
            }

            if (confirmation) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        "Kredi istegi silinmistir");

                query = "DELETE FROM CreditDemands WHERE"
                        + " DemandId = " + demandId;
                try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                        Statement stat = conn.createStatement()){
                    stat.execute(query);
                    frame.dispose();
                }
                catch (SQLException exp) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, exp.toString());
            }
                
            }
            else{
                 f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        "Lutfen var olan bir kredi istek IDsi giriniz");
            }
        } 
    }//GEN-LAST:event_denyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton deny;
    private javax.swing.JTextField idTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
