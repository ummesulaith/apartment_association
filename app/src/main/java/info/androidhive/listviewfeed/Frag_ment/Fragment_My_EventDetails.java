package info.androidhive.listviewfeed.Frag_ment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.listviewfeed.R;

/**
 * Created by Chanti on 12/30/2016.
 */

public class Fragment_My_EventDetails extends Fragment{


    public Fragment_My_EventDetails(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_my_event_details, container, false);

        return rootView;

    }

}
