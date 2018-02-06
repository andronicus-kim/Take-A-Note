package com.example.android.takeanote.createnote;

import com.example.android.takeanote.data.Note;
import com.example.android.takeanote.data.NoteRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by andronicus on 2/5/2018.
 */

public class NotePresenter implements NoteContract.Presenter{

    private NoteContract.View mView;
    private NoteRepository mNoteRepository;

    @Inject
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

    @Override
    public void getNotes() {
        List<Note> notes = mNoteRepository.getNotes();
        System.out.println(notes.size());
        if (notes.size() > 0){
            mView.displayNotes(notes);
        }
        mView.displayNoNotes();
    }

    @Override
    public void getNote(String id) {
        Note note = mNoteRepository.getNote(id);
        if (note != null){
            mView.displayNote(note);
        }else {
            mView.displayNoteNotFoundError();
        }
    }
}
