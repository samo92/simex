package ib.facmed.unam.mx.simexfacmed.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Adapters.PonenteAdapterRecyclerView;
import ib.facmed.unam.mx.simexfacmed.Models.Ponente;
import ib.facmed.unam.mx.simexfacmed.R;

public class PonenteRecycler extends AppCompatActivity {

    PonenteAdapterRecyclerView ponenteAdaptador;
    ArrayList<Ponente> arrayPonente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponenterecycler);

        arrayPonente.add(new Ponente("DIEGO ANDRES DÍAZ GUÍO","VITAL CARE Centro de Simulación Clínica-Colombia",0));


        initViews();


    }

    private void initViews() {

        //Instanciamos nuestro RecyclerView
        RecyclerView programaRecycler = (RecyclerView) findViewById(R.id.programaRecycler);

        //Creamos un MANAGER para nuestro recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()); //contexto
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Asociamos nuestro RecyclerView
        programaRecycler.setLayoutManager(linearLayoutManager);

        //Instanciamos nuestro adaptador
        ponenteAdaptador =
                new PonenteAdapterRecyclerView(arrayPonente, R.layout.cardview_pressdetail, this);
        programaRecycler.setAdapter(ponenteAdaptador);



    }
}
