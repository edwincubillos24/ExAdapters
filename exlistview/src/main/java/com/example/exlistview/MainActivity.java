package com.example.exlistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Lista_Entrada[] datos =
            new Lista_Entrada[] {
                new Lista_Entrada(R.drawable.supermanlogo, "Superman", "Clark Kent", "1938"),
                new Lista_Entrada(R.drawable.flashlogo, "Flash", "Barry Alen", "1940"),
                new Lista_Entrada(R.drawable.mujermaravillalogo, "Mujer Maravilla", "Diana", "1941"),
                new Lista_Entrada(R.drawable.acuamanlogo, "Acuaman", "Arthur Curry", "1941")};

    private ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Adapter adaptador = new Adapter(this, datos);

    lst = (ListView) findViewById(R.id.Lst);

    lst.setAdapter(adaptador);

     lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String opcionSeleccionada = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();

             Toast.makeText(MainActivity.this, opcionSeleccionada, Toast.LENGTH_SHORT).show();
         }
     });

    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{
        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.listitem, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem, null);

            TextView nombre = (TextView) item.findViewById(R.id.tnombre);
            nombre.setText(datos[position].getNombre());

            TextView nombrePila = (TextView) item.findViewById(R.id.tnomPila);
            nombrePila.setText(datos[position].getNombrePila());

            TextView year = (TextView) item.findViewById(R.id.tyear);
            year.setText(datos[position].getFecha());

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return (item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
