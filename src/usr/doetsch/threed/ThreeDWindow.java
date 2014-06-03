package usr.doetsch.threed;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

import javax.swing.JApplet;
import javax.swing.JFrame;

import usr.doetsch.linalg.Matrix;
import usr.doetsch.linalg.TransformationMatrixFactory;

public class ThreeDWindow extends Canvas {

	private TransformationMatrixFactory matfact;
	
	private MatrixMap map;
	private Matrix m;
	
	private double rx = 0, ry = 0, rz = 0, camZ = -20;

	
	
	public ThreeDWindow () {

		this.matfact = TransformationMatrixFactory.createInstance();
		this.map = new MatrixMap();
		
		
		for (int i = -5; i < 6; i++) {
			for (int j = -5; j < 6; j++) {
				for (int k = -5; k < 6; k++) {
					
					double[][] vector = {{i},
							{j},
							{k},
							{1}};
					
					Matrix m = Matrix.createMatrix(vector);
					
					this.map.add(m);

				}
			}
		}
		
		this.m = map.getMatrix();
		
	}
	
	public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
//		g2d.setRenderingHints(new RenderingHints(
//	             RenderingHints.KEY_ANTIALIASING,
//	             RenderingHints.VALUE_ANTIALIAS_ON));
//		
//		//g2d.setColor(new Color(0, 0, 0));
//		//g2d.drawLine(0, 0, 640, 380);
//		
//		g2d.setColor(getBackground());
//		g2d.fillRect(0, 0, 640, 380);
//		g2d.setColor(getForeground());
		
		
		
		rx += 0.1;
		ry += 0.1;
		rz += 0.1;

		

		//Matrix m = map.getMatrix();
		
		for (int i = 0; i < m.getColumns(); i++) {
			
			Matrix tm = Matrix.multiply(Matrix.multiply(matfact.createZAxisRotation(rz), matfact.createXAxisRotation(rx)), m);
			
			drawLine3D (g2d, tm.cells[0][i], tm.cells[1][i], tm.cells[2][i],
					tm.cells[0][i], tm.cells[1][i], tm.cells[2][i]);
		}

	
	}
	

	public void update (Graphics g) {
	
		Image bufferImage = this.createImage(640, 380);
		Graphics2D bufferGraphics = (Graphics2D) bufferImage.getGraphics();
		
		bufferGraphics.setRenderingHints(new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON));
		
		bufferGraphics.setColor(this.getBackground());
		bufferGraphics.fillRect(0, 0, 640, 380);
		bufferGraphics.setColor(this.getForeground());
		
		this.paint(bufferGraphics);
		g.drawImage(bufferImage, 0, 0, this);
		
	}

	
	public void drawLine3D (Graphics2D g2d, double x1, double y1, double z1,
									double x2, double y2, double z2) {
		
		
		double sx1, sy1, sx2, sy2;
		
		sx1 = (x1 / (z1 - camZ)) * 256;
		sy1 = (y1 / (z1 - camZ)) * 256;
		
		sx2 = (x2 / (z2 - camZ)) * 256;
		sy2 = (y2 / (z2 - camZ)) * 256;
		
//		g2d.setColor(new Color(0, 0, 0));
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
		
		//applet.init();
		//applet.
		
		frame.pack();
		frame.setVisible(true);
		
		int fps = 0;
		long start = System.currentTimeMillis();		
		
		while (System.currentTimeMillis() - start < 10000) {
			fps++;
			applet.repaint();
			
		}
		
		
		System.out.println(fps);

	}
	
	

}
