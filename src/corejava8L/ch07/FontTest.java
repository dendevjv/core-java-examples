/*
 * Listing 7-5
 */
package corejava8L.ch07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FontTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FontFrame frame = new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class FontFrame extends JFrame {
	private final class ChangeTextFieldListener implements DocumentListener {
		@Override
		public void removeUpdate(DocumentEvent e) {
			updateMessage();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			updateMessage();
		}

		private void updateMessage() {
			component.setMessage(textField.getText());
		}

		@Override
		public void changedUpdate(DocumentEvent e) { 
			// empty method
		}
	}

	private static final long serialVersionUID = -5062421675095648558L;

	private FontComponent component;
	private JTextField textField;
	
	FontFrame() {
		super("FontFrame");
		this.setSize(300, 200);
		
		
		textField = new JTextField();
		textField.getDocument().addDocumentListener(new ChangeTextFieldListener());
		this.add(textField, BorderLayout.NORTH);
		
		component = new FontComponent();
		this.add(component, BorderLayout.CENTER);

		JComboBox<String> fontsCombo = new JComboBox<>(new String[] {
				"SansSerif", "Serif", "Monospaced", "Dialog", "DialogInput" });
		fontsCombo.setSelectedItem("Serif");
		fontsCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String fontName = (String) cb.getSelectedItem(); 
				component.setFont(fontName);
			}
		});
		this.add(fontsCombo, BorderLayout.SOUTH);
	}
}

/**
 * A component that shows a centered message in a box.
 */
class FontComponent extends JComponent {
	private static final long serialVersionUID = 5416887236632609246L;

	private String message;
	private Font font;
	
	FontComponent() {
		message = "Hello, World!";
		font = new Font("Serif", Font.BOLD, 36);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(font);
		
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(message, context);
		
		double x = (this.getWidth() - bounds.getWidth()) / 2;
		double y = (this.getHeight() - bounds.getHeight()) / 2;
		
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
		g2.drawString(message, (int) x, (int) baseY);
		g2.setPaint(Color.LIGHT_GRAY);
		
		g2.translate((int)x, (int)baseY);
		
//		Line2D baseLine = new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY);
		Line2D baseLine = new Line2D.Double(0, 0, bounds.getWidth(), 0);
		g2.draw(baseLine);
		
//		Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
//		g2.draw(rect);
		g2.draw(bounds);
	}
	
	public void setFont(String fontName) {
		font = new Font(fontName, Font.BOLD, 36);
		repaint();
	}
	
	public void setMessage(String s) {
		message = s;
		this.repaint();
	}
}