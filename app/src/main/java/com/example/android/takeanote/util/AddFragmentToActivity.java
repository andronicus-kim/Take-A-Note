package com.example.android.takeanote.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import io.reactivex.annotations.NonNull;

/**
 * Created by andronicus on 2/6/2018.
 */

public class AddFragmentToActivity {

    public static void addThisFragment(@NonNull Fragment fragment,
                                       @NonNull FragmentManager manager,
                                       int fragmentId){
        manager.beginTransaction()
                .replace(fragmentId,fragment)
                .commit();
    }
}
