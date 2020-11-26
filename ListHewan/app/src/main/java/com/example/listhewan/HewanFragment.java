package com.example.listhewan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listhewan.Data.DataHewan;
import com.example.listhewan.Data.Hewan;

import java.util.ArrayList;

public class HewanFragment extends Fragment {

    private RecyclerView rvHewan;
    private ArrayList<Hewan> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.row_hewan, container, false);
        rvHewan = view.findViewById(R.id.rv_hewan);
        rvHewan.setHasFixedSize(true);

        list.addAll(DataHewan.getListData());

            rvHewan.setLayoutManager(new GridLayoutManager(getContext(), 1));
            HewanAdapter hewanAdapter = new HewanAdapter(list);
            rvHewan.setAdapter(hewanAdapter);

            hewanAdapter.setOnItemClickCallback(new HewanAdapter.OnItemClickCallback() {
                @Override
                public void onItemClicked(Hewan data) {
                    Intent intent = new Intent(getContext(), KeteranganHewanActivity.class);
                    intent.putExtra("name",  data.getNama());
                    intent.putExtra("jenis",  data.getJenis());
                    intent.putExtra("photo",  data.getPhoto());
                    intent.putExtra("keterangan",  data.getKeterangan());
                    startActivity(intent);
                }
            });


        return view;
    }
}
