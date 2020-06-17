package com.revature.monsterfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.monsterfit.models.FitAvatar;
import com.revature.monsterfit.models.Weapon;
import com.revature.monsterfit.service.ConnectionService;

public class AvatarRepoDB implements IAvatarRepo{

ConnectionService connectionService = ConnectionService.getInstance();
	  
	
	
	
	public AvatarRepoDB() {
		
	}
	
	@Override
	public int addRewardPoints(int RewardPoints) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] addUser(ArrayList<String> newUser) {
		//add username and password
		 
		try {
			final Connection conn = connectionService.getConnection();
			PreparedStatement UserPasswordStatement = conn.prepareStatement("INSERT INTO UserPassword VALUES (?,?)");
			UserPasswordStatement.setString(1, newUser.get(0));
			UserPasswordStatement.setString(2, newUser.get(1));
			UserPasswordStatement.executeUpdate();
			
	
		
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void setStats() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFriendStats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getFriendRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllFriends() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getLeaderboard() {
		// TODO Auto-generated method stub
	
		List<FitAvatar> result = new ArrayList<FitAvatar>();
		
		try {
			
			final Connection conn = connectionService.getConnection();
			Statement s = conn.createStatement();
			s.executeQuery("SELECT Username, Points, RANK () " +
			"OVER (ORDER BY Points DESC) rank_number From FitAvatar;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				FitAvatar fa = new FitAvatar();
				fa.setUsername(rs.getString("Username"));
				fa.setPoints(rs.getInt("Points"));
				fa.setRank(rs.getInt("rank_number"));
				if (!result.contains(fa)) {
					result.add(fa);}
						}			
			} 
				catch (SQLException e) {
					
					e.printStackTrace();
				}
		
		for (FitAvatar fitAvatar : result) {
		System.out.println("Rank: " + fitAvatar.getRank() + "    Username: " + fitAvatar.getUsername() + "Points: " + fitAvatar.getPoints());	
		}
		
		return null;
	}
	

	@Override
	public String[] addAvatar(ArrayList<String> newUser) {
		//set fit avatar table upon user creation and gifting 5 starter coins
		try {
			final Connection conn = connectionService.getConnection();
			PreparedStatement fitAvatarPrep = conn.prepareStatement("INSERT INTO FitAvatar VALUES (?,?,?,?)");
			fitAvatarPrep.setString(1, newUser.get(0));
			fitAvatarPrep.setInt(2, 0);
			fitAvatarPrep.setInt(3, 5);
			fitAvatarPrep.setInt(4, 0);
			fitAvatarPrep.executeUpdate();
			
	
		
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean checkLogin(ArrayList<String> user) {
		// TODO Auto-generated method stub
		
				
		try {
			
			final Connection conn = connectionService.getConnection();
			Statement s = conn.createStatement();
			s.executeQuery("SELECT * " + 
					"FROM UserPassword " + 
					"WHERE Username= " + "'" + user.get(0) + "'" +
					";");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				 String Username = rs.getString("Username");
				 String Password = rs.getString("Password");
				if (Password.equals(user.get(1))) {
					return true;	}
				else {return false;}
				}
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
return false;
	}

	@Override
	public void updateHealth(FitAvatar fitAvatar) {
		// TODO Auto-generated method stub
		try {
			final Connection conn = connectionService.getConnection();
			PreparedStatement fitAvatarPrep = conn.prepareStatement("Update FitAvatar SET healthlevel=? Where username=?");
			fitAvatarPrep.setInt(1, fitAvatar.getHealthLevel());
			fitAvatarPrep.setString(2, fitAvatar.getUsername());
			fitAvatarPrep.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void updateFitCoins(FitAvatar fitAvatar) {
		// TODO Auto-generated method stub
		try {
			final Connection conn = connectionService.getConnection();
			PreparedStatement fitAvatarPrep = conn.prepareStatement("Update FitAvatar SET Coins=? Where username=?");
			fitAvatarPrep.setInt(1, fitAvatar.getFitCoins());
			fitAvatarPrep.setString(2, fitAvatar.getUsername());
			fitAvatarPrep.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Override
	public FitAvatar getAvatar(String name) {
		// TODO Auto-generated method stub

		
		try {
			
			final Connection conn = connectionService.getConnection();
			Statement s = conn.createStatement();
			s.executeQuery("SELECT * From FitAvatar WHERE " +
			"Username = " + "'" + name + "';");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				FitAvatar fa = new FitAvatar();
				fa.setUsername(rs.getString("Username"));
				fa.setHealthLevel(rs.getInt("healthlevel"));
				fa.setFitCoins(rs.getInt("Coins"));
				fa.setPoints(rs.getInt("Points"));
				return  fa;		
						}	
			
			} 	catch (SQLException e) {
					
					e.printStackTrace();
				}
		
	
		
		
		return null;
	}

	@Override
	public Weapon getWeapon(String weaponName) {
		// TODO Auto-generated method stub
	
		try {
			
			final Connection conn = connectionService.getConnection();
			Statement s = conn.createStatement();
			s.executeQuery("SELECT * From Armory WHERE " +
			"Weaponname = " + "'" + weaponName + "';");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Weapon w = new Weapon();
				w.setName(rs.getString("WeaponName"));
				w.setPower(rs.getInt("Strength"));
				w.setCost(rs.getInt("Price"));
				  return w;		
						}	
			
			} 	catch (SQLException e) {
					
					e.printStackTrace();
				}
		
	return null;
	
		
		
	}

	
	
}
