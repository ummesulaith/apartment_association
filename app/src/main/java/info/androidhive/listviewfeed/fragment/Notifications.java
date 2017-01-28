package info.androidhive.listviewfeed.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import info.androidhive.listviewfeed.Frag_ment.Feedback;
import info.androidhive.listviewfeed.Frag_ment.Query;
import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;

/**
 * A simple {@link Fragment} subclass.
 */
public class Notifications extends Fragment {

    public Button b1,b2;


    public Notifications() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_notifications, container, false);
        //btn=(Button)v.findViewById(R.id.btn);

        b1= (Button) v.findViewById(R.id.rd1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Feedback f1 = new Feedback();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("Feedback/Query");
               // Home.title.setText(" Feedback ");
            }
        });

        b2= (Button) v.findViewById(R.id.rd2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Query f2 = new Query();
                fragmentTransaction.replace(R.id.Container, f2);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("Feedback/Query");
               // Home.title.setText(" Feedback ");
            }
        });
        return v;
    }


}
