package com.example.diego.univas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class ListaProvasAgendadasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_provas_agendadas);
        ArrayList<ProvasAgendadas> lista = new ArrayList<ProvasAgendadas>();
        ProvasAgendadas a = new ProvasAgendadas("Engenharia de Software");
        ProvasAgendadas b = new ProvasAgendadas("Java");
        ProvasAgendadas c = new ProvasAgendadas("TCC");
        ProvasAgendadas d = new ProvasAgendadas("Redes");
        ProvasAgendadas e = new ProvasAgendadas("Sistemas Operacionais");

        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        lista.add(e);

        ListaAdapterProvasAgendadas listaAdapterItem = new ListaAdapterProvasAgendadas(this, lista);

        ListView listView = (ListView) findViewById(R.id.listViewProvasAgendadas);

        listView.setAdapter(listaAdapterItem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_provas_agendadas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
