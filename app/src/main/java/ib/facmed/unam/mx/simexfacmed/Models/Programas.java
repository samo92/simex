package ib.facmed.unam.mx.simexfacmed.Models;

import java.util.ArrayList;

/**
 * Created by samo92 on 04/04/2018.
 */

public class Programas {

        private ArrayList<Dia_3005> _3005 = null;
        private ArrayList<Dia_3005> _3105 = null;
        private ArrayList<Dia_3005> _0106 = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public Programas() {
        }
        public Programas(ArrayList<Dia_3005> _3005, ArrayList<Dia_3005> _3105, ArrayList<Dia_3005> _0106) {
            super();
            this._3005 = _3005;
            this._3105 = _3105;
            this._0106 = _0106;
        }

    public ArrayList<Dia_3005> get_3005() {
        return _3005;
    }

    public ArrayList<Dia_3005> get_3105() {
        return _3105;
    }

    public ArrayList<Dia_3005> get_0106() {
        return _0106;
    }

    public void set_3005(ArrayList<Dia_3005> _3005) {
        this._3005 = _3005;
    }

    public void set_3105(ArrayList<Dia_3005> _3105) {
        this._3105 = _3105;
    }

    public void set_0106(ArrayList<Dia_3005> _0106) {
        this._0106 = _0106;
    }
}
