package com.revature.monsterfit.models;

import java.util.ArrayList;

public class FitAvatar {
private String username;
private String password;
private int healthLevel;
private int fitCoins;
private int points;
private int rank;
private ArrayList<Weapon> toolBelt; 




public void addFitCoins(int a) {
	
	this.fitCoins = fitCoins + a;
}

public  void purchaseWeapon(Weapon weapon) {
	
	if (fitCoins >= weapon.getCost()) {
		Weapon myWeapon = weapon;
	this.toolBelt.add(myWeapon);
	System.out.println("Weapon: " + weapon.getName() + " has been added to your toolbelt");
	fitCoins = fitCoins - weapon.getCost();
	}
	else {System.out.println("This weapon is too expensive for your purse");}

}












//getters and setters
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getHealthLevel() {
	return healthLevel;
}
public void setHealthLevel(int healthLevel) {
	this.healthLevel = healthLevel;
}
public int getFitCoins() {
	return fitCoins;
}
public void setFitCoins(int fitCoins) {
	this.fitCoins = fitCoins;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
public int getRank() {
	return rank;
}

public void setRank(int rank) {
	this.rank = rank;
}
public ArrayList<Weapon> getToolBelt() {
	return toolBelt;
}
public void setToolBelt(ArrayList<Weapon> toolBelt) {
	this.toolBelt = toolBelt;
}
}
