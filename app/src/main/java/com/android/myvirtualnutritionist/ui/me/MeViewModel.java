package com.android.myvirtualnutritionist.ui.me;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.myvirtualnutritionist.R;

public class MeViewModel extends ViewModel {

    private MutableLiveData<Integer> meProfilePic;

    public MeViewModel() {
        meProfilePic = new MutableLiveData<>();
        meProfilePic.setValue(R.drawable.profilepic);

    }

    public LiveData<Integer> getMeProfilePic() {
        return meProfilePic;
    }

}