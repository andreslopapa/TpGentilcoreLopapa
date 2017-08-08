package tools;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LimitadorTxt {

	public static void MaxCaracteres(int max,JTextField txt){
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if(txt.getText().length()>=max){
					evt.consume();
				}
			}
		});
	}
	public static void MaxCaracteres(int max,JPasswordField pwf){
		pwf.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent evt) {
			if(pwf.getPassword().length>=max){
				evt.consume();
			}
		}
	});
	}
}
