package com.example.android.takeanote.createnote;

import com.example.android.takeanote.data.Note;

import java.util.List;

/**
 * Created by andronicus on 2/5/2018.
 */

public interface NoteContract {

    interface View{

        void displaySuccessMessage();

        void displayErrorMessage();

        void displayNotes(List<Note> notes);

        void displayNoNotes();

        void displayNote(Note note);

        void displayNoteNotFoundError();
    }
    interface Presenter{

        void getNotes();

        void getNote(String id);
    }
}
