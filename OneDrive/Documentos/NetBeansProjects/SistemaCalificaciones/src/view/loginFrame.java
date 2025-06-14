package view;

import controller.Conexion;
import controller.UsuarioDAO;
import javax.swing.JOptionPane;

public class loginFrame extends javax.swing.JFrame {

    private Conexion conexion;

    public loginFrame() {
        initComponents();
        conectarBD();
        centrarFrame();
        estilobtns();
        
    }
 private void estilobtns() {
        // Hacer que el botón sea transparente
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
       // jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        
       
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

    private void conectarBD() {
        try {
            conexion = new Conexion();
            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        Textuser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_user.png"))); // NOI18N
        jLabel1.setText("Usuario:");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setMaximumSize(new java.awt.Dimension(79, 32));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icon_password.png"))); // NOI18N
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        PasswordField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        PasswordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 150, -1));

        Textuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextuserActionPerformed(evt);
            }
        });
        getContentPane().add(Textuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 150, -1));

        jLabel3.setText("CBTIS AcademicReg");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Login.png"))); // NOI18N
        jButton1.setText("Iniciar sesión");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono_de_usuarios.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salir.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 35, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 300, 170, 130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo_login.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String usuario = Textuser.getText();
        String contraseña = new String(PasswordField.getPassword());

// Crear una instancia de UsuarioDAO pasándole la conexión
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexion.getConexion());

// Verificar las credenciales del usuario
        if (usuarioDAO.verificarCredenciales(usuario, contraseña)) {
            JOptionPane.showMessageDialog(this, "¡Bienvenido!" +" "+ usuario);
            this.dispose();

            framematerias();
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextuserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void framematerias() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField Textuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
