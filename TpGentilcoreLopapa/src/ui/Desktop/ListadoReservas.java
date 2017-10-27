package ui.Desktop;



import javax.swing.JOptionPane;
import javax.swing.JTable;


import business.entities.Elemento;
import business.entities.Reserva;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
import business.logic.CtrlPersonaLogic;
import business.logic.CtrlReservaLogic;
import business.logic.CtrlTipoDeElementoLogic;


import java.util.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.BeanProperty;


import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import tools.BotonLabel;
import tools.Campo;

import tools.LimitadorTxt;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JToolBar;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;


public class ListadoReservas extends Listado implements IListados{
	/**
	 * @wbp.nonvisual location=127,137
	 */
	private CtrlReservaLogic reservaLogic;
	private int totalReservas;
	private JTable table;
	private JTextField txtIndice;
	private JLabel lblIndice;
	private Reserva reservaActual;
	private ABMCReservaPrueba formReserva;
    public static enum TipoBusqueda{ POR_IDRESERVA("Por Id de la Reserva"),POR_IDELEMENTO("Por Id del elemento"),
    								POR_IDPERSONA("Por Id de la Persona"),PENDIENTES("Pendientes"),VENCIDAS("Vencidas"),TRAER_TODAS("Traer Todas");
    	private final String texto;
    	private TipoBusqueda(final String texto){this.texto=texto;}
    	@Override
    	public String toString(){return texto;}}
    private TipoBusqueda tipoBusquedaActual;
    public ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	//private int visibleVentanaReserva=1;			//mostrar ocultar ventana


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ListadoElementos frame = new ListadoElementos();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	private static ListadoReservas instancia;
	private JTextField txtBuscar;
	//private JComboBox cboTipoElemento;
	private JComboBox cboTipoBusqueda;
	private JDesktopPane desktopPane;
	
	public static ListadoReservas getInstancia()throws Exception{
		if(ListadoReservas.instancia==null){
			ListadoReservas.instancia=new ListadoReservas();
		}
		//ListadoReservas.instancia.Actualiza();
		return ListadoReservas.instancia;
	}
	
	private ListadoReservas() {
		setBorder(null);
		getContentPane().setBackground(Color.WHITE);
		
	    reservaActual=null;
	    tipoBusquedaActual=TipoBusqueda.TRAER_TODAS;
		reservaLogic=new CtrlReservaLogic();
		setBounds(100, 100, 556, 444);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				mapearHaciaABMCClick();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		scrollPane.setViewportView(table);
		
		JButton btnAnterior = new JButton("",new ImageIcon(ListadoReservas.class.getResource("/ui/Desktop/flechaizquierda.png")));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				buscarXIndiceClick(txtIndice.getText(),Indice.ANTERIOR);
			}
		});
		
		txtIndice = new JTextField();
		txtIndice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarXIndiceClick(txtIndice.getText(),Indice.ESTE);
			}
		});
		
		txtIndice.setColumns(10);
		txtIndice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		lblIndice = new JLabel("de xxx");
		getContentPane().setLayout(new MigLayout("", "[4%][25%][grow][][][50px:50px:50px,center][14.00][48.00][159.00][2.88%][20%,grow]", "[25px:25px:25px][][20px:20px:20px,grow][45px:45px:45px][20px:20px:20px][30px:30px:30px][85%,grow][5%,baseline]"));
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				buscarClick();
			}
		});
		
		JPanel panelBarraAzulLateral = new JPanel();
		panelBarraAzulLateral.setBackground(new Color(0, 51, 102));
		getContentPane().add(panelBarraAzulLateral, "cell 0 1 1 6,grow");
		
		JLabel lblIconoListadoRes = new JLabel("");
		lblIconoListadoRes.setIcon(new ImageIcon(ListadoReservas.class.getResource("/ui/Desktop/ic_devices_white_24dp_2x.png")));

		//		lblUsuario.setHorizontalAlignment(JLabel.CENTER);
//		lblUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		panelBarraAzulLateral.setLayout(new MigLayout("", "[64px]", "[48px][24px]"));
		panelBarraAzulLateral.add(lblIconoListadoRes, "cell 0 0,alignx center,aligny top");
		
		JPanel panelBarraAzulSup = new JPanel();
		panelBarraAzulSup.setBorder(null);
		panelBarraAzulSup.setBackground(new Color(0,51,102));
		getContentPane().add(panelBarraAzulSup, "cell 0 0 11 2,grow");
		JLabel lblUsuario = new JLabel(Ingreso.PersonaLogueada.getCategoria()+": "+Ingreso.PersonaLogueada.getApellido()+","+Ingreso.PersonaLogueada.getNombre());
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setIcon(new ImageIcon(ListadoReservas.class.getResource("/ui/Desktop/ic_person_pin_white_24dp_1x.png")));
		GroupLayout gl_panelBarraAzulSup = new GroupLayout(panelBarraAzulSup);
		gl_panelBarraAzulSup.setHorizontalGroup(
			gl_panelBarraAzulSup.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBarraAzulSup.createSequentialGroup()
					.addContainerGap(343, Short.MAX_VALUE)
					.addComponent(lblUsuario)
					.addContainerGap())
		);
		gl_panelBarraAzulSup.setVerticalGroup(
			gl_panelBarraAzulSup.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBarraAzulSup.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblUsuario))
		);
		panelBarraAzulSup.setLayout(gl_panelBarraAzulSup);
		

		getContentPane().add(txtBuscar, "cell 1 2 8 1,alignx left,aligny top");
		txtBuscar.setColumns(30);
		//LimitadorTxt.MaxCaracteres(LimitadorTxt.Campo.ELENOM, txtBuscar);
		
		
		JButton btnBuscar = new JButton("Buscar",null);
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarClick();
			}
		});
		getContentPane().add(btnBuscar, "cell 1 3 3 1,alignx left,aligny top");
		
		cboTipoBusqueda = new JComboBox();
		cboTipoBusqueda.setFont(new Font("Calibri", Font.PLAIN, 12));
		getContentPane().add(cboTipoBusqueda, "cell 1 3 3 1,alignx left,aligny top");
		cboTipoBusqueda.addItem(TipoBusqueda.POR_IDRESERVA);
		cboTipoBusqueda.addItem(TipoBusqueda.POR_IDELEMENTO);
		cboTipoBusqueda.addItem(TipoBusqueda.POR_IDPERSONA);
		cboTipoBusqueda.addItem(TipoBusqueda.PENDIENTES);
		cboTipoBusqueda.addItem(TipoBusqueda.VENCIDAS);
		cboTipoBusqueda.addItem(TipoBusqueda.TRAER_TODAS);
		
//		cboTipoElemento=new JComboBox();
//		this.cboTipoElemento.setSelectedIndex(-1);
//		getContentPane().add(cboTipoElemento,"cell 1 5 3 1");
//		JLabel lblTipo = new JLabel("Tipo de Elemento");
//		
//
//		getContentPane().add(lblTipo, "cell 1 4 3 1,alignx left,aligny center");
		
		desktopPane = new JDesktopPane();
		desktopPane.setIgnoreRepaint(true);
		desktopPane.setForeground(Color.WHITE);
		desktopPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		abrirVentanaReserva();
		
//		JToolBar toolBar = new JToolBar();
//		toolBar.setFloatable(false);
//		getContentPane().add(toolBar, "cell 6 5 4 1,alignx right,aligny center");
		
		
//		BotonLabel btnReservar=new BotonLabel("reservar.png","reservarFocus.png","reservarApretado.png");
//		btnReservar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				abrirVentanaReserva();
//			}
//		});
//		btnReservar.setToolTipText("Reservar/Sacar Reserva");
//		BotonLabel btnAgregar=new BotonLabel("Agregar.png","AgregarFocus.png","AgregarApretado.png");
//		btnAgregar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				abrirVentanaReserva();
//			}
//		});
//		btnAgregar.setToolTipText("Agregar");
//		BotonLabel btnEditar=new BotonLabel("Editar.png","EditarFocus.png","EditarApretado.png");
//		btnEditar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				abrirVentanaReserva();
//			}
//		});
//		btnEditar.setToolTipText("Editar");
//		BotonLabel btnBorrar=new BotonLabel("Borrar.png","BorrarFocus.png","BorrarApretado.png");
//		btnBorrar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				abrirVentanaReserva();
//			}
//		});
//		btnBorrar.setToolTipText("Eliminar");
//
//		
//	//	toolBar.add(btnReservar);
//		toolBar.add(btnAgregar);
//		toolBar.add(btnEditar);
//		toolBar.add(btnBorrar);
		getContentPane().add(desktopPane, "cell 9 6 2 1,grow");
		
//		JRadioButton rdbtnId = new JRadioButton("Por Id");
//		getContentPane().add(rdbtnId, "flowx,cell 1 1,alignx left,aligny center");
//		rdbtnId.setSelected(true);
//		
//		JRadioButton rdbtnNombre = new JRadioButton("Por Nombre");
//		getContentPane().add(rdbtnNombre, "cell 1 1,alignx left,aligny center");
//		
//		JRadioButton rdbtnTipo = new JRadioButton("Por Tipo de Elemento");
//		getContentPane().add(rdbtnTipo, "cell 1 1 4 1,alignx left,aligny center");
//		
//		
//		ButtonGroup bgIdTipo=new ButtonGroup();
//		bgIdTipo.add(rdbtnId);
//		bgIdTipo.add(rdbtnTipo);
//		
//		ButtonGroup bgIdNombre=new ButtonGroup();
//		bgIdNombre.add(rdbtnId);
//		bgIdNombre.add(rdbtnNombre);
//		
//	    bgIdTipo.clearSelection();
		

		
		
		getContentPane().add(txtIndice, "cell 5 7,alignx right,aligny center");
		getContentPane().add(lblIndice, "cell 7 7,alignx left,aligny center");
		getContentPane().add(btnAnterior, "cell 3 7,alignx right,aligny center");
		getContentPane().add(scrollPane, "cell 1 6 8 1,grow");
		
		this.indiceActual=1;
		txtIndice.setText(String.valueOf(indiceActual));
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarXIndiceClick(txtIndice.getText(), Indice.POSTERIOR);
			}
		});
		btnSiguiente.setIcon(new ImageIcon(ListadoReservas.class.getResource("/ui/Desktop/flechaderecha.png")));
		getContentPane().add(btnSiguiente, "cell 8 7,alignx left,aligny center");
		
		
		this.Actualiza();
		setPermisos();
		
	}

	protected void abrirVentanaReserva() {
	
	//	if(visibleVentanaReserva==1){									//las validaciones y multiplicaciones por -1 es para mostrar y ocultar con el mismo boton
	//		visibleVentanaReserva=visibleVentanaReserva*(-1);
	//	visibleVentanaReserva=-1;
			try {
				formReserva=ABMCReservaPrueba.getInstancia();
				desktopPane.removeAll();
				desktopPane.add(formReserva);
				formReserva.setVisible(true);
				formReserva.setMaximum(true);
			}catch (PropertyVetoException e) {
				JOptionPane.showMessageDialog(null, "Error al intentar ingresar la ventana interna de Reserva\n"+e.getMessage());
			}
			catch(SQLException sqlex){
				JOptionPane.showMessageDialog(null, "Error al abrir ventana para reservar\n"+sqlex.getMessage(),
											"Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
	//	}else{
	//		visibleVentanaReserva=visibleVentanaReserva*(-1);
	//		formReserva.setVisible(false);
	//		abrirVentanaElemento(ABMC.Action.OTHER);

	//	}
		
	}
//
//	private void abrirVentanaElemento(ABMC.Action accion) {
//		try {
////			if(formElemento==null){
//			
//			this.mapearHaciaABMCClick();
//			formElemento=ABMCElementoPrueba.getInstancia(accion);
//			
////			}
//			desktopPane.removeAll();
//			//esktopPane.remove(formElemento);
//			desktopPane.add(formElemento);
//			formElemento.setVisible(true);
//			formElemento.setMaximum(true);
//			
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error al tratar de insertar la ventana interna de elementos\n"+e.getMessage(),
//					"Error",JOptionPane.ERROR_MESSAGE);
//		}
//	}
	protected void mapearHaciaABMCClick() {
		if(table.getSelectedRowCount()!=0){
		int indiceReserva=this.table.convertRowIndexToModel(table.getSelectedRow());
		try {
			this.formReserva.mapearAForm(this.reservaLogic.reservas.get((indiceReserva)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		}
		
	}

	public void buscarClick() {
		
		
		
		try{
	
			this.mapearDeForm();
			indiceActual=1;
			this.Actualiza();
		
			}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error al buscar\n"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	//crear interface para que implemente esto y mas
	public void buscarXIndiceClick(String indiceCampo,Indice tipoIndice) {
		if(Campo.Valida(indiceCampo, Campo.tipo.INDICE)){
			//this.Actualiza();
			int indiceNumero=Integer.parseInt(indiceCampo);
			if(indiceNumero<=cantidadIndices){	
				indiceActual=indiceNumero;
				if(tipoIndice==Indice.ANTERIOR && indiceActual>1){
					--indiceActual;
					txtIndice.setText(String.valueOf(indiceActual));

				}
				else if(tipoIndice==Indice.POSTERIOR && indiceActual<cantidadIndices){
									
					++indiceActual;
					txtIndice.setText(String.valueOf(indiceActual));
				}
				
				
				try {
					//this.elementos=elementoLogic.getSome(elementoActual,(indiceActual-1)*FilasTabla,FilasTabla);
					this.Actualiza();
					//initDataBindings();
					
				} 
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al buscar por indice\n"+e.getMessage(),
							"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "indice demasiado grande");
				txtIndice.setText(String.valueOf(indiceActual));
			}
		}
		else{
			txtIndice.setText(String.valueOf(indiceActual));
			
		}
	}
	
	public void Actualiza(){
		try {
			//loadLists();
			this.totalReservas=reservaLogic.getCantidad(Ingreso.PersonaLogueada,tipoBusquedaActual,reservaActual);
			cantidadIndices=(int)Math.ceil((double)totalReservas/FilasTabla);
			if(cantidadIndices==0){cantidadIndices=1;}
			if(indiceActual>cantidadIndices){
				indiceActual=cantidadIndices;}
			this.txtIndice.setText(String.valueOf(indiceActual));
			this.reservaLogic.reservas=reservaLogic.getSome(Ingreso.PersonaLogueada,tipoBusquedaActual,reservaActual,(indiceActual-1)*FilasTabla,FilasTabla);//esto cambiarlo
		    this.lblIndice.setText("de "+String.valueOf(cantidadIndices));
		    initDataBindings();
		    if(!this.reservaLogic.reservas.isEmpty()){
		    	table.setRowSelectionInterval(0,0);
		    	int indiceReserva=this.table.convertRowIndexToModel(table.getSelectedRow());
				this.formReserva.mapearAForm(this.reservaLogic.reservas.get((indiceReserva)));
		    }
		    else{
		    	this.formReserva.mapearAForm(null);
		    }
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al actualizar datos\n"+ex.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
//	public void initDataBindings() {
//		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, this.reservaLogic.elementos, table);
//		//
//		BeanProperty<Elemento, Integer> elementoBeanProperty = BeanProperty.create("id_elemento");
//		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("ID Elemento");
//		//
//		BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("nombre");
//		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Nombre");
//		//
//		BeanProperty<Elemento, String> elementoBeanProperty_2 = BeanProperty.create("tipo.nombre");
//		jTableBinding.addColumnBinding(elementoBeanProperty_2).setColumnName("Tipo de elemento");
//		//
//		jTableBinding.setEditable(false);
//		
//		
//	
//		jTableBinding.bind();
//		
//	}
	
//	private void loadLists(){
////	 try {
////		int indice=cboTipoElemento.getSelectedIndex(); 
////		this.cboTipoElemento.setModel(new DefaultComboBoxModel(new CtrlTipoDeElementoLogic().getAll().toArray()));
////	    this.cboTipoElemento.setSelectedIndex(indice);
////	 } catch (Exception e) {
////		JOptionPane.showMessageDialog(null, "Error al recuperar lista de tipos de elementos\n"+e.getMessage(),
////				"Error",JOptionPane.ERROR_MESSAGE);
////	}
//	}
	
	private void mapearDeForm()throws Exception{
		reservaActual=new Reserva();
		reservaActual.setPersona(Ingreso.PersonaLogueada);
		switch((TipoBusqueda)this.cboTipoBusqueda.getSelectedItem()){
		case POR_IDRESERVA:
						  if(Campo.Valida(txtBuscar.getText(), Campo.tipo.ID)){
				          reservaActual.setId_reserva(Integer.parseInt(this.txtBuscar.getText()));
				          this.tipoBusquedaActual=TipoBusqueda.POR_IDRESERVA;}
						  else{
							  JOptionPane.showMessageDialog(null, Campo.Mensaje,"",JOptionPane.INFORMATION_MESSAGE);
						  }
				          break;
		case POR_IDELEMENTO:
						  if(Campo.Valida(txtBuscar.getText(), Campo.tipo.ID)){
				          reservaActual.setElemento(new CtrlElementoLogic().getOne(Integer.parseInt(txtBuscar.getText())));
				          this.tipoBusquedaActual=TipoBusqueda.POR_IDELEMENTO;}
						  else{
							  JOptionPane.showMessageDialog(null, Campo.Mensaje,"",JOptionPane.INFORMATION_MESSAGE);
						  }
						  break;
		case POR_IDPERSONA:
						  if(Campo.Valida(txtBuscar.getText(), Campo.tipo.ID)){
						  reservaActual.setPersona(new CtrlPersonaLogic().getOne(Integer.parseInt(txtBuscar.getText())));
			        	  this.tipoBusquedaActual=TipoBusqueda.POR_IDPERSONA;}
						  else{
							  JOptionPane.showMessageDialog(null, Campo.Mensaje,"",JOptionPane.INFORMATION_MESSAGE);
						  }
						  break;
		case PENDIENTES:
						  this.tipoBusquedaActual=TipoBusqueda.PENDIENTES;
						  break;
		case VENCIDAS:
				    	  this.tipoBusquedaActual=TipoBusqueda.VENCIDAS;
				    	  break;
		case TRAER_TODAS:
		default:reservaActual=null;
				this.tipoBusquedaActual=TipoBusqueda.TRAER_TODAS;
				break;		
		}
		
	} 
	public void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, this.reservaLogic.reservas, table);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty = BeanProperty.create("id_reserva");
		jTableBinding.addColumnBinding(reservaBeanProperty).setColumnName("Id Reserva").setEditable(false);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty_1 = BeanProperty.create("persona.id");
		jTableBinding.addColumnBinding(reservaBeanProperty_1).setColumnName("Id Persona").setEditable(false);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty_2 = BeanProperty.create("elemento.id_elemento");
		jTableBinding.addColumnBinding(reservaBeanProperty_2).setColumnName("Id Elemento");
		
		//
		BeanProperty<Reserva, String> reservaBeanProperty_3 = BeanProperty.create("fecha_hora_reserva_hecha");
		jTableBinding.addColumnBinding(reservaBeanProperty_3).setColumnName("Fecha Reserva Hecha").setEditable(false);
		
		//
		BeanProperty<Reserva, String> reservaBeanProperty_4 = BeanProperty.create("fecha_hora_desde_solicitada");
		jTableBinding.addColumnBinding(reservaBeanProperty_4).setColumnName("Fecha Desde");
		//
		BeanProperty<Reserva, String> reservaBeanProperty_5 = BeanProperty.create("fecha_hora_hasta_solicitada");
		jTableBinding.addColumnBinding(reservaBeanProperty_5).setColumnName("Fecha Hasta");
		//
		BeanProperty<Reserva, String> reservaBeanProperty_6 = BeanProperty.create("fecha_hora_entregado");
		jTableBinding.addColumnBinding(reservaBeanProperty_6).setColumnName("Fecha Entrega");
		//
//		BeanProperty<Reserva, String> reservaBeanProperty_7 = BeanProperty.create("detalle");
//		jTableBinding.addColumnBinding(reservaBeanProperty_7).setColumnName("Detalle");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
		
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setMinWidth(150);;
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(5).setMinWidth(150);
		table.getColumnModel().getColumn(6).setMinWidth(150);
	
	}
	
	public void setPermisos(){
		try{
		ABMCReservaPrueba.getInstancia().setPermisos();}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error al setear permisos de usuario\n"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		switch(Ingreso.PersonaLogueada.getCategoria().getDescripcion()){
		
		
		case "Administrador":break;
		case "Usuario":
		case "Encargado":
		default:
			cboTipoBusqueda.removeItem(TipoBusqueda.POR_IDPERSONA);
			
		break;
		
		}
	
	}
}