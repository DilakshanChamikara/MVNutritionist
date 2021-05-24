package com.android.myvirtualnutritionist.ui.diary.nutrition;

import android.os.Bundle;

import com.android.myvirtualnutritionist.databinding.ActivityNutritionMainBinding;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.android.myvirtualnutritionist.ui.diary.nutrition.ui.main.SectionsPagerAdapter;


public class NutritionMainActivity extends AppCompatActivity {

    private ActivityNutritionMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNutritionMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabLayout;
        tabs.setupWithViewPager(viewPager);

    }
}