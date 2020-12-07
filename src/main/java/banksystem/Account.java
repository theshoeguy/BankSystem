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
public class Account {
	private char type;
	private double balance;

	public Account() {
		this.type = 'c';
		this.balance = 0;
	}

	public Account(char type, double balance) {
		this.type = type;
		this.balance = balance;
	}
	
	public Account(Account account) {
		this.type = account.type;
		this.balance = account.balance;
	}
	
	public boolean equals(Account account) {
		return this.type == account.type && this.balance == account.balance;
	}

	@Override
	public String toString() {
		String str = "";
		
		str += String.format("%-10s: %s\n", "Type", type == 'c' ? "Checking" : "Saving");
		str += String.format("%-10s: %.2f\n", "Balance", balance);
		
		return str;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
}
