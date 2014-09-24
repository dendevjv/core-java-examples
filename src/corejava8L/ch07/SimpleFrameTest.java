package corejava8L.ch07;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SimpleFrame frame = new SimpleFrame();
				frame.setVisible(true);
			}
		});

	}
}

class SimpleFrame extends JFrame {
	private static final int DEFAULT_HEIGHT = 200;
	private static final int DEFAULT_WIDTH = 300;
	private static final long serialVersionUID = 1L;
	
	private SecondFrame secondFrame;
	private JLabel messageLabel;

	SimpleFrame() {
		super("SimpleFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		ImageIcon icon = new  ImageIcon("img/icon.gif");
		this.setIconImage(icon.getImage());
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		addButtons(panel);
		messageLabel = new JLabel();
		panel.add(messageLabel);
		
		this.addComponentListener(new ComponentListener() {
			@Override
			public void componentShown(ComponentEvent e) {
				displayExtendedState("componentShown()");
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				displayExtendedState("componentResized()");
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				displayExtendedState("componentMoved()");
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				displayExtendedState("componentHidden()");
			}
		});
		
		secondFrame = new SecondFrame("Undecorated");
		
		this.addWindowStateListener(new WindowStateListener() {
			
			@Override
			public void windowStateChanged(WindowEvent e) {
//				int state = e.getNewState();
				displayExtendedState("windowStateChanged()");
			}
		});
	}

	public void addButtons(JPanel panel) {
		JButton b1 = new JButton("Show");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				secondFrame.setVisible(true);
			}
		});
		panel.add(b1);
		
		JButton b2 = new JButton("Hide");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (secondFrame != null && secondFrame.isVisible()) {
					secondFrame.setVisible(false);
				}
			}
		});
		panel.add(b2);
		
		JButton b3 = new JButton("toFront");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (secondFrame != null && secondFrame.isVisible()) {
					secondFrame.toFront();
				}
			}
		});
		panel.add(b3);
		
		JButton b4 = new JButton("extendedState");
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayExtendedState("");
			}
		});
		panel.add(b4);
		
		JButton b5 = new JButton("Set ICONIFIED");
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleFrame.this.setExtendedState(ICONIFIED);
			}
		});
		panel.add(b5);
	} // end of addButtons()
	
	private void displayExtendedState(String prefix) {
		int state = this.getExtendedState();
		String s = prefix + ". " + "Extended state = " + state + " :";
		if (state == Frame.NORMAL) {
			s += " normal";
		} else {
			if (bitIsSet(state, Frame.ICONIFIED)) {
				s += " iconified";
			}
			if (bitIsSet(state, Frame.MAXIMIZED_HORIZ)) {
				s += " maximuzed_horizontal";
			}
			if (bitIsSet(state, Frame.MAXIMIZED_VERT)) {
				s += " maximuzed_vertical";
			}
			if (bitIsSet(state, Frame.MAXIMIZED_BOTH)) {
				s += " maximuzed_both";
			}
		}
		messageLabel.setText(s);
		if (secondFrame != null) {
			secondFrame.setText(s);
		}
	}
	
	private final boolean bitIsSet(int number, int bit) {
		return (number & bit) == bit;
	}
} // end of class SimpleFrame

class SecondFrame extends JFrame {
	private static final long serialVersionUID = 7484987312308541482L;
	
	private JTextField textField;

	SecondFrame(String text) {
		setUndecorated(true);
		setLocationByPlatform(true);
		setSize(500, 50);
		textField = new JTextField(text);
		textField.setEditable(false);
		this.add(textField);
	}
	
	void setText(String txt) {
		textField.setText(txt);
	}
}