package com.uniquindio.electiva_android.peliculasactuales.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.uniquindio.electiva_android.peliculasactuales.R;
import com.uniquindio.electiva_android.peliculasactuales.fragmets.AgregarPeliculaFragment;
import com.uniquindio.electiva_android.peliculasactuales.fragmets.DetalleDePeliculaFragment;
import com.uniquindio.electiva_android.peliculasactuales.fragmets.ListaDePeliculasFragment;
import com.uniquindio.electiva_android.peliculasactuales.util.AdaptadorDePelicula;
import com.uniquindio.electiva_android.peliculasactuales.util.Utilidades;
import com.uniquindio.electiva_android.peliculasactuales.vo.Pelicula;

import java.util.ArrayList;
import java.util.List;
/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa la pelicula
 */
public class PeliculasActualesActivity extends AppCompatActivity implements ListaDePeliculasFragment.OnPeliculaSeleccionadaListener{


    private ListaDePeliculasFragment listaDePeliculasFragment;
    private ArrayList<Pelicula> peliculas;
    /**
     * Metodo que nos permite realizar las inicializaciones los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilidades.obtenerLenguaje(this);
        setContentView(R.layout.activity_peliculas_actuales);
        setTitle(R.string.app_name);

        peliculas = new ArrayList();
        peliculas.add(new Pelicula("Interestelar", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        peliculas.add(new Pelicula("El Padrino", "2015", "https://www.youtube.com/watch?v=yyDUC1LUXSU"));
        peliculas.add(new Pelicula("Regreso al futuro", "2015", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        peliculas.add(new Pelicula("Titanic", "2014", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        peliculas.add(new Pelicula("StarWars","2014","https://www.youtube.com/watch?v=yyDUC1LUXSU"));
        peliculas.add(new Pelicula("El bueno, el malo y el feo", "2014", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        peliculas.add(new Pelicula("La Pantera Rosa", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        peliculas.add(new Pelicula("Interestelar", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        peliculas.add(new Pelicula("El Padrino", "2015", "https://www.youtube.com/watch?v=yyDUC1LUXSU"));
        peliculas.add(new Pelicula("Regreso al futuro", "2015", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        peliculas.add(new Pelicula("Titanic", "2014", "https://www.youtube.com/watch?v=bvC_0foemLY"));
        peliculas.add(new Pelicula("StarWars", "2014","https://www.youtube.com/watch?v=yyDUC1LUXSU"));
        peliculas.add(new Pelicula("El bueno, el malo y el feo", "2014", "https://www.youtube.com/watch?v=HL1UzIK-flA"));
        peliculas.add(new Pelicula("La Pantera Rosa", "2015", "https://www.youtube.com/watch?v=bvC_0foemLY"));

        listaDePeliculasFragment= (ListaDePeliculasFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_peliculas);
        listaDePeliculasFragment.setPeliculas(peliculas);

    }
    /**
     * Metodo que nos permite inicializar el menu que es enviado por parametro
     * @param menu, menu el cual se va a inflar
     * @return true cuando se inicializa correctamente el menu falso en caso contrario
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    /**
     * Metodo que es llamado cuando se selecciona un elemento de un menu
     * @param item, el item  que ha sido seleccionado
     * @return false, para que ocurra el procedimiento normal o true si requiere consusumir o
     * hacer un procedimiento desde el metodo
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * Metodo que permite redirigir la pelicula seleccionada
     * a el frngmento que contiene el detalle de la pelicula
     * @param position, posicion de la pelicula seleccionada
     */
    @Override
    public void onPeliculaSeleccionada(int position) {
        boolean esFragmento =
                getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula) != null;
        if (esFragmento) {
            ((DetalleDePeliculaFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula)).showDetail(peliculas.get(position));
        } else {
            Intent intent = new Intent(PeliculasActualesActivity.this,
                    DetalleDePeliculaActivity.class);
            intent.putExtra("pelicula", peliculas.get(position));
            startActivity(intent);
        }
    }

}
