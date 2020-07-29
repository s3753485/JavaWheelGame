package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum WheelIcon {

	//Wheel ENUM
	WHEEL("images/Wheel.png");

	
	//Initialize variables
	private String wheelIcon;
	private Icon icon;

	
	//Wheel icon constructor 
	private WheelIcon(String wheelIcon) {
		this.wheelIcon = wheelIcon;
		this.icon = new ImageIcon(String.format(wheelIcon));
	}

	//return icon
	public Icon getIcon() {
		return icon;
	}
	
	
	//return wheel icon folder path
	public String getPath() {
		return this.wheelIcon;
	}
}
