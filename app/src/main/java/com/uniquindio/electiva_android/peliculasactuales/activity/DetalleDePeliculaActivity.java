package com.uniquindio.electiva_android.peliculasactuales.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uniquindio.electiva_android.peliculasactuales.R;
import com.uniquindio.electiva_android.peliculasactuales.fragmets.DetalleDePeliculaFragment;
import com.uniquindio.electiva_android.peliculasactuales.vo.Pelicula;
/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa el detalle de una pelicula
 */
public class DetalleDePeliculaActivity extends AppCompatActivity {
    /**
     * Metodo que nos permite realizar las inicializaciones los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_pelicula);

        DetalleDePeliculaFragment detalleDePelicula = (DetalleDePeliculaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_pelicula);
        Pelicula film = (Pelicula) getIntent().getExtras().getParcelable("pelicula");
        detalleDePelicula.showDetail(film);

    }
}
