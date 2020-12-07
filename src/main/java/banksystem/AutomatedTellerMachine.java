/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.Scanner;

/**
 *
 * @author 1830041
 */
public class AutomatedTellerMachine {
	private String atmID;
	private static int nextID = 1;
	
	public AutomatedTellerMachine() {
		this.atmID = String.format("%06d", nextID++);
	}
	
	public AutomatedTellerMachine(String atmID) {
		this.atmID = atmID;
	}
	
	public AutomatedTellerMachine(AutomatedTellerMachine automatedTellerMachine) {
		this.atmID = automatedTellerMachine.atmID;
	}
	
	/**
	 * The pipeline of teh ATM if someone wants to use it
	 */
	public void pipeline() {
		printWelcome();
		User user = readUserId();
		if (user == null)
			System.exit(1); // cannot find the user
		if (!inputPin(user))
			System.exit(2); // wrong password
		
		Account account = chooseAccount(user);
		int oper = chooseOperation();
		switch (oper) {
			case 1:
				withdraw(account);
				break;
			case 2:
				deposit(account);
				break;
			default:
				displayBalance(account);
		}
		printGoodBye();
		
	}
	
	/**
	 * To print a welcome message at the very beginning
	 */
	public void printWelcome() {
		System.out.println("Welcome to use our ATM");
	}
	
	/**
	 * To ask the user to input the user id, if the id exists, then return the user object,
	 * else will shut down the entire process.
	 * @return the user object that matches the user input id
	 */
	public User readUserId() {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please enter your user ID");
		String inputId = console.next();
		
		for (int i = 0; i < Bank.getUsers().size(); i++)
			if (inputId.equals(Bank.getUsers().get(i).getUserId()))
				return Bank.getUsers().get(i);
		
		return null;
	}
	
	/**
	 * To ask the user to input the password. The user has three times to give
	 * the right password, if the user failed 3 times, the the process will
	 * be shut down.
	 * @param user the user object of the user
	 * @return if the password is correct
	 */
	public boolean inputPin(User user) {
		Scanner console = new Scanner(System.in);
		int maxTry = 3;
		
		for (int i = 0; i < maxTry; i++) {
			System.out.println("Please enter your user pin");
			String password = console.next();
			if (user.getPassword().equals(password))
				return true;
			System.out.println("Your password is wrong");
		}
		System.out.println("You input password wrong for 3 times");
		return false;
	}
	
	/**
	 * To ask the user to choose the account, could be
	 * 1. checking account
	 * 2. saving account
	 * @param user the user object for the user
	 * @return the selected account
	 */
	public Account chooseAccount(User user) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please choose the account you want to operate with"
		+ "\n\t1. Checking account" + "\n\t2. Saving account");
		int accountChoice = console.nextInt();
		
		return accountChoice == 1 ? user.getCheckingAccount() : user.getSavingAccount();
	}
	
	/**
	 * To ask the user to choose the operation, could be:
	 * 1. withdraw
	 * 2. deposit
	 * 3. display balance
	 * @return the operation the user selects
	 */
	public int chooseOperation() {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please choose the operation"
		+ "\n\t1. Withdraw" + "\n\t2. Deposit" + "\n\t3. Display Balance");
		int operation = console.nextInt();
		
		return operation;
	}
	
	/**
	 * To withdraw from the ATM
	 * @param account the account the user want to withdraw from
	 * @return true if withdraw successfully
	 */
	public boolean withdraw(Account account) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("How much do you want to withdraw?");
		double amount = console.nextDouble();
		if (account.getBalance() < amount) {
			System.out.println("Sorry, you don't have enough balance.");
			return false;
		}
		account.setBalance(account.getBalance() - amount);
		System.out.println("Withdraw successfully");
		return true;
	}
	
	/**
	 * To deposit to the ATM
	 * @param account the account the user wants to deposit to
	 * @return true if deposit successfully
	 */
	public boolean deposit(Account account) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("How much do you want to deposit? ");
		double amount = console.nextDouble();
		
		account.setBalance(account.getBalance() + amount);
		System.out.println("deposit succesfully");
		return true;
	}
	
	/**
	 * To display the balance of the account
	 * @param account the acocunt you want to check
	 */
	public void displayBalance(Account account) {
		System.out.printf("Your current balance is $%.2f", account.getBalance());
	}
	
	/**
	 * To print a goodbye message
	 */
	public void printGoodBye() {
		System.out.println("Thank you for using our ATM. Goodbye");
	}
	
	public boolean equals(AutomatedTellerMachine automatedTellerMachine) {
		return this.atmID.equals(automatedTellerMachine.atmID);
	}

	@Override
	public String toString() {
		return String.format("%-10s: %s", "ATM ID", atmID);
	}

	public String getAtmID() {
		return atmID;
	}

	public void setAtmID(String atmID) {
		this.atmID = atmID;
	}
}
