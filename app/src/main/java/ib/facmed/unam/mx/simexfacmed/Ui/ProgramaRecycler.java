package ib.facmed.unam.mx.simexfacmed.Ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Adapters.ProgramaAdapterRecyclerView;
import ib.facmed.unam.mx.simexfacmed.Api.ApiService;
import ib.facmed.unam.mx.simexfacmed.Api.PostApiService;
import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.Models.Programas;
import ib.facmed.unam.mx.simexfacmed.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by samo92 on 04/04/2018.
 */

public class ProgramaRecycler extends AppCompatActivity {

    private PostApiService postApiService;

    private ProgramaAdapterRecyclerView programaAdaptador;

    private String idDia;
    private Programas programa;
    private ArrayList<Dia_3005> arrayDia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programarecycler);

        Bundle bundle = getIntent().getExtras();
        programa = (Programas) bundle.getSerializable("objPrograma");

        //programa = (Programas) savedInstanceState.getSerializable("objPrograma");
        idDia = getIntent().getExtras().getString("dia");
        Log.e("RESPUESTA: ", idDia);

        initViews();
    }

    private void initViews() {

        switch (idDia) {
            case "3005":
                arrayDia=programa.getDayOne();
                break;
            case "3105":
                arrayDia=programa.getDayTwo();
                break;
            case "0106":
                arrayDia=programa.getDayThree();
                break;
        }

        //Instanciamos nuestro RecyclerView
        RecyclerView programaRecycler = (RecyclerView) findViewById(R.id.programaRecycler);

        //Creamos un MANAGER para nuestro recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()); //contexto
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Asociamos nuestro RecyclerView
        programaRecycler.setLayoutManager(linearLayoutManager);

        //Instanciamos nuestro adaptador
        programaAdaptador =
                new ProgramaAdapterRecyclerView(arrayDia, R.layout.cardview_pressdetail, this);
        programaRecycler.setAdapter(programaAdaptador);



    }

    /*private void loadJSON(){
        postApiService = ApiService.createApiService();
        Call<Programas> responsePost = postApiService.getPrograma();

        responsePost.enqueue(new Callback<Programas>() {
            @Override
            public void onResponse(Call<Programas> call, Response<Programas> response) {
                Programas programa = response.body();
                Log.e("idDia",programa.getDayOne().get(1).getActividad());
                switch (idDia) {
                    case "3005":
                        programaAdaptador.updateAdapter(programa.getDayOne());
                        break;
                    case "3105":
                        programaAdaptador.updateAdapter(programa.getDayTwo());
                        break;
                    case "0106":
                        programaAdaptador.updateAdapter(programa.getDayThree());
                        break;
                }
            }

            @Override
            public void onFailure(Call<Programas> call, Throwable t) {

            }
        });
    }*/
}
