package ib.facmed.unam.mx.simexfacmed.Models;



import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by samo92 on 04/04/2018.
 */

public class Dia_3005 implements Serializable {

    private String horaInicio;
    private String horaFin;
    private String actividad;
    private String ponente;
    private String sede;
    private String ponente2;
    private String sede2;
    private String ponente3;
    private String sede3;
    private String ponente4;
    private String sede4;
    private String lugar;
    private String nota;

    public Dia_3005() {
    }

    public Dia_3005(String horaInicio, String horaFin, String actividad, String ponente, String sede, String ponente2, String sede2, String ponente3, String sede3, String ponente4, String sede4, String lugar, String nota) {
        super();
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.actividad = actividad;
        this.ponente = ponente;
        this.sede = sede;
        this.ponente2 = ponente2;
        this.sede2 = sede2;
        this.ponente3 = ponente3;
        this.sede3 = sede3;
        this.ponente4 = ponente4;
        this.sede4 = sede4;
        this.lugar = lugar;
        this.nota = nota;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getPonente() {
        if (ponente != null)
            return ponente;
        else {
            return "";
        }
    }

    public void setPonente(String ponente) {
        this.ponente = ponente;
    }

    public String getSede() {
        if (sede != null)
            return sede;
        else {
            return "";
        }
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPonente2() {
        if (ponente2 != null)
            return ponente2;
        else {
            return "";
        }
    }

    public void setPonente2(String ponente2) {
        this.ponente2 = ponente2;
    }

    public String getSede2() {
        if (sede2 != null)
            return sede2;
        else {
            return "";
        }
    }

    public void setSede2(String sede2) {
        this.sede2 = sede2;
    }

    public String getPonente3() {
        if (ponente3 != null)
            return ponente3;
        else {
            return "";
        }
    }

    public void setPonente3(String ponente3) {
        this.ponente3 = ponente3;
    }

    public String getSede3() {
        if (sede3 != null)
            return sede3;
        else {
            return "";
        }
    }

    public void setSede3(String sede3) {
        this.sede3 = sede3;
    }

    public String getPonente4() {
        if (ponente4 != null)
            return ponente4;
        else {
            return "";
        }
    }

    public void setPonente4(String ponente4) {
        this.ponente4 = ponente4;
    }

    public String getSede4() {
        if (sede4 != null)
            return sede4;
        else {
            return "";
        }
    }

    public void setSede4(String sede4) {
        this.sede4 = sede4;
    }

    public String getLugar() {
        if (lugar != null)
            return lugar;
        else {
            return "";
        }
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNota() {
        if (nota != null)
            return nota;
        else {
            return "";
        }
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    //Metodos adicionales

    public String getSoloHoraInicio() {
        if (horaInicio != null)
            return horaInicio.substring(11, 16);
        else {
            return "XX:XX";
        }
    }

    public String getSoloHoraFin() {
        if (horaFin != null)
            return horaFin.substring(11, 16);
        else {
            return "XX:XX";
        }
    }

    public String getSoloMesInicio() {
        if (horaInicio != null)
            return horaInicio.substring(5, 7);
        else {
            return "12";
        }
    }

    public String getSoloDiaInicio() {
        if (horaInicio != null)
            return horaInicio.substring(8, 10);
        else {
            return "01";
        }
    }

    public String getFechaCompleta() {
        String fecha="";
        if (horaInicio != null) {
            String dia = horaInicio.substring(8, 10);
            switch (dia){
                case "29":
                    fecha = "29 de Mayo del 2018";
                    break;
                case "30":
                    fecha = "30 de Mayo del 2018";
                    break;
                case "31":
                    fecha = "31 de Mayo del 2018";
                    break;
                case "01":
                    fecha = "01 de Junio del 2018";
                    break;
            }
            return fecha;
            }else{
            return fecha;
        }
    }


}
