package com.example.android.takeanote;

import io.reactivex.annotations.NonNull;

/**
 * Created by andronicus on 2/5/2018.
 */

class NotePresenter implements NoteContract.Presenter{

    private NoteContract.View mView;
    private NoteRepository mNoteRepository;

    public NotePresenter(@NonNull NoteContract.View view,
                         @NonNull NoteRepository noteRepository) {
        mView = view;
        mNoteRepository = noteRepository;
    }

    public void createNote(Note note) {
        int i = mNoteRepository.createNote(note);

        System.out.println(i);

        if (i > 0){
            mView.displaySuccessMessage();
        }else {
            mView.displayErrorMessage();
        }
    }
}
