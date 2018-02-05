package com.example.android.takeanote;

/**
 * Created by andronicus on 2/5/2018.
 */

public interface NoteContract {

    interface View{

        void displaySuccessMessage();

        void displayErrorMessage();
    }
    interface Presenter{

    }
}
