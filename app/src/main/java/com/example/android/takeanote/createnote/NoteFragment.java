package com.example.android.takeanote.createnote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.takeanote.data.Note;
import com.example.android.takeanote.R;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by andronicus on 2/5/2018.
 */

public class NoteFragment extends Fragment implements NoteContract.View{


    @Inject
    NoteContract.Presenter mPresenter;

    public static NoteFragment newInstance() {

        Bundle args = new Bundle();

        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_fragment,container,false);
        DaggerNoteComponent.builder()
                .noteModule(new NoteModule(this))
                .build()
                .inject(this);
        return view;
    }

    @Override
    public void displaySuccessMessage() {

    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(getActivity(), "Display error message!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayNotes(List<Note> notes) {


    }

    @Override
    public void displayNoNotes() {

    }

    @Override
    public void displayNote(Note note) {

    }

    @Override
    public void displayNoteNotFoundError() {

    }
}
