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
public class ListaAdapterProvasAgendadas extends ArrayAdapter<ProvasAgendadas> {

    private Context context;
    private ArrayList<ProvasAgendadas> lista;
    public ListaAdapterProvasAgendadas(Context context, ArrayList<ProvasAgendadas> lista) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProvasAgendadas itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.provas_agendadas, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewProvasAgendadas);
        textView.setText(itemPosicao.getNome());

        return convertView;
    }

}
