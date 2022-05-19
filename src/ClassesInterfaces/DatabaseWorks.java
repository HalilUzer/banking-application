/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInterfaces;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;
/**
 *
 * @author Halil
 */
public class DatabaseWorks { 

    
    public static void k(String query){
        
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()){
                stat.execute(query);

        }
        catch(SQLException exp){
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());

        }
    }
    
    public static void p(String query){

        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                 ResultSet result = stat.executeQuery(query)
               ){
            

        }
        catch(SQLException exp){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, exp.toString());

        }
    }
    
    public static long getRemainingCreditCard(long creditCardId){
        String query = "SELECT RemaininAmount\n"
                + "FROM CreditCard\n"
                + "WHERE CreditCardID = " + creditCardId + ";";
      
        long remainingAmount = 0;
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()){
                ResultSet result = stat.executeQuery(query);
                remainingAmount = result.getLong("RemainingAmount");
        }
        catch(SQLException exp){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, exp.toString());

        }
        return remainingAmount;
    }
    
    
    public static long getMoneyInBankAccount(long ID){
        String query = "SELECT BankBalance FROM BankAccounts WHERE ID = " + ID;
        long money = 0;
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)){
            money = result.getLong(1);
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(new JFrame(), exp.toString());
        }
        return money;
    }
    
    
    
    public static void q(String[] args){
       

        
    }
    
    public static boolean larger(long creditCardID,long amount){
        
        String query = "SELECT RemainingAmount FROM CreditCard\n"
                + "WHERE CreditCardID = " + creditCardID;
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)){
                if(amount > result.getLong(1)){
                    return true;
                }
                else{
                    return false;
                }
        }
        catch(SQLException exp){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, exp.toString());
            return false;
        }
    }
    
    
    public static boolean contains(long creditCardId){
        
        String query = "SELECT EXISTS(SELECT 1 FROM CreditCard\n"
                + "WHERE CreditCardId = " + creditCardId + ")";
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)){
                return result.getBoolean(1);
                
        }
        catch(SQLException exp){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, exp.toString());
            return false;
        }
    }
    
    public static void resultToTable(ResultSet result, JTable k) throws SQLException{

        DefaultTableModel x = new DefaultTableModel();

        ResultSetMetaData y = result.getMetaData();

        int columnCount = y.getColumnCount();

        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            x.addColumn(y.getColumnLabel(columnIndex));
        }

        Object[] o = new Object[columnCount];


        while (result.next()){
            for (int i = 0; i < columnCount; i++){
                o[i] = result.getObject(i+1);
            }
            x.addRow(o);
        }

        k.setModel(x);
    }

}
