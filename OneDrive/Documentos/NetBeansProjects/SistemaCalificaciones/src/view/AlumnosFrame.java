package view;

import controller.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class AlumnosFrame extends javax.swing.JFrame {

    Conexion conexion;
    DefaultTableModel JtTable1;

    public AlumnosFrame() {
        initComponents();
        try {
            conexion = new Conexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Cargar datos en los JComboBox
        cargarnombregrupo();
        centrarFrame();
        estilobtns();
                jButton6.setEnabled(false); // Inicialmente deshabilitado

    }

    private void estilobtns() {
        // Hacer que el botón sea transparente
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
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

    void cargarnombregrupo() {
        List<String> nombres_materias = obtenernombresmateria();
        for (String nombre_materia : nombres_materias) {
            jComboBox1.addItem(nombre_materia);
        }
    }

    // Método para obtener nombres de grupos
    private List<String> obtenernombresmateria() {
        List<String> nombres_materia = new ArrayList<>();
        String sql = "SELECT nombre_materia FROM materias";

        try (PreparedStatement ps = conexion.getConexion().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombre_materia = rs.getString("nombre_materia");
                nombres_materia.add(nombre_materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombres_materia;
    }

    // Método para cerrar la conexión al cerrar la ventana
    private void cerrarConexion() {
        if (conexion != null) {
            conexion.closeConnection();
        }
    }

    private int getMateriaIdByName(String nombreGrupo) {
        int idMateria = -1;
        String query = "SELECT id_materia FROM materias WHERE nombre_materia = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.getConexion().prepareStatement(query);
            ps.setString(1, nombreGrupo);
            rs = ps.executeQuery();
            if (rs.next()) {
                idMateria = rs.getInt("id_materia");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener el ID de la materia: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        return idMateria;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablealumno = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_añadir_Alumno.png"))); // NOI18N
        jButton2.setText("Insertar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 125, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_editar_Alumno.png"))); // NOI18N
        jButton3.setText("Modificar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 125, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_buscar_Alumno.png"))); // NOI18N
        jButton4.setText("Mostrar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 125, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_eliminar_Alumno.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 520, 125, -1));

        jTablealumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nombre ", "Apellido", "Materia", "Parcial 1", "Parcial 2", "Parcial 3", "Promedio", "Email", "Dirección", "Teléfono", "Localidad"
            }
        ));
        jTablealumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablealumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablealumno);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 276, 968, 140));

        jLabel2.setText("Matricula del alumno:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 91, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 87, 206, -1));

        jLabel3.setText("Nombre del alumno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 129, 121, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 125, 206, -1));

        jLabel4.setText("Apellido del alumno:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 167, 121, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 167, 206, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 135, -1));

        jLabel5.setFont(new java.awt.Font("Frank Ruehl CLM", 1, 36)); // NOI18N
        jLabel5.setText("REGISTRO DE ALUMNOS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 18, -1, -1));

        jLabel1.setText("Materia:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 216, 49, -1));

        jLabel6.setText("Parcial 1:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        jLabel7.setText("Parcial 2:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, -1));

        jLabel8.setText("Parcial 3:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 90, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 90, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 90, -1));

        jLabel9.setText("Promedio final:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 89, -1));

        jTextField7.setEnabled(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 152, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_menu.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, -1, -1));

        jLabel10.setText("Correo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 209, 49, -1));
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 210, 278, -1));

        jLabel11.setText("Dirección:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 71, -1));

        jLabel12.setText("Localidad:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 62, -1));

        jLabel13.setText("Teléfono:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 62, -1));
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 166, -1));
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 169, -1));
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 169, -1));

        jButton6.setText("Agregar información");
        jButton6.setPreferredSize(new java.awt.Dimension(87, 40));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 160, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoContenido.jpg"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Conexion conexion = null; // Asegúrate de que la conexión esté activa
        try {
            conexion = new Conexion(); // Inicializa la conexión aquí

            int selecrow = jTablealumno.getSelectedRow();
            if (selecrow == -1) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona la fila que deseas eliminar");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTablealumno.getModel();
            String matriculaStr = (String) model.getValueAt(selecrow, 0);
            int matricula = Integer.parseInt(matriculaStr); // Convertir el valor a int 
            String nombre = (String) model.getValueAt(selecrow, 1);
            String apellido = (String) model.getValueAt(selecrow, 2);
            String materia = (String) model.getValueAt(selecrow, 3);

            String query = "DELETE FROM alumno WHERE matricula_alumno = ?";
            conexion.setPreparedStatement(query);
            conexion.setParameter(1, matricula);

            int filas_afectadas = conexion.executeUpdate();
            if (filas_afectadas > 0) {
                model.removeRow(selecrow);
                System.out.println("Fila eliminada");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar o no existe ese alumno");
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                conexion.closeConnection();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String query = "INSERT INTO alumno (matricula_alumno, nombre, apellido, "
                + " id_materia, parcial1, parcial2, parcial3,"
                + " promedio, email, direccion, telefono, localidad)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Conexion conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = new Conexion();
            ps = conexion.getConexion().prepareStatement(query);

            String matriculastr = jTextField2.getText();
            String nombre_alumno = jTextField3.getText();
            String apellido_alumno = jTextField4.getText();
            String nombreMateria = (String) jComboBox1.getSelectedItem();
            String email = jTextField8.getText();
            String direccin = jTextField9.getText();
            String telefono = jTextField10.getText();
            String localidad = jTextField10.getText();

            // Validar que los campos no estén vacíos
            if (matriculastr.isEmpty() || nombre_alumno.isEmpty() || apellido_alumno.isEmpty()
                    || nombreMateria.isEmpty() || email.isEmpty() || direccin.isEmpty()
                    || telefono.isEmpty() || localidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se han llenado todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idMateria = getMateriaIdByName(nombreMateria);
            double parcial1, parcial2, parcial3;

            // Validar y convertir los parciales a números
            try {
                parcial1 = Double.parseDouble(jTextField1.getText());
                parcial2 = Double.parseDouble(jTextField5.getText());
                parcial3 = Double.parseDouble(jTextField6.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Los parciales deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Validar que los parciales estén en el rango 0-10
            if (parcial1 < 0 || parcial1 > 10 || parcial2 < 0 || parcial2 > 10 || parcial3 < 0 || parcial3 > 10) {
                JOptionPane.showMessageDialog(this, "Los parciales deben estar en el rango de 0 a 10.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double promedioFinal = (parcial1 + parcial2 + parcial3) / 3;

            // Convertir la matrícula a entero
            int matricula;
            try {
                matricula = Integer.parseInt(matriculastr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La matrícula debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ps.setInt(1, matricula);
            ps.setString(2, nombre_alumno);
            ps.setString(3, apellido_alumno);
            ps.setInt(4, idMateria);
            ps.setDouble(5, parcial1);
            ps.setDouble(6, parcial2);
            ps.setDouble(7, parcial3);
            ps.setDouble(8, promedioFinal);
            ps.setString(9, email);
            ps.setString(10, direccin);
            ps.setString(11, telefono);
            ps.setString(12, localidad);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Alumno agregado exitosamente.");
                JOptionPane.showMessageDialog(this, "Alumno agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el alumno.");
                JOptionPane.showMessageDialog(this, "No se pudo agregar el alumno.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al insertar el alumno en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar los recursos
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                conexion.closeConnection();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Conexion conexion = null;
        PreparedStatement ps = null;
        try {
            conexion = new Conexion();

            int selectrow = jTablealumno.getSelectedRow();
            if (selectrow == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona una fila a editar");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTablealumno.getModel();
            String matriculaStr = (String) model.getValueAt(selectrow, 0);
            int matricula = Integer.parseInt(matriculaStr);
            String nombreact = jTextField3.getText();
            String apellidoact = jTextField4.getText();
            String MateriaSeleccionada = (String) jComboBox1.getSelectedItem();
            // Obtener los valores de parciales desde la interfaz
            double parcial1 = Double.parseDouble(jTextField1.getText());
            double parcial2 = Double.parseDouble(jTextField5.getText());
            double parcial3 = Double.parseDouble(jTextField6.getText());

            // Calcular el promedio
            double promedio = (parcial1 + parcial2 + parcial3) / 3;
            String correo = jTextField8.getText();
            String direccion = jTextField9.getText();
            String telefono = jTextField10.getText();
            String localidad = jTextField11.getText();

            // Obtener el ID de la materia
            int idMateria = getMateriaIdByName(MateriaSeleccionada);
            if (idMateria == -1) {
                JOptionPane.showMessageDialog(this, "La materia seleccionada no existe.");
                return;
            }

            String query = "UPDATE alumno SET nombre = ?, apellido = ?, id_materia = ?,"
                    + " parcial1 = ?, parcial2 = ?, parcial3 = ?, promedio = ?, "
                    + "email = ?, direccion = ?, telefono = ?, localidad = ? "
                    + "WHERE matricula_alumno = ?";

            // Asegúrate de que tu clase Conexion tiene un método getConexion() que retorna una Connection
            ps = conexion.getConexion().prepareStatement(query);
            ps.setString(1, nombreact);
            ps.setString(2, apellidoact);
            ps.setInt(3, idMateria);
            ps.setDouble(4, parcial1);
            ps.setDouble(5, parcial2);
            ps.setDouble(6, parcial3);
            ps.setDouble(7, promedio);
            ps.setString(8, correo);
            ps.setString(9, direccion);
            ps.setString(10, telefono);
            ps.setString(11, localidad);
            ps.setInt(12, matricula);

            int filas_afectadas = ps.executeUpdate();
            if (filas_afectadas > 0) {
                model.setValueAt(nombreact, selectrow, 1);
                model.setValueAt(apellidoact, selectrow, 2);
                model.setValueAt(MateriaSeleccionada, selectrow, 3);
                model.setValueAt(parcial1, selectrow, 4);
                model.setValueAt(parcial2, selectrow, 5);
                model.setValueAt(parcial3, selectrow, 6);
                model.setValueAt(promedio, selectrow, 7);
                model.setValueAt(correo, selectrow, 8);
                model.setValueAt(direccion, selectrow, 9);
                model.setValueAt(telefono, selectrow, 10);
                model.setValueAt(localidad, selectrow, 11);
                JOptionPane.showMessageDialog(rootPane, "Fila actualizada");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar o no existe ese alumno.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null && conexion.getConexion() != null) {
                    conexion.getConexion().close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // Consulta SQL para obtener los datos de los alumnos, incluyendo calificaciones y promedio
            String consulta = "SELECT a.matricula_alumno, a.nombre, a.apellido, m.nombre_materia, "
                    + "a.parcial1, a.parcial2, a.parcial3, "
                    + "(a.parcial1 + a.parcial2 + a.parcial3) / 3 AS promedio, a.email,a.direccion,a.telefono,a.localidad "
                    + "FROM alumno a "
                    + "JOIN materias m ON a.id_materia = m.id_materia";

            // Crear la conexión y preparar la consulta
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);

            // Ejecutar la consulta y obtener el ResultSet
            ResultSet rs = ps.executeQuery();

            // Obtener el modelo de la tabla y limpiar las filas existentes
            DefaultTableModel model = (DefaultTableModel) jTablealumno.getModel();
            model.setRowCount(0);

            // Iterar sobre el ResultSet y añadir las filas al modelo de la tabla
            while (rs.next()) {
                // Obtener los datos de la fila actual
                String matricula_alumno = rs.getString("matricula_alumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String materia = rs.getString("nombre_materia");
                double parcial1 = rs.getDouble("parcial1");
                double parcial2 = rs.getDouble("parcial2");
                double parcial3 = rs.getDouble("parcial3");
                double promedio = rs.getDouble("promedio");
                String correo = rs.getString("email");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String localidad = rs.getString("localidad");

                // Crear una nueva fila con los datos obtenidos
                Object[] row = {matricula_alumno, nombre, apellido, materia,
                    parcial1, parcial2, parcial3, promedio, correo,
                    direccion, telefono, localidad};

                // Añadir la fila al modelo de la tabla
                model.addRow(row);
            }

            // Cerrar el ResultSet y PreparedStatement
            rs.close();
            ps.close();
            conexion.closeConnection();

        } catch (SQLException e) {
            // Manejo de excepciones SQL
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Manejo de otras excepciones
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTablealumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablealumnoMouseClicked
// Obtener la fila seleccionada
        int row = jTablealumno.getSelectedRow();

// Verificar que la selección no esté vacía
        if (row != -1) {
            DefaultTableModel model = (DefaultTableModel) jTablealumno.getModel();

            // Obtener los datos de la fila seleccionada
            String matricula = (String) model.getValueAt(row, 0); // Asume que la matrícula está en la primera columna
            String nombre = (String) model.getValueAt(row, 1);    // Asume que el nombre está en la segunda columna
            String apellido = (String) model.getValueAt(row, 2);  // Asume que el apellido está en la tercera columna
            String materia = (String) model.getValueAt(row, 3);     // Asume que la materia está en la cuarta columna
            Double parcial1 = (Double) model.getValueAt(row, 4);    // Asume que parcial1 está en la quinta columna
            Double parcial2 = (Double) model.getValueAt(row, 5);    // Asume que parcial2 está en la sexta columna
            Double parcial3 = (Double) model.getValueAt(row, 6);    // Asume que parcial3 está en la séptima columna
            String correo = (String) model.getValueAt(row, 8);
            String direccion = (String) model.getValueAt(row, 9);
            String telefono = (String) model.getValueAt(row, 10);
            String localidad = (String) model.getValueAt(row, 11);
            // Calcular el promedio en base a los parciales
            Double promedio = (parcial1 + parcial2 + parcial3) / 3;

            // Establecer los datos en los campos correspondientes
            jTextField2.setText(matricula);
            jTextField3.setText(nombre);
            jTextField4.setText(apellido);

            // Convertir los valores de parciales a String para mostrarlos en los campos de texto
            jTextField1.setText(String.valueOf(parcial1));
            jTextField5.setText(String.valueOf(parcial2));
            jTextField6.setText(String.valueOf(parcial3));
            jComboBox1.setSelectedItem(materia);
            jTextField7.setText(String.valueOf(promedio));
            jTextField8.setText(correo);
            jTextField9.setText(direccion);
            jTextField10.setText(telefono);
            jTextField11.setText(localidad);
           
            jButton6.setEnabled(true);

        }


    }//GEN-LAST:event_jTablealumnoMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Framemenu();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        FrameTutor();
        
    }//GEN-LAST:event_jButton6ActionPerformed

     private void FrameTutor() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tutoresframe().setVisible(true);
            }
        });
    }
    
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
                new AlumnosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablealumno;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
