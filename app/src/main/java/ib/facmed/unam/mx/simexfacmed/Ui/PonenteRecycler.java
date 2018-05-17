package ib.facmed.unam.mx.simexfacmed.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Adapters.PonentesAdapterRecyclerView;
import ib.facmed.unam.mx.simexfacmed.Models.Ponente;
import ib.facmed.unam.mx.simexfacmed.R;

public class PonenteRecycler extends AppCompatActivity {

    PonentesAdapterRecyclerView ponenteAdaptador;

    private ArrayList<Ponente> arrayPonentes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponenterecycler);

        Bundle bundle = getIntent().getExtras();

        arrayPonentes = (ArrayList<Ponente>) bundle.getSerializable("arrayPonentes");

        initViews();


    }

    private void initViews() {

        //Instanciamos nuestro RecyclerView
        RecyclerView ponenteRecycler = (RecyclerView) findViewById(R.id.recycler_ponentes);

        //Creamos un MANAGER para nuestro recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()); //contexto
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Asociamos nuestro RecyclerView
        ponenteRecycler.setLayoutManager(linearLayoutManager);

        //Instanciamos nuestro adaptador
        ponenteAdaptador =
                new PonentesAdapterRecyclerView(arrayPonentes, R.layout.cardview_ponentes, this);
        ponenteRecycler.setAdapter(ponenteAdaptador);


    }
}
