package testsomething;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class FrameForTesting {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyFrame frame = new MyFrame();
				frame.setVisible(true);
			}
		});
	}
}

class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	MyFrame() {
		super("FrameForTesting");
		this.setSize(400, 300);
		this.setLocationByPlatform(true);
		
		MyPanel panel = new MyPanel();
		this.add(panel, BorderLayout.CENTER);
		
//		JButton openFontButton = new JButton("Open Font");
//		this.add(openFontButton, BorderLayout.SOUTH);
	}
	
}


class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	MyPanel() {
		String[] listData = {"Spring", "Hibernate", "MVC" };
		JList<String> jlist = new JList<>(listData );
//		jlist.add
		this.add(jlist);
	}
}