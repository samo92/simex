package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class SeleccionaMapasActivity extends AppCompatActivity {

    Button btn_palacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona_mapas);

        btn_palacio = (Button) findViewById(R.id.btn_mapa_palacio);
        btn_palacio.setText(getText(R.string.button_palacio_sede));
        //btn_palacio.setTextSize(Html.fromHt);

        //android:text="palacio de la escuela de m...\nrepublica de brasil no. 33, esquina..."
    }

    public void goShowMaps(View view) {
        Intent intent = new Intent(this,MapSedeActivity.class);
        startActivity(intent);
    }
}
