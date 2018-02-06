package com.example.android.takeanote.createnote;

import com.example.android.takeanote.data.NoteRepository;
import com.example.android.takeanote.scopes.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andronicus on 2/6/2018.
 */
@Module
public class NoteModule {

    private NoteContract.View mView;

    public NoteModule(NoteContract.View view) {
        mView = view;
    }

    @FragmentScope
    @Provides
    NoteContract.View provideNoteView(){
        return mView;
    }
    @FragmentScope
    @Provides
    NoteContract.Presenter providePresenter(NoteContract.View view, NoteRepository repository){
        return new NotePresenter(view,repository);
    }
}
