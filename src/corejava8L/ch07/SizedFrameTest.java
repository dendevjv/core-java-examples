package corejava8L.ch07;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SizedFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SizedFrame frame = new SizedFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class SizedFrame extends JFrame {
	private static final long serialVersionUID = 830690075470713999L;

	SizedFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		this.setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);
		
		Image img = kit.getImage("img/icon.gif");
		this.setIconImage(img);
		this.setTitle("SizedFrame");
	}
}