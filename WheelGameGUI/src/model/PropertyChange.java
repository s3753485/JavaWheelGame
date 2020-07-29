package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;

import model.bet.Bet;
import model.wheel.Slot;
import view.GameCallback;

public class PropertyChange {
	public Collection<GameCallback> callbacks = new ArrayList<GameCallback>();

	// Setup propertyChange
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	
	// Create Events
	public static final class Events {
		public static String ADDED_PLAYER = "Add Player";
		public static String REMOVE_PLAYER = "Remove Player";
		public static String SPIN_WHEEL = "Spin Wheel";
		public static String PLACE_BET = "Place Bet";
		public static String WINNING_SLOT = "Winning Slot";
		public static String CHANGE_COLOR = "Change Color";
	}

	// Method to add listener
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	
	//Method to remove listener
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

	
	// Add player change
	public void addPlayer(int i) {
		this.pcs.firePropertyChange(Events.ADDED_PLAYER, null, i);
	}

	
	// Remove player change
	public void removePlayer(int i) {
		this.pcs.firePropertyChange(Events.REMOVE_PLAYER, i, null);
	}

	
	//Place bet change
	public void placeBet(Player player, Bet bet) {
		this.pcs.firePropertyChange(Events.PLACE_BET, player, bet);
	}

	
	//Spin wheel change
	public void spinWheel(Slot slot) {
		this.pcs.firePropertyChange(Events.SPIN_WHEEL, null, slot);
		this.pcs.firePropertyChange(Events.WINNING_SLOT, null, slot);
	}

	
	//Change color change
	public void changeColor(String color) {
		this.pcs.firePropertyChange(Events.CHANGE_COLOR, null, color);
	}

}
