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
import tools.ParseoAFecha;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

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

public class AltasReserva extends JInternalFrame{
	
	CtrlReservaLogic resLogic = new CtrlReservaLogic();

	
	
	private JLabel lblElemento;
	private JTextField textElemento;
	private JTextArea textAreaDetalle;
	private CtrlElementoLogic ctrElemLogic;
	private JDateChooser dateChooserDesde;
	private JDateChooser dateChooserHasta;

	/**
	 * Launch the application.
	 */
	public static void main() {								//parametro
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltasReserva window = new AltasReserva();			//parametro
					window.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AltasReserva() {									//parametro

		this.resLogic = new CtrlReservaLogic();
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
					.addContainerGap()
					.addComponent(panelCrearReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(panelCrearReserva, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		textAreaDetalle = new JTextArea();
		textAreaDetalle.setLineWrap(true);
		textAreaDetalle.setFont(new Font("Calibri", Font.PLAIN, 12));
		textAreaDetalle.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		dateChooserHasta = new JDateChooser();
		dateChooserHasta.setDateFormatString("yyyy/MM/dd");
		
		dateChooserDesde = new JDateChooser();
		dateChooserDesde.setDateFormatString("yyyy/MM/dd");
		
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
		GroupLayout gl_panelCrearReserva = new GroupLayout(panelCrearReserva);
		gl_panelCrearReserva.setHorizontalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCrearReserva.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(lblElemento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHasta, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addComponent(lblDesde, GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
						.addComponent(lblDetalle, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblGestionarReservas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textAreaDetalle, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addComponent(btnSolicitarReserva)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar))
						.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textElemento, Alignment.LEADING)
							.addComponent(dateChooserDesde, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(dateChooserHasta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
					.addGap(30))
		);
		gl_panelCrearReserva.setVerticalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearReserva.createSequentialGroup()
					.addGap(11)
					.addComponent(lblGestionarReservas)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElemento)
						.addComponent(textElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDesde)
						.addComponent(dateChooserDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHasta)
						.addComponent(dateChooserHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(textAreaDetalle, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDetalle))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSolicitarReserva)
						.addComponent(btnCancelar))
					.addGap(60))
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
			if(Campo.Valida(this.textElemento.getText(),Campo.tipo.ID) 
				&& Campo.Valida(((JTextField)dateChooserDesde.getDateEditor().getUiComponent()).getText(), Campo.tipo.FECHA)
				&& Campo.Valida(((JTextField)dateChooserHasta.getDateEditor().getUiComponent()).getText(), Campo.tipo.FECHA)){
				
				resLogic.add(this.mapearDeForm(Ingreso.PersonaLogueada));
				JOptionPane.showMessageDialog(this, "Reserva realizada correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				ListadoElementos.getInstancia().abrirVentanaElemento(ABMC.Action.OTHER);
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, "Error\n"+e.getMessage());

		}		
	}
	
	
	

	

	private Reserva mapearDeForm(Persona pers) throws ParseException,Exception{

		Reserva r = new Reserva();
		Elemento e = new Elemento();

		r.setPersona(pers);	
		e.setId_elemento(Integer.parseInt(this.textElemento.getText()));
		r.setElemento(e);
		
				int yearD = dateChooserDesde.getCalendar().get(Calendar.YEAR);
				int monthD = 1+dateChooserDesde.getCalendar().get(Calendar.MONTH);				//le sumo 1 xq inicia el mes en cero (january lo toma como 0)
				int dayD = dateChooserDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fechaD = yearD + "-" + monthD + "-" + dayD;
		r.setFecha_hora_desde_solicitada(Date.valueOf(fechaD));	//el famoso provisorio. --> En vez de estas 5 lineas de codigo, Intent� una mas linda con dateChooserHasta.getDate() como en la linea de abajo pero no me dejaba convertir de java.util.Date a java.sql.date.... Busqe y no encontre ayuda , Luego vere otra forma "mejor"
		//r.setFecha_hora_desde_solicitada(Date.valueOf(textHasta.getText()));

				int yearH = dateChooserHasta.getCalendar().get(Calendar.YEAR);
				int monthH = 1+dateChooserHasta.getCalendar().get(Calendar.MONTH);
				int dayH = dateChooserHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fechaH = yearH + "-" + monthH + "-" + dayH;
		r.setFecha_hora_hasta_solicitada(Date.valueOf(fechaH));	//el famoso provisorio
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		r.setFecha_hora_reserva_hecha(formatter.parse(new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())));
		r.setDetalle(this.textAreaDetalle.getText());
		return r;
	}

	
	
	private void limpiarCampos(){
		this.textElemento.setText(null);
		this.dateChooserDesde.setDate(null);
		this.dateChooserHasta.setDate(null);
		this.textAreaDetalle.setText(null);

	}
	
	public void mapearAForm(int id_elemento){
		this.textElemento.setText(String.valueOf(id_elemento));
	}
	
	public void mapearAForm(Reserva res){
		if(res!=null){
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