package com.example.todoapplication.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapplication.R;
import com.example.todoapplication.data.entity.CardData;
import com.example.todoapplication.databinding.YapilacaklarCardBinding;
import com.example.todoapplication.ui.fragment.AnasayfaFragment;
import com.example.todoapplication.ui.fragment.AnasayfaFragmentArgs;
import com.example.todoapplication.ui.fragment.AnasayfaFragmentDirections;
import com.example.todoapplication.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.CardTasarimTutucu>{

    private List<CardData> yapilacaklarListesi;
    private Context mContext;;
    private AnasayfaViewModel viewModel;



    public ToDoAdapter(List<CardData> yapilacaklarListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.yapilacaklarListesi = yapilacaklarListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;

    }



    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private YapilacaklarCardBinding tasarim;

        public CardTasarimTutucu(YapilacaklarCardBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;

        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YapilacaklarCardBinding binding = YapilacaklarCardBinding.inflate(LayoutInflater.from(mContext),parent,false);

        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        CardData yapilacaklar = yapilacaklarListesi.get(position);
        YapilacaklarCardBinding t = holder.tasarim;





        t.textViewTarih.setText(yapilacaklar.getTarih());




        t.cardTitle.setText(yapilacaklar.getName());


        t.anasayfaCard.setOnClickListener(v -> {
            AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(yapilacaklar);

            Navigation.findNavController(v).navigate(gecis);

        });

        t.sil.setOnClickListener(v -> {


            new MaterialAlertDialogBuilder(mContext)
                    .setTitle("Silmek İstiyor musunuz?")
                    .setMessage(yapilacaklar.getName() + " Silinsin mi?")
                    .setPositiveButton("Evet", (d, i) -> {

                        viewModel.sil(yapilacaklar.getId());
                    })
                    .setNegativeButton("Hayır", (d, i) -> {
                        d.dismiss();


                    })

                    .show();
        });


    }

    @Override
    public int getItemCount() {
        return yapilacaklarListesi.size();
    }




}
