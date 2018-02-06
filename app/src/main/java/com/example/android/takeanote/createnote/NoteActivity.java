package com.example.android.takeanote.createnote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.takeanote.R;
import com.example.android.takeanote.util.AddFragmentToActivity;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.note_fragment_container);

        if (fragment == null){
            AddFragmentToActivity.addThisFragment(NoteFragment.newInstance(),
                    fragmentManager,
                    R.id.note_fragment_container);
        }
    }
}
