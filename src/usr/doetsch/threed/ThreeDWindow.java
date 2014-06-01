package usr.doetsch.threed;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class ThreeDWindow extends JApplet {
	
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHints(new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON));
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawLine(0, 0, 640, 380);
	}
	
	public static void main (String[] args) {
		
		JFrame frame = new JFrame("JVM 3D");
		ThreeDWindow applet = new ThreeDWindow();
		
		frame.addWindowListener(new WindowAdapter () {
			
			public void windowClosing (WindowEvent e) {
				System.exit(0);
			}
			
		});	
		
		frame.add(applet);
		
		applet.init();
		
		frame.pack();
		frame.setSize(640, 380);
		frame.setVisible(true);
		
	}
	
	

}
