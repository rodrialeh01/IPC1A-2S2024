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
public class Documento implements Serializable{
    private String codigo;
    private String descripcion;
    private String estado;
    private int[][] texto;

    public Documento(String codigo, String descripcion, String estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
