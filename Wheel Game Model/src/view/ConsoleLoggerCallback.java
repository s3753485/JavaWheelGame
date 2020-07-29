package view;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.GameEngine;
import model.GameEngineImpl;
import model.Player;
import model.bet.Bet;
import model.bet.ColorBet;
import model.bet.NumberBet;
import model.wheel.Slot;


public class ConsoleLoggerCallback implements GameCallback {
	public static final Logger LOGGER;

	static {
		// DO NOT EDIT THIS STATIC BLOCK!!

		// Creating consoleHandler, add it and set the log levels.
		LOGGER = Logger.getLogger(ConsoleLoggerCallback.class.getName());
		LOGGER.setLevel(Level.FINER);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINER);
		LOGGER.addHandler(handler);
		LOGGER.setUseParentHandlers(false);
	}

	public ConsoleLoggerCallback(GameEngine engine) {
		super();
	}

	// print added player to console

	@Override
	public void addPlayer(Player player) {
		LOGGER.info("Added " + player.toString());
	}

	// print remove player to console

	@Override
	public void removePlayer(Player player) {
		LOGGER.info("Removed " + player.toString());

	}

	// print update bet to console

	@Override
	public void updateBet(Player player, Bet bet) {

		if (bet instanceof ColorBet) {
			LOGGER.info("Bet updated for Player id=" + player.getId() + ", name=" + player.getName() + ", points="
					+ player.getPoints() + ", Bet " + bet.getAmount() + " on " + bet.getBetType());
		} else if (bet instanceof NumberBet) {
			LOGGER.info("Bet updated for Player id=" + player.getId() + ", name=" + player.getName() + ", points="
					+ player.getPoints() + ", Bet " + bet.getAmount() + " on " + bet.getBetType() + " "
					+ ((NumberBet) bet).getNumber());
		} else {
			LOGGER.info("Bet updated for Player id=" + player.getId() + ", name=" + player.getName() + ", points="
					+ player.getPoints() + " " + player.getBet());
		}

	}

	// print initial slot to console

	@Override
	public void initialSlot(Slot slot) {
		LOGGER.fine("Initial Slot is " + slot.toString());

	}

	// print slot increments to console

	@Override
	public void advanceSlot(Slot slot) {
		LOGGER.fine("Advance slot to " + slot.toString());

	}

	// print winning slot to console

	@Override
	public void winningSlot(Slot slot) {
		LOGGER.fine("Winning slot is " + slot.toString());

		String results = "";
		Bet bet = null;
		int outcome = 0;

		for (Player p : new GameEngineImpl().getAllPlayers()) {
			bet = p.getBet();
			outcome = bet.getOutcome(slot);

			if (outcome > 0) {
				results += "Player: " + p.getId() + " " + p.getName() + " WIN! " + bet.getOutcome(slot) + "\n";
			} else {
				results += "Player: " + p.getId() + " " + p.getName() + " LOSS! " + "-" + p.getBet().getAmount() + "\n";
			}
		}

		LOGGER.info("Final Results:\n" + results);
		results = null;

	}

}
