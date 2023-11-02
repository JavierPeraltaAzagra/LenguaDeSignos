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

        if (realm.isEmpty()) {
            List<Signo> lista = new ArrayList();
            lista.add(new Signo(R.drawable.alfombra, "Alfombra"));
            lista.add(new Signo(R.drawable.armario, "Armario"));
            lista.add(new Signo(R.drawable.banera, "Bañera"));
            lista.add(new Signo(R.drawable.bano, "Baño"));
            lista.add(new Signo(R.drawable.cacerola, "Cacerola"));
            lista.add(new Signo(R.drawable.cama, "Cama"));
            lista.add(new Signo(R.drawable.casa, "Casa"));
            lista.add(new Signo(R.drawable.cepillo, "Cepillo"));
            lista.add(new Signo(R.drawable.champu, "Champú"));
            lista.add(new Signo(R.drawable.cocina, "Cocina"));
            lista.add(new Signo(R.drawable.colonia, "Colonia"));
            lista.add(new Signo(R.drawable.cristal, "Cristal"));
            lista.add(new Signo(R.drawable.cuchara, "Cuchara"));
            lista.add(new Signo(R.drawable.cuchillo, "Cuchillo"));
            lista.add(new Signo(R.drawable.despertador, "Despertador"));
            lista.add(new Signo(R.drawable.dormitorio, "Dormitorio"));
            lista.add(new Signo(R.drawable.espejo, "Espejo"));
            lista.add(new Signo(R.drawable.esponja, "Esponja"));
            lista.add(new Signo(R.drawable.fax, "Fax"));
            lista.add(new Signo(R.drawable.jabon, "Jabón"));
            lista.add(new Signo(R.drawable.jarra, "Jarra"));
            lista.add(new Signo(R.drawable.lampara, "Lámpara"));
            lista.add(new Signo(R.drawable.lavabo, "Lavabo"));
            lista.add(new Signo(R.drawable.lavadora, "Lavadora"));
            lista.add(new Signo(R.drawable.maceta, "Maceta"));
            lista.add(new Signo(R.drawable.manta, "Manta"));
            lista.add(new Signo(R.drawable.maquina, "Máquina"));
            lista.add(new Signo(R.drawable.mesilla, "Mesilla"));
            lista.add(new Signo(R.drawable.mueble, "Mueble"));
            lista.add(new Signo(R.drawable.muneco, "Muñeco"));
            lista.add(new Signo(R.drawable.nevera, "Nevera"));
            lista.add(new Signo(R.drawable.objeto, "Objeto"));
            lista.add(new Signo(R.drawable.ordenador, "Ordenador"));
            lista.add(new Signo(R.drawable.papel, "Papel"));
            lista.add(new Signo(R.drawable.pasta_de_dientes, "Pasta de dientes"));
            lista.add(new Signo(R.drawable.peine, "Peine"));
            lista.add(new Signo(R.drawable.pelota, "Pelota"));
            lista.add(new Signo(R.drawable.plancha, "Plancha"));
            lista.add(new Signo(R.drawable.plato, "Plato"));
            lista.add(new Signo(R.drawable.puerta, "Puerta"));
            lista.add(new Signo(R.drawable.sabana, "Sábana"));
            lista.add(new Signo(R.drawable.salon, "Salón"));
            lista.add(new Signo(R.drawable.sarten, "Sartén"));
            lista.add(new Signo(R.drawable.servilleta, "Servilleta"));
            lista.add(new Signo(R.drawable.silla, "Silla"));
            lista.add(new Signo(R.drawable.sofa, "Sofá"));
            lista.add(new Signo(R.drawable.telefono, "Teléfono"));
            lista.add(new Signo(R.drawable.televisor, "Televisor"));
            lista.add(new Signo(R.drawable.tenedor, "Tenedor"));
            lista.add(new Signo(R.drawable.toalla, "Toalla"));
            lista.add(new Signo(R.drawable.vaso, "Vaso"));
            lista.add(new Signo(R.drawable.ventana, "Ventana"));


            realm.beginTransaction();
            realm.copyToRealmOrUpdate(lista);
            realm.commitTransaction();
        }

        results = realm.where(Signo.class).findAll();

        recyclerDataAdapter = new RecyclerDataAdapter(results, new RecyclerDataAdapter.OnItemClickListener() {

            @Override
            public void onItemClick (String titulo,int imagen, String descripcion, String
        bgTitulo, String bgDescripcion,int position) {
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