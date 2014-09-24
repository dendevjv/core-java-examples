package corejava8L.ch07;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ImageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageFrame frame = new ImageFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ImageFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	ImageFrame() {
		super("ImageTest");
		this.setSize(300, 200);
		
		ImageComponent comp = new ImageComponent();
		this.add(comp, BorderLayout.CENTER);
	}
}

class ImageComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private Image image;

	ImageComponent() {
		try {
			image = ImageIO.read(new File("img/blue-ball.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (image == null)
			return;

		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);

		g.drawImage(image, 0, 0, null);

		int width = this.getWidth();
		int height = this.getHeight();

		for (int i = 0; i * imageWidth <= width; i++) {
			for (int j = 0; j * imageHeight <= height; j++) {
				if (i + j > 0) {
					g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j
							* imageHeight);
				}
			}
		}
	}
}