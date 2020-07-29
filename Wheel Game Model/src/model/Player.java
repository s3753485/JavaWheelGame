package model;

import model.bet.Bet;
import model.wheel.Slot;

public interface Player
{

	public String getId();
	
	
	public String getName();
	
	
	
	public int getPoints();
	
	
	
	public int getTotalPoints();
	

	public void assignBet(Bet bet);
	
	
	public Bet getBet();
	
	
	public void finaliseBet(Slot slot);
	
	
	public void resetBet();
	
	
	@Override
	public String toString();
}
