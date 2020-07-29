package view;


import model.GameEngine;
import model.Player;
import model.PropertyChange;
import model.bet.Bet;
import model.wheel.Slot;

public class GUICallback implements GameCallback {
	
	// propertyChange instance variable
	private PropertyChange propertyChange;

	//GUICallback constructor
	public GUICallback(GameEngine engine, PropertyChange propertyChange) {
		super();
		this.propertyChange = propertyChange;
	}

	
	//Add Player callback
	
	@Override
	public void addPlayer(Player player) {
		propertyChange.addPlayer(player.getId());
		
	}

	
	//Remove Player Callback
	@Override
	public void removePlayer(Player player) {
		propertyChange.removePlayer(player.getId());

	}

	//Update Bet callback
	
	@Override
	public void updateBet(Player player, Bet bet) {
		propertyChange.placeBet(player,bet);

	}
	
	// Initial slot callback

	@Override
	public void initialSlot(Slot slot) {
		// TODO Auto-generated method stub

	}
	
	// advance slot callback

	@Override
	public void advanceSlot(Slot slot) {
		// TODO Auto-generated method stub

	}
	
	// winning slot callback

	@Override
	public void winningSlot(Slot slot) {
		propertyChange.spinWheel(slot);

	}
	
	// colorChange callback
	
	public void changeColor(String color) {
		propertyChange.changeColor(color);
	}

}
