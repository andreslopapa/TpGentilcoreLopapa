package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.entities.Elemento;
import business.entities.TipoDeElemento;
import business.logic.CtrlElementoLogic;
import tools.AppDataException;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMCElemento extends JFrame {
	
	CtrlElementoLogic elemLogic = new CtrlElementoLogic();

	private JPanel contentPane;
	private JTextField textIdElemento;
	private JTextField textNombreElemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElemento frame = new ABMCElemento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ABMCElemento() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ABMCElemento.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 452);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBarraAzulLateral = new JPanel();
		panelBarraAzulLateral.setBackground(new Color(0, 51, 102));
		panelBarraAzulLateral.setBounds(0, 0, 130, 415);
		contentPane.add(panelBarraAzulLateral);
		
		textIdElemento = new JTextField();
		textIdElemento.setBounds(286, 107, 193, 20);
		contentPane.add(textIdElemento);
		textIdElemento.setColumns(10);
		
		textNombreElemento = new JTextField();
		textNombreElemento.setBounds(286, 154, 193, 20);
		contentPane.add(textNombreElemento);
		textNombreElemento.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					clickBuscarElemento();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
		btnBuscar.setBounds(520, 106, 89, 23);
		contentPane.add(btnBuscar);
	}
	
	protected void clickBuscarElemento() throws Exception{
		try {
			this.mapearAForm(elemLogic.getOne(this.mapearDeForm()));
		} catch (Exception sqlex) {
			throw new AppDataException(sqlex, "Error al buscar elemento");			//MECA: 			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private Elemento mapearDeForm(){
		Elemento e = new Elemento();
		TipoDeElemento tde = new TipoDeElemento();
		
		e.setId_elemento(Integer.parseInt(this.textIdElemento.getText()));
		e.setNombre(this.textNombreElemento.getText());
		//FALTA EL TIPO DE ELEMENTO
		return e;
	}
	
	private void mapearAForm(Elemento e){
	//	this.textIdElemento.setText(e.getId_elemento());
		this.textNombreElemento.setText(e.getNombre());
	}
}
