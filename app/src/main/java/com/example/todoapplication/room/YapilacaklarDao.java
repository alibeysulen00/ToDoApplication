package com.example.todoapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todoapplication.data.entity.CardData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface YapilacaklarDao {

    @Query("SELECT * FROM toDos")
    Single<List<CardData>> yapilacaklariYukle();

    @Insert
    Completable kaydet(CardData cardData);

    @Update
    Completable guncelle(CardData cardData);

    @Delete
    Completable sil(CardData cardData);

    @Query("SELECT * FROM toDos WHERE name LIKE '%' || :aramaKelimesi || '%'")
    Single<List<CardData>> ara(String aramaKelimesi);
}
