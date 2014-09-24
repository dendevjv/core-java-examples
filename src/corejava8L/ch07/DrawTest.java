/*
 * Listing 7-4.
 */
package corejava8L.ch07;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DrawFrame frame = new DrawFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class DrawFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public DrawFrame() {
		this.setTitle("DrawTest");
		this.setSize(400, 400);

		DrawComponent component = new DrawComponent();
		component.setForeground(Color.BLUE.darker());
		this.add(component);
	}
}

class DrawComponent extends JComponent {
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		fillBackgroundWithGradient(g2);

		float leftX = 100.0F;
		float topY = 100.0F;
		float width = 200.0F;
		float height = 150.0F;

		Rectangle2D.Float rect = new Rectangle2D.Float(leftX, topY, width,
				height);
		g2.draw(rect);

		Ellipse2D.Float ellipse = new Ellipse2D.Float();
		ellipse.setFrame(rect);
		g2.draw(ellipse);

		Line2D.Float line = new Line2D.Float(leftX, topY, leftX + width, topY
				+ height);
		g2.draw(line);

		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = height;

		Ellipse2D.Float circle = new Ellipse2D.Float();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY
				+ radius);
		g2.draw(circle);
		
		
	}

	public void fillBackgroundWithGradient(Graphics2D g2) {
		int w = this.getWidth();
		int h = this.getHeight();
		Point2D start = new Point2D.Float(w / 2, 0);
		Point2D end = new Point2D.Float(w / 2, h);
		float[] fractions = {0.0f, 0.5f, 1.0f};
		Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
		Paint  p = new LinearGradientPaint(start, end, fractions, colors);
		Paint savedPaint = g2.getPaint();
		g2.setPaint(p);
		g2.fillRect(0, 0, w, h);
		g2.setPaint(savedPaint);
	}
}
