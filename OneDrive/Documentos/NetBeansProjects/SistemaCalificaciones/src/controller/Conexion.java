package controller;

import java.sql.*;

public class Conexion {
    private Connection conexion = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private boolean isConnectionClosed = false;

    public Conexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/calificaciones", "root", "JAME060503");
            System.out.println("Conexión establecida.");
        } catch (ClassNotFoundException e1) {
            System.out.println("ERROR: No se pudo cargar el driver de MySQL: " + e1.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public ResultSet getResultSet() {
        return rs;
    }

    public void setPreparedStatement(String consulta) {
        try {
            ps = conexion.prepareStatement(consulta);
        } catch (SQLException e) {
            System.out.println("ERROR: Fallo al preparar la consulta SQL: " + e.getMessage());
        }
    }

    public void setParameter(int posicion, Object valor) {
        try {
            ps.setObject(posicion, valor);
        } catch (SQLException e) {
            System.out.println("ERROR: Fallo al establecer parámetro: " + e.getMessage());
        }
    }

    public void executeQuery() {
        try {
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("ERROR: Fallo en la consulta SQL: " + e.getMessage());
        }
    }

    public int executeUpdate() {
        int filasAfectadas = 0;
        try {
            filasAfectadas = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: Fallo en la actualización SQL: " + e.getMessage());
        }
        return filasAfectadas;
    }

    public void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Fallo al cerrar recursos: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (conexion != null && !isConnectionClosed) {
            try {
                closeResources(); // Asegúrate de cerrar recursos antes de cerrar la conexión
                conexion.close();
                isConnectionClosed = true;
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("ERROR: Fallo al cerrar conexión: " + e.getMessage());
            }
        }
    }

    public boolean isConnectionClosed() {
        return isConnectionClosed;
    }
}
