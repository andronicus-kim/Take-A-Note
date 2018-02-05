package com.example.android.takeanote;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
}
