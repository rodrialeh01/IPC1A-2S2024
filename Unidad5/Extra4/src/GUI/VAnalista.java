/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Clases.Analista;
import Clases.Coincidencia;
import Clases.Documento;
import extra4.Extra4;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author rodri
 */
public class VAnalista extends JFrame implements ActionListener{
    JLabel titulo, lcodigo;
    JTextField tcodigo;
    JButton banalizar, bregresar;
    String codigoc;
    String codigo_analista_logueado;
    public VAnalista(String codigo_analista_logueado) {
        this.codigo_analista_logueado = codigo_analista_logueado;
        //TITULO
        titulo = new JLabel("Analizar");
        titulo.setFont(new Font("Century Gothic",Font.BOLD,15));
        titulo.setBounds(120,30,250,30);
        titulo.setVisible(true);
        this.add(titulo);
        
        //label de codigo
        lcodigo = new JLabel("Codigo: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcodigo.setBounds(40,100,100,30);
        lcodigo.setVisible(true);
        this.add(lcodigo);
        
        //BOTON REGRESAR
        bregresar = new JButton("Regresar");
        bregresar.setBounds(100,450,280,40);
        bregresar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(bregresar);
        
        //BOTON ELIMINAR ANALISTA
        banalizar = new JButton("Analizar");
        banalizar.setBounds(100,500,280,40);
        banalizar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(banalizar);
        
        //TEXTFIELD DE CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(140,100,100,30);
        tcodigo.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Analista");
        this.setBounds(450, 100, 500, 600);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        //CERRAR LA VENTANA Y EL PROCESO EN EJECUCION
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        codigoc = tcodigo.getText();
        if (e.getSource() == banalizar) {
            Analista logueado = extra4.Extra4.obtenerAnalista(this.codigo_analista_logueado);
            System.out.println("EL NOMBRE DEL LOGUEADO ES: " + logueado.getDocumento_asignado());
            Documento documento = logueado.getDocumento_asignado();
            Coincidencia coincidencia = Extra4.obtenerCoincidencia(codigoc);
            int[][] matriz_doc = documento.getTexto();
            int[][] matriz_coi = coincidencia.getTexto();
            try {
                Extra4.Analizar(matriz_doc, matriz_coi);
                this.abrirArchivo("Analisis/Analisis.html");
                //se agrega al objeto analisis
                Extra4.contador_analisis+= 1;
            } catch (IOException ex) {
                
            }
        }else if(e.getSource() == bregresar){
            
        }
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
