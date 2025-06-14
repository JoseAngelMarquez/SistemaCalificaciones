package view;

import controller.Conexion;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class MateriasFrame extends javax.swing.JFrame {

    Conexion conexion;

    public MateriasFrame() {
        initComponents();
        try {
            conexion = new Conexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        centrarFrame();
        // cargarnombregrupo();
        estilobtns();

    }

    private void estilobtns() {
        // Hacer que el botón sea transparente
        jButton8.setOpaque(false);
        jButton8.setContentAreaFilled(false);
        //jButton8.setBorderPainted(false);
        jButton8.setFocusPainted(false);
        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
          jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        //jButton1.setBorderPainted(false);
        //jButton1.setFocusPainted(false);
      
      
    }

    void cargarnombregrupo() {
        List<String> nombres_grupo = obtenernombresgrupo();
        for (String nombre_grupo : nombres_grupo) {
            jComboBox1.addItem(nombre_grupo);
        }
    }

    // Método para obtener nombres de grupos
    private List<String> obtenernombresgrupo() {
        List<String> nombres_grupo = new ArrayList<>();
        String sql = "SELECT nombre_grupo FROM grupo";

        try (PreparedStatement ps = conexion.getConexion().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombre_grupo = rs.getString("nombre_grupo");
                nombres_grupo.add(nombre_grupo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombres_grupo;
    }

    private int getGroupIdByName(String nombreGrupo) {
        int idGrupo = -1;
        String query = "SELECT id_grupo FROM grupo WHERE nombre_grupo = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.getConexion().prepareStatement(query);
            ps.setString(1, nombreGrupo);
            rs = ps.executeQuery();
            if (rs.next()) {
                idGrupo = rs.getInt("id_grupo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener el ID del grupo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cierra ResultSet y PreparedStatement
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return idGrupo;
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

        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaterias = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Textfieldmateria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Textfieldhorario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextFfieldAula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Textfieldsemestre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TextFieldinicio = new javax.swing.JTextField();
        Textfieldfin = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jButton7.setText("Insertar Grupo");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la materia", "Horario", "Aula", "Semestre", "Fecha de inicio", "Fecha de fin", "Grupo"
            }
        ));
        jTableMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMaterias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 222, 1011, 220));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_agrega_materia.png"))); // NOI18N
        jButton2.setText("Agregar Materia");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 476, 170, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_modifica_Materia.png"))); // NOI18N
        jButton3.setText("Modificar materia");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 476, 170, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_mostrar_Materia.png"))); // NOI18N
        jButton4.setText("Mostrar materia");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 476, 170, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_eliminar_Materia.png"))); // NOI18N
        jButton5.setText("Eliminar materia");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(817, 476, 170, -1));

        jLabel1.setText("Nombre de la materia:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        Textfieldmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextfieldmateriaActionPerformed(evt);
            }
        });
        getContentPane().add(Textfieldmateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 162, -1));

        jLabel3.setText("Horario de clase:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 115, -1));

        Textfieldhorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextfieldhorarioActionPerformed(evt);
            }
        });
        getContentPane().add(Textfieldhorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 140, -1));

        jLabel4.setText("Aula:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));
        getContentPane().add(TextFfieldAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 162, -1));

        jLabel5.setText("Semestre:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 62, -1));

        jLabel6.setText("Fecha de inicio:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 93, -1));

        Textfieldsemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextfieldsemestreActionPerformed(evt);
            }
        });
        getContentPane().add(Textfieldsemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 190, 140, -1));

        jLabel7.setText("Fecha de fin:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 93, -1));
        getContentPane().add(TextFieldinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 140, -1));
        getContentPane().add(Textfieldfin, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 140, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_menu.png"))); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));

        jLabel2.setText("Grupo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 41, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 140, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_Grupo.png"))); // NOI18N
        jButton8.setText("Insertar Grupo");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 170, 20));

        jLabel8.setFont(new java.awt.Font("Frank Ruehl CLM", 1, 36)); // NOI18N
        jLabel8.setText("REGISTRO DE MATERIAS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_actualiza_grupo.png"))); // NOI18N
        jButton1.setText("Cargar grupo");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 150, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoContenido.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Obtener los datos de los campos de texto
        String nombre_materia = Textfieldmateria.getText();
        String horario = Textfieldhorario.getText();
        String aula = TextFfieldAula.getText();
        String semestre = Textfieldsemestre.getText();
        String fecha_inicio = TextFieldinicio.getText();
        String fecha_fin = Textfieldfin.getText();

        // Verificar que ningún campo esté vacío
        if (nombre_materia.isEmpty() || horario.isEmpty() || aula.isEmpty() || semestre.isEmpty() || fecha_inicio.isEmpty() || fecha_fin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Algún campo no ha sido llenado, por favor verifica los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el nombre del grupo seleccionado
        String nombreGrupo = (String) jComboBox1.getSelectedItem();
        // Obtener el id_grupo correspondiente
        int idGrupo = getGroupIdByName(nombreGrupo);
        if (idGrupo == -1) {
            JOptionPane.showMessageDialog(this, "Error al obtener el ID del grupo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Validar y convertir fechas
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedInicio = sdf.parse(fecha_inicio);
            Date parsedFin = sdf.parse(fecha_fin);

            // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaInicioSQL = new java.sql.Date(parsedInicio.getTime());
            java.sql.Date fechaFinSQL = new java.sql.Date(parsedFin.getTime());

            // Preparar consulta SQL con PreparedStatement
            String query = "INSERT INTO materias (nombre_materia, horario, aula, semestre, fecha_inicio, fecha_fin, id_grupo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            conexion.setPreparedStatement(query);

            // Establecer parámetros en el PreparedStatement
            conexion.setParameter(1, nombre_materia);
            conexion.setParameter(2, horario);
            conexion.setParameter(3, aula);
            conexion.setParameter(4, semestre);
            conexion.setParameter(5, fechaInicioSQL);
            conexion.setParameter(6, fechaFinSQL);
            conexion.setParameter(7, idGrupo);

            // Ejecutar la consulta de actualización (insert)
            int filasAfectadas = conexion.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Materia agregada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la materia.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException | ParseException e) {
            System.out.println("Error al convertir o parsear la fecha: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    private void TextfieldmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextfieldmateriaActionPerformed

    }//GEN-LAST:event_TextfieldmateriaActionPerformed

    private void TextfieldhorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextfieldhorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextfieldhorarioActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            int selectedRow = jTableMaterias.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Error. No ha seleccionado ninguna fila a eliminar");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTableMaterias.getModel();
            int idMateria = (Integer) model.getValueAt(selectedRow, 0);

            String query = "DELETE FROM materias WHERE id_materia = ?";
            Conexion conexion = new Conexion();
            PreparedStatement ps = null;

            try {
                ps = conexion.getConexion().prepareStatement(query);
                ps.setInt(1, idMateria);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Fila eliminada correctamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la fila.", "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar la fila: " + e.getMessage(), "Error de Eliminación", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Framemenu();
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = jTableMaterias.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccionar una fila para editar");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTableMaterias.getModel();
        Object idMateriaObj = model.getValueAt(selectedRow, 0);
        Object idGrupoObj = model.getValueAt(selectedRow, 7);

        if (!(idMateriaObj instanceof Integer) || !(idGrupoObj instanceof Integer)) {
            JOptionPane.showMessageDialog(this, "ID de materia o ID de grupo inválido");
            return;
        }

        int idMateria = (Integer) idMateriaObj;
        int idGrupo = (Integer) idGrupoObj;

        String nombreMateria = Textfieldmateria.getText();
        String horario = Textfieldhorario.getText();
        String aula = TextFfieldAula.getText();
        String semestre = Textfieldsemestre.getText();
        String fechaInicio = TextFieldinicio.getText();
        String fechaFin = Textfieldfin.getText();

        // Verificar que ningún campo esté vacío
        if (nombreMateria.isEmpty() || horario.isEmpty() || aula.isEmpty() || semestre.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Algún campo no ha sido llenado, por favor verifica los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Validar y convertir fechas
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedInicio = sdf.parse(fechaInicio);
            Date parsedFin = sdf.parse(fechaFin);

            // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaInicioSQL = new java.sql.Date(parsedInicio.getTime());
            java.sql.Date fechaFinSQL = new java.sql.Date(parsedFin.getTime());

            String query = "UPDATE materias SET "
                    + "nombre_materia = ?, "
                    + "horario = ?, "
                    + "aula = ?, "
                    + "semestre = ?, "
                    + "fecha_inicio = ?, "
                    + "fecha_fin = ?, "
                    + "id_grupo = ? "
                    + "WHERE id_materia = ?";

            PreparedStatement ps = null;

            try {
                ps = conexion.getConexion().prepareStatement(query);

                ps.setString(1, nombreMateria);
                ps.setString(2, horario);
                ps.setString(3, aula);
                ps.setString(4, semestre);
                ps.setDate(5, fechaInicioSQL);
                ps.setDate(6, fechaFinSQL);
                ps.setInt(7, idGrupo);
                ps.setInt(8, idMateria);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Elemento modificado con éxito");
                    model.setValueAt(nombreMateria, selectedRow, 1);
                    model.setValueAt(horario, selectedRow, 2);
                    model.setValueAt(aula, selectedRow, 3);
                    model.setValueAt(semestre, selectedRow, 4);
                    model.setValueAt(fechaInicio, selectedRow, 5);
                    model.setValueAt(fechaFin, selectedRow, 6);
                    model.setValueAt(idGrupo, selectedRow, 7);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo modificar el elemento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al modificar el elemento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al parsear la fecha: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void TextfieldsemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextfieldsemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextfieldsemestreActionPerformed

    private void jTableMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMateriasMouseClicked
        int selectedRow = jTableMaterias.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTableMaterias.getModel();

            String nombreMateria = (String) model.getValueAt(selectedRow, 1);
            String horario = (String) model.getValueAt(selectedRow, 2);
            String aula = (String) model.getValueAt(selectedRow, 3);
            String semestre = (String) model.getValueAt(selectedRow, 4);
            String fechaInicio = (String) model.getValueAt(selectedRow, 5);
            String fechaFin = (String) model.getValueAt(selectedRow, 6);
            String idGrupo = String.valueOf(model.getValueAt(selectedRow, 7));

            Textfieldmateria.setText(nombreMateria);
            Textfieldhorario.setText(horario);
            TextFfieldAula.setText(aula);
            Textfieldsemestre.setText(semestre);
            TextFieldinicio.setText(fechaInicio);
            Textfieldfin.setText(fechaFin);

            for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                if (jComboBox1.getItemAt(i).toString().equals(idGrupo)) {
                    jComboBox1.setSelectedIndex(i);
                    break;
                }
            }
        }

    }//GEN-LAST:event_jTableMateriasMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // Preparar consulta SQL para obtener datos, incluyendo id_grupo
            String consulta = "SELECT id_materia, nombre_materia, horario, aula, semestre, fecha_inicio, fecha_fin, id_grupo FROM materias";
            conexion.setPreparedStatement(consulta);

            // Ejecutar consulta y obtener ResultSet
            conexion.executeQuery();
            ResultSet rs = conexion.getResultSet();

            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jTableMaterias.getModel();
            if (model == null) {
                model = new DefaultTableModel();
                jTableMaterias.setModel(model);
            } else {
                model.setRowCount(0); // Limpiar filas existentes
            }

            // Definir las columnas de la tabla, asegúrate de que coincidan con tu modelo de tabla
            model.setColumnIdentifiers(new Object[]{
                "ID Materia", "Nombre Materia", "Horario", "Aula", "Semestre", "Fecha Inicio", "Fecha Fin", "ID Grupo"
            });

            // Procesar resultados del ResultSet y añadir a la tabla
            while (rs.next()) {
                int idMateria = rs.getInt("id_materia");
                String nombreMateria = rs.getString("nombre_materia");
                String horario = rs.getString("horario");
                String aula = rs.getString("aula");
                String semestre = rs.getString("semestre");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFin = rs.getString("fecha_fin");
                int idGrupo = rs.getInt("id_grupo");

                // Agregar fila a la tabla
                Object[] row = {idMateria, nombreMateria, horario, aula, semestre, fechaInicio, fechaFin, idGrupo};
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar consulta SQL: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al ejecutar consulta SQL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        FrameGrupo();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jComboBox1.removeAllItems();
        cargarnombregrupo();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void FrameGrupo() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grupoframe().setVisible(true);
            }
        });
    }

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
                new MateriasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFfieldAula;
    private javax.swing.JTextField TextFieldinicio;
    private javax.swing.JTextField Textfieldfin;
    private javax.swing.JTextField Textfieldhorario;
    private javax.swing.JTextField Textfieldmateria;
    private javax.swing.JTextField Textfieldsemestre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaterias;
    // End of variables declaration//GEN-END:variables
}
