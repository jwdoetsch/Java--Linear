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
		
		//g2d.setColor(new Color(0, 0, 0));
		//g2d.drawLine(0, 0, 640, 380);
		
		
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				for (int k = 10; k < 12; k++) {
					drawLine3D (g2d,	i, j, k,
										i, j, k);
				}
			}
		}
		
		
		
		
		drawLine3D (g2d,	1, 1, 10,
							4, 3, 10);
		
		drawLine3D (g2d,	4, 3, 10,
							1.5, 4, 10);
		
		drawLine3D (g2d,	1.5, 4, 10,
							1, 1, 10);
		
		drawLine3D (g2d,	1, 1, 10,
							2.5, 2.5, 13);
		
		drawLine3D (g2d,	4, 3, 10,
							2.5, 2.5, 13);

		drawLine3D (g2d,	1.5, 4, 10,
							2.5, 2.5, 13);


		

		
	}
	
	public static void drawLine3D (Graphics2D g2d, double x1, double y1, double z1,
									double x2, double y2, double z2) {
		
		
		double sx1, sy1, sx2, sy2;
		
		sx1 = (x1 / z1) * 256;
		sy1 = (y1 / z1) * 256;
		
		sx2 = (x2 / z2) * 256;
		sy2 = (y2 / z2) * 256;
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawLine((int) (320 + sx1), (int) (190 - sy1),
						(int) (320 + sx2), (int) (190 - sy2));
		
		
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
		
		frame.getContentPane().setPreferredSize(new Dimension(640, 380));
		
		applet.init();
		
		frame.pack();
		frame.setVisible(true);

	}
	
	

}
