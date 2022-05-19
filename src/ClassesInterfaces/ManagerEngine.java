/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInterfaces;

import GUIs.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Halil
 */
public class ManagerEngine extends EmployeeEngine {
    
    public ManagerEngine(long id, long iban, long moneyInBankAccount, long sumOfDebts,
            String username, String password, Login parent) {
        super(id, iban, moneyInBankAccount,
                sumOfDebts, username, password, parent);
    }
    
    public void wayBillObjectDemands() {
        JFrame f = new JFrame();
        WayBillObjectDemands window = new WayBillObjectDemands(f);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(488, 440);
        f.setLocationRelativeTo(null);
        f.add(window);
        String query = "SELECT BillObjects.BillID AS 'Fatura IDsi', BillObjects.ID AS 'Sahibi HesapID',"
                + "BilType AS 'Turu', BillAmount 'Fatura Miktari'"
                + "FROM BillObjects\n"
                + "INNER JOIN Bills\n"
                + "ON BillObjects.BillID = Bills.BillID";
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)){
                DatabaseWorks.resultToTable(result, window.getjTable1());
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(new JFrame(), exp.toString());
        }
        f.setVisible(true);
    }
}
