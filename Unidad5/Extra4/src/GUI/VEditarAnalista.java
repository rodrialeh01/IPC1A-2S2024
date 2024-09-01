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
import extra4.Extra4;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class VEditarAnalista extends JFrame implements ActionListener{
    JLabel titulo, lcodigo, lnombre, lgenero, lcontrasenia;
    JTextField tcodigo,tnombre,tgenero,tcontrasenia;
    JButton bcrear, bbuscar, bregresar;
    String codigot, nombret, generot,contraseniat;

    public VEditarAnalista() {
        //TITULO
        titulo = new JLabel("Editar Analista");
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
        
        //BOTON BUSCAR
        bbuscar = new JButton("Buscar");
        bbuscar.setBounds(280,100,100,30);
        bbuscar.setFont(new Font("Century Gothic",Font.BOLD,18));
        bbuscar.addActionListener(this);
        bbuscar.setVisible(true);
        this.add(bbuscar);
        
        //TEXTFIELD DE CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(140,100,100,30);
        tcodigo.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //label de NOMBRE
        lnombre = new JLabel("Nombre: ");
        lnombre.setFont(new Font("Century Gothic",Font.BOLD,18));
        lnombre.setBounds(40,180,100,30);
        lnombre.setVisible(true);
        this.add(lnombre);
        
        //TEXTFIELD DE NOMBRE
        tnombre = new JTextField();
        tnombre.setBounds(140,180,280,30);
        tnombre.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tnombre.setVisible(true);
        this.add(tnombre);
        
        //label de CREDITOS
        lgenero = new JLabel("Genero: ");
        lgenero.setFont(new Font("Century Gothic",Font.BOLD,18));
        lgenero.setBounds(40,260,100,30);
        lgenero.setVisible(true);
        this.add(lgenero);
        
        //TEXTFIELD DE CREDITOS
        tgenero = new JTextField();
        tgenero.setBounds(140,260,280,30);
        tgenero.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tgenero.setVisible(true);
        this.add(tgenero);
        
        //label de CONTRASEÑA
        lcontrasenia = new JLabel("Contrasenia: ");
        lcontrasenia.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcontrasenia.setBounds(40,320,100,30);
        lcontrasenia.setVisible(true);
        this.add(lcontrasenia);
        
        //TEXTFIELD DE CONTRASEÑA
        tcontrasenia = new JTextField();
        tcontrasenia.setBounds(140,320,280,30);
        tcontrasenia.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tcontrasenia.setVisible(true);
        this.add(tcontrasenia);
        
        //BOTON REGRESAR
        bregresar = new JButton("Regresar");
        bregresar.setBounds(100,450,280,40);
        bregresar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(bregresar);
        
        //BOTON EDITAR ANALISTA
        bcrear = new JButton("Editar Analista");
        bcrear.setBounds(100,500,280,40);
        bcrear.addActionListener(this);
        //BLOQUEAR UN BOTON
        bcrear.setEnabled(false);
        this.add(bcrear);
        
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Editar Analista");
        this.setBounds(450, 100, 500, 600);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //OBTENGO LA INFO DE LOS TEXTFIELD
        codigot = tcodigo.getText();
        nombret = tnombre.getText();
        generot = tgenero.getText();
        contraseniat = tcontrasenia.getText();
        if(e.getSource() == bbuscar){
            
            Analista encontrado = Extra4.obtenerAnalista(codigot);
            
            if(encontrado == null){
                JOptionPane.showMessageDialog(this, "No se encontro el analista");
                this.dispose();
                VentanaAdmin va = new VentanaAdmin();
            }
            
            tnombre.setText(encontrado.getNombre());
            tgenero.setText(encontrado.getGenero());
            tcontrasenia.setText(encontrado.getContrasenia());
            tcodigo.setEditable(false);
            bcrear.setEnabled(true);
            
        }else if(e.getSource() == bcrear){
            //FORMAS DE ACTUALIZAR
            //creando el objeto y seteando el objeto
            
            Extra4.actualizarAnalista(codigot, nombret, contraseniat, generot);
            
            JOptionPane.showMessageDialog(this, "Se actualizó el analista");
            this.dispose();
            VentanaAdmin va = new VentanaAdmin();
        }else if(e.getSource() == bregresar){
            //DESTRUIR LA VENTANA ACTUAL
            this.dispose();
            //ABRA EL VENTANAADMIN
            VentanaAdmin va = new VentanaAdmin();
        }
    }
}
