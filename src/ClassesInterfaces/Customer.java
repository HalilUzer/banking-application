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
public class Customer extends User {
    private int con;

    public int getCons() {
        return con;
    }

    public void setCons(int cons) {
        this.con = cons;
    }
    
    public Customer(long id, long iban,long moneyInBankAccount, long sumOfDebts,
            String username, String password){
        super(id, iban, moneyInBankAccount, sumOfDebts, username, password);
        this.con = 10;
    }

}
