package com.revature.monsterfit.menu;

import java.util.Scanner;

import com.revature.monsterfit.dao.AvatarRepoDB;
import com.revature.monsterfit.models.FitAvatar;

public class ArmoryMenu {
private Scanner input = new Scanner(System.in);
	
	public void start(String name) {
		AvatarRepoDB repo = new AvatarRepoDB();
		FitAvatar fitAvatar= repo.getAvatar(name);
		
		System.out.println("Welcome to the Armory");
		System.out.println("Purchase your weapon of choice");
		System.out.println("[1] WeaponName: Stick    Strength: 100   Price: 5  FitCoins  ");
		System.out.println("[2] WeaponName: Sword    Strength: 200   Price: 12 FitCoins");
		System.out.println("[3] WeaponName: Crossbow Strength: 500   Price: 30 FitCoins");
		System.out.println("[4] WeaponName: Blaster  Strength: 1000  Price: 70 FitCoins");
		System.out.println("[5] Return to hub");
	int	choice = input.nextInt();
		switch (choice) {
		  case 1:
			  String WeaponName1 =  new String("Stick");
			  fitAvatar.purchaseWeapon(repo.getWeapon(WeaponName1));
			  repo.updateFitCoins(fitAvatar);
			  break;
		  case 2:
			  String WeaponName2 = "Sword";
			  fitAvatar.purchaseWeapon(repo.getWeapon(WeaponName2));
			  break;
		  case 3:
			  String WeaponName3 = "Crossbow";
			  fitAvatar.purchaseWeapon(repo.getWeapon(WeaponName3));
			  break; 
		  case 4:
			  String WeaponName4 = "Blaster";
			  fitAvatar.purchaseWeapon(repo.getWeapon(WeaponName4));
			  break;
		  case 5:
			  MonsterFitHub monsterHub = new MonsterFitHub();
				 monsterHub.start(name);
			  break;
		  default:
		    	System.out.println("Invalid input. Try again");
		}
		ArmoryMenu armoryLoop = new ArmoryMenu();
	    armoryLoop.start(name);
		

	}

}
