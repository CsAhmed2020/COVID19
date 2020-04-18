package com.example.covid19.UI.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid19.Adapter.WorldAdapter;
import com.example.covid19.R;
import com.example.covid19.Utils.NetworkUtils;
import com.example.covid19.ViewModel.WorldViewModel;

public class WorldFragment extends Fragment {

    WorldViewModel worldViewModel;
    RecyclerView recyclerView;

    public WorldFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_world_fragment,container,false);
        SwipeRefreshLayout refreshLayout=view.findViewById(R.id.swipe_refresh_world);
        TextView total_cases=view.findViewById(R.id.world_total_cases_num);
        TextView total_deaths=view.findViewById(R.id.world_total_deaths_num);
        TextView total_recovered=view.findViewById(R.id.world_total_recovered_num);

        FragmentActivity fragmentActivity=getActivity();
        recyclerView=view.findViewById(R.id.world_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        WorldAdapter adapter=new WorldAdapter();
        recyclerView.setSaveEnabled(true);
        recyclerView.setAdapter(adapter);

        worldViewModel=new ViewModelProvider(requireActivity()).get(WorldViewModel.class);
        worldViewModel.getAllCases();
        worldViewModel.getCountries();

        worldViewModel.getCountries().observe(requireActivity(),countries -> {
            adapter.setCountriesList(countries);
            recyclerView.setVisibility(View.VISIBLE);
        });

        worldViewModel.getIsFirstLoading().observe(requireActivity(),aBoolean -> {
            if (aBoolean){
                refreshLayout.setRefreshing(false);
                recyclerView.setVisibility(View.GONE);
            }
        });

        worldViewModel.getAllCases().observe(requireActivity(),allCases -> {
            total_cases.setText(String.valueOf(allCases.getCases()));
            total_deaths.setText(String.valueOf(allCases.getDeaths()));
            total_recovered.setText(String.valueOf(allCases.getRecovered()));
        });

        worldViewModel.getIsLoading().observe(requireActivity(),aBoolean -> {
            if (aBoolean){
                if (worldViewModel.getIsFirstLoading().getValue()!=null && !worldViewModel.getIsFirstLoading().getValue()){
                    refreshLayout.setRefreshing(true);
                }
            }else {
                refreshLayout.setRefreshing(false);
            }
        });

        worldViewModel.getIsError().observe(requireActivity(),aBoolean -> {
            if (aBoolean){
                refreshLayout.setRefreshing(false);
                total_cases.setText("-");
                total_deaths.setText("-");
                total_recovered.setText("-");

                if (NetworkUtils.getConnectivityStatus(fragmentActivity)!=0){
                    //recyclerView.setVisibility(View.GONE);
                    Toast.makeText(fragmentActivity.getApplicationContext(),"Wrong happend",Toast.LENGTH_LONG).show();

                }else {
                    recyclerView.setVisibility(View.GONE);
                    Toast.makeText(fragmentActivity.getApplicationContext(),"No network connection",Toast.LENGTH_LONG).show();

                }
            }
        });

        refreshLayout.setOnRefreshListener(()->{
            if (NetworkUtils.getConnectivityStatus(fragmentActivity.getApplicationContext())!=0){
                worldViewModel.refresh();
            }else {
                Toast.makeText(requireActivity().getApplicationContext(),"No Network connection",Toast.LENGTH_LONG).show();
                refreshLayout.setRefreshing(false);
            }
        });

        return view;
    }
    }

