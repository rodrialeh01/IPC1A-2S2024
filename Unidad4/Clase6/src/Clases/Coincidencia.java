/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
//IMPORTAMOS UNA LIBRERIA PARA SERIALIZAR OBJETOS
import java.io.Serializable;
/**
 *
 * @author rodri
 */
public class Coincidencia implements Serializable{
    private String codigo;
    private String nombre;
    private int[][] texto;

    public Coincidencia(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the texto
     */
    public int[][] getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(int[][] texto) {
        this.texto = texto;
    }
    
    
}
