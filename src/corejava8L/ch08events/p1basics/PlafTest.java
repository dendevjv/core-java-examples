/*
 * Listing 8-2
 */
package corejava8L.ch08events.p1basics;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PlafTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				PlafFrame frame = new PlafFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class PlafFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	PlafFrame() {
		super("PlafTest");
		this.setSize(300, 200);

		panel = new JPanel();
		UIManager.LookAndFeelInfo[] infos = UIManager
				.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos) {
			makeButton(info.getName(), info.getClassName());
		}
		add(panel);
	}

	private void makeButton(String name, final String className) {
		JButton button = new JButton(name);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(className);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}