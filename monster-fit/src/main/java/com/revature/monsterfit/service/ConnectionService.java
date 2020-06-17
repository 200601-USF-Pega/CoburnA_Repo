package com.revature.monsterfit.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionService {
	private static ConnectionService connectionServiceInstance = null;
	private Connection connection;
	
	public ConnectionService() {
		
		try  {
			
		connection = DriverManager.getConnection("jdbc:postgresql://hansken.db.elephantsql.com:5432/hezlnaov","hezlnaov","ezKl-CqaNEJl--6ltc7l66x9xo2FmkWW");
		
} catch (Exception e) {
	System.out.println("Exception: " + e.getMessage());
	e.printStackTrace();
}
}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	
	public static ConnectionService getInstance() {
		if (connectionServiceInstance == null) {
			
			connectionServiceInstance = new ConnectionService();
			
		}
		return connectionServiceInstance;
	}
	
	
	
	@Override
	public void finalize() {
		try {
			connection.close();
		} catch(Exception e) {
			
		}
	}

}

