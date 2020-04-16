package com.fcp.reportebasuras.nuevaspantallas.admin.verificarestadisticas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerificarEstadisticasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VerificarEstadisticasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}