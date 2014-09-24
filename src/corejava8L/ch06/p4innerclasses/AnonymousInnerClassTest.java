package corejava8L.ch06.p4innerclasses;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnonymousInnerClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TalkingClock4 clock = new TalkingClock4();
		clock.start(1500, true);

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

class TalkingClock4 {

	public void start(int interval, final boolean beep) {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date now = new Date();
				System.out.println("Anonymous inner class: At the tone, the time is " + now);
				if (beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}; 
		
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
}
