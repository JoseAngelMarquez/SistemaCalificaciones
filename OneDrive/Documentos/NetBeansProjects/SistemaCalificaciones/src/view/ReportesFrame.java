
package view;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import controller.Exportar_excel;
import controller.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ReportesFrame extends javax.swing.JFrame {

     private Exportar_excel reportGenerator;
    private Conexion conexion;

    public ReportesFrame() {
        initComponents();
         reportGenerator = new Exportar_excel();
        try {
            this.conexion = new Conexion();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

 

    private void exportarDatos() {
        // Obtener los datos de la base de datos
        DefaultTableModel modelo = obtenerDatosDeBaseDeDatos();
        if (modelo == null) {
            JOptionPane.showMessageDialog(this, "No se pudieron obtener los datos para exportar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un JTable temporal con los datos
        JTable tabla = new JTable(modelo);

        // Mostrar un cuadro de diálogo para elegir la ubicación del archivo
        JFileChooser selectorDeArchivos = new JFileChooser();
        int resultado = selectorDeArchivos.showSaveDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String rutaArchivo = selectorDeArchivos.getSelectedFile().getAbsolutePath();
            if (!rutaArchivo.endsWith(".xlsx")) {
                rutaArchivo += ".xlsx";
            }
            reportGenerator.exportToExcel(tabla, rutaArchivo);
        }
    }

    private DefaultTableModel obtenerDatosDeBaseDeDatos() {
        DefaultTableModel modelo = null;
        String consulta = "SELECT matricula_alumno, nombre, apellido, nombre_materia, " +
                          "parcial1, parcial2, parcial3, (parcial1 + parcial2 + parcial3) / 3 AS promedio " +
                          "FROM alumno a " +
                          "JOIN materias m ON a.id_materia = m.id_materia";

        try (PreparedStatement ps = conexion.getConexion().prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            // Obtener los metadatos de la consulta
            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = metaData.getColumnCount();

            // Crear el modelo de la tabla
            modelo = new DefaultTableModel();
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(metaData.getColumnName(i));
            }

            // Llenar el modelo de la tabla con los datos
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Reporte1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(445, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButton1)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        exportarDatos();

    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
