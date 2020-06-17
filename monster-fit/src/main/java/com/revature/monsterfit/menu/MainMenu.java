package com.revature.monsterfit.menu;

import java.util.Scanner;






public class MainMenu {

	public void MainMenu() {}
	
	public void start() {
		 final Scanner sc = new Scanner(System.in);
		do {
			System.out.println("------------------------------");
			System.out.println("|          Monster           |");
			System.out.println("|            Fit             |");
			System.out.println("------------------------------");
			System.out.println("[0] Create an account");
			System.out.println("[1] Sign in");
			System.out.println("[2] Exit");
			
			//switch for user input to point them to appropriate places in the code 
			
			String userInput = sc.nextLine();
			switch (userInput) {
			case "0":
				NewMemberMenu myNewMemberMenu = new NewMemberMenu();
				myNewMemberMenu.startNewMenu();
				break;
			case "1":
				MemberMenu myMemberMenu = new MemberMenu();
				myMemberMenu.startMemberMenu();
				break;
			case "2":
				System.out.println("Exiting....");
				break;
			default:
				System.out.println("Invalid input please try again!");
					
			}
		} while(sc.nextInt() != 2);
	sc.close();
	}
	
}
