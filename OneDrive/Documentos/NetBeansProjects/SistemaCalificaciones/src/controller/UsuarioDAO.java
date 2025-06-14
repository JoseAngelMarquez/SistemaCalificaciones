package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para verificar credenciales de usuario
    public boolean verificarCredenciales(String nombreUsuario, String contraseña) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean usuarioValido = false;

        try {
            // Consulta SQL para verificar las credenciales
            String query = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();

            // Si se encuentra algún resultado, las credenciales son válidas
            if (rs.next()) {
                usuarioValido = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return usuarioValido;
    }
}
