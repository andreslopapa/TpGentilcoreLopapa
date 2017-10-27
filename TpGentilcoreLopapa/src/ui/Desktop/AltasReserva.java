package ui.Desktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.entities.Categoria;
import business.entities.Elemento;
import business.entities.Persona;
import business.entities.Reserva;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
import business.logic.CtrlReservaLogic;
import business.logic.CtrlTipoDeElementoLogic;
import tools.AppDataException;
import tools.Campo;
import tools.LimitadorTxt;
import tools.ParseoAFecha;


import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class AltasReserva extends FormReserva{
	
//	CtrlReservaLogic resLogic = new CtrlReservaLogic();
//	private JLabel lblElemento;
	private JTextField textElemento;
//	private JTextArea textAreaDetalle;
//	private CtrlElementoLogic ctrElemLogic;
//	private JDateChooser dateChooserDesde;
//	private JDateChooser dateChooserHasta;
//	private JSpinner timeSpinnerDesde;
//	private JSpinner timeSpinnerHasta;
	private JLabel lblTiempoMaxRes;
	private JLabel lblDiasMaxAnticip;
//	private Elemento elementoActual;
	/**
	 * Launch the application.
	 */
//	public static void main() {								//parametro
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltasReserva window = new AltasReserva();			//parametro
//					window.setVisible(true);
//				} catch (Exception e) {
//					JOptionPane.showMessageDialog(null,e.getMessage());
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AltasReserva() {									//parametro

		this.resLogic = new CtrlReservaLogic();
		this.ctrElemLogic=new CtrlElementoLogic();
		initialize();		
		//cargarPersona(per);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBorder(null);											
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //estas dos ultimas lineas quitan bordes y titulo
		
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panelCrearReserva = new JPanel();
		panelCrearReserva.setBackground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelCrearReserva, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panelCrearReserva, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		textAreaDetalle = new JTextArea();
		textAreaDetalle.setLineWrap(true);
		textAreaDetalle.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAreaDetalle.setBorder(new LineBorder(Color.LIGHT_GRAY));
		LimitadorTxt.MaxCaracteres(LimitadorTxt.Campo.RESDETALLE, textAreaDetalle);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		dateChooserHasta = new JDateChooser();
		
		dateChooserDesde = new JDateChooser();
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblElemento = new JLabel("Elemento");
		lblElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textElemento = new JTextField();
		textElemento.setColumns(10);
		
		JButton btnSolicitarReserva = new JButton("Reservar");
		btnSolicitarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSolicitarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickCrearReserva();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				} catch (AppDataException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JLabel lblGestionarReservas = new JLabel("Gestionar Reserva");
		lblGestionarReservas.setFont(new Font("Calibri", Font.BOLD, 19));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarclick();
			}

			
		});
		
		JLabel lblTitDiasMaxAnticip = new JLabel("Dias maximos para anticipar:");
		
		lblDiasMaxAnticip = new JLabel("");
		
		JLabel lblTitTiempoMaxRes = new JLabel("Horas maximas de reserva:");
		
		lblTiempoMaxRes = new JLabel("");
		
	    timeSpinnerDesde = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditorDesde = new JSpinner.DateEditor(timeSpinnerDesde, "HH:mm:ss");
		timeSpinnerDesde.setEditor(timeEditorDesde);
		Calendar calendario=Calendar.getInstance();
		calendario.set(2000, 1, 1, 0, 0, 0);
		timeSpinnerDesde.setValue(calendario.getTime());
		getContentPane().add(timeSpinnerDesde);
		timeSpinnerDesde.setVisible(true);

//timeSpinnerDesde=new JSpinner();
//timeSpinnerHasta=new JSpinner();
		
		
		
		timeSpinnerHasta = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditorHasta = new JSpinner.DateEditor(timeSpinnerHasta, "HH:mm:ss");
		timeSpinnerHasta.setEditor(timeEditorHasta);
		calendario.set(2000, 1, 1, 23, 59, 59);
		timeSpinnerHasta.setValue(calendario.getTime());
		getContentPane().add(timeSpinnerHasta);
		timeSpinnerHasta.setVisible(true);

		
		GroupLayout gl_panelCrearReserva = new GroupLayout(panelCrearReserva);
		gl_panelCrearReserva.setHorizontalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCrearReserva.createSequentialGroup()
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblElemento, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
						.addComponent(lblHasta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(lblDesde, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE)
						.addComponent(lblDetalle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addComponent(lblTitTiempoMaxRes)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTiempoMaxRes)
							.addContainerGap())
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addComponent(textElemento, 199, 199, 199)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelCrearReserva.createSequentialGroup()
							.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelCrearReserva.createSequentialGroup()
									.addComponent(lblTitDiasMaxAnticip)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblDiasMaxAnticip)
									.addGap(14))
								.addGroup(Alignment.LEADING, gl_panelCrearReserva.createSequentialGroup()
									.addGap(4)
									.addComponent(lblGestionarReservas, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
								.addComponent(textAreaDetalle, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panelCrearReserva.createSequentialGroup()
									.addComponent(btnSolicitarReserva)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancelar))
								.addGroup(Alignment.LEADING, gl_panelCrearReserva.createSequentialGroup()
									.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(dateChooserHasta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dateChooserDesde, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
										.addComponent(timeSpinnerHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(timeSpinnerDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(42))))
		);
		gl_panelCrearReserva.setVerticalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearReserva.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestionarReservas)
					.addGap(43)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(textElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblElemento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitDiasMaxAnticip)
						.addComponent(lblDiasMaxAnticip))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitTiempoMaxRes)
						.addComponent(lblTiempoMaxRes))
					.addGap(14)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(timeSpinnerDesde, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesde, Alignment.TRAILING)
						.addComponent(dateChooserDesde, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooserHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHasta)
						.addComponent(timeSpinnerHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(textAreaDetalle, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDetalle))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSolicitarReserva)
						.addComponent(btnCancelar))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panelCrearReserva.setLayout(gl_panelCrearReserva);
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 397, 477);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//	mapearAForm(per);				//per es la persona logueada que se envia como parametro desde el login
	//	cargarListaTdE();
	}
	/*
	private void cargarListaTdE(){
			try {	
				this.comboBoxTiposDeElementos.setModel(new DefaultComboBoxModel(ctrElemLogic.getTipoDeElemento().toArray()));		//en el controlorador de reservas o de elemento??
				this.comboBoxTiposDeElementos.setSelectedIndex(-1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}*/
	private void cancelarclick() {
		try {
			ListadoElementos.getInstancia().abrirVentanaElemento(ABMC.Action.OTHER);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void clickCrearReserva() throws Exception, SQLException, AppDataException{
		try {
			String fechaD=((JTextField)dateChooserDesde.getDateEditor().getUiComponent()).getText();
			String fechaH=((JTextField)dateChooserHasta.getDateEditor().getUiComponent()).getText();
			String horaD=((JSpinner.DefaultEditor)timeSpinnerDesde.getEditor()).getTextField().getText();
			String horaH=((JSpinner.DefaultEditor)timeSpinnerHasta.getEditor()).getTextField().getText();
//			String fechaHoraD=fechaD+" "+horaD;
//			String fechaHoraH=fechaH+" "+horaH;
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//			formatter.setLenient(false);
			if(Campo.Valida(this.textElemento.getText(),Campo.tipo.ID) 
				&& Campo.Valida(fechaD, Campo.tipo.FECHA)
				&& Campo.Valida(horaD, Campo.tipo.HORA)
				&& Campo.Valida(fechaH, Campo.tipo.FECHA)
				&& Campo.Valida(horaH, Campo.tipo.HORA)){
					
					
					Elemento ele=this.ctrElemLogic.getOne(Integer.parseInt(textElemento.getText()));
					if(ele!=null){
						this.elementoActual=ele;
						if(this.validaFechas(this.getFechaD(),this.getFechaH())){
							Reserva resMapeada=this.mapearDeForm();
							if(resLogic.sePuedeCrear(Ingreso.PersonaLogueada,resMapeada)){
								if(!resLogic.hayLimtResPen(Ingreso.PersonaLogueada, resMapeada)){
									resLogic.add(resMapeada);
									JOptionPane.showMessageDialog(this, "Reserva realizada correctamente", "", JOptionPane.INFORMATION_MESSAGE);
									ListadoElementos.getInstancia().abrirVentanaElemento(ABMC.Action.OTHER);
								}
								else{
									JOptionPane.showMessageDialog(null, "No puede reservar mas elementos de este tipo\n"
											+ "Limite de reservas pendientes alcanzadas para el tipo:"+resMapeada.getElemento().getTipo().getNombre());
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "Solo los encargados pueden reservar este tipo de elemento");
							}
						}
					}
					else{
						textElemento.setText(null);
						JOptionPane.showMessageDialog(null, "El elemento no existe","",JOptionPane.INFORMATION_MESSAGE);
					}
			}
			else{
				JOptionPane.showMessageDialog(null, Campo.Mensaje,"",JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, "Error\n"+e.getMessage());

		}		
	}
	
	
	

	

//	private Reserva mapearDeForm() throws ParseException,Exception{
//
//		Reserva r = new Reserva();
//		Elemento e = new Elemento();
//
//		r.setPersona(Ingreso.PersonaLogueada);	
//		e.setId_elemento(Integer.parseInt(this.textElemento.getText()));
//		r.setElemento(e);
//		
//				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//				formatter.setLenient(false);
//				int yearD = dateChooserDesde.getCalendar().get(Calendar.YEAR);
//				int monthD = 1+dateChooserDesde.getCalendar().get(Calendar.MONTH);				//le sumo 1 xq inicia el mes en cero (january lo toma como 0)
//				int dayD = dateChooserDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
//				String HoraD=((JSpinner.DefaultEditor)timeSpinnerDesde.getEditor()).getTextField().getText();
//				String fechaD = dayD + "/" + monthD + "/" + yearD;
//				r.setFecha_hora_desde_solicitada(formatter.parse(fechaD+" "+HoraD));	
//				
//
//				int yearH = dateChooserHasta.getCalendar().get(Calendar.YEAR);
//				int monthH = 1+dateChooserHasta.getCalendar().get(Calendar.MONTH);
//				int dayH = dateChooserHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
//				
//				String HoraH=((JSpinner.DefaultEditor)timeSpinnerHasta.getEditor()).getTextField().getText();
//				String fechaH = dayH + "/" + monthH + "/" +yearH ;
////				JSpinner.DateEditor timeEditorHasta = new JSpinner.DateEditor(timeSpinnerHasta, "HH:mm:ss");
//			
////				r.setFecha_hora_hasta_solicitada(formatter.parse(fechaH+" "+timeEditorHasta.getFormat().format(timeSpinnerHasta.getValue())));	
//				r.setFecha_hora_hasta_solicitada(formatter.parse(fechaH+" "+HoraH));	
//
//		
//		r.setFecha_hora_reserva_hecha(formatter.parse(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime())));
//		r.setDetalle(this.textAreaDetalle.getText());
//		return r;
//	}

//	private Boolean validaFechas(java.util.Date fechaD,java.util.Date fechaH)throws ParseException,Exception{
//		Calendar calendario=Calendar.getInstance();
//		if(!resLogic.noEsFechaPasada(fechaD)){
//			this.dateChooserDesde.setDate(null);
//			this.dateChooserHasta.setDate(null);
//			calendario.set(2000, 1, 1, 23, 59, 59);
//			timeSpinnerHasta.setValue(calendario.getTime());
//			calendario.set(2000, 1, 1, 0, 0, 0);
//			timeSpinnerDesde.setValue(calendario.getTime());
//			JOptionPane.showMessageDialog(null, "Fecha incorrecta: no puede reservar con "
//										+"una fecha-hora pasada","",
//					                    JOptionPane.INFORMATION_MESSAGE);
//			return false;
//		}
//		
//		//ojo la validacion de arriba no ponerla en el otro abm de reservas
//		
//		
//		if(!this.resLogic.isFHastaMayorQFDesde(fechaD, fechaH)){
//			this.dateChooserHasta.setDate(null);
//			calendario.set(2000, 1, 1, 23, 59, 59);
//			timeSpinnerHasta.setValue(calendario.getTime());
//			JOptionPane.showMessageDialog(null, "La fecha-hora hasta debe ser posterior a la fecha-hora "
//					+ "desde","",JOptionPane.INFORMATION_MESSAGE);
//			return false;
//		}
//		
//		java.util.Date hoy=Calendar.getInstance().getTime();
//		int diasMaxAnt=Integer.parseInt(lblDiasMaxAnticip.getText());
//		float diasEntre=this.resLogic.getDaysBetween(fechaD,hoy);
//		if(diasEntre >diasMaxAnt){
//			calendario.setTime(hoy);
//			calendario.add(Calendar.DATE,diasMaxAnt);
//			JOptionPane.showMessageDialog(null, "No puede reservar este elemento luego del "
//					+ ""+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(calendario.getTime()),"",JOptionPane.INFORMATION_MESSAGE);
//			this.dateChooserDesde.setDate(calendario.getTime());
//			calendario.set(2000, 1, 1, 0, 0, 0);
//			timeSpinnerDesde.setValue(calendario.getTime());
//			this.dateChooserHasta.setDate(null);
//			calendario.set(2000, 1, 1, 23, 59, 59);
//			this.timeSpinnerHasta.setValue(calendario.getTime());
//			
//			return false;
//		}
//		
//		int horasMaxRes=Integer.parseInt(lblTiempoMaxRes.getText());
//		float horasEntre=this.resLogic.getHoursBetween(fechaH, fechaD);
//		if(horasEntre>horasMaxRes){
//			
//			calendario.setTime(fechaD);
//			calendario.add(Calendar.HOUR_OF_DAY, horasMaxRes);
//			this.dateChooserHasta.setDate(calendario.getTime());
//			this.timeSpinnerHasta.setValue(calendario.getTime());
//			JOptionPane.showMessageDialog(null, "La reserva no puede durar mas de "
//										+horasMaxRes+" horas","",JOptionPane.INFORMATION_MESSAGE);
//			return false;
//		}
//		
//		if(this.resLogic.getReservasEnIntervalo(Integer.parseInt(textElemento.getText()), fechaD, fechaH)>0){
//			JOptionPane.showMessageDialog(null, 
//					"No se puede reservar en ese intervalo,otra reserva interfiere\n"
//					+ "Consulte las reservas del elemento","",JOptionPane.INFORMATION_MESSAGE);
//			return false;
//		}
//		return true;
//	}
	
	private void limpiarCampos(){
		this.textElemento.setText(null);
		this.lblDiasMaxAnticip.setText(null);
		this.lblTiempoMaxRes.setText(null);
		this.dateChooserDesde.setDate(null);
		this.dateChooserHasta.setDate(null);
		this.textAreaDetalle.setText(null);
		Calendar calendario=Calendar.getInstance();
		calendario.set(2000, 1, 1, 0, 0, 0);
		timeSpinnerDesde.setValue(calendario.getTime());
		calendario.set(2000, 1, 1, 23, 59, 59);
		timeSpinnerHasta.setValue(calendario.getTime());
	}
	
	public void mapearAForm(Elemento elemento){
		this.elementoActual=elemento;
		this.textElemento.setText(String.valueOf(elemento.getId_elemento()));
		this.lblDiasMaxAnticip.setText(String.valueOf(elemento.getTipo().getDias_max_anticipacion()));
		this.lblTiempoMaxRes.setText(String.valueOf(elemento.getTipo().getLimite_horas_res()));
	}
	
	public void mapearAForm(Reserva res){
		if(res!=null){
		this.elementoActual=res.getElemento();
		this.textElemento.setText(String.valueOf(res.getElemento().getId_elemento()));
		this.dateChooserDesde.setDate(res.getFecha_hora_desde_solicitada());
		this.dateChooserHasta.setDate(res.getFecha_hora_hasta_solicitada());
		this.textAreaDetalle.setText(res.getDetalle());
		}
		else{
			this.limpiarCampos();
		}
	}
}