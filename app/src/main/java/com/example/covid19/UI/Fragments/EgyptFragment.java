package com.example.covid19.UI.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.covid19.R;
import com.example.covid19.Utils.NetworkUtils;
import com.example.covid19.ViewModel.EgyptViewModel;


public class EgyptFragment extends Fragment {

    EgyptViewModel egyptViewModel;

    public EgyptFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_egypt_fragment,container,false);

        TextView totalCases = view.findViewById(R.id.total_cases_num);
        TextView totalDeaths = view.findViewById(R.id.total_deaths_num);
        TextView todayCases = view.findViewById(R.id.today_cases_num);
        TextView todayDeaths = view.findViewById(R.id.today_death_num);
        TextView recovered = view.findViewById(R.id.recovered_cases_num);
        TextView critical = view.findViewById(R.id.critical_cases_num);
        TextView active = view.findViewById(R.id.active_cases_num);
        TextView casesPerOneMillion = view.findViewById(R.id.cases_per_mil_num);
        TextView deathsPerOneMillion = view.findViewById(R.id.deaths_per_mil_num);

        SwipeRefreshLayout refreshLayout = view.findViewById(R.id.swipe_refresh);

        egyptViewModel = new ViewModelProvider(requireActivity()).get(EgyptViewModel.class);
        egyptViewModel.getEgypt();

        FragmentActivity activity=getActivity();

        egyptViewModel.getEgypt().observe(requireActivity(), country -> {
                    totalCases.setText(String.valueOf(country.getCases()));
                    todayCases.setText(String.valueOf(country.getTodayCases()));
                    totalDeaths.setText(String.valueOf(country.getDeaths()));
                    todayDeaths.setText(String.valueOf(country.getTodayDeaths()));
                    deathsPerOneMillion.setText(String.valueOf(country.getDeathsPerOneMillion()));
                    casesPerOneMillion.setText(String.valueOf(country.getCasesPerOneMillion()));
                    recovered.setText(String.valueOf(country.getRecovered()));
                    active.setText(String.valueOf(country.getActive()));
                    critical.setText(String.valueOf(country.getCritical()));

                }

        );

        egyptViewModel.getIsLoading().observe(requireActivity(), aBoolean -> {
            if (aBoolean) {
                refreshLayout.setRefreshing(true);
            } else {
                refreshLayout.setRefreshing(false);
            }
        });

        egyptViewModel.getIsError().observe(requireActivity(), aBoolean -> {
            if (aBoolean) {
                refreshLayout.setRefreshing(false);
                totalCases.setText("-");
                todayCases.setText("-");
                totalDeaths.setText("-");
                todayDeaths.setText("-");
                deathsPerOneMillion.setText("-");
                casesPerOneMillion.setText("-");
                recovered.setText("-");
                active.setText("-");
                critical.setText("-");

                if (NetworkUtils.getConnectivityStatus(
                        activity) != 0) {

                    Toast.makeText(activity.getApplicationContext(),
                            "Somthing wrong happend", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(activity.getApplicationContext(),
                            "No network connection", Toast.LENGTH_SHORT).show();
                }
                egyptViewModel.reset();
            }
        });

        refreshLayout.setOnRefreshListener(() -> {
            if (NetworkUtils.getConnectivityStatus(
                    activity.getApplicationContext()) != 0) {
                egyptViewModel.refresh();
            } else {
                Toast.makeText(activity.getApplicationContext(),
                        "No network Connection", Toast.LENGTH_SHORT).show();
                refreshLayout.setRefreshing(false);
                egyptViewModel.reset();
            }
        });


        return view;
    }
}
