package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {
    String id, nombre, rfc, razonSocial;

    public Cliente(String nombre, String rfc, String razonSocial) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.razonSocial = razonSocial;
    }

    protected Cliente(Parcel in) {
        nombre = in.readString();
        rfc = in.readString();
        razonSocial = in.readString();
    }

    public Cliente(String id, String nombre, String rfc, String razonSocial) {
        this.id = id;
        this.nombre = nombre;
        this.rfc = rfc;
        this.razonSocial = razonSocial;
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Cliente() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(rfc);
        parcel.writeString(razonSocial);
    }
}
