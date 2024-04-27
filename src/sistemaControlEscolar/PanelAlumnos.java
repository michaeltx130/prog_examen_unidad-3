package sistemaControlEscolar;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelAlumnos {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAlumnos window = new PanelAlumnos();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PanelAlumnos() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 500);
		frame.setTitle("Control escolar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
	
		JLabel lblNewLabel = new JLabel("Hola [Alumno]");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);

		PanelAlumnos();
	}
	
	private void PanelAlumnos() {
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		ImageIcon imgdescargar = new ImageIcon("descargar.png");
		ImageIcon imgdescargarSelect = new ImageIcon("descargarSelect.png");
		ImageIcon imgConsultar = new ImageIcon("consultar.png");
		ImageIcon imgConsultarSelect = new ImageIcon("consultarSelect.png");
		ImageIcon imgCrear = new ImageIcon("crear.png");
		ImageIcon imgCrearSelect = new ImageIcon("crearSelect.png");
		ImageIcon imgEditar = new ImageIcon("editar.png");
		ImageIcon imgEditarSelect = new ImageIcon("editarSelect.png");
		ImageIcon imgEliminar = new ImageIcon("eliminar.png");
		ImageIcon imgEliminarSelect = new ImageIcon("eliminarSelect.png");



		
		JButton descargarbtn = new JButton();
		descargarbtn.setContentAreaFilled(false);
		descargarbtn.setBorderPainted(false);
		descargarbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		descargarbtn.setBounds(60, 40, 135, 135);
		descargarbtn.setIcon(new ImageIcon(imgdescargar.getImage().getScaledInstance(descargarbtn.getWidth(), descargarbtn.getHeight(), Image.SCALE_SMOOTH)));
		descargarbtn.setRolloverIcon(new ImageIcon(imgdescargarSelect.getImage().getScaledInstance(descargarbtn.getWidth(), descargarbtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(descargarbtn);
		
		JButton consultarbtn = new JButton();
		consultarbtn.setContentAreaFilled(false);
		consultarbtn.setBorderPainted(false);
		consultarbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		consultarbtn.setBounds(250, 40, 135, 135);
		consultarbtn.setIcon(new ImageIcon(imgConsultar.getImage().getScaledInstance(consultarbtn.getWidth(), consultarbtn.getHeight(), Image.SCALE_SMOOTH)));
		consultarbtn.setRolloverIcon(new ImageIcon(imgConsultarSelect.getImage().getScaledInstance(consultarbtn.getWidth(), consultarbtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(consultarbtn);
		
		JButton crearBtn = new JButton();
		crearBtn.setBorderPainted(false);
		crearBtn.setContentAreaFilled(false);
		crearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearBtn.setBounds(440, 40, 135, 135);
		crearBtn.setIcon(new ImageIcon(imgCrear.getImage().getScaledInstance(crearBtn.getWidth(), crearBtn.getHeight(), Image.SCALE_SMOOTH)));
		crearBtn.setRolloverIcon(new ImageIcon(imgCrearSelect.getImage().getScaledInstance(crearBtn.getWidth(), crearBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(crearBtn);
		
		JButton editarBtn = new JButton();
		editarBtn.setContentAreaFilled(false);
		editarBtn.setBorderPainted(false);
		editarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarBtn.setBounds(146, 228, 135, 135);
		editarBtn.setIcon(new ImageIcon(imgEditar.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		editarBtn.setRolloverIcon(new ImageIcon(imgEditarSelect.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(editarBtn);
		
		JButton eliminarBtn = new JButton("");
		eliminarBtn.setContentAreaFilled(false);
		eliminarBtn.setBorderPainted(false);
		eliminarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarBtn.setBounds(351, 228, 135, 135);
		eliminarBtn.setIcon(new ImageIcon(imgEliminar.getImage().getScaledInstance(eliminarBtn.getWidth(), eliminarBtn.getHeight(), Image.SCALE_SMOOTH)));
		eliminarBtn.setRolloverIcon(new ImageIcon(imgEliminarSelect.getImage().getScaledInstance(eliminarBtn.getWidth(), eliminarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(eliminarBtn);
		
		JLabel descargarLabel = new JLabel("Descargar Información");
		descargarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descargarLabel.setBounds(60, 185, 135, 14);
		panel_1.add(descargarLabel);
		
		JLabel consultarLabel = new JLabel("Consultar");
		consultarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		consultarLabel.setBounds(250, 185, 135, 14);
		panel_1.add(consultarLabel);
		
		JLabel crearLabel = new JLabel("Crear");
		crearLabel.setHorizontalAlignment(SwingConstants.CENTER);
		crearLabel.setBounds(440, 186, 135, 14);
		panel_1.add(crearLabel);
		
		JLabel editarLabel = new JLabel("Editar");
		editarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		editarLabel.setBounds(146, 374, 135, 14);
		panel_1.add(editarLabel);
		
		JLabel eliminarLabel = new JLabel("Eliminar");
		eliminarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eliminarLabel.setBounds(351, 374, 135, 14);
		panel_1.add(eliminarLabel);
	}
}
