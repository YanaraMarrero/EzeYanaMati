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
			PreparedStatement statement = acceBD.prepareStatement(sql);
			statement.setInt(1, perfil.getId());
			statement.setString(2, perfil.getNombre());
			statement.setString(3, perfil.getFechaNac().toString());
			statement.setString(4, perfil.getFechaFall().toString());
			statement.setString(5, perfil.getNacionalidad());
			statement.setString(6, perfil.getOcupacion());
			statement.setString(7, perfil.getLogros());

			numFAfectadas = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().equals("Duplicate entry '" + perfil.getId() + "' for key 'perfil.PRIMARY'")) {
				return "Duplicado";
			}
		}
		if (numFAfectadas > 0)
			rptaRegistro = "Si";
		return rptaRegistro;
	}

	public String getPerfil(String id) {
		try {
			Connection acceBD = conexion.getConnection();

			String sql = "SELECT id, nombre, fechaNac, fechaFall, nacionalidad, ocupacion, logros FROM perfil WHERE id = ?";

			PreparedStatement statement = acceBD.prepareStatement(sql);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();

			String datos = null;

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String fechaNac = resultSet.getString("fechaNac");
				String fechaFall = resultSet.getString("fechaFall");
				String nacionalidad = resultSet.getString("nacionalidad");
				String ocupacion = resultSet.getString("ocupacion");
				String logros = resultSet.getString("logros");

				datos = String.format("Nombre: %s :: %s - %s :: Nacionalidad: %s :: Ocupacion: %s :: Logros: %s", nombre, fechaNac, fechaFall, nacionalidad, ocupacion, logros);
				
			}

			return datos.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Error al obtener datos del perfil";
		}
	}

	public boolean eliminarPerfil(String id) {
		try {
			Connection acceBD = conexion.getConnection();

			// Eliminar de la tabla perfil
			String sql = "DELETE FROM perfil WHERE id=?";
			PreparedStatement statement = acceBD.prepareStatement(sql);
			statement.setString(1, id);

			int filasAfectadas = statement.executeUpdate();
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