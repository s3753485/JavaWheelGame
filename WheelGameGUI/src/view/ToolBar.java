package view;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import javax.swing.JToolBar;
import controller.ToolBarListener;
import model.GameEngine;
import model.GameEngineImpl;

import model.PropertyChange;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {

	GameEngine engine = new GameEngineImpl();

	
	// ToolBar constructor
	public ToolBar(PropertyChange callback) {

		
		// Create PlaceBet button
		AbstractButton b1 = new JButton("Place Bet");
		add(b1);

		
		// Create Add Player button
		AbstractButton b2 = new JButton("Add Player");
		add(b2);

		
		// Create Remove Player button
		AbstractButton b3 = new JButton("Remove Player");
		add(b3);

		
		//Create spin wheel button
		AbstractButton b4 = new JButton("Spin Wheel");
		add(b4);

		
		// add action listeners for buttons
		b1.addActionListener(new ToolBarListener(callback));

		b2.addActionListener(new ToolBarListener(callback));

		b3.addActionListener(new ToolBarListener(callback));

		b4.addActionListener(new ToolBarListener(callback));
	}

}
