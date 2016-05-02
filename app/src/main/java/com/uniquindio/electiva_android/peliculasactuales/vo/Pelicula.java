package com.uniquindio.electiva_android.peliculasactuales.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-15
 *
 * Actividad que que representa una pelicula
 */
public class Pelicula implements Parcelable{
    private String titulo, anio, urlTrailer ,descripcion;

    /**
     * Metodo contructor de la clase pelicula
     * @param titulo, titulo de la pelicula
     * @param anio, anio de la pelicula
     */
    public Pelicula(String titulo, String anio) {
        this.titulo = titulo;
        this.anio = anio;
    }
    /**
     * Metodo contructor dos de la clase pelicula que resibe otro parametro
     * @param titulo, titulo de la pelicula
     * @param anio, anio de la pelicula
     * @param urlTrailer, la url de la pelicula
     */
    public Pelicula(String titulo, String anio, String urlTrailer) {
        this.titulo = titulo;
        this.anio = anio;
        this.urlTrailer=urlTrailer;
    }
    /**
     * Metodo que permite guardar la informacion de la pelicula para ser enviada entre actividades
     * @param in, la parcela en donde se va guardar la informacion de la pelicula
     */
    protected Pelicula(Parcel in) {
        titulo = in.readString();
        anio = in.readString();
        urlTrailer = in.readString();
        descripcion = in.readString();
    }

    /**
     * Interfaz que debe implementarse y proporciona como un campo
     * CREADOR pública que genera instancias de la clase parcelable de una parcela.
     */
    public static final Creator<Pelicula> CREATOR = new Creator<Pelicula>() {
        /**
         * Metodo que permite Crear una nueva instancia de la clase parcelable,
         * instanciándola de la parcela determinada
         * @param in, la parcela de la pelicula
         */
        @Override
        public Pelicula createFromParcel(Parcel in) {
            return new Pelicula(in);
        }
        /**
         * Metodo que crea una matriz de la pelicula parcelable
         * @param size, el tamaño de la matriz
         */
        @Override
        public Pelicula[] newArray(int size) {
            return new Pelicula[size];
        }
    };
    /**
     * Metodo que Describir los tipos de objetos especiales contenidas en la parcela
     * @return 0 objetos especiales
     */
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * Metodo que permite escribir en la parcela destino la informacion de la pelicula
     * @param dest, la parcela destino
     * @param flags, bandera para identificar como el objeto debe ser escrito
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(anio);
        dest.writeString(urlTrailer);
        dest.writeString(descripcion);
    }
    /**
     * Metodo que permite leer desde la parcela
     * @param in, la parcela  a ser leida con la informacion de la pelicula
     */
    public void readFromParcel(Parcel in) {
        titulo=in.readString();
        anio=in.readString();
        urlTrailer=in.readString();
        descripcion=in.readString();
    }

    /**
     * Metodo que permite obtener el titulo de la pelicula
     * @return el titulo de la pelicula
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Metodo que permite modificar el titulo de la pelicula
     * @param titulo , el titulo de la pelicula
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Metodo que permite obtener el anio de la pelicula
     * @return el anio de la pelicula
     */
    public String getAnio() {
        return anio;
    }
    /**
     * Metodo que permite modificar el anio de la pelicula
     * @param anio , el anio de la pelicula
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }
    /**
     * Metodo que permite obtener la url del trailer
     * @return la url del trailer
     */
    public String getUrlTrailer() {
        return urlTrailer;
    }
    /**
     * Metodo que permite modificar la url de la pelicula
     * @param urlTrailer , la url de la pelicula
     */
    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }
    /**
     * Metodo que permite obtener la descripcion de la pelicula
     * @return la descripcion de la pelicula
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo que permite modificar la descripcion de la pelicula
     * @param descripcion , la descripcion de la pelicula
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
