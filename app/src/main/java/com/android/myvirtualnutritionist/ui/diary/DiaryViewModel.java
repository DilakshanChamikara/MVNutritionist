package com.android.myvirtualnutritionist.ui.diary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiaryViewModel extends ViewModel {

    private MutableLiveData<String> caloriesCalc;
    private MutableLiveData<String> caloriesDesc;

    public DiaryViewModel() {
        caloriesCalc = new MutableLiveData<>();
        caloriesCalc.setValue("2073  -  0  +  0  =  2073 ");

        caloriesDesc = new MutableLiveData<>();
        caloriesDesc.setValue("\tGoal\t\t\t\t\t\t\t\tFood\t\t\t\t\tExercise\t\t\t\t\tRemaining");
    }

    public LiveData<String> getCaloriesCalc() {
        return caloriesCalc;
    }

    public LiveData<String> getCaloriesDesc(){
        return caloriesDesc;
    }
}