/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesInterfaces;
import GUIs.Login;

/**
 *
 * @author Halil
 */
public class CustomerEngine extends Engine {
    
    public CustomerEngine(long id, long iban,long moneyInBankAccount, long sumOfDebts, 
            String username, String password,Login parent){
        super(id, iban, moneyInBankAccount, sumOfDebts, username, password,
            parent);
        
    }
    
}
