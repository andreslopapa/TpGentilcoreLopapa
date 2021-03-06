package ui.Desktop;

import java.awt.EventQueue;

import javax.swing.JFrame;


import java.awt.Color;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.entities.Elemento;
import business.entities.Persona;
import business.entities.Reserva;
import business.logic.CtrlElementoLogic;
import business.logic.CtrlReservaLogic;
import tools.AppDataException;
import tools.Campo;
import tools.LimitadorTxt;


import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class ABMCReserva extends FormReserva{
	
//	CtrlReservaLogic resLogic = new CtrlReservaLogic();
//	private Elemento elementoActual;
//	private JLabel lblElemento;
	private JTextField textElemento;
//	private JTextArea textAreaDetalle;
//	private CtrlElementoLogic ctrElemLogic;
//	private JDateChooser dateChooserDesde;
//	private JDateChooser dateChooserHasta;
	private JDateChooser dateChooserFechaFinRes;
	private JTextField textIdReserva;
	private JPanel panel_EditarReserva;
	int visibleClickCrearReserva=1;
	int visibleClickEditarReserva=1;
	private static ABMCReserva instancia;
	private JButton btnReservarEliminar;
	private JButton btnCancelarResEli;
	private JButton btnActualizar;
	private JButton btnCancelarCierre;
	private Action accion;
	private JPanel panelCrearEliminarReserva;
	private JLabel lblIdReservaNumero;
	protected JSpinner timeSpinnerCierre;
	private Reserva resActual;
	private JButton btnCerrarReserva;

//	private JSpinner timeSpinnerDesde;
//	private JSpinner timeSpinnerHasta;
	public static ABMCReserva getInstancia()throws Exception{
		if(instancia==null){
			instancia=new ABMCReserva();
		}
		return instancia;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main() {								//parametro
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCReserva window = new ABMCReserva();			//parametro
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
	private ABMCReserva() {									//parametro

		this.resLogic = new CtrlReservaLogic();
		initialize();		
		//cargarPersona(per);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		accion=Action.OTHER;
		this.ctrElemLogic=new CtrlElementoLogic();
		setBorder(null);											
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //estas dos ultimas lineas quitan bordes y titulo
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblGestionarReservas = new JLabel("Gestionar Reserva");
		lblGestionarReservas.setFont(new Font("Calibri", Font.BOLD, 19));
		
		panelCrearEliminarReserva = new JPanel();
		panelCrearEliminarReserva.setBackground(Color.WHITE);
		
		JButton btnCrearReserva = new JButton("");
		btnCrearReserva.setToolTipText("Reservar un elemento");
		btnCrearReserva.addMouseListener(new MouseAdapter() {				
			@Override
			public void mouseClicked(MouseEvent arg0) {					//multiplica por -1 para mostrar/ocultar. 
			//	if(visibleClickCrearReserva==1){			
			//	visibleClickCrearReserva=visibleClickCrearReserva*(-1);
				try {
					prepararVistaCrearReserva();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			//	}else{
			//		visibleClickCrearReserva=visibleClickCrearReserva*(-1);
			//		panelCrearReserva.setVisible(false);
			//	}
			}
		});
		
		btnCrearReserva.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/Agregar.png")));
		
		btnCerrarReserva = new JButton("");
		btnCerrarReserva.setToolTipText("Finalizar reserva");
		btnCerrarReserva.addMouseListener(new MouseAdapter() {				
			@Override
			public void mouseClicked(MouseEvent arg0) {					//multiplica por -1 para mostrar/ocultar. 
			//	if(visibleClickEditarReserva==1){			
			//		visibleClickEditarReserva=visibleClickEditarReserva*(-1);
					try {
						prepararVistaCerrarReserva();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
			//	}else{
			//		visibleClickEditarReserva=visibleClickEditarReserva*(-1);
			//		panel_EditarReserva.setVisible(false);
			//	}
			}
		});
		btnCerrarReserva.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/Editar.png")));
		
		JButton btnCancelarSolicitud = new JButton("");
		btnCancelarSolicitud.setToolTipText("Eliminar Reserva");
		btnCancelarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					prepararVistaEliminarReserva();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());		
					}
			}
		});
		btnCancelarSolicitud.setIcon(new ImageIcon(ABMCReserva.class.getResource("/ui/Desktop/Borrar.png")));
		
		panel_EditarReserva = new JPanel();
		panel_EditarReserva.setVisible(false);
		panel_EditarReserva.setBackground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGestionarReservas)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnCrearReserva, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCerrarReserva, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancelarSolicitud, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelCrearEliminarReserva, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_EditarReserva, GroupLayout.PREFERRED_SIZE, 369, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(lblGestionarReservas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCancelarSolicitud, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCerrarReserva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCrearReserva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_EditarReserva, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCrearEliminarReserva, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		textIdReserva = new JTextField();
		textIdReserva.setColumns(10);
		textIdReserva.setEditable(false);
		
		JLabel lblId = new JLabel("ID Reserva");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		dateChooserFechaFinRes = new JDateChooser();
		
		JLabel lblFinReserva = new JLabel("Fecha Cierre");
		lblFinReserva.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnActualizar = new JButton("Cerrar reserva");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickModificarReserva();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (AppDataException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		btnCancelarCierre = new JButton("Cancelar");
		btnCancelarCierre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cancelarCierreClick();
			}
		});
		
		timeSpinnerCierre = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditorCierre = new JSpinner.DateEditor(timeSpinnerCierre, "HH:mm:ss");
		timeSpinnerCierre.setEditor(timeEditorCierre);
		timeSpinnerCierre.setValue(Calendar.getInstance().getTime());
	    getContentPane().add(timeSpinnerCierre);
		timeSpinnerCierre.setVisible(true);
		
		GroupLayout gl_panel_EditarReserva = new GroupLayout(panel_EditarReserva);
		gl_panel_EditarReserva.setHorizontalGroup(
				gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_EditarReserva.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblFinReserva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel_EditarReserva.createSequentialGroup()
								.addComponent(btnActualizar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING, false)
									.addComponent(dateChooserFechaFinRes, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
									.addComponent(textIdReserva, 0, 0, Short.MAX_VALUE)
									.addComponent(btnCancelarCierre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(timeSpinnerCierre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(234))
			);
			gl_panel_EditarReserva.setVerticalGroup(
				gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_EditarReserva.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(textIdReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.LEADING)
							.addComponent(lblFinReserva)
							.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.BASELINE)
								.addComponent(dateChooserFechaFinRes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(timeSpinnerCierre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(12)
						.addGroup(gl_panel_EditarReserva.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnActualizar)
							.addComponent(btnCancelarCierre))
						.addContainerGap(182, Short.MAX_VALUE))
			);
		panel_EditarReserva.setLayout(gl_panel_EditarReserva);
		
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
		
		lblElemento = new JLabel("Elemento (Id)");
		lblElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textElemento = new JTextField();
		textElemento.setColumns(10);
		
		btnReservarEliminar = new JButton("Reservar");
		btnReservarEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickCrearEliminarReserva();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (AppDataException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnReservarEliminar.setVisible(false);
		
		btnCancelarResEli = new JButton("Cancelar");
		btnCancelarResEli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarReservaOEliminacion();
			}
		});
		btnCancelarResEli.setVisible(false);
		
		 JLabel lblReservaId = new JLabel("Reserva (Id)");
		
		lblIdReservaNumero = new JLabel("");
		
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
		
		
		GroupLayout gl_panelCrearReserva = new GroupLayout(panelCrearEliminarReserva);
	gl_panelCrearReserva.setHorizontalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearReserva.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblReservaId)
								.addComponent(lblElemento)
								.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblDesde, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDetalle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblHasta, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIdReservaNumero)
								.addGroup(gl_panelCrearReserva.createSequentialGroup()
									.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(dateChooserHasta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dateChooserDesde, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textElemento, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
										.addComponent(timeSpinnerHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(timeSpinnerDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textAreaDetalle, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCrearReserva.createSequentialGroup()
							.addComponent(btnReservarEliminar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelarResEli)))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		gl_panelCrearReserva.setVerticalGroup(
			gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCrearReserva.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReservaId)
						.addComponent(lblIdReservaNumero))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(textElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblElemento))
					.addGap(12)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.TRAILING)
							.addComponent(dateChooserDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDesde))
						.addComponent(timeSpinnerDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.LEADING)
						.addComponent(timeSpinnerHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooserHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHasta))
					.addGap(17)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(textAreaDetalle, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDetalle))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCrearReserva.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReservarEliminar)
						.addComponent(btnCancelarResEli))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		//panelCrearReserva.setVisible(false);
		panelCrearEliminarReserva.setLayout(gl_panelCrearReserva);
		
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 393, 508);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
	
	
	private void clickCrearEliminarReserva() throws Exception, SQLException,ParseException{
		try {
			if(Campo.Valida(this.textElemento.getText(),Campo.tipo.ID) 
					&& Campo.Valida(((JTextField)dateChooserDesde.getDateEditor().getUiComponent()).getText(), Campo.tipo.FECHA)
					&& Campo.Valida(((JTextField)dateChooserHasta.getDateEditor().getUiComponent()).getText(), Campo.tipo.FECHA)
					&& Campo.Valida(((JSpinner.DefaultEditor)timeSpinnerDesde.getEditor()).getTextField().getText(), Campo.tipo.HORA)
					&& Campo.Valida(((JSpinner.DefaultEditor)timeSpinnerHasta.getEditor()).getTextField().getText(), Campo.tipo.HORA))
			{
				
				int id=Integer.parseInt(this.textElemento.getText());
				Elemento ele=this.ctrElemLogic.getOne(id);
				if(ele!=null){
					    elementoActual=ele;
						if(accion==Action.ADD){
							if(this.validaFechas(this.getFechaD(), this.getFechaH())){
								Reserva resMapeada=this.mapearDeForm();
								if(resLogic.sePuedeCrear(Ingreso.PersonaLogueada, resMapeada)){
									if(!resLogic.hayLimtResPen(Ingreso.PersonaLogueada, resMapeada)){
										resLogic.add(resMapeada);
										JOptionPane.showMessageDialog(this, "Reserva realizada correctamente", "", JOptionPane.INFORMATION_MESSAGE);
									    ListadoReservas.getInstancia().Actualiza();
									    accion=Action.OTHER;
									    btnReservarEliminar.setVisible(false);
									    btnCancelarResEli.setVisible(false);
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
						else if(accion==Action.DELETE){
							
							if(resLogic.sePuedeEliminar(Ingreso.PersonaLogueada, resActual)){
								Reserva res=this.mapearDeForm();
								res.setId_reserva(Integer.parseInt(lblIdReservaNumero.getText()));
								resLogic.delete(res);
								JOptionPane.showMessageDialog(this, "Reserva eliminada correctamente", "", JOptionPane.INFORMATION_MESSAGE);
							    ListadoReservas.getInstancia().Actualiza();
							    accion=Action.OTHER;
							    btnReservarEliminar.setVisible(false);
							    btnCancelarResEli.setVisible(false);
							    editarComponentes(true);
						    }
							else{
								JOptionPane.showMessageDialog(null, "Solo se pueden eliminar reservas pendientes");
							}
						    
						}
						ListadoReservas.getInstancia().Actualiza();
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

			JOptionPane.showMessageDialog(this, "Error:\n"+e.getMessage());

		}		
	}
	
	
	
	
	private void clickModificarReserva() throws Exception,SQLException, ParseException{
		try {
			if(Campo.Valida(((JSpinner.DefaultEditor)timeSpinnerCierre.getEditor()).getTextField().getText(), Campo.tipo.HORA)
				&& Campo.Valida(((JTextField)dateChooserFechaFinRes.getDateEditor().getUiComponent()).getText(), Campo.tipo.FECHA)
				){
				
				if(resLogic.isFCierreMayorQFDesde(this.getFechaCierre(),resActual.getFecha_hora_desde_solicitada())){
					if(resLogic.sePuedeCerrar(resActual)){	
						resLogic.updateParaCerrarRes(this.mapearDeFormFechaFin());
						JOptionPane.showMessageDialog(this, "Reserva finalizada", "", JOptionPane.INFORMATION_MESSAGE);
						ListadoReservas.getInstancia().Actualiza();
						accion=Action.OTHER;
						this.panel_EditarReserva.setVisible(false);
						this.panelCrearEliminarReserva.setVisible(true);
						ListadoReservas.getInstancia().Actualiza();
					}
					else{
						JOptionPane.showMessageDialog(null, "No se puede cerrar la reserva:aun no ha iniciado.");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "La fecha de cierre debe ser posterior al inicio de la reserva");
					this.dateChooserFechaFinRes.setDate(null);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, Campo.Mensaje,"",JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());

		}
	}
	

//	private Reserva mapearDeForm() throws Exception{
//
//		Reserva r = new Reserva();
//		//Persona p = new Persona();
//		Elemento e = new Elemento();
//        r.setId_reserva(Integer.parseInt(this.lblIdReservaNumero.getText()));
//		r.setPersona(Ingreso.PersonaLogueada);	
//		e.setId_elemento(Integer.parseInt(this.textElemento.getText()));
//		r.setElemento(e);
//		
//				int yearD = dateChooserDesde.getCalendar().get(Calendar.YEAR);
//				int monthD = 1+dateChooserDesde.getCalendar().get(Calendar.MONTH);				//le sumo 1 xq inicia el mes en cero (january lo toma como 0)
//				int dayD = dateChooserDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
//				String fechaD = yearD + "-" + monthD + "-" + dayD;
//		r.setFecha_hora_desde_solicitada(Date.valueOf(fechaD));	//el famoso provisorio. --> En vez de estas 5 lineas de codigo, Intent� una mas linda con dateChooserHasta.getDate() como en la linea de abajo pero no me dejaba convertir de java.util.Date a java.sql.date.... Busqe y no encontre ayuda , Luego vere otra forma "mejor"
//		//r.setFecha_hora_desde_solicitada(Date.valueOf(textHasta.getText()));
//
//				int yearH = dateChooserHasta.getCalendar().get(Calendar.YEAR);
//				int monthH = 1+dateChooserHasta.getCalendar().get(Calendar.MONTH);
//				int dayH = dateChooserHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
//				String fechaH = yearH + "-" + monthH + "-" + dayH;
//		r.setFecha_hora_hasta_solicitada(Date.valueOf(fechaH));	//el famoso provisorio
//		
//
//	
////		int year = Calendar.getInstance().get(Calendar.YEAR);
////		int month = Calendar.getInstance().get(Calendar.MONTH)+1;
////		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
////		int hora=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
////		int minutos=Calendar.getInstance().get(Calendar.MINUTE);
////		int segundos=Calendar.getInstance().get(Calendar.SECOND);
////		String fecha = day + "/" +month + "/" + year +"/"+ hora+":"+minutos+":"+segundos;
////		
////		r.setFecha_hora_reserva_hecha(Date.valueOf(fecha));
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		r.setFecha_hora_reserva_hecha(formatter.parse(new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())));
//		r.setDetalle(this.textAreaDetalle.getText());
//		return r;
//	}
	
	
	private Reserva mapearDeFormFechaFin() throws Exception{
		Reserva r = new Reserva();
		r.setId_reserva(Integer.parseInt(this.textIdReserva.getText()));
		r.setFecha_hora_entregado(this.getFechaCierre());			
		return r;
	}
	
	
	private void limpiarCampos()throws Exception{
		this.lblIdReservaNumero.setText(null);
		this.textElemento.setText(null);
		this.dateChooserDesde.setDate(null);
		this.dateChooserHasta.setDate(null);
		this.textAreaDetalle.setText(null);
		this.textIdReserva.setText(null);
		this.dateChooserFechaFinRes.setDate(null);
		Calendar calendario=Calendar.getInstance();
		calendario.set(2000, 1, 1, 0, 0, 0);
		timeSpinnerDesde.setValue(calendario.getTime());
		calendario.set(2000, 1, 1, 23, 59, 59);
		timeSpinnerHasta.setValue(calendario.getTime());
		timeSpinnerCierre.setValue(Calendar.getInstance().getTime());
	}
	
	public void mapearAForm(Reserva res)throws Exception{
		if(res!=null){
			if(accion==Action.OTHER){
				resActual=res;
				this.elementoActual=res.getElemento();
				this.lblIdReservaNumero.setText(String.valueOf(res.getId_reserva()));
				this.textElemento.setText(String.valueOf(res.getElemento().getId_elemento()));
				this.dateChooserDesde.setDate(res.getFecha_hora_desde_solicitada());
				this.dateChooserHasta.setDate(res.getFecha_hora_hasta_solicitada());
				this.textAreaDetalle.setText(res.getDetalle());
				this.textIdReserva.setText(String.valueOf(res.getId_reserva()));
				this.dateChooserFechaFinRes.setDate(res.getFecha_hora_entregado());
				timeSpinnerDesde.setValue(res.getFecha_hora_desde_solicitada());
				timeSpinnerHasta.setValue(res.getFecha_hora_hasta_solicitada());
				if(res.getFecha_hora_entregado()!=null){
					timeSpinnerCierre.setValue(res.getFecha_hora_entregado());}
				else{
					timeSpinnerCierre.setValue(Calendar.getInstance().getTime());
				}
			}
		}
		else{
			this.limpiarCampos();
		}
	}

	private void cancelarCierreClick() {
		accion=Action.OTHER;
		panel_EditarReserva.setVisible(false);
		panelCrearEliminarReserva.setVisible(true);
		try {
			ListadoReservas.getInstancia().mapearHaciaABMCClick();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void cancelarReservaOEliminacion() {
		btnReservarEliminar.setVisible(false);
		btnCancelarResEli.setVisible(false);
		accion=Action.OTHER;
		editarComponentes(true);
		try {
			ListadoReservas.getInstancia().mapearHaciaABMCClick();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	private void prepararVistaCrearReserva() throws Exception {
		btnReservarEliminar.setVisible(true);
		btnCancelarResEli.setVisible(true);
		btnReservarEliminar.setText("Reservar");
		accion=Action.ADD;
		limpiarCampos();
		this.lblIdReservaNumero.setText(String.valueOf(this.resLogic.getMaxId()+1));
		panel_EditarReserva.setVisible(false);
		panelCrearEliminarReserva.setVisible(true);
	}
	protected void prepararVistaEliminarReserva()throws Exception {
		accion=Action.OTHER;
		ListadoReservas.getInstancia().mapearHaciaABMCClick();
		accion=Action.DELETE;
		btnReservarEliminar.setVisible(true);
		btnCancelarResEli.setVisible(true);
		btnReservarEliminar.setText("Eliminar");
		panel_EditarReserva.setVisible(false);
		panelCrearEliminarReserva.setVisible(true);
		editarComponentes(false);
	}

	private void editarComponentes(Boolean opcion) {
		this.textElemento.setEditable(opcion);
		this.dateChooserDesde.setEnabled(opcion);
		this.dateChooserHasta.setEnabled(opcion);
		this.textAreaDetalle.setEditable(opcion);
		this.timeSpinnerDesde.setEnabled(opcion);
		this.timeSpinnerHasta.setEnabled(opcion);
	}

	private void prepararVistaCerrarReserva()throws Exception {
		accion=Action.OTHER;
		ListadoReservas.getInstancia().mapearHaciaABMCClick();
		accion=Action.UPDATE;
		panelCrearEliminarReserva.setVisible(false);
		panel_EditarReserva.setVisible(true);
	}
	
	private java.util.Date getFechaCierre()throws Exception{
		String fechaC=((JTextField)dateChooserFechaFinRes.getDateEditor().getUiComponent()).getText();
		String horaC=((JSpinner.DefaultEditor)timeSpinnerCierre.getEditor()).getTextField().getText();
		String fechaHoraC=fechaC+" "+horaC;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		formatter.setLenient(false);
		return formatter.parse(fechaHoraC);
	}
	
	public void setPermisos(){
		switch(Ingreso.PersonaLogueada.getCategoria().getDescripcion()){
		
		
		case "Administrador":break;
		case "Usuario":
		case "Encargado":
		default:
			
			this.btnCerrarReserva.setVisible(false);
		break;
		
		}
	}
}