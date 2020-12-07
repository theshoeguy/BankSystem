/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

/**
 *
 * @author 1830041
 */
public class Test {
	public static void main(String[] args) {
		Bank.addUser("Yi", "1234");
		Bank.addUser("Wang", "2345");
		Bank.addUser("Mike", "3456");
		
		AutomatedTellerMachine a1 = new AutomatedTellerMachine();
		AutomatedTellerMachine a2 = new AutomatedTellerMachine();
		AutomatedTellerMachine a3 = new AutomatedTellerMachine();
		
		// Bank.getUsers().get(0)
		a1.pipeline();
	}
	
}
