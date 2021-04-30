package com.android.myvirtualnutritionist.ui.diary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiaryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DiaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is DIARY fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}