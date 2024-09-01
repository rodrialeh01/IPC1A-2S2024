/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Clases.Documento;
import extra4.Extra4;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class PanelAsignacion extends JPanel implements ActionListener{
    Color grisito = new Color(197, 201, 190);
    JButton basignar;
    JTextField tcodigo1,tcodigo2;
    JLabel lcodigo1, lcodigo2;
    //ATRIBUTO DE LA VENTANA PADRE PARA PODER HACER CAMBIOS EN LA VENTANA
    VentanaAdmin va;
    
    //EN EL CONSTRUCTOR SOLICITAMOS NUESTRA VENTANA PARE
    public PanelAsignacion(VentanaAdmin va) {
        this.va = va;
        
        //LABEL CODIGO
        lcodigo1 = new JLabel("Código INV: ");
        lcodigo1.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcodigo1.setBounds(40,100,100,30);
        lcodigo1.setVisible(true);
        lcodigo1.setForeground(Color.WHITE);
        this.add(lcodigo1);
        
        //TEXTFIELD CODIGO
        tcodigo1 = new JTextField();
        tcodigo1.setBounds(140,100,280,30);
        tcodigo1.setFont(new Font("Century Gothic",Font.BOLD,18));
        tcodigo1.setVisible(true);
        this.add(tcodigo1);
        
        //LABEL DESCRIPCIÓN
        lcodigo2 = new JLabel("Código M: ");
        lcodigo2.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcodigo2.setBounds(40,180,100,30);
        lcodigo2.setVisible(true);
        lcodigo2.setForeground(Color.WHITE);
        this.add(lcodigo2);
        
        //TEXTFIELD DESCRIPCIÓN
        tcodigo2 = new JTextField();
        tcodigo2.setBounds(140,180,280,30);
        tcodigo2.setFont(new Font("Century Gothic",Font.BOLD,18));
        tcodigo2.setVisible(true);
        this.add(tcodigo2);
        
        //BOTON CREAR
        basignar = new JButton("Crear");
        basignar.setBounds(900,10,150,50);
        basignar.setFont(new Font("Century Gothic", Font.BOLD,15));
        basignar.setForeground(Color.ORANGE);
        basignar.setBackground(Color.GRAY);
        basignar.setVisible(true);
        basignar.addActionListener(this);
        this.add(basignar);
        
        //DISEÑO PANEL
        this.setLayout(null);
        this.setBackground(grisito);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code1 = tcodigo1.getText();
        String code2 = tcodigo2.getText();
        if(e.getSource() == basignar){
            if(!code1.equals("") && !code2.equals("")){
                //OBTENGO EL DOCUMENTO
                Documento doc = Extra4.obtenerDocumento(code2);
                Extra4.obtenerAnalista(code1).setDocumento_asignado(doc);
            }
        }
    }
}
