/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author rodri
 */
public class Calculadora {
    private int numero1;
    private int numero2;
    private String operacion;

    public Calculadora() {
        this.numero1 = 0;
        this.numero2 = 0;
        this.operacion = "";
    }

    /**
     * @return the numero1
     */
    public int getNumero1() {
        return numero1;
    }

    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    /**
     * @return the numero2
     */
    public int getNumero2() {
        return numero2;
    }

    /**
     * @param numero2 the numero2 to set
     */
    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    public int suma(){
        return this.numero1 + this.numero2;
    }
    
    public int resta(){
        return this.numero1 - this.numero2;
    }
    
    public int multiplicacion(){
        return this.numero1 * this.numero2;
    }
    
    public int potencia(){
        int resultado = 1;
        
        for (int i = 0; i < this.numero2; i++) {
            resultado *= this.numero1;
        }
        
        return resultado;        
    }
}
