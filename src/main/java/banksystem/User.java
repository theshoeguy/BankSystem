/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.ArrayList;

/**
 *
 * @author 1830041
 */
public class User {
	private String userId;
	private String userName;
	private String password;
	private Account checkingAccount;
	private Account savingAccount;
	private ArrayList<Record> history;
	private static int nextId = 1;
	
	public User() {
		this.userId = String.format("%06d", nextId++);
		this.userName = null;
		this.password = null;
		this.savingAccount = null;
		this.checkingAccount = null;
		this.history = null;
	}
	
	public User(String userName, String password) {
		this.userId = String.format("%06d", nextId++);
		this.userName = userName;
		this.password = password;
		this.savingAccount = null;
		this.checkingAccount = new Account();
		this.history = new ArrayList<>();
	}
	
	public User(User user) {
		this.userId = user.userId;
		this.userName = user.userName;
		this.password = user.password;
		this.savingAccount = new Account(savingAccount);
		this.checkingAccount = new Account(checkingAccount);
		this.history = new ArrayList<>(history);
	}
	
	public boolean equals(User user) {
		return this.userId.equals(user.userId) &&
			this.userName.equals(user.userName) &&
			this.password.equals(user.password) &&
			this.savingAccount.equals(user.savingAccount) &&
			this.checkingAccount.equals(user.checkingAccount) &&
			this.history.equals(user.history);
	}

	@Override
	public String toString() {
		String str = "";
		
		str += String.format("%-20s: %s\n", "User ID", userId);
		str += String.format("%-20s: %s\n", "User Name", userName);
		str += String.format("%-20s: %s\n", "Saving Account", savingAccount);
		str += String.format("%-20s: %s\n", "Checking Account", checkingAccount);
		str += String.format("%-20s: %s\n", "History", history);
		
		return str;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(Account checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public Account getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(Account savingAccount) {
		this.savingAccount = savingAccount;
	}

	public ArrayList<Record> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<Record> history) {
		this.history = history;
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		User.nextId = nextId;
	}
	
}
