package com.example.todoapplication.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.todoapplication.data.repo.YapilacaklarRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KayitSayfaViewModel extends ViewModel {

    public YapilacaklarRepo yrepo;

    @Inject
    public KayitSayfaViewModel(YapilacaklarRepo yrepo) {
        this.yrepo = yrepo;
    }

    public void kaydet(String name, String tarih){
        yrepo.kaydet(name, tarih);
    }
}
