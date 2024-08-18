/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author rodri
 */

import extra2.Extra2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelAnalistas extends JPanel implements ActionListener{
    Color grisito = new Color(197, 201, 190);
    JButton bcrear,bcargar,beliminar,bactualizar;
    static JTable tabla;
    static Object[][] datos;
    //ATRIBUTO DE LA VENTANA PADRE PARA PODER HACER CAMBIOS EN LA VENTANA
    VentanaAdmin va;
    //EN EL CONSTRUCTOR SOLICITAMOS NUESTRA VENTANA PARE
    public PanelAnalistas(VentanaAdmin va){
        this.va = va;
        
        //BOTON CREAR
        bcrear = new JButton("Crear");
        bcrear.setBounds(900,10,150,50);
        bcrear.setFont(new Font("Century Gothic", Font.BOLD,15));
        bcrear.setForeground(Color.ORANGE);
        bcrear.setBackground(Color.GRAY);
        bcrear.setVisible(true);
        bcrear.addActionListener(this);
        this.add(bcrear);
        
        //BOTON CARGAR
        bcargar = new JButton("Cargar");
        bcargar.setBounds(1100,10,150,50);
        bcargar.setFont(new Font("Century Gothic", Font.BOLD,15));
        bcargar.setForeground(Color.ORANGE);
        bcargar.setBackground(Color.GRAY);
        bcargar.setVisible(true);
        bcargar.addActionListener(this);
        this.add(bcargar);
        
        //BOTON EDITAR
        bactualizar = new JButton("Editar");
        bactualizar.setBounds(900,70,150,50);
        bactualizar.setFont(new Font("Century Gothic", Font.BOLD,15));
        bactualizar.setForeground(Color.ORANGE);
        bactualizar.setBackground(Color.GRAY);
        bactualizar.setVisible(true);
        bactualizar.addActionListener(this);
        this.add(bactualizar);
        
        //BOTON ELIMINAR
        beliminar = new JButton("Eliminar");
        beliminar.setBounds(1100,70,150,50);
        beliminar.setFont(new Font("Century Gothic", Font.BOLD,15));
        beliminar.setForeground(Color.ORANGE);
        beliminar.setBackground(Color.GRAY);
        beliminar.setVisible(true);
        beliminar.addActionListener(this);
        this.add(beliminar);
        
        //TABLA
        //ENCABEZADO
        String[] encabezado = {"Usuario","Nombre","Genero","Analisis"};
        //DATOS
        //--PENDIENTE--
        datos = Extra2.convertirTablaAnalista();
        tabla = new JTable(datos,encabezado);
        
        //SCROLLPANE
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(20, 10, 800, 600);
        this.add(sp);
        
        //DISEÑO PANEL
        this.setLayout(null);
        this.setBackground(grisito);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bcrear){
            //ELIMINAR LA VENTANA PADRE
            this.va.dispose();
            //MOSTRARÁ LA VENTANA DE CREAR ANALISTA
            VCrearAnalista vca = new VCrearAnalista();
        }
    }
    
}
