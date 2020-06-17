package com.revature.monsterfit.models;

//possibly make abstract class warrior that attacks, takes damage, and dies

public interface iMortal {
	
public default void	takeDamage(int healthLevel, int power) {};

}
