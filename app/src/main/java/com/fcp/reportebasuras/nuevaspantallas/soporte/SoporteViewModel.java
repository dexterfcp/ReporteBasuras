package com.fcp.reportebasuras.nuevaspantallas.soporte;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SoporteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SoporteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}