/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author rodri
 */

import Clases.Documento;
import extra4.Extra4;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;



public class PanelDocumentos extends JPanel implements ActionListener, MouseListener{
    Color grisito = new Color(197, 201, 190);
    JButton bcrear,bcargar;
    static JTable tabla;
    static Object[][] datos;
    //ATRIBUTO DE LA VENTANA PADRE PARA PODER HACER CAMBIOS EN LA VENTANA
    VentanaAdmin va;
    //EN EL CONSTRUCTOR SOLICITAMOS NUESTRA VENTANA PARE
    public PanelDocumentos(VentanaAdmin va) {
        this.va = va;
        
        //BOTON CREAR
        bcrear = new JButton("Crear");
        this.va = va;
        
        //BOTON CREAR
        bcrear = new JButton("Crear");
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
        
        //TABLA
        //ENCABEZADO
        String[] encabezado = {"Código","Descripción","Estado","Acciones"};
        //DATOS
        datos = Extra4.convertirTablaDocumentos();
        tabla = new JTable(datos,encabezado);
        tabla.setDefaultRenderer(Object.class, new TablaDocs());
        tabla.addMouseListener(this);
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
            this.va.dispose();
            VCrearDocumento vcd = new VCrearDocumento();            
        }else if(e.getSource() == bcargar){
            //aqui se carga
            this.cargaMasiva();
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
                    String descripcion = fila_datos[1].trim();
                    String texto = fila_datos[2].trim();
                    int[][] matriz_texto = Extra4.ptc_to_matrix(texto);
                    Documento nuevo = new Documento(codigo,descripcion,"Ingreso");
                    nuevo.setTexto(matriz_texto);
                    Extra4.añadirDocumento(nuevo);
                    Extra4.crearArchivo(matriz_texto, codigo, "ReportesDocumentos","Documento");
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

    
    //METODOS DEL MOUSELISTENER
    @Override
    public void mouseClicked(MouseEvent e) {
        //OBTENEMOS LAS COORDENADAS DE LA TABLAS
        int posy = tabla.getColumnModel().getColumnIndexAtX(e.getX());
        System.out.println("Y: " + posy);
        int posx = e.getY()/tabla.getRowHeight();
        System.out.println("X: " + posx);
        //VERIFICA LAS COORDENADAS DE LA TABLA
        if(posx < tabla.getRowCount() && posx>= 0 && posy < tabla.getColumnCount() && posy>=0){
            //OBTENEMOS EL OBJETO SELECCIONADO
            Object objeto = tabla.getValueAt(posx, posy);
            System.out.println(objeto);
            if(objeto instanceof JLabel){
                JLabel lbl = (JLabel) objeto;
                System.out.println("El nombre del jlabel es: " + lbl.getName());
                String ruta_archivo = lbl.getName() + ".html";
                this.abrirArchivo(ruta_archivo);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    //ABRIR UN ARCHIVO Y MOSTRARLO AL USUARIO
    public void abrirArchivo(String ruta){
        try{
            File archivo_html_a_abrir = new File(ruta);
            Desktop.getDesktop().open(archivo_html_a_abrir);
        }catch(IOException ex){
            
        }
    }
}
