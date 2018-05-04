package ib.facmed.unam.mx.simexfacmed.Models;

public class Ponente {

    //ATRIBUTOS
    private String nombre;
    private String institucion;
    private int imagenPonente;

    //CONSTRUCTOR
    public Ponente(String nombre, String institucion, int imagenPonente) {
        this.nombre = nombre;
        this.institucion = institucion;
        this.imagenPonente = imagenPonente;
    }

    //METODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
}
