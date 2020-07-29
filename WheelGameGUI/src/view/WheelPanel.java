//package view;
//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import model.WheelIcon;
//
//@SuppressWarnings("serial")
//public class WheelPanel extends JPanel implements PropertyChangeListener {
//
//	private static final Icon wheel = WheelIcon.WHEEL.getIcon();
//
//	public WheelPanel() {
//
//        ImageIcon icon = new ImageIcon("images/Wheel.png");
//        
//        // create a center aligned label (horizontal alignment)
//        JLabel label = new JLabel(icon, JLabel.CENTER);
// 
//        // add label to frame
//  
//	}
//
//	@Override
//	public void propertyChange(PropertyChangeEvent evt) {
//		System.out.println("Another print");
//
//	}
//}

package view;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import model.PropertyChange;
import model.WheelColors;
import model.WheelIcon;

@SuppressWarnings("serial")
public class WheelPanel extends JPanel implements PropertyChangeListener {
	JLabel pic;

	
	// WheelPanel constructor
	public WheelPanel(PropertyChange propertyChange) {

		
		// Create JLabel
		pic = new JLabel();
		
		// Set size
		pic.setBounds(40, 30, 500, 500);
		ImageIcon image = SetImageSize();
		pic.setIcon(image);

		
		// Add the JLabel
		add(pic);
		setVisible(true);
	}

	// create a function to resize the image
	public ImageIcon SetImageSize() {
		ImageIcon icon = new ImageIcon(WheelIcon.WHEEL.getPath());
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);

		return newImc;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName() == PropertyChange.Events.CHANGE_COLOR) {
			
			// change color to Dark Green
			String color = (String) evt.getNewValue();
			if (color.equals(WheelColors.DARK_GREEN.getLowercase())) {
				this.setBackground(WheelColors.DARK_GREEN.getColor());
				revalidate();
			}

			
			// Change color to Orange
			if (color.equals(WheelColors.ORANGE.getLowercase())) {
				this.setBackground(WheelColors.ORANGE.getColor());
				revalidate();
			}

			// Change color to purple
			if (color.equals(WheelColors.PURPLE.getLowercase())) {
				this.setBackground(WheelColors.PURPLE.getColor());
				revalidate();
			}
		}

	}
}