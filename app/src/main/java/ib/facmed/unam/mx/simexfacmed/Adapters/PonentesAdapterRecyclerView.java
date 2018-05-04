package ib.facmed.unam.mx.simexfacmed.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Models.Ponente;
import ib.facmed.unam.mx.simexfacmed.R;

/**
 * Created by samo92 on 04/04/2018.
 */

public class PonentesAdapterRecyclerView
        extends RecyclerView.Adapter<PonentesAdapterRecyclerView.PonenteViewHolder>{

    private ArrayList<Ponente> ponenteArray;
    private int resource;
    private Activity activity;


    public PonentesAdapterRecyclerView(ArrayList<Ponente> ponenteArray, int resource, Activity activity){
        this.ponenteArray = ponenteArray;
        this.resource=resource;
        this.activity=activity;
    }

    @Override
    public PonenteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PonenteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PonenteViewHolder holder, int position) {
        Ponente ponente = ponenteArray.get(position);
        holder.ponenteImg.setImageResource(ponente.getImagenPonente());
        holder.nombre.setText(ponente.getNombre());
        holder.institucion.setText(ponente.getInstitucion());

    }

    public class PonenteViewHolder extends RecyclerView.ViewHolder{
        /**
         * Declaramos las variables que contiene nuestro CARDVIEW
         */
        private ImageView ponenteImg;
        private TextView nombre;
        private TextView institucion;

        public PonenteViewHolder(View itemView) {
            super(itemView);

            ponenteImg = itemView.findViewById(R.id.imageView_ponente);
            nombre = (TextView) itemView.findViewById(R.id.textView_ponente_nombre);
            institucion = (TextView) itemView.findViewById(R.id.textView_ponente_institucion);
        }
    }
    @Override
    public int getItemCount() {
        if(ponenteArray.size() != 0)
            return ponenteArray.size();
        return 0;
    }
}
