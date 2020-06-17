package com.revature.monsterfit.menu;

import java.util.Scanner;

import com.revature.monsterfit.dao.AvatarRepoDB;
import com.revature.monsterfit.models.FitAvatar;

public class Battleground {
private Scanner input = new Scanner(System.in);
	
	public void start(String name) {
		AvatarRepoDB repo = new AvatarRepoDB();
		FitAvatar fitAvatar= repo.getAvatar(name);
		
		
		
		
	}
}
