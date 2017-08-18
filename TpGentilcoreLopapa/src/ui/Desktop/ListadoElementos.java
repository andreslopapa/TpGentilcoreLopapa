package ui.Desktop;


import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;


import business.entities.Elemento;
import business.logic.CtrlElementoLogic;


import java.util.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableList;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import tools.Campo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoElementos extends Listado {
	/**
	 * @wbp.nonvisual location=127,137
	 */
	private CtrlElementoLogic elementoLogic;
	private ArrayList<Elemento> elementos=null;
	private int totalElementos;
	
	private JTable table;
	private JTextField txtIndice;
	private JLabel lblIndice;

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
	public ListadoElementos() {
		
	
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
		
		txtIndice.setColumns(10);
		txtIndice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblIndice = new JLabel("de xxx");
		getContentPane().setLayout(new MigLayout("", "[100%][100%][][50:50:50,center][][][][100%][100%]", "[][95%][5%,baseline]"));
		getContentPane().add(txtIndice, "cell 3 2,alignx right,aligny center");
		getContentPane().add(lblIndice, "cell 5 2,alignx left,aligny center");
		getContentPane().add(btnAnterior, "cell 1 2,alignx right,aligny center");
		getContentPane().add(btnSiguiente, "cell 7 2,alignx left,aligny center");
		getContentPane().add(scrollPane, "cell 1 1 7 1,grow");
		
		this.indiceActual=1;
		txtIndice.setText(String.valueOf(indiceActual));
		this.Actualiza();
		initDataBindings();

	}
	protected void buscarXIndiceClick(String indiceCampo,Indice tipoIndice) {
		if(Campo.Valida(indiceCampo, Campo.tipo.INDICE)){
			this.Actualiza();
			int indiceTexto=Integer.parseInt(indiceCampo);
			if(indiceTexto<=cantidadIndices){	
				indiceActual=indiceTexto;
				if(tipoIndice==Indice.ANTERIOR && indiceActual>1){
					--indiceActual;
					txtIndice.setText(String.valueOf(indiceActual));
				}
				else if(tipoIndice==Indice.POSTERIOR && indiceActual<cantidadIndices){
					++indiceActual;
					txtIndice.setText(String.valueOf(indiceActual));
				}
				//JOptionPane.showMessageDialog(null, Math.ceil(totalElementos/FilasTabla));
				
				try {
					this.elementos=elementoLogic.getSome((indiceActual-1)*FilasTabla,FilasTabla);
					initDataBindings();
					
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
			//esto corregirlo
		}
	}
	
	private void Actualiza(){
		try {
			this.elementos=elementoLogic.getSome(indiceActual-1,FilasTabla);
			this.totalElementos=elementoLogic.getCantidad();
			cantidadIndices=(int)Math.ceil((double)totalElementos/FilasTabla);
		    this.lblIndice.setText("de "+String.valueOf(cantidadIndices));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al actualizar datos\n"+ex.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	protected void initDataBindings() {
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
}
