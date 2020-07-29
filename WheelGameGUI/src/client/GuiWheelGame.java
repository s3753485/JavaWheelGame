package client;

import javax.swing.SwingUtilities;

import model.PropertyChange;
import model.wheel.Slot;
import model.wheel.WheelImpl;
import view.WheelFrame;

public class GuiWheelGame {

	public static void main(String[] args) {

		// Setup Slots
		checkWheel();

		// Create property change
		PropertyChange propertyChange = new PropertyChange();

		SwingUtilities.invokeLater(

				// run wheel
				new Runnable() {
					@Override
					public void run() {
						new WheelFrame(propertyChange);

					}
				});
	}

	private static void checkWheel() {
		for (Slot s : new WheelImpl().generateWheel())
			System.out.println(s);

		System.out.println();
	}
}