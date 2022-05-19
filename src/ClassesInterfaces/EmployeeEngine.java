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
public class EmployeeEngine extends Engine{
    public EmployeeEngine(long id, long iban, long moneyInBankAccount, 
            long sumOfDebts, String username, String password, Login parent) {
        super(id, iban, moneyInBankAccount,
                sumOfDebts, username, password, parent);
    }
    
    public void acceptOrDenyCreditRequests(){
        JFrame f = new JFrame();

        String query = "SELECT DemandId AS IstekID, ID AS 'HesapID'"
                + ", Amount AS Miktar FROM CreditDemands";
        WayCreditDemandsWindow window = new WayCreditDemandsWindow(
            f);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(window);
        f.setSize(430, 540);
        f.setLocationRelativeTo(null);
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)
                ){
            DatabaseWorks.resultToTable(result, window.getjTable1());
        }
        catch(SQLException exp){
                f = new JFrame();
                JOptionPane.showMessageDialog(f, exp.toString());
                }
        f.setVisible(true);
    }
    
    public void limitChangeDemands(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LimitChangeDemands window = new LimitChangeDemands(f);
        f.add(window);
        f.setSize(430, 500);
        f.setLocationRelativeTo(null);
      
        String query = "SELECT DemandID AS 'Istek ID', CreditCardID AS\n"
                + "'Kredi karti ID', Amount AS Miktar FROM\n"
                + "LimitIncreaseDemands";
        
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)){
                DatabaseWorks.resultToTable(result, window.getjTable1());
        }
        catch(SQLException exp){
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());
        }
        
        f.setVisible(true);
    }
    
    public void wayCreditCardDemands(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(360, 480);
        WayCreditCardDemands window = new WayCreditCardDemands(
                this.getProgramUser(), f);
        f.add(window);
        f.setLocationRelativeTo(null);
        
        String query = "SELECT DemandId AS 'Istek IDsi',"
                + "ID AS 'Hesap IDsi', Amount\n"
                + "AS 'Istenilen Limit' FROM CreditCardDemands";
        
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
    
    public void sendBills(){
        JFrame f = new JFrame();
        SendBills window = new SendBills(f);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(440, 270);
        f.add(window);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
