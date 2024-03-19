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

			String sql = "SELECT * FROM Perfil p WHERE p.id = ?";

			PreparedStatement statement = acceBD.prepareStatement(sql);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();

			String datos = null;

			while (resultSet.next()) {

				String nom1 = resultSet.getString("nom1");
				String nom2 = resultSet.getString("nom2");
				String ape1 = resultSet.getString("ape1");
				String ape2 = resultSet.getString("ape2");
				String nombreCompleto = unirNombres(nom1, nom2, ape1, ape2);
				String fechaNac = resultSet.getString("fechaNac");
				String fechaFall = resultSet.getString("fechaFall");
				String nacionalidad = resultSet.getString("nacionalidad");
				String ocupacion1 = resultSet.getString("ocupacion1");
				String ocupacion2 = resultSet.getString("ocupacion2");
				String logro1 = resultSet.getString("logro1");
				String logro2 = resultSet.getString("logro2");

				datos = String.format("Nombre: %s :: %s - %s :: Nacionalidad: %s :: Ocupacion: %s - %s :: Logros: %s - %s",
						nombreCompleto, fechaNac, fechaFall, nacionalidad, ocupacion1, ocupacion2, logro1, logro2);

			}

			return datos;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Error al obtener datos del perfil";
		}
	}

	public static String unirNombres(String nom1, String nom2, String ape1, String ape2) {
		StringBuilder nombreCompleto = new StringBuilder();
		if (nom1 != null) {
			nombreCompleto.append(nom1).append(" ");
		}
		if (nom2 != null) {
			nombreCompleto.append(nom2).append(" ");
		}
		if (ape1 != null) {
			nombreCompleto.append(ape1).append(" ");
		}
		if (ape2 != null) {
			nombreCompleto.append(ape2);
		}
		return nombreCompleto.toString().trim();
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