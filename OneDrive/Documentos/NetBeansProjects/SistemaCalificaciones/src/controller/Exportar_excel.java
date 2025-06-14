package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 

public class Exportar_excel {

    public void exportToExcel(JTable table, String filePath) {
        Workbook workbook = new HSSFWorkbook(); 
        try {
            Sheet sheet = workbook.createSheet("Data");

            TableModel model = table.getModel();

            // Crear encabezados de columna
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }

            // Crear filas de datos
            for (int i = 0; i < model.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    Object value = model.getValueAt(i, j);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                }
            }

            // Escribir el archivo en disco
            try (FileOutputStream fileOut = new FileOutputStream(new File(filePath))) {
                workbook.write(fileOut);
            }

            JOptionPane.showMessageDialog(null, "Datos exportados a Excel exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al exportar datos a Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
}
