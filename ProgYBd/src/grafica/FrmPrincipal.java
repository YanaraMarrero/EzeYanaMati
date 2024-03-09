package grafica;

import logica.*;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JComboBox cmbPerfiles;
	ImagenDAO imgD = new ImagenDAO();
	private JPanel panel_Foto;
	private JLabel lblFoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(10, 11, 414, 230);
		contentPane.add(panel);
		panel.setLayout(null);

		cmbPerfiles = new JComboBox();
		cmbPerfiles.setModel(new DefaultComboBoxModel(new String[] {"Ada Lovelace", "Barbara Thoens", "Betty Snyder Holberton", "Carol Shaw", "Erna Schneider Hoover", "Evelyn Berezin", "Frances E. Allen", "Grace Murray Hopper", "Hedy Lemarr", "Jean Bartik", "Jean E. Sammet", "Joan Clarke", "Joanna Rutkowska", "Jude Milhon", "Karen Spärck Jones", "Kathleen McNulty Mauchly Anton", "Lynn Conway", "Margaret Hamilton", "Marlyn Wescoff Meltze", "Radia Perlman", "Rózsa Péter", "Ruth Lichterman Teitelbaum", "Gertrude Blanch"}));
		cmbPerfiles.setBounds(10, 11, 394, 22);
		panel.add(cmbPerfiles);

		JTextField txtFechas = new JTextField();
		txtFechas.setBounds(120, 44, 284, 27);
		panel.add(txtFechas);
		txtFechas.setColumns(10);

		panel_Foto = new JPanel();
		panel_Foto.setBounds(10, 44, 103, 103);
		panel.add(panel_Foto);
		panel_Foto.setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setBounds(0, 0, 103, 103);
		panel_Foto.add(lblFoto);

		JTextField txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(120, 82, 284, 27);
		panel.add(txtNacionalidad);

		JTextField txtOcupacion = new JTextField();
		txtOcupacion.setColumns(10);
		txtOcupacion.setBounds(120, 120, 284, 27);
		panel.add(txtOcupacion);

		JTextField txtLogros = new JTextField();
		txtLogros.setBounds(10, 158, 394, 61);
		panel.add(txtLogros);
		txtLogros.setColumns(10);

		cmbPerfiles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String perfilSeleccionado = (String) cmbPerfiles.getSelectedItem();

					if (perfilSeleccionado != null) {
						switch (perfilSeleccionado) {
						case "Ada Lovelace":
							mostrarImagen("1");
							break;
						case "Barbara Thoens":
							mostrarImagen("2");
							break;
						case "Betty Snyder Holberton":
							mostrarImagen("3");
							break;
						case "Carol Shaw":
							mostrarImagen("4");
							break;
						case "Erna Schneider Hoover":
							mostrarImagen("5");
							break;
						case "Evelyn Berezin":
							mostrarImagen("6");
							break;
						case "Frances E. Allen":
							mostrarImagen("7");
							break;
						case "Grace Murray Hopper":
							mostrarImagen("8");
							break;
						case "Hedy Lemarr":
							mostrarImagen("9");
							break;
						case "Jean Bartik":
							mostrarImagen("10");
							break;
						case "Jean E. Sammet":
							mostrarImagen("11");
							break;
						case "Joan Clarke":
							mostrarImagen("12");
							break;
						case "Joanna Rutkowska":
							mostrarImagen("13");
							break;
						case "Jude Milhon":
							mostrarImagen("14");
							break;
						case "Karen Spärck Jones":
							mostrarImagen("15");
							break;
						case "Kathleen McNulty Mauchly Anton":
							mostrarImagen("16");
							break;
						case "Lynn Conway":
							mostrarImagen("17");
							break;
						case "Margaret Hamilton":
							mostrarImagen("18");
							break;
						case "Marlyn Wescoff Meltze":
							mostrarImagen("19");
							break;
						case "Radia Perlman":
							mostrarImagen("20");
							break;
						case "Rózsa Péter":
							mostrarImagen("21");
							break;
						case "Ruth Lichterman Teitelbaum":
							mostrarImagen("22");
							break;
						case "Gertrude Blanch":
							mostrarImagen("23");
							break;
						default:
							limpiarImagen();
						}
					}
				}
			}
		});
	}

	private void mostrarImagen(String id) {
		ImageIcon icono = new ImageIcon(imgD.pedirImagen(id));
		Image imagenEscalada = icono.getImage().getScaledInstance(panel_Foto.getWidth(), panel_Foto.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		JLabel lblFoto = (JLabel) panel_Foto.getComponent(0);
		lblFoto.setIcon(iconoEscalado);
		panel_Foto.revalidate();
		panel_Foto.repaint();
	}

	private void limpiarImagen() {
		panel_Foto.removeAll();
		panel_Foto.revalidate();
		panel_Foto.repaint();
	}
}