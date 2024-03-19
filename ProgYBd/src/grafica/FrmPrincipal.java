package grafica;

import logica.*;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JComboBox cmbPerfiles;
	private JPanel panel_Foto;
	private JLabel lblFoto;
	private JTextField txtFechas;
	private JTextField txtNacionalidad;
	private JTextField txtOcupacion;
	private JTextField txtLogros;
	ImagenDAO imgD = new ImagenDAO();
	PerfilDAO perD = new PerfilDAO();

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
		cmbPerfiles.setModel(new DefaultComboBoxModel(new String[] { "", "Ada Lovelace", "Barbara Thoens",
				"Betty Snyder Holberton", "Carol Shaw", "Erna Schneider Hoover", "Evelyn Berezin", "Frances E. Allen",
				"Grace Murray Hopper", "Hedy Lemarr", "Jean Bartik", "Jean E. Sammet", "Joan Clarke",
				"Joanna Rutkowska", "Jude Milhon", "Karen Spärck Jones", "Kathleen McNulty Mauchly Anton",
				"Lynn Conway", "Margaret Hamilton", "Marlyn Wescoff Meltze", "Radia Perlman", "Rózsa Péter",
				"Ruth Lichterman Teitelbaum", "Gertrude Blanch" }));
		cmbPerfiles.setBounds(10, 11, 394, 22);
		panel.add(cmbPerfiles);

		txtFechas = new JTextField();
		txtFechas.setEditable(false);
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

		txtNacionalidad = new JTextField();
		txtNacionalidad.setEditable(false);
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(120, 82, 284, 27);
		panel.add(txtNacionalidad);

		txtOcupacion = new JTextField();
		txtOcupacion.setEditable(false);
		txtOcupacion.setColumns(10);
		txtOcupacion.setBounds(120, 120, 284, 27);
		panel.add(txtOcupacion);

		txtLogros = new JTextField();
		txtLogros.setEditable(false);
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
							mostrarDatos("1");
							break;
						case "Barbara Thoens":
							mostrarImagen("2");
							mostrarDatos("2");
							break;
						case "Betty Snyder Holberton":
							mostrarImagen("3");
							mostrarDatos("3");
							break;
						case "Carol Shaw":
							mostrarImagen("4");
							mostrarDatos("4");
							break;
						case "Erna Schneider Hoover":
							mostrarImagen("5");
							mostrarDatos("5");
							break;
						case "Evelyn Berezin":
							mostrarImagen("6");
							mostrarDatos("6");
							break;
						case "Frances E. Allen":
							mostrarImagen("7");
							mostrarDatos("7");
							break;
						case "Grace Murray Hopper":
							mostrarImagen("8");
							mostrarDatos("8");
							break;
						case "Hedy Lemarr":
							mostrarImagen("9");
							mostrarDatos("9");
							break;
						case "Jean Bartik":
							mostrarImagen("10");
							mostrarDatos("10");
							break;
						case "Jean E. Sammet":
							mostrarImagen("11");
							mostrarDatos("11");
							break;
						case "Joan Clarke":
							mostrarImagen("12");
							mostrarDatos("12");
							break;
						case "Joanna Rutkowska":
							mostrarImagen("13");
							mostrarDatos("13");
							break;
						case "Jude Milhon":
							mostrarImagen("14");
							mostrarDatos("14");
							break;
						case "Karen Spärck Jones":
							mostrarImagen("15");
							mostrarDatos("15");
							break;
						case "Kathleen McNulty Mauchly Anton":
							mostrarImagen("16");
							mostrarDatos("16");
							break;
						case "Lynn Conway":
							mostrarImagen("17");
							mostrarDatos("17");
							break;
						case "Margaret Hamilton":
							mostrarImagen("18");
							mostrarDatos("18");
							break;
						case "Marlyn Wescoff Meltze":
							mostrarImagen("19");
							mostrarDatos("19");
							break;
						case "Radia Perlman":
							mostrarImagen("20");
							mostrarDatos("20");
							break;
						case "Rózsa Péter":
							mostrarImagen("21");
							mostrarDatos("21");
							break;
						case "Ruth Lichterman Teitelbaum":
							mostrarImagen("22");
							mostrarDatos("22");
							break;
						case "Gertrude Blanch":
							mostrarImagen("23");
							mostrarDatos("23");
							break;
						default:
							limpiarImagen();
							limpiarDatos();
						}
					}
				}
			}
		});
	}

	private void mostrarImagen(String id) {
		ImageIcon icono = new ImageIcon(imgD.getImagen(id));
		Image imagenEscalada = icono.getImage().getScaledInstance(panel_Foto.getWidth(), panel_Foto.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		JLabel lblFoto = (JLabel) panel_Foto.getComponent(0);
		lblFoto.setIcon(iconoEscalado);
		panel_Foto.revalidate();
		panel_Foto.repaint();
	}

	private void limpiarImagen() {
		lblFoto.setIcon(null);
		;
		panel_Foto.revalidate();
		panel_Foto.repaint();
	}

	private void mostrarDatos(String id) {
		System.out.println(perD.getPerfil(id).split("::")[0]);
		txtFechas.setText(perD.getPerfil(id).split("::")[1]);
		txtNacionalidad.setText(perD.getPerfil(id).split("::")[2]);
		txtOcupacion.setText(perD.getPerfil(id).split("::")[3]);
		txtLogros.setText(perD.getPerfil(id).split("::")[4]);
		// El ".split("::")" sirve para separar el string cada vez que haya un "::"
		// "Nombre: %s :: %s - %s :: Nacionalidad: %s :: Ocupacion: %s :: Logros: %s"
	}

	private void limpiarDatos() {
		txtFechas.setText("");
		txtNacionalidad.setText("");
		txtOcupacion.setText("");
		txtLogros.setText("");
	}

}