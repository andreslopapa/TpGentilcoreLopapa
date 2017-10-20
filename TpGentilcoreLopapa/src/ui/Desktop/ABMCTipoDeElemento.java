package ui.Desktop;

import tools.Campo;
import business.entities.*;
import business.logic.*;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import org.jdesktop.beansbinding.ObjectProperty;

public class ABMCTipoDeElemento extends JInternalFrame{

	CtrlTipoDeElementoLogic ctrlTde = new CtrlTipoDeElementoLogic();
	private ArrayList<TipoDeElemento> tdes;// = new ArrayList<>();
	
	
	private JFrame frmSistemaDeGestion;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTable tableTipos;
	private JScrollPane scrollPaneTablaTipos;
	


	private static ABMCTipoDeElemento Instancia=null;
	private JButton btnReiniciarListado;
	private JButton btnBotonquebusca;
	private JCheckBox chckbxOnlyEncargados;
	private JSpinner spinnerMaxResPen;
	private JSpinner spinnerLimiteHoras;
	private JSpinner spinnerDiasAnt;
	public static ABMCTipoDeElemento getInstancia()throws Exception{
		if(Instancia==null){
			Instancia=new ABMCTipoDeElemento();
		}
		return Instancia;
	}
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ABMCPersona window = new ABMCPersona();
//					window.frmSistemaDeGestin.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	 // Create the application.

	private ABMCTipoDeElemento() throws Exception {
		
		getContentPane().setBackground(Color.WHITE);
		setBorder(null);											
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //estas dos ultimas lineas quitan bordes y barra superior de la ventana
		
		
		JLabel lblCantMaxResPen = new JLabel("Max reservas pendientes");
		lblCantMaxResPen.setToolTipText("Es la cantidad maxima de elementos de este tipo \nque cada persona puede tener pendiente a futuro");
		lblCantMaxResPen.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantMaxResPen.setForeground(new Color(0, 51, 102));
		lblCantMaxResPen.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblLimiteHorasRes = new JLabel("Limite de Horas");
		lblLimiteHorasRes.setToolTipText("Limite maximo de tiempo de reserva (en horas)");

		lblLimiteHorasRes.setHorizontalAlignment(SwingConstants.LEFT);
		lblLimiteHorasRes.setForeground(new Color(0, 51, 102));
		lblLimiteHorasRes.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(new Color(0, 51, 102));
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblDiasDeAnticipacion = new JLabel("Dias de Anticipacion");
		lblDiasDeAnticipacion.setToolTipText("Cantidad maxima de dias de anticipacion para reservar este tipo");
		lblDiasDeAnticipacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiasDeAnticipacion.setForeground(new Color(0, 51, 102));
		lblDiasDeAnticipacion.setFont(new Font("Calibri", Font.PLAIN, 14));

		
		JLabel lblGestionDeTipos = new JLabel("Gestión de Tipos de Elementos");
		lblGestionDeTipos.setForeground(new Color(0, 51, 102));
		lblGestionDeTipos.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/Agregar.png")));
		btnGuardar.setToolTipText("Crear nuevo tipo");
		btnGuardar.setForeground(new Color(0, 51, 102));
		btnGuardar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					guardarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
	
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setForeground(new Color(0, 51, 102));
		lblId.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Buscar Tipo de Elemento");
		btnBuscar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_search_black_24dp_1x.png")));
		btnBuscar.setForeground(new Color(0, 51, 102));
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					buscarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/Editar.png")));
		btnModificar.setToolTipText("Actualizar datos del tipo");
		btnModificar.setForeground(new Color(0, 51, 102));
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modificarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/Borrar.png")));
		btnBorrar.setToolTipText("Borrar tipo de elemento");
		btnBorrar.setForeground(new Color(153, 0, 0));
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					eliminarClick();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al apretar en boton borrar\n"+e1.getMessage());
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		
		JLabel lblIconousuario = new JLabel("");
		lblIconousuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIconousuario.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_devices_white_24dp_2x.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblIconousuario)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblIconousuario)
					.addContainerGap(377, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		scrollPaneTablaTipos = new JScrollPane();
		scrollPaneTablaTipos.setBackground(Color.WHITE);			

		
		btnBotonquebusca = new JButton("");
		btnBotonquebusca.setToolTipText("Seleccionar tipo para visualizar en formulario");
		btnBotonquebusca.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_touch_app_black.png")));
		btnBotonquebusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					buscaTipo();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al apretar en boton Buscar\n"+e.getMessage());
				}
			}
		});
		
		JButton btnBuscarenlista = new JButton("");
		btnBuscarenlista.setToolTipText("Mostrar listado para buscar");
		btnBuscarenlista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clickMostrarListado();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error con boton Mostrar Listado Personas\n"+e1.getMessage());
				}
			}
		});
		
		btnBuscarenlista.setSelectedIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/buscaPersonaListad.png")));
		btnBuscarenlista.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/buscaPersonaLista.png")));
		
		JLabel lblListadoDeTipos = new JLabel("Listado de Tipos de Elementos");
		lblListadoDeTipos.setForeground(new Color(0, 51, 102));
		lblListadoDeTipos.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		btnReiniciarListado = new JButton("");
		btnReiniciarListado.setToolTipText("Recargar tabla");
		btnReiniciarListado.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/ic_replay_black_24dp_1x.png")));

		btnReiniciarListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarLista();
			}

			
		});

		
		JButton btnLimpiarCampos = new JButton("");
		btnLimpiarCampos.setToolTipText("Limpiar formulario");
		btnLimpiarCampos.setIcon(new ImageIcon(ABMCPersona.class.getResource("/ui/Desktop/escoba.png")));
		btnLimpiarCampos.setFont(new Font("Calibri", Font.PLAIN, 9));
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTexto();
			}
		});
		
		spinnerMaxResPen = new JSpinner();
		spinnerLimiteHoras = new JSpinner();
		spinnerDiasAnt = new JSpinner();
		
		chckbxOnlyEncargados = new JCheckBox("Restringido a Encargados");
		chckbxOnlyEncargados.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxOnlyEncargados.setBackground(Color.WHITE);
		chckbxOnlyEncargados.setFont(new Font("Dialog", Font.PLAIN, 14));
		chckbxOnlyEncargados.setForeground(new Color(0, 51, 102));
		chckbxOnlyEncargados.setHorizontalTextPosition(SwingConstants.LEFT);
//		GroupLayout groupLayout = new GroupLayout(frmSistemaDeGestin.getContentPane());
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chckbxOnlyEncargados, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblId)
											.addComponent(lblNombre))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblCantMaxResPen, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblLimiteHorasRes)
											.addComponent(lblDiasDeAnticipacion))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(spinnerMaxResPen, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
											.addComponent(spinnerLimiteHoras, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
											.addComponent(spinnerDiasAnt, Alignment.TRAILING))))
								.addContainerGap(419, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnLimpiarCampos, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblGestionDeTipos, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
								.addGap(358))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblListadoDeTipos)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnBuscarenlista, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPaneTablaTipos, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBotonquebusca, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(46)))
								.addGap(41))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnReiniciarListado, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblGestionDeTipos, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnLimpiarCampos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBorrar))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantMaxResPen, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerMaxResPen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLimiteHorasRes, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerLimiteHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiasDeAnticipacion, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinnerDiasAnt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxOnlyEncargados)
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblListadoDeTipos)
						.addComponent(btnBuscarenlista, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBotonquebusca)
						.addComponent(scrollPaneTablaTipos, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReiniciarListado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		
		
		tableTipos = new JTable();
		tableTipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTipos.getTableHeader().setResizingAllowed(false);
		tableTipos.getTableHeader().setReorderingAllowed(false);
		scrollPaneTablaTipos.setViewportView(tableTipos);
		tableTipos.setFont(new Font("Calibri", Font.PLAIN, 14));
		tableTipos.setBackground(Color.WHITE);

		getContentPane().setLayout(groupLayout);


		cargarListaTipos();	//Tabla									
		initDataBindings();


	}



	protected void guardarClick(){
		try {		
			if(validaCampos()){
		
				ctrlTde.add(this.mapearDeForm());
				actualizarLista();
				JOptionPane.showMessageDialog(frmSistemaDeGestion, "Tipo guardado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
				}
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestion, e.getMessage());
		} 
	}

	private boolean validaCampos() {
		
		
		return (Campo.Valida(txtId.getText(), Campo.tipo.ID) && 
		   Campo.Valida(txtNombre.getText(), Campo.tipo.OTRO) &&
		   Campo.Valida(((JSpinner.DefaultEditor)spinnerMaxResPen.getEditor()).getTextField().getText(), Campo.tipo.MAXRESPEN) &&
		   Campo.Valida(((JSpinner.DefaultEditor)spinnerDiasAnt.getEditor()).getTextField().getText(), Campo.tipo.DIASANT) &&
		   Campo.Valida(((JSpinner.DefaultEditor)spinnerLimiteHoras.getEditor()).getTextField().getText(), Campo.tipo.LIMHOR));

		
	}
	

	protected void buscarClick(){
		try {
			
			if(Campo.Valida(txtId.getText(), Campo.tipo.ID)){
				TipoDeElemento te=ctrlTde.getOne(this.mapearDeForm());
				if(te!=null){this.mapearAForm(te);}
				else{ JOptionPane.showMessageDialog(null, "Tipo de elemento inexistente","",JOptionPane.INFORMATION_MESSAGE);}
			}
			else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmSistemaDeGestion,e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected void modificarClick(){
		try {
			if(this.validaCampos()){
				ctrlTde.update(mapearDeForm());
				actualizarLista();
				JOptionPane.showMessageDialog(frmSistemaDeGestion, "Tipo de Elemento actualizado", "", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
			}
		} 
		catch (Exception e) {
			//limpiarTexto();
			JOptionPane.showMessageDialog(frmSistemaDeGestion, e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	protected void eliminarClick(){
		try {
			if(Campo.Valida(txtId.getText(), Campo.tipo.ID)){
				ctrlTde.delete(mapearDeForm());
				actualizarLista();
				JOptionPane.showMessageDialog(null, "Tipo eliminado", "", JOptionPane.INFORMATION_MESSAGE);
				this.limpiarTexto();
			}else{
				JOptionPane.showMessageDialog(null, Campo.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			limpiarTexto();
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private TipoDeElemento mapearDeForm(){
		TipoDeElemento tde=new TipoDeElemento();
		tde.setId(Integer.parseInt(txtId.getText()));
		tde.setNombre(this.txtNombre.getText());
		tde.setCant_max_res_pen((Integer)spinnerMaxResPen.getValue());
		tde.setDias_max_anticipacion((Integer)spinnerDiasAnt.getValue());
		tde.setLimite_horas_res((Integer)spinnerLimiteHoras.getValue());
		tde.setOnly_encargados(this.chckbxOnlyEncargados.isSelected());

		return tde;
		}
	
	private void mapearAForm(TipoDeElemento tde){
		
		this.txtId.setText(String.valueOf(tde.getId()));
		this.txtNombre.setText(tde.getNombre());
		this.spinnerMaxResPen.setValue(tde.getCant_max_res_pen());
		this.spinnerDiasAnt.setValue(tde.getDias_max_anticipacion());
		this.spinnerLimiteHoras.setValue(tde.getLimite_horas_res());
		this.chckbxOnlyEncargados.setSelected(tde.isOnly_encargados());
		
}
	
	private void limpiarTexto(){
		this.txtId.setText("");
		this.txtNombre.setText("");
		this.spinnerMaxResPen.setValue(10);
		this.spinnerDiasAnt.setValue(10);
		this.spinnerLimiteHoras.setValue(72);
		this.chckbxOnlyEncargados.setSelected(false);
	}
	
	
	
	protected ArrayList<TipoDeElemento> cargarListaTipos(){
		try {
			tdes= this.ctrlTde.getAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error al cargar tipos de elementos",JOptionPane.ERROR_MESSAGE);
		}
		return tdes;
	}
	
	
													///////////////////////////////////////////
	public void clickMostrarListado(){		//ESTE NO FUNCIONA. PERO ESTAR�A COPADO QUE SI LO HAGA JAJA. HAY 

		if(this.scrollPaneTablaTipos.isVisible()){
			this.scrollPaneTablaTipos.setVisible(false);
			this.btnBotonquebusca.setVisible(false);
			this.btnReiniciarListado.setVisible(false);
			}
		else{
			this.scrollPaneTablaTipos.setVisible(true);
			this.btnBotonquebusca.setVisible(true);
			this.btnReiniciarListado.setVisible(true);
		}
//		if(visibilidadTabla==1){
//			scrollPaneTablaPersona = new JScrollPane();	
//			scrollPaneTablaPersona.setVisible(true);
//			
//			visibilidadTabla=visibilidadTabla*-1;
//		}else{
//			scrollPaneTablaPersona.setVisible(false);
//			visibilidadTabla=visibilidadTabla*-1;
//		}
		
	}
	
	
	public void buscaTipo(){
		if(this.tableTipos.getSelectedRowCount()!=0){
			int indexTipo= tableTipos.convertRowIndexToModel(tableTipos.getSelectedRow());
			this.showTipo(this.tdes.get(indexTipo));}

	}
	
	
	public void showTipo(TipoDeElemento te){
		this.mapearAForm(te);
		
	}
	private void actualizarLista() {
		cargarListaTipos();										
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<TipoDeElemento, List<TipoDeElemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, tdes, tableTipos, "tablaTipos");
		//
		BeanProperty<TipoDeElemento, Integer> tipoDeElementoBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(tipoDeElementoBeanProperty).setColumnName("ID").setEditable(false);
		//
		BeanProperty<TipoDeElemento, String> tipoDeElementoBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(tipoDeElementoBeanProperty_1).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<TipoDeElemento, Integer> tipoDeElementoBeanProperty_2 = BeanProperty.create("cant_max_res_pen");
		jTableBinding.addColumnBinding(tipoDeElementoBeanProperty_2).setColumnName("Max Res Pen").setEditable(false);
		//
		BeanProperty<TipoDeElemento, Integer> tipoDeElementoBeanProperty_3 = BeanProperty.create("dias_max_anticipacion");
		jTableBinding.addColumnBinding(tipoDeElementoBeanProperty_3).setColumnName("Dias Max Ant").setEditable(false);
		//
		ObjectProperty<TipoDeElemento> tipoDeElementoObjectProperty = ObjectProperty.create();
		jTableBinding.addColumnBinding(tipoDeElementoObjectProperty).setColumnName("Limite Horas Res").setEditable(false);
		//
		BeanProperty<TipoDeElemento, Boolean> tipoDeElementoBeanProperty_4 = BeanProperty.create("only_encargados");
		jTableBinding.addColumnBinding(tipoDeElementoBeanProperty_4).setColumnName("Solo Encargados").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}