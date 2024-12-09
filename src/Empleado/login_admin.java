/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Empleado;

import Clases.conexion;
import java.sql.*;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class login_admin extends javax.swing.JFrame {

    /**
     * Creates new form login_admin
     */
    int xMouse, yMouse;

    public login_admin() {
        initComponents();

        // Centrar la ventana en la pantalla
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jp_header = new javax.swing.JPanel();
        btn_exit = new javax.swing.JPanel();
        lb_exit = new javax.swing.JLabel();
        btn_empleado = new javax.swing.JPanel();
        lb_empleado = new javax.swing.JLabel();
        btn_admin = new javax.swing.JPanel();
        lb_admin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jp_header.setBackground(new java.awt.Color(255, 255, 255));
        jp_header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jp_headerMouseDragged(evt);
            }
        });
        jp_header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp_headerMousePressed(evt);
            }
        });

        btn_exit.setBackground(new java.awt.Color(255, 255, 255));

        lb_exit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lb_exit.setForeground(new java.awt.Color(51, 51, 51));
        lb_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_exit.setText("X");
        lb_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_exitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_exitLayout = new javax.swing.GroupLayout(btn_exit);
        btn_exit.setLayout(btn_exitLayout);
        btn_exitLayout.setHorizontalGroup(
            btn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        btn_exitLayout.setVerticalGroup(
            btn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        btn_empleado.setBackground(new java.awt.Color(255, 255, 255));

        lb_empleado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_empleado.setForeground(new java.awt.Color(102, 102, 102));
        lb_empleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_empleado.setText("Empleado");
        lb_empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_empleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_empleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_empleadoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_empleadoLayout = new javax.swing.GroupLayout(btn_empleado);
        btn_empleado.setLayout(btn_empleadoLayout);
        btn_empleadoLayout.setHorizontalGroup(
            btn_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_empleado, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );
        btn_empleadoLayout.setVerticalGroup(
            btn_empleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_admin.setBackground(new java.awt.Color(175, 23, 64));

        lb_admin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_admin.setForeground(new java.awt.Color(255, 255, 255));
        lb_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_admin.setText("Admin");

        javax.swing.GroupLayout btn_adminLayout = new javax.swing.GroupLayout(btn_admin);
        btn_admin.setLayout(btn_adminLayout);
        btn_adminLayout.setHorizontalGroup(
            btn_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btn_adminLayout.setVerticalGroup(
            btn_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_headerLayout = new javax.swing.GroupLayout(jp_header);
        jp_header.setLayout(jp_headerLayout);
        jp_headerLayout.setHorizontalGroup(
            jp_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_headerLayout.createSequentialGroup()
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 278, Short.MAX_VALUE))
        );
        jp_headerLayout.setVerticalGroup(
            jp_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jp_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(btn_admin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_empleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 43, 82));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ParkCar");

        txt_usuario.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(102, 102, 102));
        txt_usuario.setText("Ingrese su nombre de usuario");
        txt_usuario.setBorder(null);
        txt_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_usuarioMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel4.setText("Usuario");

        txt_pass.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(102, 102, 102));
        txt_pass.setText("********");
        txt_pass.setBorder(null);
        txt_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_passMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel5.setText("Contraseña");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_usuario)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_pass)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)))
                    .addComponent(jp_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jp_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 129, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //--------------------------------------Personaliza boton exit --------------------------------------------------------------
    private void lb_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exitMouseClicked
        // Configura el boton salir 
        System.exit(0);
    }//GEN-LAST:event_lb_exitMouseClicked

    private void lb_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exitMouseEntered
        //Cuando el mouse pasa encima    rgb(116, 9, 56)
        btn_exit.setBackground(new Color(116, 9, 56)); //parecido a rojo bajito
        lb_exit.setForeground(Color.white);
    }//GEN-LAST:event_lb_exitMouseEntered

    private void lb_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exitMouseExited
        btn_exit.setBackground(Color.white);
        lb_exit.setForeground(Color.black);
    }//GEN-LAST:event_lb_exitMouseExited
// ---------------------------------------- Configuracion para que se mueva la ventana -------------------------------------------
    private void jp_headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jp_headerMouseDragged

    private void jp_headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jp_headerMousePressed

    // ----------------------------------- Confira el boton empleado -------------------------------------------------------------------
    private void lb_empleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_empleadoMouseEntered
        btn_empleado.setBackground(new Color(204, 43, 82)); //parecido a rojo bajito rgb(204, 43, 82)
        lb_empleado.setForeground(Color.white);
    }//GEN-LAST:event_lb_empleadoMouseEntered

    private void lb_empleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_empleadoMouseExited
        btn_empleado.setBackground(Color.white);
        lb_empleado.setForeground(new Color(60, 63, 65)); // gris [60,63,65]
    }//GEN-LAST:event_lb_empleadoMouseExited

    private void lb_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_empleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_empleadoMouseClicked
// ---------------------------------------- Configura las cajas de texto -----------------------------------------------------------------
    private void txt_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usuarioMousePressed
        if (txt_usuario.getText().equals("Ingrese su nombre de usuario")) {
            txt_usuario.setText("");
            txt_usuario.setForeground(Color.black);
        }
        if (String.valueOf(txt_pass.getPassword()).isEmpty()) {
            txt_pass.setText("********");
            txt_pass.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txt_usuarioMousePressed

    private void txt_passMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passMousePressed
        if (String.valueOf(txt_pass.getPassword()).equals("********")) {
            txt_pass.setText("");
            txt_pass.setForeground(Color.black);
        }
        if (txt_usuario.getText().isEmpty()) {
            txt_usuario.setText("Ingrese su nombre de usuario");
            txt_usuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txt_passMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_admin;
    private javax.swing.JPanel btn_empleado;
    private javax.swing.JPanel btn_exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jp_header;
    private javax.swing.JLabel lb_admin;
    private javax.swing.JLabel lb_empleado;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}