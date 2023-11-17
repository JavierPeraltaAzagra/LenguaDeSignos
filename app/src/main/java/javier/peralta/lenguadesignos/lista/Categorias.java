package javier.peralta.lenguadesignos.lista;

import java.util.ArrayList;
import java.util.List;

import javier.peralta.lenguadesignos.R;
import javier.peralta.lenguadesignos.clase.Categoria;
import javier.peralta.lenguadesignos.clase.Signo;

public class Categorias {

    public static List<Categoria> getList(){
        List<Categoria> lista = new ArrayList<>();

        lista.add(new Categoria(R.drawable.saludos_y_preguntas_categoria, "Saludos y preguntas"));
        lista.add(new Categoria(R.drawable.familia_categoria, "Familia"));
        lista.add(new Categoria(R.drawable.comidas_categoria, "Comidas y bebidas"));
        lista.add(new Categoria(R.drawable.ropa_categoria, "Ropa"));
        lista.add(new Categoria(R.drawable.cuerpo_categoria, "Cuerpo"));
        lista.add(new Categoria(R.drawable.casa_categoria,  "Casa"));
        lista.add(new Categoria(R.drawable.colegio_categoria,  "Colegio"));
        lista.add(new Categoria(R.drawable.ciudad_categoria,  "Ciudad"));
        lista.add(new Categoria(R.drawable.calendario_categoria,  "Calendario"));
        lista.add(new Categoria(R.drawable.naturaleza_categoria, "Naturaleza"));
        lista.add(new Categoria(R.drawable.adjetivos_adverbios_verbos_categoria,  "Adjetivos, advebios y verbos"));


        return lista;
    }


}
