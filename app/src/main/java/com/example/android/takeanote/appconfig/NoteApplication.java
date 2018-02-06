package com.example.android.takeanote.appconfig;

import android.app.Application;

/**
 * Created by andronicus on 2/6/2018.
 */

public class NoteApplication extends Application {

    static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    public static ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }
}
