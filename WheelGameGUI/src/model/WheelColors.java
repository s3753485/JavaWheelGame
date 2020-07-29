package model;

import java.awt.Color;

public enum WheelColors {

	// Create ENUMS and RGB details
	DARK_GREEN("Dark Green", 0, 102, 0), ORANGE("Orange", 255, 102, 0), PURPLE("Purple", 102, 0, 153);

	private String lowercase;
	private Color color;

	
	//Setup RGB
	private WheelColors(String lowercase, int r, int g, int b) {
		this.lowercase = lowercase;
		this.color = new Color(r, g, b);
	}

	//Return color
	public Color getColor() {
		return this.color;
	}

	//Return lowercase
	public String getLowercase() {
		return this.lowercase;
	}
}
