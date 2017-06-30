package com.mario219.restconsumer.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by marioalejndro on 30/06/17.
 */

public class ProspectSqlModel implements Parcelable {

    private int id;
    private String name, surname;
    private Long identification, telephone;

    public ProspectSqlModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeLong(identification);
        dest.writeLong(telephone);
    }

    protected ProspectSqlModel(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.surname = in.readString();
        this.identification = in.readLong();
        this.telephone = in.readLong();
    }

    public static final Creator<ProspectSqlModel> CREATOR = new Creator<ProspectSqlModel>() {
        @Override
        public ProspectSqlModel createFromParcel(Parcel in) {
            return new ProspectSqlModel(in);
        }

        @Override
        public ProspectSqlModel[] newArray(int size) {
            return new ProspectSqlModel[size];
        }
    };
}
