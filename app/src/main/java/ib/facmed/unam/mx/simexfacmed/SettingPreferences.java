package ib.facmed.unam.mx.simexfacmed;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import ib.facmed.unam.mx.simexfacmed.Models.Programas;

public class SettingPreferences {


    private static final String PERSON_PREFERENCE_KEY = "MisPreferencias";
    private final Context context;

    public SettingPreferences(Context context) {
        this.context = context;
    }


    public void save(Programas programa) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        String json = new Gson().toJson(programa);
        edit.putString(PERSON_PREFERENCE_KEY,json);
        edit.apply();
    }

    public Programas getPrograma() {
        String json = getSharedPreferences().getString(PERSON_PREFERENCE_KEY,null);
        if(json == null){
            return new Programas();
        }
        Programas programa = new Gson().fromJson(json, Programas.class);
        return programa;
    }


    private SharedPreferences getSharedPreferences(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences;
    }

}