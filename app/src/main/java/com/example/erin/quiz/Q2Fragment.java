package com.example.erin.quiz;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Erin on 2/18/2016.
 */
public class Q2Fragment extends Fragment {

    static String q1;
    static String q2;

    public static Q2Fragment newInstance(String q1answer) {
        q1 = q1answer;
        Q2Fragment fragment = new Q2Fragment();
        return fragment;
    }

    public Q2Fragment() {
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
        view = inflater.inflate(R.layout.fragment_q2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final boolean q1Correct = checkQ1Answer(q1);

        final Button mc1 = (Button)view.findViewById(R.id.mc1);
        final Button mc2 = (Button)view.findViewById(R.id.mc2);
        final Button mc3 = (Button)view.findViewById(R.id.mc3);

        mc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2 = mc1.getText().toString();
                String response = "Nope";
                if (q1Correct)
                    response = "Maybe";
                displayResults(q1, q2, response);
            }
        });
        //correct answer
        mc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2 = mc2.getText().toString();
                String response = "Maybe";
                if (q1Correct)
                    response = "Yes";
                displayResults(q1, q2, response);
            }
        });
        mc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q2 = mc3.getText().toString();
                String response = "Nope";
                if (q1Correct)
                    response = "Maybe";
                displayResults(q1, q2, response);
            }
        });

    }

    private boolean checkQ1Answer(String guess) {
        if (guess.toLowerCase().equals("cockroach")) {
            return true;
        }
        return false;
    }

    private void displayResults(String q1, String q2, String response) {

        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("Are you an entomologist?")
                .setMessage(response)
                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO start a rematch!
                        getFragmentManager().popBackStack();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO back out the the start screen
                        getActivity().finish();
                    }
                })
                .show();
    }
}
