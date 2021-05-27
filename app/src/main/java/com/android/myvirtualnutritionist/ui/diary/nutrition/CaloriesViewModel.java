package com.android.myvirtualnutritionist.ui.diary.nutrition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CaloriesViewModel extends ViewModel {

    private MutableLiveData<String> totalCalories;
    private MutableLiveData<String> netCalories;
    private MutableLiveData<String> goal;

    public CaloriesViewModel() {
        totalCalories = new MutableLiveData<>();
        totalCalories.setValue("0");

        netCalories = new MutableLiveData<>();
        netCalories.setValue("0");

        goal = new MutableLiveData<>();
        goal.setValue("2070");
    }

    public LiveData<String> getTotalCalories() {
        return totalCalories;
    }

    public LiveData<String> getNetCalories() {
        return netCalories;
    }

    public LiveData<String> getGoal() {
        return goal;
    }
}
