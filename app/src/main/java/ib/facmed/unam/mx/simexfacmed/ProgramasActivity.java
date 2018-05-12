package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.Ui.ProgramaRecycler;

public class ProgramasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programas);
    }

    public void goPressDetail(View view){
        Bundle bundle = getIntent().getExtras();
        Intent intent = new Intent(this, ProgramaRecycler.class);
        bundle.putString("dia", view.getTag().toString() );
        intent.putExtras(bundle);
        Log.e("werwerwer123", view.getTag().toString());
        startActivity(intent);
    }
}
