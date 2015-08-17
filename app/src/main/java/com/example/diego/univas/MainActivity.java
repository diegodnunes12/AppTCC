package com.example.diego.univas;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, ItemListFragment.Callbacks, AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private boolean mTwoPane;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }


    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {


            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            //Intent detailIntent = new Intent(this, ItemDetailActivity.class);

            // Ao clicar na materia o valor do id abrirá a pagina correspondente
            switch (id) {
                case "1":
                    Intent detailIntent = new Intent(this, ItemDetailActivity.class);
                    detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                    startActivity(detailIntent);
                    break;
                case "2":
                    Intent detailIntent2 = new Intent(this, ItemDetailActivity.class);
                    detailIntent2.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                    startActivity(detailIntent2);
                    break;
                case "3":
                    Intent detailIntent3 = new Intent(this, ItemDetailActivity.class);
                    detailIntent3.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                    startActivity(detailIntent3);
                    break;
                case "4":
                    Intent detailIntent4 = new Intent(this, ItemDetailActivity.class);
                    detailIntent4.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                    startActivity(detailIntent4);
                    break;
                case "5":
                    Intent detailIntent5 = new Intent(this, ItemDetailActivity.class);
                    detailIntent5.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                    startActivity(detailIntent5);
                    break;

            }
        }
    }

    // Metodo para mostrar as opções do Navigation
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();

        // Caso a posição for 0 mostra as notas, 1 as faltas e 2 as provas
        switch (position) {
            case 0:// Home
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ItemListFragment())
                        .commit();
                break;
            case 1:// Notas
                Intent intentListaNotas = new Intent(this, ListaNotasActivity.class);
                startActivity(intentListaNotas);
                break;
            case 2:// Faltas
                Intent intentListaFaltas = new Intent(this, ListaFaltasActivity.class);
                startActivity(intentListaFaltas);
                /*fragmentManager.beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(position + 2))
                        .commit();*/
                break;
            case 3: // Provas Agendadas
                Intent intentListaAgenda = new Intent(this, ListaProvasAgendadasActivity.class);
                startActivity(intentListaAgenda);
                break;
        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;

        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
