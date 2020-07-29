package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.PropertyChange;

@SuppressWarnings("serial")
public class WheelFrame extends JFrame {

	// WheelFrame constructor
	public WheelFrame(PropertyChange propertyChange) {

		// Set title for game
		super("Wheel Game");

		// Exit when window closes
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Set minimum size
		setMinimumSize(new Dimension(400, 400));

		// Layout is set to BorderLayout
		setLayout(new BorderLayout());

		// Create Menu Bar
		WheelMenuBar menu = new WheelMenuBar(propertyChange);
		setJMenuBar(menu);

		// Create ToolBar, StatusBar, WheelPanel and PlayerPanel
		ToolBar tb = new ToolBar(propertyChange);
		StatusBar sb = new StatusBar(propertyChange);
		WheelPanel wp = new WheelPanel(propertyChange);
		PlayerPanel pp = new PlayerPanel(propertyChange);

		// Add the above to the frame
		add(sb, BorderLayout.SOUTH);
		add(wp, BorderLayout.CENTER);
		add(tb, BorderLayout.NORTH);
		add(pp, BorderLayout.EAST);

		// Add listeners to the above
		propertyChange.addPropertyChangeListener(sb);
		propertyChange.addPropertyChangeListener(wp);
		propertyChange.addPropertyChangeListener(pp);

		// Clean up frame and set to visible
		pack();
		setVisible(true);
	}

}
