package com.example.todoapplication.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.todoapplication.data.repo.YapilacaklarRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetaySayfaViewModel extends ViewModel {

    public YapilacaklarRepo yrepo;

    @Inject
    public DetaySayfaViewModel(YapilacaklarRepo yrepo) {
        this.yrepo = yrepo;
    }


    public void guncelle(int id, String name, String tarih){
        yrepo.guncelle(id, name, tarih);
    }
}
