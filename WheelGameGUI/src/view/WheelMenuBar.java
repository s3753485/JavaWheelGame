package view;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import controller.MenuBarListener;
import model.PropertyChange;
import model.WheelColors;

@SuppressWarnings("serial")
public class WheelMenuBar extends JMenuBar {

	private ButtonGroup group;

	
	// WheelMenuBar constructor
	public WheelMenuBar(PropertyChange propertyChange) {
		super();

		
		// Create button group
		group = new ButtonGroup();

		
		// Create Menu and add title
		JMenu circleMenu = new JMenu("Select Colour");

		
		// Add the menu
		add(circleMenu);

		
		// Create a menu item for each color in WheelColors
		for (WheelColors color : WheelColors.values()) {
			AbstractButton menuItem = new JRadioButtonMenuItem(color.getLowercase());
			group.add(menuItem);
			circleMenu.add(menuItem);
			menuItem.addActionListener(new MenuBarListener(propertyChange));
		}

	}

}
