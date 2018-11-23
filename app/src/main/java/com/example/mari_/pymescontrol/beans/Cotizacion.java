package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Cotizacion implements Parcelable {
    String id, folio, titulo, nombre;
    Date fecha;

    public Cotizacion(String id, String folio, String titulo, String nombre, Date fecha) {
        this.id = id;
        this.folio = folio;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    protected Cotizacion(Parcel in) {
        id = in.readString();
        folio = in.readString();
        titulo = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Cotizacion> CREATOR = new Creator<Cotizacion>() {
        @Override
        public Cotizacion createFromParcel(Parcel in) {
            return new Cotizacion(in);
        }

        @Override
        public Cotizacion[] newArray(int size) {
            return new Cotizacion[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getFolio() {
        return folio;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "id=" + id +
                ", folio='" + folio + '\'' +
                ", titulo='" + titulo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(folio);
        parcel.writeString(titulo);
        parcel.writeString(nombre);
    }
}
