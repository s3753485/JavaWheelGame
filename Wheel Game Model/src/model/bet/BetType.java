package model.bet;

import model.GameEngineImpl;
import model.Player;
import model.wheel.Slot;

public enum BetType {
	RED(2) {

		// Override toString method

		@Override
		public String toString() {
			return "Red";
		}

		// check if slot is RED

		@Override
		public boolean isWinningBet(Slot slot) {
			Bet bet = null;

			// get all players bets
			for (Player p : new GameEngineImpl().getAllPlayers()) {
				bet = p.getBet();

				// if the bet is BetType RED, return true
				if (slot.getColor().name() == RED.name() && bet.getBetType().name() == RED.name()) {

					return true;
				}
			}

			// if the bet is not BetType RED, return false
			return false;
		}

	},

	BLACK(2) {

		// Override toString method

		@Override
		public String toString() {
			return "Black";
		}

		// check if slot is BLACK

		@Override
		public boolean isWinningBet(Slot slot) {
			Bet bet = null;

			// get all players bets
			for (Player p : new GameEngineImpl().getAllPlayers()) {
				bet = p.getBet();
				
				// if the bet is BetType BLACK, return true
				if (slot.getColor().name() == BLACK.name() && bet.getBetType().name() == BLACK.name()) {
					return true;
				}
			}
			// if the bet is not BetType BLACK, return false
			return false;
		}
	},

	GREEN(19) {

		// Override toString method

		@Override
		public String toString() {
			return "Green";
		}

		// check if slot is GREEN

		@Override
		public boolean isWinningBet(Slot slot) {
			Bet bet = null;

			// get all players bets
			for (Player p : new GameEngineImpl().getAllPlayers()) {
				bet = p.getBet();

				
				// if the bet is BetType GREEN, return true
				if (slot.getColor().name().equalsIgnoreCase("GREEN0")
						|| slot.getColor().name().equalsIgnoreCase("GREEN00"))
					if (bet.getBetType().name().equalsIgnoreCase("GREEN")) {
						return true;
					}
			}
			// if the bet is not BetType GREEN, return false
			return false;
		}

	},

	NUMBER(38) {

		// Override toString method

		@Override
		public String toString() {
			return "Number";
		}

		// check if slot is a NUMBER. More information required for NUMBER bet

		@Override
		public boolean isWinningBet(Slot slot) {
			return false;

		}

	};

	// initialize multiplier
	public int multiplier;

	private BetType(int multiplier) {

		// Set the multiplier
		this.multiplier = multiplier;
	}

	public int getMultiplier() {

		// return the multiplier
		return multiplier;
	}

	public abstract boolean isWinningBet(Slot slot);
}
