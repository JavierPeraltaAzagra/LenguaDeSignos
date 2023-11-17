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

        realm = Realm.getDefaultInstance();

        recyclerView = findViewById(R.id.recycler_view);

        buscador = findViewById(R.id.buscador);

        if (realm.isEmpty()) {
            List<Signo> lista = new ArrayList();
            lista.add(new Signo(R.drawable.abajo, "Abajo"));
            lista.add(new Signo(R.drawable.abecedario, "Abecedario"));
            lista.add(new Signo(R.drawable.abeja, "Abeja"));
            lista.add(new Signo(R.drawable.abeto, "Abeto"));
            lista.add(new Signo(R.drawable.abrazar, "Abrazar"));
            lista.add(new Signo(R.drawable.abuelo, "Abuelo"));
            lista.add(new Signo(R.drawable.aburrido, "Aburrido"));
            lista.add(new Signo(R.drawable.aceite, "Aceite"));
            lista.add(new Signo(R.drawable.acera, "Acera"));
            lista.add(new Signo(R.drawable.acido, "Ácido"));
            lista.add(new Signo(R.drawable.adjetivos, "Adjetivos"));
            lista.add(new Signo(R.drawable.adverbio, "Adverbio"));
            lista.add(new Signo(R.drawable.agradable, "Agradable"));
            lista.add(new Signo(R.drawable.agua, "Agua"));
            lista.add(new Signo(R.drawable.aguila, "Aguila"));
            lista.add(new Signo(R.drawable.alegre, "Alegre"));
            lista.add(new Signo(R.drawable.alfombra, "Alfombra"));
            lista.add(new Signo(R.drawable.alimento, "Alimento"));
            lista.add(new Signo(R.drawable.alto, "Alto"));
            lista.add(new Signo(R.drawable.alumno, "Alumno"));
            lista.add(new Signo(R.drawable.amar, "Amar"));
            lista.add(new Signo(R.drawable.amargo, "Amargo"));
            lista.add(new Signo(R.drawable.amarillo, "Amarillo"));
            lista.add(new Signo(R.drawable.ambulancia, "Ambulancia"));
            lista.add(new Signo(R.drawable.amigo, "Amigo"));
            lista.add(new Signo(R.drawable.andar, "Andar"));
            lista.add(new Signo(R.drawable.animal, "Animal"));
            lista.add(new Signo(R.drawable.aprender, "Aprender"));
            lista.add(new Signo(R.drawable.arbol, "Árbol"));
            lista.add(new Signo(R.drawable.arco_iris, "Arcoíris"));
            lista.add(new Signo(R.drawable.arena, "Arena"));
            lista.add(new Signo(R.drawable.armario, "Armario"));
            lista.add(new Signo(R.drawable.arriba, "Arriba"));
            lista.add(new Signo(R.drawable.arroz, "Arroz"));
            lista.add(new Signo(R.drawable.autobus, "Autobús"));
            lista.add(new Signo(R.drawable.ayer, "Ayer"));
            lista.add(new Signo(R.drawable.ayudar, "Ayudar"));
            lista.add(new Signo(R.drawable.azucar, "Azúcar"));
            lista.add(new Signo(R.drawable.bajo, "Bajo"));
            lista.add(new Signo(R.drawable.ballena, "Ballena"));
            lista.add(new Signo(R.drawable.banco_dinero, "Banco de dinero"));
            lista.add(new Signo(R.drawable.banco_sentar, "Banco de asiento"));
            lista.add(new Signo(R.drawable.banera, "Bañera"));
            lista.add(new Signo(R.drawable.bano, "Baño"));
            lista.add(new Signo(R.drawable.barca, "Barca"));
            lista.add(new Signo(R.drawable.bebe, "Bebé"));
            lista.add(new Signo(R.drawable.beber, "Beber"));
            lista.add(new Signo(R.drawable.bebida, "Bebida"));
            lista.add(new Signo(R.drawable.besar, "Besar"));
            lista.add(new Signo(R.drawable.biblioteca, "Biblioteca"));
            lista.add(new Signo(R.drawable.bicicleta, "Bicicleta"));
            lista.add(new Signo(R.drawable.bien, "Bien"));
            lista.add(new Signo(R.drawable.blanco, "Blanco"));
            lista.add(new Signo(R.drawable.blando, "Blando"));
            lista.add(new Signo(R.drawable.boca, "Boca"));
            lista.add(new Signo(R.drawable.bocadillo, "Bocadillo"));
            lista.add(new Signo(R.drawable.boligrafo, "Bolígrafo"));
            lista.add(new Signo(R.drawable.bombero, "Bombero"));
            lista.add(new Signo(R.drawable.borrador, "Borrador"));
            lista.add(new Signo(R.drawable.brazo, "Brazo"));
            lista.add(new Signo(R.drawable.bueno, "Bueno"));
            lista.add(new Signo(R.drawable.buzon, "Buzón"));
            lista.add(new Signo(R.drawable.caballo, "Caballo"));
            lista.add(new Signo(R.drawable.cabeza, "Cabeza"));
            lista.add(new Signo(R.drawable.cabra, "Cabra"));
            lista.add(new Signo(R.drawable.cacerola, "Cacerola"));
            lista.add(new Signo(R.drawable.calendario, "Calendario"));
            lista.add(new Signo(R.drawable.caliente, "Caliente"));
            lista.add(new Signo(R.drawable.calle, "Calle"));
            lista.add(new Signo(R.drawable.cama, "Cama"));
            lista.add(new Signo(R.drawable.camello, "Camello"));
            lista.add(new Signo(R.drawable.camion, "Camión"));
            lista.add(new Signo(R.drawable.caramelo, "Caramelo"));
            lista.add(new Signo(R.drawable.carnes, "Carnes"));
            lista.add(new Signo(R.drawable.casa, "Casa"));
            lista.add(new Signo(R.drawable.castano, "Castaño"));
            lista.add(new Signo(R.drawable.cebolla, "Cebolla"));
            lista.add(new Signo(R.drawable.cena, "Cena"));
            lista.add(new Signo(R.drawable.cepillo, "Cepillo"));
            lista.add(new Signo(R.drawable.cera, "Cera"));
            lista.add(new Signo(R.drawable.cerca, "Cerca"));
            lista.add(new Signo(R.drawable.cerdo, "Cerdo"));
            lista.add(new Signo(R.drawable.champu, "Champú"));
            lista.add(new Signo(R.drawable.chocolate, "Chocolate"));
            lista.add(new Signo(R.drawable.ciego, "Ciego"));
            lista.add(new Signo(R.drawable.cine, "Cine"));
            lista.add(new Signo(R.drawable.circulo, "Círculo"));
            lista.add(new Signo(R.drawable.ciudad, "Ciudad"));
            lista.add(new Signo(R.drawable.claro, "Claro"));
            lista.add(new Signo(R.drawable.clase, "Clase"));
            lista.add(new Signo(R.drawable.coche, "Coche"));
            lista.add(new Signo(R.drawable.cocina, "Cocina"));
            lista.add(new Signo(R.drawable.cocodrilo, "Cocodrilo"));
            lista.add(new Signo(R.drawable.colegio, "Colegio"));
            lista.add(new Signo(R.drawable.colonia, "Colonia"));
            lista.add(new Signo(R.drawable.colores, "Colores"));
            lista.add(new Signo(R.drawable.columpio, "Columpio"));
            lista.add(new Signo(R.drawable.comer, "Comer"));
            lista.add(new Signo(R.drawable.comida, "Comida"));
            lista.add(new Signo(R.drawable.comprar, "Comprar"));
            lista.add(new Signo(R.drawable.conejo, "Conejo"));
            lista.add(new Signo(R.drawable.conocer, "Conocer"));
            lista.add(new Signo(R.drawable.contar, "Contar"));
            lista.add(new Signo(R.drawable.contento, "Contento"));
            lista.add(new Signo(R.drawable.correr, "Correr"));
            lista.add(new Signo(R.drawable.cortar, "Cortar"));
            lista.add(new Signo(R.drawable.cosas, "Cosas"));
            lista.add(new Signo(R.drawable.cosas_del_colegio, "Cosas del colegio"));
            lista.add(new Signo(R.drawable.crecer, "Crecer"));
            lista.add(new Signo(R.drawable.crecer_planta, "Crecer planta"));
            lista.add(new Signo(R.drawable.cristal, "Cristal"));
            lista.add(new Signo(R.drawable.cuaderno, "Cuaderno"));
            lista.add(new Signo(R.drawable.cuchara, "Cuchara"));
            lista.add(new Signo(R.drawable.cuchillo, "Cuchillo"));
            lista.add(new Signo(R.drawable.cuento, "Cuento"));
            lista.add(new Signo(R.drawable.cuerpo, "Cuerpo"));
            lista.add(new Signo(R.drawable.culo, "Culo"));
            lista.add(new Signo(R.drawable.cumpleanos, "Cumpleaños"));
            lista.add(new Signo(R.drawable.debajo, "Debajo"));
            lista.add(new Signo(R.drawable.dedo, "Dedo"));
            lista.add(new Signo(R.drawable.delante, "Delante"));
            lista.add(new Signo(R.drawable.delfin, "Delfín"));
            lista.add(new Signo(R.drawable.delgado, "Delgado"));
            lista.add(new Signo(R.drawable.dentro, "Dentro"));
            lista.add(new Signo(R.drawable.derecha, "Derecha"));
            lista.add(new Signo(R.drawable.desagradable, "Desagradable"));
            lista.add(new Signo(R.drawable.desayuno, "Desayuno"));
            lista.add(new Signo(R.drawable.despertador, "Despertador"));
            lista.add(new Signo(R.drawable.detras, "Detrás"));
            lista.add(new Signo(R.drawable.dia_de_la_semana, "Dia de la semana"));
            lista.add(new Signo(R.drawable.dia_manana, "Mañana (Día)"));
            lista.add(new Signo(R.drawable.dibujo, "Dibujo"));
            lista.add(new Signo(R.drawable.diccionario, "Diccionario"));
            lista.add(new Signo(R.drawable.diciembre, "Diciembre"));
            lista.add(new Signo(R.drawable.dientes, "Dientes"));
            lista.add(new Signo(R.drawable.diferencia, "Diferencia"));
            lista.add(new Signo(R.drawable.diferente, "Diferente"));
            lista.add(new Signo(R.drawable.divertido, "Divertido"));
            lista.add(new Signo(R.drawable.domingo, "Domingo"));
            lista.add(new Signo(R.drawable.dormir, "Dormir"));
            lista.add(new Signo(R.drawable.dormitorio, "Dormitorio"));
            lista.add(new Signo(R.drawable.ducharse, "Ducharse"));
            lista.add(new Signo(R.drawable.dulce, "Dulce"));
            lista.add(new Signo(R.drawable.duro, "Duro"));
            lista.add(new Signo(R.drawable.elefante, "Elefante"));
            lista.add(new Signo(R.drawable.en_punto, "En punto"));
            lista.add(new Signo(R.drawable.encima, "Encima"));
            lista.add(new Signo(R.drawable.enfadado, "Enfadado"));
            lista.add(new Signo(R.drawable.enfermo, "Enfermo"));
            lista.add(new Signo(R.drawable.entender, "Entender"));
            lista.add(new Signo(R.drawable.escribir, "Escribir"));
            lista.add(new Signo(R.drawable.espejo, "Espejo"));
            lista.add(new Signo(R.drawable.esperar, "Esperar"));
            lista.add(new Signo(R.drawable.esponja, "Esponja"));
            lista.add(new Signo(R.drawable.estaciones, "Estaciones"));
            lista.add(new Signo(R.drawable.estrella, "Estrella"));
            lista.add(new Signo(R.drawable.explicar, "Explicar"));
            lista.add(new Signo(R.drawable.familia, "Familia"));
            lista.add(new Signo(R.drawable.faro, "Faro"));
            lista.add(new Signo(R.drawable.farola, "Farola"));
            lista.add(new Signo(R.drawable.fax, "Fax"));
            lista.add(new Signo(R.drawable.feo, "Feo"));
            lista.add(new Signo(R.drawable.fiesta, "Fiesta"));
            lista.add(new Signo(R.drawable.fin_de_semana, "Fin de semana"));
            lista.add(new Signo(R.drawable.flan, "Flan"));
            lista.add(new Signo(R.drawable.flor, "Flor"));
            lista.add(new Signo(R.drawable.flotador, "Flotador"));
            lista.add(new Signo(R.drawable.foca, "Foca"));
            lista.add(new Signo(R.drawable.formas, "Formas"));
            lista.add(new Signo(R.drawable.formas_y_tamanos, "Formas y tamaños"));
            lista.add(new Signo(R.drawable.fresa, "Fresa"));
            lista.add(new Signo(R.drawable.frio, "Frio"));
            lista.add(new Signo(R.drawable.fruta, "Fruta"));
            lista.add(new Signo(R.drawable.fuego, "Fuego"));
            lista.add(new Signo(R.drawable.fuente, "Fuente"));
            lista.add(new Signo(R.drawable.galleta, "Galleta"));
            lista.add(new Signo(R.drawable.gallina, "Gallina"));
            lista.add(new Signo(R.drawable.gato, "Gato"));
            lista.add(new Signo(R.drawable.goma, "Goma"));
            lista.add(new Signo(R.drawable.gordo, "Gordo"));
            lista.add(new Signo(R.drawable.gramo, "Gramo"));
            lista.add(new Signo(R.drawable.grande, "Grande"));
            lista.add(new Signo(R.drawable.granja, "Granja"));
            lista.add(new Signo(R.drawable.gritar, "Gritar"));
            lista.add(new Signo(R.drawable.guapo, "Guapo"));
            lista.add(new Signo(R.drawable.gustar, "Gustar"));
            lista.add(new Signo(R.drawable.gusto, "Gusto"));
            //lista.add(new Signo(R.drawable.hablar, "Hablar"));
            lista.add(new Signo(R.drawable.hablar_oral, "Hablar (Oral)"));
            lista.add(new Signo(R.drawable.helado, "Helado"));
            lista.add(new Signo(R.drawable.hermano, "Hermano"));
            lista.add(new Signo(R.drawable.hierba, "Hierba"));
            lista.add(new Signo(R.drawable.hoja, "Hoja"));
            lista.add(new Signo(R.drawable.hora_interrogativa, "Hora (Interrogativa)"));
            lista.add(new Signo(R.drawable.hoy, "Hoy"));
            lista.add(new Signo(R.drawable.huevo, "Huevo"));
            lista.add(new Signo(R.drawable.igual, "Igual"));
            lista.add(new Signo(R.drawable.invierno, "Invierno"));
            lista.add(new Signo(R.drawable.izquierda, "Izquierda"));
            lista.add(new Signo(R.drawable.jabon, "Jabón"));
            lista.add(new Signo(R.drawable.jarra, "Jarra"));
            lista.add(new Signo(R.drawable.jirafa, "Jirafa"));
            lista.add(new Signo(R.drawable.jueves, "Jueves"));
            lista.add(new Signo(R.drawable.jugar, "Jugar"));
            lista.add(new Signo(R.drawable.junio, "Junio"));
            lista.add(new Signo(R.drawable.la_hora_de, "La hora de"));
            lista.add(new Signo(R.drawable.lampara, "Lámpara"));
            lista.add(new Signo(R.drawable.lapices_de_colores, "Lápices de colores"));
            lista.add(new Signo(R.drawable.lapiz, "Lápiz"));
            lista.add(new Signo(R.drawable.cristal, "Cristal"));
            lista.add(new Signo(R.drawable.cristal, "Cristal"));lista.add(new Signo(R.drawable.cristal, "Cristal"));
            lista.add(new Signo(R.drawable.lavabo, "Lavabo"));
            lista.add(new Signo(R.drawable.lavadora, "Lavadora"));
            lista.add(new Signo(R.drawable.lavar_la_cabeza, "Lavar la cabeza"));
            lista.add(new Signo(R.drawable.lavar_la_ropa, "Lavar la ropa"));
            lista.add(new Signo(R.drawable.lavar_los_dientes, "Lavar los dientes"));
            lista.add(new Signo(R.drawable.leche, "Leche"));
            lista.add(new Signo(R.drawable.lechuga, "Lechuga"));
            lista.add(new Signo(R.drawable.leer, "Leer"));
            lista.add(new Signo(R.drawable.lejos, "Lejos"));
            lista.add(new Signo(R.drawable.lengua, "Lengua"));
            lista.add(new Signo(R.drawable.lenguajessignosespa_ola, "Lenguaje de signos Española"));
            lista.add(new Signo(R.drawable.lento, "Lento"));
            lista.add(new Signo(R.drawable.leon, "León"));
            lista.add(new Signo(R.drawable.levantarse, "Levantarse"));
            lista.add(new Signo(R.drawable.libreria, "Librería"));
            lista.add(new Signo(R.drawable.libro, "Libro"));
            lista.add(new Signo(R.drawable.limon, "Limón"));
            lista.add(new Signo(R.drawable.limpio, "Limpio"));
            lista.add(new Signo(R.drawable.litro, "Litro"));
            lista.add(new Signo(R.drawable.lleno, "Lleno"));
            lista.add(new Signo(R.drawable.loro, "Loro"));
            lista.add(new Signo(R.drawable.luna, "Luna"));
            lista.add(new Signo(R.drawable.lunes, "Lúnes"));
            lista.add(new Signo(R.drawable.macarrones, "Macarrones"));
            lista.add(new Signo(R.drawable.maceta, "Maceta"));
            lista.add(new Signo(R.drawable.mal, "Mal"));
            lista.add(new Signo(R.drawable.malo, "Malo"));
            lista.add(new Signo(R.drawable.mama, "Mamá"));
            lista.add(new Signo(R.drawable.manana, "Mañana"));
            lista.add(new Signo(R.drawable.mano, "Mano"));
            lista.add(new Signo(R.drawable.manta, "Manta"));
            lista.add(new Signo(R.drawable.manzana, "Manzana"));
            lista.add(new Signo(R.drawable.maquina, "Máquina"));
            lista.add(new Signo(R.drawable.mariposa, "Mariposa"));
            lista.add(new Signo(R.drawable.marron, "Marrón"));
            lista.add(new Signo(R.drawable.martes, "Martes"));
            lista.add(new Signo(R.drawable.mayo, "Mayo"));
            lista.add(new Signo(R.drawable.mediano, "Mediano"));
            lista.add(new Signo(R.drawable.medico, "Médico"));
            lista.add(new Signo(R.drawable.medida, "Medida"));
            lista.add(new Signo(R.drawable.menos_cuarto, "Menos cuarto"));
            lista.add(new Signo(R.drawable.merienda, "Merienda"));
            lista.add(new Signo(R.drawable.mes, "Més"));
            lista.add(new Signo(R.drawable.meses_del_ano, "Meses del año"));
            lista.add(new Signo(R.drawable.mesilla, "Mesilla"));
            lista.add(new Signo(R.drawable.metro, "Metro"));
            lista.add(new Signo(R.drawable.miercoles, "Miércoles"));
            lista.add(new Signo(R.drawable.mono, "Mono"));
            lista.add(new Signo(R.drawable.montar, "Montar"));
            lista.add(new Signo(R.drawable.moreno, "Moreno"));
            lista.add(new Signo(R.drawable.moto, "Moto"));
            lista.add(new Signo(R.drawable.mucho, "Mucho"));
            lista.add(new Signo(R.drawable.mueble, "Mueble"));
            lista.add(new Signo(R.drawable.multiplicacion, "Multiplicación"));
            lista.add(new Signo(R.drawable.muneco, "Muñeco"));
            lista.add(new Signo(R.drawable.museo, "Museo"));
            lista.add(new Signo(R.drawable.nacer, "Nacer"));
            lista.add(new Signo(R.drawable.naranja, "Naranja"));
            lista.add(new Signo(R.drawable.nariz, "Naríz"));
            lista.add(new Signo(R.drawable.navidad, "Navidad"));
            lista.add(new Signo(R.drawable.negro, "Negro"));
            lista.add(new Signo(R.drawable.nevera, "Nevera"));
            lista.add(new Signo(R.drawable.nina, "Niña"));
            lista.add(new Signo(R.drawable.nino, "Niño"));
            lista.add(new Signo(R.drawable.no_conocer, "No conocer"));
            lista.add(new Signo(R.drawable.no_gustar, "No gustar"));
            lista.add(new Signo(R.drawable.no_tener, "No tener"));
            lista.add(new Signo(R.drawable.noviembre, "Noviembre"));
            lista.add(new Signo(R.drawable.numero, "Número"));
            lista.add(new Signo(R.drawable.objeto, "Objeto"));
            lista.add(new Signo(R.drawable.objetos, "Objetos"));
            lista.add(new Signo(R.drawable.octubre, "Octubre"));
            lista.add(new Signo(R.drawable.oido, "Oído"));
            lista.add(new Signo(R.drawable.oir, "Oír"));
            lista.add(new Signo(R.drawable.ojo, "Ojo"));
            lista.add(new Signo(R.drawable.oler, "Oler"));
            lista.add(new Signo(R.drawable.olfato, "Olfato"));
            lista.add(new Signo(R.drawable.ordenador, "Ordenador"));
            lista.add(new Signo(R.drawable.oreja, "Oreja"));
            lista.add(new Signo(R.drawable.oscuro, "Oscuro"));
            lista.add(new Signo(R.drawable.oso, "Oso"));
            lista.add(new Signo(R.drawable.otono, "Otoño"));
            lista.add(new Signo(R.drawable.oveja, "Oveja"));
            lista.add(new Signo(R.drawable.pajaro, "Pájaro"));
            lista.add(new Signo(R.drawable.palabra, "Palabra"));
            lista.add(new Signo(R.drawable.pan, "Pan"));
            lista.add(new Signo(R.drawable.papa, "Papa"));
            lista.add(new Signo(R.drawable.papa_noel, "Papa Noel"));
            lista.add(new Signo(R.drawable.papel, "Papel"));
            lista.add(new Signo(R.drawable.papelera, "Papelera"));
            lista.add(new Signo(R.drawable.parque, "Parque"));
            lista.add(new Signo(R.drawable.pasear, "Pasear"));
            lista.add(new Signo(R.drawable.paso_de_cebra, "Paso de cebra"));
            lista.add(new Signo(R.drawable.pasta_de_dientes, "Pasta de dientes"));
            lista.add(new Signo(R.drawable.pasteleria, "Pasteleria"));
            lista.add(new Signo(R.drawable.pastelero, "Pastelero"));
            lista.add(new Signo(R.drawable.patata, "Patata"));
            lista.add(new Signo(R.drawable.patinar, "Patinar"));
            lista.add(new Signo(R.drawable.patio, "Patio"));
            lista.add(new Signo(R.drawable.pato, "Pato"));
            lista.add(new Signo(R.drawable.pegamento, "Pegamento"));
            lista.add(new Signo(R.drawable.pegar, "Pegar"));
            lista.add(new Signo(R.drawable.peinarse, "Peinarse"));
            lista.add(new Signo(R.drawable.peine, "Peine"));
            lista.add(new Signo(R.drawable.pelirrojo, "Pelirrojo"));
            lista.add(new Signo(R.drawable.pelo, "Pelo"));
            lista.add(new Signo(R.drawable.pelota, "Pelota"));
            lista.add(new Signo(R.drawable.pene, "Pene"));
            lista.add(new Signo(R.drawable.pequeno, "Pequeño"));
            lista.add(new Signo(R.drawable.pera, "Pera"));
            lista.add(new Signo(R.drawable.perro, "Perro"));
            lista.add(new Signo(R.drawable.persona, "Persona"));
            lista.add(new Signo(R.drawable.pescado, "Pescado"));
            lista.add(new Signo(R.drawable.pescador, "Pescador"));
            lista.add(new Signo(R.drawable.pie, "Pie"));
            lista.add(new Signo(R.drawable.pierna, "Pierna"));
            lista.add(new Signo(R.drawable.pintura, "Pintura"));
            lista.add(new Signo(R.drawable.pizarra, "Pizarra"));
            lista.add(new Signo(R.drawable.plancha, "Plancha"));
            lista.add(new Signo(R.drawable.plastilina, "Plastilina"));
            lista.add(new Signo(R.drawable.platano, "Plátano"));
            lista.add(new Signo(R.drawable.plato, "Plato"));
            lista.add(new Signo(R.drawable.plaza, "Plaza"));
            lista.add(new Signo(R.drawable.poco, "Poco"));
            lista.add(new Signo(R.drawable.policia, "Policía"));
            lista.add(new Signo(R.drawable.pollo, "Pollo"));
            lista.add(new Signo(R.drawable.ponerse, "Ponerse"));
            lista.add(new Signo(R.drawable.por_la_manana, "Por la mañana"));
            lista.add(new Signo(R.drawable.por_la_noche, "Por la noche"));
            lista.add(new Signo(R.drawable.por_la_tarde, "Por la tarde"));
            lista.add(new Signo(R.drawable.postre, "Postre"));
            lista.add(new Signo(R.drawable.primavera, "Primavera"));
            lista.add(new Signo(R.drawable.primer, "Primer"));
            lista.add(new Signo(R.drawable.primo, "Primo"));
            lista.add(new Signo(R.drawable.profesiones, "Profesiones"));
            lista.add(new Signo(R.drawable.profesor, "Profecsor"));
            lista.add(new Signo(R.drawable.puente, "Puente"));
            lista.add(new Signo(R.drawable.puerta, "Puerta"));
            lista.add(new Signo(R.drawable.pure, "Puré"));
            lista.add(new Signo(R.drawable.queso, "Queso"));
            lista.add(new Signo(R.drawable.quiosco, "Quiosco"));
            lista.add(new Signo(R.drawable.quitarse, "Quitarse"));
            lista.add(new Signo(R.drawable.rapido, "Rápido"));
            lista.add(new Signo(R.drawable.rectangulo, "Rectángulo"));
            lista.add(new Signo(R.drawable.regalar, "Regalar"));
            lista.add(new Signo(R.drawable.reir, "Reir"));
            lista.add(new Signo(R.drawable.resta, "Resta"));
            lista.add(new Signo(R.drawable.reyes_magos, "Reyes Magos"));
            lista.add(new Signo(R.drawable.rojo, "Rojo"));
            lista.add(new Signo(R.drawable.rosa, "Rosa"));
            lista.add(new Signo(R.drawable.rotulador, "Rotulador"));
            lista.add(new Signo(R.drawable.rubio, "Rubio"));
            lista.add(new Signo(R.drawable.sabado, "Sábado"));
            lista.add(new Signo(R.drawable.sabana, "Sábana"));
            lista.add(new Signo(R.drawable.saborear, "Saborear"));
            lista.add(new Signo(R.drawable.sacapuntas, "Sacapuntas"));
            lista.add(new Signo(R.drawable.sal, "Sal"));
            lista.add(new Signo(R.drawable.salado, "Salado"));
            lista.add(new Signo(R.drawable.salon, "Salón"));
            lista.add(new Signo(R.drawable.saltar, "Saltar"));
            lista.add(new Signo(R.drawable.sandia, "Sandía"));
            lista.add(new Signo(R.drawable.sano, "Sano"));
            lista.add(new Signo(R.drawable.sarten, "Sartén"));
            lista.add(new Signo(R.drawable.sed, "Sed"));
            lista.add(new Signo(R.drawable.semaforo, "Semáforo"));
            lista.add(new Signo(R.drawable.semana, "Semana"));
            lista.add(new Signo(R.drawable.sentarse, "Sentarse"));
            lista.add(new Signo(R.drawable.sentidos, "Sentidos"));
            lista.add(new Signo(R.drawable.septiembre, "Septiembre"));
            lista.add(new Signo(R.drawable.servicio, "Servicio"));
            lista.add(new Signo(R.drawable.servilleta, "Servilleta"));
            lista.add(new Signo(R.drawable.silla, "Silla"));
            lista.add(new Signo(R.drawable.sofa, "Sofá"));
            lista.add(new Signo(R.drawable.sopa, "Sopa"));
            lista.add(new Signo(R.drawable.sordo, "Sordo"));
            lista.add(new Signo(R.drawable.sordociego, "Sordociego"));
            lista.add(new Signo(R.drawable.sucio, "Sucio"));
            lista.add(new Signo(R.drawable.suma, "Suma"));
            lista.add(new Signo(R.drawable.supermercado, "Súpermercado"));
            lista.add(new Signo(R.drawable.tacto, "Tacto"));
            lista.add(new Signo(R.drawable.tamano, "Tamaño"));
            lista.add(new Signo(R.drawable.tarta, "Tarta"));
            lista.add(new Signo(R.drawable.teatro, "Teatro"));
            lista.add(new Signo(R.drawable.telefono, "Teléfono"));
            lista.add(new Signo(R.drawable.televisor, "Televisor"));
            lista.add(new Signo(R.drawable.templado, "Templado"));
            lista.add(new Signo(R.drawable.tenedor, "Tenedor"));
            lista.add(new Signo(R.drawable.tener, "Tener"));
            lista.add(new Signo(R.drawable.tiburon, "Tiburón"));
            lista.add(new Signo(R.drawable.tiempo, "Tiempo"));
            lista.add(new Signo(R.drawable.tienda, "Tienda"));
            lista.add(new Signo(R.drawable.tigre, "Tigre"));
            lista.add(new Signo(R.drawable.tijeras, "Tijeras"));
            lista.add(new Signo(R.drawable.tio, "Tío"));
            lista.add(new Signo(R.drawable.tiza, "Tiza"));
            lista.add(new Signo(R.drawable.toalla, "Toalla"));
            lista.add(new Signo(R.drawable.tobogan, "Tobogán"));
            lista.add(new Signo(R.drawable.tocar, "Tocar"));
            lista.add(new Signo(R.drawable.tomate, "Tomate"));
            lista.add(new Signo(R.drawable.toro, "Toro"));
            lista.add(new Signo(R.drawable.tortuga, "Tortuga"));
            lista.add(new Signo(R.drawable.transporte, "Transporte"));
            lista.add(new Signo(R.drawable.triangulo, "Triángulo"));
            lista.add(new Signo(R.drawable.triste, "Triste"));
            lista.add(new Signo(R.drawable.ultimo, "Último"));
            lista.add(new Signo(R.drawable.uva, "Uva"));
            lista.add(new Signo(R.drawable.vaca, "Vaca"));
            lista.add(new Signo(R.drawable.vacio, "Vacío"));
            lista.add(new Signo(R.drawable.vamos_a, "Vamos a"));
            lista.add(new Signo(R.drawable.vaso, "Vaso"));
            lista.add(new Signo(R.drawable.vehiculo, "Vehículo"));
            lista.add(new Signo(R.drawable.ventana, "Ventana"));
            lista.add(new Signo(R.drawable.ver, "Ver"));
            lista.add(new Signo(R.drawable.verano, "Verano"));
            lista.add(new Signo(R.drawable.verbo, "Verbo"));
            lista.add(new Signo(R.drawable.verde, "Verde"));
            lista.add(new Signo(R.drawable.vestirse, "Vestirse"));
            lista.add(new Signo(R.drawable.video, "Vídeo"));
            lista.add(new Signo(R.drawable.viernes, "Viernes"));
            lista.add(new Signo(R.drawable.vista, "Vista"));
            lista.add(new Signo(R.drawable.vivir, "Vivir"));
            lista.add(new Signo(R.drawable.vulva, "Vulva"));
            lista.add(new Signo(R.drawable.y_cuarto, "Y cuarto"));
            lista.add(new Signo(R.drawable.y_media, "Y media"));
            lista.add(new Signo(R.drawable.yogur, "Yogur"));
            lista.add(new Signo(R.drawable.zanahoria, "Zanahoria"));
            lista.add(new Signo(R.drawable.zapateria, "Zapatería"));
            lista.add(new Signo(R.drawable.zoo, "Zoo"));
            lista.add(new Signo(R.drawable.zumo, "Zumo"));


            realm.beginTransaction();
            realm.copyToRealmOrUpdate(lista);
            realm.commitTransaction();
        }



        if (realm.isEmpty()) {

            // Familia
            List<Signo> lista = new ArrayList();
            lista.add(new Signo(R.drawable.abajo, "Abajo"));
            lista.add(new Signo(R.drawable.abuelo, "Abuelo"));
            lista.add(new Signo(R.drawable.amigo, "Amigo"));
            lista.add(new Signo(R.drawable.bebe, "Bebé"));
            lista.add(new Signo(R.drawable.hermano, "Hermano"));
            lista.add(new Signo(R.drawable.mama, "Mamá"));
            lista.add(new Signo(R.drawable.nina, "Niña"));
            lista.add(new Signo(R.drawable.nino, "Niño"));
            lista.add(new Signo(R.drawable.papa, "Papá"));
            lista.add(new Signo(R.drawable.persona, "Persona"));
            lista.add(new Signo(R.drawable.primo, "Primo"));
            lista.add(new Signo(R.drawable.tio, "Tío"));
            lista.add(new Signo(R.drawable.ciego, "Ciego"));
            lista.add(new Signo(R.drawable.sordo, "Sordo"));
            lista.add(new Signo(R.drawable.sordociego, "Sordociego"));


            // Comidas y bebidas
            lista.add(new Signo(R.drawable.comida, "Comida"));
            lista.add(new Signo(R.drawable.bebida, "Bebida"));
            lista.add(new Signo(R.drawable.desayuno, "Desayuno"));
            lista.add(new Signo(R.drawable.comida, "Comida"));
            lista.add(new Signo(R.drawable.merienda, "Merienda"));
            lista.add(new Signo(R.drawable.cena, "Cena"));
            lista.add(new Signo(R.drawable.alimento, "Alimento"));
            // lista.add(new Signo(R.drawable.hambre, "Hambre"));
            lista.add(new Signo(R.drawable.sed, "Sed"));
            lista.add(new Signo(R.drawable.aceite, "Aceite"));
            lista.add(new Signo(R.drawable.agua, "Agua"));
            lista.add(new Signo(R.drawable.arroz, "Arroz"));
            lista.add(new Signo(R.drawable.azucar, "Azúcar"));
            lista.add(new Signo(R.drawable.bocadillo, "Bocadillo"));
            lista.add(new Signo(R.drawable.caramelo, "Caramelo"));
            lista.add(new Signo(R.drawable.carnes, "Carne"));
            lista.add(new Signo(R.drawable.cebolla, "Cebolla"));
            lista.add(new Signo(R.drawable.chocolate, "Chocolate"));
            lista.add(new Signo(R.drawable.galleta, "Galleta"));
            lista.add(new Signo(R.drawable.huevo, "Huevo"));
            lista.add(new Signo(R.drawable.leche, "Leche"));
            lista.add(new Signo(R.drawable.lechuga, "Lechuga"));
            lista.add(new Signo(R.drawable.limon, "Limón"));
            lista.add(new Signo(R.drawable.macarrones, "Macarrones"));
            lista.add(new Signo(R.drawable.pan, "Pan"));
            lista.add(new Signo(R.drawable.patata, "Patata"));
            lista.add(new Signo(R.drawable.pescado, "Pescado"));
            lista.add(new Signo(R.drawable.pollo, "Pollo"));
            lista.add(new Signo(R.drawable.pure, "Puré"));
            lista.add(new Signo(R.drawable.queso, "Queso"));
            lista.add(new Signo(R.drawable.sal, "Sal"));
            lista.add(new Signo(R.drawable.sopa, "Sopa"));
            lista.add(new Signo(R.drawable.tomate, "Tomate"));
            lista.add(new Signo(R.drawable.zanahoria, "Zanahoria"));
            lista.add(new Signo(R.drawable.zumo, "Zumo"));
            lista.add(new Signo(R.drawable.postre, "Postre"));
            lista.add(new Signo(R.drawable.dulce, "Dulce"));
            lista.add(new Signo(R.drawable.flan, "Flan"));
            lista.add(new Signo(R.drawable.fresa, "Fresa"));
            lista.add(new Signo(R.drawable.fruta, "Fruta"));
            lista.add(new Signo(R.drawable.helado, "Helado"));
            lista.add(new Signo(R.drawable.manzana, "Manzana"));
            lista.add(new Signo(R.drawable.naranja, "Naranja"));
            lista.add(new Signo(R.drawable.pera, "Pera"));
            lista.add(new Signo(R.drawable.platano, "Plátano"));
            lista.add(new Signo(R.drawable.sandia, "Sandía"));
            lista.add(new Signo(R.drawable.tarta, "Tarta"));
            lista.add(new Signo(R.drawable.uva, "Uva"));
            lista.add(new Signo(R.drawable.yogur, "Yogur"));


            // Ropa
            lista.add(new Signo(R.drawable.ropa, "Ropa"));
            lista.add(new Signo(R.drawable.abrigo, "Abrigo"));
            lista.add(new Signo(R.drawable.banador_chico, "Bañador Chico"));
            lista.add(new Signo(R.drawable.banador_chica, "Bañador Chica"));
            lista.add(new Signo(R.drawable.braga, "Braga"));
            lista.add(new Signo(R.drawable.bufanda, "Bufanda"));
            lista.add(new Signo(R.drawable.calzoncillo, "Calzoncillo"));
            lista.add(new Signo(R.drawable.camisa, "Camisa"));
            lista.add(new Signo(R.drawable.chandal, "Chándal"));
            lista.add(new Signo(R.drawable.gafas, "Gafas"));
            lista.add(new Signo(R.drawable.gorra, "Gorra"));
            lista.add(new Signo(R.drawable.jersey, "Jersey"));
            lista.add(new Signo(R.drawable.mochila, "Mochila"));
            lista.add(new Signo(R.drawable.pantalon, "Pantalón"));
            lista.add(new Signo(R.drawable.pijama, "Pijama"));
            lista.add(new Signo(R.drawable.reloj, "Reloj"));
            lista.add(new Signo(R.drawable.zapatilla, "Zapatilla"));
            lista.add(new Signo(R.drawable.zapato, "Zapato"));


            // Cuerpo
            lista.add(new Signo(R.drawable.cuerpo, "Cuerpo"));
            lista.add(new Signo(R.drawable.boca, "Boca"));
            lista.add(new Signo(R.drawable.brazo, "Brazo"));
            lista.add(new Signo(R.drawable.cabeza, "Cabeza"));
            lista.add(new Signo(R.drawable.culo, "Culo"));
            lista.add(new Signo(R.drawable.dedo, "Dedo"));
            lista.add(new Signo(R.drawable.dientes, "Dientes"));
            lista.add(new Signo(R.drawable.lengua, "Lengua"));
            lista.add(new Signo(R.drawable.mano, "Mano"));
            lista.add(new Signo(R.drawable.nariz, "Nariz"));
            lista.add(new Signo(R.drawable.ojo, "Ojo"));
            lista.add(new Signo(R.drawable.oreja, "Oreja"));
            lista.add(new Signo(R.drawable.pelo, "Pelo"));
            lista.add(new Signo(R.drawable.pene, "Pene"));
            lista.add(new Signo(R.drawable.pie, "Pie"));
            lista.add(new Signo(R.drawable.pierna, "Pierna"));
            lista.add(new Signo(R.drawable.vulva, "Vulva"));
            lista.add(new Signo(R.drawable.sentidos, "Sentidos"));
            lista.add(new Signo(R.drawable.gusto, "Gusto"));
            lista.add(new Signo(R.drawable.oido, "Oído"));
            lista.add(new Signo(R.drawable.olfato, "Olfato"));
            lista.add(new Signo(R.drawable.tacto, "Tacto"));
            lista.add(new Signo(R.drawable.vista, "Vista"));


            // Casa
            lista.add(new Signo(R.drawable.casa, "Casa"));
            lista.add(new Signo(R.drawable.cocina, "Cocina"));
            lista.add(new Signo(R.drawable.bano, "Cuarto de baño"));
            lista.add(new Signo(R.drawable.dormitorio, "Dormitorio"));
            lista.add(new Signo(R.drawable.salon, "Salón"));
            lista.add(new Signo(R.drawable.alfombra, "Alfombra"));
            lista.add(new Signo(R.drawable.armario, "Armario"));
            lista.add(new Signo(R.drawable.cama, "Cama"));
            lista.add(new Signo(R.drawable.cristal, "Cristal"));
            lista.add(new Signo(R.drawable.despertador, "Despertador"));
            lista.add(new Signo(R.drawable.fax, "Fax"));
            lista.add(new Signo(R.drawable.lampara, "Lámpara"));
            lista.add(new Signo(R.drawable.maceta, "Maceta"));
            lista.add(new Signo(R.drawable.manta, "Manta"));
            lista.add(new Signo(R.drawable.maquina, "Máquina"));
            lista.add(new Signo(R.drawable.mesa, "Mesa"));
            lista.add(new Signo(R.drawable.mesilla, "Mesilla"));
            lista.add(new Signo(R.drawable.mueble, "Mueble"));
            lista.add(new Signo(R.drawable.muneco, "Muñeco"));
            lista.add(new Signo(R.drawable.objeto, "Objeto"));
            lista.add(new Signo(R.drawable.ordenador, "Ordenador"));
            lista.add(new Signo(R.drawable.pelota, "Pelota"));
            lista.add(new Signo(R.drawable.plancha, "Plancha"));
            lista.add(new Signo(R.drawable.puerta, "Puerta"));
            lista.add(new Signo(R.drawable.sabana, "Sábana"));
            lista.add(new Signo(R.drawable.silla, "Silla"));
            lista.add(new Signo(R.drawable.sofa, "Sofá"));
            lista.add(new Signo(R.drawable.telefono, "Teléfono"));
            lista.add(new Signo(R.drawable.televisor, "Televisor"));
            lista.add(new Signo(R.drawable.ventana, "Ventana"));
            lista.add(new Signo(R.drawable.video, "Vídeo"));
            lista.add(new Signo(R.drawable.objetos, "Objetos"));
            lista.add(new Signo(R.drawable.bano, "Baño"));
            lista.add(new Signo(R.drawable.banera, "Bañera"));
            lista.add(new Signo(R.drawable.cepillo, "Cepillo de dientes"));
            lista.add(new Signo(R.drawable.champu, "Champú"));
            lista.add(new Signo(R.drawable.colonia, "Colonia"));
            lista.add(new Signo(R.drawable.espejo, "Espejo"));
            lista.add(new Signo(R.drawable.esponja, "Esponja"));
            lista.add(new Signo(R.drawable.jabon, "Jabón"));
            lista.add(new Signo(R.drawable.lavabo, "Lavabo"));
            lista.add(new Signo(R.drawable.papel, "Papel higiénico"));
            lista.add(new Signo(R.drawable.pasta_de_dientes, "Pasta de dientes"));
            lista.add(new Signo(R.drawable.peine, "Peine"));
            lista.add(new Signo(R.drawable.toalla, "Toalla"));
            lista.add(new Signo(R.drawable.cocina, "Cocina"));
            lista.add(new Signo(R.drawable.cacerola, "Cacerola"));
            lista.add(new Signo(R.drawable.cuchara, "Cuchara"));
            lista.add(new Signo(R.drawable.cuchillo, "Cuchillo"));
            lista.add(new Signo(R.drawable.jarra, "Jarra"));
            lista.add(new Signo(R.drawable.lavadora, "Lavadora"));
            lista.add(new Signo(R.drawable.nevera, "Nevera"));
            lista.add(new Signo(R.drawable.plato, "Plato"));
            lista.add(new Signo(R.drawable.sarten, "Sartén"));
            lista.add(new Signo(R.drawable.servilleta, "Servilleta"));
            lista.add(new Signo(R.drawable.tenedor, "Tenedor"));
            lista.add(new Signo(R.drawable.vaso, "Vaso"));


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