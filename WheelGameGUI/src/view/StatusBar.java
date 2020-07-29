package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.Player;
import model.PropertyChange;
import model.bet.Bet;
import model.wheel.Slot;

@SuppressWarnings("serial")
public class StatusBar extends JPanel implements PropertyChangeListener {

	
	//Instance Variables
	private JLabel s1;
	private JLabel s2;

	
	//StatusBar constructor
	public StatusBar(PropertyChange callback) {

		
		// Layout is set to GridLayout
		setLayout(new GridLayout(1, 0));

		
		// Set lines to black
		Border border = BorderFactory.createLineBorder(Color.BLACK);

		
		// Create first cell
		s1 = new JLabel("Game Launched");
		s1.setBorder(border);
		s1.setHorizontalAlignment(SwingConstants.LEFT);
		add(s1);

		
		// Create second cell
		s2 = new JLabel("Spin pending");
		s2.setBorder(border);
		s2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(s2);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		
		// Winning slot event
		if (evt.getPropertyName() == PropertyChange.Events.WINNING_SLOT) {
			
			// Update cell to display that the wheel has finished spinning
			Slot slot = (Slot) evt.getNewValue();
			s2.setText(slot.toString());
			s1.setText("Spin complete");
		}

		// Place Bet event
		if (evt.getPropertyName() == PropertyChange.Events.PLACE_BET) {
			
			//update cell to show who has placed a bet
			Player player = (Player) evt.getOldValue();
			Bet bet = (Bet) evt.getNewValue();
			if (!(bet.equals(Bet.NO_BET))) {
				s1.setText(player.getName() + " Bet " + bet.getBetType());
			}

		}

		
		// Added player event
		if (evt.getPropertyName() == PropertyChange.Events.ADDED_PLAYER) {
			
			// Update slot to show that a player has been added
			String id = (String) evt.getNewValue();
			s1.setText("Added PlayerID " + id);
		}
	}
}