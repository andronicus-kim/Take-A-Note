package com.example.android.takeanote.appconfig;

import com.example.android.takeanote.data.NoteRepository;
import com.example.android.takeanote.scopes.ApplicationScope;

import dagger.Component;

/**
 * Created by andronicus on 2/6/2018.
 */
@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    NoteRepository exposeRepository();
}
