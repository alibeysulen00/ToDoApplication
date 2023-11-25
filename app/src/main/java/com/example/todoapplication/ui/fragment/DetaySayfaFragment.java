package com.example.todoapplication.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoapplication.R;
import com.example.todoapplication.data.entity.CardData;
import com.example.todoapplication.databinding.FragmentDetaySayfaBinding;
import com.example.todoapplication.ui.viewmodel.DetaySayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint

public class DetaySayfaFragment extends Fragment {


    private FragmentDetaySayfaBinding binding;
    private DetaySayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetaySayfaBinding.inflate(inflater, container, false);

        DetaySayfaFragmentArgs bundle = DetaySayfaFragmentArgs.fromBundle(getArguments());
        CardData cardData = bundle.getYapilacak();

        binding.editTextDetay.setText(cardData.getName());

        binding.buttonGuncelle.setOnClickListener(v -> {

            String name = binding.editTextDetay.getText().toString();

            viewModel.guncelle(cardData.getId(),name,cardData.getTarih());


            Navigation.findNavController(v).navigate(R.id.detaydanAnasayfayaGecis);

        });










        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetaySayfaViewModel.class);
    }

}