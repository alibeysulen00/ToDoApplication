package com.example.todoapplication.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.todoapplication.R;
import com.example.todoapplication.databinding.FragmentAnasayfaBinding;
import com.example.todoapplication.ui.adapter.ToDoAdapter;
import com.example.todoapplication.ui.viewmodel.AnasayfaViewModel;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {


    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);




        binding.cardRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        viewModel.yapilacaklarListesi.observe(getViewLifecycleOwner(), yapilacaklarListesi -> {

            ToDoAdapter adapter = new ToDoAdapter(yapilacaklarListesi, requireContext(), viewModel);

            binding.cardRv.setAdapter(adapter);

        });

        binding.fab.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.kayitGecis);
        });







        SearchView searchView = (SearchView) binding.searchView;
        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) searchView.findViewById(id);


        textView.setTextColor(Color.BLACK);

        textView.setHintTextColor(Color.rgb(100, 100, 100));
        textView.setTextSize(14);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { // Klavye üzerindeki arama iconu ile çalışır
                viewModel.ara(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) { // Harf girdikçe veya sildikçe çalışır
                viewModel.ara(newText);
                return true;
            }
        });



        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.yapilacaklariYukle();
    }


}