/*
 * Listing 8-1
 */
package corejava8L.ch08events.p1basics;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class ButtonFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	ButtonFrame() {
		super("ButtonTest");
		this.setSize(300, 200);

		panel = new JPanel();
		makeButton("Yellow", Color.YELLOW);
		makeButton("Pink", Color.PINK);
		makeButton("Blue", Color.BLUE);
		makeButton("Green", Color.GREEN);
		makeButton("Red", Color.RED);

		this.add(panel);
	}
	
	private void makeButton(String label, final Color background) {
		JButton button = new JButton(label);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(background);
			}
		});
	}
}
