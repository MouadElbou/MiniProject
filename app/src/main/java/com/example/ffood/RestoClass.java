package com.example.ffood;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class RestoClass extends ArrayList<Parcelable> implements Parcelable
{
    // variables for our coursename,
    // description, tracks and duration, id.
    private String RestoName;
    private String AdressResto;
    private String EmailResto;
    private String NumeroResto;
    private int RestoID;

    protected RestoClass(Parcel in) {
        RestoName = in.readString();
        AdressResto = in.readString();
        EmailResto = in.readString();
        NumeroResto = in.readString();
        RestoID = in.readInt();
    }

    public static final Creator<RestoClass> CREATOR = new Creator<RestoClass>() {
        @Override
        public RestoClass createFromParcel(Parcel in) {
            return new RestoClass(in);
        }

        @Override
        public RestoClass[] newArray(int size) {
            return new RestoClass[size];
        }
    };

    // creating getter and setter methods
    public String getRestoName() {
        return RestoName;
    }

    public void setRestoName(String restoname) {
        this.RestoName = restoname;
    }

    public String getAdressResto() {
        return AdressResto;
    }

    public void setAdressResto(String adressresto) {
        this.AdressResto = adressresto;
    }

    public String getEmailResto() {
        return EmailResto;
    }

    public void setEmailResto(String emailresto) {
        this.EmailResto = emailresto;
    }

    public String getNumeroResto() {
        return NumeroResto;
    }

    public void setNumeroResto(String numeroresto) {
        this.NumeroResto = numeroresto;
    }

    public int getRestoID() {
        return RestoID;
    }

    public void setRestoID(int restoID) {
        this.RestoID = restoID;
    }

    // constructor
    public RestoClass(String RestoName, String AdressResto, String EmailResto, String NumeroResto) {
        this.RestoName = RestoName;
        this.AdressResto = AdressResto;
        this.EmailResto = EmailResto;
        this.NumeroResto = NumeroResto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(RestoName);
        dest.writeString(AdressResto);
        dest.writeString(EmailResto);
        dest.writeString(NumeroResto);
        dest.writeInt(RestoID);
    }
}
