package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Api.ApiService;
import ib.facmed.unam.mx.simexfacmed.Api.PostApiService;
import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.Models.Programas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Dia_3005> todoEventos = new ArrayList<>();
    private PostApiService postApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void goPress(View view) {
        Intent intent = new Intent(this, ProgramasActivity.class);
        startActivity(intent);
    }

    public void goCreditos(View view) {
        Intent intent = new Intent(this, CreditosActivity.class);
        startActivity(intent);
    }

    public void goBusqueda(View view) {

        loadJSON();

    }


    private void loadJSON(){
        postApiService = ApiService.createApiService();
        Call<Programas> responsePost = postApiService.getPrograma();

        responsePost.enqueue(new Callback<Programas>() {
            @Override
            public void onResponse(Call<Programas> call, Response<Programas> response) {
                Programas programa = response.body();
                todoEventos.addAll(programa.getDayOne());
                todoEventos.addAll(programa.getDayTwo());
                todoEventos.addAll(programa.getDayThree());
                Log.e("idDia",programa.getDayOne().get(1).getActividad());

                Intent intent = new Intent(MainActivity.this, BusquedaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("arrayEventos", todoEventos);
                intent.putExtras(bundle);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Programas> call, Throwable t) {

            }
        });
    }
}
