package com.revature.monsterfit.dao;


import java.util.ArrayList;
import java.util.List;

import com.revature.monsterfit.models.FitAvatar;
import com.revature.monsterfit.models.Weapon;

public interface IAvatarRepo {
	
	public int addRewardPoints(int RewardPoints);
	
	//add username and password
	public String[] addUser(ArrayList<String> newUser);

	//add health and fitCoins to DB
	public void setStats();
	
	//return health, fitCoins, RewardPoints, Rankings, and Toolbelt
	public String getStats();
	
	//return friend username, Reward Points, Ranking, and Toolbelt
	public String getFriendStats();
	
	public List<String> getFriendRequests();
	
	public List<String> getAllFriends();
	
	//view top 10 in Leaderboard 
	public List<String> getLeaderboard();
	
	public String[] addAvatar(ArrayList<String> newUser); 
	
	boolean checkLogin(ArrayList<String> User);
	
	public void updateHealth(FitAvatar fitAvatar);
	
	public void updateFitCoins(FitAvatar fitAvatar);
	
	public FitAvatar getAvatar(String name);
	
	public Weapon getWeapon(String weaponName);
}
