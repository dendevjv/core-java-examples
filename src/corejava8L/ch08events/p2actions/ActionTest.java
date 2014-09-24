/*
 * Listing 8-3
 */
package corejava8L.ch08events.p2actions;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ActionTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ActionFrame frame = new ActionFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ActionFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;

	ActionFrame() {
		super("ActionTest");
		this.setSize(300, 200);
		
		panel = new JPanel();
		InputMap imap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap amap = panel.getActionMap();
		
		makeColorButton(imap, amap, "Yellow", Color.YELLOW);
		makeColorButton(imap, amap, "Blue", Color.BLUE);
		makeColorButton(imap, amap, "Green", Color.GREEN);
		makeColorButton(imap, amap, "Red", Color.RED);
		
		this.add(panel);
	}
	
	private void makeColorButton(InputMap imap, ActionMap amap, String name,  Color color) {
		String imageFileName = "img/" + name.toLowerCase() + "-ball.gif";
		ImageIcon imageIcon = new ImageIcon(imageFileName);
		
		Action action = new ColorAction(name, imageIcon, color);
		JButton button = new JButton(action);
		panel.add(button);
		
		KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl " + name.toUpperCase().substring(0, 1));
		String actionKey = "panel." + name.toLowerCase();
		imap.put(keyStroke, actionKey);
		amap.put(actionKey, action);
	}


	private class ColorAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", c);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue("color");
			panel.setBackground(c);
		}
		
	}
}
