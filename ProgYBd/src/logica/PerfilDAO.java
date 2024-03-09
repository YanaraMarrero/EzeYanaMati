package logica;

import java.sql.*;
import persistencia.*;

public class PerfilDAO {

	private Conexion conexion;

	public PerfilDAO() {
			conexion = new Conexion();
		}

	public String insertarPerfil(Perfil perfil) {
		int numFAfectadas = 0;
		String rptaRegistro = null;
		try {
			Connection acceBD = conexion.getConnection();
			
			String sql = "INSERT INTO perfil VALUES(?,?,?,?,?,?)";
			PreparedStatement estatuto = acceBD.prepareStatement(sql);
			estatuto.setInt(1, perfil.getId());
			estatuto.setString(2, perfil.getNombre());
			estatuto.setString(3, perfil.getFechaNac().toString());
			estatuto.setString(4, perfil.getFechaFall().toString());
			estatuto.setString(5, perfil.getNacionalidad());
			estatuto.setString(6, perfil.getOcupacion());
			estatuto.setString(7, perfil.getLogros());

			numFAfectadas = estatuto.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().equals("Duplicate entry '" + perfil.getId() + "' for key 'libro.PRIMARY'")) {
				return "Duplicado";
			}
		}
		if (numFAfectadas > 0)
			rptaRegistro = "Si";
		return rptaRegistro;
	}

	public String getPerfil() {
		try {
			Connection acceBD = conexion.getConnection();

			String sql = "SELECT id, nombre, fechNac, fechFall, nacionalidad, ocupacion, logros FROM perfil WHERE id = ?";

			PreparedStatement estatuto = acceBD.prepareStatement(sql);

			ResultSet resultSet = estatuto.executeQuery();

			StringBuilder datos = new StringBuilder();

			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String nombre = resultSet.getString("nombre");
				String fechNac = resultSet.getString("fechNac");
				String fechFall = resultSet.getString("fechFall");
				String nacionalidad = resultSet.getString("nacionalidad");
				String ocupacion = resultSet.getString("ocupacion");
				String logros = resultSet.getString("logros");

				datos.append("Id: ").append(id).append(", Nombre: ").append(nombre).append(", Fecha de Nacimiento: ")
						.append(fechNac).append(", Fecha de Fallecimiento: ").append(fechFall).append(", Nacionalidad: ").append(nacionalidad)
						.append(", Ocupacion: ").append(ocupacion).append(", Logros: ").append(logros).append("\n");
			}

			return datos.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Error al obtener datos del perfil";
		}
	}

	public boolean eliminarPerfil(String ci) {
		try {
			Connection acceBD = conexion.getConnection();

			// Eliminar de la tabla perfil
			String sql = "DELETE FROM perfil WHERE id=?";
			PreparedStatement estatuto = acceBD.prepareStatement(sql);
			estatuto.setString(1, ci);
			int filasAfectadas = estatuto.executeUpdate();
			System.out.println("Filas afectadas en perfil: " + filasAfectadas);

			if (filasAfectadas > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

}