package ib.facmed.unam.mx.simexfacmed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

public class BusquedaActivity extends AppCompatActivity {

    CheckedTextView checkTema;
    CheckedTextView checkExpositor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        checkTema = (CheckedTextView) findViewById(R.id.checkTema);
        checkExpositor = (CheckedTextView) findViewById(R.id.checkExpositor);

        checkTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkTema.isChecked())
                    checkTema.setChecked(false);
                else
                    checkTema.setChecked(true);
            }
        });

        checkExpositor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkExpositor.isChecked())
                    checkExpositor.setChecked(false);
                else
                    checkExpositor.setChecked(true);
            }
        });
    }
}
