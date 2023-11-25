package com.example.todoapplication.di;

import android.content.Context;

import androidx.room.Room;

import com.example.todoapplication.data.repo.YapilacaklarRepo;

import com.example.todoapplication.room.Veritabani;
import com.example.todoapplication.room.YapilacaklarDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public YapilacaklarRepo providerKisilerDaoRepository(YapilacaklarDao ydao){

        return new YapilacaklarRepo(ydao);
    }

    @Provides
    @Singleton
    public YapilacaklarDao provideKisilerDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class,"veritabani.sqlite")
                .createFromAsset("veritabani.sqlite").build();
        return vt.getYapilacaklarDao();
    }

}