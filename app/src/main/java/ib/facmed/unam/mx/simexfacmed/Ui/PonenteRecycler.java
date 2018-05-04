package ib.facmed.unam.mx.simexfacmed.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Adapters.PonentesAdapterRecyclerView;
import ib.facmed.unam.mx.simexfacmed.Models.Ponente;
import ib.facmed.unam.mx.simexfacmed.R;

public class PonenteRecycler extends AppCompatActivity {

    PonentesAdapterRecyclerView ponenteAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponenterecycler);

        initViews();


    }

    private void initViews() {

        //Instanciamos nuestro RecyclerView
        RecyclerView ponenteRecycler = (RecyclerView) findViewById(R.id.recycler_ponentes);

        //Creamos un MANAGER para nuestro recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()); //contexto
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Asociamos nuestro RecyclerView
        ponenteRecycler.setLayoutManager(linearLayoutManager);

        //Instanciamos nuestro adaptador
        ponenteAdaptador =
                new PonentesAdapterRecyclerView(llenarArray(), R.layout.cardview_ponentes, this);
        ponenteRecycler.setAdapter(ponenteAdaptador);



    }

    private ArrayList<Ponente> llenarArray(){

        ArrayList<Ponente> arrayPonente = new ArrayList<Ponente>();

        arrayPonente.add(new Ponente("DIEGO ANDRES DÍAZ GUÍO",
                "VITAL CARE Centro de Simulación Clínica-Colombia",
                R.drawable.ponente_diego_guio));
        arrayPonente.add(new Ponente("JESÚS M. DORADOR GONZÁLEZ",
                "Facultad de Ingeniería, UNAM-México",
                R.drawable.ponente_jesus_dorador));
        arrayPonente.add(new Ponente("JUAN A. SÁMANO MALDONADO",
                "Facultad de Odontología, UNAM-México",
                R.drawable.ponente_juan_samano));
        arrayPonente.add(new Ponente("ELENA RÍOS BARRIENTOS",
                "Escuela de Medicina, ITESM-México",
                R.drawable.ponente_elena_rios));
        arrayPonente.add(new Ponente("EDGARD DÍAZ SOTO",
                "Instituto Mexicano del Seguro Social-México",
                R.drawable.ponente_edgar_diaz));
        arrayPonente.add(new Ponente("HECTOR GERARDO AGUIRRE GAS",
                "Petróleos Mexicanos-México",
                R.drawable.ponente_hector_aguirre));
        arrayPonente.add(new Ponente("EDUARDO GARCÍA LUNA MARTÍNEZ",
                "División de Ciencias de la Salud, UDEM-México",
                R.drawable.ponente_eduardo_luna));
        arrayPonente.add(new Ponente("VICTOR BALTAZAR OLIVAR LÓPEZ",
                "Hospital Infantil de México, Federico Gómez-México",
                R.drawable.ponente_victor_baltazar));
        arrayPonente.add(new Ponente("ESTELA MELMAN SZTEYN",
                "Consejo Mexicano de Anestesiología-México",
                R.drawable.ponente_estela_melman));
        arrayPonente.add(new Ponente("LAURA PEÑALOZA OCHOA",
                "Fisioterapia, Facultad de Medicina, UNAM-México",
                R.drawable.ponente_laura_pe_aloza));
        arrayPonente.add(new Ponente("CLAUDIA ERIKA RAMÍREZ ÁVILA",
                "Psiquiatría y Salud Mental, UNAM-México",
                R.drawable.ponente_claudia_erika));
        arrayPonente.add(new Ponente("REBECA HERSHBERGER DEL ARENAL",
                "Facultad de Medicina, UNAM-México",
                R.drawable.ponente_rebeca));
        arrayPonente.add(new Ponente("DIEGO PINEDA MARTÍNEZ",
                "Facultad de Medicina, UNAM-México",
                R.drawable.ponente_diego_pineda));
        arrayPonente.add(new Ponente("MA. DE LOURDES MARROQUÍN YÁÑEZ",
                "Hospital Infantil de México, Federico Gómez-México",
                R.drawable.ponente_lourdes));
        arrayPonente.add(new Ponente("FRANCISCO VALDÉS SALDAÑA",
                "Centro Medico ABC - México",
                R.drawable.ponente_francisco_valdes));
        //
        arrayPonente.add(new Ponente("FEDERICO FERRERA",
                "Universidad Nacional de la plata - Argentina",
                R.drawable.ponente_federico_ferrero));
        arrayPonente.add(new Ponente("CARLOS MARIO GARCÍA ÁLVEZ",
                "División de Ciencias de la Salud, UDEM-México ",
                R.drawable.ponente_carlos_mario));
        arrayPonente.add(new Ponente("OLGA MARINA ROBELO ZARZA",
                "Facultad de Medicina, UNAM-México",
                R.drawable.ponente_olga_marina));
        arrayPonente.add(new Ponente("MOISÉS N. DE LOS SANTOS RODRÍGUEZ",
                "Facultad de Medicina, UADY-México",
                R.drawable.ponente_moises_santos));
        arrayPonente.add(new Ponente("JOSÉ LUIS GARCÍA GALAVIZ",
                "Universidad del Noreste - México",
                R.drawable.ponente_joseluis_garcia));
        arrayPonente.add(new Ponente("ALEXANDER HEINZE RODRÍGUEZ",
                "Universität Heidelberg - Alemania",
                R.drawable.ponente_alexander));

        return arrayPonente;
    }
}
