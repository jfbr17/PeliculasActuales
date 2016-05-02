package com.uniquindio.electiva_android.peliculasactuales.fragmets;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uniquindio.electiva_android.peliculasactuales.R;
import com.uniquindio.electiva_android.peliculasactuales.vo.Pelicula;
/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa el detalle de peliculas de tipo fragmento
 */
public class DetalleDePeliculaFragment extends Fragment implements View.OnClickListener{

    private TextView titulo;

    private Pelicula pelicula;

    private Button btnIrATrailer;

    public DetalleDePeliculaFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo que nos permite asociar el fragmento con un layout
     * @param inflater, el layout para inflar el fragmento
     * @param container, es la vista padre que contiene el fragmento.
     * @param savedInstanceState, bundle que nos permite guar estados.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_pelicula, container, false);
    }
    /**
     * Metodo que nos permite ver los detaller de una pelicula
     * @param pelicula, la pelicula que se requiere ver los detalles
     */
    public void showDetail(Pelicula pelicula) {
        this.pelicula= pelicula;
        pelicula.getTitulo();
        titulo = (TextView) getView().findViewById(R.id.titulo_de_detalle_pelicula);
        titulo.setText(pelicula.getTitulo());
        btnIrATrailer= (Button) getView().findViewById(R.id.btn_ir_a_trailes);
        btnIrATrailer.setOnClickListener(this);
    }
    /**
     * Metodo que permite identificar el item de la vista presionado
     * @param v, la vista del evento
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(pelicula.getUrlTrailer()));
        startActivity(intent);
    }

}
