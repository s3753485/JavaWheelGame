package view;

import model.Player;
import model.bet.Bet;
import model.wheel.Slot;

public interface GameCallback
{

	public void addPlayer(Player player);

	public void removePlayer(Player player);

	public void updateBet(Player player, Bet bet);

	public void initialSlot(Slot slot);

	public void advanceSlot(Slot slot);

	public void winningSlot(Slot slot);
}
