package com.example.movieapp.presenter;

import android.content.Context;

import com.example.movieapp.appclass.Result;
import com.example.movieapp.model.api.interface_mainactivity_model_presenter;
import com.example.movieapp.model.api.mainactivitymodel;

import java.util.List;

public class mainactivity_presenter implements interface_mainactivity_model_presenter {

    public static final String TAG = "mainactivity_presenter";
    private Context mcontext;
    private mainactivitymodel mainactivitymodelx;
    private main_presenter_interface mainPresenterInterfacex;
    private interface_mainactivity_model_presenter model_presenter;

    public mainactivity_presenter(Context mcontext,int x) {
        mainPresenterInterfacex = (main_presenter_interface) mcontext;
    }

    public mainactivity_presenter(Context mcontext) {
        this.mcontext = mcontext;
        mainactivitymodelx = new mainactivitymodel(mcontext);
        call_model();
        mainPresenterInterfacex = (main_presenter_interface) mcontext;
    }

    public void call_model() {
        mainactivitymodelx.do_retrofit();
    }

    @Override
    public void getmovies_from_model(List<Result> movies) {
        mainPresenterInterfacex.back_data(movies);
    }

}
