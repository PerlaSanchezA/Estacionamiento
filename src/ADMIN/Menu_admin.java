/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ADMIN;

import Clases.conexion;
import java.sql.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Vanessa
 */
public class Menu_admin extends javax.swing.JFrame {

    /**
     * Creates new form Menu_admin
     */
    private HashMap<Integer, JPanel> panelMap = new HashMap<>();
    int xMouse, yMouse;
    
    conexion consultas=new conexion();
   
    public Menu_admin() {
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());  // O puedes usar FlatLightLaf para el modo claro
        } catch (UnsupportedLookAndFeelException e) {
        }
         
        initComponents();   
        
        mapearPaneles(); // Llenar el mapa de paneles
        actualizarColores(); // Actualizar los colores según la base de datos
        
        consultas.RellenarComboBox("estacionamiento", "id_estacionamiento",CB_estacionamiento);
        tiempo(); //Lama el metodo para mostrarlo
        
    }
    
    // Metodo para obener nombre de usuario 
    public void setNombreUsuario(String nombreUsuario) {
        lb_nombreUsuario.setText("Bienvenido, " + nombreUsuario);
    }
    
    // Metodo para obtener la hora y fecha actual
    public void tiempo(){
          Timer timer = new Timer(1000, e -> {
            java.util.Date date = new java.util.Date();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = dateFormatter.format(date);
            lb_fecha.setText(formattedDate);

            SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss a");
            String formattedTime = timeFormatter.format(date);
            lb_tiempo.setText(formattedTime);

            
        });
        timer.start();
     }
    
    //lugares del estacionamiento
    
     private void mapearPaneles() {
        // Asocia cada panel con su ID correspondiente
        panelMap.put(1, jp1);
        panelMap.put(2, jp2);
        panelMap.put(3, jp3);
        panelMap.put(4, jp4);
        panelMap.put(5, jp5);
        panelMap.put(6, jp6);
        panelMap.put(7, jp7);
        panelMap.put(8, jp8);
        panelMap.put(9, jp9);
        panelMap.put(10, jp10);
        panelMap.put(11, jp11);
        panelMap.put(12, jp12);
        panelMap.put(13, jp13);
        panelMap.put(14, jp14);
        panelMap.put(15, jp15);
        panelMap.put(16, jp16);
        panelMap.put(17, jp17);
        panelMap.put(18, jp18);
        panelMap.put(19, jp19);
        panelMap.put(20, jp20);
        panelMap.put(21, jp21);
        panelMap.put(22, jp22);
        panelMap.put(23, jp23);
        panelMap.put(24, jp24);
        panelMap.put(25, jp25);
        panelMap.put(26, jp26);
        panelMap.put(27, jp27);
        panelMap.put(28, jp28);
        panelMap.put(29, jp29);
        panelMap.put(30, jp30);
        // Continúa agregando todos los paneles...
    }
    
    private void actualizarColores() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = conexion.getConection(); // Llama a tu clase conexión
            if (con != null) {
                String query = "SELECT id_espacio, estado FROM espacio_lugar WHERE id_estacionamiento = 123";
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int idEspacio = rs.getInt("id_espacio");
                    String estado = rs.getString("estado");

                    // Cambiar el color según el estado
                    JPanel panel = panelMap.get(idEspacio);
                    if (panel != null) {
                        if (estado.equalsIgnoreCase("Disponible")) {
                            panel.setBackground(Color.GREEN);
                        } else if (estado.equalsIgnoreCase("Ocupado")) {
                            panel.setBackground(Color.RED);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JPanel();
        lb_exit = new javax.swing.JLabel();
        btn_minmax = new javax.swing.JPanel();
        lb_minmax = new javax.swing.JLabel();
        btn_min = new javax.swing.JPanel();
        lb_min = new javax.swing.JLabel();
        lb_tiempo = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();
        lb_nombreUsuario = new javax.swing.JLabel();
        IZQ2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_usuarios = new Clases.PanelRound();
        lb_usuarios = new javax.swing.JLabel();
        btn_Membresia = new Clases.PanelRound();
        lb_membresia = new javax.swing.JLabel();
        btn_registros = new Clases.PanelRound();
        lb_registros = new javax.swing.JLabel();
        btn_HorayFracc = new Clases.PanelRound();
        lb_HorayFraccion = new javax.swing.JLabel();
        btn_Lugares = new Clases.PanelRound();
        lb_lugares = new javax.swing.JLabel();
        btn_SalVehiculos = new Clases.PanelRound();
        lb_salidaVehiculos = new javax.swing.JLabel();
        btn_cerrarsesion = new Clases.PanelRound();
        lb_cerrarsesion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_vehiculo = new Clases.PanelRound();
        lb_vehiculo = new javax.swing.JLabel();
        centro = new javax.swing.JPanel();
        jp_principal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jp_usuarios = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lb_estac = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_iduser = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_curp = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        CB_estacionamiento = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btn_registrar = new Clases.PanelRound();
        lb_registrar = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txt_telefono = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        cmbRol1 = new javax.swing.JComboBox<>();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jp_vehiculo = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        btn_registrarV = new Clases.PanelRound();
        lb_registrarV = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jp_membresia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator14 = new javax.swing.JSeparator();
        jTextField5 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        btn_registrarMD = new Clases.PanelRound();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jp_registros = new javax.swing.JPanel();
        jp_HorayFraccion = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel43 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        panelRound1 = new Clases.PanelRound();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        jp_lugares = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jp6 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jSeparator28 = new javax.swing.JSeparator();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator31 = new javax.swing.JSeparator();
        jp30 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jp2 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jp4 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jp5 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jp1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jp7 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jp8 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jp9 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jp10 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jp11 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jp12 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jp13 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jp14 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jp15 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jp16 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jp17 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jp18 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jp19 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jp20 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jp21 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jp22 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jp23 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jp24 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jp25 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jp26 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jp27 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jp28 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jp29 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jp_salidaVehiculos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header.setBackground(new java.awt.Color(175, 23, 64));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 32, 78));
        jPanel9.setPreferredSize(new java.awt.Dimension(200, 17));

        jLabel8.setFont(new java.awt.Font("Soberana Sans", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("La estación");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_exit.setBackground(new java.awt.Color(175, 23, 64));

        lb_exit.setBackground(new java.awt.Color(175, 23, 64));
        lb_exit.setFont(new java.awt.Font("Soberana Sans", 0, 14)); // NOI18N
        lb_exit.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_exitLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        btn_exitLayout.setVerticalGroup(
            btn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btn_minmax.setBackground(new java.awt.Color(175, 23, 64));

        lb_minmax.setBackground(new java.awt.Color(175, 23, 64));
        lb_minmax.setFont(new java.awt.Font("Soberana Sans", 0, 24)); // NOI18N
        lb_minmax.setForeground(new java.awt.Color(255, 255, 255));
        lb_minmax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_minmax.setText("/");
        lb_minmax.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_minmax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_minmaxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_minmaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_minmaxMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_minmaxLayout = new javax.swing.GroupLayout(btn_minmax);
        btn_minmax.setLayout(btn_minmaxLayout);
        btn_minmaxLayout.setHorizontalGroup(
            btn_minmaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_minmaxLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lb_minmax, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        btn_minmaxLayout.setVerticalGroup(
            btn_minmaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_minmax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        btn_min.setBackground(new java.awt.Color(175, 23, 64));

        lb_min.setBackground(new java.awt.Color(175, 23, 64));
        lb_min.setFont(new java.awt.Font("Soberana Sans", 0, 18)); // NOI18N
        lb_min.setForeground(new java.awt.Color(255, 255, 255));
        lb_min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_min.setText("-");
        lb_min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_min.setFocusable(false);
        lb_min.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lb_min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_minMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_minLayout = new javax.swing.GroupLayout(btn_min);
        btn_min.setLayout(btn_minLayout);
        btn_minLayout.setHorizontalGroup(
            btn_minLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_minLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lb_min, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );
        btn_minLayout.setVerticalGroup(
            btn_minLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lb_tiempo.setBackground(new java.awt.Color(187, 187, 187));
        lb_tiempo.setFont(new java.awt.Font("Soberana Sans", 0, 14)); // NOI18N
        lb_tiempo.setForeground(new java.awt.Color(204, 204, 204));
        lb_tiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tiempo.setText("hh:mm:ss am");

        lb_fecha.setFont(new java.awt.Font("Soberana Sans", 0, 14)); // NOI18N
        lb_fecha.setForeground(new java.awt.Color(204, 204, 204));
        lb_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_fecha.setText("dd/mm/yyyy");

        lb_nombreUsuario.setFont(new java.awt.Font("Louis George Cafe", 1, 12)); // NOI18N
        lb_nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lb_nombreUsuario.setText("user");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lb_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lb_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(btn_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_minmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(btn_minmax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        IZQ2.setBackground(new java.awt.Color(0, 34, 77));
        IZQ2.setPreferredSize(new java.awt.Dimension(200, 502));

        jSeparator1.setBackground(new java.awt.Color(222, 124, 125));
        jSeparator1.setForeground(new java.awt.Color(222, 124, 125));

        btn_usuarios.setBackground(new java.awt.Color(0, 34, 77));
        btn_usuarios.setForeground(new java.awt.Color(204, 204, 204));
        btn_usuarios.setRoundBottomLeft(37);
        btn_usuarios.setRoundTopLeft(37);
        btn_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_usuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_usuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_usuariosMouseExited(evt);
            }
        });

        lb_usuarios.setBackground(new java.awt.Color(255, 255, 255));
        lb_usuarios.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_usuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_usuarios.setText("USUARIOS");
        lb_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_usuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_usuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_usuariosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_usuariosLayout = new javax.swing.GroupLayout(btn_usuarios);
        btn_usuarios.setLayout(btn_usuariosLayout);
        btn_usuariosLayout.setHorizontalGroup(
            btn_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_usuariosLayout.setVerticalGroup(
            btn_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        btn_Membresia.setBackground(new java.awt.Color(0, 34, 77));
        btn_Membresia.setRoundBottomLeft(37);
        btn_Membresia.setRoundTopLeft(37);

        lb_membresia.setBackground(new java.awt.Color(187, 187, 187));
        lb_membresia.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_membresia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_membresia.setText("Membresia");
        lb_membresia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_membresiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_membresiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_membresiaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_MembresiaLayout = new javax.swing.GroupLayout(btn_Membresia);
        btn_Membresia.setLayout(btn_MembresiaLayout);
        btn_MembresiaLayout.setHorizontalGroup(
            btn_MembresiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_membresia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_MembresiaLayout.setVerticalGroup(
            btn_MembresiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_membresia, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        btn_registros.setBackground(new java.awt.Color(0, 34, 77));
        btn_registros.setRoundBottomLeft(37);
        btn_registros.setRoundTopLeft(37);

        lb_registros.setBackground(new java.awt.Color(187, 187, 187));
        lb_registros.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_registros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_registros.setText("Registros");
        lb_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_registrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_registrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_registrosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_registrosLayout = new javax.swing.GroupLayout(btn_registros);
        btn_registros.setLayout(btn_registrosLayout);
        btn_registrosLayout.setHorizontalGroup(
            btn_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_registrosLayout.setVerticalGroup(
            btn_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registros, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        btn_HorayFracc.setBackground(new java.awt.Color(0, 34, 77));
        btn_HorayFracc.setRoundBottomLeft(37);
        btn_HorayFracc.setRoundTopLeft(37);

        lb_HorayFraccion.setBackground(new java.awt.Color(187, 187, 187));
        lb_HorayFraccion.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_HorayFraccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HorayFraccion.setText("Hora y fracción");
        lb_HorayFraccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_HorayFraccionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_HorayFraccionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_HorayFraccionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_HorayFraccLayout = new javax.swing.GroupLayout(btn_HorayFracc);
        btn_HorayFracc.setLayout(btn_HorayFraccLayout);
        btn_HorayFraccLayout.setHorizontalGroup(
            btn_HorayFraccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_HorayFraccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_HorayFraccLayout.setVerticalGroup(
            btn_HorayFraccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_HorayFraccion, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        btn_Lugares.setBackground(new java.awt.Color(0, 34, 77));
        btn_Lugares.setRoundBottomLeft(37);
        btn_Lugares.setRoundTopLeft(37);

        lb_lugares.setBackground(new java.awt.Color(187, 187, 187));
        lb_lugares.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_lugares.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_lugares.setText("Lugares");
        lb_lugares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_lugaresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_lugaresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_lugaresMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_LugaresLayout = new javax.swing.GroupLayout(btn_Lugares);
        btn_Lugares.setLayout(btn_LugaresLayout);
        btn_LugaresLayout.setHorizontalGroup(
            btn_LugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_lugares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_LugaresLayout.setVerticalGroup(
            btn_LugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_lugares, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        btn_SalVehiculos.setBackground(new java.awt.Color(0, 34, 77));
        btn_SalVehiculos.setRoundBottomLeft(37);
        btn_SalVehiculos.setRoundTopLeft(37);

        lb_salidaVehiculos.setBackground(new java.awt.Color(187, 187, 187));
        lb_salidaVehiculos.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_salidaVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_salidaVehiculos.setText("Salida vehículos");
        lb_salidaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_salidaVehiculosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_salidaVehiculosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_salidaVehiculosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_SalVehiculosLayout = new javax.swing.GroupLayout(btn_SalVehiculos);
        btn_SalVehiculos.setLayout(btn_SalVehiculosLayout);
        btn_SalVehiculosLayout.setHorizontalGroup(
            btn_SalVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_salidaVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        );
        btn_SalVehiculosLayout.setVerticalGroup(
            btn_SalVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_salidaVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        btn_cerrarsesion.setBackground(new java.awt.Color(93, 14, 65));
        btn_cerrarsesion.setRoundBottomLeft(37);
        btn_cerrarsesion.setRoundBottomRight(37);
        btn_cerrarsesion.setRoundTopLeft(37);
        btn_cerrarsesion.setRoundTopRight(37);

        lb_cerrarsesion.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_cerrarsesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cerrarsesion.setText("Cerrar sesión");

        javax.swing.GroupLayout btn_cerrarsesionLayout = new javax.swing.GroupLayout(btn_cerrarsesion);
        btn_cerrarsesion.setLayout(btn_cerrarsesionLayout);
        btn_cerrarsesionLayout.setHorizontalGroup(
            btn_cerrarsesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_cerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        btn_cerrarsesionLayout.setVerticalGroup(
            btn_cerrarsesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_cerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Admin");

        btn_vehiculo.setBackground(new java.awt.Color(0, 34, 77));
        btn_vehiculo.setForeground(new java.awt.Color(204, 204, 204));
        btn_vehiculo.setRoundBottomLeft(37);
        btn_vehiculo.setRoundTopLeft(37);

        lb_vehiculo.setForeground(new java.awt.Color(204, 204, 204));
        lb_vehiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_vehiculo.setText("Vehiculos");
        lb_vehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_vehiculoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_vehiculoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_vehiculoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_vehiculoLayout = new javax.swing.GroupLayout(btn_vehiculo);
        btn_vehiculo.setLayout(btn_vehiculoLayout);
        btn_vehiculoLayout.setHorizontalGroup(
            btn_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_vehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_vehiculoLayout.setVerticalGroup(
            btn_vehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_vehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout IZQ2Layout = new javax.swing.GroupLayout(IZQ2);
        IZQ2.setLayout(IZQ2Layout);
        IZQ2Layout.setHorizontalGroup(
            IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IZQ2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(IZQ2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_vehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(IZQ2Layout.createSequentialGroup()
                        .addGroup(IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_Membresia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_registros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_HorayFracc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Lugares, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_SalVehiculos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        IZQ2Layout.setVerticalGroup(
            IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IZQ2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Membresia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_registros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_HorayFracc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Lugares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_SalVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        getContentPane().add(IZQ2, java.awt.BorderLayout.LINE_START);

        centro.setBackground(new java.awt.Color(248, 244, 236));
        centro.setLayout(new java.awt.CardLayout());

        jp_principal.setBackground(new java.awt.Color(255, 204, 255));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bienvenido");

        javax.swing.GroupLayout jp_principalLayout = new javax.swing.GroupLayout(jp_principal);
        jp_principal.setLayout(jp_principalLayout);
        jp_principalLayout.setHorizontalGroup(
            jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_principalLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jp_principalLayout.setVerticalGroup(
            jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_principalLayout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );

        centro.add(jp_principal, "card2");

        jp_usuarios.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/agregar-usuario.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Altone Trial", 0, 18)); // NOI18N
        jLabel9.setText("Agregar usuarios");

        jLabel10.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel10.setText("Id_usuario");

        jLabel11.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel11.setText("Nombre completo");

        jLabel14.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel14.setText("Número telefónico");

        lb_estac.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        lb_estac.setText("Estacionmiento");

        jLabel19.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel19.setText("CURP");

        txt_iduser.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_iduser.setForeground(new java.awt.Color(102, 102, 102));
        txt_iduser.setText("Ingrese el ID de usuario");
        txt_iduser.setBorder(null);
        txt_iduser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_iduserMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_iduserMousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel20.setText("Contraseña");

        txt_nombre.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(102, 102, 102));
        txt_nombre.setText("Ingrese el nombre completo");
        txt_nombre.setBorder(null);
        txt_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nombreMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_nombreMousePressed(evt);
            }
        });

        txt_curp.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_curp.setForeground(new java.awt.Color(102, 102, 102));
        txt_curp.setText("Ingrese el CURP");
        txt_curp.setBorder(null);
        txt_curp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_curpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_curpMousePressed(evt);
            }
        });
        txt_curp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_curpActionPerformed(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(102, 102, 102));
        txtContraseña.setText("jPasswordField1");
        txtContraseña.setBorder(null);
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtContraseñaMouseExited(evt);
            }
        });

        CB_estacionamiento.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        CB_estacionamiento.setBorder(null);
        CB_estacionamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_estacionamientoActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        btn_registrar.setBackground(new java.awt.Color(116, 9, 56));
        btn_registrar.setRoundBottomLeft(50);
        btn_registrar.setRoundBottomRight(50);
        btn_registrar.setRoundTopLeft(50);
        btn_registrar.setRoundTopRight(50);

        lb_registrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_registrar.setForeground(new java.awt.Color(255, 255, 255));
        lb_registrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_registrar.setText("REGISTRAR");
        lb_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_registrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_registrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_registrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_registrarLayout = new javax.swing.GroupLayout(btn_registrar);
        btn_registrar.setLayout(btn_registrarLayout);
        btn_registrarLayout.setHorizontalGroup(
            btn_registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_registrarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lb_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        btn_registrarLayout.setVerticalGroup(
            btn_registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        txt_telefono.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(102, 102, 102));
        txt_telefono.setText("Ingrese el número teléfonico");
        txt_telefono.setBorder(null);
        txt_telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_telefonoMousePressed(evt);
            }
        });
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        cmbRol1.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        cmbRol1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));
        cmbRol1.setBorder(null);
        cmbRol1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRol1ActionPerformed(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel16.setText("Rango");

        javax.swing.GroupLayout jp_usuariosLayout = new javax.swing.GroupLayout(jp_usuarios);
        jp_usuarios.setLayout(jp_usuariosLayout);
        jp_usuariosLayout.setHorizontalGroup(
            jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_usuariosLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_iduser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jp_usuariosLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))))
                    .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_estac)
                                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CB_estacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)))
                            .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel20)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                .addComponent(txt_curp)
                                .addComponent(jLabel19)
                                .addComponent(jSeparator3)
                                .addComponent(jSeparator5)
                                .addComponent(jSeparator7)
                                .addComponent(cmbRol1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jp_usuariosLayout.setVerticalGroup(
            jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_usuariosLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_iduser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_curp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRol1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lb_estac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_estacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126))
        );

        centro.add(jp_usuarios, "card3");

        jp_vehiculo.setBackground(new java.awt.Color(255, 255, 255));
        jp_vehiculo.setLayout(null);

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Placa");
        jp_vehiculo.add(jLabel21);
        jLabel21.setBounds(65, 108, 31, 16);

        jTextField2.setText("jTextField2");
        jp_vehiculo.add(jTextField2);
        jTextField2.setBounds(65, 130, 285, 38);

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Tipo");
        jp_vehiculo.add(jLabel22);
        jLabel22.setBounds(65, 226, 24, 16);
        jp_vehiculo.add(jSeparator10);
        jSeparator10.setBounds(65, 174, 285, 10);
        jp_vehiculo.add(jSeparator11);
        jSeparator11.setBounds(65, 296, 285, 10);

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Marca");
        jp_vehiculo.add(jLabel23);
        jLabel23.setBounds(65, 351, 33, 16);
        jp_vehiculo.add(jSeparator12);
        jSeparator12.setBounds(65, 433, 285, 10);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/miniCarro.png"))); // NOI18N
        jp_vehiculo.add(jLabel31);
        jLabel31.setBounds(64, 40, 32, 32);

        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Vehiculo");
        jp_vehiculo.add(jLabel32);
        jLabel32.setBounds(124, 48, 47, 16);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Nissan", "Ford", "Yamaha", "Chevrolet", "Mercedes-Benz" }));
        jp_vehiculo.add(jComboBox2);
        jComboBox2.setBounds(65, 385, 285, 42);

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Modelo");
        jp_vehiculo.add(jLabel33);
        jLabel33.setBounds(448, 108, 40, 16);

        jTextField12.setText("jTextField12");
        jp_vehiculo.add(jTextField12);
        jTextField12.setBounds(448, 248, 364, 35);

        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Color");
        jp_vehiculo.add(jLabel34);
        jLabel34.setBounds(448, 226, 30, 16);
        jp_vehiculo.add(jSeparator22);
        jSeparator22.setBounds(448, 289, 364, 10);

        btn_registrarV.setRoundBottomLeft(40);
        btn_registrarV.setRoundBottomRight(40);
        btn_registrarV.setRoundTopLeft(40);
        btn_registrarV.setRoundTopRight(40);

        lb_registrarV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_registrarV.setText("Registrar");

        javax.swing.GroupLayout btn_registrarVLayout = new javax.swing.GroupLayout(btn_registrarV);
        btn_registrarV.setLayout(btn_registrarVLayout);
        btn_registrarVLayout.setHorizontalGroup(
            btn_registrarVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registrarV, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        btn_registrarVLayout.setVerticalGroup(
            btn_registrarVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registrarV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jp_vehiculo.add(btn_registrarV);
        btn_registrarV.setBounds(65, 517, 136, 47);

        jTextField4.setText("jTextField4");
        jp_vehiculo.add(jTextField4);
        jTextField4.setBounds(448, 130, 364, 38);
        jp_vehiculo.add(jSeparator13);
        jSeparator13.setBounds(448, 174, 364, 10);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/lupa.png"))); // NOI18N
        jp_vehiculo.add(jLabel35);
        jLabel35.setBounds(362, 123, 32, 45);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedán", "Motocicleta", "Pick-up" }));
        jp_vehiculo.add(jComboBox3);
        jComboBox3.setBounds(65, 252, 285, 38);

        centro.add(jp_vehiculo, "card9");

        jp_membresia.setBackground(new java.awt.Color(255, 255, 255));
        jp_membresia.setForeground(new java.awt.Color(0, 0, 0));
        jp_membresia.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ICON");
        jp_membresia.add(jLabel1);
        jLabel1.setBounds(39, 51, 30, 28);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Membresia");
        jp_membresia.add(jLabel5);
        jLabel5.setBounds(87, 57, 131, 16);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Id membresia");
        jp_membresia.add(jLabel6);
        jLabel6.setBounds(39, 130, 77, 16);

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setText("jTextField1");
        jTextField1.setBorder(null);
        jp_membresia.add(jTextField1);
        jTextField1.setBounds(39, 164, 213, 43);
        jp_membresia.add(jSeparator9);
        jSeparator9.setBounds(39, 213, 213, 16);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Hora");
        jp_membresia.add(jLabel12);
        jLabel12.setBounds(39, 235, 27, 16);

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("ICON");
        jp_membresia.add(jLabel13);
        jLabel13.setBounds(590, 60, 30, 16);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Cliente");
        jp_membresia.add(jLabel15);
        jLabel15.setBounds(640, 60, 96, 16);

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Placa");
        jp_membresia.add(jLabel17);
        jLabel17.setBounds(320, 230, 31, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jp_membresia.add(jComboBox1);
        jComboBox1.setBounds(320, 260, 144, 37);
        jp_membresia.add(jSeparator14);
        jSeparator14.setBounds(320, 310, 144, 22);

        jTextField5.setText("jTextField5");
        jp_membresia.add(jTextField5);
        jTextField5.setBounds(39, 257, 213, 33);
        jp_membresia.add(jSeparator15);
        jSeparator15.setBounds(39, 310, 213, 10);

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Fecha");
        jp_membresia.add(jLabel18);
        jLabel18.setBounds(39, 338, 34, 16);

        jTextField6.setText("jTextField6");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jp_membresia.add(jTextField6);
        jTextField6.setBounds(39, 366, 213, 33);
        jp_membresia.add(jSeparator16);
        jSeparator16.setBounds(39, 411, 213, 10);

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Costo");
        jp_membresia.add(jLabel24);
        jLabel24.setBounds(39, 439, 33, 16);

        jTextField7.setText("jTextField7");
        jp_membresia.add(jTextField7);
        jTextField7.setBounds(39, 467, 213, 33);
        jp_membresia.add(jSeparator17);
        jSeparator17.setBounds(39, 512, 213, 10);

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Lugar de estacionamiento");
        jp_membresia.add(jLabel25);
        jLabel25.setBounds(320, 140, 144, 16);
        jp_membresia.add(jSpinner1);
        jSpinner1.setBounds(320, 170, 144, 30);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jp_membresia.add(jSeparator18);
        jSeparator18.setBounds(510, 90, 16, 520);

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Atiende");
        jp_membresia.add(jLabel26);
        jLabel26.setBounds(39, 540, 41, 16);

        jTextField8.setText("jTextField8");
        jp_membresia.add(jTextField8);
        jTextField8.setBounds(39, 568, 440, 37);

        btn_registrarMD.setRoundBottomLeft(40);
        btn_registrarMD.setRoundBottomRight(40);
        btn_registrarMD.setRoundTopLeft(40);
        btn_registrarMD.setRoundTopRight(40);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Registrar");

        javax.swing.GroupLayout btn_registrarMDLayout = new javax.swing.GroupLayout(btn_registrarMD);
        btn_registrarMD.setLayout(btn_registrarMDLayout);
        btn_registrarMDLayout.setHorizontalGroup(
            btn_registrarMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        btn_registrarMDLayout.setVerticalGroup(
            btn_registrarMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jp_membresia.add(btn_registrarMD);
        btn_registrarMD.setBounds(39, 635, 124, 40);

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("id_dueño");
        jp_membresia.add(jLabel27);
        jLabel27.setBounds(550, 140, 52, 16);

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Nombre completo");
        jp_membresia.add(jLabel29);
        jLabel29.setBounds(550, 230, 99, 16);

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Identificación");
        jp_membresia.add(jLabel30);
        jLabel30.setBounds(550, 330, 72, 16);

        jTextField9.setText("jTextField9");
        jp_membresia.add(jTextField9);
        jTextField9.setBounds(550, 160, 247, 36);

        jTextField10.setText("jTextField10");
        jp_membresia.add(jTextField10);
        jTextField10.setBounds(550, 250, 247, 39);

        jTextField11.setText("jTextField11");
        jp_membresia.add(jTextField11);
        jTextField11.setBounds(550, 360, 247, 36);
        jp_membresia.add(jSeparator19);
        jSeparator19.setBounds(550, 210, 247, 10);
        jp_membresia.add(jSeparator20);
        jSeparator20.setBounds(550, 300, 247, 10);
        jp_membresia.add(jSeparator21);
        jSeparator21.setBounds(550, 410, 247, 10);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jp_membresia.add(jScrollPane2);
        jScrollPane2.setBounds(850, 160, 270, 330);

        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Ticket");
        jp_membresia.add(jLabel46);
        jLabel46.setBounds(850, 120, 270, 20);

        centro.add(jp_membresia, "card4");

        jp_registros.setBackground(new java.awt.Color(255, 204, 153));

        javax.swing.GroupLayout jp_registrosLayout = new javax.swing.GroupLayout(jp_registros);
        jp_registros.setLayout(jp_registrosLayout);
        jp_registrosLayout.setHorizontalGroup(
            jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        jp_registrosLayout.setVerticalGroup(
            jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );

        centro.add(jp_registros, "card5");

        jp_HorayFraccion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/tiempo.png"))); // NOI18N

        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Estacionamiento x hora");

        jLabel38.setText("id_estacionamiento");

        jTextField3.setText("jTextField3");

        jLabel39.setText("Placa");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel40.setText("Hora");

        jTextField13.setText("jTextField13");

        jLabel41.setText("Fecha");

        jTextField14.setText("jTextField14");

        jLabel42.setText("Lugar");

        jLabel43.setText("Empleado");

        jTextField15.setText("jTextField15");
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Registrar");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Ticket");

        javax.swing.GroupLayout jp_HorayFraccionLayout = new javax.swing.GroupLayout(jp_HorayFraccion);
        jp_HorayFraccion.setLayout(jp_HorayFraccionLayout);
        jp_HorayFraccionLayout.setHorizontalGroup(
            jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(796, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HorayFraccionLayout.createSequentialGroup()
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel37))
                            .addComponent(jTextField3)
                            .addComponent(jSeparator23)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator24)
                            .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jSeparator25))
                        .addGap(108, 108, 108)
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel41)
                            .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(jLabel42)
                            .addComponent(jSpinner2)
                            .addComponent(jLabel43)
                            .addComponent(jTextField15)
                            .addComponent(jSeparator26)
                            .addComponent(jSeparator27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                        .addGap(76, 76, 76))))
        );
        jp_HorayFraccionLayout.setVerticalGroup(
            jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel36))
                                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel37)))
                                .addGap(55, 55, 55)
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel41))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HorayFraccionLayout.createSequentialGroup()
                                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel42)
                                            .addComponent(jLabel39))
                                        .addGap(7, 7, 7)
                                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel43))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel45)
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(136, 136, 136)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
        );

        centro.add(jp_HorayFraccion, "card6");

        jp_lugares.setBackground(new java.awt.Color(255, 255, 255));
        jp_lugares.setLayout(null);

        jLabel47.setText("icon");
        jp_lugares.add(jLabel47);
        jLabel47.setBounds(41, 37, 23, 16);

        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Lugares");
        jp_lugares.add(jLabel48);
        jLabel48.setBounds(82, 37, 46, 16);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("6");

        javax.swing.GroupLayout jp6Layout = new javax.swing.GroupLayout(jp6);
        jp6.setLayout(jp6Layout);
        jp6Layout.setHorizontalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp6Layout.setVerticalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, 63));

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 45, -1, 63));

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 175, -1, -1));

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 175, 66, -1));

        jSeparator28.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator28.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 790, 20));

        jSeparator29.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator29.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 790, 20));

        jSeparator30.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator30.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 790, 20));

        jSeparator31.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator31.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 790, 20));

        jp30.setBackground(new java.awt.Color(204, 204, 255));

        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("30");

        javax.swing.GroupLayout jp30Layout = new javax.swing.GroupLayout(jp30);
        jp30.setLayout(jp30Layout);
        jp30Layout.setHorizontalGroup(
            jp30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp30Layout.setVerticalGroup(
            jp30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp30, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, -1, 63));

        jp2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("2");

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 63));

        jp3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("3");

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp3Layout.setVerticalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, 63));

        jp4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("4");

        javax.swing.GroupLayout jp4Layout = new javax.swing.GroupLayout(jp4);
        jp4.setLayout(jp4Layout);
        jp4Layout.setHorizontalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp4Layout.setVerticalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, 63));

        jp5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("5");

        javax.swing.GroupLayout jp5Layout = new javax.swing.GroupLayout(jp5);
        jp5.setLayout(jp5Layout);
        jp5Layout.setHorizontalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp5Layout.setVerticalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, 63));

        jp1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("1");

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 63));

        jp7.setBackground(new java.awt.Color(204, 204, 255));

        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("7");

        javax.swing.GroupLayout jp7Layout = new javax.swing.GroupLayout(jp7);
        jp7.setLayout(jp7Layout);
        jp7Layout.setHorizontalGroup(
            jp7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp7Layout.setVerticalGroup(
            jp7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 63));

        jp8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("8");

        javax.swing.GroupLayout jp8Layout = new javax.swing.GroupLayout(jp8);
        jp8.setLayout(jp8Layout);
        jp8Layout.setHorizontalGroup(
            jp8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp8Layout.setVerticalGroup(
            jp8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, 63));

        jp9.setBackground(new java.awt.Color(204, 204, 255));

        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("9");

        javax.swing.GroupLayout jp9Layout = new javax.swing.GroupLayout(jp9);
        jp9.setLayout(jp9Layout);
        jp9Layout.setHorizontalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp9Layout.setVerticalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, 63));

        jp10.setBackground(new java.awt.Color(204, 204, 255));

        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("10");

        javax.swing.GroupLayout jp10Layout = new javax.swing.GroupLayout(jp10);
        jp10.setLayout(jp10Layout);
        jp10Layout.setHorizontalGroup(
            jp10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp10Layout.setVerticalGroup(
            jp10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, 63));

        jp11.setBackground(new java.awt.Color(204, 204, 255));

        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("11");

        javax.swing.GroupLayout jp11Layout = new javax.swing.GroupLayout(jp11);
        jp11.setLayout(jp11Layout);
        jp11Layout.setHorizontalGroup(
            jp11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp11Layout.setVerticalGroup(
            jp11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, 63));

        jp12.setBackground(new java.awt.Color(204, 204, 255));

        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("12");

        javax.swing.GroupLayout jp12Layout = new javax.swing.GroupLayout(jp12);
        jp12.setLayout(jp12Layout);
        jp12Layout.setHorizontalGroup(
            jp12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp12Layout.setVerticalGroup(
            jp12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, 63));

        jp13.setBackground(new java.awt.Color(204, 204, 255));

        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("13");

        javax.swing.GroupLayout jp13Layout = new javax.swing.GroupLayout(jp13);
        jp13.setLayout(jp13Layout);
        jp13Layout.setHorizontalGroup(
            jp13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp13Layout.setVerticalGroup(
            jp13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, 63));

        jp14.setBackground(new java.awt.Color(204, 204, 255));

        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("14");

        javax.swing.GroupLayout jp14Layout = new javax.swing.GroupLayout(jp14);
        jp14.setLayout(jp14Layout);
        jp14Layout.setHorizontalGroup(
            jp14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp14Layout.setVerticalGroup(
            jp14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, 63));

        jp15.setBackground(new java.awt.Color(204, 204, 255));

        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("15");

        javax.swing.GroupLayout jp15Layout = new javax.swing.GroupLayout(jp15);
        jp15.setLayout(jp15Layout);
        jp15Layout.setHorizontalGroup(
            jp15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp15Layout.setVerticalGroup(
            jp15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, 63));

        jp16.setBackground(new java.awt.Color(204, 204, 255));

        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("16");

        javax.swing.GroupLayout jp16Layout = new javax.swing.GroupLayout(jp16);
        jp16.setLayout(jp16Layout);
        jp16Layout.setHorizontalGroup(
            jp16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp16Layout.setVerticalGroup(
            jp16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, 63));

        jp17.setBackground(new java.awt.Color(204, 204, 255));

        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("17");

        javax.swing.GroupLayout jp17Layout = new javax.swing.GroupLayout(jp17);
        jp17.setLayout(jp17Layout);
        jp17Layout.setHorizontalGroup(
            jp17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp17Layout.setVerticalGroup(
            jp17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, 63));

        jp18.setBackground(new java.awt.Color(204, 204, 255));

        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("18");

        javax.swing.GroupLayout jp18Layout = new javax.swing.GroupLayout(jp18);
        jp18.setLayout(jp18Layout);
        jp18Layout.setHorizontalGroup(
            jp18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp18Layout.setVerticalGroup(
            jp18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, -1, 63));

        jp19.setBackground(new java.awt.Color(204, 204, 255));

        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("19");

        javax.swing.GroupLayout jp19Layout = new javax.swing.GroupLayout(jp19);
        jp19.setLayout(jp19Layout);
        jp19Layout.setHorizontalGroup(
            jp19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp19Layout.setVerticalGroup(
            jp19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 63));

        jp20.setBackground(new java.awt.Color(204, 204, 255));

        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("20");

        javax.swing.GroupLayout jp20Layout = new javax.swing.GroupLayout(jp20);
        jp20.setLayout(jp20Layout);
        jp20Layout.setHorizontalGroup(
            jp20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp20Layout.setVerticalGroup(
            jp20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, 63));

        jp21.setBackground(new java.awt.Color(204, 204, 255));

        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("21");

        javax.swing.GroupLayout jp21Layout = new javax.swing.GroupLayout(jp21);
        jp21.setLayout(jp21Layout);
        jp21Layout.setHorizontalGroup(
            jp21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp21Layout.setVerticalGroup(
            jp21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, 63));

        jp22.setBackground(new java.awt.Color(204, 204, 255));

        jLabel70.setForeground(new java.awt.Color(0, 0, 0));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("22");

        javax.swing.GroupLayout jp22Layout = new javax.swing.GroupLayout(jp22);
        jp22.setLayout(jp22Layout);
        jp22Layout.setHorizontalGroup(
            jp22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp22Layout.setVerticalGroup(
            jp22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp22, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, 63));

        jp23.setBackground(new java.awt.Color(204, 204, 255));

        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("23");

        javax.swing.GroupLayout jp23Layout = new javax.swing.GroupLayout(jp23);
        jp23.setLayout(jp23Layout);
        jp23Layout.setHorizontalGroup(
            jp23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp23Layout.setVerticalGroup(
            jp23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp23, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, 63));

        jp24.setBackground(new java.awt.Color(204, 204, 255));

        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("24");

        javax.swing.GroupLayout jp24Layout = new javax.swing.GroupLayout(jp24);
        jp24.setLayout(jp24Layout);
        jp24Layout.setHorizontalGroup(
            jp24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp24Layout.setVerticalGroup(
            jp24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp24, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, -1, 63));

        jp25.setBackground(new java.awt.Color(204, 204, 255));

        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("25");

        javax.swing.GroupLayout jp25Layout = new javax.swing.GroupLayout(jp25);
        jp25.setLayout(jp25Layout);
        jp25Layout.setHorizontalGroup(
            jp25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp25Layout.setVerticalGroup(
            jp25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, 63));

        jp26.setBackground(new java.awt.Color(204, 204, 255));

        jLabel74.setForeground(new java.awt.Color(0, 0, 0));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("26");

        javax.swing.GroupLayout jp26Layout = new javax.swing.GroupLayout(jp26);
        jp26.setLayout(jp26Layout);
        jp26Layout.setHorizontalGroup(
            jp26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp26Layout.setVerticalGroup(
            jp26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp26, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, -1, 63));

        jp27.setBackground(new java.awt.Color(204, 204, 255));

        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("27");

        javax.swing.GroupLayout jp27Layout = new javax.swing.GroupLayout(jp27);
        jp27.setLayout(jp27Layout);
        jp27Layout.setHorizontalGroup(
            jp27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp27Layout.setVerticalGroup(
            jp27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, -1, 63));

        jp28.setBackground(new java.awt.Color(204, 204, 255));

        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("28");

        javax.swing.GroupLayout jp28Layout = new javax.swing.GroupLayout(jp28);
        jp28.setLayout(jp28Layout);
        jp28Layout.setHorizontalGroup(
            jp28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp28Layout.setVerticalGroup(
            jp28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp28, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, -1, 63));

        jp29.setBackground(new java.awt.Color(204, 204, 255));

        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("29");

        javax.swing.GroupLayout jp29Layout = new javax.swing.GroupLayout(jp29);
        jp29.setLayout(jp29Layout);
        jp29Layout.setHorizontalGroup(
            jp29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jp29Layout.setVerticalGroup(
            jp29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel1.add(jp29, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, -1, 63));

        jp_lugares.add(jPanel1);
        jPanel1.setBounds(235, 46, 915, 601);

        centro.add(jp_lugares, "card7");

        javax.swing.GroupLayout jp_salidaVehiculosLayout = new javax.swing.GroupLayout(jp_salidaVehiculos);
        jp_salidaVehiculos.setLayout(jp_salidaVehiculosLayout);
        jp_salidaVehiculosLayout.setHorizontalGroup(
            jp_salidaVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        jp_salidaVehiculosLayout.setVerticalGroup(
            jp_salidaVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );

        centro.add(jp_salidaVehiculos, "card8");

        getContentPane().add(centro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
 // --------------------------- Configuración del boton exit ----------------------------------------------------------------------
    private void lb_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lb_exitMouseClicked

    private void lb_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exitMouseEntered
         btn_exit.setBackground(new Color(204, 43, 82)); //parecido a rojo bajito
        lb_exit.setForeground(Color.white);
    }//GEN-LAST:event_lb_exitMouseEntered

    private void lb_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exitMouseExited
        btn_exit.setBackground(new Color(175,23,64)); //Rojo  [175,23,64]
        lb_exit.setForeground(Color.white);
    }//GEN-LAST:event_lb_exitMouseExited

// --------------------------------------- BOTON que maximiza y minimiza la ventana ----------------------------------------------
    private boolean maximizado = false; // Bandera para controlar el estado
    private void lb_minmaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_minmaxMouseClicked
         if (!maximizado) {
            // Maximizar la ventana
            this.setExtendedState(MAXIMIZED_BOTH);
            maximizado = true; // Cambiar el estado
         } else {
            // Restaurar tamaño original
            this.setExtendedState(NORMAL);
            maximizado = false; // Cambiar el estado
        }
    }//GEN-LAST:event_lb_minmaxMouseClicked

    private void lb_minmaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_minmaxMouseEntered
        btn_minmax.setBackground(new Color(204, 43, 82)); //parecido a rojo bajito
        lb_minmax.setForeground(Color.white);
    }//GEN-LAST:event_lb_minmaxMouseEntered

    private void lb_minmaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_minmaxMouseExited
         btn_minmax.setBackground(new Color(175,23,64)); //Rojo  [175,23,64]
         lb_minmax.setForeground(Color.white);
    }//GEN-LAST:event_lb_minmaxMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed
// -------------------------------------- Configuracion para minimizar -----------------------------------------------------------------
    private void lb_minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_minMouseClicked
                              
         this.setState(ICONIFIED); // Minimiza el JFrame
    }//GEN-LAST:event_lb_minMouseClicked

    private void lb_minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_minMouseEntered
        btn_min.setBackground(new Color(204, 43, 82)); //parecido a rojo bajito
        lb_min.setForeground(Color.white);
    }//GEN-LAST:event_lb_minMouseEntered

    private void lb_minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_minMouseExited
         btn_min.setBackground(new Color(175,23,64)); //Rojo  [175,23,64]
         lb_min.setForeground(Color.white);
    }//GEN-LAST:event_lb_minMouseExited

    // ---------------------------------- LOGICA DEL BOTON REGISTRAR USUARIOS ---------------------------------------------
    private void lb_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarMouseClicked
         // Capturar los datos de los campos de texto del formulario
        String id_usuario = txt_iduser.getText();  // txtIdUsuario es el JTextField para el id_usuario
        String nombre = txt_nombre.getText();         // txtNombre es el JTextField para el nombre
        String telefono = txt_telefono.getText();     // txtTelefono es el JTextField para el telefono
        String rol = cmbRol1.getSelectedItem().toString(); // cmbRol es el JComboBox para el rol
        String curp = txt_curp.getText();  // txtCredencial es el JTextField para las credenciales
        String estacionamiento = CB_estacionamiento.getSelectedItem().toString(); // cmbRol es el JComboBox para el rol
        String contraseña = new String(txtContraseña.getPassword()); // txtContraseña es el JPasswordField para la contraseña
        

        // Establecer la conexión
        Connection con = conexion.getConection();
        if (con != null) {
            try {
                // Crear la consulta SQL para insertar los datos
                String sql = "INSERT INTO usuario (id_usuario, Nombre, Telefono, Rango, CURP, id_estacionamiento, Contraseña) VALUES (?, ?, ?, ?, ?, ?,?)";

                // Preparar la sentencia SQL
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, id_usuario);
                ps.setString(2, nombre);
                ps.setString(3, telefono);
                ps.setString(4, rol);
                ps.setString(5, curp);
                ps.setString(6, estacionamiento);
                ps.setString(7, contraseña); // Si deseas encriptar la contraseña, aquí debes hacerlo antes de insertarla

                // Ejecutar la consulta
                int rowsAffected = ps.executeUpdate();

                // Verificar si la inserción fue exitosa
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario.");
                }

                // Cerrar la conexión y el PreparedStatement
                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
        }
    }//GEN-LAST:event_lb_registrarMouseClicked

    private void lb_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_registrarMouseEntered

    private void lb_registrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_registrarMouseExited

    private void btn_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usuariosMouseClicked
       
    }//GEN-LAST:event_btn_usuariosMouseClicked

    private void btn_usuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usuariosMouseEntered
        
    }//GEN-LAST:event_btn_usuariosMouseEntered

    private void btn_usuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usuariosMouseExited
        
    }//GEN-LAST:event_btn_usuariosMouseExited

    private void CB_estacionamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_estacionamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_estacionamientoActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_curpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_curpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_curpActionPerformed

    private void txt_iduserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_iduserMousePressed
        if (txt_iduser.getText().equals("Ingrese el ID de usuario")) {
            txt_iduser.setText("");
            txt_iduser.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_iduserMousePressed

    private void txt_curpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_curpMousePressed
        if (txt_curp.getText().equals("Ingrese el CURP")) {
            txt_curp.setText("");
            txt_curp.setForeground(Color.black);
        }

        // Añadir un KeyListener para convertir a mayúsculas y validar la longitud del texto
        txt_curp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Convertir a mayúsculas si la tecla presionada es una letra minúscula
                char c = e.getKeyChar();
                if (Character.isLowerCase(c)) {
                    // Convertir el carácter a mayúscula
                    e.setKeyChar(Character.toUpperCase(c));
                }

                // Si el texto ya tiene 18 caracteres y se intenta ingresar más, se bloquea la entrada
                if (txt_curp.getText().length() >= 18) {
                    e.consume();  // Bloquea la entrada de más caracteres
                    JOptionPane.showMessageDialog(null, "Ingreso más de los caracteres esperados (18 caracteres)", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });   
    }//GEN-LAST:event_txt_curpMousePressed

    private void txt_nombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMousePressed
        if (txt_nombre.getText().equals("Ingrese el nombre completo")) {
            txt_nombre.setText("");
            txt_nombre.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_nombreMousePressed

    private void txt_telefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMousePressed
        if (txt_telefono.getText().equals("Ingrese el número teléfonico")) {
            txt_telefono.setText("");
            txt_telefono.setForeground(Color.black);
        } 
        
        txt_telefono.addKeyListener(new KeyAdapter() { //Solo se esperan números
        @Override
        public void keyTyped(KeyEvent e) {
            // Obtener el carácter ingresado
            char c = e.getKeyChar();
            
            // Verificar si el carácter es un número o si es la tecla de retroceso 
            if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();  // Si no es un número, se bloquea la entrada
                JOptionPane.showMessageDialog(null, "Ingrese solo números", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if (txt_telefono.getText().length() >= 10) {
                if (Character.isDigit(c)) {
                    e.consume();  // Si el número de caracteres es 10, no se permite añadir más
                    JOptionPane.showMessageDialog(null, "El número telefónico no puede tener más de 10 dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    });
    }//GEN-LAST:event_txt_telefonoMousePressed

    private void txt_iduserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_iduserMouseExited
        if (txt_iduser.getText().isEmpty()) {
            txt_iduser.setText("Ingrese el ID de usuario");
            txt_iduser.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_iduserMouseExited

    private void txt_curpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_curpMouseExited
        if (txt_curp.getText().isEmpty()) {
            txt_curp.setText("Ingrese el CURP");
            txt_curp.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_curpMouseExited

    private void txt_nombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMouseExited
        if (txt_nombre.getText().isEmpty()) {
            txt_nombre.setText("Ingrese el nombre completo");
            txt_nombre.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_nombreMouseExited

    private void txt_telefonoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMouseExited
        if (txt_telefono.getText().isEmpty()) {
            txt_telefono.setText("Ingrese el número teléfonico");
            txt_telefono.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_telefonoMouseExited

    private void txtContraseñaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMouseExited
        if (String.valueOf(txtContraseña.getPassword()).isEmpty()) {
            txtContraseña.setText("**************");
            txtContraseña.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txtContraseñaMouseExited

    
    // ------------------------------- LOGICA DE QUE PANEL ESTA SELECCIONADO ----------------------------------------------------------------------------
    // Variables de selección
        private String panelSeleccionado = ""; // Nombre del panel actualmente seleccionado

        private void seleccionarPanel(String panel) {
            // Restaurar colores de todos los botones y etiquetas
            restaurarEstadoPaneles();

            // Cambiar colores y mostrar el panel correspondiente
            switch (panel) {
                case "usuarios":
                    btn_usuarios.setBackground(Color.WHITE); // Seleccionado
                    lb_usuarios.setForeground(new Color(0, 34, 77)); // Fuente
                    jp_usuarios.setVisible(true);
                    break;
                case "dueño":
                    btn_vehiculo.setBackground(Color.WHITE); // Seleccionado
                    lb_vehiculo.setForeground(new Color(0, 34, 77)); // Fuente
                    jp_vehiculo.setVisible(true);
                    break;
                case "membresia":
                    btn_Membresia.setBackground(Color.WHITE);
                    lb_membresia.setForeground(new Color(0, 34, 77));
                    jp_membresia.setVisible(true);
                    break;
                case "registros":
                    btn_registros.setBackground(Color.WHITE);
                    lb_registros.setForeground(new Color(0, 34, 77));
                    jp_registros.setVisible(true);
                    break;
                 case "HorayFraccion":
                    btn_HorayFracc.setBackground(Color.WHITE);
                    lb_HorayFraccion.setForeground(new Color(0, 34, 77));
                    jp_HorayFraccion.setVisible(true);
                    break;
                 case "Lugares":
                    btn_Lugares.setBackground(Color.WHITE);
                    lb_lugares.setForeground(new Color(0, 34, 77));
                    jp_lugares.setVisible(true);
                    break;
                 case "SalidaVehiculos":
                    btn_SalVehiculos.setBackground(Color.WHITE);
                    lb_salidaVehiculos.setForeground(new Color(0, 34, 77));
                    jp_salidaVehiculos.setVisible(true);
                    break;
                
            }

            // Actualizar el panel seleccionado
            panelSeleccionado = panel;
        }
    
        private void restaurarEstadoPaneles() {
            // Restaurar colores de todos los botones y etiquetas
            btn_usuarios.setBackground(new Color(0, 34, 77));
            lb_usuarios.setForeground(new Color(187, 187, 187));
            
            btn_vehiculo.setBackground(new Color(0, 34, 77));
            lb_vehiculo.setForeground(new Color(187, 187, 187));

            btn_Membresia.setBackground(new Color(0, 34, 77));
            lb_membresia.setForeground(new Color(187, 187, 187));

            btn_registros.setBackground(new Color(0, 34, 77));
            lb_registros.setForeground(new Color(187, 187, 187));
            
            btn_HorayFracc.setBackground(new Color(0, 34, 77));
            lb_HorayFraccion.setForeground(new Color(187, 187, 187));
            
            btn_Lugares.setBackground(new Color(0, 34, 77));
            lb_lugares.setForeground(new Color(187, 187, 187));
            
            btn_SalVehiculos.setBackground(new Color(0, 34, 77));
            lb_salidaVehiculos.setForeground(new Color(187, 187, 187));

            // Ocultar todos los paneles
            jp_principal.setVisible(false);
            jp_usuarios.setVisible(false);
            jp_vehiculo.setVisible(false);
            jp_membresia.setVisible(false);
            jp_registros.setVisible(false);
            jp_HorayFraccion.setVisible(false);
            jp_lugares.setVisible(false);
            jp_salidaVehiculos.setVisible(false);
            
        }
  
    private void lb_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_usuariosMouseClicked
        if (!panelSeleccionado.equals("usuarios")) {
            seleccionarPanel("usuarios");
        }  
    }//GEN-LAST:event_lb_usuariosMouseClicked

    private void lb_membresiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_membresiaMouseClicked
       if (!panelSeleccionado.equals("membresia")) {
            seleccionarPanel("membresia");
        }
    }//GEN-LAST:event_lb_membresiaMouseClicked

    private void lb_usuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_usuariosMouseEntered
        // Cambiar color solo si no está seleccionado
        if (!panelSeleccionado.equals("usuarios")) {
             btn_usuarios.setBackground(Color.WHITE);
            lb_usuarios.setForeground(new Color(0, 34, 77));
        }
    }//GEN-LAST:event_lb_usuariosMouseEntered

    private void lb_usuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_usuariosMouseExited
        // Restaurar color solo si no está seleccionado
        if (!panelSeleccionado.equals("usuarios")) {
            btn_usuarios.setBackground(new Color(0, 34, 77));
            lb_usuarios.setForeground(new Color(187, 187, 187)); 
        }
    }//GEN-LAST:event_lb_usuariosMouseExited

    private void lb_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrosMouseClicked
        if (!panelSeleccionado.equals("registros")) {
            seleccionarPanel("registros");
        }
    }//GEN-LAST:event_lb_registrosMouseClicked

    private void lb_HorayFraccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_HorayFraccionMouseClicked
        if (!panelSeleccionado.equals("HorayFraccion")) {
            seleccionarPanel("HorayFraccion");
        }
    }//GEN-LAST:event_lb_HorayFraccionMouseClicked

    private void lb_lugaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_lugaresMouseClicked
        if (!panelSeleccionado.equals("Lugares")) {
            seleccionarPanel("Lugares");
        }
    }//GEN-LAST:event_lb_lugaresMouseClicked

    private void lb_salidaVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_salidaVehiculosMouseClicked
        if (!panelSeleccionado.equals("SalidaVehiculos")) {
            seleccionarPanel("SalidaVehiculos");
        }
    }//GEN-LAST:event_lb_salidaVehiculosMouseClicked

    private void lb_membresiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_membresiaMouseEntered
        if (!panelSeleccionado.equals("membresia")) {
             btn_Membresia.setBackground(Color.WHITE);
            lb_membresia.setForeground(new Color(0, 34, 77));
        }
    }//GEN-LAST:event_lb_membresiaMouseEntered

    private void lb_registrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrosMouseEntered
        if (!panelSeleccionado.equals("registros")) {
             btn_registros.setBackground(Color.WHITE);
            lb_registros.setForeground(new Color(0, 34, 77));
        }
    }//GEN-LAST:event_lb_registrosMouseEntered

    private void lb_HorayFraccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_HorayFraccionMouseEntered
        if (!panelSeleccionado.equals("HorayFraccion")) {
             btn_HorayFracc.setBackground(Color.WHITE);
            lb_HorayFraccion.setForeground(new Color(0, 34, 77));
        }
    }//GEN-LAST:event_lb_HorayFraccionMouseEntered

    private void lb_lugaresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_lugaresMouseEntered
        if (!panelSeleccionado.equals("Lugares")) {
             btn_Lugares.setBackground(Color.WHITE);
            lb_lugares.setForeground(new Color(0, 34, 77));
        }
    }//GEN-LAST:event_lb_lugaresMouseEntered

    private void lb_salidaVehiculosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_salidaVehiculosMouseEntered
        if (!panelSeleccionado.equals("SalidaVehiculos")) {
             btn_SalVehiculos.setBackground(Color.WHITE);
            lb_salidaVehiculos.setForeground(new Color(0, 34, 77));
        }
    }//GEN-LAST:event_lb_salidaVehiculosMouseEntered

    private void lb_membresiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_membresiaMouseExited
        if (!panelSeleccionado.equals("membresia")) {
            btn_Membresia.setBackground(new Color(0, 34, 77));
            lb_membresia.setForeground(new Color(187, 187, 187)); 
        }
    }//GEN-LAST:event_lb_membresiaMouseExited

    private void lb_registrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrosMouseExited
        if (!panelSeleccionado.equals("registros")) {
            btn_registros.setBackground(new Color(0, 34, 77));
            lb_registros.setForeground(new Color(187, 187, 187)); 
        }
    }//GEN-LAST:event_lb_registrosMouseExited

    private void lb_HorayFraccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_HorayFraccionMouseExited
        if (!panelSeleccionado.equals("HorayFraccion")) {
            btn_HorayFracc.setBackground(new Color(0, 34, 77));
            lb_HorayFraccion.setForeground(new Color(187, 187, 187)); 
        }
    }//GEN-LAST:event_lb_HorayFraccionMouseExited

    private void lb_lugaresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_lugaresMouseExited
        if (!panelSeleccionado.equals("Lugares")) {
            btn_Lugares.setBackground(new Color(0, 34, 77));
            lb_lugares.setForeground(new Color(187, 187, 187)); 
        }
    }//GEN-LAST:event_lb_lugaresMouseExited

    private void lb_salidaVehiculosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_salidaVehiculosMouseExited
        if (!panelSeleccionado.equals("SalidaVehiculos")) {
            btn_SalVehiculos.setBackground(new Color(0, 34, 77));
            lb_salidaVehiculos.setForeground(new Color(187, 187, 187)); 
        }
    }//GEN-LAST:event_lb_salidaVehiculosMouseExited

    private void cmbRol1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRol1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRol1ActionPerformed

    private void lb_vehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_vehiculoMouseClicked
        if (!panelSeleccionado.equals("dueño")) {
            seleccionarPanel("dueño");
        }
    }//GEN-LAST:event_lb_vehiculoMouseClicked

    private void lb_vehiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_vehiculoMouseEntered
        if (!panelSeleccionado.equals("dueño")) {
             btn_vehiculo.setBackground(Color.WHITE);
            lb_vehiculo.setForeground(new Color(0, 34, 77));
        }
    }//GEN-LAST:event_lb_vehiculoMouseEntered

    private void lb_vehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_vehiculoMouseExited
        if (!panelSeleccionado.equals("dueño")) {
            btn_vehiculo.setBackground(new Color(0, 34, 77));
            lb_vehiculo.setForeground(new Color(187, 187, 187)); 
        }
    }//GEN-LAST:event_lb_vehiculoMouseExited

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SwingUtilities.invokeLater(() -> new Menu_admin().setVisible(true));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_estacionamiento;
    private javax.swing.JPanel IZQ2;
    private Clases.PanelRound btn_HorayFracc;
    private Clases.PanelRound btn_Lugares;
    private Clases.PanelRound btn_Membresia;
    private Clases.PanelRound btn_SalVehiculos;
    private Clases.PanelRound btn_cerrarsesion;
    private javax.swing.JPanel btn_exit;
    private javax.swing.JPanel btn_min;
    private javax.swing.JPanel btn_minmax;
    private Clases.PanelRound btn_registrar;
    private Clases.PanelRound btn_registrarMD;
    private Clases.PanelRound btn_registrarV;
    private Clases.PanelRound btn_registros;
    private Clases.PanelRound btn_usuarios;
    private Clases.PanelRound btn_vehiculo;
    private javax.swing.JPanel centro;
    private javax.swing.JComboBox<String> cmbRol1;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp10;
    private javax.swing.JPanel jp11;
    private javax.swing.JPanel jp12;
    private javax.swing.JPanel jp13;
    private javax.swing.JPanel jp14;
    private javax.swing.JPanel jp15;
    private javax.swing.JPanel jp16;
    private javax.swing.JPanel jp17;
    private javax.swing.JPanel jp18;
    private javax.swing.JPanel jp19;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp20;
    private javax.swing.JPanel jp21;
    private javax.swing.JPanel jp22;
    private javax.swing.JPanel jp23;
    private javax.swing.JPanel jp24;
    private javax.swing.JPanel jp25;
    private javax.swing.JPanel jp26;
    private javax.swing.JPanel jp27;
    private javax.swing.JPanel jp28;
    private javax.swing.JPanel jp29;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp30;
    private javax.swing.JPanel jp4;
    private javax.swing.JPanel jp5;
    private javax.swing.JPanel jp6;
    private javax.swing.JPanel jp7;
    private javax.swing.JPanel jp8;
    private javax.swing.JPanel jp9;
    private javax.swing.JPanel jp_HorayFraccion;
    private javax.swing.JPanel jp_lugares;
    private javax.swing.JPanel jp_membresia;
    private javax.swing.JPanel jp_principal;
    private javax.swing.JPanel jp_registros;
    private javax.swing.JPanel jp_salidaVehiculos;
    private javax.swing.JPanel jp_usuarios;
    private javax.swing.JPanel jp_vehiculo;
    private javax.swing.JLabel lb_HorayFraccion;
    private javax.swing.JLabel lb_cerrarsesion;
    private javax.swing.JLabel lb_estac;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_lugares;
    private javax.swing.JLabel lb_membresia;
    private javax.swing.JLabel lb_min;
    private javax.swing.JLabel lb_minmax;
    private javax.swing.JLabel lb_nombreUsuario;
    private javax.swing.JLabel lb_registrar;
    private javax.swing.JLabel lb_registrarV;
    private javax.swing.JLabel lb_registros;
    private javax.swing.JLabel lb_salidaVehiculos;
    private javax.swing.JLabel lb_tiempo;
    private javax.swing.JLabel lb_usuarios;
    private javax.swing.JLabel lb_vehiculo;
    private Clases.PanelRound panelRound1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txt_curp;
    private javax.swing.JTextField txt_iduser;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
