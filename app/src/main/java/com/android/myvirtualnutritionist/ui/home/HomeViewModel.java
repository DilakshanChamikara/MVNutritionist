package com.android.myvirtualnutritionist.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> caloriesDesc;

    public HomeViewModel() {
        caloriesDesc = new MutableLiveData<>();
        caloriesDesc.setValue("Daily Calories Need\t\t\t\t\t\t\t\t\tDaily Calorie Goal");
    }

    public LiveData<String> getCaloriesDesc(){
        return caloriesDesc;
    }

}