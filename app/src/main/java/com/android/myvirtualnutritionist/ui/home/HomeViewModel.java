package com.android.myvirtualnutritionist.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> caloriesDesc;

    public HomeViewModel() {
        caloriesDesc = new MutableLiveData<>();
        caloriesDesc.setValue("Calories/day");
    }

    public LiveData<String> getCaloriesDesc(){
        return caloriesDesc;
    }

}