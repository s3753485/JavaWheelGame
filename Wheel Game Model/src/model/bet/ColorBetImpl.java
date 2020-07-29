package model.bet;

import model.GameEngineImpl;
import model.Player;
import model.wheel.Slot;

public class ColorBetImpl implements ColorBet {

	private int amount;
	private BetType betType;

	public ColorBetImpl(int amount, BetType betType) throws NullPointerException, IllegalArgumentException {
		this.amount = amount;
		this.betType = betType;
	}

	@Override
	public int getAmount() {

		// return the bet amount
		return amount;
	}

	@Override
	public BetType getBetType() {

		// return the betType
		return betType;
	}

	// get the BetType with the isWinningBet method

	@Override
	public boolean isWinningBet(Slot slot) {
		for (BetType c : BetType.values()) {
			if (c.isWinningBet(slot) == true) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int getOutcome(Slot slot) {

		// initialize variables
		int payout = 0;
		boolean result = false;
		int multiplier = 0;

		// Get the BetType
		for (BetType c : BetType.values()) {
			if (c.isWinningBet(slot) == true) {

				// Get the multiplier from BetType
				multiplier = c.multiplier;
			}
		}

		// For each player in players array
		for (Player p : new GameEngineImpl().getAllPlayers()) {

			// if the players bet is a color bet
			if (p.getBet() instanceof ColorBet) {

				// check if the bet is a winning bet
				result = p.getBet().isWinningBet(slot);

				// if the result is true, calculate the payout
				if (result == true) {
					payout = p.getBet().getAmount();
					payout = payout * multiplier;
					return payout;
				} else {

					// if the result is false, set payout to 0
					payout = 0;
					return payout;
				}
			}
		}
		return this.amount = 0;

	}

	@Override
	public int compareTo(Bet arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
