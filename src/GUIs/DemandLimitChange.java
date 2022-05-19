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
public class DemandLimitChange extends javax.swing.JPanel {
    private User programUser;
    private JFrame parent;


    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    /**
     * Creates new form DemandLimitChange
     */
    public DemandLimitChange(JFrame parent, User programUser) {
        initComponents();
        this.parent = parent;
        this.programUser = programUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        creditCardIdTextField = new javax.swing.JTextField();
        limittextField = new javax.swing.JTextField();
        sendDemand = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jTextField1.setText("jTextField1");

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

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setText("Kredi Kartleri ve Limitleri");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        jTextField4.setText("Kredi Karti ID:");

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setText("Yeni Limit:");

        sendDemand.setText("Istegi Gonder");
        sendDemand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendDemandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limittextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(creditCardIdTextField))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(sendDemand)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditCardIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limittextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sendDemand)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendDemandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendDemandActionPerformed
        // TODO add your handling code here:
        String creditCardId = this.creditCardIdTextField.getText();
        String newLimit = this.limittextField.getText();
        JFrame f = null;
        if (creditCardId.equals("") || newLimit.equals("")) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Lutfen kredi karti IDsini veya yeni limiti bos "
                    + "birakmayiniz");
        } else {
            String query = "SELECT EXISTS(SELECT 1 FROM CreditCard\n"
                    + "WHERE CreditCardId = " + creditCardId + ")";
            
            int confirmation = 0;

            try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                    Statement stat = conn.createStatement();
                    ResultSet result = stat.executeQuery(query)) {
                confirmation = result.getInt(1);

            } catch (SQLException exp) {
                JOptionPane.showMessageDialog(new JFrame(), exp.toString());
            }

            if (confirmation == 1) {
                query = "INSERT INTO LimitIncreaseDemands (DemandID, "
                        + "CreditCardID, ID, Amount)\n"
                        + "VALUES(NULL, " + creditCardId + ", " + 
                        this.programUser.getId()
                        + ", " + newLimit + ");";

                try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                        Statement stat = conn.createStatement()) {
                    stat.execute(query);
                } catch (SQLException exp) {
                    JOptionPane.showMessageDialog(new JFrame(), exp.toString());
                }
                this.parent.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Lutfen var olan"
                        + "bir kredi karti IDsi giriniz");
            }

        }
    }//GEN-LAST:event_sendDemandActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField creditCardIdTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField limittextField;
    private javax.swing.JButton sendDemand;
    // End of variables declaration//GEN-END:variables
}