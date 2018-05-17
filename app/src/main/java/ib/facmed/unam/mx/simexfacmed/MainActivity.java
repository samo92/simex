package ib.facmed.unam.mx.simexfacmed;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Api.ApiService;
import ib.facmed.unam.mx.simexfacmed.Api.PostApiService;
import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.Models.Ponente;
import ib.facmed.unam.mx.simexfacmed.Models.Programas;
import ib.facmed.unam.mx.simexfacmed.Models.SimexPonentes;
import ib.facmed.unam.mx.simexfacmed.Ui.PonenteRecycler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String PERSON_PREFERENCE_KEY = "MisPreferencias";
    private static final String PONENTE_PREFERENCE_KEY = "MisPreferenciasPonentes";

    private Programas programa;
    private Programas programaPreferences = new Programas();
    private Programas programaRetrofit;
    private SimexPonentes ponentesRetrofit;
    private SimexPonentes ponentesPreferences = new SimexPonentes();
    private ArrayList<Dia_3005> todoEventos = new ArrayList<>();
    private ArrayList<Ponente> arrayPonentes = new ArrayList<>();
    private PostApiService postApiService;
    private PostApiService postApiService2;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        loadJSON();
    }

    public void goNosotros(View view) {
        Intent intent = new Intent(this, NosotrosActivity.class);
        startActivity(intent);
    }

    public void goMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void goPress(View view) {

        if(!todoEventos.isEmpty()){
            Intent intent = new Intent(MainActivity.this, ProgramasActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("objPrograma", programa);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public void goCreditos(View view) {
        Intent intent = new Intent(this, CreditosActivity.class);
        startActivity(intent);
    }

    public void goExpositores(View view) {
        Intent intent = new Intent(this, ExpositoresActivity.class);
        startActivity(intent);
    }

    public void goPonentes(View view) {

        if(arrayPonentes!=null && !arrayPonentes.isEmpty()){
            Intent intent = new Intent(this, PonenteRecycler.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("arrayPonentes", arrayPonentes);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    public void goEmpty(View view) {
        Intent intent = new Intent(this, EmptyActivity.class);
        startActivity(intent);
    }

    public void goBusqueda(View view) {

        if(!todoEventos.isEmpty()){
            Intent intent = new Intent(MainActivity.this, BusquedaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("arrayEventos", todoEventos);
                intent.putExtras(bundle);
                startActivity(intent);
        }

    }


    private void loadJSON(){
        postApiService = ApiService.createApiService();
        Call<Programas> responsePost = postApiService.getPrograma();

        readSharedPreferences();

        responsePost.enqueue(new Callback<Programas>() {
            @Override
            public void onResponse(Call<Programas> call, Response<Programas> response) {
                programaRetrofit = response.body();

                String json1 = new Gson().toJson(programaPreferences);
                String json2 = new Gson().toJson(programaRetrofit);

                /////////////////////////////////////////////////////////////////////////////////////////////////////////////
                /** VALIDAMOS LOS OBJETOS Y ACTUALIZAMOS PREFERENCES  **/
                if(json2.equals(json1)){
                    todoEventos.addAll(programaPreferences.getDayOne());
                    todoEventos.addAll(programaPreferences.getDayTwo());
                    todoEventos.addAll(programaPreferences.getDayThree());
                    //Log.d("objIGUALES","RETROFIT Y PREFERENCES: objetos son iguales");
                    programa=programaPreferences;
                    //Toast.makeText(MainActivity.this, "OnResponse usando sharedPreferences", Toast.LENGTH_SHORT).show();
                }else{
                    todoEventos.addAll(programaRetrofit.getDayOne());
                    todoEventos.addAll(programaRetrofit.getDayTwo());
                    todoEventos.addAll(programaRetrofit.getDayThree());
                    createSharedPreferences(programaRetrofit);
                    //Toast.makeText(MainActivity.this, "usando retrofit", Toast.LENGTH_SHORT).show();
                }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////

                /*setContentView(R.layout.activity_main);

                toolbar = (Toolbar) findViewById(R.id.appbar_main);
                setSupportActionBar(toolbar);*/

                loadJsonPonentes();

            }

            @Override
            public void onFailure(Call<Programas> call, Throwable t) {

                if( programaPreferences!=null && !programaPreferences.equals("")) {
                    todoEventos.addAll(programaPreferences.getDayOne());
                    todoEventos.addAll(programaPreferences.getDayTwo());
                    todoEventos.addAll(programaPreferences.getDayThree());
                    //Log.d("objIGUALES", "RETROFIT Y PREFERENCES: objetos son iguales");
                    Toast.makeText(MainActivity.this, "usando sharedPreferences", Toast.LENGTH_SHORT).show();
                    programa = programaPreferences;
                }

                /*setContentView(R.layout.activity_main);

                toolbar = (Toolbar) findViewById(R.id.appbar_main);
                setSupportActionBar(toolbar);*/

                loadJsonPonentes();

            }
        });
    }

    private void loadJsonPonentes(){
        postApiService2 = ApiService.createApiService();
        Call<SimexPonentes> responsePost = postApiService2.getPonentes();

        readSharedPreferencesPonentes();

        responsePost.enqueue(new Callback<SimexPonentes>() {
            @Override
            public void onResponse(Call<SimexPonentes> call, Response<SimexPonentes> response) {
                ponentesRetrofit = response.body();

                String jsonPreferences = new Gson().toJson(ponentesPreferences);
                String jsonRetrofit = new Gson().toJson(ponentesRetrofit);

                if(jsonRetrofit.equals(jsonPreferences)){
                    arrayPonentes.addAll(ponentesPreferences.getPonentes());
                }else{
                    arrayPonentes.addAll(ponentesRetrofit.getPonentes());
                    createSharedPreferencesPonentes(ponentesRetrofit);
                }

                setContentView(R.layout.activity_main);

                toolbar = (Toolbar) findViewById(R.id.appbar_main);
                setSupportActionBar(toolbar);
            }

            @Override
            public void onFailure(Call<SimexPonentes> call, Throwable t) {

                if(ponentesPreferences!=null && !ponentesPreferences.toString().isEmpty()){
                    arrayPonentes.addAll(ponentesPreferences.getPonentes());
                }

                setContentView(R.layout.activity_main);

                toolbar = (Toolbar) findViewById(R.id.appbar_main);
                setSupportActionBar(toolbar);


            }
        });
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    private void createSharedPreferences(Programas programa){
        SharedPreferences settings = getSharedPreferences(PERSON_PREFERENCE_KEY,0);
        SharedPreferences.Editor editor = settings.edit();

        String json = new Gson().toJson(programa);
        editor.putString("jsonPrograma",json);

        editor.commit();
    }

    private void readSharedPreferences(){
        SharedPreferences settings = getSharedPreferences(PERSON_PREFERENCE_KEY,0);
        String json = settings.getString("jsonPrograma","");
        programaPreferences = new Gson().fromJson(json, Programas.class);
    }

    private void createSharedPreferencesPonentes(SimexPonentes simexPonentes){
        SharedPreferences settings = getSharedPreferences(PONENTE_PREFERENCE_KEY,0);
        SharedPreferences.Editor editor = settings.edit();

        String json = new Gson().toJson(simexPonentes);
        editor.putString("jsonPonente",json);

        editor.commit();
    }

    private void readSharedPreferencesPonentes(){
        SharedPreferences settings = getSharedPreferences(PONENTE_PREFERENCE_KEY,0);
        String json = settings.getString("jsonPonente","");
        ponentesPreferences = new Gson().fromJson(json, SimexPonentes.class);
    }
}
