package com.revature.monsterfit.menu;

import java.util.Scanner;

import com.revature.monsterfit.dao.AvatarRepoDB;
import com.revature.monsterfit.models.FitAvatar;

public class FriendMenu {
private Scanner input = new Scanner(System.in);
	
	public void start(String name) {
		AvatarRepoDB repo = new AvatarRepoDB();
		FitAvatar fitAvatar= repo.getAvatar(name);
		
		System.out.println("Welcome to the Friends Corner");
		System.out.println("What would you like to do?");
		System.out.println("[1] Send a friend request");
		System.out.println("[2] View pending friend requests");
		System.out.println("[3] View a friends profile");
		
	int	choice = input.nextInt();
		switch (choice) {
		  case 1:
			 
			  break;
		  case 2:
			
			  break;
		  case 3:
			  
			  break; 
		
		
	}
}
