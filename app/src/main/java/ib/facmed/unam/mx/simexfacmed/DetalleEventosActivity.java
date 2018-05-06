package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetalleEventosActivity extends AppCompatActivity {

    TextView fecha,hora,nombreEvento,ponente1,ponente2,ponente3,ponente4,sede1,sede2,sede3,sede4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_eventos);

        fecha = (TextView) findViewById(R.id.tv_evento_fecha);
        hora = (TextView) findViewById(R.id.tv_evento_hora);
        nombreEvento = (TextView) findViewById(R.id.tv_evento_nombre);
        ponente1 = (TextView) findViewById(R.id.tv_evento_ponente1);
        ponente2 = (TextView) findViewById(R.id.tv_evento_ponente2);
        ponente3 = (TextView) findViewById(R.id.tv_evento_ponente3);
        ponente4 = (TextView) findViewById(R.id.tv_evento_ponente4);
        sede1 = (TextView) findViewById(R.id.tv_evento_institucion1);
        sede2 = (TextView) findViewById(R.id.tv_evento_institucion2);
        sede3 = (TextView) findViewById(R.id.tv_evento_institucion3);
        sede4 = (TextView) findViewById(R.id.tv_evento_institucion4);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleEventosActivity.this, SeleccionaMapasActivity.class);
                startActivity(intent);
            }
        });
    }

}
