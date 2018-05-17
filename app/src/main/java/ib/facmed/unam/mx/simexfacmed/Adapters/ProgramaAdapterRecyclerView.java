package ib.facmed.unam.mx.simexfacmed.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.DetalleEventosActivity;
import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.R;

/**
 * Created by samo92 on 04/04/2018.
 */

public class ProgramaAdapterRecyclerView
        extends RecyclerView.Adapter<ProgramaAdapterRecyclerView.ProgramaViewHolder> {

    private ArrayList<Dia_3005> programasArray;
    private int resource;
    private Activity activity;


    public ProgramaAdapterRecyclerView(ArrayList<Dia_3005> programasArray, int resource, Activity activity){
        this.programasArray = programasArray;
        this.resource=resource;
        this.activity=activity;
    }

    @Override
    public ProgramaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ProgramaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramaViewHolder holder, int position) {
        Dia_3005 dia = programasArray.get(position);
        holder.horaInicio.setText(dia.getSoloHoraInicio());
        holder.horaFin.setText(dia.getSoloHoraFin());
        holder.registro.setText(dia.getActividad());
        holder.ponente.setText(dia.getPonente());
        holder.institucion.setText(dia.getSede());

    }

    @Override
    public int getItemCount() {
        if(programasArray.size() != 0)
            return programasArray.size();
        return 0;
    }

    public void updateAdapter (ArrayList<Dia_3005> items){
        programasArray.clear();
        programasArray=items;
        notifyDataSetChanged();
    }


    public class ProgramaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        /**
         * Declaramos las variables que contiene nuestro CARDVIEW
         */
        private TextView horaInicio;
        private TextView horaFin;
        private TextView registro;
        private TextView ponente;
        private TextView institucion;

        public ProgramaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            horaInicio = (TextView) itemView.findViewById(R.id.textView_horaInicio);
            horaFin = (TextView) itemView.findViewById(R.id.textView_horaFin);
            registro = (TextView) itemView.findViewById(R.id.textView_registro);
            ponente = (TextView) itemView.findViewById(R.id.textView_ponente);
            institucion = (TextView) itemView.findViewById(R.id.textView_institucion);

        }


        @Override
        public void onClick(View view) {

            AlertDialog.Builder mybuild = new AlertDialog.Builder(itemView.getContext());
            mybuild.setMessage("Que deseas hacer: ");
            mybuild.setTitle("SIMEX");

            mybuild.setPositiveButton("Agendar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int witch) {
                    Log.e("mes: ", programasArray.get(getAdapterPosition()).getSoloMesInicio() );
                    Log.e("dia ", programasArray.get(getAdapterPosition()).getSoloDiaInicio() );

                    Calendar cal = Calendar.getInstance();
                    Intent intent = new Intent(Intent.ACTION_EDIT);

                    cal.set(Calendar.YEAR, Integer.parseInt("2018"));                 //
                    cal.set(Calendar.MONTH, Integer.parseInt( programasArray.get(getAdapterPosition()).getSoloMesInicio() ));   // Set de AÑO MES y Dia
                    cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt( programasArray.get(getAdapterPosition()).getSoloDiaInicio() ));       //


                    cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(String.valueOf(horaInicio.getText()).substring(0,2)));   // Set de HORA y MINUTO
                    cal.set(Calendar.MINUTE, Integer.parseInt(String.valueOf(horaInicio.getText()).substring(3,5)) );            //

                    intent.setType("vnd.android.cursor.item/event");

                    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
                    intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis() + 60 * 60 * 500);

                    //intent.putExtra(CalendarContract.Events.ALL_DAY, duracion.isSelected());
                    intent.putExtra(CalendarContract.Events.TITLE, registro.getText().toString());
                    //intent.putExtra(CalendarContract.Events.DESCRIPTION, registro.getText().toString());
                    //intent.putExtra(CalendarContract.Events.EVENT_LOCATION, localizacion.getText().toString());

                    activity.startActivity(intent);
                }
            });

            mybuild.setNegativeButton("Detalle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int witch) {

                        Intent intent = new Intent(itemView.getContext() , DetalleEventosActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("objEvento", programasArray.get(getAdapterPosition()));
                        intent.putExtras(bundle);
                        activity.startActivity(intent);

                }
            });

            AlertDialog dialog = mybuild.create();
            dialog.show();
        }
    }
}
