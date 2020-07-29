package model;

import java.util.Collection;

import model.bet.BetType;
import model.wheel.Slot;
import view.GameCallback;
import view.GameCallbackCollection;

public interface GameEngine extends GameCallbackCollection
{
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException;
	
	public void removePlayer(String playerId) throws NullPointerException, IllegalArgumentException;
	
	public Collection<Player> getAllPlayers();
	
	public void placeBet(String playerId, int betAmount, BetType betType)
			throws NullPointerException, IllegalArgumentException;
	
	public void placeBet(String playerId, int betAmount, int number)
			throws NullPointerException, IllegalArgumentException;
	
	public void resetAllBets();
	
	public Slot selectStartingSlot();
	
	
	public static final int DEFAULT_INITIAL_DELAY = 50;
	

	public static final int DEFAULT_FINAL_DELAY = 500;
	

	public static final int DEFAULT_DELAY_INCREMENT = 10;
	
	
	public Slot spinWheel();
	
	
	public Slot spinWheel(int initialDelay, int finalDelay, int delayIncrement)
			throws IllegalArgumentException;
	
	
	public void finaliseSpin(Slot slot);
}
