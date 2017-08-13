package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Campo {

	public enum tipo{EMAIL,DNI,OTRO}
	
	public static boolean Valida(String campo,tipo tipoCampo){
		if(campo.isEmpty() || campo==null){
			JOptionPane.showMessageDialog(null,"Complete todos los campos por favor", "", JOptionPane.INFORMATION_MESSAGE);
			return false;}
		
		switch(tipoCampo){
		case EMAIL:return validaEmail(campo);
		case DNI:return validaDni(campo);
		default:break;
		}
		return true;
	}
	
	
	private static boolean validaEmail(String email){
		
        boolean valido = false;
        
        Pattern patronEmail = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");    
        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        
        if (mEmail.matches()){
           valido = true;  
        }
        else{
        	JOptionPane.showMessageDialog(null, "Email invalido","",JOptionPane.INFORMATION_MESSAGE);
        }
        return valido;
	}
	
	private static boolean validaDni(String dni){
		boolean correcto=dni.matches("[0-9]+");
		if(!correcto){JOptionPane.showMessageDialog(null, "Dni invalido","",JOptionPane.INFORMATION_MESSAGE);}
		return correcto;
	}
}
