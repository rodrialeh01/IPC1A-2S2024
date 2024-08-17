/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases2;

/**
 *
 * @author rodri
 */
public class Circulo extends Figura implements Calculo{
    private int radio;
    public Circulo(int radio) {
        super(1024);
        this.radio = radio;
    }

    @Override
    public double Area() {
        return 3.14*this.radio*this.radio;
    }

    @Override
    public int perimetro() {
        return 0;
    }
    
}
