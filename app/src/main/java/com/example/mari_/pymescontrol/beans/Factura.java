package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Factura implements Parcelable {
    private String id, serie, folio, nombre, status, rfc;
    private Date fecha;

    public Factura() {
    }

    public Factura(String id, String serie, String folio, String nombre, String status, String rfc, Date fecha) {
        this.id = id;
        this.serie = serie;
        this.folio = folio;
        this.nombre = nombre;
        this.status = status;
        this.rfc = rfc;
        this.fecha = fecha;
    }

    protected Factura(Parcel in) {
        id = in.readString();
        serie = in.readString();
        folio = in.readString();
        nombre = in.readString();
        status = in.readString();
        rfc = in.readString();
    }

    public static final Creator<Factura> CREATOR = new Creator<Factura>() {
        @Override
        public Factura createFromParcel(Parcel in) {
            return new Factura(in);
        }

        @Override
        public Factura[] newArray(int size) {
            return new Factura[size];
        }
    };

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String num) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", serie='" + serie + '\'' +
                ", folio='" + folio + '\'' +
                ", status='" + status + '\'' +
                ", rfc='" + rfc + '\'' +
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
        parcel.writeString(serie);
        parcel.writeString(folio);
        parcel.writeString(nombre);
        parcel.writeString(status);
        parcel.writeString(rfc);
    }
}
