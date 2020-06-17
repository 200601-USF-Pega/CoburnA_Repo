package com.revature.monsterfit.menu;

import java.util.Scanner;

import com.revature.monsterfit.dao.AvatarRepoDB;
import com.revature.monsterfit.models.FitAvatar;

public class MonsterFitHub {
private Scanner input = new Scanner(System.in);
	
	public void start(String username) {
		String name = username;
		AvatarRepoDB repo = new AvatarRepoDB();
		FitAvatar fitAvatar= repo.getAvatar(name);
		
		System.out.println("Welcome to the Monster Fit Hub");
		System.out.println("What would you like to do?");
		System.out.println("[1] Update Steps [2] View FitAvatar  ");
		System.out.println("[3] Visit Armory  [4] Battle");
		System.out.println("[5] See leaderboard [6] Make Friends");
		System.out.println("[7] Exit Hub");
	int	choice = input.nextInt();
		switch (choice) {
		  case 1:
		    System.out.println("How many steps did you take today?");
		    int steps = input.nextInt();
		    int healthLevel = steps;
		    int fitCoins = steps/1000; 
		    fitAvatar.addFitCoins(fitCoins);
		    fitAvatar.setHealthLevel(healthLevel);
		    repo.updateHealth(fitAvatar);
		    repo.updateFitCoins(fitAvatar);
		    System.out.println("You have succesfully updated your Avatar");
		    break;
		  case 2:
		    System.out.println("Avatar Name: " + fitAvatar.getUsername());
		    System.out.println("Health Remaining: " + fitAvatar.getHealthLevel());
		    System.out.println("Purse: " + fitAvatar.getFitCoins() + " Fit Coins");
		    System.out.println("Points: " + fitAvatar.getPoints());
		    System.out.println("------------------------------------------------------");
		    break;
		  case 3:
		    ArmoryMenu armory = new ArmoryMenu();
		    armory.start(name);
		    break;
		  case 4:
		    Battleground battle = new Battleground();
		    battle.start(name);
		    break;
		  case 5:
		    repo.getLeaderboard();
		    break;
		  case 6:
			  FriendMenu friend = new FriendMenu();
			    friend.start(name);
		    break;
		  case 7:
		    System.out.println("Signing Out...");
		    MainMenu drive = new MainMenu();
			drive.start();
		    break;
		    default:
		    	System.out.println("Invalid input. Try again");
		}
		MonsterFitHub monsterLoop = new MonsterFitHub();
		monsterLoop.start(name);
	}
	
}
