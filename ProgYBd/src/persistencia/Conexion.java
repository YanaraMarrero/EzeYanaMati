package persistencia;

import java.sql.*;

public class Conexion {

	static String bd = "ProgYBD";
	static String login = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost/" + bd + "?useTimezone=true&serverTimezone=UTC";

	Connection con = null;

	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, login, password);

			if (con != null) {
				System.out.println("Conexión a " + bd + ": OK");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return con;
	}

	public void desconectar() {
		con = null;
	}

}