package com.example.erin.quiz;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Erin on 2/18/2016.
 */
public class QuizActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, Q1Fragment.newInstance())
                .addToBackStack(null)
                .commit();

    }
}
