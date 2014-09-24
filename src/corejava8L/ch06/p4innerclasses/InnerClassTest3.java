/*
 * Listing 6-4.
 */
package corejava8L.ch06.p4innerclasses;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest3 {
	public static void main(String[] args) {
		TalkingClock3 clock = new TalkingClock3();
		clock.start(1000, true);

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock3 {
	void start(int interval, final boolean beep) {
		class TimePrinter implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date now = new Date();
				System.out.println("Local inner class: At the tone, the time is " + now);
				if (beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
}
