package model.bet;

import model.wheel.Slot;
import model.wheel.SlotColor;


public interface Bet extends Comparable<Bet>
{

	public int getAmount();
	
	public BetType getBetType();
	
	public boolean isWinningBet(Slot slot);
	
	public int getOutcome(Slot slot);
	
	@Override
	public String toString();
	
	@Override
	public int compareTo(Bet bet);
	
	static final Bet NO_BET = new Bet()
	{
		
		@Override
		public int getAmount()
		{
			return 0;
		}
		
		@Override
		public BetType getBetType()
		{
			return null;
		}
		
		@Override
		public boolean isWinningBet(Slot slot)
		{
			return false;
		}
		
		@Override
		public int getOutcome(Slot slot)
		{
			return 0;
		}
		
		@Override
		public String toString()
		{
			return "No Bet";
		}
		
		@Override
		public int compareTo(Bet bet)
		{
			return bet == this ? 0 : -bet.getAmount();
		}
	};
}
