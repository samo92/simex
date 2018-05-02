package ib.facmed.unam.mx.simexfacmed;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckedTextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Adapters.ProgramaAdapterRecyclerView;
import ib.facmed.unam.mx.simexfacmed.Api.ApiService;
import ib.facmed.unam.mx.simexfacmed.Api.PostApiService;
import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.Models.Programas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusquedaActivity extends AppCompatActivity {

    CheckedTextView checkTema;
    CheckedTextView checkExpositor;

    MaterialSearchView searchView;

    private PostApiService postApiService;

    RecyclerView programaRecycler;
    private ProgramaAdapterRecyclerView programaAdaptador;

    private String idDia;

    private ArrayList<Dia_3005> todoEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        Bundle bundle = getIntent().getExtras();
        todoEventos = (ArrayList<Dia_3005>) bundle.getSerializable("arrayEventos");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Busca algun evento...");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        searchView = (MaterialSearchView) findViewById(R.id.search_view);

        initViews();


        checkTema = (CheckedTextView) findViewById(R.id.checkTema);
        checkTema.setChecked(true);
        checkExpositor = (CheckedTextView) findViewById(R.id.checkExpositor);

        checkTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkTema.isChecked()) {
                    checkTema.setChecked(false);
                    checkExpositor.setChecked(true);
                }
                else {
                    checkTema.setChecked(true);
                    checkExpositor.setChecked(false);
                }
            }
        });

        checkExpositor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkExpositor.isChecked()){
                    checkTema.setChecked(true);
                    checkExpositor.setChecked(false);
                }
                else {
                    checkExpositor.setChecked(true);
                    checkTema.setChecked(false);
                }
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

                //If closed Search View, recycler will return default
                programaAdaptador =
                        new ProgramaAdapterRecyclerView(todoEventos, R.layout.cardview_pressdetail, BusquedaActivity.this);
                programaRecycler.setAdapter(programaAdaptador);

            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if(newText != null && !newText.isEmpty()){
                    ArrayList<Dia_3005> arrayFound = new ArrayList<>();
                    if(checkTema.isChecked()){
                        for(int i=0; i<todoEventos.size(); i++){
                            if(todoEventos.get(i).getActividad().toLowerCase().contains(newText))
                                arrayFound.add(todoEventos.get(i));
                        }
                        programaAdaptador =
                                new ProgramaAdapterRecyclerView(arrayFound, R.layout.cardview_pressdetail, BusquedaActivity.this);
                        programaRecycler.setAdapter(programaAdaptador);
                    }else{
                        for(int i=0; i<todoEventos.size(); i++){
                            if(todoEventos.get(i).getPonente().toLowerCase().contains(newText))
                                arrayFound.add(todoEventos.get(i));
                        }
                        programaAdaptador =
                                new ProgramaAdapterRecyclerView(arrayFound, R.layout.cardview_pressdetail, BusquedaActivity.this);
                        programaRecycler.setAdapter(programaAdaptador);
                    }

                }else{
                    programaAdaptador =
                            new ProgramaAdapterRecyclerView(todoEventos, R.layout.cardview_pressdetail, BusquedaActivity.this);
                    programaRecycler.setAdapter(programaAdaptador);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

    private void initViews() {

        //Instanciamos nuestro RecyclerView
        programaRecycler = (RecyclerView) findViewById(R.id.buscandoRecycler);

        //Creamos un MANAGER para nuestro recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()); //contexto
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Asociamos nuestro RecyclerView
        programaRecycler.setLayoutManager(linearLayoutManager);

        //Instanciamos nuestro adaptador
        programaAdaptador =
                new ProgramaAdapterRecyclerView(todoEventos, R.layout.cardview_pressdetail, this);
        programaRecycler.setAdapter(programaAdaptador);

    }
}
