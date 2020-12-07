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
public class Bank {
	private static ArrayList<AutomatedTellerMachine> atms = new ArrayList<>();
	private static ArrayList<User> users = new ArrayList<>();
	
	/**
	 * To add a new user to the user list
	 * @param userName the name of the user
	 * @param pin the pin of the user
	 */
	public static void addUser(String userName, String pin) {
		users.add(new User (userName, pin));
	}
	
	/**
	 * To add a new ATM to the atms list
	 */
	public static void addAtm() {
		atms.add(new AutomatedTellerMachine());
	}
	
	public static ArrayList<User> getUsers() {
		return users;
	}
}