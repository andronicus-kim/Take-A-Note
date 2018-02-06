package com.example.android.takeanote.createnote;

import com.example.android.takeanote.scopes.FragmentScope;

import dagger.Component;

/**
 * Created by andronicus on 2/6/2018.
 */
@FragmentScope
@Component(modules = NoteModule.class)
public interface NoteComponent {

    void inject(NoteContract.View view);
}
