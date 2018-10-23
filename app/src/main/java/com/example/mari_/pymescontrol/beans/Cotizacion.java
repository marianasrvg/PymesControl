package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Cotizacion implements Parcelable {
    int id;
    String titulo, nombre;
    Date fecha;

    public Cotizacion() {
    }

    public Cotizacion(int id, String titulo, String nombre, Date fecha) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    protected Cotizacion(Parcel in) {
        id = in.readInt();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Cotizacion{" +
                "id=" + id +
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
        parcel.writeInt(id);
        parcel.writeString(titulo);
        parcel.writeString(nombre);
    }
}
