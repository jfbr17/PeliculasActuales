package com.uniquindio.electiva_android.peliculasactuales.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.electiva_android.peliculasactuales.R;
import com.uniquindio.electiva_android.peliculasactuales.fragmets.ListaDePeliculasFragment;
import com.uniquindio.electiva_android.peliculasactuales.vo.Pelicula;

import java.util.ArrayList;
/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa el adaptador recyclerView para la presentacion de las peliculas
 */
public class AdaptadorDePelicula extends RecyclerView.Adapter<AdaptadorDePelicula.PeliculaViewHolder>{

    private ArrayList<Pelicula> peliculas;

    private static OnClickAdaptadorDePelicula listener;
    /**
     * Metodo contructor de la clase adaptadorPelicula
     * @param peliculas, el arreglo de peliculas a mostrar
     * @param listaDePeliculasFragment, los fagmentos de las peliculas
     */
    public AdaptadorDePelicula(ArrayList<Pelicula>peliculas, ListaDePeliculasFragment listaDePeliculasFragment) {
        this.peliculas= peliculas;
        listener= (OnClickAdaptadorDePelicula) listaDePeliculasFragment;
    }
    /**
     * Metodo que permite crear una vista de tipo pelicula para el reciclerView
     * @param parent, El ViewGroup en la que se añadirá la nueva vista
     * @param viewType, El tipo de vista de la nueva vista.
     */
    @Override
    public PeliculaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_de_pelicula, parent, false);
        PeliculaViewHolder peliculaVH = new PeliculaViewHolder(itemView);
        return peliculaVH;
    }
    /**
     * Metodo que visualizar los datos en la posicion especifica
     * @param holder, la vista a ser visualizada
     * @param position, la posicion de la vista.
     */
    @Override
    public void onBindViewHolder(PeliculaViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.binPelicual(pelicula);

    }
    /**
     * Metodo que permite contar los elemmentos de la lista
     * @return el tamaño de la lista
     */
    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public static class PeliculaViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTitulo;
        private TextView txtAnio;
        /**
         * Metodo contructor de la vista de tipo pelicula
         * @param itemView, el item de la lista
         */
        public PeliculaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            txtAnio = (TextView) itemView.findViewById(R.id.anio);

        }
        /**
         * Metodo que permite modificar los atributos de la pelicula
         * @param p, la pelicula
         */
        public void binPelicual(Pelicula p) {
            txtTitulo.setText(p.getTitulo());
            txtAnio.setText(p.getAnio());
        }
        /**
         * Metodo que permite identificar el item de la vista presionado
         * @param v, la vista del evento
         */
        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. "+txtTitulo.getText());

        }
    }

    public interface OnClickAdaptadorDePelicula{
        public void onClickPosition(int pos);
    }


}
