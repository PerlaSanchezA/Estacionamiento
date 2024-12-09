/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package estacionamiento;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Vanessa
 */
public class bienvenida extends javax.swing.JFrame {

    /**
     * Creates new form bienvenida
     */
    public bienvenida() {
        initComponents();

        //Metodos para la barra de progreso
        personalizarInterfaz();
        iniciarCarga();

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

    }

// Método para personalizar la barra de progreso
private void personalizarInterfaz() {
    // Configurar barra de progreso
    barraprogreso.setStringPainted(true);
    barraprogreso.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Fuente moderna
    barraprogreso.setForeground(new Color(151, 254, 237)); // Verde suave
    barraprogreso.setBackground(new Color(11, 102, 106)); // Fondo oscuro
    
    barraprogreso.setIndeterminate(false);
    
    // Cambiar bordes con un Border redondeado
    barraprogreso.setBorder(new javax.swing.border.AbstractBorder() {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(52, 152, 219)); // Azul suave
            g2.drawRoundRect(x, y, width - 1, height - 1, 20, 20); // Bordes redondeados
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 4, 4, 4); // Espaciado interno del borde
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    });

    // Usar BasicProgressBarUI para personalizar la barra de progreso
    barraprogreso.setUI(new javax.swing.plaf.basic.BasicProgressBarUI() {
        @Override
        protected void paintDeterminate(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = c.getWidth();
            int height = c.getHeight();
            int arcSize = height; // Usamos la altura para el radio de las esquinas

            // Fondo de la barra redondeada (verde oscuro)
            g2.setColor(new Color(11, 102, 106)); // Fondo oscuro
            g2.fillRoundRect(0, 0, width, height, arcSize, arcSize); // Fondo con bordes redondeados

            // Dibujar progreso redondeado
            int progressWidth = (int) (barraprogreso.getPercentComplete() * width);
            if (progressWidth > 0) {
                g2.setColor(new Color(151, 254, 237)); // Color del progreso
                g2.fillRoundRect(0, 0, progressWidth, height, arcSize, arcSize); // Progreso con bordes redondeados
            }

            // Dibujar texto del porcentaje
            String progressText = barraprogreso.getString();
            if (barraprogreso.isStringPainted() && progressText != null) {
                g2.setFont(barraprogreso.getFont());

                // Cambiar color del texto según el progreso
                if (barraprogreso.getPercentComplete() < 0.45) {
                    g2.setColor(Color.WHITE); // Blanco antes del 45%
                } else {
                    g2.setColor(new Color(0, 51, 102)); // Gris oscuro desde el 45%
                }

                FontMetrics fm = g2.getFontMetrics();
                int stringWidth = fm.stringWidth(progressText);
                int stringHeight = fm.getAscent();
                int textX = (width - stringWidth) / 2;
                int textY = (height + stringHeight) / 2 - 2;
                g2.drawString(progressText, textX, textY); // Dibujar el texto
            }
        }

        @Override
        protected void paintIndeterminate(Graphics g, JComponent c) {
            // Modo indeterminado: personalizar si es necesario
            paintDeterminate(g, c);
        }
    });

        // Centrar la barra de progreso en el JFrame
        int x = (getWidth() - barraprogreso.getWidth()) / 2;
        int y = (getHeight() - barraprogreso.getHeight()) / 2;
        barraprogreso.setLocation(x, y);

        // Animación de "Cargando..." para jLabel1
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jLabel1.setForeground(new Color(15, 16, 53)); // Color del texto 
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Asegura que el texto esté centrado

        // Timer para animar el texto de "Cargando..."
        new Timer(500, e -> {
            String text = jLabel1.getText();
            jLabel1.setText(text.equals("Cargando...") ? "Cargando" : text + ".");
        }).start();
    }

    //Configura la barra de progreso para que funcione
    private void iniciarCarga() {
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50); // Simula tiempo de carga
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                barraprogreso.setValue(i); // Actualiza el progreso
            }
            abrirDashboard(); // Llama al dashboard al terminar
        }).start();
    }

    private void abrirDashboard() {
        dispose(); // Cierra esta ventana
        new ADMIN.login_admin().setVisible(true); // Abre el Dashboard
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_fondo = new javax.swing.JPanel();
        lb_img = new javax.swing.JLabel();
        barraprogreso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jp_fondo.setBackground(new java.awt.Color(206, 226, 226));

        lb_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/GIFcarro (1).gif"))); // NOI18N

        barraprogreso.setForeground(new java.awt.Color(0, 0, 0));
        barraprogreso.setBorder(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cargando...");

        javax.swing.GroupLayout jp_fondoLayout = new javax.swing.GroupLayout(jp_fondo);
        jp_fondo.setLayout(jp_fondoLayout);
        jp_fondoLayout.setHorizontalGroup(
            jp_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_fondoLayout.createSequentialGroup()
                .addGroup(jp_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_fondoLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_fondoLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(barraprogreso, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_fondoLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(lb_img)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jp_fondoLayout.setVerticalGroup(
            jp_fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_fondoLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lb_img, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraprogreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraprogreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jp_fondo;
    private javax.swing.JLabel lb_img;
    // End of variables declaration//GEN-END:variables
}
