/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInterfaces;



/**
 *
 * @author Halil
 */
 public abstract class User{
    private long id;
    private long iban;

    private long sumOfDebts;
    private String username;
    private String password;



    public User(long id, long iban,long moneyInBankAccount, long sumOfDebts, 
            String username, String password) {
        this.id = id;
        this.iban = iban;
        this.sumOfDebts = sumOfDebts;
        this.username = username;
        this.password = password;

    }
    
    
     public boolean withdrawMoney(long amount){
         
        return (DatabaseWorks.getMoneyInBankAccount(this.id) >= amount) ?(true) : false;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIban() {
        return iban;
    }

    public void setIban(long iban) {
        this.iban = iban;
    }

    public long getSumOfDebts() {
        return sumOfDebts;
    }

    public void setSumOfDebts(long sumOfDebts) {
        this.sumOfDebts = sumOfDebts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
