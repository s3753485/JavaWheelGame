package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import model.GameEngine;
import model.GameEngineImpl;

import model.PlayerImpl;
import model.PropertyChange;

import model.bet.BetType;
import model.wheel.Wheel;
import view.ConsoleLoggerCallback;
import view.GUICallback;

public class ToolBarListener implements ActionListener {
	GameEngine engine = (GameEngine) new GameEngineImpl();

	// ToolBarListener constructor
	public ToolBarListener(PropertyChange propertyChange) {
		super();

		// register callbacks
		engine.registerCallback(new GUICallback(engine, propertyChange));
		engine.registerCallback(new ConsoleLoggerCallback(engine));
	}

	public void actionPerformed(ActionEvent e) {

		// if action is place Bet
		if (e.getActionCommand().equals("Place Bet")) {

			// initialize variables
			String[] options = { "number bet", "color bet" };
			String playerID;
			int betAmount;
			int numberBet;
			BetType betType = null;

			playerID = JOptionPane.showInputDialog("Enter PlayerID");
			betAmount = (int) Double.parseDouble(JOptionPane.showInputDialog("Enter amount to bet"));
			int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
					"Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
					options[0]);

			// if option is Color Bet
			if (x == 1) {
				String[] colors = { "Black", "Green", "Red" };

				x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
						"Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, colors,
						colors[0]);

				switch (x) {
				case 0:
					betType = BetType.BLACK;
					break;

				case 1:
					betType = BetType.GREEN;
					break;

				case 2:
					betType = BetType.RED;
					break;

				}

				// Place color bet

				engine.placeBet(playerID, betAmount, betType);
			}

			else {

				numberBet = (int) Double.parseDouble(JOptionPane.showInputDialog("Enter slot number"));

				// If number Bet
				if (numberBet > Wheel.NUMBER_OF_SLOTS) {
					JOptionPane.showMessageDialog(null, "Bet is too large, try again");
				} else {

					// Place number bet
					engine.placeBet(playerID, betAmount, numberBet);
				}
			}
		}

		// if Action is Spin Wheel
		if (e.getActionCommand().equals("Spin Wheel")) {

			// Spin wheel
			engine.spinWheel();
		}

		// if Action is Add Player
		if (e.getActionCommand().equals("Add Player")) {

			// Initialze variables
			String playerID;
			String playerName;
			int points = 0;

			playerID = JOptionPane.showInputDialog("Enter PlayerID");
			playerName = JOptionPane.showInputDialog("Enter player name");
			points = (int) Double.parseDouble(JOptionPane.showInputDialog("Enter Amount of points for player"));

			// if player is not null
			if (!(playerID.equals("")) || !(playerName.equals("")) || points != 0) {

				// add player
				engine.addPlayer(new PlayerImpl(playerID, playerName, points));

			}

			else

			{
				// print error information
				JOptionPane.showMessageDialog(null, "Missing information, try again");
			}
		}

		// if Action is remove player
		if (e.getActionCommand().equals("Remove Player")) {

			// initialize variables
			String playerID;

			playerID = JOptionPane.showInputDialog("Enter PlayerID");

			// If ID is not null
			if (!(playerID.equals(""))) {

				// Remove Player
				engine.removePlayer(playerID);
			}

			else {

				// Print error
				JOptionPane.showMessageDialog(null, "Missing information, try again.");
			}
		}
	}
}
