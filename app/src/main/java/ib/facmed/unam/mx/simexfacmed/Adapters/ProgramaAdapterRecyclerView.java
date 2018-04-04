package ib.facmed.unam.mx.simexfacmed.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.Models.Programas;
import ib.facmed.unam.mx.simexfacmed.R;

/**
 * Created by samo92 on 04/04/2018.
 */

public class ProgramaAdapterRecyclerView
        extends RecyclerView.Adapter<ProgramaAdapterRecyclerView.ProgramaViewHolder>{

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
        holder.horaInicio.setText(dia.getHoraInicio());
        holder.horaFin.setText(dia.getHoraFin());
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


    public class ProgramaViewHolder extends RecyclerView.ViewHolder{
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

            horaInicio = (TextView) itemView.findViewById(R.id.textView_horaInicio);
            horaFin = (TextView) itemView.findViewById(R.id.textView_horaFin);
            registro = (TextView) itemView.findViewById(R.id.textView_registro);
            ponente = (TextView) itemView.findViewById(R.id.textView_ponente);
            institucion = (TextView) itemView.findViewById(R.id.textView_institucion);

        }
    }
}
