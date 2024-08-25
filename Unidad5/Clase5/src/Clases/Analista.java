/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rodri
 */
public class Analista {
    //ATRIBUTOS
    private String usuario;
    private String nombre;
    private String contrasenia;
    private String genero;
    private int cantidad_analisis;
    private Documento documento_asignado;

    public Analista(String usuario, String nombre,String contrasenia, String genero) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.genero = genero;
        this.cantidad_analisis = 0;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the cantidad_analisis
     */
    public int getCantidad_analisis() {
        return cantidad_analisis;
    }

    /**
     * @param cantidad_analisis the cantidad_analisis to set
     */
    public void setCantidad_analisis(int cantidad_analisis) {
        this.cantidad_analisis = cantidad_analisis;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Documento getDocumento_asignado() {
        return documento_asignado;
    }

    public void setDocumento_asignado(Documento documento_asignado) {
        this.documento_asignado = documento_asignado;
    }
    
    
}
