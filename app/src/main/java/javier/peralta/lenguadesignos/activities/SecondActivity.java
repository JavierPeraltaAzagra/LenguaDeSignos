package javier.peralta.lenguadesignos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import javier.peralta.lenguadesignos.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();

        TextView titulo = findViewById(R.id.titulo);
        TextView desc = findViewById(R.id.desc);
        ImageView imagen = findViewById(R.id.imagenDesc);

        titulo.setText(bundle.getString("titulo"));
        desc.setText(bundle.getString("descripcion"));
        imagen.setImageResource(bundle.getInt("imagen"));
        titulo.setBackgroundColor(Color.parseColor(bundle.getString("bgTitulo")));
        imagen.setBackgroundColor(Color.parseColor(bundle.getString("bgTitulo")));
        desc.setBackgroundColor(Color.parseColor(bundle.getString("bgDescripcion")));
    }
}