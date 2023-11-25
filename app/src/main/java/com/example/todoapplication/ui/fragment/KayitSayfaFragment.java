package com.example.todoapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.text.SimpleDateFormat;

import com.example.todoapplication.R;
import com.example.todoapplication.databinding.FragmentKayitSayfaBinding;
import com.example.todoapplication.ui.viewmodel.KayitSayfaViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.util.Locale;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint

public class KayitSayfaFragment extends Fragment {

    private FragmentKayitSayfaBinding binding;
    private KayitSayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKayitSayfaBinding.inflate(inflater, container, false);




        binding.buttonKaydet.setOnClickListener(v ->{

            String name = binding.nameId.getText().toString();
            String tarih = binding.editTextTarih.getText().toString();
            viewModel.kaydet(name,tarih);



            Navigation.findNavController(v).navigate(R.id.kayittanAnasayfayaGecis);
        });

        binding.chipTarih.setOnClickListener(v -> {

            MaterialDatePicker dp = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Tarih Seç")
                    .build();

            dp.show(getParentFragmentManager(),"DATE_PICKER");

            dp.addOnPositiveButtonClickListener(v2 -> {
                SimpleDateFormat df = new SimpleDateFormat("dd/MMMM/yyyy", Locale.getDefault());
                String tarih = df.format(v2);
                binding.editTextTarih.setText(tarih);
            });

        });





        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KayitSayfaViewModel.class);
    }

}