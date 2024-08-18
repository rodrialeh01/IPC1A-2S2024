/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author rodri
 */
public class VentanaAdmin extends JFrame implements ActionListener{
    //COLORES
    Color amarillo_ejemplo = new Color(209, 148, 15);
    Color cbotones = new Color(148, 210, 56);
    JPanel Panel;
    public VentanaAdmin() {
        
        //PANEL PRINCIPAL
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5,25,5,5));
        setContentPane(Panel);
        Panel.setLayout(null);
        
        //PESTAÑAS
        JTabbedPane pestañas = new JTabbedPane(JTabbedPane.TOP);
        pestañas.setBounds(10, 11, 1290, 650);
        pestañas.setFont(new Font("Century Gothic", Font.PLAIN,15));
        pestañas.setBackground(Color.WHITE);
        Panel.add(pestañas);
        
        //PANEL DE ANALISTAS Y ENVIAMOS LA VENTANA PADRE QUE ES DONDE ESTAMOS
        PanelAnalistas pa = new PanelAnalistas(this);
        //(NOMBRE_PESTAÑA,ICONO,COMPONENTE-PANEL,TEXTO QUE SE PONE AL PONER EL CURSOR ENCIMA DE LA PESTAÑA)
        pestañas.addTab("Analistas", null, pa, "Pestaña de analistas");
        
        //PANEL DE DOCUMENTOS
        PanelDocumentos pd = new PanelDocumentos(this);
        pestañas.addTab("Documentos", null,pd,"Pestaña de documentos");
        
        //PANEL DE COINCIDENCIAS
        PanelCoincidencia pc = new PanelCoincidencia(this);
        pestañas.addTab("Coincidencias", null,pc,"Pestaña de Coincidencias");
        
        //SIEMPRE PERO SIEMPREEEEE EL DISEÑO DE LA VENTANA VA HASTA DE ULTIMO EN EL CONSTRUCTOR
        // DISEÑO DE LA VENTANA
        // TITULO DE LA VENTANA
        this.setTitle("Administrador - IPCPlag");
        
        //COORDENADAS PARA TAMAÑO DE LA VENTANA
        /*
        THIS.SETBOUNDS(X1,Y1,X2,Y2);
        X1 = ESPACIO ENTRE LA PANTALLA Y LA VENTANA EN HORIZONTAL
        Y1 = ESPACIO ENTRE LA PANTALLA Y LA VENTANA EN VERTICAL
        X2 = TAMAÑO EN HORIZONTAL DE LA VENTANA
        Y2 = TAMAÑO EN VERTICAL DE LA VENTANA
        */
        this.setBounds(150,150,1320,700);
        //QUITAR LOS MARGENES PARA PERSONALIZAR Y NO TENER PROBLEMAS AL PONER NUESTROS COMPONENTES
        this.setLayout(null);
        //QUITAR OPCION QUE EL USUARIO CAMBIE EL TAMAÑO DE LA VENTANA
        this.setResizable(false);
        //VER LA VENTANA
        this.setVisible(true);
        //AGREGAR UN COLOR DE FONDO PARA LA VENTANA
        this.getContentPane().setBackground(amarillo_ejemplo);
        //CERRAR LA VENTANA Y EL PROCESO EN EJECUCION
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //LOGICA DE BOTONES Y ESO
        
    }
    
}
