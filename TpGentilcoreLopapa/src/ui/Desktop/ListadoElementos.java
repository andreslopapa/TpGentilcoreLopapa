package ui.Desktop;



import javax.swing.JOptionPane;
import javax.swing.JTable;


import business.entities.Elemento;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
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
import ui.Desktop.ABMC.Action;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JToolBar;
import java.beans.PropertyVetoException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class ListadoElementos extends Listado implements IListados{
	/**
	 * @wbp.nonvisual location=127,137
	 */
	private CtrlElementoLogic elementoLogic;
	private int totalElementos;
	private JTable table;
	private JTextField txtIndice;
	private JLabel lblIndice;
	private Elemento elementoActual;
	private ABMCElementoPrueba formElemento;
	private AltasReserva formReserva;
    public static enum TipoBusqueda{ POR_ID("Por Id"),POR_NOMBRE("Por Nombre"),
    					     POR_TIPO("Por Tipo"),POR_NOMBRE_Y_TIPO("Por Nombre y Tipo"),
    					     TRAER_TODOS("Traer Todos");
    	private final String texto;
    	private TipoBusqueda(final String texto){this.texto=texto;}
    	@Override
    	public String toString(){return texto;}}
    private TipoBusqueda tipoBusquedaActual;
    
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
	
	private static ListadoElementos instancia;
	private JTextField txtBuscar;
	private JComboBox cboTipoElemento;
	private JComboBox cboTipoBusqueda;
	private JDesktopPane desktopPane;
	
	public static ListadoElementos getInstancia()throws Exception{
		if(ListadoElementos.instancia==null){
			ListadoElementos.instancia=new ListadoElementos();
		}
		return ListadoElementos.instancia;
	}
	
	public ListadoElementos() {
		setBorder(null);
		getContentPane().setBackground(Color.WHITE);
		
	    elementoActual=null;
	    tipoBusquedaActual=TipoBusqueda.TRAER_TODOS;
		elementoLogic=new CtrlElementoLogic();
		setBounds(100, 100, 556, 444);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(formElemento.getAccion()==Action.OTHER){
				mapearHaciaABMCElementoClick();}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		scrollPane.setViewportView(table);
		
		JButton btnAnterior = new JButton("",new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/flechaizquierda.png")));
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
		getContentPane().setLayout(new MigLayout("", "[7.91%,grow][25%][grow][][][50px:50px:50px,center][14.00][48.00][159.00][2.88%][20%,grow]", "[25px:25px:25px][][20px:30.00px:20px,grow][45px:45px:45px][20px:20px:20px][30px:30px:30px][85%,grow][5%,baseline]"));
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				buscarClick();
			}
		});
		
		JPanel panelBarraAzulLateral = new JPanel();
		panelBarraAzulLateral.setBackground(new Color(0, 51, 102));
		getContentPane().add(panelBarraAzulLateral, "cell 0 0 1 7,alignx leading,growy");
		
		JLabel lblIconoListadoEles = new JLabel("");
		lblIconoListadoEles.setIcon(new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/ic_devices_white_24dp_2x.png")));

		//		lblUsuario.setHorizontalAlignment(JLabel.CENTER);
//		lblUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
		panelBarraAzulLateral.setLayout(new MigLayout("", "[64px]", "[48px][24px]"));
		panelBarraAzulLateral.add(lblIconoListadoEles, "cell 0 0,alignx center,aligny top");
		JLabel lblUsuario = new JLabel(Ingreso.PersonaLogueada.getCategoria()+": "+Ingreso.PersonaLogueada.getApellido()+","+Ingreso.PersonaLogueada.getNombre());
		getContentPane().add(lblUsuario, "cell 8 0");
		lblUsuario.setForeground(new Color(0, 51, 102));
		lblUsuario.setIcon(new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/ic_person_white_24dp_2x.png")));
		

		getContentPane().add(txtBuscar, "flowx,cell 1 2 7 1,alignx left,aligny bottom");
		txtBuscar.setColumns(30);
		LimitadorTxt.MaxCaracteres(LimitadorTxt.Campo.ELENOM, txtBuscar);
		
		//ImageIcon buscarIcon=new ImageIcon(ListadoElementos.class.getResource("buscar.png"));
		JButton btnBuscar = new JButton("Buscar",null);
		btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarClick();
			}
		});
		getContentPane().add(btnBuscar, "cell 1 3 3 1,alignx left,aligny center");
		
		cboTipoBusqueda = new JComboBox();
		cboTipoBusqueda.setFont(new Font("Calibri", Font.PLAIN, 12));
		getContentPane().add(cboTipoBusqueda, "cell 1 3 3 1,alignx left,aligny center");
		cboTipoBusqueda.addItem(TipoBusqueda.POR_ID);
		cboTipoBusqueda.addItem(TipoBusqueda.POR_NOMBRE);
		cboTipoBusqueda.addItem(TipoBusqueda.POR_TIPO);
		cboTipoBusqueda.addItem(TipoBusqueda.POR_NOMBRE_Y_TIPO);
		cboTipoBusqueda.addItem(TipoBusqueda.TRAER_TODOS);
		
		cboTipoElemento=new JComboBox();
		this.cboTipoElemento.setSelectedIndex(-1);
		getContentPane().add(cboTipoElemento,"cell 1 5 3 1");
		JLabel lblTipo = new JLabel("Tipo de Elemento");
		

		getContentPane().add(lblTipo, "cell 1 4 3 1,alignx left,aligny center");
		
		desktopPane = new JDesktopPane();
		desktopPane.setIgnoreRepaint(true);
		desktopPane.setForeground(Color.WHITE);
		desktopPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		abrirVentanaElemento(ABMC.Action.OTHER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, "cell 6 5 4 1,alignx right,aligny center");
		
		
		BotonLabel btnReservar=new BotonLabel("reservar.png","reservarFocus.png","reservarApretado.png");
		btnReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				abrirVentanaReserva();
			}
		});
		btnReservar.setToolTipText("Reservar/Sacar Reserva");
		BotonLabel btnAgregar=new BotonLabel("Agregar.png","AgregarFocus.png","AgregarApretado.png");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaElemento(ABMC.Action.ADD);
			}
		});
		btnAgregar.setToolTipText("Agregar");
		BotonLabel btnEditar=new BotonLabel("Editar.png","EditarFocus.png","EditarApretado.png");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaElemento(Action.UPDATE);
			}
		});
		btnEditar.setToolTipText("Editar");
		BotonLabel btnBorrar=new BotonLabel("Borrar.png","BorrarFocus.png","BorrarApretado.png");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaElemento(Action.DELETE);
			}
		});
		btnBorrar.setToolTipText("Eliminar");

		
		toolBar.add(btnReservar);
		toolBar.add(btnAgregar);
		toolBar.add(btnEditar);
		toolBar.add(btnBorrar);
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
		btnSiguiente.setIcon(new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/flechaderecha.png")));
		getContentPane().add(btnSiguiente, "cell 8 7,alignx left,aligny center");
		
		
		this.Actualiza();

		
	}

	protected void abrirVentanaReserva() {
	
	//	if(visibleVentanaReserva==1){									//las validaciones y multiplicaciones por -1 es para mostrar y ocultar con el mismo boton
	//		visibleVentanaReserva=visibleVentanaReserva*(-1);
	//	visibleVentanaReserva=-1;
			try {
				formReserva=new AltasReserva();
				this.mapearHaciaAltasReservaClick();
				desktopPane.removeAll();
				desktopPane.add(formReserva);
				formReserva.setVisible(true);
				formReserva.setMaximum(true);
			}catch (PropertyVetoException e) {
				JOptionPane.showMessageDialog(null, "Error al intentar ingresar la ventana interna de Reserva\n"+e.getMessage());
			}
	//	}else{
	//		visibleVentanaReserva=visibleVentanaReserva*(-1);
	//		formReserva.setVisible(false);
	//		abrirVentanaElemento(ABMC.Action.OTHER);

	//	}
		
	}

	public void abrirVentanaElemento(ABMC.Action accion) {
		try {
//			if(formElemento==null){
			
			this.mapearHaciaABMCElementoClick();
			formElemento=ABMCElementoPrueba.getInstancia(accion);
			
//			}
			desktopPane.removeAll();
			//esktopPane.remove(formElemento);
			desktopPane.add(formElemento);
			formElemento.setVisible(true);
			formElemento.setMaximum(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al tratar de insertar la ventana interna de elementos\n"+e.getMessage(),
					"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected void mapearHaciaAltasReservaClick(){
		if(table.getSelectedRowCount()!=0){
			int indiceElemento=this.table.convertRowIndexToModel(table.getSelectedRow());
			this.formReserva.mapearAForm(this.elementoLogic.elementos.get((indiceElemento)).getId_elemento());
			}
	}
	protected void mapearHaciaABMCElementoClick() {
		if(table.getSelectedRowCount()!=0){
		int indiceElemento=this.table.convertRowIndexToModel(table.getSelectedRow());
		this.formElemento.mapearAForm(this.elementoLogic.elementos.get((indiceElemento)));
		}
		
	}

	public void buscarClick() {
		
		
		
		try{
		//this.elementos=this.elementoLogic.getSome(elementoActual, 0, FilasTabla);
			this.mapearDeForm();
			indiceActual=1;
			this.Actualiza();
			//initDataBindings();
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
			loadLists();
			this.totalElementos=elementoLogic.getCantidad(tipoBusquedaActual,elementoActual);
			cantidadIndices=(int)Math.ceil((double)totalElementos/FilasTabla);
			if(cantidadIndices==0){cantidadIndices=1;}
			if(indiceActual>cantidadIndices){
				indiceActual=cantidadIndices;}
			this.txtIndice.setText(String.valueOf(indiceActual));
			this.elementoLogic.elementos=elementoLogic.getSome(tipoBusquedaActual,elementoActual,(indiceActual-1)*FilasTabla,FilasTabla);//esto cambiarlo
		    this.lblIndice.setText("de "+String.valueOf(cantidadIndices));
		    initDataBindings();
		    if(!this.elementoLogic.elementos.isEmpty()){
		    	table.setRowSelectionInterval(0,0);
		    	int indiceElemento=this.table.convertRowIndexToModel(table.getSelectedRow());
				this.formElemento.mapearAForm(this.elementoLogic.elementos.get((indiceElemento)));
		    	
		    }
		    else{
		    	this.formElemento.mapearAForm(null);
		    }
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al actualizar datos\n"+ex.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, this.elementoLogic.elementos, table);
		//
		BeanProperty<Elemento, Integer> elementoBeanProperty = BeanProperty.create("id_elemento");
		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("ID Elemento");
		//
		BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Nombre");
		//
		BeanProperty<Elemento, String> elementoBeanProperty_2 = BeanProperty.create("tipo.nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty_2).setColumnName("Tipo de elemento");
		//
		jTableBinding.setEditable(false);
		
		
	
		jTableBinding.bind();
		
	}
	
	private void loadLists(){
	 try {
		int indice=cboTipoElemento.getSelectedIndex(); 
		this.cboTipoElemento.setModel(new DefaultComboBoxModel(new CtrlTipoDeElementoLogic().getAll().toArray()));
	    this.cboTipoElemento.setSelectedIndex(indice);
	 } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error al recuperar lista de tipos de elementos\n"+e.getMessage(),
				"Error",JOptionPane.ERROR_MESSAGE);
	}
	}
	
	private void mapearDeForm(){
		elementoActual=new Elemento();
		switch((TipoBusqueda)this.cboTipoBusqueda.getSelectedItem()){
		case POR_ID:if(Campo.Valida(txtBuscar.getText(), Campo.tipo.ID)){
			          elementoActual.setId_elemento(Integer.parseInt(this.txtBuscar.getText()));
			          this.tipoBusquedaActual=TipoBusqueda.POR_ID;}
			          break;
		case POR_NOMBRE:
			          elementoActual.setNombre(txtBuscar.getText());
			          this.tipoBusquedaActual=TipoBusqueda.POR_NOMBRE;
					  break;
		case POR_TIPO:
			          if(cboTipoElemento.getSelectedIndex()!=(-1)){
			        	  elementoActual.setTipo((TipoDeElemento)cboTipoElemento.getSelectedItem());
			        	  this.tipoBusquedaActual=TipoBusqueda.POR_TIPO;}
			          else{JOptionPane.showMessageDialog(null, "Seleccione un tipo");}
					  break;
		case POR_NOMBRE_Y_TIPO:
				      if(cboTipoElemento.getSelectedIndex()!=(-1)){
				    	  elementoActual.setNombre(txtBuscar.getText());
				    	  elementoActual.setTipo((TipoDeElemento)cboTipoElemento.getSelectedItem());
				    	  this.tipoBusquedaActual=TipoBusqueda.POR_NOMBRE_Y_TIPO;}
				      else{JOptionPane.showMessageDialog(null, "Seleccione un tipo");}
				      break;
		case TRAER_TODOS:
		default:elementoActual=null;
				this.tipoBusquedaActual=TipoBusqueda.TRAER_TODOS;
				break;
		
		
		
		
		}
		
	} 
}
