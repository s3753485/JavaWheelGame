package model.bet;

import model.GameEngineImpl;
import model.Player;
import model.wheel.Slot;

public class NumberBetImpl implements NumberBet {

	private int betValue;
	private int number;

	public NumberBetImpl(int betValue, int number) throws IllegalArgumentException {
		this.betValue = betValue;
		this.number = number;

	}

	@Override
	public int getAmount() {

		// return the bet amount
		return betValue;
	}

	// return teh betType
	@Override
	public BetType getBetType() {
		return BetType.NUMBER;
	}

	@Override
	public boolean isWinningBet(Slot slot) {

		// if the slot number is equal to the players bet number. return true
		if (slot.getNumber() == this.number) {
			return true;
		}

		// else return false

		return false;
	}

	@Override
	public int getOutcome(Slot slot) {

		// initialize variables
		int payout = 0;
		boolean result = false;
		BetType bet = this.getBetType();

		// for each player in array
		for (Player p : new GameEngineImpl().getAllPlayers()) {

			// if the bet is a Number bet
			if (p.getBet() instanceof NumberBet) {

				// get the result of the winning bet
				result = p.getBet().isWinningBet(slot);

				// if the result is true
				if (result == true) {

					// calculate the payout
					payout = p.getBet().getAmount();
					payout = payout * bet.multiplier;
					return payout;

					// if the result is false
				} else {

					// calculate the payout
					payout = 0;
					return payout;
				}
			}
		}
		return payout;

	}

	@Override
	public int compareTo(Bet arg0) {
		return 0;
	}

	// return the number
	@Override
	public int getNumber() {
		return number;
	}

}
