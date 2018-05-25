package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;

public class DetalleEventosActivity extends AppCompatActivity {

    TextView fecha,horaInicio,horaFin,nombreEvento,ponente1,notaEvento;
    private Dia_3005 detalleEvento;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_eventos);

        Bundle bundle = getIntent().getExtras();
        detalleEvento = (Dia_3005) bundle.getSerializable("objEvento");

        loadUI();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleEventosActivity.this, SeleccionaMapasActivity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadUI(){
        fecha = (TextView) findViewById(R.id.tv_evento_fecha);
        horaInicio = (TextView) findViewById(R.id.tv_evento_hora_inicio);
        horaFin = (TextView) findViewById(R.id.tv_evento_hora_fin);
        nombreEvento = (TextView) findViewById(R.id.tv_evento_nombre);
        ponente1 = (TextView) findViewById(R.id.tv_evento_ponente1);
        notaEvento = (TextView) findViewById(R.id.tv_evento_nota);

        fecha.setText(detalleEvento.getFechaCompleta());
        horaInicio.setText(detalleEvento.getSoloHoraInicio());
        horaFin.setText(detalleEvento.getSoloHoraFin());
        nombreEvento.setText(detalleEvento.getActividad());
        if(!detalleEvento.getNota().isEmpty()) {
            String notaTexto = "Nota: "+detalleEvento.getNota();
            notaEvento.setText(notaTexto);
        }

        /* Creamos string del formato Html para llenar los textview "ponentes" */

        String PonenteSede1 = "<font size='15' color='#0C1C60'>" + detalleEvento.getPonente() +"</font>"
                + "<font size='15' color='#0C1C60'>" + " | " +"</font>"
                + "<font size='15' color='#00C3FF'>" + detalleEvento.getSede() +"</font>" ;

        String PonenteSede2 = "<font size='15' color='#0C1C60'>" + detalleEvento.getPonente2() +"</font>"
                + "<font size='15' color='#0C1C60'>" + " | " +"</font>"
                + "<font size='15' color='#00C3FF'>" + detalleEvento.getSede2() +"</font>" ;

        String PonenteSede3 = "<font size='15' color='#0C1C60'>" + detalleEvento.getPonente3() +"</font>"
                + "<font size='15' color='#0C1C60'>" + " | " +"</font>"
                + "<font size='15' color='#00C3FF'>" + detalleEvento.getSede3() +"</font>" ;

        String PonenteSede4 = "<font size='15' color='#0C1C60'>" + detalleEvento.getPonente4() +"</font>"
                + "<font size='15' color='#0C1C60'>" + " | " +"</font>"
                + "<font size='15' color='#00C3FF'>" + detalleEvento.getSede4() +"</font>" ;

        String LugarEvento = "<font size='15'>Lugar: "+detalleEvento.getLugar()+"</font>";

        String giantCad;


        if(detalleEvento.getSede()==null || detalleEvento.getSede().isEmpty()){

        }else if(detalleEvento.getSede2()==null || detalleEvento.getSede2().isEmpty()){
            giantCad = PonenteSede1+"<p><br>"+LugarEvento+"</p>";
            ponente1.setText(Html.fromHtml(giantCad, Html.FROM_HTML_MODE_COMPACT));

        }else if(detalleEvento.getSede3()==null || detalleEvento.getSede3().isEmpty()){
            giantCad = PonenteSede1+"<p><br>"+PonenteSede2
                    +"</p><br><p>"+LugarEvento+"</p>";
            ponente1.setText(Html.fromHtml(giantCad, Html.FROM_HTML_MODE_COMPACT));

        }else if(detalleEvento.getSede4()==null || detalleEvento.getSede4().isEmpty()){
            giantCad = PonenteSede1+"<p><br>"+PonenteSede2
                    +"</p><br><p>"+PonenteSede3+"</p><br><p>"+LugarEvento+"</p>";
            ponente1.setText(Html.fromHtml(giantCad, Html.FROM_HTML_MODE_COMPACT));
        }else{
            giantCad = PonenteSede1+"<p><br>"+PonenteSede2
                    +"</p><br><p>"+PonenteSede3+"</p><br><p>"+PonenteSede4+"</p><br><p>"
                    +LugarEvento+"</p>";
            ponente1.setText(Html.fromHtml(giantCad, Html.FROM_HTML_MODE_COMPACT));
        }
    }

}
