package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameEngine;
import model.GameEngineImpl;
import model.Player;
import model.PropertyChange;
import model.bet.Bet;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel implements PropertyChangeListener {

	// Create array of field to keep a collection of JLabels
	public static final Collection<JLabel> field = new ArrayList<JLabel>();

	GameEngine engine = new GameEngineImpl();

	// PlayerPanel constructor
	public PlayerPanel(PropertyChange propertyChange) {
		super();

		// register callbacks
		engine.registerCallback(new ConsoleLoggerCallback(engine));
		engine.registerCallback(new GUICallback(engine, propertyChange));

		// set layout as grid layout
		setLayout(new GridLayout(0, 1));
		setPreferredSize(new Dimension(300, 100));
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		// Add Player
		if (evt.getPropertyName() == PropertyChange.Events.ADDED_PLAYER) {

			// Add cells for all players
			for (Player p : engine.getAllPlayers()) {
				if (p.getId() == (int)evt.getNewValue()) {
					field.add(new JLabel(p.toString()));

				}
			}

			for (JLabel tf : field) {
				System.out.println(tf);
				add(tf);
				revalidate();
			}
		}

		// Remove player
		if (evt.getPropertyName() == PropertyChange.Events.REMOVE_PLAYER) {
			for (JLabel tf : field) {
				System.out.println(tf.getText().contains("ID= " + evt.getOldValue()));

				// remove the player if the ID is equal to the player id
				if (tf.getText().contains("ID= " + evt.getOldValue())) {
					System.out.println("Removing");
					remove(tf);
					field.remove(tf);
					revalidate();
					repaint();
				}
			}
		}

		// place bet
		if (evt.getPropertyName() == PropertyChange.Events.PLACE_BET) {

			Player player = (Player) evt.getOldValue();
			int id = player.getId();
			boolean result = true;

			// update field for all players that have placed a bet
			for (@SuppressWarnings("unused")
			Player p : engine.getAllPlayers()) {

				for (JLabel l : field) {
					if (l.getText().contains("ID= " + id)) {
						l.setText(player.toString());
					}
					this.revalidate();
				}
			}

			// if all players have placed bets, spin wheel
			for (Player p : engine.getAllPlayers()) {

				if (p.getBet().equals(Bet.NO_BET)) {
					result = false;
				}
			}

			if (result == true) {
				engine.spinWheel();
			}
		}

		// spin wheel
		if (evt.getPropertyName() == PropertyChange.Events.SPIN_WHEEL)

		{

			// Spin wheel will work out if player have won or lost, results are added to the
			// appropriate cells
			for (Player p : engine.getAllPlayers()) {

				for (JLabel l : field) {
					if (l.getText().contains("ID= " + p.getId())) {
						l.setText(p.toString());
					}
				}
			}
		}

	}

}
