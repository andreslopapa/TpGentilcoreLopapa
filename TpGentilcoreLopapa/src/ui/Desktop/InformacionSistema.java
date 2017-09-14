package ui.Desktop;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JPanel;

public class InformacionSistema extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionSistema frame = new InformacionSistema();
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
	public InformacionSistema() {

		setBorder(null);											
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); //estas dos ultimas lineas quitan bordes y barra superior de la ventana
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 816, 518);
		
		JLabel lblSistemaDeGestin = new JLabel("Sistema de gesti\u00F3n de Reservas ");
		lblSistemaDeGestin.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblSistemaRealizadoComo = new JLabel("Sistema realizado como Trabajo Pr\u00E1ctico para la C\u00E1tedra de Java\r\n2017");
		
		JLabel lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JLabel lblAlbertoGentilcoreLegajo = new JLabel("Alberto Gentilcore");
		lblAlbertoGentilcoreLegajo.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblAndresLopapa = new JLabel("Andres Lopapa");
		lblAndresLopapa.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblUniversidadTecnolgicaNacional = new JLabel("Universidad Tecnol\u00F3gica Nacional");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		
		JLabel lblHomTrabaj = new JLabel("");
		lblHomTrabaj.setIcon(new ImageIcon(InformacionSistema.class.getResource("/ui/Desktop/hombres_trabajando.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSistemaDeGestin)
						.addComponent(lblSistemaRealizadoComo)
						.addComponent(lblUniversidadTecnolgicaNacional)
						.addComponent(lblAlbertoGentilcoreLegajo)
						.addComponent(lblAndresLopapa)
						.addComponent(lblAlumnos)
						.addComponent(lblHomTrabaj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(403, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemaDeGestin)
					.addGap(6)
					.addComponent(lblSistemaRealizadoComo)
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addComponent(lblUniversidadTecnolgicaNacional)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAlumnos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAlbertoGentilcoreLegajo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAndresLopapa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHomTrabaj, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(217))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InformacionSistema.class.getResource("/tools/perrito.png")));
		panel.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);

	}
}
