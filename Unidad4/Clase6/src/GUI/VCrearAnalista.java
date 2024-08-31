/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Clases.Analista;
import clase6.Clase6;

/**
 *
 * @author rodri
 */
public class VCrearAnalista extends JFrame implements ActionListener{

    JLabel titulo, lusuario, lnombre,lgenero,lcontrasenia;
    JTextField tusuario,tnombre,tgenero;
    JPasswordField tcontrasenia;
    JButton bcrear,bregresar;
    String usuario,nombre,genero,contrasenia;
    Color morado_ejemplo = new Color(91, 58, 240);

    public VCrearAnalista() {
        //TITULO
        titulo = new JLabel("Crear Analista");
        titulo.setFont(new Font("Century Gothic",Font.BOLD,30));
        titulo.setBounds(120,30,250,30);
        titulo.setVisible(true);
        titulo.setForeground(Color.WHITE);
        this.add(titulo);
        
        //LABEL USUARIO
        lusuario = new JLabel("Usuario: ");
        lusuario.setFont(new Font("Century Gothic",Font.BOLD,18));
        lusuario.setBounds(40,100,100,30);
        lusuario.setVisible(true);
        lusuario.setForeground(Color.WHITE);
        this.add(lusuario);
        
        //TEXTFIELD USUARIO
        tusuario = new JTextField();
        tusuario.setBounds(140,100,280,30);
        tusuario.setFont(new Font("Century Gothic",Font.BOLD,18));
        tusuario.setVisible(true);
        this.add(tusuario);
        
        //LABEL NOMBRE
        lnombre = new JLabel("Nombre: ");
        lnombre.setFont(new Font("Century Gothic",Font.BOLD,18));
        lnombre.setBounds(40,180,100,30);
        lnombre.setVisible(true);
        lnombre.setForeground(Color.WHITE);
        this.add(lnombre);
        
        //TEXTFIELD NOMBRE
        tnombre = new JTextField();
        tnombre.setBounds(140,180,280,30);
        tnombre.setFont(new Font("Century Gothic",Font.BOLD,18));
        tnombre.setVisible(true);
        this.add(tnombre);
        
        //LABEL GENERO
        lgenero = new JLabel("Genero: ");
        lgenero.setFont(new Font("Century Gothic",Font.BOLD,18));
        lgenero.setBounds(40,260,100,30);
        lgenero.setVisible(true);
        lgenero.setForeground(Color.WHITE);
        this.add(lgenero);
        
        //TEXTFIELD GENERO
        tgenero = new JTextField();
        tgenero.setBounds(140,260,280,30);
        tgenero.setFont(new Font("Century Gothic",Font.BOLD,18));
        tgenero.setVisible(true);
        this.add(tgenero);
        
        //LABEL CONTRASENIA
        lcontrasenia = new JLabel("Contraseña: ");
        lcontrasenia.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcontrasenia.setBounds(40,340,100,30);
        lcontrasenia.setVisible(true);
        lcontrasenia.setForeground(Color.WHITE);
        this.add(lcontrasenia);
        
        //PASSWORDFIELD USUARIO
        tcontrasenia = new JPasswordField();
        tcontrasenia.setBounds(140,340,280,30);
        tcontrasenia.setFont(new Font("Century Gothic",Font.BOLD,18));
        tcontrasenia.setVisible(true);
        //CAMBIAR EL CARACTER QUE HACE QUE SE OCULTE
        tcontrasenia.setEchoChar('*');
        this.add(tcontrasenia);
        
        //BOTON REGRESAR
        bregresar = new JButton("Regresar");
        bregresar.setBounds(100,450,280,40);
        bregresar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //bcrear.setEnabled(false);
        this.add(bregresar);
        
        //BOTON CREAR ANALISTA
        bcrear = new JButton("Crear Analista");
        bcrear.setBounds(100,500,280,40);
        bcrear.addActionListener(this);
        //BLOQUEAR UN BOTON
        //bcrear.setEnabled(false);
        this.add(bcrear);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Crear Analista");
        this.setBounds(450, 100, 500, 600);
        this.getContentPane().setBackground(morado_ejemplo);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //OBTENGO LA INFO DE LOS TEXTFIELD
        usuario = tusuario.getText();
        nombre = tnombre.getText();
        genero = tgenero.getText();
        contrasenia = tcontrasenia.getText();
        
        if(e.getSource() == bcrear){
            //CREAR EL OBJETO DE TIPO ANALISTA
            Analista nuevo = new Analista(usuario,nombre,contrasenia,genero);
            //AGREGARLO A LA LISTA
            Clase6.añadirAnalista(nuevo);
            //DESTRUIR LA VENTANA ACTUAL
            this.dispose();
            //ABRA EL VENTANAADMIN
            VentanaAdmin va = new VentanaAdmin();
        }else if(e.getSource() == bregresar){
            //DESTRUIR LA VENTANA ACTUAL
            this.dispose();
            //ABRA EL VENTANAADMIN
            VentanaAdmin va = new VentanaAdmin();
        }
    }
    
}
