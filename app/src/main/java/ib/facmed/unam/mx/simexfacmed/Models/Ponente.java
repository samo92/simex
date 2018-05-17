package ib.facmed.unam.mx.simexfacmed.Models;

import java.io.Serializable;

public class Ponente implements Serializable {

    //ATRIBUTOS
    private String nombrePonente;
    private String institucion;
    private int imagenPonente;
    private String imagen;

    //CONSTRUCTOR
    public Ponente(String nombre, String institucion, int imagenPonente) {
        this.nombrePonente = nombre;
        this.institucion = institucion;
        this.imagenPonente = imagenPonente;
    }

    public Ponente(String nombre, String institucion, String imagen) {
        this.nombrePonente = nombre;
        this.institucion = institucion;
        this.imagen = imagen;
    }

    //METODOS

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public int getImagenPonente() {
        return imagenPonente;
    }

    public void setImagenPonente(int imagenPonente) {
        this.imagenPonente = imagenPonente;
    }

    public String getNombrePonente() {
        return nombrePonente;
    }

    public void setNombrePonente(String nombrePonente) {
        this.nombrePonente = nombrePonente;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
