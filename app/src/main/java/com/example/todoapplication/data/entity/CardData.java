package com.example.todoapplication.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "toDos")
public class CardData implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "tarih")
    @NonNull
    private String tarih;

    public CardData() {
    }

    public CardData(int id, @NonNull String name, @NonNull String tarih) {
        this.id = id;
        this.name = name;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getTarih() {
        return tarih;
    }

    public void setTarih(@NonNull String tarih) {
        this.tarih = tarih;
    }
}
