package ib.facmed.unam.mx.simexfacmed.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by samo92 on 04/04/2018.
 */

public class Programas implements Serializable {

    @SerializedName("DayOne")
    private ArrayList<Dia_3005> DayOne = null;

    @SerializedName("DayTwo")
    private ArrayList<Dia_3005> DayTwo = null;

    @SerializedName("DayThree")
    private ArrayList<Dia_3005> DayThree = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public Programas() {
        }
        public Programas(ArrayList<Dia_3005> DayOne, ArrayList<Dia_3005> DayTwo, ArrayList<Dia_3005> DayThree) {
            super();
            this.DayOne = DayOne;
            this.DayTwo = DayTwo;
            this.DayThree = DayThree;
        }

    public ArrayList<Dia_3005> getDayOne() {
        return DayOne;
    }

    public void setDayOne(ArrayList<Dia_3005> dayOne) {
        DayOne = dayOne;
    }

    public ArrayList<Dia_3005> getDayTwo() {
        return DayTwo;
    }

    public void setDayTwo(ArrayList<Dia_3005> dayTwo) {
        DayTwo = dayTwo;
    }

    public ArrayList<Dia_3005> getDayThree() {
        return DayThree;
    }

    public void setDayThree(ArrayList<Dia_3005> dayThree) {
        DayThree = dayThree;
    }
}
