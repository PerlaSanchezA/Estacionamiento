/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Empleado;

import Clases.conexion;
import java.sql.*;
import java.awt.Color;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

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

    conexion consultas = new conexion();

    public Menu_admin() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());  // O puedes usar FlatLightLaf para el modo claro
        } catch (UnsupportedLookAndFeelException e) {
        }

        initComponents();
        txtContraseña.setEchoChar((char) 0);
        txtContraseña.setText("**************");

        mapearPaneles(); // Llenar el mapa de paneles
        actualizarColores(); // Actualizar los colores según la base de datos
        iniciarActualizacionPeriodica();//Actualiza

        consultas.RellenarComboBox("estacionamiento", "id_estacionamiento", CB_estacionamiento);
        consultas.RellenarComboBox("vehiculo", "Placa", cb_placaMD);
        consultas.RellenarComboBox("vehiculo", "Placa", cb_placaEH);
        consultas.RellenarComboBox("vehiculo", "Placa", cb_placaSV);

        tiempo(); //Lama el metodo para mostrarlo

    }

    // Metodo para obener nombre de usuario 
    public void setNombreUsuario(String nombreUsuario) {
        lb_nombreUsuario.setText("Bienvenido, " + nombreUsuario);
        txt_empleadoMD.setText(nombreUsuario);
        txt_empleadoEH.setText(nombreUsuario);
    }

    // Metodo para obtener la hora y fecha actual
    public void tiempo() {
        Timer timer = new Timer(1000, e -> {
            java.util.Date date = new java.util.Date();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = dateFormatter.format(date);
            lb_fecha.setText(formattedDate);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate1 = dateFormatter1.format(date);
            txt_fechaMD.setText(formattedDate1);
            txt_fechaEH.setText(formattedDate1);
            txt_fechaSV.setText(formattedDate1);

            // Cambia el formato de hora a 24 horas
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
            String formattedTime = timeFormatter.format(date);
            lb_tiempo.setText(formattedTime);
            txt_horaMD.setText(formattedTime);
            txt_horaEH.setText(formattedTime);
            txt_HorasalidaSV.setText(formattedTime);
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
        try (Connection con = conexion.getConection(); PreparedStatement ps = con.prepareStatement("SELECT id_espacio, espaciodisp_ocup FROM espacio_lugar WHERE id_estacionamiento = 1"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idEspacio = rs.getInt("id_espacio");
                String estado = rs.getString("espaciodisp_ocup").trim();

                // Cambiar el color del panel correspondiente
                JPanel panel = panelMap.get(idEspacio);
                if (panel != null) {
                    // Usamos Color.GREEN para Disponible, Color.RED para Ocupado
                    panel.setBackground(estado.equalsIgnoreCase("Disponible") ? Color.GREEN : Color.RED);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void iniciarActualizacionPeriodica() {
        // Creamos un Timer que se ejecute cada 5 segundos (5000 milisegundos)
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamamos a la función para actualizar los colores cada vez que el timer se active
                actualizarColores();
            }
        });

        // Inicia el timer
        timer.start();
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
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
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
        btn_actualizarU = new Clases.PanelRound();
        lb_actualizar = new javax.swing.JLabel();
        lb_mostrarUC = new javax.swing.JLabel();
        lb_buscar = new javax.swing.JLabel();
        btn_limpiarU = new Clases.PanelRound();
        lb_limpiarU = new javax.swing.JLabel();
        jp_vehiculo = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cb_marca = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        txt_color = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        btn_registrarV = new Clases.PanelRound();
        lb_registrarV = new javax.swing.JLabel();
        txt_modelo = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        cb_tipo = new javax.swing.JComboBox<>();
        btn_actualizarV = new Clases.PanelRound();
        lb_actualizarV = new javax.swing.JLabel();
        btn_limpiar = new Clases.PanelRound();
        lb_limpiar = new javax.swing.JLabel();
        lb_buscarV = new javax.swing.JLabel();
        jp_registros = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtb_registros = new javax.swing.JTable();
        cb_tablas = new javax.swing.JComboBox<>();
        jLabel97 = new javax.swing.JLabel();
        btn_consultarR = new Clases.PanelRound();
        lb_consultarR = new javax.swing.JLabel();
        jp_HorayFraccion = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        cb_placaEH = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        txt_horaEH = new javax.swing.JTextField();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        txt_fechaEH = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jsp_lugarEH = new javax.swing.JSpinner();
        jLabel43 = new javax.swing.JLabel();
        txt_empleadoEH = new javax.swing.JTextField();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        btn_registrarEH = new Clases.PanelRound();
        lb_registrarEH = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtA_ticketEH = new javax.swing.JTextArea();
        btn_ticket = new Clases.PanelRound();
        lb_ticket = new javax.swing.JLabel();
        jSeparator37 = new javax.swing.JSeparator();
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
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        cb_placaSV = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        btn_buscarSV = new Clases.PanelRound();
        lb_buscarSV = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txt_horaEntradaSV = new javax.swing.JTextField();
        txt_HorasalidaSV = new javax.swing.JTextField();
        lb_tiempoSV = new javax.swing.JLabel();
        btn_calcularTiemCost = new Clases.PanelRound();
        lb_calcularTiemCost = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        txt_idEstSV = new javax.swing.JTextField();
        jSeparator33 = new javax.swing.JSeparator();
        txt_fechaSV = new javax.swing.JTextField();
        jSeparator34 = new javax.swing.JSeparator();
        txt_costoSV = new javax.swing.JTextField();
        jSeparator35 = new javax.swing.JSeparator();
        btn_pagarSV = new Clases.PanelRound();
        lb_pagarSV = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtA_ticketSV = new javax.swing.JTextArea();
        jsp_lugarSV = new javax.swing.JSpinner();
        jSeparator36 = new javax.swing.JSeparator();
        btn_ticketSV = new Clases.PanelRound();
        lb_ticketSV = new javax.swing.JLabel();
        jp_membresia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_idmembresiaMD = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cb_placaMD = new javax.swing.JComboBox<>();
        jSeparator14 = new javax.swing.JSeparator();
        txt_horaMD = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txt_fechaMD = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        txt_costoMD = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jsp_lugarMD = new javax.swing.JSpinner();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        txt_empleadoMD = new javax.swing.JTextField();
        btn_registrarMD = new Clases.PanelRound();
        lb_resgistrarMD = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_idueñoMD = new javax.swing.JTextField();
        txt_nombrecompletoMD = new javax.swing.JTextField();
        txt_identificacionMD = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA_ticketMD = new javax.swing.JTextArea();
        btn_dueñoMD = new Clases.PanelRound();
        lb_dueñoMD = new javax.swing.JLabel();
        btn_ticketMem = new Clases.PanelRound();
        lb_ticketMem = new javax.swing.JLabel();
        btn_buscarCMD = new javax.swing.JLabel();
        btn_limpMem = new Clases.PanelRound();
        lb_limpMem = new javax.swing.JLabel();
        btn_salida = new Clases.PanelRound();
        lb_salida = new javax.swing.JLabel();
        btn_renovar = new Clases.PanelRound();
        lb_renovar = new javax.swing.JLabel();
        lb_membresiaMD = new javax.swing.JLabel();

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
        jLabel8.setText("ParkCar");

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
        lb_tiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        lb_tiempo.setForeground(new java.awt.Color(204, 204, 204));
        lb_tiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tiempo.setText("hh:mm:ss am");

        lb_fecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        lb_fecha.setForeground(new java.awt.Color(204, 204, 204));
        lb_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_fecha.setText("dd/mm/yyyy");

        lb_nombreUsuario.setFont(new java.awt.Font("Louis George Cafe", 1, 15)); // NOI18N
        lb_nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lb_nombreUsuario.setText("user");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lb_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(lb_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
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
        lb_usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        lb_membresia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        lb_registros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        lb_HorayFraccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        lb_lugares.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        lb_salidaVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        btn_cerrarsesion.setBackground(new java.awt.Color(160, 21, 62));
        btn_cerrarsesion.setRoundBottomLeft(37);
        btn_cerrarsesion.setRoundBottomRight(37);
        btn_cerrarsesion.setRoundTopLeft(37);
        btn_cerrarsesion.setRoundTopRight(37);

        lb_cerrarsesion.setFont(new java.awt.Font("Altone Trial", 1, 14)); // NOI18N
        lb_cerrarsesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cerrarsesion.setText("Cerrar sesión");
        lb_cerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_cerrarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_cerrarsesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_cerrarsesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_cerrarsesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_cerrarsesionLayout = new javax.swing.GroupLayout(btn_cerrarsesion);
        btn_cerrarsesion.setLayout(btn_cerrarsesionLayout);
        btn_cerrarsesionLayout.setHorizontalGroup(
            btn_cerrarsesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_cerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );
        btn_cerrarsesionLayout.setVerticalGroup(
            btn_cerrarsesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_cerrarsesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Admin");

        btn_vehiculo.setBackground(new java.awt.Color(0, 34, 77));
        btn_vehiculo.setForeground(new java.awt.Color(204, 204, 204));
        btn_vehiculo.setRoundBottomLeft(37);
        btn_vehiculo.setRoundTopLeft(37);

        lb_vehiculo.setFont(new java.awt.Font("Altone Trial", 0, 14)); // NOI18N
        lb_vehiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_vehiculo.setText("Vehículos");
        lb_vehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                            .addGroup(IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, IZQ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
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
                .addContainerGap(549, Short.MAX_VALUE))
        );

        getContentPane().add(IZQ2, java.awt.BorderLayout.LINE_START);

        centro.setBackground(new java.awt.Color(248, 244, 236));
        centro.setLayout(new java.awt.CardLayout());

        jp_principal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Louis George Cafe", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 50, 135));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel28.setFont(new java.awt.Font("Louis George Cafe", 1, 22)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel35.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 51, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel38.setFont(new java.awt.Font("Louis George Cafe", 1, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(153, 51, 0));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel44.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 51, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel88.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 51, 102));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel90.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 51, 102));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel91.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 51, 102));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel93.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 51, 102));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel98.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 51, 102));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel99.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(102, 102, 102));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/agregar-usuario.png"))); // NOI18N

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/agregar-vehiculo.png"))); // NOI18N

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/afiliacion.png"))); // NOI18N

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/registro.png"))); // NOI18N

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/tarifa-por-hora.png"))); // NOI18N

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/coche.png"))); // NOI18N

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/concesion.png"))); // NOI18N

        javax.swing.GroupLayout jp_principalLayout = new javax.swing.GroupLayout(jp_principal);
        jp_principal.setLayout(jp_principalLayout);
        jp_principalLayout.setHorizontalGroup(
            jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_principalLayout.createSequentialGroup()
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_principalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel105))
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel104))
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel103))
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel102))
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel101))
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel100))
                    .addGroup(jp_principalLayout.createSequentialGroup()
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel106)))
                .addGap(354, 354, 354))
        );
        jp_principalLayout.setVerticalGroup(
            jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_principalLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jp_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        centro.add(jp_principal, "card2");

        jp_usuarios.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/agregar-usuario.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Agregar usuarios");

        jLabel10.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel10.setText("Id_usuario");

        jLabel11.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel11.setText("Nombre completo");

        jLabel14.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel14.setText("Número telefónico");

        lb_estac.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        lb_estac.setText("Estacionamiento");

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseñaMousePressed(evt);
            }
        });

        CB_estacionamiento.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
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
        btn_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_registrarMouseEntered(evt);
            }
        });

        lb_registrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_registrar.setForeground(new java.awt.Color(255, 255, 255));
        lb_registrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_registrar.setText("REGISTRAR");
        lb_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(lb_registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
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

        cmbRol1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
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

        btn_actualizarU.setBackground(new java.awt.Color(116, 9, 56));
        btn_actualizarU.setRoundBottomLeft(50);
        btn_actualizarU.setRoundBottomRight(50);
        btn_actualizarU.setRoundTopLeft(50);
        btn_actualizarU.setRoundTopRight(50);

        lb_actualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        lb_actualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_actualizar.setText("ACTUALIZAR");
        lb_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_actualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_actualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_actualizarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_actualizarULayout = new javax.swing.GroupLayout(btn_actualizarU);
        btn_actualizarU.setLayout(btn_actualizarULayout);
        btn_actualizarULayout.setHorizontalGroup(
            btn_actualizarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_actualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        btn_actualizarULayout.setVerticalGroup(
            btn_actualizarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        lb_mostrarUC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ojo.png"))); // NOI18N
        lb_mostrarUC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_mostrarUCMouseClicked(evt);
            }
        });

        lb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/buscar.png"))); // NOI18N
        lb_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_buscarMouseClicked(evt);
            }
        });

        btn_limpiarU.setBackground(new java.awt.Color(102, 102, 102));
        btn_limpiarU.setRoundBottomLeft(40);
        btn_limpiarU.setRoundBottomRight(40);
        btn_limpiarU.setRoundTopLeft(40);
        btn_limpiarU.setRoundTopRight(40);

        lb_limpiarU.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_limpiarU.setForeground(new java.awt.Color(255, 255, 255));
        lb_limpiarU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_limpiarU.setText("LIMPIAR");
        lb_limpiarU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_limpiarUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_limpiarUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_limpiarUMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_limpiarULayout = new javax.swing.GroupLayout(btn_limpiarU);
        btn_limpiarU.setLayout(btn_limpiarULayout);
        btn_limpiarULayout.setHorizontalGroup(
            btn_limpiarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_limpiarU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );
        btn_limpiarULayout.setVerticalGroup(
            btn_limpiarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_limpiarU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_usuariosLayout = new javax.swing.GroupLayout(jp_usuarios);
        jp_usuarios.setLayout(jp_usuariosLayout);
        jp_usuariosLayout.setHorizontalGroup(
            jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_usuariosLayout.createSequentialGroup()
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9)
                            .addGroup(jp_usuariosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_iduser, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_buscar))))
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btn_limpiarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lb_estac)
                                .addComponent(CB_estacionamiento, 0, 339, Short.MAX_VALUE)
                                .addComponent(jSeparator8))
                            .addGroup(jp_usuariosLayout.createSequentialGroup()
                                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                    .addComponent(txt_curp)
                                    .addComponent(jLabel19)
                                    .addComponent(jSeparator3)
                                    .addComponent(jSeparator5)
                                    .addComponent(jSeparator7)
                                    .addComponent(cmbRol1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_mostrarUC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(189, Short.MAX_VALUE))
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jp_usuariosLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(btn_actualizarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jp_usuariosLayout.setVerticalGroup(
            jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_usuariosLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_iduser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_curp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_mostrarUC))
                .addGap(2, 2, 2)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRol1))
                .addGap(1, 1, 1)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_usuariosLayout.createSequentialGroup()
                        .addComponent(lb_estac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_estacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_limpiarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(490, 490, 490))
        );

        centro.add(jp_usuarios, "card3");

        jp_vehiculo.setBackground(new java.awt.Color(255, 255, 255));
        jp_vehiculo.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel21.setText("Placa");
        jp_vehiculo.add(jLabel21);
        jLabel21.setBounds(135, 172, 38, 19);

        txt_placa.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_placa.setForeground(new java.awt.Color(102, 102, 102));
        txt_placa.setText("Ingrese la placa");
        txt_placa.setBorder(null);
        txt_placa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_placaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_placaMousePressed(evt);
            }
        });
        txt_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placaActionPerformed(evt);
            }
        });
        jp_vehiculo.add(txt_placa);
        txt_placa.setBounds(135, 203, 323, 44);

        jLabel22.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel22.setText("Tipo");
        jp_vehiculo.add(jLabel22);
        jLabel22.setBounds(135, 299, 82, 19);
        jp_vehiculo.add(jSeparator10);
        jSeparator10.setBounds(135, 249, 323, 10);
        jp_vehiculo.add(jSeparator11);
        jSeparator11.setBounds(135, 376, 323, 10);

        jLabel23.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel23.setText("Marca");
        jp_vehiculo.add(jLabel23);
        jLabel23.setBounds(135, 426, 46, 19);
        jp_vehiculo.add(jSeparator12);
        jSeparator12.setBounds(135, 513, 323, 10);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/agregar-vehiculo.png"))); // NOI18N
        jp_vehiculo.add(jLabel31);
        jLabel31.setBounds(54, 70, 32, 32);

        jLabel32.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Registro de vehículos");
        jp_vehiculo.add(jLabel32);
        jLabel32.setBounds(98, 70, 200, 31);

        cb_marca.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Nissan", "Ford", "Yamaha", "Chevrolet", "Mercedes-Benz" }));
        cb_marca.setBorder(null);
        jp_vehiculo.add(cb_marca);
        cb_marca.setBounds(135, 463, 323, 44);

        jLabel33.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel33.setText("Modelo");
        jp_vehiculo.add(jLabel33);
        jLabel33.setBounds(702, 172, 117, 19);

        txt_color.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_color.setForeground(new java.awt.Color(102, 102, 102));
        txt_color.setText("Ingrese el color");
        txt_color.setBorder(null);
        txt_color.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_colorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_colorMousePressed(evt);
            }
        });
        txt_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_colorActionPerformed(evt);
            }
        });
        jp_vehiculo.add(txt_color);
        txt_color.setBounds(708, 330, 323, 44);

        jLabel34.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel34.setText("Color");
        jp_vehiculo.add(jLabel34);
        jLabel34.setBounds(703, 299, 88, 19);
        jp_vehiculo.add(jSeparator22);
        jSeparator22.setBounds(708, 376, 323, 10);

        btn_registrarV.setBackground(new java.awt.Color(116, 9, 56));
        btn_registrarV.setRoundBottomLeft(40);
        btn_registrarV.setRoundBottomRight(40);
        btn_registrarV.setRoundTopLeft(40);
        btn_registrarV.setRoundTopRight(40);

        lb_registrarV.setBackground(new java.awt.Color(51, 0, 0));
        lb_registrarV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_registrarV.setForeground(new java.awt.Color(255, 255, 255));
        lb_registrarV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_registrarV.setText("REGISTRAR");
        lb_registrarV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_registrarV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_registrarVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_registrarVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_registrarVMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_registrarVLayout = new javax.swing.GroupLayout(btn_registrarV);
        btn_registrarV.setLayout(btn_registrarVLayout);
        btn_registrarVLayout.setHorizontalGroup(
            btn_registrarVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registrarV, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        btn_registrarVLayout.setVerticalGroup(
            btn_registrarVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registrarV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jp_vehiculo.add(btn_registrarV);
        btn_registrarV.setBounds(120, 590, 140, 47);

        txt_modelo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(102, 102, 102));
        txt_modelo.setText("Ingrese el modelo");
        txt_modelo.setBorder(null);
        txt_modelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_modeloMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_modeloMousePressed(evt);
            }
        });
        txt_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeloActionPerformed(evt);
            }
        });
        jp_vehiculo.add(txt_modelo);
        txt_modelo.setBounds(702, 203, 323, 44);
        jp_vehiculo.add(jSeparator13);
        jSeparator13.setBounds(702, 249, 323, 10);

        cb_tipo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedán", "Furgoneta", "Motocicleta", "Pick-up" }));
        cb_tipo.setBorder(null);
        jp_vehiculo.add(cb_tipo);
        cb_tipo.setBounds(135, 330, 323, 44);

        btn_actualizarV.setBackground(new java.awt.Color(116, 9, 56));
        btn_actualizarV.setRoundBottomLeft(40);
        btn_actualizarV.setRoundBottomRight(40);
        btn_actualizarV.setRoundTopLeft(40);
        btn_actualizarV.setRoundTopRight(40);

        lb_actualizarV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_actualizarV.setForeground(new java.awt.Color(255, 255, 255));
        lb_actualizarV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_actualizarV.setText("ACTUALIZAR");
        lb_actualizarV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_actualizarV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_actualizarVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_actualizarVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_actualizarVMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_actualizarVLayout = new javax.swing.GroupLayout(btn_actualizarV);
        btn_actualizarV.setLayout(btn_actualizarVLayout);
        btn_actualizarVLayout.setHorizontalGroup(
            btn_actualizarVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_actualizarV, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        btn_actualizarVLayout.setVerticalGroup(
            btn_actualizarVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_actualizarV, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jp_vehiculo.add(btn_actualizarV);
        btn_actualizarV.setBounds(310, 590, 140, 47);

        btn_limpiar.setBackground(new java.awt.Color(102, 102, 102));
        btn_limpiar.setRoundBottomLeft(40);
        btn_limpiar.setRoundBottomRight(40);
        btn_limpiar.setRoundTopLeft(40);
        btn_limpiar.setRoundTopRight(40);

        lb_limpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        lb_limpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_limpiar.setText("LIMPIAR");
        lb_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_limpiarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_limpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_limpiarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_limpiarLayout = new javax.swing.GroupLayout(btn_limpiar);
        btn_limpiar.setLayout(btn_limpiarLayout);
        btn_limpiarLayout.setHorizontalGroup(
            btn_limpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_limpiarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_limpiarLayout.setVerticalGroup(
            btn_limpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_limpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jp_vehiculo.add(btn_limpiar);
        btn_limpiar.setBounds(805, 463, 142, 40);

        lb_buscarV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/buscar.png"))); // NOI18N
        lb_buscarV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_buscarV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_buscarVMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_buscarVMousePressed(evt);
            }
        });
        jp_vehiculo.add(lb_buscarV);
        lb_buscarV.setBounds(470, 203, 32, 44);

        centro.add(jp_vehiculo, "card9");

        jp_registros.setBackground(new java.awt.Color(255, 255, 255));

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/registro.png"))); // NOI18N

        jLabel96.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(102, 102, 102));
        jLabel96.setText("Registros");

        jtb_registros.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jtb_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jtb_registros);

        cb_tablas.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cb_tablas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuarios", "Vehiculos", "Membresias", "Hora x estacionamiento", " " }));

        jLabel97.setFont(new java.awt.Font("Louis George Cafe", 0, 17)); // NOI18N
        jLabel97.setText("¿Qué desea consultar?");

        btn_consultarR.setBackground(new java.awt.Color(102, 102, 102));
        btn_consultarR.setRoundBottomLeft(40);
        btn_consultarR.setRoundBottomRight(40);
        btn_consultarR.setRoundTopLeft(40);
        btn_consultarR.setRoundTopRight(40);

        lb_consultarR.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_consultarR.setForeground(new java.awt.Color(255, 255, 255));
        lb_consultarR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_consultarR.setText("CONSULTAR");
        lb_consultarR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_consultarR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_consultarRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_consultarRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_consultarRMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_consultarRLayout = new javax.swing.GroupLayout(btn_consultarR);
        btn_consultarR.setLayout(btn_consultarRLayout);
        btn_consultarRLayout.setHorizontalGroup(
            btn_consultarRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_consultarRLayout.createSequentialGroup()
                .addComponent(lb_consultarR, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        btn_consultarRLayout.setVerticalGroup(
            btn_consultarRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_consultarR, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_registrosLayout = new javax.swing.GroupLayout(jp_registros);
        jp_registros.setLayout(jp_registrosLayout);
        jp_registrosLayout.setHorizontalGroup(
            jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_registrosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel95)
                .addGap(11, 11, 11)
                .addGroup(jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96)
                    .addGroup(jp_registrosLayout.createSequentialGroup()
                        .addGroup(jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel97, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_tablas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(btn_consultarR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jp_registrosLayout.setVerticalGroup(
            jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_registrosLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jLabel97)
                .addGap(30, 30, 30)
                .addGroup(jp_registrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_tablas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_consultarR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );

        centro.add(jp_registros, "card5");

        jp_HorayFraccion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/tarifa-por-hora.png"))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("Estacionamiento x hora");

        jLabel39.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel39.setText("Placa");

        cb_placaEH.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cb_placaEH.setBorder(null);

        jLabel40.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel40.setText("Hora");

        txt_horaEH.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_horaEH.setText("jTextField13");
        txt_horaEH.setBorder(null);

        jLabel41.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel41.setText("Fecha");

        txt_fechaEH.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_fechaEH.setText("jTextField14");
        txt_fechaEH.setBorder(null);

        jLabel42.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel42.setText("Lugar");

        jsp_lugarEH.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jsp_lugarEH.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jLabel43.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel43.setText("Empleado ID");

        txt_empleadoEH.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_empleadoEH.setText("jTextField15");
        txt_empleadoEH.setBorder(null);
        txt_empleadoEH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empleadoEHActionPerformed(evt);
            }
        });

        btn_registrarEH.setBackground(new java.awt.Color(116, 9, 56));
        btn_registrarEH.setRoundBottomLeft(40);
        btn_registrarEH.setRoundBottomRight(40);
        btn_registrarEH.setRoundTopLeft(40);
        btn_registrarEH.setRoundTopRight(40);

        lb_registrarEH.setBackground(new java.awt.Color(116, 9, 56));
        lb_registrarEH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_registrarEH.setForeground(new java.awt.Color(255, 255, 255));
        lb_registrarEH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_registrarEH.setText("REGISTRAR");
        lb_registrarEH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_registrarEH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_registrarEHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_registrarEHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_registrarEHMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_registrarEHLayout = new javax.swing.GroupLayout(btn_registrarEH);
        btn_registrarEH.setLayout(btn_registrarEHLayout);
        btn_registrarEHLayout.setHorizontalGroup(
            btn_registrarEHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registrarEH, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        btn_registrarEHLayout.setVerticalGroup(
            btn_registrarEHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_registrarEH, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jLabel45.setFont(new java.awt.Font("Louis George Cafe", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Ticket");

        txtA_ticketEH.setColumns(20);
        txtA_ticketEH.setRows(5);
        jScrollPane5.setViewportView(txtA_ticketEH);

        btn_ticket.setBackground(new java.awt.Color(153, 193, 190));
        btn_ticket.setRoundBottomLeft(40);
        btn_ticket.setRoundTopRight(40);

        lb_ticket.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_ticket.setForeground(new java.awt.Color(255, 255, 255));
        lb_ticket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ticket.setText("TICKET");
        lb_ticket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_ticket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ticketMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_ticketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_ticketMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_ticketLayout = new javax.swing.GroupLayout(btn_ticket);
        btn_ticket.setLayout(btn_ticketLayout);
        btn_ticketLayout.setHorizontalGroup(
            btn_ticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_ticket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        btn_ticketLayout.setVerticalGroup(
            btn_ticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_HorayFraccionLayout = new javax.swing.GroupLayout(jp_HorayFraccion);
        jp_HorayFraccion.setLayout(jp_HorayFraccionLayout);
        jp_HorayFraccionLayout.setHorizontalGroup(
            jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HorayFraccionLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btn_registrarEH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)
                            .addComponent(cb_placaEH, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_horaEH, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37)))
                .addGap(90, 90, 90)
                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41)
                    .addComponent(txt_fechaEH, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(jLabel42)
                    .addComponent(jsp_lugarEH)
                    .addComponent(jLabel43)
                    .addComponent(txt_empleadoEH)
                    .addComponent(jSeparator26)
                    .addComponent(jSeparator27)
                    .addComponent(jSeparator37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );
        jp_HorayFraccionLayout.setVerticalGroup(
            jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(70, 70, 70)
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel39))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_fechaEH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_placaEH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator37, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HorayFraccionLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(8, 8, 8)
                                .addComponent(jsp_lugarEH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_HorayFraccionLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_horaEH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_empleadoEH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5)))
                .addGroup(jp_HorayFraccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btn_registrarEH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_HorayFraccionLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btn_ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(654, 654, 654))
        );

        centro.add(jp_HorayFraccion, "card6");

        jp_lugares.setBackground(new java.awt.Color(255, 255, 255));
        jp_lugares.setLayout(null);

        jLabel47.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/coche.png"))); // NOI18N
        jLabel47.setText("icon");
        jp_lugares.add(jLabel47);
        jLabel47.setBounds(60, 80, 30, 30);

        jLabel48.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("Lugares");
        jp_lugares.add(jLabel48);
        jLabel48.setBounds(110, 80, 80, 30);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp6.setBackground(new java.awt.Color(204, 204, 255));

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
            .addGap(0, 63, Short.MAX_VALUE)
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
            .addGap(0, 66, Short.MAX_VALUE)
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
        jPanel1.setBounds(170, 200, 866, 601);

        centro.add(jp_lugares, "card7");

        jp_salidaVehiculos.setBackground(new java.awt.Color(255, 255, 255));
        jp_salidaVehiculos.setLayout(null);

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/concesion.png"))); // NOI18N
        jp_salidaVehiculos.add(jLabel79);
        jLabel79.setBounds(60, 40, 30, 40);

        jLabel80.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(102, 102, 102));
        jLabel80.setText("Salida de vehículos");
        jp_salidaVehiculos.add(jLabel80);
        jLabel80.setBounds(100, 40, 160, 40);

        jLabel81.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel81.setText("Placa");
        jp_salidaVehiculos.add(jLabel81);
        jLabel81.setBounds(50, 116, 60, 19);

        cb_placaSV.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cb_placaSV.setBorder(null);
        jp_salidaVehiculos.add(cb_placaSV);
        cb_placaSV.setBounds(50, 142, 250, 40);

        jLabel85.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel85.setText("Fecha");
        jp_salidaVehiculos.add(jLabel85);
        jLabel85.setBounds(50, 290, 60, 19);

        jLabel86.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel86.setText("Lugar");
        jp_salidaVehiculos.add(jLabel86);
        jLabel86.setBounds(50, 380, 60, 19);

        jLabel87.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel87.setText("Costo");
        jp_salidaVehiculos.add(jLabel87);
        jLabel87.setBounds(50, 480, 50, 19);

        btn_buscarSV.setBackground(new java.awt.Color(102, 102, 102));
        btn_buscarSV.setRoundBottomLeft(20);
        btn_buscarSV.setRoundTopRight(20);

        lb_buscarSV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_buscarSV.setForeground(new java.awt.Color(255, 255, 255));
        lb_buscarSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_buscarSV.setText("BUSCAR");
        lb_buscarSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_buscarSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_buscarSVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_buscarSVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_buscarSVMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_buscarSVLayout = new javax.swing.GroupLayout(btn_buscarSV);
        btn_buscarSV.setLayout(btn_buscarSVLayout);
        btn_buscarSVLayout.setHorizontalGroup(
            btn_buscarSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_buscarSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        );
        btn_buscarSVLayout.setVerticalGroup(
            btn_buscarSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_buscarSV, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jp_salidaVehiculos.add(btn_buscarSV);
        btn_buscarSV.setBounds(316, 138, 91, 37);

        jPanel2.setLayout(null);

        jLabel89.setFont(new java.awt.Font("Louis George Cafe", 1, 18)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Calculador");
        jPanel2.add(jLabel89);
        jLabel89.setBounds(30, 20, 467, 22);

        jLabel82.setFont(new java.awt.Font("Louis George Cafe", 0, 15)); // NOI18N
        jLabel82.setText("Hora entrada");
        jPanel2.add(jLabel82);
        jLabel82.setBounds(30, 67, 90, 18);

        jLabel83.setFont(new java.awt.Font("Louis George Cafe", 0, 15)); // NOI18N
        jLabel83.setText("Hora salida");
        jPanel2.add(jLabel83);
        jLabel83.setBounds(380, 67, 100, 18);

        jLabel84.setFont(new java.awt.Font("Louis George Cafe", 0, 15)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Tiempo");
        jLabel84.setToolTipText("");
        jPanel2.add(jLabel84);
        jLabel84.setBounds(220, 70, 100, 20);

        txt_horaEntradaSV.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jPanel2.add(txt_horaEntradaSV);
        txt_horaEntradaSV.setBounds(30, 90, 129, 34);

        txt_HorasalidaSV.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jPanel2.add(txt_HorasalidaSV);
        txt_HorasalidaSV.setBounds(380, 90, 113, 34);

        lb_tiempoSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tiempoSV.setText("mm");
        jPanel2.add(lb_tiempoSV);
        lb_tiempoSV.setBounds(220, 90, 103, 34);

        btn_calcularTiemCost.setBackground(new java.awt.Color(204, 239, 181));
        btn_calcularTiemCost.setRoundBottomLeft(40);
        btn_calcularTiemCost.setRoundTopRight(40);

        lb_calcularTiemCost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_calcularTiemCost.setForeground(new java.awt.Color(102, 102, 102));
        lb_calcularTiemCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_calcularTiemCost.setText("CALCULAR");
        lb_calcularTiemCost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_calcularTiemCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_calcularTiemCostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_calcularTiemCostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_calcularTiemCostMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_calcularTiemCostLayout = new javax.swing.GroupLayout(btn_calcularTiemCost);
        btn_calcularTiemCost.setLayout(btn_calcularTiemCostLayout);
        btn_calcularTiemCostLayout.setHorizontalGroup(
            btn_calcularTiemCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_calcularTiemCost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btn_calcularTiemCostLayout.setVerticalGroup(
            btn_calcularTiemCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_calcularTiemCost, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel2.add(btn_calcularTiemCost);
        btn_calcularTiemCost.setBounds(220, 160, 110, 42);

        jp_salidaVehiculos.add(jPanel2);
        jPanel2.setBounds(480, 80, 530, 230);

        jLabel92.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel92.setText("id_estacionamiento");
        jp_salidaVehiculos.add(jLabel92);
        jLabel92.setBounds(50, 200, 140, 19);
        jp_salidaVehiculos.add(jSeparator32);
        jSeparator32.setBounds(50, 181, 240, 10);

        txt_idEstSV.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_idEstSV.setForeground(new java.awt.Color(102, 102, 102));
        txt_idEstSV.setText("Ingrese el ID del cajón");
        txt_idEstSV.setBorder(null);
        txt_idEstSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_idEstSVMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_idEstSVMousePressed(evt);
            }
        });
        jp_salidaVehiculos.add(txt_idEstSV);
        txt_idEstSV.setBounds(50, 220, 250, 40);
        jp_salidaVehiculos.add(jSeparator33);
        jSeparator33.setBounds(50, 260, 250, 10);

        txt_fechaSV.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_fechaSV.setText("jTextField19");
        txt_fechaSV.setBorder(null);
        jp_salidaVehiculos.add(txt_fechaSV);
        txt_fechaSV.setBounds(50, 310, 250, 40);
        jp_salidaVehiculos.add(jSeparator34);
        jSeparator34.setBounds(50, 450, 240, 10);

        txt_costoSV.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_costoSV.setForeground(new java.awt.Color(102, 102, 102));
        txt_costoSV.setText("Ingrese el costo");
        txt_costoSV.setBorder(null);
        txt_costoSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_costoSVMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_costoSVMousePressed(evt);
            }
        });
        jp_salidaVehiculos.add(txt_costoSV);
        txt_costoSV.setBounds(50, 510, 240, 40);
        jp_salidaVehiculos.add(jSeparator35);
        jSeparator35.setBounds(50, 560, 240, 10);

        btn_pagarSV.setBackground(new java.awt.Color(116, 9, 56));
        btn_pagarSV.setRoundBottomLeft(40);
        btn_pagarSV.setRoundBottomRight(40);
        btn_pagarSV.setRoundTopLeft(40);
        btn_pagarSV.setRoundTopRight(40);

        lb_pagarSV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_pagarSV.setForeground(new java.awt.Color(255, 255, 255));
        lb_pagarSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pagarSV.setText("PAGAR");
        lb_pagarSV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_pagarSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_pagarSVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_pagarSVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_pagarSVMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_pagarSVLayout = new javax.swing.GroupLayout(btn_pagarSV);
        btn_pagarSV.setLayout(btn_pagarSVLayout);
        btn_pagarSVLayout.setHorizontalGroup(
            btn_pagarSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_pagarSV, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        btn_pagarSVLayout.setVerticalGroup(
            btn_pagarSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_pagarSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jp_salidaVehiculos.add(btn_pagarSV);
        btn_pagarSV.setBounds(90, 590, 139, 51);

        jLabel94.setFont(new java.awt.Font("Louis George Cafe", 1, 16)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(102, 102, 102));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Ticket");
        jp_salidaVehiculos.add(jLabel94);
        jLabel94.setBounds(556, 350, 360, 19);

        txtA_ticketSV.setColumns(20);
        txtA_ticketSV.setRows(5);
        jScrollPane3.setViewportView(txtA_ticketSV);

        jp_salidaVehiculos.add(jScrollPane3);
        jScrollPane3.setBounds(580, 410, 360, 310);
        jp_salidaVehiculos.add(jsp_lugarSV);
        jsp_lugarSV.setBounds(50, 410, 240, 40);
        jp_salidaVehiculos.add(jSeparator36);
        jSeparator36.setBounds(50, 350, 250, 10);

        btn_ticketSV.setBackground(new java.awt.Color(153, 193, 190));
        btn_ticketSV.setRoundBottomLeft(40);
        btn_ticketSV.setRoundTopRight(40);

        lb_ticketSV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_ticketSV.setForeground(new java.awt.Color(255, 255, 255));
        lb_ticketSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ticketSV.setText("TICKET");
        lb_ticketSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ticketSVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_ticketSVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_ticketSVMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_ticketSVLayout = new javax.swing.GroupLayout(btn_ticketSV);
        btn_ticketSV.setLayout(btn_ticketSVLayout);
        btn_ticketSVLayout.setHorizontalGroup(
            btn_ticketSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_ticketSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        btn_ticketSVLayout.setVerticalGroup(
            btn_ticketSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_ticketSV, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jp_salidaVehiculos.add(btn_ticketSV);
        btn_ticketSV.setBounds(700, 780, 140, 50);

        centro.add(jp_salidaVehiculos, "card8");

        jp_membresia.setBackground(new java.awt.Color(255, 255, 255));
        jp_membresia.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/afiliacion.png"))); // NOI18N
        jp_membresia.add(jLabel1);
        jLabel1.setBounds(39, 51, 40, 28);

        jLabel5.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Membresia");
        jp_membresia.add(jLabel5);
        jLabel5.setBounds(87, 50, 150, 30);

        jLabel6.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel6.setText("Id membresia");
        jp_membresia.add(jLabel6);
        jLabel6.setBounds(39, 130, 120, 19);

        txt_idmembresiaMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_idmembresiaMD.setForeground(new java.awt.Color(102, 102, 102));
        txt_idmembresiaMD.setText("Ingrese el ID de la membresia");
        txt_idmembresiaMD.setBorder(null);
        txt_idmembresiaMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_idmembresiaMDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_idmembresiaMDMousePressed(evt);
            }
        });
        txt_idmembresiaMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idmembresiaMDActionPerformed(evt);
            }
        });
        jp_membresia.add(txt_idmembresiaMD);
        txt_idmembresiaMD.setBounds(39, 170, 212, 40);
        jp_membresia.add(jSeparator9);
        jSeparator9.setBounds(39, 213, 213, 16);

        jLabel12.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel12.setText("Hora");
        jp_membresia.add(jLabel12);
        jLabel12.setBounds(39, 235, 70, 19);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/usuario.png"))); // NOI18N
        jp_membresia.add(jLabel13);
        jLabel13.setBounds(550, 58, 32, 32);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Creato Display", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Cliente");
        jp_membresia.add(jLabel15);
        jLabel15.setBounds(600, 60, 96, 30);

        jLabel17.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel17.setText("Placa");
        jp_membresia.add(jLabel17);
        jLabel17.setBounds(320, 235, 70, 19);

        cb_placaMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cb_placaMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_placaMDActionPerformed(evt);
            }
        });
        jp_membresia.add(cb_placaMD);
        cb_placaMD.setBounds(320, 270, 144, 40);
        jp_membresia.add(jSeparator14);
        jSeparator14.setBounds(320, 310, 144, 22);

        txt_horaMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_horaMD.setBorder(null);
        txt_horaMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_horaMDActionPerformed(evt);
            }
        });
        jp_membresia.add(txt_horaMD);
        txt_horaMD.setBounds(40, 270, 212, 40);
        jp_membresia.add(jSeparator15);
        jSeparator15.setBounds(39, 310, 213, 10);

        jLabel18.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel18.setText("Fecha");
        jp_membresia.add(jLabel18);
        jLabel18.setBounds(39, 338, 80, 19);

        txt_fechaMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_fechaMD.setBorder(null);
        txt_fechaMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaMDActionPerformed(evt);
            }
        });
        jp_membresia.add(txt_fechaMD);
        txt_fechaMD.setBounds(40, 370, 212, 40);
        jp_membresia.add(jSeparator16);
        jSeparator16.setBounds(39, 411, 213, 10);

        jLabel24.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel24.setText("Costo");
        jp_membresia.add(jLabel24);
        jLabel24.setBounds(39, 439, 80, 19);

        txt_costoMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_costoMD.setForeground(new java.awt.Color(102, 102, 102));
        txt_costoMD.setText("Ingrese el costo");
        txt_costoMD.setBorder(null);
        txt_costoMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_costoMDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_costoMDMousePressed(evt);
            }
        });
        txt_costoMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costoMDActionPerformed(evt);
            }
        });
        jp_membresia.add(txt_costoMD);
        txt_costoMD.setBounds(40, 470, 212, 40);
        jp_membresia.add(jSeparator17);
        jSeparator17.setBounds(39, 512, 213, 10);

        jLabel25.setFont(new java.awt.Font("Louis George Cafe", 0, 15)); // NOI18N
        jLabel25.setText("Cajón");
        jp_membresia.add(jLabel25);
        jLabel25.setBounds(320, 130, 190, 19);

        jsp_lugarMD.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));
        jp_membresia.add(jsp_lugarMD);
        jsp_lugarMD.setBounds(320, 170, 140, 40);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jp_membresia.add(jSeparator18);
        jSeparator18.setBounds(510, 90, 16, 520);

        jLabel26.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel26.setText("Atiende ID");
        jp_membresia.add(jLabel26);
        jLabel26.setBounds(39, 540, 100, 19);

        txt_empleadoMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jp_membresia.add(txt_empleadoMD);
        txt_empleadoMD.setBounds(39, 568, 440, 37);

        btn_registrarMD.setBackground(new java.awt.Color(116, 9, 56));
        btn_registrarMD.setRoundBottomLeft(40);
        btn_registrarMD.setRoundBottomRight(40);
        btn_registrarMD.setRoundTopLeft(40);
        btn_registrarMD.setRoundTopRight(40);

        lb_resgistrarMD.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lb_resgistrarMD.setForeground(new java.awt.Color(255, 255, 255));
        lb_resgistrarMD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_resgistrarMD.setText("REGISTRAR");
        lb_resgistrarMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_resgistrarMDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_resgistrarMDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_resgistrarMDMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_registrarMDLayout = new javax.swing.GroupLayout(btn_registrarMD);
        btn_registrarMD.setLayout(btn_registrarMDLayout);
        btn_registrarMDLayout.setHorizontalGroup(
            btn_registrarMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_resgistrarMD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        btn_registrarMDLayout.setVerticalGroup(
            btn_registrarMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_resgistrarMD, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jp_membresia.add(btn_registrarMD);
        btn_registrarMD.setBounds(40, 670, 160, 50);

        jLabel27.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel27.setText("id_dueño");
        jp_membresia.add(jLabel27);
        jLabel27.setBounds(550, 140, 90, 19);

        jLabel29.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel29.setText("Nombre completo");
        jp_membresia.add(jLabel29);
        jLabel29.setBounds(550, 230, 140, 19);

        jLabel30.setFont(new java.awt.Font("Louis George Cafe", 0, 16)); // NOI18N
        jLabel30.setText("Identificación");
        jp_membresia.add(jLabel30);
        jLabel30.setBounds(550, 330, 110, 19);

        txt_idueñoMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_idueñoMD.setForeground(new java.awt.Color(102, 102, 102));
        txt_idueñoMD.setText("Ingrese el ID del dueño");
        txt_idueñoMD.setBorder(null);
        txt_idueñoMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_idueñoMDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_idueñoMDMousePressed(evt);
            }
        });
        txt_idueñoMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idueñoMDActionPerformed(evt);
            }
        });
        jp_membresia.add(txt_idueñoMD);
        txt_idueñoMD.setBounds(550, 170, 212, 40);

        txt_nombrecompletoMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_nombrecompletoMD.setForeground(new java.awt.Color(102, 102, 102));
        txt_nombrecompletoMD.setText("Ingrese el nombre completo");
        txt_nombrecompletoMD.setBorder(null);
        txt_nombrecompletoMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nombrecompletoMDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_nombrecompletoMDMousePressed(evt);
            }
        });
        jp_membresia.add(txt_nombrecompletoMD);
        txt_nombrecompletoMD.setBounds(550, 259, 212, 40);

        txt_identificacionMD.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txt_identificacionMD.setForeground(new java.awt.Color(102, 102, 102));
        txt_identificacionMD.setText("Ingrese la identificación");
        txt_identificacionMD.setBorder(null);
        txt_identificacionMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_identificacionMDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_identificacionMDMousePressed(evt);
            }
        });
        jp_membresia.add(txt_identificacionMD);
        txt_identificacionMD.setBounds(550, 360, 212, 40);
        jp_membresia.add(jSeparator19);
        jSeparator19.setBounds(550, 210, 212, 10);
        jp_membresia.add(jSeparator20);
        jSeparator20.setBounds(550, 300, 212, 10);
        jp_membresia.add(jSeparator21);
        jSeparator21.setBounds(550, 403, 212, 10);

        jLabel46.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Ticket");
        jp_membresia.add(jLabel46);
        jLabel46.setBounds(840, 90, 270, 20);

        txtA_ticketMD.setColumns(20);
        txtA_ticketMD.setRows(5);
        jScrollPane2.setViewportView(txtA_ticketMD);

        jScrollPane1.setViewportView(jScrollPane2);

        jp_membresia.add(jScrollPane1);
        jScrollPane1.setBounds(840, 130, 300, 280);

        btn_dueñoMD.setBackground(new java.awt.Color(116, 9, 56));
        btn_dueñoMD.setRoundBottomLeft(40);
        btn_dueñoMD.setRoundBottomRight(40);
        btn_dueñoMD.setRoundTopLeft(40);
        btn_dueñoMD.setRoundTopRight(40);

        lb_dueñoMD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_dueñoMD.setForeground(new java.awt.Color(255, 255, 255));
        lb_dueñoMD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_dueñoMD.setText("REGISTRAR DUEÑO");
        lb_dueñoMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_dueñoMDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_dueñoMDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_dueñoMDMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_dueñoMDLayout = new javax.swing.GroupLayout(btn_dueñoMD);
        btn_dueñoMD.setLayout(btn_dueñoMDLayout);
        btn_dueñoMDLayout.setHorizontalGroup(
            btn_dueñoMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_dueñoMD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        btn_dueñoMDLayout.setVerticalGroup(
            btn_dueñoMDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_dueñoMD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jp_membresia.add(btn_dueñoMD);
        btn_dueñoMD.setBounds(570, 450, 170, 50);

        btn_ticketMem.setBackground(new java.awt.Color(153, 193, 190));
        btn_ticketMem.setForeground(new java.awt.Color(102, 102, 102));
        btn_ticketMem.setRoundBottomLeft(40);
        btn_ticketMem.setRoundTopRight(40);

        lb_ticketMem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_ticketMem.setForeground(new java.awt.Color(255, 255, 255));
        lb_ticketMem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ticketMem.setText("TICKET");
        lb_ticketMem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ticketMemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_ticketMemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_ticketMemMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_ticketMemLayout = new javax.swing.GroupLayout(btn_ticketMem);
        btn_ticketMem.setLayout(btn_ticketMemLayout);
        btn_ticketMemLayout.setHorizontalGroup(
            btn_ticketMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_ticketMem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btn_ticketMemLayout.setVerticalGroup(
            btn_ticketMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_ticketMem, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jp_membresia.add(btn_ticketMem);
        btn_ticketMem.setBounds(930, 450, 130, 50);

        btn_buscarCMD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/buscar.png"))); // NOI18N
        btn_buscarCMD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscarCMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarCMDMouseClicked(evt);
            }
        });
        jp_membresia.add(btn_buscarCMD);
        btn_buscarCMD.setBounds(770, 170, 40, 40);

        btn_limpMem.setBackground(new java.awt.Color(102, 102, 102));
        btn_limpMem.setRoundBottomLeft(40);
        btn_limpMem.setRoundBottomRight(40);
        btn_limpMem.setRoundTopLeft(40);
        btn_limpMem.setRoundTopRight(40);

        lb_limpMem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_limpMem.setForeground(new java.awt.Color(255, 255, 255));
        lb_limpMem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_limpMem.setText("LIMPIAR");
        lb_limpMem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_limpMemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_limpMemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_limpMemMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_limpMemLayout = new javax.swing.GroupLayout(btn_limpMem);
        btn_limpMem.setLayout(btn_limpMemLayout);
        btn_limpMemLayout.setHorizontalGroup(
            btn_limpMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_limpMem, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        btn_limpMemLayout.setVerticalGroup(
            btn_limpMemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_limpMem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jp_membresia.add(btn_limpMem);
        btn_limpMem.setBounds(260, 670, 160, 50);

        btn_salida.setBackground(new java.awt.Color(33, 33, 137));
        btn_salida.setForeground(new java.awt.Color(0, 51, 102));
        btn_salida.setRoundBottomLeft(40);
        btn_salida.setRoundTopRight(40);

        lb_salida.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lb_salida.setForeground(new java.awt.Color(255, 255, 255));
        lb_salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_salida.setText("SALIDA");
        lb_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_salidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_salidaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout btn_salidaLayout = new javax.swing.GroupLayout(btn_salida);
        btn_salida.setLayout(btn_salidaLayout);
        btn_salidaLayout.setHorizontalGroup(
            btn_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_salida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btn_salidaLayout.setVerticalGroup(
            btn_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_salida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jp_membresia.add(btn_salida);
        btn_salida.setBounds(690, 670, 130, 47);

        btn_renovar.setBackground(new java.awt.Color(33, 33, 137));
        btn_renovar.setForeground(new java.awt.Color(0, 51, 102));
        btn_renovar.setRoundBottomLeft(40);
        btn_renovar.setRoundTopRight(40);

        lb_renovar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lb_renovar.setForeground(new java.awt.Color(255, 255, 255));
        lb_renovar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_renovar.setText("RENOVAR");
        lb_renovar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_renovarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_renovarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_renovarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btn_renovarLayout = new javax.swing.GroupLayout(btn_renovar);
        btn_renovar.setLayout(btn_renovarLayout);
        btn_renovarLayout.setHorizontalGroup(
            btn_renovarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_renovar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        btn_renovarLayout.setVerticalGroup(
            btn_renovarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_renovar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jp_membresia.add(btn_renovar);
        btn_renovar.setBounds(490, 670, 130, 47);

        lb_membresiaMD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/buscar.png"))); // NOI18N
        lb_membresiaMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_membresiaMDMouseClicked(evt);
            }
        });
        jp_membresia.add(lb_membresiaMD);
        lb_membresiaMD.setBounds(260, 170, 40, 40);

        centro.add(jp_membresia, "card4");

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
        btn_exit.setBackground(new Color(175, 23, 64)); //Rojo  [175,23,64]
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
        btn_minmax.setBackground(new Color(175, 23, 64)); //Rojo  [175,23,64]
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
        btn_min.setBackground(new Color(175, 23, 64)); //Rojo  [175,23,64]
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

                    // Limpiar los campos de texto y restablecer los controles
                    txt_iduser.setText("");
                    txt_nombre.setText("");
                    txt_telefono.setText("");
                    txt_curp.setText("");
                    txtContraseña.setText("");
                    cmbRol1.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
                    CB_estacionamiento.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado 

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
        // Comparar el texto del botón con "registrar"
        if (!lb_registrar.getText().equals("registrar")) {
            btn_registrar.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a blanco
            lb_registrar.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color azul
        }
    }//GEN-LAST:event_lb_registrarMouseEntered

    private void lb_registrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarMouseExited
        btn_registrar.setBackground(new Color(116, 9, 56)); //Rojo  [175,23,64]
        lb_registrar.setForeground(Color.white);
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

        txt_iduser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Validar que solo se ingresen números
                if (!Character.isDigit(c)) {
                    e.consume();  // Bloquea la entrada si no es un número
                    JOptionPane.showMessageDialog(null, "Solo se permiten números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                // Si el texto ya tiene 8 caracteres y se intenta ingresar más, se bloquea la entrada
                if (txt_iduser.getText().length() >= 8) {
                    e.consume();  // Bloquea la entrada de más caracteres
                    JOptionPane.showMessageDialog(null, "Ingreso más de los caracteres esperados (8 caracteres)", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
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
        // Si el campo está vacío, restauramos el marcador de posición
        if (String.valueOf(txtContraseña.getPassword()).isEmpty()) {
            txtContraseña.setText("**************"); // Restaura el marcador de posición
            txtContraseña.setForeground(new Color(102, 102, 102)); // Cambia el texto a gris
            txtContraseña.setEchoChar((char) 0); // Desactiva el enmascarado para mostrar el marcador
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

    private void txt_fechaMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaMDActionPerformed

    private void cb_placaMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_placaMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_placaMDActionPerformed

    private void txt_empleadoEHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empleadoEHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empleadoEHActionPerformed

    // ------------------ Actualiza los registro USUARIOS -------------------------------------------------
    private void lb_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_actualizarMouseClicked

        // Capturar los datos de los campos de texto del formulario
        String id_usuario = txt_iduser.getText();
        String nombre = txt_nombre.getText();
        String telefono = txt_telefono.getText();
        String rol = cmbRol1.getSelectedItem().toString();
        String curp = txt_curp.getText();
        String estacionamiento = CB_estacionamiento.getSelectedItem().toString();
        String contraseña = new String(txtContraseña.getPassword());

        // Establecer la conexión
        Connection con = conexion.getConection();
        if (con != null) {
            try {
                // Crear la consulta SQL para actualizar los datos
                String sql = "UPDATE usuario SET Nombre = ?, Telefono = ?, Rango = ?, CURP = ?, id_estacionamiento = ?, Contraseña = ? WHERE id_usuario = ?";

                // Preparar la sentencia SQL
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, telefono);
                ps.setString(3, rol);
                ps.setString(4, curp);
                ps.setString(5, estacionamiento);
                ps.setString(6, contraseña);
                ps.setString(7, id_usuario);

                // Ejecutar la consulta
                int rowsAffected = ps.executeUpdate();

                // Verificar si la actualización fue exitosa
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Datos del usuario actualizados exitosamente.");

                    // Limpiar los campos de texto y restablecer los controles
                    txt_iduser.setText("");
                    txt_nombre.setText("");
                    txt_telefono.setText("");
                    txt_curp.setText("");
                    txtContraseña.setText("");
                    cmbRol1.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
                    CB_estacionamiento.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos del usuario.");
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

    }//GEN-LAST:event_lb_actualizarMouseClicked

    private void lb_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_actualizarMouseEntered
        if (!lb_actualizar.getText().equals("actualizar")) {
            btn_actualizarU.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a rojo bajo
            lb_actualizar.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_actualizarMouseEntered

    private void lb_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_actualizarMouseExited
        btn_actualizarU.setBackground(new Color(116, 9, 56)); //Rojo  [175,23,64]
        lb_actualizar.setForeground(Color.white);
    }//GEN-LAST:event_lb_actualizarMouseExited

    // ------------------------- BOTON REGITRAr AUTOMOVILESS --------------------------------------------
    private void lb_registrarVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarVMouseClicked

        // Capturar los datos de los campos de texto del formulario
        String placa = txt_placa.getText().trim();
        String tipo = cb_tipo.getSelectedItem().toString();
        String marca = cb_marca.getSelectedItem().toString();
        String modelo = txt_modelo.getText().trim();
        String color = txt_color.getText().trim();

        // Validar que los campos no estén vacíos
        if (placa.isEmpty() || tipo.isEmpty() || marca.isEmpty() || modelo.isEmpty() || color.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de registrar el vehículo.");
            return;
        }

        // Conexión a la base de datos
        try (Connection con = conexion.getConection(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO vehiculo (Placa, Tipo, Marca, Modelo, Color) VALUES (?, ?, ?, ?, ?)")) {

            // Configurar los parámetros de la consulta
            ps.setString(1, placa);
            ps.setString(2, tipo);
            ps.setString(3, marca);
            ps.setString(4, modelo);
            ps.setString(5, color);

            // Ejecutar la consulta
            int rowsAffected = ps.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Vehículo registrado exitosamente.");

                // Limpiar los campos de texto y restablecer los controles
                txt_placa.setText("");
                cb_tipo.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
                cb_marca.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
                txt_modelo.setText("");
                txt_color.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar vehículo.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el vehículo: " + e.getMessage());
            e.printStackTrace(); // Solo para depuración
        }
    }//GEN-LAST:event_lb_registrarVMouseClicked

    private void lb_registrarVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarVMouseEntered
        if (!lb_registrarV.getText().equals("registrar")) {
            btn_registrarV.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a rojo
            lb_registrarV.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_registrarVMouseEntered

    private void lb_registrarVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarVMouseExited
        btn_registrarV.setBackground(new Color(116, 9, 56)); //Rojo  
        lb_registrarV.setForeground(Color.white);
    }//GEN-LAST:event_lb_registrarVMouseExited

    //------------------------------------------- ACTUALIZAR DATOS VEHICULO -------------------------
    private void lb_actualizarVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_actualizarVMouseClicked
        // Capturar los datos de los campos de texto del formulario
        // Capturar los datos de los campos de texto del formulario
        String placa = txt_placa.getText(); // Nueva placa
        String tipo = cb_tipo.getSelectedItem().toString();
        String marca = cb_marca.getSelectedItem().toString();
        String modelo = txt_modelo.getText();
        String color = txt_color.getText();

        // Si tienes un campo para la placa original, úsalo. Por ahora, asumiremos que hay una variable placaOriginal.
        String placaOriginal = txt_placa.getText();

        // Establecer la conexión
        Connection con = conexion.getConection();
        if (con != null) {
            try {
                // Crear la consulta SQL para actualizar los datos
                String sql = "UPDATE vehiculo SET Placa = ?, Tipo = ?, Marca = ?, Modelo = ?, Color = ? WHERE Placa = ?";

                // Preparar la sentencia SQL
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, placa);          // Nueva placa
                ps.setString(2, tipo);
                ps.setString(3, marca);
                ps.setString(4, modelo);
                ps.setString(5, color);
                ps.setString(6, placaOriginal); // Placa original para identificar el registro

                // Ejecutar la consulta
                int rowsAffected = ps.executeUpdate();

                // Verificar si la actualización fue exitosa
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Datos del vehículo actualizados exitosamente.");

                    // Limpiar los campos de texto y restablecer los controles
                    txt_placa.setText("");
                    txt_placa.setText(""); // Limpiar también este campo
                    cb_tipo.setSelectedIndex(0);   // Restablecer JComboBox al valor predeterminado
                    cb_marca.setSelectedIndex(0);  // Restablecer JComboBox al valor predeterminado
                    txt_modelo.setText("");
                    txt_color.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos del vehículo.");
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
    }//GEN-LAST:event_lb_actualizarVMouseClicked

    private void lb_actualizarVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_actualizarVMouseEntered
        if (!lb_actualizarV.getText().equals("actualizar")) {
            btn_actualizarV.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a rojo
            lb_actualizarV.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_actualizarVMouseEntered

    private void lb_actualizarVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_actualizarVMouseExited
        btn_actualizarV.setBackground(new Color(116, 9, 56)); //Rojo  
        lb_actualizarV.setForeground(Color.white);
    }//GEN-LAST:event_lb_actualizarVMouseExited

    private void lb_limpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpiarMouseClicked
        // Limpiar los campos de texto y restablecer los controles
        txt_placa.setText("");
        cb_tipo.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
        cb_marca.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
        txt_modelo.setText("");
        txt_color.setText("");
    }//GEN-LAST:event_lb_limpiarMouseClicked

    // --------------------------- Membresia --------------------------------------------
    private void lb_resgistrarMDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_resgistrarMDMouseClicked

        String idMembresia = txt_idmembresiaMD.getText();
        String placa = cb_placaMD.getSelectedItem().toString();
        String hora = txt_horaMD.getText();
        String fecha = txt_fechaMD.getText();
        String costo = txt_costoMD.getText();
        int lugar = (int) jsp_lugarMD.getValue();
        String empleado = txt_empleadoMD.getText();
        String idDueño = txt_idueñoMD.getText();

        Connection con = null;

        try {
            con = conexion.getConection();

            // Verificar si el lugar de estacionamiento está disponible
            String queryCheckLugar = "SELECT espaciodisp_ocup FROM espacio_lugar WHERE id_espacio = ?";
            PreparedStatement pstCheckLugar = con.prepareStatement(queryCheckLugar);
            pstCheckLugar.setInt(1, lugar);
            ResultSet rs = pstCheckLugar.executeQuery();

            if (rs.next()) {
                String estado = rs.getString("espaciodisp_ocup");
                if ("Ocupado".equalsIgnoreCase(estado)) {
                    JOptionPane.showMessageDialog(this, "El lugar de estacionamiento ya está ocupado. Seleccione otro lugar.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El lugar de estacionamiento no existe.");
                return;
            }

            String queryRegistrarMembresia = "INSERT INTO membresia (id_membresia, Placa, hora, fecha, costo, id_espacio, id_usuario, Id_DueñoV) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstRegistrarMembresia = con.prepareStatement(queryRegistrarMembresia);

            // Asignar los valores
            pstRegistrarMembresia.setString(1, idMembresia);
            pstRegistrarMembresia.setString(2, placa);
            pstRegistrarMembresia.setString(3, hora);
            pstRegistrarMembresia.setString(4, fecha);
            pstRegistrarMembresia.setString(5, costo);
            pstRegistrarMembresia.setInt(6, lugar);
            pstRegistrarMembresia.setString(7, empleado);
            pstRegistrarMembresia.setString(8, idDueño);

            // Ejecutar la consulta
            int filasAfectadas = pstRegistrarMembresia.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Membresía registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar la membresía.");
            }

            // Actualizar el estado del lugar a "Ocupado"
            String queryActualizarLugar = "UPDATE espacio_lugar SET espaciodisp_ocup = 'Ocupado' WHERE id_espacio = ?";
            PreparedStatement pstActualizarLugar = con.prepareStatement(queryActualizarLugar);
            pstActualizarLugar.setInt(1, lugar);
            pstActualizarLugar.executeUpdate();

            JOptionPane.showMessageDialog(this, "Lugar actualizado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la membresía: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_lb_resgistrarMDMouseClicked

    private void lb_consultarRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_consultarRMouseClicked

        Connection con = conexion.getConection(); // Usa tu clase de conexión
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Obtener el valor seleccionado del JComboBox
        String seleccion = cb_tablas.getSelectedItem().toString(); // Cambia 'jComboBoxTablas' al nombre correcto de tu JComboBox

        // Variables para almacenar el nombre real de la tabla y los encabezados
        String nombreTabla = "";
        String[] encabezados = {};

        // Usar un switch para asignar el nombre real de la tabla y los encabezados
        switch (seleccion) {
            case "Usuarios": // Nombre mostrado en el JComboBox
                nombreTabla = "usuario"; // Nombre real de la tabla
                encabezados = new String[]{"ID", "Nombre", "Telefono", "Rango", "Curp", "Sucursal"}; // Ajusta los encabezados
                break;
            case "Vehiculos":
                nombreTabla = "vehiculo";
                encabezados = new String[]{"Placa", "Tipo", "Marca", "Model", "Color"}; // Ajusta los encabezados
                break;
            case "Membresias":
                nombreTabla = "membresia";
                encabezados = new String[]{"ID", "Placa", "Hora", "Fecha", "Costo", "Lugar", "Empleado", "Dueño"}; // Ajusta los encabezados
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tabla no válida seleccionada");
                return; // Detener la ejecución si no es una selección válida
        }

        // Construir la consulta SQL
        String consultaSQL = "SELECT * FROM " + nombreTabla;

        try {
            ps = con.prepareStatement(consultaSQL);
            rs = ps.executeQuery();

            // Configurar modelo de la tabla con encabezados dinámicos
            DefaultTableModel modelo = new DefaultTableModel(encabezados, 0); // 0 indica sin filas iniciales
            jtb_registros.setModel(modelo); // Asignar el nuevo modelo a la JTable

            // Cargar datos a la tabla
            int columnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la consulta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_lb_consultarRMouseClicked

    private void txt_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placaActionPerformed

    private void txt_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modeloActionPerformed

    private void txt_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_colorActionPerformed

    private void txt_placaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_placaMouseExited
        if (txt_placa.getText().isEmpty()) {
            txt_placa.setText("Ingrese la placa");
            txt_placa.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_placaMouseExited

    private void txt_placaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_placaMousePressed
        if (txt_placa.getText().equals("Ingrese la placa")) {
            txt_placa.setText("");
            txt_placa.setForeground(Color.black);
        }

        txt_placa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Si el texto ya tiene 9 caracteres y se intenta ingresar más, se bloquea la entrada
                if (txt_placa.getText().length() >= 9) {
                    e.consume();  // Bloquea la entrada de más caracteres
                    JOptionPane.showMessageDialog(null, "Ingreso más de los caracteres esperados (9 caracteres)", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_txt_placaMousePressed

    private void txt_modeloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_modeloMouseExited
        if (txt_modelo.getText().isEmpty()) {
            txt_modelo.setText("Ingrese el modelo");
            txt_modelo.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_modeloMouseExited

    private void txt_modeloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_modeloMousePressed
        if (txt_modelo.getText().equals("Ingrese el modelo")) {
            txt_modelo.setText("");
            txt_modelo.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_modeloMousePressed

    private void txt_colorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_colorMouseExited
        if (txt_color.getText().isEmpty()) {
            txt_color.setText("Ingrese el color");
            txt_color.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_colorMouseExited

    private void txt_colorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_colorMousePressed
        if (txt_color.getText().equals("Ingrese el color")) {
            txt_color.setText("");
            txt_color.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_colorMousePressed

    private void lb_buscarVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_buscarVMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_buscarVMousePressed

    private void lb_buscarVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_buscarVMouseClicked
        // Capturar la placa ingresada por el usuario
        String placa = txt_placa.getText(); // txt_placa es el JTextField donde el usuario ingresa la placa

        // Establecer la conexión
        Connection con = conexion.getConection();
        if (con != null) {
            try {
                // Crear la consulta SQL para buscar los datos
                String sql = "SELECT Placa, Tipo, Marca, Modelo, Color FROM vehiculo WHERE Placa = ?";

                // Preparar la sentencia SQL
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, placa);

                // Ejecutar la consulta
                ResultSet rs = ps.executeQuery();

                // Verificar si se encontró un resultado
                if (rs.next()) {
                    // Rellenar los campos del formulario con los datos obtenidos
                    txt_placa.setText(rs.getString("Placa"));
                    cb_tipo.setSelectedItem(rs.getString("Tipo")); // jComboBox
                    cb_marca.setSelectedItem(rs.getString("Marca")); // jComboBox
                    txt_modelo.setText(rs.getString("Modelo"));
                    txt_color.setText(rs.getString("Color"));

                    JOptionPane.showMessageDialog(null, "Datos encontrados.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para la placa ingresada.");
                }

                // Cerrar ResultSet y PreparedStatement
                rs.close();
                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
        }
    }//GEN-LAST:event_lb_buscarVMouseClicked

    private void txtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMousePressed
        // Si el campo contiene el marcador de posición "**************", lo limpiamos
        if (String.valueOf(txtContraseña.getPassword()).equals("**************")) {
            txtContraseña.setText(""); // Limpia el campo
            txtContraseña.setForeground(Color.black); // Cambia el color del texto
            txtContraseña.setEchoChar('*'); // Activa el enmascarado
        }
    }//GEN-LAST:event_txtContraseñaMousePressed

    // -----------------------------------------------  Ticket  --------------------------------------------------------
    public void datosTicketMembresia() {
        Connection con = null; // Usamos la clase conexión
        try {
            // Consulta SQL para obtener los datos del estacionamiento
            String query = "SELECT id_estacionamiento, Nombre_estaci, Direccion FROM estacionamiento WHERE id_estacionamiento = ?";
            con = conexion.getConection(); // Obtener la conexión usando tu clase
            PreparedStatement ps = con.prepareStatement(query);

            // Fijamos un ID de estacionamiento, o lo obtenemos de otra fuente
            int estacionamientoId = 1; // Cambia este valor según tus necesidades o toma de otro campo
            ps.setInt(1, estacionamientoId); // Establecemos el ID del estacionamiento en la consulta

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Obtener los datos del estacionamiento desde la base de datos
                String idEstacionamiento = rs.getString("id_estacionamiento");
                String nombre = rs.getString("Nombre_estaci");
                String direccion = rs.getString("Direccion");

                // Generar el contenido del ticket con formato bonito
                StringBuilder ticketContent = new StringBuilder();

                ticketContent.append("==============================================================\n");
                ticketContent.append("                TICKET DE ESTACIONAMIENTO                     \n");
                ticketContent.append("==============================================================\n\n");

                ticketContent.append(String.format("%-20s: %s\n", "ID Estacionamiento", idEstacionamiento));
                ticketContent.append(String.format("%-20s: %s\n", "Nombre", nombre));
                ticketContent.append(String.format("%-20s: %s\n", "Dirección", direccion));

                ticketContent.append("\n--------------------------------------------------------------\n");
                ticketContent.append("                    ESTACIONAMIENTO POR HORA                   \n");
                ticketContent.append("--------------------------------------------------------------\n\n");

                ticketContent.append(String.format("%-20s: %s\n", "Placa", cb_placaEH.getSelectedItem().toString()));
                ticketContent.append(String.format("%-20s: %s\n", "Hora", txt_horaEH.getText()));
                ticketContent.append(String.format("%-20s: %s\n", "Fecha", txt_fechaEH.getText()));
                ticketContent.append(String.format("%-20s: %d\n", "Lugar", (int) jsp_lugarEH.getValue()));
                ticketContent.append(String.format("%-20s: %s\n", "Empleado", txt_empleadoEH.getText()));

                ticketContent.append("\n==============================================================\n");
                ticketContent.append("                  ¡GRACIAS POR USAR NUESTRO SERVICIO!          \n");
                ticketContent.append("==============================================================\n");

                // Mostrar el contenido del ticket en el área de texto
                txtA_ticketEH.setText(ticketContent.toString());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el estacionamiento con ese ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }


    private void lb_ticketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketMouseClicked
        datosTicketMembresia();

    }//GEN-LAST:event_lb_ticketMouseClicked

    private void lb_registrarEHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarEHMouseClicked

        String placa = cb_placaEH.getSelectedItem().toString();
        String hora = txt_horaEH.getText();
        String fecha = txt_fechaEH.getText();
        int lugar = (int) jsp_lugarEH.getValue();
        String empleado = txt_empleadoEH.getText();

        Connection con = null;

        try {
            con = conexion.getConection();

            // Verificar si el lugar de estacionamiento está disponible
            String queryCheckLugar = "SELECT espaciodisp_ocup FROM espacio_lugar WHERE id_espacio = ?";
            PreparedStatement pstCheckLugar = con.prepareStatement(queryCheckLugar);
            pstCheckLugar.setInt(1, lugar);
            ResultSet rs = pstCheckLugar.executeQuery();

            if (rs.next()) {
                String estado = rs.getString("espaciodisp_ocup");
                if ("Ocupado".equalsIgnoreCase(estado)) {
                    JOptionPane.showMessageDialog(this, "El lugar de estacionamiento ya está ocupado. Seleccione otro lugar.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El lugar de estacionamiento no existe.");
                return;
            }

            // Registrar el estacionamiento en la tabla h_estacionamiento
            String queryRegistrarEstacionamiento = "INSERT INTO h_estacionamiento (Placa, Hora, Fecha, Id_Espacio, id_usuario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstRegistrarEstacionamiento = con.prepareStatement(queryRegistrarEstacionamiento);
            pstRegistrarEstacionamiento.setString(1, placa);
            pstRegistrarEstacionamiento.setString(2, hora);
            pstRegistrarEstacionamiento.setString(3, fecha);
            pstRegistrarEstacionamiento.setInt(4, lugar);
            pstRegistrarEstacionamiento.setString(5, empleado);
            pstRegistrarEstacionamiento.executeUpdate();

            // Actualizar el estado del lugar a "Ocupado"
            String queryActualizarLugar = "UPDATE espacio_lugar SET espaciodisp_ocup = 'Ocupado' WHERE id_espacio = ?";
            PreparedStatement pstActualizarLugar = con.prepareStatement(queryActualizarLugar);
            pstActualizarLugar.setInt(1, lugar);
            pstActualizarLugar.executeUpdate();

            // Generar el ticket
            datosTicketMembresia(); // Llama al método para generar el ticket

            // Imprimir el ticket
            txtA_ticketEH.print();

            JOptionPane.showMessageDialog(this, "Registro de estacionamiento completado y ticket impreso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el estacionamiento: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al imprimir el ticket: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_lb_registrarEHMouseClicked

    private void txt_horaMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_horaMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_horaMDActionPerformed

    private void txt_costoMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoMDActionPerformed

    private void txt_idmembresiaMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idmembresiaMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idmembresiaMDActionPerformed

    private void txt_idueñoMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idueñoMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idueñoMDActionPerformed

    private void txt_idmembresiaMDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idmembresiaMDMouseExited
        if (txt_idmembresiaMD.getText().isEmpty()) {
            txt_idmembresiaMD.setText("Ingrese el ID de la membresia");
            txt_idmembresiaMD.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_idmembresiaMDMouseExited

    private void txt_idmembresiaMDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idmembresiaMDMousePressed
        if (txt_idmembresiaMD.getText().equals("Ingrese el ID de la membresia")) {
            txt_idmembresiaMD.setText("");
            txt_idmembresiaMD.setForeground(Color.black);
        }

        txt_idmembresiaMD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Validar que solo se ingresen números
                if (!Character.isDigit(c)) {
                    e.consume();  // Bloquea la entrada si no es un número
                    JOptionPane.showMessageDialog(null, "Solo se permiten números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                // Si el texto ya tiene 8 caracteres y se intenta ingresar más, se bloquea la entrada
                if (txt_idmembresiaMD.getText().length() >= 8) {
                    e.consume();  // Bloquea la entrada de más caracteres
                    JOptionPane.showMessageDialog(null, "Ingreso más de los caracteres esperados (8 caracteres)", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_txt_idmembresiaMDMousePressed

    private void txt_costoMDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_costoMDMouseExited
        if (txt_costoMD.getText().isEmpty()) {
            txt_costoMD.setText("Ingrese el costo");
            txt_costoMD.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_costoMDMouseExited

    private void txt_costoMDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_costoMDMousePressed
        if (txt_costoMD.getText().equals("Ingrese el costo")) {
            txt_costoMD.setText("");
            txt_costoMD.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_costoMDMousePressed

    private void txt_idueñoMDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idueñoMDMouseExited
        if (txt_idueñoMD.getText().isEmpty()) {
            txt_idueñoMD.setText("Ingrese el ID del dueño");
            txt_idueñoMD.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_idueñoMDMouseExited

    private void txt_idueñoMDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idueñoMDMousePressed
        if (txt_idueñoMD.getText().equals("Ingrese el ID del dueño")) {
            txt_idueñoMD.setText("");
            txt_idueñoMD.setForeground(Color.black);
        }

        txt_idueñoMD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Validar que solo se ingresen números
                if (!Character.isDigit(c)) {
                    e.consume();  // Bloquea la entrada si no es un número
                    JOptionPane.showMessageDialog(null, "Solo se permiten números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                // Si el texto ya tiene 8 caracteres y se intenta ingresar más, se bloquea la entrada
                if (txt_idueñoMD.getText().length() >= 8) {
                    e.consume();  // Bloquea la entrada de más caracteres
                    JOptionPane.showMessageDialog(null, "Ingreso más de los caracteres esperados (8 caracteres)", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_txt_idueñoMDMousePressed

    private void txt_nombrecompletoMDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombrecompletoMDMouseExited
        if (txt_nombrecompletoMD.getText().isEmpty()) {
            txt_nombrecompletoMD.setText("Ingrese el nombre completo");
            txt_nombrecompletoMD.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_nombrecompletoMDMouseExited

    private void txt_nombrecompletoMDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombrecompletoMDMousePressed
        if (txt_nombrecompletoMD.getText().equals("Ingrese el nombre completo")) {
            txt_nombrecompletoMD.setText("");
            txt_nombrecompletoMD.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_nombrecompletoMDMousePressed

    private void txt_identificacionMDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_identificacionMDMouseExited
        if (txt_identificacionMD.getText().isEmpty()) {
            txt_identificacionMD.setText("Ingrese la identificación");
            txt_identificacionMD.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_identificacionMDMouseExited

    private void txt_identificacionMDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_identificacionMDMousePressed
        if (txt_identificacionMD.getText().equals("Ingrese la identificación")) {
            txt_identificacionMD.setText("");
            txt_identificacionMD.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_identificacionMDMousePressed

    private void txt_idEstSVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idEstSVMousePressed
        if (txt_idEstSV.getText().equals("Ingrese el ID del cajón")) {
            txt_idEstSV.setText("");
            txt_idEstSV.setForeground(Color.black);
        }

        txt_idEstSV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Validar que solo se ingresen números
                if (!Character.isDigit(c)) {
                    e.consume();  // Bloquea la entrada si no es un número
                    JOptionPane.showMessageDialog(null, "Solo se permiten números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                // Si el texto ya tiene 8 caracteres y se intenta ingresar más, se bloquea la entrada
                if (txt_idEstSV.getText().length() >= 8) {
                    e.consume();  // Bloquea la entrada de más caracteres
                    JOptionPane.showMessageDialog(null, "Ingreso más de los caracteres esperados (8 caracteres)", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_txt_idEstSVMousePressed

    private void txt_idEstSVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_idEstSVMouseExited
        if (txt_idEstSV.getText().isEmpty()) {
            txt_idEstSV.setText("Ingrese el ID del cajón");
            txt_idEstSV.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_idEstSVMouseExited

    private void txt_costoSVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_costoSVMouseExited
        if (txt_costoSV.getText().isEmpty()) {
            txt_costoSV.setText("Ingrese el costo");
            txt_costoSV.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txt_costoSVMouseExited

    private void txt_costoSVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_costoSVMousePressed
        if (txt_costoSV.getText().equals("Ingrese el costo")) {
            txt_costoSV.setText("");
            txt_costoSV.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_costoSVMousePressed

    private void btn_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrarMouseEntered

    }//GEN-LAST:event_btn_registrarMouseEntered

    private boolean isPasswordVisible = false;
    private void lb_mostrarUCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_mostrarUCMouseClicked
        // Alterna entre mostrar y ocultar la contraseña
        if (isPasswordVisible) {
            // Si la contraseña es visible, la ocultamos
            txtContraseña.setEchoChar('*');  // Vuelve a poner el asterisco para ocultar los caracteres
            lb_mostrarUC.setText("Mostrar"); // Cambia el texto del botón para indicar la acción
        } else {
            // Si la contraseña está oculta, la mostramos
            txtContraseña.setEchoChar((char) 0); // Muestra los caracteres de la contraseña
            lb_mostrarUC.setText("Ocultar"); // Cambia el texto del botón para indicar la acción
        }

        // Cambia el estado de la contraseña
        isPasswordVisible = !isPasswordVisible;

    }//GEN-LAST:event_lb_mostrarUCMouseClicked

    private void lb_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_buscarMouseClicked
        String usuario = txt_iduser.getText(); // txt_placa es el JTextField donde el usuario ingresa la placa

        // Establecer la conexión
        Connection con = conexion.getConection();
        if (con != null) {
            try {
                // Crear la consulta SQL para buscar los datos
                String sql = "SELECT id_usuario , Nombre, Telefono, Rango,  Curp, Contraseña, id_estacionamiento FROM usuario WHERE id_usuario = ?";

                // Preparar la sentencia SQL
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, usuario);

                // Ejecutar la consulta
                ResultSet rs = ps.executeQuery();

                // Verificar si se encontró un resultado
                if (rs.next()) {
                    // Rellenar los campos del formulario con los datos obtenidos
                    txt_iduser.setText(rs.getString("id_usuario"));
                    txt_nombre.setText(rs.getString("Nombre"));
                    txt_telefono.setText(rs.getString("Telefono"));
                    cmbRol1.setSelectedItem(rs.getString("Rango")); // jComboBox
                    txt_curp.setText(rs.getString("Curp"));
                    String password = rs.getString("Contraseña"); // Aquí obtenemos la contraseña como String
                    txtContraseña.setText(password);

                    JOptionPane.showMessageDialog(null, "Datos encontrados.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos de id usuario ingresado.");
                }

                // Cerrar ResultSet y PreparedStatement
                rs.close();
                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
        }
    }//GEN-LAST:event_lb_buscarMouseClicked

    private void lb_limpiarUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpiarUMouseClicked
        // Limpiar los campos de texto y restablecer los controles
        txt_iduser.setText("");
        txt_nombre.setText("");
        txt_telefono.setText("");
        txt_curp.setText("");
        txtContraseña.setText("");
        cmbRol1.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado
        CB_estacionamiento.setSelectedIndex(0); // Restablecer JComboBox al valor predeterminado 
    }//GEN-LAST:event_lb_limpiarUMouseClicked

    private void lb_dueñoMDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dueñoMDMouseClicked

        String idDueño = txt_idueñoMD.getText();
        String nombreCompleto = txt_nombrecompletoMD.getText();
        String credencial = txt_identificacionMD.getText();

        // Verificar que los campos no estén vacíos
        if (idDueño.isEmpty() || nombreCompleto.isEmpty() || credencial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de registrar al dueño.");
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = conexion.getConection();

            String queryRegistrarDueño = "INSERT INTO dueño_vehiculo (Id_DueñoV, Nombre, Identificacion) VALUES (?, ?, ?)";
            ps = con.prepareStatement(queryRegistrarDueño);
            ps.setString(1, idDueño);
            ps.setString(2, nombreCompleto);
            ps.setString(3, credencial);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Dueño registrado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el dueño: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_lb_dueñoMDMouseClicked

    private void btn_buscarCMDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarCMDMouseClicked
        // Obtener los valores ingresados en los campos de texto (por ejemplo, los de búsqueda)
        String idDueño = txt_idueñoMD.getText();  // Campo de texto para buscar por ID
        String nombreDueño = txt_nombrecompletoMD.getText();  // Campo de texto para buscar por nombre

        if (idDueño.isEmpty() && nombreDueño.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID o un Nombre para la búsqueda.");
            return;
        }

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = conexion.getConection();  // Obtiene la conexión

            String query = "SELECT Id_DueñoV, Nombre, Identificacion FROM dueño_vehiculo WHERE ";

            // Condicional para construir la consulta según el campo que se ingrese
            if (!idDueño.isEmpty()) {
                query += "Id_DueñoV = ?";
            } else {
                query += "Nombre LIKE ?";
                nombreDueño = "%" + nombreDueño + "%";  // Utilizamos LIKE para hacer coincidencias parciales
            }

            // Preparamos la consulta
            pst = con.prepareStatement(query);

            // Establecemos los parámetros según el tipo de búsqueda
            if (!idDueño.isEmpty()) {
                pst.setString(1, idDueño);  // Si se ingresa un ID
            } else {
                pst.setString(1, nombreDueño);  // Si se ingresa un nombre
            }

            rs = pst.executeQuery();

            // Verificamos si encontramos un registro
            if (rs.next()) {
                String encontradoId = rs.getString("Id_DueñoV");
                String encontradoNombre = rs.getString("Nombre");
                String encontradoIdentificacion = rs.getString("Identificacion");

                // Muestra los datos encontrados
                // Mostrar los datos encontrados en los campos de texto
                txt_idueñoMD.setText(encontradoId);
                txt_nombrecompletoMD.setText(encontradoNombre);
                txt_identificacionMD.setText(encontradoIdentificacion);

            } else {
                // Si no se encuentra ningún registro
                JOptionPane.showMessageDialog(this, "Persona aun no registrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error en la búsqueda: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_buscarCMDMouseClicked

    // -----------------------------------------------  Ticket  --------------------------------------------------------
    public void datosTicket() {
        Connection con = null; // Usamos la clase conexión
        try {
            // Consulta SQL para obtener los datos del estacionamiento
            String queryEstacionamiento = "SELECT id_estacionamiento, Nombre_estaci, Direccion FROM estacionamiento WHERE id_estacionamiento = ?";
            con = conexion.getConection(); // Obtener la conexión usando tu clase
            PreparedStatement psEstacionamiento = con.prepareStatement(queryEstacionamiento);

            // Fijamos un ID de estacionamiento, o lo obtenemos de otra fuente
            int estacionamientoId = 1; // Cambia este valor según tus necesidades o toma de otro campo
            psEstacionamiento.setInt(1, estacionamientoId); // Establecemos el ID del estacionamiento en la consulta

            ResultSet rsEstacionamiento = psEstacionamiento.executeQuery();

            if (rsEstacionamiento.next()) {
                // Obtener los datos del estacionamiento desde la base de datos
                String idEstacionamiento = rsEstacionamiento.getString("id_estacionamiento");
                String nombre = rsEstacionamiento.getString("Nombre_estaci");
                String direccion = rsEstacionamiento.getString("Direccion");

                // Obtener los datos del vehículo a partir de la placa seleccionada
                String placa = cb_placaMD.getSelectedItem().toString(); // Obtenemos la placa seleccionada
                String queryVehiculo = "SELECT Tipo, Marca, Modelo, Color FROM vehiculo WHERE Placa = ?";
                PreparedStatement psVehiculo = con.prepareStatement(queryVehiculo);
                psVehiculo.setString(1, placa); // Pasamos el ID del vehículo (placa) a la consulta
                ResultSet rsVehiculo = psVehiculo.executeQuery();

                // Verificamos si encontramos el vehículo
                if (rsVehiculo.next()) {
                    String tipo = rsVehiculo.getString("Tipo");
                    String marca = rsVehiculo.getString("Marca");
                    String modelo = rsVehiculo.getString("Modelo");
                    String color = rsVehiculo.getString("Color");

                    // Generar el contenido del ticket con formato bonito
                    StringBuilder ticketContent = new StringBuilder();

                    ticketContent.append("==============================================================\n");
                    ticketContent.append("                TICKET DE ESTACIONAMIENTO                     \n");
                    ticketContent.append("==============================================================\n\n");

                    ticketContent.append(String.format("%-20s: %s\n", "ID Estacionamiento", idEstacionamiento));
                    ticketContent.append(String.format("%-20s: %s\n", "Nombre", nombre));
                    ticketContent.append(String.format("%-20s: %s\n", "Dirección", direccion));

                    ticketContent.append("\n--------------------------------------------------------------\n");
                    ticketContent.append("                    ESTACIONAMIENTO POR MEMBRESIA                   \n");
                    ticketContent.append("--------------------------------------------------------------\n\n");

                    ticketContent.append(String.format("%-20s: %s\n", "ID membresia", txt_idmembresiaMD.getText()));
                    ticketContent.append(String.format("%-20s: %s\n", "Placa", placa));
                    ticketContent.append(String.format("%-20s: %s\n", "Hora", txt_horaEH.getText()));
                    ticketContent.append(String.format("%-20s: %s\n", "Fecha", txt_fechaEH.getText()));
                    ticketContent.append(String.format("%-20s: %d\n", "Lugar", (int) jsp_lugarMD.getValue()));
                    ticketContent.append(String.format("%-20s: %s\n", "Dueño vehiculo", txt_idueñoMD.getText()));
                    ticketContent.append(String.format("%-20s: %s\n", "Identificacion", txt_identificacionMD.getText()));
                    ticketContent.append(String.format("%-20s: %s\n", "Costo   $ ", txt_costoMD.getText()));
                    ticketContent.append(String.format("%-20s: %s\n", "Empleado", txt_empleadoMD.getText()));

                    // Agregamos los detalles del vehículo
                    ticketContent.append("\n--------------------------------------------------------------\n");
                    ticketContent.append("                     DETALLES DEL VEHÍCULO                     \n");
                    ticketContent.append("--------------------------------------------------------------\n\n");
                    ticketContent.append(String.format("%-20s: %s\n", "Tipo", tipo));
                    ticketContent.append(String.format("%-20s: %s\n", "Tipo", marca));
                    ticketContent.append(String.format("%-20s: %s\n", "Modelo", modelo));
                    ticketContent.append(String.format("%-20s: %s\n", "Color", color));

                    ticketContent.append("\n==============================================================\n");
                    ticketContent.append("                  ¡GRACIAS POR USAR NUESTRO SERVICIO!          \n");
                    ticketContent.append("==============================================================\n");

                    // Mostrar el contenido del ticket en el área de texto
                    txtA_ticketMD.setText(ticketContent.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el vehículo con esa placa.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el estacionamiento con ese ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }


    private void lb_ticketMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketMemMouseClicked
        datosTicket();
    }//GEN-LAST:event_lb_ticketMemMouseClicked

    private void lb_limpMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpMemMouseClicked
        // Limpiar los JTextField
        txt_idueñoMD.setText("");
        txt_nombrecompletoMD.setText("");
        txt_identificacionMD.setText("");
        txt_idmembresiaMD.setText("");
        txt_horaMD.setText("");
        txt_fechaMD.setText("");
        txt_costoMD.setText("");
        txt_empleadoMD.setText("");

        // Limpiar el JComboBox (placa del vehículo)
        cb_placaMD.setSelectedIndex(-1); // o cb_placaMD.setSelectedItem(null); si quieres establecerlo a null

        // Limpiar el JSpinner (lugar de estacionamiento)
        jsp_lugarMD.setValue(0); // Establecer el valor predeterminado

        // Limpiar el JTextArea (si es que estás mostrando un ticket)
        txtA_ticketMD.setText("");
    }//GEN-LAST:event_lb_limpMemMouseClicked

    // Renovar
    private void lb_renovarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_renovarMouseClicked

        String idMembresia = txt_idmembresiaMD.getText();
        String placa = cb_placaMD.getSelectedItem().toString();
        String hora = txt_horaMD.getText();
        String fecha = txt_fechaMD.getText();
        String costo = txt_costoMD.getText();
        int lugar = (int) jsp_lugarMD.getValue();
        String empleado = txt_empleadoMD.getText();
        String idDueño = txt_idueñoMD.getText();

        Connection con = null;

        try {
            con = conexion.getConection();

            // Verificar si la membresía existe
            String queryCheckMembresia = "SELECT id_espacio FROM membresia WHERE id_membresia = ?";
            PreparedStatement pstCheckMembresia = con.prepareStatement(queryCheckMembresia);
            pstCheckMembresia.setString(1, idMembresia);
            ResultSet rsMembresia = pstCheckMembresia.executeQuery();

            if (rsMembresia.next()) {
                int lugarAnterior = rsMembresia.getInt("id_espacio");

                // Si el lugar anterior es diferente al nuevo lugar, actualizamos ambos lugares
                if (lugarAnterior != lugar) {
                    // Cambiar el estado del lugar anterior a "Disponible"
                    String queryDesocuparLugar = "UPDATE espacio_lugar SET espaciodisp_ocup = 'Disponible' WHERE id_espacio = ?";
                    PreparedStatement pstDesocuparLugar = con.prepareStatement(queryDesocuparLugar);
                    pstDesocuparLugar.setInt(1, lugarAnterior);
                    pstDesocuparLugar.executeUpdate();
                }

                // Actualizar la membresía
                String queryActualizarMembresia = "UPDATE membresia SET Placa = ?, hora = ?, fecha = ?, costo = ?, id_espacio = ?, id_usuario = ?, Id_DueñoV = ? WHERE id_membresia = ?";
                PreparedStatement pstActualizarMembresia = con.prepareStatement(queryActualizarMembresia);
                pstActualizarMembresia.setString(1, placa);
                pstActualizarMembresia.setString(2, hora);
                pstActualizarMembresia.setString(3, fecha);
                pstActualizarMembresia.setString(4, costo);
                pstActualizarMembresia.setInt(5, lugar);
                pstActualizarMembresia.setString(6, empleado);
                pstActualizarMembresia.setString(7, idDueño);
                pstActualizarMembresia.setString(8, idMembresia);
                pstActualizarMembresia.executeUpdate();

                // Actualizar el estado del nuevo lugar a "Ocupado"
                String queryActualizarLugar = "UPDATE espacio_lugar SET espaciodisp_ocup = 'Ocupado' WHERE id_espacio = ?";
                PreparedStatement pstActualizarLugar = con.prepareStatement(queryActualizarLugar);
                pstActualizarLugar.setInt(1, lugar);
                pstActualizarLugar.executeUpdate();

                JOptionPane.showMessageDialog(this, "Membresía renovada correctamente y lugar actualizado.");
            } else {
                JOptionPane.showMessageDialog(this, "La membresía no existe.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al renovar la membresía: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_lb_renovarMouseClicked

    private void lb_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_salidaMouseClicked

        String idMembresia = txt_idmembresiaMD.getText();
        Connection con = null;

        try {
            con = conexion.getConection();

            // Verificar si la membresía existe
            String queryCheckMembresia = "SELECT id_membresia, id_espacio, fecha FROM membresia WHERE id_membresia = ?";
            PreparedStatement pstCheckMembresia = con.prepareStatement(queryCheckMembresia);
            pstCheckMembresia.setString(1, idMembresia);
            ResultSet rsMembresia = pstCheckMembresia.executeQuery();

            if (rsMembresia.next()) {
                // Si la membresía existe, obtener los datos necesarios
                String idEspacio = rsMembresia.getString("id_espacio");
                String fechaRegistro = rsMembresia.getString("fecha");
                java.util.Date date = new java.util.Date();
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                String fechaSalida = dateFormatter.format(date); // Fecha de salida es la actual

                // Registrar los datos en la tabla expira_membresia
                String queryInsertExpiraMembresia = "INSERT INTO expira_membresia (id_renova, id_membresia, fecha_registro, id_espacio, fecha_salida) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstInsertExpiraMembresia = con.prepareStatement(queryInsertExpiraMembresia);
                pstInsertExpiraMembresia.setString(1, idMembresia); // id_renova
                pstInsertExpiraMembresia.setString(2, idMembresia); // id_membresia
                pstInsertExpiraMembresia.setString(3, fechaRegistro); // fecha_registro
                pstInsertExpiraMembresia.setString(4, idEspacio); // id_espacio
                pstInsertExpiraMembresia.setString(5, fechaSalida); // fecha_salida
                pstInsertExpiraMembresia.executeUpdate();

                // Eliminar la membresía de la tabla membresia
                String queryDeleteMembresia = "DELETE FROM membresia WHERE id_membresia = ?";
                PreparedStatement pstDeleteMembresia = con.prepareStatement(queryDeleteMembresia);
                pstDeleteMembresia.setString(1, idMembresia);
                pstDeleteMembresia.executeUpdate();

                // Liberar el lugar de estacionamiento (marcarlo como "Disponible")
                String queryActualizarLugar = "UPDATE espacio_lugar SET espaciodisp_ocup = 'Disponible' WHERE id_espacio = ?";
                PreparedStatement pstActualizarLugar = con.prepareStatement(queryActualizarLugar);
                pstActualizarLugar.setString(1, idEspacio);
                pstActualizarLugar.executeUpdate();

                JOptionPane.showMessageDialog(this, "Membresía eliminada y lugar desocupado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "La membresía no existe.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar la membresía: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_lb_salidaMouseClicked

    private void lb_membresiaMDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_membresiaMDMouseClicked
        // Obtener el id de la membresía ingresada en el campo de texto
        String idMembresia = txt_idmembresiaMD.getText();

        if (idMembresia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID de membresía.");
            return;
        }

        Connection con = null;

        try {
            con = conexion.getConection();

            // Verificar si la membresía existe en la base de datos
            String queryCheckMembresia = "SELECT id_membresia FROM membresia WHERE id_membresia = ?";
            PreparedStatement pstCheckMembresia = con.prepareStatement(queryCheckMembresia);
            pstCheckMembresia.setString(1, idMembresia);
            ResultSet rs = pstCheckMembresia.executeQuery();

            if (rs.next()) {
                // Si la membresía existe, mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "La membresía con ID " + idMembresia + " existe.");
            } else {
                // Si la membresía no existe, mostrar mensaje de error
                JOptionPane.showMessageDialog(this, "No se encontró la membresía con ID " + idMembresia + ".");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al verificar la membresía: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_lb_membresiaMDMouseClicked

    private void lb_calcularTiemCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_calcularTiemCostMouseClicked

        String horaEntrada = txt_horaEntradaSV.getText(); // Hora de entrada
        double costoPorHora = 15.0; // Costo por hora
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // Formato para horas

        try {
            // Obtener la hora de salida como hora actual
            java.util.Date salida = new java.util.Date();
            String horaSalida = sdf.format(salida); // Formato para la hora actual

            // Mostrar la hora de salida en el JTextField (si tienes uno para mostrarla)
            txt_HorasalidaSV.setText(horaSalida);

            // Convertir las horas de entrada y salida a objetos Date
            java.util.Date entrada = sdf.parse(horaEntrada);
            java.util.Date salidaParsed = sdf.parse(horaSalida);

            // Calcular la diferencia en milisegundos
            long diferenciaMilisegundos = salidaParsed.getTime() - entrada.getTime();

            // Asegurarse de que la salida sea posterior a la entrada
            if (diferenciaMilisegundos < 0) {
                JOptionPane.showMessageDialog(this, "La hora de entrada debe ser anterior a la hora actual.");
                return;
            }

            // Convertir la diferencia a minutos totales
            long minutosTotales = diferenciaMilisegundos / (1000 * 60);

            // Calcular las horas completas y los minutos restantes
            long horasCompletas = minutosTotales / 60;
            long minutosRestantes = minutosTotales % 60;

            // Calcular el costo (una fracción de hora cuenta como una hora completa)
            double costoTotal = (horasCompletas + (minutosRestantes > 0 ? 1 : 0)) * costoPorHora;

            // Mostrar el tiempo total en el JLabel y el costo en el JTextField
            String tiempoTotal = String.format("%02d horas y %02d minutos", horasCompletas, minutosRestantes);
            lb_tiempoSV.setText(tiempoTotal); // Actualiza el JLabel con el tiempo total
            txt_costoSV.setText(String.format("$%.2f", costoTotal)); // Actualiza el JTextField con el costo total

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de hora incorrecto. Use el formato HH:mm (por ejemplo, 14:30).");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al calcular el tiempo y costo: " + e.getMessage());
        }

    }//GEN-LAST:event_lb_calcularTiemCostMouseClicked

    private void lb_buscarSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_buscarSVMouseClicked

        String placa = cb_placaSV.getSelectedItem().toString();

        Connection con = null; // Crear conexión
        try {
            con = conexion.getConection(); // Obtener la conexión desde tu clase de conexión

            // Consulta SQL para obtener los datos de la tabla h_estacionamiento basados en la placa
            String query = "SELECT id_HEstacionamiento, Hora, Id_Espacio FROM h_estacionamiento WHERE Placa = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, placa); // Establecer el valor de la placa en la consulta

            ResultSet rs = pst.executeQuery(); // Ejecutar la consulta

            // Verificar si se encuentran resultados
            if (rs.next()) {
                // Obtener los datos de la consulta
                String idHEstacionamiento = rs.getString("id_HEstacionamiento");
                String horaEntrada = rs.getString("Hora");
                int idEspacio = rs.getInt("id_Espacio"); // Obtener el id_Espacio como entero

                // Mostrar los datos en los TextFields
                txt_idEstSV.setText(idHEstacionamiento);
                txt_horaEntradaSV.setText(horaEntrada);

                // Establecer el valor del JSpinner con el id_Espacio
                jsp_lugarSV.setValue(idEspacio); // Usar el tipo correcto para JSpinner (int)
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron datos para la placa seleccionada.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar los datos: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_lb_buscarSVMouseClicked

    // -----------------------------------------------  Ticket  --------------------------------------------------------
    public void datosTicketsalidaVehiculos() {
        Connection con = null; // Usamos la clase conexión
        try {
            // Consulta SQL para obtener los datos del estacionamiento
            String query = "SELECT id_estacionamiento, Nombre_estaci, Direccion FROM estacionamiento WHERE id_estacionamiento = ?";
            con = conexion.getConection(); // Obtener la conexión usando tu clase
            PreparedStatement ps = con.prepareStatement(query);

            // Fijamos un ID de estacionamiento, o lo obtenemos de otra fuente
            int estacionamientoId = 1; // Cambia este valor según tus necesidades o toma de otro campo
            ps.setInt(1, estacionamientoId); // Establecemos el ID del estacionamiento en la consulta

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Obtener los datos del estacionamiento desde la base de datos
                String idEstacionamiento = rs.getString("id_estacionamiento");
                String nombre = rs.getString("Nombre_estaci");
                String direccion = rs.getString("Direccion");

                // Generar el contenido del ticket con formato bonito
                StringBuilder ticketContent = new StringBuilder();

                ticketContent.append("==============================================================\n");
                ticketContent.append("                TICKET DE ESTACIONAMIENTO                     \n");
                ticketContent.append("==============================================================\n\n");

                ticketContent.append(String.format("%-20s: %s\n", "ID Estacionamiento", idEstacionamiento));
                ticketContent.append(String.format("%-20s: %s\n", "Nombre", nombre));
                ticketContent.append(String.format("%-20s: %s\n", "Dirección", direccion));

                ticketContent.append("\n--------------------------------------------------------------\n");
                ticketContent.append("                    ESTACIONAMIENTO SALIDA                   \n");
                ticketContent.append("--------------------------------------------------------------\n\n");

                ticketContent.append(String.format("%-20s: %s\n", "ID", cb_placaEH.getSelectedItem().toString()));
                ticketContent.append(String.format("%-20s: %s\n", "Hora entrada", txt_horaEntradaSV.getText()));
                ticketContent.append(String.format("%-20s: %s\n", "Hora salida", txt_HorasalidaSV.getText()));
                ticketContent.append(String.format("%-20s: %s\n", "Tiempo", lb_tiempoSV.getText()));
                ticketContent.append(String.format("%-20s: %s\n", "Fecha", txt_fechaEH.getText()));
                ticketContent.append(String.format("%-20s: %d\n", "Lugar", (int) jsp_lugarSV.getValue()));
                ticketContent.append(String.format("%-20s: %s\n", "Costo", txt_costoSV.getText()));

                ticketContent.append("\n==============================================================\n");
                ticketContent.append("                  ¡GRACIAS POR USAR NUESTRO SERVICIO!          \n");
                ticketContent.append("==============================================================\n");

                // Mostrar el contenido del ticket en el área de texto
                txtA_ticketSV.setText(ticketContent.toString());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el estacionamiento con ese ID.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    private void lb_ticketSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketSVMouseClicked
        datosTicketsalidaVehiculos();
    }//GEN-LAST:event_lb_ticketSVMouseClicked

    private void lb_pagarSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pagarSVMouseClicked
        // Obtener los datos desde la UI
        String placa = cb_placaSV.getSelectedItem().toString();
        String idHestacionamiento = txt_idEstSV.getText();
        String horaEntrada = txt_horaEntradaSV.getText();
        String horaSalida = txt_HorasalidaSV.getText();
        String tiempoTotal = lb_tiempoSV.getText();  // Tiempo total que ya se muestra en el JLabel
        String fecha = txt_fechaSV.getText();
        String costoTotalStr = txt_costoSV.getText(); // El costo total calculado que se muestra en el JTextField
        int lugar = (int) jsp_lugarSV.getValue(); // El lugar de estacionamiento desde el JSpinner

        // Extraer el valor de costo total
        double costoTotal = Double.parseDouble(costoTotalStr.replace("$", "").trim()); // Eliminar el signo '$' y convertir a double

        Connection con = null;
        try {
            con = conexion.getConection(); // Conexión a la base de datos

            // Registrar la salida del vehículo en la tabla salida_vehiculo
            String queryInsertarSalida = "INSERT INTO salida_vehiculo (id_HEstacionamiento, Hora_entrada, Hora_salida, Tiempo, Fecha, id_Espacio, Costo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstInsertarSalida = con.prepareStatement(queryInsertarSalida);

            // Obtener la hora de salida como la hora actual
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            java.util.Date salida = new java.util.Date();
            String horaSalidaActual = sdf.format(salida); // La hora actual de salida

            // Establecer los parámetros para el INSERT
            pstInsertarSalida.setString(1, idHestacionamiento); // id_HEstacionamiento
            pstInsertarSalida.setString(2, horaEntrada); // Hora de entrada
            pstInsertarSalida.setString(3, horaSalidaActual); // Hora de salida
            pstInsertarSalida.setString(4, tiempoTotal); // Tiempo total
            pstInsertarSalida.setString(5, fecha); // Fecha
            pstInsertarSalida.setInt(6, lugar); // id_Espacio
            pstInsertarSalida.setDouble(7, costoTotal); // Costo total

            pstInsertarSalida.executeUpdate(); // Insertar en salida_vehiculo

            // Eliminar el vehículo de la tabla h_estacionamiento
            String queryEliminarEstacionamiento = "DELETE FROM h_estacionamiento WHERE Placa = ?";
            PreparedStatement pstEliminarEstacionamiento = con.prepareStatement(queryEliminarEstacionamiento);
            pstEliminarEstacionamiento.setString(1, placa);
            pstEliminarEstacionamiento.executeUpdate(); // Eliminar el vehículo

            // Desocupar el lugar de estacionamiento en la tabla espacio_lugar
            String queryDesocuparLugar = "UPDATE espacio_lugar SET espaciodisp_ocup = 'Disponible' WHERE id_espacio = ?";
            PreparedStatement pstDesocuparLugar = con.prepareStatement(queryDesocuparLugar);
            pstDesocuparLugar.setInt(1, lugar);
            pstDesocuparLugar.executeUpdate(); // Desocupar el lugar

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Pago realizado con éxito. El vehículo ha sido registrado en la salida y el lugar ha sido desocupado.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al procesar el pago: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_lb_pagarSVMouseClicked

    private void lb_cerrarsesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarsesionMouseClicked
        // Mostrar un mensaje de confirmación antes de cerrar la sesión
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Seguro deseas salir de la sesión?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            // Aquí puedes colocar el código para regresar a la pantalla de login
            // Por ejemplo, si estás usando un JFrame para la pantalla de login:

            // Cerrar la ventana actual (donde está la sesión activa)
            this.dispose();  // Cierra la ventana actual

            // Crear una nueva instancia del JFrame del login
            login_admin loginFrame = new login_admin();  // Sustituye "LoginFrame" por el nombre de tu clase de login
            loginFrame.setVisible(true);  // Muestra el JFrame del login
        } else {
            // Si el usuario selecciona "No", no hacer nada
            return;
        }
    }//GEN-LAST:event_lb_cerrarsesionMouseClicked

    private void lb_cerrarsesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarsesionMouseEntered
        btn_cerrarsesion.setBackground(new Color(255, 32, 78)); //rgb(255, 32, 78)
        lb_cerrarsesion.setForeground(Color.WHITE);
    }//GEN-LAST:event_lb_cerrarsesionMouseEntered

    private void lb_cerrarsesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_cerrarsesionMouseExited
        btn_cerrarsesion.setBackground(new Color(160, 21, 62)); //rgb(160, 21, 62)
        lb_cerrarsesion.setForeground(new Color(187, 187, 187));
    }//GEN-LAST:event_lb_cerrarsesionMouseExited

    private void lb_resgistrarMDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_resgistrarMDMouseEntered
        if (!lb_resgistrarMD.getText().equals("registrar")) {
            btn_registrarMD.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a rojo
            lb_resgistrarMD.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_resgistrarMDMouseEntered

    private void lb_dueñoMDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dueñoMDMouseEntered
        if (!lb_dueñoMD.getText().equals("registrar dueño")) {
            btn_dueñoMD.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a rojo
            lb_dueñoMD.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_dueñoMDMouseEntered

    private void lb_registrarEHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarEHMouseEntered
        if (!lb_registrarEH.getText().equals("registrar")) {
            btn_registrarEH.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a rojo
            lb_registrarEH.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_registrarEHMouseEntered

    private void lb_registrarEHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_registrarEHMouseExited
        btn_registrarEH.setBackground(new Color(116, 9, 56)); //Rojo  
        lb_registrarEH.setForeground(Color.white);
    }//GEN-LAST:event_lb_registrarEHMouseExited

    private void lb_pagarSVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pagarSVMouseEntered
        if (!lb_pagarSV.getText().equals("pagar")) {
            btn_pagarSV.setBackground(new Color(204, 43, 82)); // Cambiar el fondo del botón a rojo
            lb_pagarSV.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_pagarSVMouseEntered

    private void lb_pagarSVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pagarSVMouseExited
        btn_pagarSV.setBackground(new Color(116, 9, 56)); //Rojo  
        lb_pagarSV.setForeground(Color.white);
    }//GEN-LAST:event_lb_pagarSVMouseExited

    private void lb_resgistrarMDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_resgistrarMDMouseExited
        btn_registrarMD.setBackground(new Color(116, 9, 56)); //Rojo  
        lb_resgistrarMD.setForeground(Color.white);
    }//GEN-LAST:event_lb_resgistrarMDMouseExited

    private void lb_dueñoMDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_dueñoMDMouseExited
        btn_dueñoMD.setBackground(new Color(116, 9, 56)); //Rojo  
        lb_dueñoMD.setForeground(Color.white);
    }//GEN-LAST:event_lb_dueñoMDMouseExited

    private void lb_limpiarUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpiarUMouseEntered
        if (!lb_limpiarU.getText().equals("limpiar")) {
            btn_limpiarU.setBackground(new Color(153, 153, 153)); // Cambiar el fondo del botón a gris bajo
            lb_limpiarU.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_limpiarUMouseEntered

    private void lb_limpiarUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpiarUMouseExited
        btn_limpiarU.setBackground(new Color(102, 102, 102)); //gris 
        lb_limpiarU.setForeground(Color.white);
    }//GEN-LAST:event_lb_limpiarUMouseExited

    private void lb_limpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpiarMouseEntered
        if (!lb_limpiar.getText().equals("limpiar")) {
            btn_limpiar.setBackground(new Color(153, 153, 153)); // Cambiar el fondo del botón a gris bajo
            lb_limpiar.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_limpiarMouseEntered

    private void lb_limpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpiarMouseExited
        btn_limpiar.setBackground(new Color(102, 102, 102)); //gris 
        lb_limpiar.setForeground(Color.white);
    }//GEN-LAST:event_lb_limpiarMouseExited

    private void lb_consultarRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_consultarRMouseEntered
        if (!lb_consultarR.getText().equals("consultar")) {
            btn_consultarR.setBackground(new Color(153, 153, 153)); // Cambiar el fondo del botón a gris bajo
            lb_consultarR.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_consultarRMouseEntered

    private void lb_consultarRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_consultarRMouseExited
        btn_consultarR.setBackground(new Color(102, 102, 102)); //gris 
        lb_consultarR.setForeground(Color.white);
    }//GEN-LAST:event_lb_consultarRMouseExited

    private void lb_buscarSVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_buscarSVMouseEntered
        if (!lb_buscarSV.getText().equals("buscar")) {
            btn_buscarSV.setBackground(new Color(153, 153, 153)); // Cambiar el fondo del botón a gris bajo
            lb_buscarSV.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_buscarSVMouseEntered

    private void lb_buscarSVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_buscarSVMouseExited
        btn_buscarSV.setBackground(new Color(102, 102, 102)); //gris 
        lb_buscarSV.setForeground(Color.white);
    }//GEN-LAST:event_lb_buscarSVMouseExited

    private void lb_limpMemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpMemMouseEntered
        if (!lb_limpMem.getText().equals("limpiar")) {
            btn_limpMem.setBackground(new Color(153, 153, 153)); // Cambiar el fondo del botón a gris bajo
            lb_limpMem.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_limpMemMouseEntered

    private void lb_limpMemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_limpMemMouseExited
        btn_limpMem.setBackground(new Color(102, 102, 102)); //gris 
        lb_limpMem.setForeground(Color.white);
    }//GEN-LAST:event_lb_limpMemMouseExited

    private void lb_ticketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketMouseEntered
        if (!lb_ticket.getText().equals("ticket")) {
            btn_ticket.setBackground(new Color(153, 211, 206)); // Cambiar el fondo del botón a azul-agua bajo
            lb_ticket.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_ticketMouseEntered

    private void lb_ticketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketMouseExited
        btn_ticket.setBackground(new Color(153, 193, 190)); //azul
        lb_ticket.setForeground(Color.white);
    }//GEN-LAST:event_lb_ticketMouseExited

    private void lb_ticketSVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketSVMouseEntered
        if (!lb_ticketSV.getText().equals("ticket")) {
            btn_ticketSV.setBackground(new Color(153, 211, 206)); // Cambiar el fondo del botón a azul-agua bajo
            lb_ticketSV.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_ticketSVMouseEntered

    private void lb_ticketSVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketSVMouseExited
        btn_ticketSV.setBackground(new Color(153, 193, 190)); //azul
        lb_ticketSV.setForeground(Color.white);
    }//GEN-LAST:event_lb_ticketSVMouseExited

    private void lb_ticketMemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketMemMouseEntered
        if (!lb_ticketMem.getText().equals("ticket")) {
            btn_ticketMem.setBackground(new Color(153, 211, 206)); // Cambiar el fondo del botón a azul-agua bajo
            lb_ticketMem.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_ticketMemMouseEntered

    private void lb_ticketMemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ticketMemMouseExited
        btn_ticketMem.setBackground(new Color(153, 193, 190)); //azul
        lb_ticketMem.setForeground(Color.white);
    }//GEN-LAST:event_lb_ticketMemMouseExited

    private void lb_renovarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_renovarMouseEntered
        if (!lb_renovar.getText().equals("renovar")) {
            btn_renovar.setBackground(new Color(33, 78, 185)); // Cambiar el fondo del botón a azul bajo
            lb_renovar.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_renovarMouseEntered

    private void lb_renovarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_renovarMouseExited
        btn_renovar.setBackground(new Color(33, 33, 137)); //azul
        lb_renovar.setForeground(Color.white);
    }//GEN-LAST:event_lb_renovarMouseExited

    private void lb_salidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_salidaMouseEntered
        if (!lb_salida.getText().equals("salida")) {
            btn_salida.setBackground(new Color(33, 78, 185)); // Cambiar el fondo del botón a azul bajo
            lb_salida.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_salidaMouseEntered

    private void lb_calcularTiemCostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_calcularTiemCostMouseEntered
        if (!lb_calcularTiemCost.getText().equals("calcular")) {
            btn_calcularTiemCost.setBackground(new Color(204, 239, 181)); // Cambiar el fondo del botón a amarillo bajo
            lb_calcularTiemCost.setForeground(Color.WHITE); // Cambiar el color de texto de la etiqueta a un color blanco
        }
    }//GEN-LAST:event_lb_calcularTiemCostMouseEntered

    private void lb_calcularTiemCostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_calcularTiemCostMouseExited
        btn_calcularTiemCost.setBackground(new Color(204, 224, 156)); //verde
        lb_calcularTiemCost.setForeground(Color.white);
    }//GEN-LAST:event_lb_calcularTiemCostMouseExited

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
    private Clases.PanelRound btn_actualizarU;
    private Clases.PanelRound btn_actualizarV;
    private javax.swing.JLabel btn_buscarCMD;
    private Clases.PanelRound btn_buscarSV;
    private Clases.PanelRound btn_calcularTiemCost;
    private Clases.PanelRound btn_cerrarsesion;
    private Clases.PanelRound btn_consultarR;
    private Clases.PanelRound btn_dueñoMD;
    private javax.swing.JPanel btn_exit;
    private Clases.PanelRound btn_limpMem;
    private Clases.PanelRound btn_limpiar;
    private Clases.PanelRound btn_limpiarU;
    private javax.swing.JPanel btn_min;
    private javax.swing.JPanel btn_minmax;
    private Clases.PanelRound btn_pagarSV;
    private Clases.PanelRound btn_registrar;
    private Clases.PanelRound btn_registrarEH;
    private Clases.PanelRound btn_registrarMD;
    private Clases.PanelRound btn_registrarV;
    private Clases.PanelRound btn_registros;
    private Clases.PanelRound btn_renovar;
    private Clases.PanelRound btn_salida;
    private Clases.PanelRound btn_ticket;
    private Clases.PanelRound btn_ticketMem;
    private Clases.PanelRound btn_ticketSV;
    private Clases.PanelRound btn_usuarios;
    private Clases.PanelRound btn_vehiculo;
    private javax.swing.JComboBox<String> cb_marca;
    private javax.swing.JComboBox<String> cb_placaEH;
    private javax.swing.JComboBox<String> cb_placaMD;
    private javax.swing.JComboBox<String> cb_placaSV;
    private javax.swing.JComboBox<String> cb_tablas;
    private javax.swing.JComboBox<String> cb_tipo;
    private javax.swing.JPanel centro;
    private javax.swing.JComboBox<String> cmbRol1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
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
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
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
    private javax.swing.JSpinner jsp_lugarEH;
    private javax.swing.JSpinner jsp_lugarMD;
    private javax.swing.JSpinner jsp_lugarSV;
    private javax.swing.JTable jtb_registros;
    private javax.swing.JLabel lb_HorayFraccion;
    private javax.swing.JLabel lb_actualizar;
    private javax.swing.JLabel lb_actualizarV;
    private javax.swing.JLabel lb_buscar;
    private javax.swing.JLabel lb_buscarSV;
    private javax.swing.JLabel lb_buscarV;
    private javax.swing.JLabel lb_calcularTiemCost;
    private javax.swing.JLabel lb_cerrarsesion;
    private javax.swing.JLabel lb_consultarR;
    private javax.swing.JLabel lb_dueñoMD;
    private javax.swing.JLabel lb_estac;
    private javax.swing.JLabel lb_exit;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_limpMem;
    private javax.swing.JLabel lb_limpiar;
    private javax.swing.JLabel lb_limpiarU;
    private javax.swing.JLabel lb_lugares;
    private javax.swing.JLabel lb_membresia;
    private javax.swing.JLabel lb_membresiaMD;
    private javax.swing.JLabel lb_min;
    private javax.swing.JLabel lb_minmax;
    private javax.swing.JLabel lb_mostrarUC;
    private javax.swing.JLabel lb_nombreUsuario;
    private javax.swing.JLabel lb_pagarSV;
    private javax.swing.JLabel lb_registrar;
    private javax.swing.JLabel lb_registrarEH;
    private javax.swing.JLabel lb_registrarV;
    private javax.swing.JLabel lb_registros;
    private javax.swing.JLabel lb_renovar;
    private javax.swing.JLabel lb_resgistrarMD;
    private javax.swing.JLabel lb_salida;
    private javax.swing.JLabel lb_salidaVehiculos;
    private javax.swing.JLabel lb_ticket;
    private javax.swing.JLabel lb_ticketMem;
    private javax.swing.JLabel lb_ticketSV;
    private javax.swing.JLabel lb_tiempo;
    private javax.swing.JLabel lb_tiempoSV;
    private javax.swing.JLabel lb_usuarios;
    private javax.swing.JLabel lb_vehiculo;
    private javax.swing.JTextArea txtA_ticketEH;
    private javax.swing.JTextArea txtA_ticketMD;
    private javax.swing.JTextArea txtA_ticketSV;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txt_HorasalidaSV;
    private javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_costoMD;
    private javax.swing.JTextField txt_costoSV;
    private javax.swing.JTextField txt_curp;
    private javax.swing.JTextField txt_empleadoEH;
    private javax.swing.JTextField txt_empleadoMD;
    private javax.swing.JTextField txt_fechaEH;
    private javax.swing.JTextField txt_fechaMD;
    private javax.swing.JTextField txt_fechaSV;
    private javax.swing.JTextField txt_horaEH;
    private javax.swing.JTextField txt_horaEntradaSV;
    private javax.swing.JTextField txt_horaMD;
    private javax.swing.JTextField txt_idEstSV;
    private javax.swing.JTextField txt_identificacionMD;
    private javax.swing.JTextField txt_idmembresiaMD;
    private javax.swing.JTextField txt_idueñoMD;
    private javax.swing.JTextField txt_iduser;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombrecompletoMD;
    private javax.swing.JTextField txt_placa;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}