package ib.facmed.unam.mx.simexfacmed.Models;

import java.util.ArrayList;

public class SimexPonentes {

    private ArrayList<Ponente> ponentes = null;

    public SimexPonentes() {
    }
    public SimexPonentes(ArrayList<Ponente> ponentes) {
        super();
        this.ponentes = ponentes;
    }

    public ArrayList<Ponente> getPonentes() {
        return ponentes;
    }

    public void setPonentes(ArrayList<Ponente> ponentes) {
        this.ponentes = ponentes;
    }
}
