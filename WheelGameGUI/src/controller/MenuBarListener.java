package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngine;
import model.GameEngineImpl;
import model.PropertyChange;
import view.GUICallback;

public class MenuBarListener implements ActionListener {

	// Create Game Engine
	GameEngine engine = new GameEngineImpl();

	// Initialize variable
	private GUICallback callback;

	// MenuBarListener construction
	public MenuBarListener(PropertyChange propertyChange) {
		super();
		callback = new GUICallback(engine, propertyChange);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// if Action is dark green
		if (e.getActionCommand().equals("Dark Green")) {

			// set WheelPanel to dark green
			callback.changeColor(e.getActionCommand());

		}

		// if Action is Purple
		if (e.getActionCommand().equals("Purple")) {

			// Set WheelPanel to Purple
			callback.changeColor(e.getActionCommand());
		}

		// if Action is Orange
		if (e.getActionCommand().equals("Orange")) {

			// set WheelPanel to purple
			callback.changeColor(e.getActionCommand());
		}

	}

}
