package tools;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LimitadorTxt {

	
	//public static enum Campo{ELEID(11),ELENOM(45),ELEIDTIPO(11),CATID(11),CATDESC(100),}
	//en proceso, me fui a dormir,son constantes con las longitudes de los campos para no tener q poner int max
	
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
