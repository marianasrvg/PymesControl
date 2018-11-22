package com.example.mari_.pymescontrol.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductoServicio implements Parcelable {
    String title, descrption;
    Double price;

    public ProductoServicio(String title, String descrption, Double price) {
        this.title = title;
        this.descrption = descrption;
        this.price = price;
    }

    protected ProductoServicio(Parcel in) {
        title = in.readString();
        descrption = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(descrption);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductoServicio{" +
                "title='" + title + '\'' +
                ", descrption='" + descrption + '\'' +
                ", price=" + price +
                '}';
    }
}
