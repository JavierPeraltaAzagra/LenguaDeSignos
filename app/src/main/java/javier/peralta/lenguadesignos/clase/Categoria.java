package javier.peralta.lenguadesignos.clase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import javier.peralta.lenguadesignos.app.MyApplication;

public class Categoria extends RealmObject {

    @PrimaryKey
    private int id;
    private String categoria;
    private int imagen;

    public Categoria(){}

    public Categoria(int imagen, String categoria) {
        this.id = MyApplication.itemID.incrementAndGet();
        this.imagen = imagen;
        this.categoria = categoria;
    }


    public String getCategoria() {
        return categoria;
    }

    public int getImagen() {
        return imagen;
    }
}


