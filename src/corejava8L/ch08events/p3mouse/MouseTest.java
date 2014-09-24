/*
 * Listing 8-4
 */
package corejava8L.ch08events.p3mouse;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MouseTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MouseFrame frame = new MouseFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class MouseFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	MouseFrame() {
		super("MouseTest");
		setSize(300, 200);
		
		MouseComponent comp = new MouseComponent();
		add(comp);
	}
}

class MouseComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private static final int SIDE = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	
	MouseComponent() {
		squares = new ArrayList<>();
		current = null;
		
		this.addMouseListener(new MouseHandler());
		this.addMouseMotionListener(new MouseMotionHandler());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (Rectangle2D r : squares) {
			g2.draw(r);
		}
	}
	
	Rectangle2D find(Point2D p) {
		for (Rectangle2D r : squares) {
			if (r.contains(p)) {
				return r;
			}
		}
		return null;
	}
	
	void add(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x - SIDE / 2, y - SIDE / 2, SIDE, SIDE);
		squares.add(current);
		this.repaint();
	}
	
	void remove(Rectangle2D s) {
		if (s == null) return;
		if (s == current) current = null;
		squares.remove(s);
		this.repaint();
	}
	
	private class MouseHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			current = find(e.getPoint());
			if (current == null) {
				add(e.getPoint());
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			current = find(e.getPoint());
			if (current != null && e.getClickCount() >= 2) {
				remove(current);
			}
		}
	}
	
	private class MouseMotionHandler extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			if (find(e.getPoint()) == null) {
				setCursor(Cursor.getDefaultCursor());
			} else {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if (current != null) {
				int x = e.getX();
				int y = e.getY();
				
				current.setFrame(x - SIDE / 2, y - SIDE / 2, SIDE, SIDE);
				repaint();
			}
		}
	}
}