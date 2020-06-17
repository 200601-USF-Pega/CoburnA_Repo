package com.revature.monsterfit.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.monsterfit.dao.AvatarRepoDB;
import com.revature.monsterfit.service.ConnectionService;

public class NewMemberMenu {
private static Scanner sc = new Scanner(System.in);
ConnectionService connectionService = new ConnectionService();

	
public void  startNewMenu() {
		AvatarRepoDB repo = new AvatarRepoDB();
		ArrayList<String> newUser = new ArrayList();
			System.out.println("------------------------------");
			System.out.println("|          Create            |");
			System.out.println("|           New              |");
			System.out.println("|          Account           |");
			System.out.println("------------------------------");
			System.out.println("Enter New Username");
		
			//switch for user input to point them to appropriate places in the code 
			
			String usernameinput = sc.nextLine();
			String username = new String(usernameinput);
			newUser.add(username);
			System.out.println("Enter New Password");
			
	 String passwordinput = sc.nextLine();
		String password = new String(passwordinput);
		newUser.add(password);
		repo.addUser(newUser);
	 System.out.println("New Username: " + username);
	 System.out.println("New Password: " + password);
	 repo.addAvatar(newUser);
	 MemberMenu myMemberMenu = new MemberMenu();
		myMemberMenu.startMemberMenu();
	}
}

