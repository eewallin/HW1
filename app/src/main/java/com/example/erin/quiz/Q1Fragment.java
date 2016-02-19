package com.example.erin.quiz;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Erin on 2/18/2016.
 */
public class Q1Fragment extends Fragment {

    public static Q1Fragment newInstance() {
        Q1Fragment fragment = new Q1Fragment();
        return fragment;
    }

    public Q1Fragment() {
        //empty
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_q1, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button proceed = (Button)view.findViewById(R.id.q1button);
        final EditText answer = (EditText)view.findViewById(R.id.q1answer);

                proceed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment_container, Q2Fragment.newInstance(answer.getText().toString()))
                                .addToBackStack(null)
                                .commit();
                    }
                });
    }

    public void saveAndProceed() {

    }
}
