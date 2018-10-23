package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Factura implements Parcelable {
    private String nombre, status, id, num;
    private Date fecha;

    public Factura() {
    }

    public Factura(String nombre, String status, String id, String num, Date fecha) {
        this.nombre = nombre;
        this.status = status;
        this.id = id;
        this.num = num;
        this.fecha = fecha;
    }

    protected Factura(Parcel in) {
        nombre = in.readString();
        status = in.readString();
        id = in.readString();
        num = in.readString();
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    @Override
    public String toString() {
        return "Factura{" +
                "nombre='" + nombre + '\'' +
                ", status='" + status + '\'' +
                ", id='" + id + '\'' +
                ", num='" + num + '\'' +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(status);
        parcel.writeString(id);
        parcel.writeString(num);
    }
}
