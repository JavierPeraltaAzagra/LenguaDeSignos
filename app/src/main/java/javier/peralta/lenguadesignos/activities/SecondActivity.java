package javier.peralta.lenguadesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;
import javier.peralta.lenguadesignos.R;
import javier.peralta.lenguadesignos.adapter.RecyclerDataAdapter;
import javier.peralta.lenguadesignos.clase.Signo;

public class SecondActivity extends AppCompatActivity {

    Realm realm;
    RealmResults<Signo> results;
    RecyclerView recyclerView;
    RecyclerDataAdapter recyclerDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();

        realm = Realm.getDefaultInstance();

        TextView titulo = findViewById(R.id.titulo);
        ImageView imagen = findViewById(R.id.imagenDesc);
        TextView textoCategoria = findViewById(R.id.texto_categoria);
        RecyclerView recyclerView = findViewById(R.id.recycler_categoria);

        String texto_titulo = bundle.getString("titulo");
        String texto_categoria = "Signos de la categoría \"" + bundle.getString("categoria") + "\"";

        titulo.setText(texto_titulo);
        imagen.setImageResource(bundle.getInt("imagen"));
        textoCategoria.setText(texto_categoria);
        results = realm.where(Signo.class).equalTo("categoria", bundle.getString("categoria")).findAll();
        recyclerDataAdapter = new RecyclerDataAdapter(results, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String titulo, int imagen, String categoria, int position) {

            }
        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }
}