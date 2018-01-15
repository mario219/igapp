package com.mario219.restconsumer.data.databasemodels;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by mario219 on 6/12/17.
 */

@Entity(tableName = "prospects")
public class ProspectDB {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "first_name")
    private String name;

    @ColumnInfo(name = "surname")
    private String surname;

    @ColumnInfo(name = "identification")
    private Long identification;

    @ColumnInfo(name = "cellphone")
    private Long telephone;

    public ProspectDB(String name, String surname, Long identification, Long telephone) {
        this.name = name;
        this.surname = surname;
        this.identification = identification;
        this.telephone = telephone;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

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

}
