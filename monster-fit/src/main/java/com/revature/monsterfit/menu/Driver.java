package com.revature.monsterfit.menu;

import java.util.Scanner;

import com.revature.monsterfit.service.ConnectionService;

public class Driver {
	
	public static void main(String[] args) {
		
		ConnectionService connectionService = ConnectionService.getInstance();
		
	MainMenu drive = new MainMenu();

			drive.start(); }
			
       }

 