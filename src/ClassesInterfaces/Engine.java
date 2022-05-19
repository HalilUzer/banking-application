/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInterfaces;

import GUIs.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Halil
 */
public abstract class Engine implements WithdrawMoney, DepositMoney{

    private User programUser;
    private Login root;

    
    

    public Engine(long id, long iban, long moneyInBankAccount, long sumOfDebts,
            String username, String password, Login parent) {
        this.programUser = new CustomerUser(id, iban, moneyInBankAccount, 
                sumOfDebts, username, password);
        this.root = parent;
    }
    
    public static void refresh(CustomerWindow window){

        
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()){
            String query = "SELECT BankAccounts.BankBalance, "
                    + "ProgramAccounts.Username, ProgramAccounts.Password\n"
                    + "FROM BankAccounts\n"
                    + "INNER JOIN ProgramAccounts\n"
                    + "ON BankAccounts.ID = ProgramAccounts.ID\n"
                    + "WHERE BankAccounts.ID = " + window.getEngine().getProgramUser().getId();
            try(ResultSet result = stat.executeQuery(query)){
                String accountInformation = 
                        "IBAN : " + window.getEngine().getProgramUser().getIban() + "\n"
                        + "Hesaptaki para miktari : " + result.getLong(1) + 
                        "\n";
                String programInformation = "Hesap ID : " + window.getEngine().getProgramUser().getId()
                        + "\nKullanici Adi : " + result.getString(2) + "\n"
                        + "Sifre : " + result.getString(3);
                
                window.getAccountInformation().setText(accountInformation);
                window.getProgramAccountInformation().setText
                (programInformation);
            }
            query = "SELECT CreditCardID, CreditCardAmount, RemainingAmount\n"
                    + "FROM CreditCard\n"
                    + "WHERE ID = " + window.getEngine().getProgramUser().getId();
            
            try(ResultSet result = stat.executeQuery(query)){
                String creditCardsInformation = "";
                
                while(result.next()){
                    creditCardsInformation += "Kredi Karti ID : " 
                        + result.getLong(1) + "  "
                            + "Kalan Miktar : "  + result.getLong(3) + "  "
                            + "Limit : " + result.getLong(2) + "\n";            
                }
                 window.getCreditCardInformation().setText(creditCardsInformation);
            }
            
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(new JFrame(), exp.toString());
        }
                
    }
    
    
    
    
    
    public static void refresh(ManagerWindow window){
             
        
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()){
            String query = "SELECT BankAccounts.BankBalance, "
                    + "ProgramAccounts.Username, ProgramAccounts.Password\n"
                    + "FROM BankAccounts\n"
                    + "INNER JOIN ProgramAccounts\n"
                    + "ON BankAccounts.ID = ProgramAccounts.ID\n"
                    + "WHERE BankAccounts.ID = " + window.getEngine().getProgramUser().getId();
            try(ResultSet result = stat.executeQuery(query)){
                String accountInformation = 
                        "IBAN : " + window.getEngine().getProgramUser().getIban() + "\n"
                        + "Hesaptaki para miktari : " + result.getLong(1) + 
                        "\n";
                String programInformation = "Hesap ID : " + window.getEngine().getProgramUser().getId()
                        + "\nKullanici Adi : " + result.getString(2) + "\n"
                        + "Sifre : " + result.getString(3);
                
                window.getAccountInformation().setText(accountInformation);
                window.getProgramAccountInformation().setText
                (programInformation);
            }
            query = "SELECT CreditCardID, CreditCardAmount, RemainingAmount\n"
                    + "FROM CreditCard\n"
                    + "WHERE ID = " + window.getEngine().getProgramUser().getId();
            
            try(ResultSet result = stat.executeQuery(query)){
                String creditCardsInformation = "";
                
                while(result.next()){
                    creditCardsInformation += "Kredi Karti ID : " 
                        + result.getLong(1) + "  "
                            + "Kalan Miktar : "  + result.getLong(3) + "  "
                            + "Limit : " + result.getLong(2) + "\n";            
                }
                window.getCreditCardInformation().setText(creditCardsInformation);
            }
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(new JFrame(), exp.toString());
        }
    }
    
    public static void refresh(EmployeeWindow window){
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()){
            String query = "SELECT BankAccounts.BankBalance, "
                    + "ProgramAccounts.Username, ProgramAccounts.Password\n"
                    + "FROM BankAccounts\n"
                    + "INNER JOIN ProgramAccounts\n"
                    + "ON BankAccounts.ID = ProgramAccounts.ID\n"
                    + "WHERE BankAccounts.ID = " + window.getEngine().getProgramUser().getId();
            try(ResultSet result = stat.executeQuery(query)){
                String accountInformation = 
                        "IBAN : " + window.getEngine().getProgramUser().getIban() + "\n"
                        + "Hesaptaki para miktari : " + result.getLong(1) + 
                        "\n";
                String programInformation = "Hesap ID : " + window.getEngine().getProgramUser().getId()
                        + "\nKullanici Adi : " + result.getString(2) + "\n"
                        + "Sifre : " + result.getString(3);
                
                window.getAccountInformation().setText(accountInformation);
                window.getProgramAccountInformation().setText
                (programInformation);
            }
            query = "SELECT CreditCardID, CreditCardAmount, RemainingAmount\n"
                    + "FROM CreditCard\n"
                    + "WHERE ID = " + window.getEngine().getProgramUser().getId();
            
            try(ResultSet result = stat.executeQuery(query)){
                String creditCardsInformation = "";
                
                while(result.next()){
                    creditCardsInformation += "Kredi Karti ID : " 
                        + result.getLong(1) + "  "
                            + "Kalan Miktar : "  + result.getLong(3) + "  "
                            + "Limit : " + result.getLong(2) + "\n";            
                }
                 window.getCreditCardInformation().setText(creditCardsInformation);
            }
            
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(new JFrame(), exp.toString());
        }
          
    }

    public static void refresh(){
        if(Login.getSameWindow() instanceof  CustomerWindow){
            refresh((CustomerWindow)Login.getSameWindow());
        }
        
        else if(Login.getSameWindow() instanceof  EmployeeWindow){
            refresh((EmployeeWindow) Login.getSameWindow());
        }
        
        else if(Login.getSameWindow() instanceof ManagerWindow){
            refresh((ManagerWindow)Login.getSameWindow());
        }
    }
    public Login getRoot() {
        return root;
    }

    public void setRoot(Login root) {
        this.root = root;
    }
    
    @Override
    public void withdrawMoney() {
        long amount = 0;
        JFrame f = null;
        int flag = 0;
        String input = null;

        while (flag == 0) {
            f = new JFrame();
            input = JOptionPane.showInputDialog(f,
                    "Lutfen cekmek istediginiz miktari giriniz");
            if (input == null) {
                return;
            } else if (input.equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Lutfen cekmek is"
                        + "tediginiz para miktarini bos birakmayiniz");
            } else if (Long.valueOf(input) < 0) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Lutfen negatif bir para"
                        + " miktari girmeyiniz");
            } else if (Long.valueOf(input)
                    > DatabaseWorks.getMoneyInBankAccount(this.programUser.getId())) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        "Cekmek istediginiz para hesabinizdaki paradan fazla"
                        + " lutfen kabul edilebilir bir miktar giri"
                        + "niz");
            } else {
                flag = 1;
            }
        }

        amount = Long.valueOf(input);

        String sql = "UPDATE BankAccounts\n"
                + "SET BankBalance = "
                + "(SELECT BankBalance FROM BankAccounts WHERE ID = " + this.programUser.getId()+ ") - " + amount
                + "\nWHERE ID = " + this.getProgramUser().getId() + ";";
        
        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()) {
            stat.execute(sql);
            Engine.refresh();

        } catch (SQLException exp) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());

        }

    }
    
    @Override
    public void depositMoney() {
        long amount = 0;
        JFrame f = null;
        int flag = 0;
        String input = null;

        while (flag == 0) {
            f = new JFrame();
            input = JOptionPane.showInputDialog(f,
                    "Lutfen yatirmak istediginiz fiyati giriniz");

            if (input == null) {
                return;
            } else if (input.equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Lutfen yatirmak istediniz"
                        + " para miktarini bos birakmayiniz");
            } else if (Long.valueOf(input) < 0) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Lutfen yatirmak istediginiz"
                        + "para miktarini negatif girmeyiniz");
            } else {
                flag = 1;
            }
        }

        amount = Long.valueOf(input);
        String sql = "UPDATE BankAccounts\n"
                + "SET BankBalance = "
                + "(SELECT BankBalance FROM BankAccounts WHERE ID = " + this.programUser.getId()+ ") + " + amount
                + " WHERE ID = " + this.programUser.getId() + ";";
        
        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()) {
            stat.execute(sql);
            Engine.refresh();

        } catch (SQLException exp) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());

        }

    }
    
    

    public void transferMoneyToAnotherAccount() {
        JFrame f = new JFrame();
        getIdAndAmount window = new getIdAndAmount(
                this.programUser, f);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(window);
        f.setSize(501, 265);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void getCreditToBankAccount() {
        JFrame f = null;
        String input = null;
        int flag = 0;
        long amount = 0;

        while (flag == 0) {
            f = new JFrame();
            input = JOptionPane.showInputDialog(f,
                    "Lutfen kredinin para miktarini giriniz");
            if (input == null) {
                return;
            } else if (input.equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        "Lutfen kredinin para miktarini bos birakmayiniz");
            } else if (Long.valueOf(input) < 0) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f, "Lutfen kredinin para "
                        + "miktarini negatif girmeyiniz");
            } else {
                flag = 1;
            }
        }

        amount = Long.valueOf(input);

        String query = "INSERT INTO CreditDemands\n"
                + "(DemandId, ID, Amount)\n"
                + "VALUES(NULL," + this.programUser.getId()
                + ", "
                + amount + " );";
        
        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()) {
            stat.execute(query);
            Engine.refresh();

        } catch (SQLException exp) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());

        }
    }
    

    public void creditCardToBankAccount() {
        JFrame f = new JFrame();
        creditCardToBankWindow window = new creditCardToBankWindow(
                this.programUser, f);
        f.add(window);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String query = "SELECT CreditCardID AS 'Kredi Karti ID', RemainingAmount"
                + " AS 'Kartta Kalan Para'\n"
                + "FROM CreditCard\n"
                + "WHERE ID = " + this.programUser.getId();
        try(Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement  stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)){
            DatabaseWorks.resultToTable(result, window.getjTable1());
        }
        catch(SQLException exp){
            JOptionPane.showMessageDialog(new JFrame(), exp.toString());
        }
        f.setSize(540, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void demandCreditCard() {
        long limit = 0;
        String limitS = null;
        int flag = 0;
        JFrame f = null;

        while (flag == 0) {
            f = new JFrame();
            limitS = JOptionPane.showInputDialog(f,
                    "Lutfen kredi karti için limit isteginizi giriniz");
            if (limitS == null) {
                return;
            } else if (limitS.equals("")) {
                f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        "Lutfen limit kismini bos birakmayiniz");
            } else if (Long.valueOf(limitS) < 0) {
                f = new JFrame();
                JOptionPane.showInternalMessageDialog(f,
                        "Lutfen limiti negatif girmeyiniz");
            } else {
                limit = Long.valueOf(limitS);
                flag = 1;
            }
        }

        String query = "INSERT INTO CreditCardDemands\n"
                + "VALUES(NULL, " + this.programUser.getId() + ", "
                + limit + ");";
        
        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()) {
            stat.execute(query);

        } catch (SQLException exp) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());

        }
    }

    public void payBill() {
        String query = null;
        
        JFrame f = new JFrame();
        PayBillWindow window = new PayBillWindow(this.programUser, f);
        f.add(window);
        f.setSize(350, 450);
        f.setLocationRelativeTo(null);

        query = "SELECT BillID AS 'Fatura IDsi', BilType  AS "
                + "'Fatura Tip', BillAmount AS 'Miktar' FROM Bills WHERE ID = "
                + this.programUser.getId();
        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)) {
            DatabaseWorks.resultToTable(result, window.getPayBillTable());
        } catch (SQLException exp) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());
        }
        f.setVisible(true);
    }

    public void objectBill() {
        

        JFrame f = new JFrame();
        ObjectBillWindow window = new ObjectBillWindow(this.programUser, f);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(window);
        f.setSize(450, 461);
        f.setLocationRelativeTo(null);
        String query = "SELECT BillId as 'Fatura IDsi', BilType AS 'Fatura "
                + "Tipi', BillAmount AS 'Miktari'\n"
                + "FROM Bills\n"
                + "WHERE ID = " + this.programUser.getId();
        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)) {
            DatabaseWorks.resultToTable(result, window.getObjectBillTable());
        } catch (SQLException exp) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());

        }
        f.setVisible(true);

    }

    public void demandLimitChange() {
        JFrame f = new JFrame();
        DemandLimitChange window = new DemandLimitChange(f, programUser);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(385, 470);
        f.setLocationRelativeTo(null);
        f.add(window);
        
        String query = "SELECT CreditCardID AS 'Kredi Karti IDsi',\n"
                + "CreditCardAmount AS 'Limit' FROM CreditCard\n"
                + "WHERE ID = " + this.programUser.getId();

        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(query)) {
            DatabaseWorks.resultToTable(result, window.getjTable1());
        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(new JFrame(), exp.toString());
        }
        f.setVisible(true);
    }

    public void changePassword() {
        JFrame f = new JFrame();
        String input = JOptionPane.showInputDialog(f,
                "Lutfen yeni sifrenizi giriniz");

        if (input == null) {
            return;
        }

        String query = "UPDATE ProgramAccounts\n"
                + "SET Password = " + "'" + input + "'"
                + "\nWHERE ID = " + this.programUser.getId() + ";";

        try (Connection conn = DriverManager.getConnection(DatabaseUrl.URL);
                Statement stat = conn.createStatement()) {
            stat.execute(query);
            this.programUser.setPassword(input);
            Engine.refresh();

        } catch (SQLException exp) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, exp.toString());
        }
    }

    public User getProgramUser() {
        return programUser;
    }

    public void setProgramUser(User programUser) {
        this.programUser = programUser;
    }
    

}
