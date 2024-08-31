/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author rodri
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import GUI.VentanaAdmin;
import clase6.Clase6;

public class VLogin extends JFrame implements ActionListener{
    JLabel titulo, lcodigo, lpas;
    JTextField tcodigo;
    JPasswordField tpassword;
    String cod, pas;
    JButton bLogin;
    JRadioButton opcion1, opcion2;
    
    public VLogin() {
        //TITULO
        titulo = new JLabel("LOGIN");
        titulo.setFont(new Font("Century Gothic",Font.BOLD,50));
        titulo.setBounds(200,10,400,90);
        titulo.setVisible(true);
        this.add(titulo);
        
        //label de codigo
        lcodigo = new JLabel("Codigo: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,15));
        lcodigo.setBounds(50,130,100,30);
        lcodigo.setVisible(true);
        this.add(lcodigo);
        
        //TEXTFIELD DE CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(160,130,350,25);
        tcodigo.setFont(new Font("Century Gothic",Font.PLAIN,15));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //label de PASSWORD
        lcodigo = new JLabel("Contrasenia: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,15));
        lcodigo.setBounds(50,200,100,30);
        lcodigo.setVisible(true);
        this.add(lcodigo);
        
        //TEXTFIELD DE PASSWORD
        tpassword = new JPasswordField();
        tpassword.setBounds(160,200,350,25);
        tpassword.setFont(new Font("Century Gothic",Font.PLAIN,15));
        tpassword.setVisible(true);
        this.add(tpassword);
        
        //BOTON ELIMINAR CURSO
        bLogin = new JButton("Iniciar Sesión");
        bLogin.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bLogin.setBounds(240,280,150,30);
        bLogin.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(bLogin);

        //DISEÑO DE LA VENTANA
        this.setTitle("Login");
        this.setBounds(400, 200, 600, 400);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cod = tcodigo.getText();
        pas = tpassword.getText();
        if(e.getSource() == bLogin){
            //valida las credenciales del admin
            if(cod.equals("admin") && pas.equals("admin")){
                VentanaAdmin va = new VentanaAdmin();
                this.dispose();
            //validar credenciales analista
            }else if(Clase6.validarCredenciales(cod, pas)){
                System.out.println("BIENVENIDO");
            }else{
                JOptionPane.showMessageDialog(this, "Credenciales Incorrectas");
            }
            
        }
    }
}
