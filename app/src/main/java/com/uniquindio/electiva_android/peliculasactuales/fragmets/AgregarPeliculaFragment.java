package com.uniquindio.electiva_android.peliculasactuales.fragmets;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.uniquindio.electiva_android.peliculasactuales.R;
import com.uniquindio.electiva_android.peliculasactuales.vo.Pelicula;
/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa gregar una pelicula tipo fracmento
 */
public class AgregarPeliculaFragment extends DialogFragment {


    private EditText txtTitulo,txtYear,txtDescripcion,txtTraile;

    public AgregarPeliculaFragment() {
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
        getDialog().setTitle(R.string.agregar_pelicula);
        View view = inflater.inflate(R.layout.fragment_agregar_pelicula, container, false);
        txtTitulo=(EditText)view.findViewById(R.id.txtTitulo);
        txtDescripcion=(EditText)view.findViewById(R.id.txtDescripcion);
        txtTraile=(EditText)view.findViewById(R.id.urlTrailer);
        txtYear=(EditText)view.findViewById(R.id.txtYear);
        Button button =(Button) view.findViewById(R.id.btn_aceptar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pelicula pelicula= new Pelicula(txtTitulo.getText().toString(),txtYear.getText().toString(),txtTraile.getText().toString());
                pelicula.setDescripcion(txtDescripcion.getText().toString());

                ListaDePeliculasFragment listaDePeliculasFragment = (ListaDePeliculasFragment)AgregarPeliculaFragment.this.getFragmentManager().findFragmentById(R.id.fragmento_lista_peliculas);
                listaDePeliculasFragment.agregarPelicula(pelicula);
                getDialog().dismiss();
            }
        });
        return view;
    }

}
