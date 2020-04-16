package com.fcp.reportebasuras.nuevaspantallas.admin.crearusuario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CrearUsuarioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CrearUsuarioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}