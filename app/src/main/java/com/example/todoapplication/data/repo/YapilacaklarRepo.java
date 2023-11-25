package com.example.todoapplication.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.todoapplication.data.entity.CardData;
import com.example.todoapplication.room.YapilacaklarDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class YapilacaklarRepo {
    public MutableLiveData<List<CardData>> yapilacaklarListesi = new MutableLiveData<>();

    private YapilacaklarDao ydao;

    public YapilacaklarRepo(YapilacaklarDao ydao) {
        this.ydao = ydao;
    }

    public void sil(int id){
        CardData cardData = new CardData(id,"","");
        ydao.sil(cardData).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        yapilacaklariYukle();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }



    public void kaydet(String name, String tarih){
        CardData cardData = new CardData(0,name,tarih);
        ydao.kaydet(cardData).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

                yapilacaklariYukle();

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public void guncelle(int id, String name, String tarih){
        CardData cardData = new CardData(id,name,tarih);
        ydao.guncelle(cardData).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {


            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public void ara(String aramaKelimesi) {
        ydao.ara(aramaKelimesi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<CardData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // Gerekirse disposable'ı ele alın
                    }

                    @Override
                    public void onSuccess(List<CardData> kisilers) {
                        yapilacaklarListesi.setValue(kisilers);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Gerekirse hata ile başa çıkın
                    }
                });
    }




    public void yapilacaklariYukle() {
        ydao.yapilacaklariYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<CardData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<CardData> cardData) {

                        yapilacaklarListesi.setValue(cardData);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }



}
