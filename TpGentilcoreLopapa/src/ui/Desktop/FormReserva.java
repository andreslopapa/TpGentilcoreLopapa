package ui.Desktop;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import business.entities.Elemento;

import business.entities.Reserva;
import business.logic.CtrlElementoLogic;
import business.logic.CtrlReservaLogic;


public abstract class FormReserva extends ABMC{
	public FormReserva() {
	}

	protected CtrlReservaLogic resLogic = new CtrlReservaLogic();
	protected JLabel lblElemento;
	protected Elemento elementoActual;
	protected JTextArea textAreaDetalle;
	protected CtrlElementoLogic ctrElemLogic;
	protected JDateChooser dateChooserDesde;
	protected JDateChooser dateChooserHasta;
	protected JSpinner timeSpinnerDesde;
	protected JSpinner timeSpinnerHasta;

	
	protected Reserva mapearDeForm() throws ParseException,Exception{

		Reserva r = new Reserva();
		//Elemento e = new Elemento();

		r.setPersona(Ingreso.PersonaLogueada);	
		//e.setId_elemento(elementoActual.getId_elemento());
		r.setElemento(elementoActual);
		
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				formatter.setLenient(false);
				int yearD = dateChooserDesde.getCalendar().get(Calendar.YEAR);
				int monthD = 1+dateChooserDesde.getCalendar().get(Calendar.MONTH);				//le sumo 1 xq inicia el mes en cero (january lo toma como 0)
				int dayD = dateChooserDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
				String HoraD=((JSpinner.DefaultEditor)timeSpinnerDesde.getEditor()).getTextField().getText();
				String fechaD = dayD + "/" + monthD + "/" + yearD;
				r.setFecha_hora_desde_solicitada(formatter.parse(fechaD+" "+HoraD));	
				

				int yearH = dateChooserHasta.getCalendar().get(Calendar.YEAR);
				int monthH = 1+dateChooserHasta.getCalendar().get(Calendar.MONTH);
				int dayH = dateChooserHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
				
				String HoraH=((JSpinner.DefaultEditor)timeSpinnerHasta.getEditor()).getTextField().getText();
				String fechaH = dayH + "/" + monthH + "/" +yearH ;
//				JSpinner.DateEditor timeEditorHasta = new JSpinner.DateEditor(timeSpinnerHasta, "HH:mm:ss");
			
//				r.setFecha_hora_hasta_solicitada(formatter.parse(fechaH+" "+timeEditorHasta.getFormat().format(timeSpinnerHasta.getValue())));	
				r.setFecha_hora_hasta_solicitada(formatter.parse(fechaH+" "+HoraH));	

		
		r.setFecha_hora_reserva_hecha(formatter.parse(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime())));
		r.setDetalle(this.textAreaDetalle.getText());
		return r;
	}
	
	
	
	protected Boolean validaFechas(java.util.Date fechaD,java.util.Date fechaH)throws ParseException,Exception{
		Calendar calendario=Calendar.getInstance();
		if(!resLogic.noEsFechaPasada(fechaD)){
			this.dateChooserDesde.setDate(null);
			this.dateChooserHasta.setDate(null);
			calendario.set(2000, 1, 1, 23, 59, 59);
			timeSpinnerHasta.setValue(calendario.getTime());
			calendario.set(2000, 1, 1, 0, 0, 0);
			timeSpinnerDesde.setValue(calendario.getTime());
			JOptionPane.showMessageDialog(null, "Fecha incorrecta: no puede reservar con "
										+"una fecha-hora pasada","",
					                    JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		//ojo la validacion de arriba no ponerla en el otro abm de reservas
		
		
		if(!this.resLogic.isFHastaMayorQFDesde(fechaD, fechaH)){
			this.dateChooserHasta.setDate(null);
			calendario.set(2000, 1, 1, 23, 59, 59);
			timeSpinnerHasta.setValue(calendario.getTime());
			JOptionPane.showMessageDialog(null, "La fecha-hora hasta debe ser posterior a la fecha-hora "
					+ "desde","",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		java.util.Date hoy=Calendar.getInstance().getTime();
		int diasMaxAnt=elementoActual.getTipo().getDias_max_anticipacion();
		float diasEntre=this.resLogic.getDaysBetween(fechaD,hoy);
		if(diasEntre >diasMaxAnt){
			calendario.setTime(hoy);
			calendario.add(Calendar.DATE,diasMaxAnt);
			JOptionPane.showMessageDialog(null, "No puede reservar este elemento luego del "
					+ ""+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(calendario.getTime()),"",JOptionPane.INFORMATION_MESSAGE);
			this.dateChooserDesde.setDate(calendario.getTime());
			calendario.set(2000, 1, 1, 0, 0, 0);
			timeSpinnerDesde.setValue(calendario.getTime());
			this.dateChooserHasta.setDate(null);
			calendario.set(2000, 1, 1, 23, 59, 59);
			this.timeSpinnerHasta.setValue(calendario.getTime());
			
			return false;
		}
		
		int horasMaxRes=elementoActual.getTipo().getLimite_horas_res();
		float horasEntre=this.resLogic.getHoursBetween(fechaH, fechaD);
		if(horasEntre>horasMaxRes){
			
			calendario.setTime(fechaD);
			calendario.add(Calendar.HOUR_OF_DAY, horasMaxRes);
			this.dateChooserHasta.setDate(calendario.getTime());
			this.timeSpinnerHasta.setValue(calendario.getTime());
			JOptionPane.showMessageDialog(null, "La reserva no puede durar mas de "
										+horasMaxRes+" horas","",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(this.resLogic.getReservasEnIntervalo(elementoActual.getId_elemento(), fechaD, fechaH)>0){
			JOptionPane.showMessageDialog(null, 
					"No se puede reservar en ese intervalo,otra reserva interfiere\n"
					+ "Consulte las reservas del elemento","",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	
	protected Date getFechaD()throws Exception{
		String fechaD=((JTextField)dateChooserDesde.getDateEditor().getUiComponent()).getText();
		String horaD=((JSpinner.DefaultEditor)timeSpinnerDesde.getEditor()).getTextField().getText();
		String fechaHoraD=fechaD+" "+horaD;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		formatter.setLenient(false);
		return formatter.parse(fechaHoraD);
	}
	
	protected Date getFechaH()throws Exception{
		String fechaH=((JTextField)dateChooserHasta.getDateEditor().getUiComponent()).getText();
		String horaH=((JSpinner.DefaultEditor)timeSpinnerHasta.getEditor()).getTextField().getText();
		String fechaHoraH=fechaH+" "+horaH;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		formatter.setLenient(false);
		return formatter.parse(fechaHoraH);
	}
}
