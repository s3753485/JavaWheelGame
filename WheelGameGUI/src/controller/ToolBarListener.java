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
	private static int IDPlayer = 1;

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
			int playerID;
			int betAmount;
			int numberBet;
			BetType betType = null;

			playerID = Integer.parseInt( (String) JOptionPane.showInputDialog(null,
			        "Text",
			        null, JOptionPane.INFORMATION_MESSAGE,
			        null,
			        null,
			        "[sample text to help input]"));
			
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
				
				String[] numbers = new String[39];
				
				for(int i = 0 ; i < 38 ; i++) {
					numbers[i] += i+1;
				}
				
				

				x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
						"Click a button", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, numbers,
						numbers[0]);

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
			int playerID;
			String playerName;
			int points = 0;

			playerID = IDPlayer;
			
			IDPlayer++;
			
			playerName = JOptionPane.showInputDialog("Enter player name");
			
			points = (int) Double.parseDouble(JOptionPane.showInputDialog("Enter Amount of points for player"));

			// if player is not null
			if (!(playerName.equals("")) || points != 0) {

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
			int playerID;

			playerID = Integer.parseInt( (String) JOptionPane.showInputDialog(
			        null, "Text",
			        null, JOptionPane.INFORMATION_MESSAGE,
			        null,
			        null,
			        "[sample text to help input]"));

			// If ID is not null
				// Remove Player
				engine.removePlayer(playerID);
		}
	}
}
