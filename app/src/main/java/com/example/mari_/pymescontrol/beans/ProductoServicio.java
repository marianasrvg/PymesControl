package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductoServicio implements Parcelable {
    String id, codigo, descripcion;
    Double precio;

    public ProductoServicio(String id, String codigo, String descripcion, Double precio) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    protected ProductoServicio(Parcel in) {
        id = in.readString();
        codigo = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0) {
            precio = null;
        } else {
            precio = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(codigo);
        dest.writeString(descripcion);
        if (precio == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(precio);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductoServicio> CREATOR = new Creator<ProductoServicio>() {
        @Override
        public ProductoServicio createFromParcel(Parcel in) {
            return new ProductoServicio(in);
        }

        @Override
        public ProductoServicio[] newArray(int size) {
            return new ProductoServicio[size];
        }
    };

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoServicio{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
