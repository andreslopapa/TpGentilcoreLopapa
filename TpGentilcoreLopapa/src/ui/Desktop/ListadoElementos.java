package ui.Desktop;



import javax.swing.JOptionPane;
import javax.swing.JTable;


import business.entities.Elemento;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
import business.logic.CtrlTipoDeElementoLogic;
import data.DataTipoDeElemento;

import java.util.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.BeanProperty;


import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import tools.Campo;
import tools.LimitadorTxt;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class ListadoElementos extends Listado implements IListados{
	/**
	 * @wbp.nonvisual location=127,137
	 */
	private CtrlElementoLogic elementoLogic;
	private ArrayList<Elemento> elementos=null;
	private int totalElementos;
	private JTable table;
	private JTextField txtIndice;
	private JLabel lblIndice;
	private Elemento elementoActual;
	//hacr una clase listado de la que hereden 

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
	
	public static ListadoElementos getInstancia()throws Exception{
		if(instancia==null){
			ListadoElementos.instancia=new ListadoElementos();
		}
		return instancia;
	}
	
	public ListadoElementos() {
		
	    elementoActual=null;
		elementoLogic=new CtrlElementoLogic();
		setBounds(100, 100, 528, 444);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false) ;
		scrollPane.setViewportView(table);
		
		JButton btnAnterior = new JButton("",new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/flechaizquierda.png")));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				buscarXIndiceClick(txtIndice.getText(),Indice.ANTERIOR);
			}
		});
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarXIndiceClick(txtIndice.getText(), Indice.POSTERIOR);
			}
		});
		btnSiguiente.setIcon(new ImageIcon(ListadoElementos.class.getResource("/ui/Desktop/flechaderecha.png")));
		
		txtIndice = new JTextField();
		txtIndice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarXIndiceClick(txtIndice.getText(),Indice.ESTE);
			}
		});
		
		txtIndice.setColumns(10);
		txtIndice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		lblIndice = new JLabel("de xxx");
		getContentPane().setLayout(new MigLayout("", "[25%,grow][25%][][][50px:50px:50px,center][][][][25%][25%]", "[20px:20px:20px][45px:45px:45px][20px:20px:20px][30px:30px:30px][85%][5%,baseline]"));
		
		txtBuscar = new JTextField();
		getContentPane().add(txtBuscar, "cell 1 0 6 1,alignx left,aligny bottom");
		txtBuscar.setColumns(30);
		LimitadorTxt.MaxCaracteres(45, txtBuscar);
		
		ImageIcon buscarIcon=new ImageIcon(ListadoElementos.class.getResource("buscar.png"));
		JButton btnBuscar = new JButton("Buscar",buscarIcon);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarClick();
			}
		});
		getContentPane().add(btnBuscar, "cell 1 1 2 1,alignx left,aligny top");
		
		cboTipoBusqueda = new JComboBox();
		getContentPane().add(cboTipoBusqueda, "cell 1 1,alignx left,aligny top");
		cboTipoBusqueda.addItem("Por Id");
		cboTipoBusqueda.addItem("Por Nombre");
		cboTipoBusqueda.addItem("Por Tipo");
		cboTipoBusqueda.addItem("Por Nombre y Tipo");
		cboTipoBusqueda.addItem("Traer Todos");
		
		cboTipoElemento=new JComboBox();
		this.cboTipoElemento.setSelectedIndex(-1);
		getContentPane().add(cboTipoElemento,"cell 1 3 2 1");
		JLabel lblTipo = new JLabel("Tipo de Elemento");
		getContentPane().add(lblTipo, "cell 1 2 2 1,alignx left,aligny center");
		
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
		

		
		
		getContentPane().add(txtIndice, "cell 4 5,alignx right,aligny center");
		getContentPane().add(lblIndice, "cell 6 5,alignx left,aligny center");
		getContentPane().add(btnAnterior, "cell 1 5,alignx right,aligny center");
		getContentPane().add(btnSiguiente, "cell 8 5,alignx left,aligny center");
		getContentPane().add(scrollPane, "cell 1 4 8 1,grow");
		
		this.indiceActual=1;
		txtIndice.setText(String.valueOf(indiceActual));
		
		
		this.Actualiza();
		initDataBindings();
		
	}
	protected void buscarClick() {
		
		
		this.mapearDeForm();
		try{
		//this.elementos=this.elementoLogic.getSome(elementoActual, 0, FilasTabla);
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
			this.totalElementos=elementoLogic.getCantidad(elementoActual);
			cantidadIndices=(int)Math.ceil((double)totalElementos/FilasTabla);
			if(cantidadIndices==0){cantidadIndices=1;}
			if(indiceActual>cantidadIndices){indiceActual=cantidadIndices;}
			this.elementos=elementoLogic.getSome(elementoActual,(indiceActual-1)*FilasTabla,FilasTabla);//esto cambiarlo
		    this.lblIndice.setText("de "+String.valueOf(cantidadIndices));
		    initDataBindings();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al actualizar datos\n"+ex.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, elementos, table);
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
		switch(this.cboTipoBusqueda.getSelectedItem().toString()){
		case "Por Id":if(Campo.Valida(txtBuscar.getText(), Campo.tipo.ID)){
			          elementoActual.setId_elemento(Integer.parseInt(this.txtBuscar.getText()));}
			          break;
		case "Por Nombre":
			          elementoActual.setNombre(txtBuscar.getText());
					  break;
		case "Por Tipo":
			          if(cboTipoElemento.getSelectedIndex()!=(-1)){
			        	  elementoActual.setTipo((TipoDeElemento)cboTipoElemento.getSelectedItem());}
			          else{JOptionPane.showMessageDialog(null, "Seleccione un tipo");}
					  break;
		case "Por Nombre y Tipo":
				      if(cboTipoElemento.getSelectedIndex()!=(-1)){
				    	  elementoActual.setNombre(txtBuscar.getText());
				    	  elementoActual.setTipo((TipoDeElemento)cboTipoElemento.getSelectedItem());}
				      else{JOptionPane.showMessageDialog(null, "Seleccione un tipo");}
				      break;
		case "Traer Todos":
		default:elementoActual=null;break;
		
		}
		
	} 
}
