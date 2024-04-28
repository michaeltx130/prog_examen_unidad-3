package sistemaControlEscolar;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 650, 510);
		frame.setTitle("Control escolar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		BarraMenu();
		this.PanelAlumnos(frame);
	}
	
	private void PanelAlumnos(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Hola [Alumno]");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
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
		descargarbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Descarga completada.");
			}
		});
		descargarbtn.setContentAreaFilled(false);
		descargarbtn.setBorderPainted(false);
		descargarbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		descargarbtn.setBounds(60, 40, 135, 135);
		descargarbtn.setIcon(new ImageIcon(imgdescargar.getImage().getScaledInstance(descargarbtn.getWidth(), descargarbtn.getHeight(), Image.SCALE_SMOOTH)));
		descargarbtn.setRolloverIcon(new ImageIcon(imgdescargarSelect.getImage().getScaledInstance(descargarbtn.getWidth(), descargarbtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_1.add(descargarbtn);
		
		JButton consultarbtn = new JButton();
		consultarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				frame.getContentPane().revalidate();
				
				ConsultarAlumno(frame);
			}
		});
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
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
	}
	
	public void BarraMenu() {
		
		JMenuBar barra = new JMenuBar();
		frame.setJMenuBar(barra);
		
		JMenu menu = new JMenu("Opciones");
		ImageIcon iconOpciones = new ImageIcon("opciones.png");
		menu.setIcon(new ImageIcon(iconOpciones.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		
		JMenu menu2 = new JMenu("Usuario");
		ImageIcon iconAyuda = new ImageIcon("avatar.png");
		menu2.setIcon(new ImageIcon(iconAyuda.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		
		ImageIcon imgEliminar = new ImageIcon("cerrar-sesion.png");
		JMenuItem eleccion1 = new JMenuItem("Cerrar sesión", new ImageIcon(imgEliminar.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
		menu.add(eleccion1);

		ImageIcon imgDocente = new ImageIcon("docente.png");
		JMenuItem seleccion1 = new JMenuItem("Docentes", new ImageIcon(imgDocente.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		menu2.add(seleccion1);
		
		ImageIcon imgAlumnos = new ImageIcon("alumno.png");
		JMenuItem seleccion2 = new JMenuItem("Alumnos", new ImageIcon(imgAlumnos.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		menu2.add(seleccion2);

		barra.add(menu);
		barra.add(menu2);
		barra.updateUI();
	}
	
	private void ConsultarAlumno(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e88e5"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel titulo = new JLabel("    Consulta de alumno");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(titulo, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#1e88e5"));
		panel_6.setBounds(395, 11, 216, 273);
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_6.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(151, 203, 255));
		panel_6.add(panel_7, BorderLayout.CENTER);
		
		ImageIcon imgUsuario = new ImageIcon("fotoEstudiante.png");
		JLabel img_user = new JLabel();
		img_user.setBounds(32, 11, 147, 167);
		img_user.setIcon(new ImageIcon(imgUsuario.getImage().getScaledInstance(img_user.getWidth(), img_user.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(img_user);
		
		ImageIcon imgEliminar = new ImageIcon("borrar.png");
		ImageIcon imgEliminarSelect = new ImageIcon("borrarSelect.png");
		JButton borrarBtn = new JButton();
		borrarBtn.setContentAreaFilled(false);
		borrarBtn.setBorderPainted(false);
		borrarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		borrarBtn.setBounds(131, 180, 59, 42);
		borrarBtn.setIcon(new ImageIcon(imgEliminar.getImage().getScaledInstance(borrarBtn.getWidth(), borrarBtn.getHeight(), Image.SCALE_SMOOTH)));
		borrarBtn.setRolloverIcon(new ImageIcon(imgEliminarSelect.getImage().getScaledInstance(borrarBtn.getWidth(), borrarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(borrarBtn);
		
		
		ImageIcon imgEditar = new ImageIcon("cambiarFoto.png");
		ImageIcon imgEditarSelect = new ImageIcon("cambiarFotoSelect.png");
		JButton editarBtn = new JButton();
		editarBtn.setContentAreaFilled(false);
		editarBtn.setBorderPainted(false);
		editarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarBtn.setBounds(20, 180, 59, 50);
		editarBtn.setIcon(new ImageIcon(imgEditar.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		editarBtn.setRolloverIcon(new ImageIcon(imgEditarSelect.getImage().getScaledInstance(editarBtn.getWidth(), editarBtn.getHeight(), Image.SCALE_SMOOTH)));
		panel_7.add(editarBtn);
		
		JLabel lblNewLabel_4 = new JLabel("Cambiar foto");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 222, 76, 14);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Borrar foto");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(121, 222, 76, 14);
		panel_7.add(lblNewLabel_4_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#1e88e5"));
		panel_2_1.setBounds(23, 11, 341, 273);
		panel_2.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_2_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_2_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(151, 203, 255));
		
		JLabel nombre_etiqueta = new JLabel("Nombres:");
		nombre_etiqueta.setBounds(15, 25, 56, 14);
		panel_3.add(nombre_etiqueta);
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 22, 136, 20);
		panel_3.add(textField);
		
		JLabel ap_etiqueta = new JLabel("Apellido Paterno:");
		ap_etiqueta.setBounds(15, 62, 100, 14);
		panel_3.add(ap_etiqueta);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 59, 136, 20);
		panel_3.add(textField_1);
		
		JLabel am_etiqueta = new JLabel("Apellido Materno:");
		am_etiqueta.setBounds(15, 99, 100, 14);
		panel_3.add(am_etiqueta);
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 96, 136, 20);
		panel_3.add(textField_2);
		
		JLabel fecha_etiqueta = new JLabel("Fecha Nacimiento:");
		fecha_etiqueta.setBounds(15, 136, 105, 14);
		panel_3.add(fecha_etiqueta);
		
		JComboBox fechas_nacimiento = new JComboBox(new Object[]{});
		fechas_nacimiento.setBounds(136, 133, 136, 20);
		panel_3.add(fechas_nacimiento);
		
		JLabel genero_etiqueta = new JLabel("Correo electrónico:");
		genero_etiqueta.setBounds(15, 173, 116, 14);
		panel_3.add(genero_etiqueta);
		
		JLabel nacionalidad_etiqueta = new JLabel("Teléfono: ");
		nacionalidad_etiqueta.setBounds(15, 210, 76, 14);
		panel_3.add(nacionalidad_etiqueta);
		
		JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(136, 170, 136, 20);
		panel_3.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(136, 207, 136, 20);
		panel_3.add(textField_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#1e88e5"));
		panel_4.setBounds(23, 295, 590, 114);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(151, 203, 255));
		panel_4.add(panel_5, BorderLayout.CENTER);
		
		JLabel descripcion_etiqueta = new JLabel("Nivel Educativo:");
		descripcion_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta.setBounds(23, 21, 106, 14);
		panel_5.add(descripcion_etiqueta);
		
		JLabel preferencias_etiqueta = new JLabel("N° Matrícula:");
		preferencias_etiqueta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		preferencias_etiqueta.setBounds(22, 58, 77, 14);
		panel_5.add(preferencias_etiqueta);
		
		JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(137, 19, 136, 20);
		panel_5.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(137, 56, 136, 20);
		panel_5.add(textField_6);
		
		JLabel descripcion_etiqueta_1 = new JLabel("Semestre:");
		descripcion_etiqueta_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1.setBounds(301, 22, 77, 14);
		panel_5.add(descripcion_etiqueta_1);
		
		JTextField textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(372, 19, 50, 20);
		panel_5.add(textField_7);
		
		JLabel descripcion_etiqueta_1_1 = new JLabel("Grupo:");
		descripcion_etiqueta_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_1_1.setBounds(448, 21, 50, 14);
		panel_5.add(descripcion_etiqueta_1_1);
		
		JTextField textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(508, 19, 50, 20);
		panel_5.add(textField_8);
		
		JLabel descripcion_etiqueta_2 = new JLabel("Carrera:");
		descripcion_etiqueta_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descripcion_etiqueta_2.setBounds(302, 58, 62, 14);
		panel_5.add(descripcion_etiqueta_2);
		
		JTextField textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(372, 56, 186, 20);
		panel_5.add(textField_9);
		
	}
}
