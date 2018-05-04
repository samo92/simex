package ib.facmed.unam.mx.simexfacmed.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.CalendarContract;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import java.util.ArrayList;

import ib.facmed.unam.mx.simexfacmed.Models.Dia_3005;
import ib.facmed.unam.mx.simexfacmed.Models.Ponente;
import ib.facmed.unam.mx.simexfacmed.Models.Programas;
import ib.facmed.unam.mx.simexfacmed.R;

/**
 * Created by samo92 on 04/04/2018.
 */

public class PonenteAdapterRecyclerView
        extends RecyclerView.Adapter<PonenteAdapterRecyclerView.PonenteViewHolder>{

    private ArrayList<Ponente> ponentesArray;
    private int resource;
    private Activity activity;


    public PonenteAdapterRecyclerView(ArrayList<Ponente> ponentesArray, int resource, Activity activity){
        this.ponentesArray = ponentesArray;
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
        //DrawableRes drawable = ponentesArray.get(position);
        holder.ponenteImg.setImageResource(Integer.parseInt(String.valueOf(ponentesArray.get(position))));

    }

    public class PonenteViewHolder extends RecyclerView.ViewHolder{
        /**
         * Declaramos las variables que contiene nuestro CARDVIEW
         */
        private ImageView ponenteImg;

        public PonenteViewHolder(View itemView) {
            super(itemView);

            //ponenteImg = (ImageView) itemView.findViewById(R.id.img_ponente);

        }
    }

    //METODOS ADICIONALES
    @Override
    public int getItemCount() {
        if(ponentesArray.size() != 0)
            return ponentesArray.size();
        return 0;
    }

    public void updateAdapter (ArrayList<DrawableRes> items){
        ponentesArray.clear();
        //ponentesArray=items;
        notifyDataSetChanged();
    }
}
