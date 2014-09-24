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

public class InnerClassTest {

	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

/**
 * Prints the time in regular intervals.
 */
class TalkingClock {
	private class TimePrinter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Date now = new Date();
			System.out.println("At the tone, the time is " + now
					+ " at interval " + TalkingClock.this.interval);
			if (beep) {
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}

	private boolean beep;
	private int interval;

	TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	void start() {
		ActionListener listener = this.new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
}
