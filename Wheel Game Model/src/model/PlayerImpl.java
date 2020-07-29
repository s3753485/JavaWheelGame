package model;

import javax.swing.JOptionPane;

import model.bet.Bet;
import model.bet.BetType;
import model.bet.ColorBet;
import model.bet.NumberBet;
import model.wheel.Slot;

public class PlayerImpl implements Player {
	GameEngine engine = (GameEngine) new GameEngineImpl();

	private int playerID;
	private String playerName;
	private int points;
	private Bet bet;

	public PlayerImpl(int playerID, String playerName, int points)
			throws NullPointerException, IllegalArgumentException {
		this.playerID = playerID;
		this.playerName = playerName;
		this.points = points;

		// all bets are set to NO_BET when a Player is created
		this.bet = Bet.NO_BET;
	}

	@Override
	public int getId() {
		// return the players ID
		return playerID;
	}

	@Override
	public String getName() {

		// return the players name
		return playerName;
	}

	@Override
	public int getPoints() {

		// return the players points
		return points;
	}

	@Override
	public int getTotalPoints() {

		// if the bet is NO_BET, return the points
		if (bet == Bet.NO_BET) {
			return points;
		} else {

			// if the bet is not NO_BET, return the points plus what the player currently
			// has as a bet
			int temp = bet.getAmount();
			temp = temp + points;
			return temp;
		}

	}

	@Override
	public void assignBet(Bet bet) {

		// Assign the bet
		int temp = bet.getAmount();

		if (this.points < temp) {
			JOptionPane.showMessageDialog(null, "Not enough points, try again");
		} else {

			// remove the amount of the bet from the players points
			this.points = (points - temp);

			this.bet = bet;

		}
	}

	@Override
	public Bet getBet() {

		// return the bet
		return this.bet;
	}

	@Override
	public void finaliseBet(Slot slot) {

		// initialize variables
		Bet bet = this.getBet();
		int amount = 0;

		// get the outcome of the bet
		amount = bet.getOutcome(slot);

		// add the outcome to the players points
		this.points = this.points + amount;
		this.bet = Bet.NO_BET;
	}

	@Override
	public void resetBet() {

		// add the points back to the players points
		this.points = this.points + this.bet.getAmount();

		// set bet as NO_BET
		this.bet = Bet.NO_BET;
	}

	@Override
	public String toString() {
		if (bet instanceof ColorBet) {
			BetType colorBet = bet.getBetType();
			return String.format("ID= %s, name= %s, points= %d, bet= %s", playerID, playerName, points, colorBet);

		}

		else if (bet instanceof NumberBet) {

			BetType numberBet = bet.getBetType();
			int number = ((NumberBet) bet).getNumber();
			return String.format("ID= %s, name= %s, points= %d, number= %d", playerID, playerName, points, number);

		}

		else {
			// an overwritten version of toString() for the PlayerImpl class.
			return String.format("ID= %s, name= %s, points= %d, bet= %s", playerID, playerName, points, bet);
		}

	}

}
