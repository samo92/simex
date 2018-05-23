package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeleccionaMapasActivity extends AppCompatActivity {

    TextView btn_palacio;
    TextView btn_posgrado;
    TextView btn_medicina;
    TextView btn_inr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_mapas);

        btn_palacio = (TextView) findViewById(R.id.btn_mapa_palacio);
        btn_palacio.setText(R.string.button_palacio_sede);

        btn_posgrado = (TextView) findViewById(R.id.btn_mapa_posgrado);
        btn_posgrado.setText(getText(R.string.button_palacio_posgrado));

        btn_medicina = (TextView) findViewById(R.id.btn_mapa_facmed);
        btn_medicina.setText(getText(R.string.button_palacio_medicina));

        btn_inr = (TextView) findViewById(R.id.btn_mapa_inr);
        btn_inr.setText(getText(R.string.button_palacio_inr));
    }

    public void goShowMaps(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this,MapsActivity.class);
        bundle.putString("sede", view.getTag().toString() );
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
