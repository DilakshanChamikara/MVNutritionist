package com.android.myvirtualnutritionist.ui.diary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiaryViewModel extends ViewModel {

    private MutableLiveData<String> caloriesCalc;
    private MutableLiveData<String> caloriesDesc;

    private MutableLiveData<String> breakfastCountItems;
    private MutableLiveData<String> lunchCountItems;
    private MutableLiveData<String> dinnerCountItems;

    public DiaryViewModel() {
        caloriesCalc = new MutableLiveData<>();
        caloriesCalc.setValue("2073  -  0  +  0  =  2073 ");

        caloriesDesc = new MutableLiveData<>();
        caloriesDesc.setValue("\tGoal\t\t\t\t\t\t\t\tFood\t\t\t\t\tExercise\t\t\t\t\tRemaining");

        breakfastCountItems = new MutableLiveData<>();
        breakfastCountItems.setValue("999");

        lunchCountItems = new MutableLiveData<>();
        lunchCountItems.setValue("99");

        dinnerCountItems = new MutableLiveData<>();
        dinnerCountItems.setValue("9");
    }

    public LiveData<String> getCaloriesCalc() {
        return caloriesCalc;
    }

    public LiveData<String> getCaloriesDesc(){
        return caloriesDesc;
    }

    public LiveData<String> getBreakfastCountItems() {
        return breakfastCountItems;
    }

    public LiveData<String> getLunchCountItems() {
        return lunchCountItems;
    }

    public LiveData<String> getDinnerCountItems() {
        return dinnerCountItems;
    }
}