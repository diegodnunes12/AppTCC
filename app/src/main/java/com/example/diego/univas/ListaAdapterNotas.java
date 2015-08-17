package com.example.diego.univas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 23/07/2015.
 */
public class ListaAdapterNotas extends ArrayAdapter<Notas> {

    private Context context;
    private ArrayList<Notas> lista;
    public ListaAdapterNotas(Context context, ArrayList<Notas> lista) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Notas itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.notas, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewNotas);
        textView.setText(itemPosicao.getNome());

        return convertView;
    }
}
