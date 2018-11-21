package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class CuentaBancaria implements Parcelable {
    String banco, nCuenta, clabe;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String banco, String nCuenta, String clabe) {
        this.banco = banco;
        this.nCuenta = nCuenta;
        this.clabe = clabe;
    }

    protected CuentaBancaria(Parcel in) {
        banco = in.readString();
        nCuenta = in.readString();
        clabe = in.readString();
    }

    public static final Creator<CuentaBancaria> CREATOR = new Creator<CuentaBancaria>() {
        @Override
        public CuentaBancaria createFromParcel(Parcel in) {
            return new CuentaBancaria(in);
        }

        @Override
        public CuentaBancaria[] newArray(int size) {
            return new CuentaBancaria[size];
        }
    };

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(banco);
        parcel.writeString(nCuenta);
        parcel.writeString(clabe);
    }
}
