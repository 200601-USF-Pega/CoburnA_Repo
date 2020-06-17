package com.revature.monsterfit.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.monsterfit.dao.AvatarRepoDB;

public class MemberMenu {
private Scanner input = new Scanner(System.in);
	
	public void startMemberMenu() {
		
		AvatarRepoDB repo = new AvatarRepoDB();
		ArrayList<String> user = new ArrayList();
		
		System.out.println("------------------------------");
		System.out.println("|          Monster           |");
		System.out.println("|           Fit              |");
		System.out.println("|          Login             |");
		System.out.println("------------------------------");
		System.out.println("Enter any key to continue, or 2 to exit");
			
		
			
		while (input.nextLine() != "2") {	
			System.out.println("Enter Your Username");
			String username = input.nextLine();
			user.add(username);
			System.out.println("Enter Password for user: " + username );
			
			String password = input.nextLine();
			user.add(password);
		 if (repo.checkLogin(user) == true) {
			 System.out.println("Login Succesful!");
			 MonsterFitHub monsterHub = new MonsterFitHub();
			 monsterHub.start(username);
		 }
		 else {System.out.println("Login attempt failed");
		 System.out.println("Try again ");
		 }
		}
		
			 
}


}