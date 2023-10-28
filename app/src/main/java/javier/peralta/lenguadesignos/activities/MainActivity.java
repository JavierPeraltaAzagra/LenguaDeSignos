package javier.peralta.lenguadesignos.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import javier.peralta.lenguadesignos.R;
import javier.peralta.lenguadesignos.adapter.RecyclerDataAdapter;
import javier.peralta.lenguadesignos.clase.Signo;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    RealmResults<Signo> results;
    RecyclerView recyclerView;
    RecyclerDataAdapter recyclerDataAdapter;

    EditText buscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        recyclerView = findViewById(R.id.recycler_view);

//        buscador = findViewById(R.id.buscador);

        if (realm.isEmpty()){
            List<Signo> lista = new ArrayList();
            lista.add(new Signo(R.drawable.alfombra, "Gato con botas", "El gato con botas es un héroe ficticio. Se basa en un gato con gorro, botas y una espada.", "#5CC03C", "#3CC0A0"));
            lista.add(new Signo(R.drawable.armario, "Cíclope", "El cíclope es un ser mitológico con forma humana que mide alrededor de 4 metros y tiene un gran ojo en vez de 2.", "#BCC03C", "#7AC03C"));
            lista.add(new Signo(R.drawable.banera, "Conejo mágico", "El conejo mágico ayudó a Alicia en el País de las Maravillas.", "#C04E3C", "#C0903C"));
            lista.add(new Signo(R.drawable.bano, "Sirena", "La sirena es un ser mitológico que vive en el mar y le canta a los marineros.", "#156395", "#152395"));
            lista.add(new Signo(R.drawable.cacerola, "Genio", "El genio es un ser mágico que concede 3 deseos al que frote su lámpara.", "#C03C7A", "#C0403C"));
            lista.add(new Signo(R.drawable.cama, "Unicornio", "El unicornio es un ser mágico con forma de caballo con un cuerno en la frente.", "#D25E84", "#D2725E"));
            lista.add(new Signo(R.drawable.casa, "Fénix", "El fénix es un ser mágico con forma de pájaro de fuego que revive cuando muere.", "#4D8D7E", "#4D7C8D"));
            lista.add(new Signo(R.drawable.cepillo, "Caldero", "El caldero es un utensilio que usan las brujas para preparar sus pociones.", "#98E274", "#74E287"));
            lista.add(new Signo(R.drawable.champu, "Excálibur", "La excalibur es una espada legendaria que solo una persona digna puede sacarla de la piedra en la que está atascada.", "#D9BB4C", "#B1D94C"));
            lista.add(new Signo(R.drawable.cocina, "Varita mágica", "La varita mágica es un utensilio que usan los magos para realizar hechizos mágicos.", "#743EC5", "#B73EC5"));
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(lista);
            realm.commitTransaction();
        }

        results = realm.where(Signo.class).findAll();

        recyclerDataAdapter = new RecyclerDataAdapter(results, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String titulo, int imagen, String descripcion, String bgTitulo, String bgDescripcion, int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("titulo", titulo);
                intent.putExtra("imagen", imagen);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("bgTitulo", bgTitulo);
                intent.putExtra("bgDescripcion", bgDescripcion);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerDataAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        // BUSCADOR

//        buscador.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                List list = new ArrayList();
//
//                list = realm.where(Item.class).findAll();
//                results = null;
//                for (Object o:list) {
//                    Item item = (Item) o;
//                    if (item.getTitulo().startsWith(buscador.getText().toString())){
//                        results += item;
//                    }
//                }
//            }
//        });
    }
}