/*
 * Listing 7-3.
 */
package corejava8L.ch07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NotHelloWorld {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				NotHelloWorldFrame frame = new NotHelloWorldFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class NotHelloWorldFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT = 200;
	private static final int DEFAULT_WIDTH = 350;

	NotHelloWorldFrame() {
		setTitle("NotHelloWorld");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		NotHelloWorldPanel panel = new NotHelloWorldPanel();
		add(panel);
	}
}

class NotHelloWorldPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int MESSAGE_Y = 100;
	private static final int MESSAGE_X = 75;
	
	NotHelloWorldPanel() {
		this.setBackground(Color.yellow);
		JComponent comp1 = new NotHelloWorldComponent();
		add(comp1);
		JComponent comp2 = new NotHelloWorldComponent();
		add(comp2);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Not a Hello World program", MESSAGE_X, MESSAGE_Y);
	}
}

class NotHelloWorldComponent extends JComponent {
	private static final long serialVersionUID = 812033903425925864L;
	
	NotHelloWorldComponent() {
		setPreferredSize(new Dimension(160, 50));
		setBackground(Color.green);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color savedColor = g.getColor();
		Dimension size = this.getSize();
		g.setColor(getBackground());
		g.fillRect(0, 0, size.width, size.height);
		g.setColor(savedColor);
		g.drawString("Not a Hello World program", 5, 30);
	}
}