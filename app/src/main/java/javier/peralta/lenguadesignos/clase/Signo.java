package javier.peralta.lenguadesignos.clase;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import javier.peralta.lenguadesignos.app.MyApplication;

public class Signo extends RealmObject {
    @PrimaryKey
    private int id;
    private int imagen;
    private String titulo;

    public Signo(){}

    public Signo(int imagen, String titulo) {
        this.id = MyApplication.itemID.incrementAndGet();
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public int getImagen() {return imagen;}

    public String getTitulo() {
        return titulo;
    }
}
