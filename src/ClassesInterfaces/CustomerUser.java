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
public class CustomerUser extends User{
    public CustomerUser(long id, long iban,long moneyInBankAccount, long sumOfDebts, 
            String username, String password){
        super(id, iban, moneyInBankAccount, sumOfDebts, username, password);
    }
    

}
