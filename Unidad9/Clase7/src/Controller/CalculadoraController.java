/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Calculadora;
import Views.CalculadoraView;

/**
 *
 * @author rodri
 */
public class CalculadoraController {
    CalculadoraView vista;
    Calculadora modelo;

    public CalculadoraController(CalculadoraView vista, Calculadora modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void mostrar(){
        this.vista.setVisible(true);
        this.accionBoton1();
        this.accionBoton2();
        this.accionBoton3();
        this.accionBoton4();
        this.accionBoton5();
        this.accionBoton6();
        this.accionBoton7();
        this.accionBoton8();
        this.accionBoton9();
        this.accionBoton0();
        this.accionSuma();
        this.accionResta();
        this.accionMultiplicacion();
        this.accionPotencia();
        this.accionIgual();
        this.accionClear();
        this.accionConvertirABinario();
        this.accionConvertirAEntero();
        this.accionConvertirAHexadecimal();
        this.accionConvertirAOctal();
    }
    
    public void accionBoton1(){
        this.vista.jButton2.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "1");
        });
    }
    
    public void accionBoton2(){
        this.vista.jButton3.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "2");
        });
    }
    
    public void accionBoton3(){
        this.vista.jButton4.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "3");
        });
    }
    
    public void accionBoton4(){
        this.vista.jButton5.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "4");
        });
    }
    
    public void accionBoton5(){
        this.vista.jButton1.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "5");
        });
    }
    
    public void accionBoton6(){
        this.vista.jButton6.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "6");
        });
    }
    
    public void accionBoton7(){
        this.vista.jButton7.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "7");
        });
    }
    
    public void accionBoton8(){
        this.vista.jButton9.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "8");
        });
    }
    
    public void accionBoton9(){
        this.vista.jButton8.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "9");
        });
    }
    
    public void accionBoton0(){
        this.vista.jButton10.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            this.vista.jTextField1.setText(texto_obtenido + "0");
        });
    }
    
    public void accionSuma(){
        this.vista.jButton13.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            if(texto_obtenido.equals("")){
                return;
            }
            this.modelo.setNumero1(Integer.parseInt(texto_obtenido));
            this.modelo.setOperacion("+");
            this.vista.jTextField1.setText("");
        });
    }
    
    public void accionResta(){
        this.vista.jButton14.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            if(texto_obtenido.equals("")){
                return;
            }
            this.modelo.setNumero1(Integer.parseInt(texto_obtenido));
            this.modelo.setOperacion("-");
            this.vista.jTextField1.setText("");
        });
    }
    
    public void accionMultiplicacion(){
        this.vista.jButton15.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            if(texto_obtenido.equals("")){
                return;
            }
            this.modelo.setNumero1(Integer.parseInt(texto_obtenido));
            this.modelo.setOperacion("*");
            this.vista.jTextField1.setText("");
        });
    }
    
    public void accionPotencia(){
        this.vista.jButton16.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            if(texto_obtenido.equals("")){
                return;
            }
            this.modelo.setNumero1(Integer.parseInt(texto_obtenido));
            this.modelo.setOperacion("^");
            this.vista.jTextField1.setText("");
        });
    }
    
    public void accionIgual(){
        this.vista.jButton11.addActionListener(e -> {
            String texto_obtenido = this.vista.jTextField1.getText();
            if(texto_obtenido.equals("")){
                return;
            }
            this.modelo.setNumero2(Integer.parseInt(texto_obtenido));
            
            //STRING -> INT : INTEGER.PARSEINT()
            //INT -> STRING : STRING.VALUEOF()
            
            switch(this.modelo.getOperacion()){
                case "+":
                    this.vista.jTextField1.setText(String.valueOf(this.modelo.suma()));
                    break;
                case "-":
                    this.vista.jTextField1.setText(String.valueOf(this.modelo.resta()));
                    break;
                case "*":
                    this.vista.jTextField1.setText(String.valueOf(this.modelo.multiplicacion()));
                    break;
                case "^":
                    this.vista.jTextField1.setText(String.valueOf(this.modelo.potencia()));
                    break;
            }
        });
    }
    
    public void accionClear(){
        this.vista.jButton12.addActionListener(e -> {
            this.vista.jTextField1.setText("");
            this.modelo.setNumero1(0);
            this.modelo.setNumero2(0);
            this.modelo.setOperacion("");
        });
    }
    
    public void accionConvertirABinario(){
        this.vista.jButton17.addActionListener(e -> {
            String texto = this.vista.jTextField1.getText();
            if(texto.equals("")){
                return;
            }
            
            int numero = Integer.parseInt(texto);
            
            String binario_saliente = Integer.toBinaryString(numero);
            
            this.vista.jTextField1.setText(binario_saliente);
        });
    }
    
    public void accionConvertirAEntero(){
        this.vista.jButton18.addActionListener(e -> {
            String texto = this.vista.jTextField1.getText();
            if(texto.equals("")){
                return;
            }
            int numero_entero = Integer.parseInt(texto,2);
            this.vista.jTextField1.setText(String.valueOf(numero_entero));
        });
    }
    
    public void accionConvertirAHexadecimal(){
        this.vista.jButton19.addActionListener(e ->{
            String texto = this.vista.jTextField1.getText();
            if(texto.equals("")){
                return;
            }
            
            int numero = Integer.parseInt(texto);
            System.out.println(numero);
            String binario_saliente = Integer.toHexString(numero);
            System.out.println(binario_saliente);
            this.vista.jTextField1.setText(binario_saliente);
        });
    }
    
    public void accionConvertirAOctal(){
        this.vista.jButton20.addActionListener(e ->{
            String texto = this.vista.jTextField1.getText();
            if(texto.equals("")){
                return;
            }
            
            int numero = Integer.parseInt(texto);
            System.out.println(numero);
            String binario_saliente = Integer.toOctalString(numero);
            System.out.println(binario_saliente);
            this.vista.jTextField1.setText(binario_saliente);
        });
    }
}
