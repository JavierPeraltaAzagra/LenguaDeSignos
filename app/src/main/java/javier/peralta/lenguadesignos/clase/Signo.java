package javier.peralta.lenguadesignos.clase;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import javier.peralta.lenguadesignos.app.MyApplication;

public class Signo extends RealmObject {
    @PrimaryKey
    private int id;
    private int imagen;
    private String titulo;
    private String categoria;

    public Signo(){}

    public Signo(int imagen, String titulo, String categoria) {
        this.id = MyApplication.itemID.incrementAndGet();
        this.imagen = imagen;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public int getImagen() {return imagen;}

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }
}
