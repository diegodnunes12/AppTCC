package com.example.diego.univas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 16/08/2015.
 */
public class ListaAdapterFaltas extends ArrayAdapter<Faltas> {

    private Context context;
    private ArrayList<Faltas> lista;
    public ListaAdapterFaltas(Context context, ArrayList<Faltas> lista) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Faltas itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.faltas, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewFaltas);
        textView.setText(itemPosicao.getNome());

        return convertView;

    }

}
