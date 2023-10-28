package javier.peralta.lenguadesignos.clase;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import javier.peralta.lenguadesignos.app.MyApplication;

public class Signo extends RealmObject {
    @PrimaryKey
    private int id;
    private int imagen;
    private String titulo;
    private String descripcion;
    private String bgImagen;
    private String bgTitulo;

    public Signo(){}

    public Signo(int imagen, String titulo, String descripcion, String bgImagen, String bgTitulo) {
        this.id = MyApplication.itemID.incrementAndGet();
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.bgImagen = bgImagen;
        this.bgTitulo = bgTitulo;
    }

    public int getImagen() {return imagen;}

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBgImagen() {
        return bgImagen;
    }

    public String getBgTitulo() {
        return bgTitulo;
    }
}
