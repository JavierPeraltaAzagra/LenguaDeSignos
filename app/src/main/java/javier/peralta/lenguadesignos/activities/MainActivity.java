package javier.peralta.lenguadesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import javier.peralta.lenguadesignos.R;
import javier.peralta.lenguadesignos.adapter.RecyclerDataAdapter;
import javier.peralta.lenguadesignos.clase.Signo;
import javier.peralta.lenguadesignos.lista.ListaPalabras;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    RealmResults<Signo> results;
    List finalList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerDataAdapter recyclerDataAdapter;

    EditText buscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            setTheme(R.style.SplashSignos);
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_LenguaDeSignos);

        realm = Realm.getDefaultInstance();

        recyclerView = findViewById(R.id.recycler_view);

        buscador = findViewById(R.id.buscador);

        if (realm.isEmpty()) {
            List<Signo> lista = ListaPalabras.getList();
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(lista);
            realm.commitTransaction();
        }
        results = realm.where(Signo.class).findAll();

        recyclerDataAdapter = new RecyclerDataAdapter(results, new RecyclerDataAdapter.OnItemClickListener() {

            @Override
            public void onItemClick (String titulo,int imagen,int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("titulo", titulo);
                intent.putExtra("imagen", imagen);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        // BUSCADOR

        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                List list = new ArrayList();
                list = realm.where(Signo.class).findAll();
                finalList.clear();
                for (Object o:list) {
                    Signo item = (Signo) o;
                    if(item.getTitulo().toUpperCase().startsWith(buscador.getText().toString().toUpperCase())){
                        finalList.add(item);
                    }
                }
                recyclerDataAdapter = new RecyclerDataAdapter(finalList, new RecyclerDataAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(String titulo, int imagen, int position) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("titulo", titulo);
                        intent.putExtra("imagen", imagen);
                        startActivity(intent);
                    }
                });
                recyclerView.setAdapter(recyclerDataAdapter);
            }
        });
    }
}