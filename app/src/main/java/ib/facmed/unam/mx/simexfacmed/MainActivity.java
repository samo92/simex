package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
        Intent intent = new Intent(this, BusquedaActivity.class);
        startActivity(intent);
    }
}
