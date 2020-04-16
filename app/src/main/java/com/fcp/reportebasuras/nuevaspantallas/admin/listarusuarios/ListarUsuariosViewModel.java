package com.fcp.reportebasuras.nuevaspantallas.admin.listarusuarios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListarUsuariosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListarUsuariosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}