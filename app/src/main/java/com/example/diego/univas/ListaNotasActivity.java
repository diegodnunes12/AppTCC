package com.example.diego.univas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class ListaNotasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);
        ArrayList<Notas> lista = new ArrayList<Notas>();
        Notas a = new Notas("Engenharia de Software");
        Notas b = new Notas("Java");
        Notas c = new Notas("TCC");

        lista.add(a);
        lista.add(b);
        lista.add(c);

        ListaAdapterNotas listaAdapterItem = new ListaAdapterNotas(this, lista);

        ListView listView = (ListView) findViewById(R.id.listViewNotas);

        listView.setAdapter(listaAdapterItem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_notas, menu);
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
