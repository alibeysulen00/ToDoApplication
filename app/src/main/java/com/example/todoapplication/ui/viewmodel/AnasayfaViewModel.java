package com.example.todoapplication.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todoapplication.data.entity.CardData;
import com.example.todoapplication.data.repo.YapilacaklarRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public YapilacaklarRepo yrepo;
    public MutableLiveData<List<CardData>> yapilacaklarListesi;

    @Inject
    public AnasayfaViewModel(YapilacaklarRepo yrepo) {
        this.yrepo = yrepo;
        yapilacaklariYukle();
        yapilacaklarListesi = yrepo.yapilacaklarListesi;


    }

    public void sil(int id){
        yrepo.sil(id);
    }

    public void ara(String aramaKelimesi){
        yrepo.ara(aramaKelimesi);
    }


    public void yapilacaklariYukle() {
        yrepo.yapilacaklariYukle();
    }


}
