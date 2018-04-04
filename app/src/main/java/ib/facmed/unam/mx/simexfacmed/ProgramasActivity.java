package ib.facmed.unam.mx.simexfacmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ib.facmed.unam.mx.simexfacmed.Ui.ProgramaRecycler;

public class ProgramasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programas);
    }

    public void goPressDetail(View view){
        Intent intent = new Intent(this, ProgramaRecycler.class);
        intent.putExtra("dia", view.getTag().toString() );
        Log.e("werwerwer123", view.getTag().toString());
        startActivity(intent);
    }
}
