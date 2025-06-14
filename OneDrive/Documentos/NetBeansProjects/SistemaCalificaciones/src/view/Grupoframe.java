package view;

import controller.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Grupoframe extends javax.swing.JFrame {

    Conexion conexion;

    public Grupoframe() {
        initComponents();
        try {
            conexion = new Conexion();

            if (conexion == null) {
                JOptionPane.showMessageDialog(this, "Error al conectarse a la bd");

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        centrarFrame();
        estilobtns();
    }

    private void estilobtns() {
        // Hacer que el botón sea transparente
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
    }

    private void centrarFrame() {
        // Obtener el tamaño de la pantalla
        java.awt.Dimension pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        // Calcular la posición para centrar el frame
        int x = (pantalla.width - getWidth()) / 2;
        int y = (pantalla.height - getHeight()) / 2;

        // Establecer la posición del frame
        setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Frank Ruehl CLM", 1, 36)); // NOI18N
        jLabel1.setText("REGISTRO DE GRUPOS");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 40));

        jLabel2.setText("Nombre del grupo:");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 140, -1));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_Materia", "Nombre del grupo"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 295, 114));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_inseratarGrupo.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 120, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_modificaGrupo.png"))); // NOI18N
        jButton2.setText("Moficar ");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 120, 36));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_buscargrupo.png"))); // NOI18N
        jButton3.setText("Mostrar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 120, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_eliminarGrupo.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 120, 36));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_cerrar.png"))); // NOI18N
        jButton5.setText("Cerrar");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 107, 36));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondogrupos.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String grupo = jTextField1.getText();
        try {
            if (grupo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo está vacío. Por favor llena el campo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String query = "INSERT INTO grupo (nombre_grupo) VALUES (?)";
            conexion.setPreparedStatement(query);

            conexion.setParameter(1, grupo);
            int filas = conexion.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(this, "Grupo registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el grupo");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String query = "Select * from grupo";
            conexion.setPreparedStatement(query);
            conexion.executeQuery();
            ResultSet rs = conexion.getResultSet();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            if (model == null) {
                model = new DefaultTableModel();
                jTable1.setModel(model);
            } else {
                model.setRowCount(0);
            }

            while (rs.next()) {
                int id_grupo = rs.getInt("id_grupo");
                String nombre_grupo = rs.getString("nombre_grupo");

                Object[] row = {id_grupo, nombre_grupo};
                model.addRow(row);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar consulta SQL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int selectrow = jTable1.getSelectedRow();
            if (selectrow == -1) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona una fila a eliminar");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int id_grupo = (int) model.getValueAt(selectrow, 0); 

            String query = "DELETE FROM grupo WHERE id_grupo = ?";
            conexion.setPreparedStatement(query);
            conexion.setParameter(1, id_grupo);

            int filas_afectadas = conexion.executeUpdate();
            if (filas_afectadas > 0) {
                JOptionPane.showMessageDialog(this, "Fila eliminada correctamente");
                model.removeRow(selectrow);
            } else {
                JOptionPane.showMessageDialog(this, "Error: no se pudo eliminar el grupo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar consulta SQL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int selectrow = jTable1.getSelectedRow();
            if (selectrow == -1) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona una fila a modificar");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int id_grupo = (int) model.getValueAt(selectrow, 0); // Asumiendo que la columna 0 es id_grupo
            String nuevoNombre = jTextField1.getText();

            String query = "UPDATE grupo SET nombre_grupo = ? WHERE id_grupo = ?";
            conexion.setPreparedStatement(query);
            conexion.setParameter(1, nuevoNombre);
            conexion.setParameter(2, id_grupo);

            int filas = conexion.executeUpdate();
            if (filas > 0) {
                model.setValueAt(nuevoNombre, selectrow, 1); // Actualiza el nombre en la tabla
                JOptionPane.showMessageDialog(this, "Fila modificada correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar o no existe el grupo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar consulta SQL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectrow = jTable1.getSelectedRow();
        if (selectrow == -1) {
            JOptionPane.showMessageDialog(this, "Porfavor selecciona una fila ");
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int id_materia = (int) model.getValueAt(selectrow, 0);
        String nombre_materia = (String) model.getValueAt(selectrow, 1);

        jTextField1.setText(nombre_materia);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        new MenuFrame().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    private void Framemenu() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grupoframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
