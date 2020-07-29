package model;

import java.util.ArrayList;
import java.util.Collection;

import model.bet.Bet;
import model.bet.BetType;
import model.bet.ColorBet;
import model.bet.ColorBetImpl;
import model.bet.NumberBet;
import model.bet.NumberBetImpl;
import model.wheel.Slot;
import model.wheel.Wheel;
import model.wheel.WheelImpl;
import view.GameCallback;

public class GameEngineImpl implements GameEngine {
	public static final Wheel wheel = (Wheel) new WheelImpl();
	public static final Collection<Player> players = new ArrayList<Player>();
	public Collection<GameCallback> callbacks = new ArrayList<GameCallback>();

	public GameEngineImpl() {
		super();
	}

	@Override
	public void registerCallback(GameCallback callback) {
		callbacks.add(callback);

	}

	@Override
	public void removeCallback(GameCallback callback) {
		callbacks.remove(callback);

	}

	@Override
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException {

		// add the player into the Players array.
		players.add(player);

		// update callback
		for (GameCallback c : callbacks) {
			c.addPlayer(player);
		}
	}

	@Override
	public void removePlayer(int playerId) throws NullPointerException, IllegalArgumentException {

		// Initialize variables
		Player temp = null;
		int id;

		// for each player in players array, check if the ID provided matches with a
		// players id in the array
		for (Player p : players) {
			id = p.getId();

			// if the ID matches, set "Temp" the the player with the same ID
			if (id ==playerId) {
				temp = p;
			}
		}

		// Remove the player from the array
		players.remove(temp);

		// update callback
		for (GameCallback c : callbacks) {
			c.removePlayer(temp);
		}

	}

	@Override
	public Collection<Player> getAllPlayers() {

		// return all players in the players array
		return players;
	}

	@Override
	public void placeBet(int playerId, int betAmount, BetType betType)
			throws NullPointerException, IllegalArgumentException {

		// initialize variables
		ColorBet Bet = (ColorBet) new ColorBetImpl(betAmount, betType);
		BetType type = Bet.getBetType();
		Player temp = null;
		int id;

		// if the betType is not a number
		if (!(type.equals(BetType.NUMBER))) {

			// for each player in players, get the the ID.
			for (Player p : players) {
				id = p.getId();

				// ID the id is equal to the ID provided, set temp as that player
				if (id == playerId) {
					temp = p;
				}
			}

			// assign bet
			temp.assignBet(Bet);

			// update callback
			for (GameCallback c : callbacks) {
				c.updateBet(temp, Bet);
			}
		}
	}

	@Override
	public void placeBet(int playerId, int betAmount, int number)
			throws NullPointerException, IllegalArgumentException {

		// initialize variables
		NumberBet Bet = (NumberBet) new NumberBetImpl(betAmount, number);
		Player temp = null;
		int id;

		// for each player in players, get the the ID.
		for (Player p : players) {
			id = p.getId();

			// if the players id is equal to the id provided, set temp as the player
			if (id == playerId) {
				temp = p;
			}

		}

		// assign bet
		temp.assignBet(Bet);

		for (GameCallback c : callbacks) {
			c.updateBet(temp, Bet);
		}
	}

	@Override
	public void resetAllBets() {

		// initialize variables
		Bet bet = null;
		bet = bet.NO_BET;

		// for each player, reset bet.
		for (Player p : players) {
			p.resetBet();

			// update callback
			for (GameCallback c : callbacks) {
				c.updateBet(p, bet);
			}

		}
	}

	@Override
	public Slot selectStartingSlot() {

		// initialize variables
		int result;

		// generate random position
		result = wheel.generateRandomPosition();

		Slot slot = wheel.moveToPosition(result);

		// return slot
		return slot;

	}

	@Override
	public Slot spinWheel() {

		// call spinWheel() and add delays
		return spinWheel(DEFAULT_INITIAL_DELAY, DEFAULT_FINAL_DELAY, DEFAULT_DELAY_INCREMENT);
	}

	@Override
	public Slot spinWheel(int initialDelay, int finalDelay, int delayIncrement) throws IllegalArgumentException {
		// initialize variables
		Slot startingSlot = selectStartingSlot();
		int position = startingSlot.getPosition();
		Slot nextSlot = null;

		// get starting position
		wheel.moveToPosition(position);

		// update callbacks
		for (GameCallback c : callbacks) {
			c.initialSlot(startingSlot);
		}

		// a for loop that increments with the delayIncrement variable
		for (int i = initialDelay; i < finalDelay; i = (i + delayIncrement)) {

			// try to delay between slot move.
			try {
				Thread.sleep(i);
				nextSlot = wheel.nextSlot();

				for (GameCallback c : callbacks)
					c.advanceSlot(nextSlot);

				// catch exception
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// call finaliseSpin once loop is complete
		finaliseSpin(nextSlot);

		// return the final slot.
		return nextSlot;
	}

	@Override
	public void finaliseSpin(Slot slot) {

		// initialize variable
		Bet bet = null;

		// update callback
		for (GameCallback c : callbacks)
			c.winningSlot(slot);

		// finalise bet for all players
		for (Player p : players) {
			p.finaliseBet(slot);
			bet = p.getBet();

			// update callback
			for (GameCallback c : callbacks)
				c.updateBet(p, bet);
		}

		for (Player p : players)
			p.assignBet(Bet.NO_BET);
	}
}
