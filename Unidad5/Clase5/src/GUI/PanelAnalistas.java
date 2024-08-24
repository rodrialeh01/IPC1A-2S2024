/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author rodri
 */

import Clases.Analista;
import clase5.Clase5;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        datos = Clase5.convertirTablaAnalista();
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
        }else if(e.getSource() == bcargar){
            //aqui se carga
            this.cargaMasiva();
        }else if(e.getSource() == bactualizar){
            this.va.dispose();
            VEditarAnalista vea = new VEditarAnalista();
        }else if(e.getSource() == beliminar){
            this.va.dispose();
            VEliminarAnalista vela = new VEliminarAnalista();
        }
    }
    
    public void cargaMasiva(){
        //DECLARAR LA CLASE FILE
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            //JFILECHOOSER PARA BUSCAR UN ARCHIVO DESDE INTERFAZ GRAFICA
            JFileChooser jfc = new JFileChooser();
            int op = jfc.showOpenDialog(this);
            if(op == JFileChooser.APPROVE_OPTION){
                System.out.println(jfc.getSelectedFile());
                archivo = jfc.getSelectedFile();
            }
            
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            int contador = 0;
            
            while((linea = br.readLine()) != null){
                System.out.println(linea);
                if(contador != 0){
                    String[] fila_datos = linea.split(",");
                    String codigo = fila_datos[0].trim();
                    String nombre = fila_datos[1].trim();
                    String genero = fila_datos[2].trim();
                    int cantidad_analisis = Integer.parseInt(fila_datos[3].trim());
                    String contrasenia = fila_datos[4].trim();
                    Analista nuevo = new Analista(codigo, nombre,contrasenia,genero);
                    nuevo.setCantidad_analisis(cantidad_analisis);
                    Clase5.añadirAnalista(nuevo);
                }
                contador++;
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo");
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        
        this.va.dispose();
        VentanaAdmin va = new VentanaAdmin();
    }
}
