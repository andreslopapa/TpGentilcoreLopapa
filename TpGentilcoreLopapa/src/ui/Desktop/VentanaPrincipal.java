package ui.Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		


		
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			//@Override
			
			int x,y;
			public void mouseDragged(MouseEvent e) {
				 Point point = MouseInfo.getPointerInfo().getLocation() ; 
				setLocation(point.x - x, point.y - y)  ;
			}
		});
		contentPane.setBackground(new Color(51, 51, 102));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JLabel lblSistemaDeGestin = new JLabel("  SISTEMA DE GESTI\u00D3N DE RESERVAS");
		lblSistemaDeGestin.addMouseListener(new MouseAdapter() {
			
			int x,y; 
			
		//	@Override
			public void lblSistemaDeGestinmousePressed(MouseEvent evt) {

				   x = evt.getX   ()  ; 
				   y = evt.getY   ()  ; 
			}			
		});
		

		lblSistemaDeGestin.setBounds(0, 1, 742, 31);
		lblSistemaDeGestin.setForeground(Color.DARK_GRAY);
		lblSistemaDeGestin.setBackground(Color.WHITE);
		lblSistemaDeGestin.setOpaque(true);
		lblSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 12));
		contentPane.add(lblSistemaDeGestin);

		/*
		//BOTONES DE MINIMAR Y CERRAR (EN CASO DE QUERER CAMBIAR EL DISEÑ
		Button button_Cerrar = new Button("X");
		button_Cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		button_Cerrar.setForeground(Color.BLACK);
		button_Cerrar.setBounds(772, 1, 28, 31);
		contentPane.add(button_Cerrar);
O)
		Button button_Minimizar = new Button("-");
		button_Minimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setExtendedState(ICONIFIED); 

			}
		});
		button_Minimizar.setBounds(740, 1, 28, 31);
		contentPane.add(button_Minimizar);
		*/
		JLabel lblCerrar = new JLabel("X");
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Esta seguro que desea Cerrar?", "Saliendo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					System.exit(0);
					}
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setBounds(772, 1, 28, 31);
		lblCerrar.setBackground(Color.BLACK);
		lblCerrar.setOpaque(true);
		lblCerrar.setFont(new Font("Calibri", Font.PLAIN, 12));
		contentPane.add(lblCerrar);
		
		JLabel labMinimizar = new JLabel("-");
		labMinimizar.setFont(new Font("Calibri", Font.PLAIN, 12));
		labMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setExtendedState(ICONIFIED); 
			}
		});
		labMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		labMinimizar.setForeground(Color.WHITE);
		labMinimizar.setBounds(743, 1, 28, 31);
		labMinimizar.setBackground(Color.DARK_GRAY);
		labMinimizar.setOpaque(true);

		contentPane.add(labMinimizar);
		
		
		labMinimizar.setFocusable(false)  ; 
		lblCerrar.setFocusable(false)  ; 
		lblSistemaDeGestin.setFocusable(false)  ;
		
		Panel panel_Gris_Derecho = new Panel();
		panel_Gris_Derecho.setBackground(new Color(0, 51, 102));
		panel_Gris_Derecho.setBounds(288, 33, 512, 417);
		contentPane.add(panel_Gris_Derecho);
		panel_Gris_Derecho.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(68, 107, 43, 16);
		lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
		panel_Gris_Derecho.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(67, 132, 348, 20);
		panel_Gris_Derecho.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblContrasenia.setBounds(68, 196, 77, 14);
		panel_Gris_Derecho.add(lblContrasenia);
		
		textContrasenia = new JTextField();
		textContrasenia.setBounds(68, 221, 347, 20);
		panel_Gris_Derecho.add(textContrasenia);
		textContrasenia.setColumns(10);
		
		JLabel lblIngresar = new JLabel("Ingresar");
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIngresar.setForeground(Color.WHITE);
		lblIngresar.setBounds(343, 292, 72, 16);
		panel_Gris_Derecho.add(lblIngresar);
		
		JLabel lblInicioSesion = new JLabel("Iniciar sesi\u00F3n");
		lblInicioSesion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblInicioSesion.setForeground(Color.WHITE);
		lblInicioSesion.setBounds(68, 40, 122, 20);
		panel_Gris_Derecho.add(lblInicioSesion);
		
		JLabel lblnoTieneUnaCuenta = new JLabel("\u00BFNo tiene una cuenta?");
		lblnoTieneUnaCuenta.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblnoTieneUnaCuenta.setForeground(Color.WHITE);
		lblnoTieneUnaCuenta.setBounds(68, 293, 107, 14);
		panel_Gris_Derecho.add(lblnoTieneUnaCuenta);
		
		JLabel lblCreeUna = new JLabel("Cree una");
		lblCreeUna.setFont(new Font("Calibri", Font.BOLD, 12));
		lblCreeUna.setForeground(Color.WHITE);
		lblCreeUna.setBounds(181, 294, 55, 14);
		panel_Gris_Derecho.add(lblCreeUna);
	//	button_Minimizar.setFocusable(false)  ; 
	//	button_Cerrar.setFocusable(false) ; 

		
		
		
		
		
	}/*
    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }*/
}
