package com.example.android.takeanote;

import com.example.android.takeanote.createnote.NoteContract;
import com.example.android.takeanote.createnote.NotePresenter;
import com.example.android.takeanote.data.Note;
import com.example.android.takeanote.data.NoteRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by andronicus on 2/5/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class NotePresenterTest {

    @Mock
    NoteRepository mNoteRepository;

    @Mock
    NoteContract.View mView;

    NotePresenter mNotePresenter;

    @Mock
    Note mNote;

    @Before
    public void setUp(){
        mNotePresenter = new NotePresenter(mView,mNoteRepository);
    }
    @Test
    public void shouldCreateANote(){
        when(mNoteRepository.createNote(mNote)).thenReturn(1);

        mNotePresenter.createNote(mNote);

        verify(mView).displaySuccessMessage();
    }

    @Test
    public void shouldFailToCreateNote(){
        when(mNoteRepository.createNote(mNote)).thenReturn(0);

        mNotePresenter.createNote(mNote);

        verify(mView).displayErrorMessage();
    }
    @Test
    public void shouldLoadAllNotes(){
        List<Note> notes = Arrays.asList(new Note(),new Note(),new Note());
        when(mNoteRepository.getNotes()).thenReturn(notes);

        mNotePresenter.getNotes();

        verify(mView).displayNotes(notes);
    }
    @Test
    public void shouldHandleNoNotes(){
        when(mNoteRepository.getNotes()).thenReturn(Collections.emptyList());

        mNotePresenter.getNotes();

        verify(mView).displayNoNotes();
    }
    @Test
    public void shouldGetOneNote(){
        String id = "1";
        Note note = new Note();
        when(mNoteRepository.getNote(id)).thenReturn(note);

        mNotePresenter.getNote(id);

        verify(mView).displayNote(note);
    }
    @Test
    public void shouldHandleNoteNotFound(){
        String id = "1";
        when(mNoteRepository.getNote(id)).thenReturn(null);

        mNotePresenter.getNote(id);

        verify(mView).displayNoteNotFoundError();
    }
}
