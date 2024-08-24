/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Clases.Documento;
import clase5.Clase5;

/**
 *
 * @author rodri
 */
public class VCrearDocumento extends JFrame implements ActionListener{
    JLabel titulo, lcodigo, ldescripcion, ldocumento;
    JTextField tcodigo,tdescripcion;
    JButton bcrear, bcargar, bregresar;
    String codigo,descripcion;
    Color morado_ejemplo = new Color(91, 58, 240);

    public VCrearDocumento() {
        //TITULO
        titulo = new JLabel("Crear Documento");
        titulo.setFont(new Font("Century Gothic",Font.BOLD,30));
        titulo.setBounds(120,30,250,30);
        titulo.setVisible(true);
        titulo.setForeground(Color.WHITE);
        this.add(titulo);
        
        //LABEL CODIGO
        lcodigo = new JLabel("Código: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcodigo.setBounds(40,100,100,30);
        lcodigo.setVisible(true);
        lcodigo.setForeground(Color.WHITE);
        this.add(lcodigo);
        
        //TEXTFIELD CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(140,100,280,30);
        tcodigo.setFont(new Font("Century Gothic",Font.BOLD,18));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //LABEL DESCRIPCIÓN
        ldescripcion = new JLabel("Descripción: ");
        ldescripcion.setFont(new Font("Century Gothic",Font.BOLD,18));
        ldescripcion.setBounds(40,180,100,30);
        ldescripcion.setVisible(true);
        ldescripcion.setForeground(Color.WHITE);
        this.add(ldescripcion);
        
        //TEXTFIELD DESCRIPCIÓN
        tdescripcion = new JTextField();
        tdescripcion.setBounds(140,180,280,30);
        tdescripcion.setFont(new Font("Century Gothic",Font.BOLD,18));
        tdescripcion.setVisible(true);
        this.add(tdescripcion);
        
        //LABEL DOCUMENTO
        ldocumento = new JLabel("Documento: ");
        ldocumento.setFont(new Font("Century Gothic",Font.BOLD,18));
        ldocumento.setBounds(40,260,100,30);
        ldocumento.setVisible(true);
        ldocumento.setForeground(Color.WHITE);
        this.add(ldocumento);
        
        //BOTON CARGAR DOCUMENTO
        bcargar = new JButton("Cargar");
        bcargar.setBounds(140,260,280,30);
        bcargar.setFont(new Font("Century Gothic",Font.BOLD,18));
        bcargar.setVisible(true);
        bcargar.addActionListener(this);
        this.add(bcargar);
        
        //BOTON REGRESAR
        bregresar = new JButton("Regresar");
        bregresar.setBounds(100,450,280,40);
        bregresar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //bcrear.setEnabled(false);
        this.add(bregresar);
        
        //BOTON CREAR ANALISTA
        bcrear = new JButton("Crear Documento");
        bcrear.setBounds(100,500,280,40);
        bcrear.addActionListener(this);
        //BLOQUEAR UN BOTON
        //bcrear.setEnabled(false);
        this.add(bcrear);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Crear Documento");
        this.setBounds(450, 100, 500, 600);
        this.getContentPane().setBackground(morado_ejemplo);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //OBTENGO LA INFO DE LOS TEXTFIELD
        codigo = tcodigo.getText();
        descripcion = tdescripcion.getText();
        int[][] matriz = null;
        
        if(e.getSource() == bcrear){
            //CREAR EL OBJETO DE TIPO DOCUMENTO
            Documento nuevo = new Documento(codigo, descripcion, "Ingreso");
            if(matriz != null){
                nuevo.setTexto(matriz);
                Clase5.añadirDocumento(nuevo);
            }
            //DESTRUIR LA VENTANA ACTUAL
            this.dispose();
            //ABRA EL VENTANAADMIN
            VentanaAdmin va = new VentanaAdmin();
        }else if(e.getSource() == bregresar){
            //DESTRUIR LA VENTANA ACTUAL
            this.dispose();
            //ABRA EL VENTANAADMIN
            VentanaAdmin va = new VentanaAdmin();
        }else if(e.getSource() == bcargar){
            JFileChooser jfc = new JFileChooser();
            int op = jfc.showOpenDialog(this);
            if(op == JFileChooser.APPROVE_OPTION){
                System.out.println(jfc.getSelectedFile());
                matriz = Clase5.csv_to_matrix(jfc.getSelectedFile());
            }
        }
    }
}
