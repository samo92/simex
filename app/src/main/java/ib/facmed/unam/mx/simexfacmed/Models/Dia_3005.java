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

    public Dia_3005 () {
    }

    public Dia_3005 (String horaInicio, String horaFin, String actividad, String ponente, String sede, String ponente2, String sede2, String ponente3, String sede3, String ponente4, String sede4) {
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
        if(ponente!=null)
            return ponente;
        else{
            return "---";
        }
    }

    public void setPonente(String ponente) {
        this.ponente = ponente;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPonente2() {
        return ponente2;
    }

    public void setPonente2(String ponente2) {
        this.ponente2 = ponente2;
    }

    public String getSede2() {
        return sede2;
    }

    public void setSede2(String sede2) {
        this.sede2 = sede2;
    }

    public String getPonente3() {
        return ponente3;
    }

    public void setPonente3(String ponente3) {
        this.ponente3 = ponente3;
    }

    public String getSede3() {
        return sede3;
    }

    public void setSede3(String sede3) {
        this.sede3 = sede3;
    }

    public String getPonente4() {
        return ponente4;
    }

    public void setPonente4(String ponente4) {
        this.ponente4 = ponente4;
    }

    public String getSede4() {
        return sede4;
    }

    public void setSede4(String sede4) {
        this.sede4 = sede4;
    }

    //Metodos adicionales

    public String getSoloHoraInicio(){
        if(horaInicio!=null)
            return horaInicio.substring(11,16);
        else{
            return "XX:XX";
        }
    }

    public String getSoloHoraFin(){
        if(horaFin!=null)
            return horaFin.substring(11,16);
        else{
            return "XX:XX";
        }
    }

    public String getSoloMesInicio(){
        if(horaInicio!=null)
            return horaInicio.substring(5,7);
        else{
            return "12";
        }
    }

    public String getSoloDiaInicio(){
        if(horaInicio!=null)
            return horaInicio.substring(8,10);
        else{
            return "01";
        }
    }

    /*public String getsoloHoroInicio(){
        try {
            Date date = null;
            date = df.parse(horaInicio);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String shortTimeStr = sdf.format(date);
            System.out.println(shortTimeStr);
        } catch (ParseException e) {
            // To change body of catch statement use File | Settings | File Templates.
            e.printStackTrace();
        }
    }*/
}
