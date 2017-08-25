package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class ParseoAFecha {

    public static Date ParsefechaMetodo(String fecha) throws ParseException
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date fechaDate = null;
    
            try {
				fechaDate = formato.parse(fecha);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
        return fechaDate;
    }
	
	
}