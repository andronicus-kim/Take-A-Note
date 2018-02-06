package com.example.android.takeanote.appconfig;

import android.content.Context;

import com.example.android.takeanote.data.NoteRepository;
import com.example.android.takeanote.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andronicus on 2/6/2018.
 */
@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @ApplicationScope
    @Provides
    Context provideApplicationContext(){
        return mContext;
    }

    @ApplicationScope
    @Provides
    NoteRepository provideRepository(){
        return new NoteRepository();
    }
}
