package com.example.covid19.UI.Activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.covid19.R;
import com.example.covid19.UI.Fragments.AdviceFragment;
import com.example.covid19.UI.Fragments.CheckFragment;
import com.example.covid19.UI.Fragments.EgyptFragment;
import com.example.covid19.UI.Fragments.EmergencyFragment;
import com.example.covid19.UI.Fragments.WorldFragment;
import com.example.covid19.ViewModel.EgyptViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    Layout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,new EgyptFragment()).commit();
        EgyptViewModel egyptViewModel = new ViewModelProvider(this).get(EgyptViewModel.class);
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setItemIconTintList(null);
        navigationView.setOnNavigationItemSelectedListener(listener);
        Toolbar mainToolbar = findViewById(R.id.toolbar);
        LottieAnimationView lottieAnimationView=findViewById(R.id.animation_view);
        lottieAnimationView.enableMergePathsForKitKatAndAbove(true);

        if(egyptViewModel.getIsLoading().getValue()!= null
                && !egyptViewModel.getIsLoading().getValue()){
            egyptViewModel.refresh();
        }

        mainToolbar.setOnMenuItemClickListener(item -> {

            if(item.getItemId() == R.id.about){
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }else if (item.getItemId()==R.id.news_item){
                startActivity(new Intent(MainActivity.this,NewsActivity.class));
            }


            else if(item.getItemId() == R.id.licences){
                startActivity(new Intent(MainActivity.this, LicenceActivity.class));
            }
            return true;
        });


    }


    private BottomNavigationView.OnNavigationItemSelectedListener listener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment=new EgyptFragment();
                    switch (item.getItemId()){
                        case R.id.adviceFragment_item:
                            selectedFragment=new AdviceFragment();
                            break;
                        case R.id.egyptFragment_item:
                            selectedFragment=new EgyptFragment();

                            break;
                        case R.id.worldFragment_item:
                            selectedFragment=new WorldFragment();
                            break;
                        case R.id.emergencyFragment_item:
                            selectedFragment=new EmergencyFragment();
                            break;
                        case R.id.checkFragment_item:
                            selectedFragment=new CheckFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag,selectedFragment).commit();
                    return true;
                }
            };

}
