package info.androidhive.listviewfeed.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import info.androidhive.listviewfeed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_MyNotifications extends Fragment {

 Button bttn;
    public Fragment_MyNotifications() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vr= inflater.inflate(R.layout.fragment_fragment__my_notifications, container, false);
       // bttn=(Button)vr.findViewById(R.id.bttn);
        return vr;
    }

}
